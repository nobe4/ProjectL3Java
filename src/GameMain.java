import javax.swing.*;

/**
 * Created by padawan on 12/11/13.
 */
public class GameMain {
    public static void main(String[] args) {

        boolean debug = true;

        JFrame frame = new GameFrame(debug);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
