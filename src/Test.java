import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test {

    private Widget block;

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Window"); // JFrame = Window

        // The other bits and pieces that make our program a bit more stable.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        // JFrame is splitted into multiple panes : each panes is like a slice of an onion
        // JPanel is a slice

        Test t = new Test();

        frame.setContentPane(t.createPanel());
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    JPanel createPanel() {
        JPanel root = new JPanel(); // Panel at the top of the window, it will contain the other one
        root.setOpaque(true);
        root.setLayout(null); // disable all layout modification

        root.add(new Widget("coucou",200,200)); // adding block in the root
        root.add(new Widget("coucou")); // adding block in the root


        return root;
    }
}