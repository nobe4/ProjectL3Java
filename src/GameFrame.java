import javax.swing.*;

/**
 * Created by padawan on 12/11/13.
 */
public class GameFrame extends JFrame {

    private GameModel model;
    private GameController controller;
    private GamePanel panel;

    public GameFrame() {
        super("This is my Frame !");

        model = new GameModel();
        panel = new GamePanel();
        controller = new GameController(); // todo leave the controller for the frame or put it inside the panel/model ?

        this.add(panel);
        this.pack();
    }
}
