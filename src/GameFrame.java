import javax.swing.*;
import java.awt.*;

/**
 * Created by padawan on 12/11/13.
 */
public class GameFrame extends JFrame {

    private GameModel model;
    private GameController controller;
    private GamePanel panel;

    public GameFrame() {
        super("This is my Frame !");
        this.setLayout(new BorderLayout());

        model = new GameModel();
        panel = new GamePanel(true);
        controller = new GameController(model, panel); // todo leave the controller for the frame or put it inside the
        // panel/model ?

        this.add((Component) panel);

        this.pack();
    }
}
