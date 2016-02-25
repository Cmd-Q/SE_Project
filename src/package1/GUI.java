package package1;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************************************************
 * GUI class for the asteroid sets up the JPanel and JFrame for the
 * asteroid game and calls on player and asteroid to instantiate the
 * new objects.
 * Created by tyleranson on 2/15/16.
 *********************************************************************/
public class GUI extends JPanel implements ActionListener {

    /** menuBar object**/
    private JMenuBar menuBar;

    /** File object for the menuBar*/
    private JMenu File;

    /** restart menuItem **/
    private JMenuItem restart;

    /** exit menu item **/
    private JMenuItem exit;

    /******************************************************************
     * GUI constructor (default)  instantiates a new asteroid and a
     * player
     ******************************************************************/
    public GUI() {
        Player s = new Player();
        Asteroid a = new Asteroid();

        JFrame gameFrame = new JFrame();

        setupGUI();

        gameFrame.setJMenuBar(menuBar);
        gameFrame.add(menuBar, BorderLayout.NORTH);
        gameFrame.add(s);
        //gameFrame.add(a);
        gameFrame.setSize(600, 600);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setTitle("ASTROYED!");

    }

    /******************************************************************
     * main method of the GUI that makes an instance of the GUI
     * @param args
     *****************************************************************/
    public static void main(String args[]) {
        GUI g = new GUI();
    }


    /******************************************************************
    Add any GUI options to be built in setupGUI (buttons,menus,othe panels)
     *****************************************************************/
    public void setupGUI(){
        File = new JMenu("File");
        menuBar = new JMenuBar();
        restart = new JMenuItem("Restart");
        exit = new JMenuItem("Exit");
        restart.addActionListener(this);
        exit.addActionListener(this);

        menuBar.add(File);
        File.add(restart);
        File.add(exit);
    }

    /******************************************************************
     *
     * @param e
     *****************************************************************/
    public void actionPerformed(ActionEvent e){
        if(exit == e.getSource()){
            System.exit(0);
        }
    }
}
