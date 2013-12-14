import javax.swing.*;
import java.awt.*;

/**
 * Created by padawan on 12/11/13.
 */

public class GamePanel extends JPanel {

    private int INIT_WIDTH = 600;
    private int INIT_HEIGHT = 400;

    private GameDraw draw;
    private Image dbImage = null;
    private Graphics2D dbg = null;


    private int panelWidth;
    private int panelHeight;

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

    //todo Grab from jbox2d ;). Really need to understand the exact behavior

    public boolean render() {
        if (dbImage == null) {
//            log.debug("dbImage is null, creating a new one");
            if (panelWidth <= 0 || panelHeight <= 0) {
                return false;
            }
            dbImage = createImage(panelWidth, panelHeight);
            if (dbImage == null) {
//                log.error("dbImage is still null, ignoring render call");
                return false;
            }
            dbg = (Graphics2D) dbImage.getGraphics();
        }
        dbg.setColor(Color.black);
        dbg.fillRect(0, 0, panelWidth, panelHeight);
        return true;
    }


    public void paintScreen() {
        try {
            Graphics g = this.getGraphics();
            if ((g != null) && dbImage != null) {
                g.drawImage(dbImage, 0, 0, null);
                Toolkit.getDefaultToolkit().sync();
                g.dispose();
            }
        } catch (AWTError e) {
//            log.error("Graphics context error", e);
        }
    }


}


