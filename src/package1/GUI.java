package package1;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by tyleranson on 2/15/16.
 */
public class GUI extends JPanel implements MouseListener {
    private JMenu jMenu;
    private JMenuBar jMenuBar;
    private JMenuItem restart;
    private JMenuItem exit;
    protected MouseListener m;

    public static void main(String args[]) {
        GUI g = new GUI();
    }

    public GUI() {
        Player s = new Player();
        Asteroid a = new Asteroid();
        JFrame gameFrame = new JFrame();
        setupGUI();

        gameFrame.setJMenuBar(jMenuBar);
        gameFrame.add(jMenuBar, BorderLayout.NORTH);
        gameFrame.add(s);
        //gameFrame.add(a);
        gameFrame.setSize(600, 600);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setTitle("ASTROYED!");
    }
    /*
    Add any GUI options to be built in setupGUI (buttons,menus,othe panels)
     */
    public void setupGUI(){
        jMenu = new JMenu("Menu");
        jMenuBar = new JMenuBar();
        restart = new JMenuItem("Restart");
        exit = new JMenuItem("Exit");
        restart.addMouseListener(m);
        exit.addMouseListener(m);

        jMenuBar.add(jMenu);
        jMenu.add(restart);
        jMenu.add(exit);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object userClick = e.getSource();
        if(userClick == restart){
            return;
        }
        if(userClick == exit){
            return;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
