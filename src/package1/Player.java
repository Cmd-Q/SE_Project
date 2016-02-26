package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**********************************************************************
 * Player class this makes a rocket object and implements the action
 * listener to decide movements.  Parts of this class will eventually
 * be implemented through the Entity class.
 * Created by Charles on 2/15/2016.
 *********************************************************************/
public class Player extends JPanel implements ActionListener,
        KeyListener {

    /*Timer object acts as a refresh rate to repaint and redraw*/
    Timer t = new Timer(5,this);
    /*Icon for the ship*/
    public ImageIcon ship = new ImageIcon("spaceship.png");
    /*Image for the background*/
    public ImageIcon background = new ImageIcon("space_bg.png");
    /*Booleans for the pressing of keyboard buttons*/
    boolean rightPressed=false, leftPressed=false, downPressed=false,
            upPressed=false;
    /*Size of the ship image*/
    private static int SHIPSIZE = 50;
    /*Width of the board*/
    private static int BOARDWIDE = 600;
    /*Height of the board*/
    private static int BOARDHIGH = 600;
    /*Left side of the board*/
    private final static int X_LEFTBOUND = 0;
    /*right side of the board*/
    private final static int X_RIGHTBOUND = BOARDWIDE;
    /*top of the board*/
    private final static int Y_UPBOUND = 0;
    /*bottom of the board*/
    private final static int Y_DOWNBOUND = BOARDHIGH;
    /*speed of the ship*/
    private static int velocity = 9;
    /*unimplemented, will be the angle that the ship travels*/
    private static double currentAngle;

    /*ensures that the ship will start in the middle of the board*/
    int x=X_RIGHTBOUND/2-(SHIPSIZE/2),y=Y_DOWNBOUND/2-(SHIPSIZE/2),
            velX=0,velY=0;

    /******************************************************************
     *  Default constructor for the player class, starts the timer
     *  adds the key listener
     *****************************************************************/
    public Player() {
        t.start();
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
    }

    /******************************************************************
     * paint component method for the drawing and refreshing of the
     * game
     * @param g
     *****************************************************************/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /**************************************************************
         * Displays .png image of a spaceship, this could be used later
         * to move the ship.png around
         * instead of the drawn blue box
         *************************************************************/
        Graphics2D g5 = (Graphics2D) g;
        background.paintIcon(this, g5, 0, 0);
        Graphics2D g2 = (Graphics2D) g;
        ship.paintIcon(this, g2, x, y);
    }
    /******************************************************************
     * Action performed method that will allow the ship to wrap around
     * the board.  Uses the board size and the ship size to determine
     * the edges of the board
     *****************************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        //if the ship is far enough over the left side it sets the
        //ship over to the right side of the board
        if(x <= X_LEFTBOUND - SHIPSIZE){
            x = X_RIGHTBOUND-SHIPSIZE;
        }

        //if the ship is over far enough on the right side of the board
        //it will set the ship over to the left side.
        if(x >= X_RIGHTBOUND){
            x = X_LEFTBOUND;
        }

        //if the ship is over the threshold of the top it will set the
        //ship back to the bottom of the board
        if(y <= Y_UPBOUND - SHIPSIZE) {
            y = Y_DOWNBOUND-SHIPSIZE;
        }

        //if the ship is at the bottom of the board, it will bring it
        //back to the top of the board
        if(y >= Y_DOWNBOUND){
            y = Y_UPBOUND;
        }

        x += velX;
        y += velY;
        repaint();
    }

    /******************************************************************
     * Rotate method, currently unimplemented,
     *****************************************************************/
    public void rotate() {
        //rotate 5 degrees at a time
        currentAngle+=5.0;
        if (currentAngle >= 360.0) {
            currentAngle = 0;
        }
        repaint();
    }

    /******************************************************************
     * keyPressed method determines what keys are being pressed in
     * combination with others to set the rocket ship in a direction.
     * @param e
     *****************************************************************/
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if((code == KeyEvent.VK_UP) && (downPressed == false)){
            velY = -2;
            upPressed = true;
        }
        if((code == KeyEvent.VK_UP) && (downPressed == true)){
            velY = 0;
            upPressed = true;
        }
        if((code == KeyEvent.VK_DOWN) && (upPressed == false)){
            velY = 2;
            downPressed = true;
        }
        if((code == KeyEvent.VK_DOWN) && (upPressed == true)){
            velY = 0;
            downPressed = true;
        }
        if((code == KeyEvent.VK_LEFT) && (rightPressed == false)){
            velX = -2;
            leftPressed = true;
            // ship.paintIcon(this, g2, x, y);
        }
        if((code == KeyEvent.VK_LEFT) && (rightPressed == true)){
            velX = 0;
            leftPressed = true;
        }
        if((code == KeyEvent.VK_RIGHT) && (leftPressed == false)){
            velX = 2;
            rightPressed = true;
        }
        if((code == KeyEvent.VK_RIGHT) && (leftPressed == true)) {
            velX = 0;
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if((code == KeyEvent.VK_UP) && (downPressed == false)){
            velY = 0;
            upPressed = false;
            rotate();
        }
        if((code == KeyEvent.VK_UP) && (downPressed == true)){
            velY = 2;
            upPressed = false;
            rotate();
        }
        if((code == KeyEvent.VK_DOWN) && (upPressed == false)){
            velY = 0;
            downPressed = false;
        }
        if((code == KeyEvent.VK_DOWN) && (upPressed == true)){
            velY = -2;
            downPressed = false;
        }
        if((code == KeyEvent.VK_LEFT) && (rightPressed == false)){
            velX = 0;
            leftPressed = false;
        }
        if((code == KeyEvent.VK_LEFT) && (rightPressed == true)){
            velX = 2;
            leftPressed = false;
        }
        if((code == KeyEvent.VK_RIGHT) && (leftPressed == false)){
            velX = 0;
            rightPressed = false;
        }
        if((code == KeyEvent.VK_RIGHT) && (leftPressed == true)) {
            velX = -2;
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }
}
