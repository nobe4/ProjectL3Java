package fr.efrei.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Seb
 * Date: 02/12/13
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class GameFrame extends JFrame {
//    private TestbedSidePanel side;
    private GameModel model;
    private GameController controller;

    public GameFrame(final GameModel argModel, final GamePanel argPanel, GameController.UpdateBehavior behavior) {
        super("JBox2D Game"); // set the title for the frame as it's the only parameters for the parent constructor
        setLayout(new BorderLayout()); // layout without gap btw components

        model = argModel;
        model.setDebugDraw(argPanel.getDebugDraw());
        controller = new GameController(model, argPanel, behavior);
//        side = new GameSidePanel(model, controller);

        add((Component) argPanel, "Center");
//        add(new JScrollPane(side), "East");
        pack(); // set prefered size to the window

        controller.playTest(0);
        controller.start();
    }
}
