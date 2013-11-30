import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: padawan
 * Date: 11/28/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Board b = new Board();
                b.setVisible(true);
            }
        });

    }
}