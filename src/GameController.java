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
    }

    public void start()
    {
        if(animating != true)
        {
            animating = true;
            if(animationThread == null)
                animationThread = new Thread(this, "Game");
            animationThread.start();
        }

    }

    public void run() {

        while(animating)
        {
            if(level == null)
            {
                level.init();
            }
            if(panel.render()) {
                update();
                panel.paintScreen();
            }
        }
    }

    private void update()
    {

    }
}
