package fr.efrei.game;

import fr.efrei.game.j2d.TestPanelJ2D;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Seb
 * Date: 02/12/13
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class GameMain {
    //Logger
//    private static final Logger log = LoggerFactory.getLogger(GameMain.class);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
//            log.warn("Could not set the look and feel to nimbus.  "
//                    + "Hopefully you're on a mac so the window isn't ugly as crap.");
        }
        GameModel model = new GameModel();
        GamePanel panel = new TestPanelJ2D(model);
        GameList.populateModel(model);
        JFrame game = new GameFrame(model, panel, GameController.UpdateBehavior.UPDATE_CALLED);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
