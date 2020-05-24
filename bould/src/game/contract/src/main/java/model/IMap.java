package model;

import java.awt.image.BufferedImage;

/**
 * @author Lucien
 * Interface used for the map with all the cjaracteristics it will use
 */
public interface IMap {

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the sprite
     */
    public ISprite getSprite(int x, int y);

    /**
     *
     * @param spriteID the sprite ID
     * @param x the x coordinate
     * @param y the y coordinate
     * @param spritePack the sprites texture pack given
     */
    public void setSprite(int spriteID, int x, int y, BufferedImage spritePack);

    /**
     * @return BufferedImage
     */
    public BufferedImage getImage();

    /**
     * @param image the image chosen
     */
    public void setImage(BufferedImage image);

    /**
     * @return ISprite[][], the sprites array which contains all the sprites
     */
    public ISprite[][] getSprites();

    /**
     * @return int
     */
    public int getWidth();

    /**
     * @return int
     */
    public int getHeight();

    /**
     * getter for the score
     * @return int
     */
    public int getScore();

    /**
     * @param score the score we have
     */
    public void setScore(int score);

    /**
     * getter for the number of diamonds
     * @return int
     */
    public int getNbDiamond();

}
