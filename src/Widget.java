import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Widget extends JButton implements KeyListener {
    private boolean[] keyPressed = new boolean[]{false, false, false, false};

    public Widget(String text, int x, int y) {
        super(text);
        this.setSize(this.getPreferredSize());
        this.setLocation(x, y);
        this.setOpaque(true);

        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public Widget(String text) {
        this(text, 100, 100);
    }

    void moveBlock() {
        int speed = 10;
        if (keyPressed[0]) {     // UP
            this.setLocation(this.getX(), this.getY() - speed);
        }
        if (keyPressed[1]) {     // DOWN
            this.setLocation(this.getX(), this.getY() + speed);
        }
        if (keyPressed[2]) {     // LEFT
            this.setLocation(this.getX() - speed, this.getY());
        }
        if (keyPressed[3]) {     // RIGHT
            this.setLocation(this.getX() + speed, this.getY());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyPressed[0] = true;
                break;
            case KeyEvent.VK_DOWN:
                keyPressed[1] = true;
                break;
            case KeyEvent.VK_LEFT:
                keyPressed[2] = true;
                break;
            case KeyEvent.VK_RIGHT:
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyPressed[0] = false;
                break;
            case KeyEvent.VK_DOWN:
                keyPressed[1] = false;
                break;
            case KeyEvent.VK_LEFT:
                keyPressed[2] = false;
                break;
            case KeyEvent.VK_RIGHT:
                keyPressed[3] = false;
                break;
            default:
                System.out.println("other key printed");
                break;
        }
    }
}
