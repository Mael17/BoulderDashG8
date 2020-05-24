package model;

/**
 * @author Tristan
 * Interface used by the different sprites in order to get the parameters when we will
 * load the map
 */
public interface ISprite {

    /**
     * @return int
     */
    public int getID();

    /**
     *
     * @return boolean
     */
    public boolean isFallable();

}
