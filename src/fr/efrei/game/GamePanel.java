package fr.efrei.game;

import org.jbox2d.callbacks.DebugDraw;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Seb
 * Date: 02/12/13
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public interface GamePanel {
    /**
     * Adds a key listener
     *
     * @param argListener
     */
    public void addKeyListener(KeyListener argListener);

    /**
     * Adds a mouse listener
     *
     * @param argListener
     */
    public void addMouseListener(MouseListener argListener);

    /**
     * Adds a mouse motion listener
     *
     * @param argListener
     */
    public void addMouseMotionListener(MouseMotionListener argListener);

    public void grabFocus();

    /**
     * Gets the display-specific debug draw
     *
     * @return
     */
    public DebugDraw getDebugDraw();

    /**
     * Renders the world
     *
     * @return if the renderer is ready for drawing
     */
    public boolean render();

    /**
     * Paints the rendered world to the screen
     */
    public void paintScreen();
}
