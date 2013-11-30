import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test implements KeyListener {

    private enum DIRECTION{UP, DOWN, LEFT, RIGHT;
    }

    private boolean[] keyPressed = {false,false,false,false};
    private JPanel block;


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

    JPanel createPanel(){
        JPanel root = new JPanel(); // Panel at the top of the window, it will contain the other one
        root.setOpaque(true);
        root.setLayout(null); // disable all layout modification

        block = new JPanel();
        block.setSize(100, 100);
        block.setLocation(100, 100);
        block.setBackground(Color.black);
        block.setOpaque(true);

        root.add(block); // adding block in the root

        root.setFocusable(true);
        root.addKeyListener(this);

        return root;
    }

    void moveBlock (){
        if (keyPressed[0]) {     // UP
            block.setLocation(block.getX(), block.getY()-1);
        }
        if (keyPressed[1]) {     // DOWN
            block.setLocation(block.getX(), block.getY()+1);
        }
        if (keyPressed[2]) {     // LEFT
            block.setLocation(block.getX()-1, block.getY());
        }
        if (keyPressed[3]) {     // RIGHT
            block.setLocation(block.getX()+1, block.getY());
        }
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

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.toString());
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                keyPressed[0] = true;
                break;
            case KeyEvent.VK_DOWN :
                keyPressed[1] = true;
                break;
            case KeyEvent.VK_LEFT :
                keyPressed[2] = true;
                break;
            case KeyEvent.VK_RIGHT :
                keyPressed[3] = true;
                break;
            default:
                System.out.println("other key printed");
                break;
        }
        moveBlock();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                keyPressed[0] = false;
                break;
            case KeyEvent.VK_DOWN :
                keyPressed[1] = false;
                break;
            case KeyEvent.VK_LEFT :
                keyPressed[2] = false;
                break;
            case KeyEvent.VK_RIGHT :
                keyPressed[3] = false;
                break;
            default:
                System.out.println("other key printed");
                break;
        }
    }
}