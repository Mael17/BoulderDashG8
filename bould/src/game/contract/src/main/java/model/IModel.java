package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Leonelle
 * interface used by the model
 */
public interface IModel {

    /**
     * @param id the map id
     * @throws SQLException the sql exception
     * @return the map read
     */
    public String readMap(int id) throws SQLException;

    /**
     * @param entity the entity
     */
    public void addEntity(IEntity entity);

    /**
     * @return ArrayList IEntity the arraylist
     */
    public ArrayList<IEntity> getEntities();

    /**
     * @return IMap
     */
    public IMap getMap();

    /**
     * @return model.Map ID
     */
    public int getMapID();

    /**
     * @return IEntity
     */
    public IEntity getPlayer();

    /**
     * @return BufferedImage
     */
    public BufferedImage getSpritePack();
}
