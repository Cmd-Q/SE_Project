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

    private static int SHIPSIZE = 40;
    private static int BOARDWIDE = 600;
    private static int BOARDHIGH = 600;
    private final static int X_LEFTBOUND = BOARDWIDE-BOARDWIDE;
    private final static int X_RIGHTBOUND = BOARDWIDE;
    private final static int Y_UPBOUND = BOARDHIGH-BOARDHIGH;
    private final static int Y_DOWNBOUND = BOARDHIGH;
    private static int velocity = 2;

    double x=X_RIGHTBOUND/2,y=Y_DOWNBOUND/2-SHIPSIZE,velX=velocity,velY=velocity;

    public Player() {
        t.start();
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
    }
    public void moveUp(){
        velY = -velocity;
        velX = 0;
    }
    public void moveDown(){
        velY = velocity;
        velX = 0;
    }
    public void moveLeft(){
        velX = -velocity;
        velY = 0;
    }
    public void moveRight(){
        velX = velocity;
        velY = 0;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.BLUE);
        Rectangle2D box =  new Rectangle2D.Double(x,y,40,40);
        g2.fill(box);
        t.start();
        /*
        Add what the class will be drawing.
         */
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
        if(code == KeyEvent.VK_UP){
            moveUp();
        }
        if(code == KeyEvent.VK_DOWN){
            moveDown();
        }
        if(code == KeyEvent.VK_LEFT){
            moveLeft();
        }
        if(code == KeyEvent.VK_RIGHT){
            moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
