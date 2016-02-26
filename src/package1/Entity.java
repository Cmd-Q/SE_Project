package package1;

import java.awt.Graphics2D;

/**********************************************************************
 * Entity class.  Yet to be implemented.  This will eventually hold
 * most of the logic for the Asteroid and the Player class.
 * Created by Charles on 2/15/2016.
 *********************************************************************/
public abstract class Entity {
    // private static final double DEFAULT_ROTATION = -Math.PI / 2.0;
    // private static final double ROTATION_SPEED = 0.052;
    // private boolean thrustPressed;

    boolean rightPressed = false, leftPressed = false,
            downPressed = false, upPressed = false;

    /* the size of the ship, corresponds to the size of the image*/
    private static int SHIPSIZE = 50;
    /*the left boundary of the baord or x(0)*/
    private static int X_LEFTBOUND = 0;
    /*the right boundary of the board, width of the board x(board)*/
    private static int X_RIGHTBOUND = 600;
    /*the top boundary of the baord or y(0)*/
    private static int Y_UPBOUND = 0;
    /*the bottom of the board or y(boardhigh)*/
    private static int Y_DOWNBOUND = 600;
    /*the velocity of the rocket ship*/
    protected static int velocity = 9;
    /*not yet implemented */
    protected static int radius;
    /*not yet implemented */
    protected static int position;

    /* this provides for the starting position of the ship, it makes
    sure that no matter what size ship we have it will always be in
    the middle of the board
    */
    int x = X_RIGHTBOUND / 2 - (SHIPSIZE / 2), y = Y_DOWNBOUND /
            2 - (SHIPSIZE / 2), velX = 0, velY = 0;


    /******************************************************************
     * Default constructor for the entity class
     *****************************************************************/
    public Entity() {

    }

    /******************************************************************
     * Update game hold the logic for wrapping the board, this will
     * soon replace the logic that is found in both
     * @param game
     *****************************************************************/
    public void update(Game game) {
        if (x <= X_LEFTBOUND - SHIPSIZE) {
            x = X_RIGHTBOUND - SHIPSIZE;
        }

        if (x >= X_RIGHTBOUND) {
            x = X_LEFTBOUND;
        }
        if (y <= Y_UPBOUND - SHIPSIZE) {
            y = Y_DOWNBOUND - SHIPSIZE;
        }
        if (y >= Y_DOWNBOUND) {
            y = Y_UPBOUND;
        }
        x += velX;
        y += velY;
    }

    /******************************************************************
     *Will eventually be the logic to see if a collision occured
     * @param entity
     * @return Whether collision occured.
     *****************************************************************/
//    public boolean checkCollision(Entity entity){
//        double radius = entity.getCollisionRadius() +
//        getCollisionRadius();
//        return (position.getDistanceToSquared(entity.position) < radius * radius);
//    }

    /******************************************************************
     * Abstract method to handle collision in Asteroid and Player
     * classes, decides what to do when a collision occured
     *
     * @param game
     * @param other
     *****************************************************************/
    public abstract void handleCollision(Game game, Entity other);

    /******************************************************************
     * Draw function that will work with Asteroid and Player classes
     *
     * @param g
     * @param game
     ******************************************************************/
    public abstract void draw(Graphics2D g, Game game);


    /******************************************************************
     * getters and setters for the instance variables, not yet
     * implemented for this class
     * @return
     *****************************************************************/
    public int getCollisionRadius() {
        return radius;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public static int getSHIPSIZE() {
        return SHIPSIZE;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public static int getxLeftbound() {
        return X_LEFTBOUND;
    }

    public static int getxRightbound() {
        return X_RIGHTBOUND;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getyDownbound() {
        return Y_DOWNBOUND;
    }

    public static int getyUpbound() {
        return Y_UPBOUND;
    }

    public static void setSHIPSIZE(int SHIPSIZE) {
        Entity.SHIPSIZE = SHIPSIZE;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void setVelocity(int velocity) {
        Entity.velocity = velocity;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public static void setxLeftbound(int xLeftbound) {
        X_LEFTBOUND = xLeftbound;
    }

    public static void setxRightbound(int xRightbound) {
        X_RIGHTBOUND = xRightbound;
    }

    public static void setyDownbound(int yDownbound) {
        Y_DOWNBOUND = yDownbound;
    }

    public static void setyUpbound(int yUpbound) {
        Y_UPBOUND = yUpbound;
    }
}