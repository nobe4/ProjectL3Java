import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: padawan
 * Date: 11/29/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board extends JFrame {

    public Board() throws HeadlessException {
        super();

        build();
    }

    private void build() {
        setTitle("Window"); //On donne un titre à l'application
        setSize(800,600); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
