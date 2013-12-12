import javax.swing.*;
import java.awt.*;

/**
 * Created by padawan on 12/11/13.
 */

public class GamePanel extends JPanel {

    private int INIT_WIDTH = 600;
    private int INIT_HEIGHT = 400;

    private GameDraw draw;

    public GamePanel(boolean debug) {
        this.setBackground(Color.cyan);
        if (debug == true)
            draw = new GameDebugDraw();
        else
            draw = new GameClassicDraw();
        this.updateSize(INIT_WIDTH, INIT_HEIGHT);
        this.setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
    }

    private void updateSize(int width, int height) {
//        draw.getViewportTranform().setExtents(width / 2, height / 2);
    }
}
