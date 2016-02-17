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
    protected double x = 0,y = 0,velX = 2,velY = 2;
    Timer t = new Timer(5,this);

//    protected int up;
//    protected int down;
//    protected int rotation;
//    private int animation;

    public Player() {
        t.start();
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
    }
    public void moveUp(){
        velY = -2.5;
        velX = 0;
    }
    public void moveDown(){
        velY = 2.5;
        velX = 0;
    }
    public void moveLeft(){
        velX = -2.5;
        velY = 0;
    }
    public void moveRight(){
        velX = 2.5;
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
