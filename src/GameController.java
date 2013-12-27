import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

/**
 * Created by padawan on 12/11/13.
 */
public class GameController implements Runnable, KeyListener {

    private GameLevel level = null;

    private boolean animating = false;
    private final GamePanel panel;
    private final GameModel model;

    private Thread animationThread;
    private float frameRate = 0;
    private long startTime;
    private long frameCount;
    private int targetFrameRate;

    private final int INIT_FPS = 60;
    private final LinkedList<QueueItem> inputQueue;


    public GameController(GameModel model, GamePanel panel, boolean debug) {
        inputQueue = new LinkedList<QueueItem>();
        this.panel = panel;
        this.model = model;
        level = model.getLevel();


        setFrameRate(INIT_FPS);

        GameDebugDraw debugDraw = new GameDebugDraw(this.panel);
        debugDraw.appendFlags(0x0001);
        // debugDraw.appendFlags(0x0002);
        // debugDraw.appendFlags(0x0004);
        // debugDraw.appendFlags(0x0008);
        // debugDraw.appendFlags(0x0010);
        // debugDraw.appendFlags(0x0020);

        this.model.getLevel().getWorld().setDebugDraw(debugDraw); // clarify add the debug draw to the controller
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("DETECTED : keyPressed");
        char key = e.getKeyChar();
        int code = e.getKeyCode();
        if (key != KeyEvent.CHAR_UNDEFINED) {
//            model.getKeys()[key] = true;
        }
//        model.getCodedKeys()[code] = true;
        inputQueue.add(new QueueItem(QueueItemType.KeyPressed, key, code));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("DETECTED : keyReleased");
        char key = e.getKeyChar();
        int code = e.getKeyCode();
        if (key != KeyEvent.CHAR_UNDEFINED) {
//            model.getKeys()[key] = false;
        }
//        model.getCodedKeys()[code] = false;
        else
            inputQueue.add(new QueueItem(QueueItemType.KeyReleased, key, code));
    }

    enum QueueItemType {
        MouseDown, MouseMove, MouseUp, ShiftMouseDown, KeyPressed, KeyReleased
    }

    class QueueItem {
        public QueueItemType type;
        public Vec2 p;
        public char c;
        public int code;

        public QueueItem(QueueItemType t, Vec2 pt) {
            type = t;
            p = pt;
        }

        public QueueItem(QueueItemType t, char cr, int cd) {
            type = t;
            c = cr;
            code = cd;
        }
    }


    private void setFrameRate(int fps) {
        if (fps <= 0) {
            throw new IllegalArgumentException("Fps cannot be less than or equal to zero");
        }
        targetFrameRate = fps;
        frameRate = fps;
    }

    /**
     * 1@ First step of the render loop : Initialization
     * - Choose the profile and configure it
     * - Make an animator thread
     * - Load needed resources
     */
    public synchronized void start() {
        if(animating != true)
        {
            frameCount = 0;
            animating = true;
            if(animationThread == null)
                animationThread = new Thread(this, "Game");
            animationThread.start();
        }
    }

    /**
     * Used to stop the render loop. Seems to never be called in the example
     */
    public synchronized void stop() {
        animating = false;
    }

    /**
     * 2@ Render loop
     * Separate in three parts :
     * - Process input
     * - render
     * - Simulate world
     */
    public void run() {
        long beforeTime, afterTime, updateTime, timeDiff, sleepTime, timeSpent;
        float timeInSecs = 0;
        beforeTime = startTime = updateTime = System.nanoTime();

        while(animating)
        {

            if (panel.render()) { //In the example, the function only draw the dark background
                update();   //It makes all the important stuff (see jdoc)
                panel.paintScreen();
            }

        }

        //loop with sleep
      /*  while(animating)
        {
            timeSpent = beforeTime - updateTime;
            if (timeSpent > 0) {
                timeInSecs = timeSpent * 1.0f / 1000000000.0f;
                updateTime = System.nanoTime();
                frameRate = (frameRate * 0.9f) + (1.0f / timeInSecs) * 0.1f;
               // model.setCalculatedFps(frameRate); // only used for printing debug
            } else {
                updateTime = System.nanoTime();
            }

            if (panel.render()) { //In the example, the function only draw the dark background
                update();   //It makes all the important stuff (see jdoc)
                panel.paintScreen();
            }

            frameCount++;

            afterTime = System.nanoTime();

            timeDiff = afterTime - beforeTime;
            sleepTime = (1000000000 / targetFrameRate - timeDiff) / 1000000;

            System.out.println(sleepTime );

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                }
            }

            beforeTime = System.nanoTime();
        }*/
    }


    /**
     * Call a method that update the level/game informations and manage inputs (in the level class)
     * After, it call the "step" function (in the level class), which get the settings and draw everything (also debug
     * informations).
     * <p/>
     * You can find in this function the "world.step()" call, that update the entire world (i.e the game world
     * simulation)
     * There is also a call to world.drawDebugData() that draw all the objects in the world
     * Note : the update function may also update the camera.
     */
    private void update() {
        // todo manage inputs

        // process our input
        if (!inputQueue.isEmpty()) {
            synchronized (inputQueue) {
                while (!inputQueue.isEmpty()) {
                    QueueItem i = inputQueue.pop();
                    switch (i.type) {
                        case KeyPressed:
                            System.out.println("keyPressed");
                            keyPressedPoped(i.c, i.code);
                            break;
                        case KeyReleased:
                            System.out.println("keyReleased");
                            keyReleasedPoped(i.c, i.code);
                            break;
                        case MouseDown:
//                            mouseDown(i.p);
                            break;
                        case MouseMove:
//                            mouseMove(i.p);
                            break;
                        case MouseUp:
//                            mouseUp(i.p);
                            break;
                        case ShiftMouseDown:
//                            shiftMouseDown(i.p);
                            break;
                    }
                }
            }
        }
        // Render the new world state (thanks to step function of World class)

        World world = model.getLevel().getWorld();
        world.step(1f / 60f, 8, 3);

        //set the camera at the new position
        System.out.println("before error");
        System.out.println("coucou :" + level.getHeros());
        System.out.println("Heros position :" + level.getHeros().getPosition());
        System.out.println("Camera position :" + panel.getDraw().getCamera());
        panel.getDraw().setCamera(level.getHeros().getPosition());

        //draw world
        world.drawDebugData();

       // System.out.println(world.getBodyCount());

    }

    private void keyReleasedPoped(char c, int code) {


    }

    private void keyPressedPoped(char c, int code) {
        System.out.println("key pressed");
        switch (c) {
            case 'd':
                System.out.println("move right");
                level.getHeros().move(new Vec2(10, 10));
                break;
            case 'q':
                level.getHeros().move(new Vec2(-10, -10));
                break;

        }

    }
}
