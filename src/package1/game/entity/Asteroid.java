package package1.game.entity;

import package1.game.Game;

import java.awt.*;

/**
 * Created by tyleranson on 3/16/16.
 */
public class Asteroid{
    
    private int size = 10;

    public Asteroid(int x, int y, int z, int a){

    }



    public void draw(Graphics2D g, Game game) {
        g.drawRect(size,size,size,size); //Draw the Asteroid.
    }
}
