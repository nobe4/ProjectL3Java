import org.jbox2d.dynamics.World;

/**
 * Created by padawan on 12/11/13.
 */
public class GameController implements Runnable{

    private GameLevel level = null;

    private boolean animating = false;
    private final GamePanel panel;
    private final GameModel model;

    private Thread animationThread;

    public GameController(GameModel model, GamePanel panel) {
        this.panel = panel;
        this.model = model;
        level = model.getLevel();

        GameDebugDraw debugDraw = new GameDebugDraw(this.panel);
        debugDraw.setFlags(0x0001);

        this.model.getLevel().getWorld().setDebugDraw(debugDraw); // clarify add the debug draw to the controller
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
        while(animating)
        {
            if (panel.render()) { //In the example, the function only draw the dark background
                update();   //It makes all the important stuff (see jdoc)
                panel.paintScreen(); //
            }

        }
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
        // Render the new world state (thanks to step function of World class)

        World world = model.getLevel().getWorld();
        world.step(1f / 60f, 8, 3);
        world.drawDebugData();

        // System.out.println(world.getBodyCount());

    }
}
