package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Charles on 2/15/2016.
 */
public class Player extends JPanel implements ActionListener,KeyListener {

    Timer t = new Timer(5,this);
    public ImageIcon ship = new ImageIcon("spaceship.png");
    boolean rightPressed=false, leftPressed=false, downPressed=false, upPressed=false;

    private static int SHIPSIZE = 50;
    private static int BOARDWIDE = 600;
    private static int BOARDHIGH = 600;
    private final static int X_LEFTBOUND = 0;
    private final static int X_RIGHTBOUND = BOARDWIDE;
    private final static int Y_UPBOUND = 0;
    private final static int Y_DOWNBOUND = BOARDHIGH;
    private static int velocity = 9;

    int x=X_RIGHTBOUND/2-(SHIPSIZE/2),y=Y_DOWNBOUND/2-(SHIPSIZE/2),velX=0,velY=0;

    public Player() {
        t.start();
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /* Displays .png image of a spaceship, this could be used later to move the ship.png around
         * instead of the drawn blue box
         */
        Graphics2D g2 = (Graphics2D) g;
        ship.paintIcon(this, g2, x, y);
        //Rectangle2D box = new Rectangle2D.Double(x,y,40,40);
        //g2.setPaint(Color.BLUE);
        //g2.fill(box);
        t.start();
    }

//    public void draw(Graphics2D g, Game game){
//        g.drawLine(-10, -8, 10, 0);
//        g.drawLine(-10, 8, 10, 0);
//        g.drawLine(-6, -6, -6, 6);
//    }

    @Override
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
        repaint();
    }

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
        }
        if((code == KeyEvent.VK_UP) && (downPressed == true)){
            velY = 2;
            upPressed = false;
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
