import javax.swing.*;
import java.awt.*;

/**
 * Created by padawan on 12/11/13.
 */
public class GameFrame extends JFrame {

    private GameModel model;
    private GameController controller;
    private GamePanel panel;

    public GameFrame(boolean debug) {
        super("JBox2d Demo");
        this.setLayout(new BorderLayout());

        model = new GameModel();
        panel = new GamePanel(debug);
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        controller = new GameController(model, panel, debug);

        model.setCurrentLevel(0);

        this.add(panel);

        this.pack();
        controller.start();

    }
}
