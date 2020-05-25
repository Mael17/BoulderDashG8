package model;
/**
 * @author Leonelle
 * Interface used by the class player but maybe used by the enemy
 * (not the time to figure it out).
 */

import java.awt.image.BufferedImage;

public interface IEntity {

    /**
     * @return int
     */
    public int getX();

    /**
     * @return int
     */
    public int getY();

    /**
     * @param x the x coordinate
     */
    public void setX(int x);

    /**
     * @param y the y coordinate
     */
    public void setY(int y);

    /**
     * @return boolean
     */
    public boolean getIsAlive();

    /**
     * @param isAlive the fact is the player is alive
     */
    public void setIsAlive(boolean isAlive);

    /**
     * @return boolean
     */
    public boolean isPlayer();

    /**
     * @param map the map
     */
    public void move(IMap map);

    /**
     * @param direction the direction
     */
    public void setDirection(Direction direction);

    /**
     * @return Direction
     */
    public Direction getDirection();

    /**
     * @return BufferedImage
     */
    public BufferedImage getImage();
}
