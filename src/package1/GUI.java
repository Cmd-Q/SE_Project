package package1;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tyleranson on 2/15/16.
 */
public class GUI extends JPanel implements ActionListener {

    private JMenuBar menuBar;

    private JMenu File;

    private JMenuItem restart;
    private JMenuItem exit;

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

    public static void main(String args[]) {
        GUI g = new GUI();
    }


    /*
    Add any GUI options to be built in setupGUI (buttons,menus,othe panels)
     */
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

    public void actionPerformed(ActionEvent e){
        if(exit == e.getSource()){
            System.exit(0);
        }
    }
}
