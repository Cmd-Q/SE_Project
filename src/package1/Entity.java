package package1;

import java.awt.Graphics2D;

/**
 * Created by Charles on 2/15/2016.
 */
public abstract class Entity {
    // private static final double DEFAULT_ROTATION = -Math.PI / 2.0;
    // private static final double ROTATION_SPEED = 0.052;
    // private boolean thrustPressed;

    boolean rightPressed = false, leftPressed = false, downPressed = false, upPressed = false;
    private static int SHIPSIZE = 50;
    private static int BOARDWIDE = 600;
    private static int BOARDHIGH = 600;
    private static int X_LEFTBOUND = 0;
    private static int X_RIGHTBOUND = BOARDWIDE;
    private static int Y_UPBOUND = 0;
    private static int Y_DOWNBOUND = BOARDHIGH;
    protected static int velocity = 9;
    protected static int radius;
    protected static int position;

    int x = X_RIGHTBOUND / 2 - (SHIPSIZE / 2), y = Y_DOWNBOUND / 2 - (SHIPSIZE / 2), velX = 0, velY = 0;

    public Entity() {

    }

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

    /**
     *
     * @param entity
     * @return Whether collision occured.
     */
//    public boolean checkCollision(Entity entity){
//        double radius = entity.getCollisionRadius() + getCollisionRadius();
//        return (position.getDistanceToSquared(entity.position) < radius * radius);
//    }

    /**
     * Abstract method to hadnle collision in Asteroid and Player classes
     *
     * @param game
     * @param other
     */
    public abstract void handleCollision(Game game, Entity other);

    /**
     * Draw function that will work with Asteroid and Player classes
     *
     * @param g
     * @param game
     */
    public abstract void draw(Graphics2D g, Game game);

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

    public static int getBOARDHIGH() {
        return BOARDHIGH;
    }

    public static int getBOARDWIDE() {
        return BOARDWIDE;
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

    public static void setBOARDHIGH(int BOARDHIGH) {
        Entity.BOARDHIGH = BOARDHIGH;
    }

    public static void setBOARDWIDE(int BOARDWIDE) {
        Entity.BOARDWIDE = BOARDWIDE;
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