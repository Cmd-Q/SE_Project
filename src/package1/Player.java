package package1;

import java.awt.*;

/**
 * Created by Charles on 2/15/2016.
 */
public class Player {
    protected int x;

    protected int y;

    protected int rotation;

    private int animation;

    public Player() {

    }

    public void draw(Graphics2D g, Game game){
        g.drawLine(-10, -8, 10, 0);
        g.drawLine(-10, 8, 10, 0);
        g.drawLine(-6, -6, -6, 6);
    }

}
