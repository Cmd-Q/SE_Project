package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**********************************************************************
 * Provides the game logic for an asteroid.
 * Created by Charles on 2/20/2016.
 *********************************************************************/
public class Asteroid extends JPanel implements ActionListener,
        KeyListener {

    Timer t2 = new Timer(10, (ActionListener) this);

    public ImageIcon asteroid = new ImageIcon("asteroid.png");
    public ImageIcon background = new ImageIcon("space_bg.png");

    private static int SHIPSIZE = 40;
    private final static int X_LEFTBOUND = 0;
    private final static int X_RIGHTBOUND = 600;
    private final static int Y_UPBOUND = 0;
    private final static int Y_DOWNBOUND = 600;

    int x=X_RIGHTBOUND/2-(SHIPSIZE/2),y=Y_DOWNBOUND/2-(SHIPSIZE/2);
    private double velX=0,velY=0;

    /******************************************************************
     * Constructor for the asteroid class
     *****************************************************************/
    public Asteroid() {
        t2.start();
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);

    }

    /******************************************************************
     *
     * @param g
     *****************************************************************/
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g5 = (Graphics2D) g;
        background.paintIcon(this, g5, 0 , 0);

        Graphics2D g3 = (Graphics2D) g;
        asteroid.paintIcon(this, g3, x , y);

        moveUp(g3);
        moveLeft(g3);
//        moveUp(g4);
//        moveRight(g4);
        repaint();
    }

    /******************************************************************
     * Method to move up
     * @param g
     *****************************************************************/
    public void moveUp(Graphics2D g){
        velY = -3;

    }

    /******************************************************************
     *Method to move down
     * @param g
     ********************************************/
    public void moveDown(Graphics2D g){
        velY = 2.5;

    }

    /******************************************************************
     *Method to move left
     * @param g
     *****************************************************************/
    public void moveLeft(Graphics2D g){
        velX = -1;

    }

    /******************************************************************
     *Method to move right
     * @param g
     *****************************************************************/
    public void moveRight(Graphics2D g){
        velX = 2.5;

    }





    /******************************************************************
     *Action performed method which provides for the wrapping of the
     * board.
     * @param e
     *****************************************************************/
    public void actionPerformed(ActionEvent e) {
        if(x <= X_LEFTBOUND - SHIPSIZE){
            x = X_RIGHTBOUND-SHIPSIZE;
        }

        if(x >= X_RIGHTBOUND){
            x = X_LEFTBOUND;
        }
        if(y <= Y_UPBOUND - SHIPSIZE) {
            y = Y_DOWNBOUND-SHIPSIZE;
        }
        if(y >= Y_DOWNBOUND){
            y = Y_UPBOUND;
        }
        x += velX;
        y += velY;
//        repaint();
    }


    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
