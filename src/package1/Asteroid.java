package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.security.Key;

/**
 * Created by Pierce on 2/17/16.
 */
public class Asteroid extends JPanel implements ActionListener {
    private static int ASTEROIDSIZE = 25;
    private static int BOARDWIDE = 600;
    private static int BOARDHIGH = 600;
    private final static int X_LEFTBOUND = 0;
    private final static int X_RIGHTBOUND = BOARDWIDE;
    private final static int Y_UPBOUND = 0;
    private final static int Y_DOWNBOUND = BOARDHIGH;

    int x = X_RIGHTBOUND / 2 - (ASTEROIDSIZE / 2), y = Y_DOWNBOUND / 2 - (ASTEROIDSIZE / 2), velX = 0, velY = 0;

    Timer t = new Timer(5, this);

    public Asteroid() {
        t.start();
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.CYAN);
        Rectangle2D asteroidShape = new Rectangle2D.Double(x, y, ASTEROIDSIZE, ASTEROIDSIZE);
        g2.fill(asteroidShape);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x <= X_LEFTBOUND - ASTEROIDSIZE) {
            x = X_RIGHTBOUND - ASTEROIDSIZE;
        }
        if (x >= X_RIGHTBOUND) {
            x = X_LEFTBOUND;
        }
        if (y <= Y_UPBOUND - ASTEROIDSIZE) {
            y = Y_DOWNBOUND - ASTEROIDSIZE;
        }
        if (y >= Y_DOWNBOUND) {
            y = Y_UPBOUND;
        }
        x += velX;
        y += velY;
        repaint();
    }
}

