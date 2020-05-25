package game.model.element.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * List containing living entities.
 */
public class ListOfEntities
{
	private static ListOfEntities singleton;
	private static List<Entity> entityList;

	/**
	 * Builder setting the list to null.
	 */
	private ListOfEntities()
	{
		entityList = null;
	}

	/**
	 * Singleton from the entity list. 
	 * 
	 * @return singleton
	 */
	public static ListOfEntities getInstance()
	{
		if (singleton == null)
		{
			singleton = new ListOfEntities();
		}
		return singleton;
	}

	/**
	 *  start starts the list with an empty list, and sets it as initialized.
	 */
	public static void start()
	{
		entityList = new ArrayList<Entity>();
	}

	/**
	 *Returns the list.
     *
     * @return Returns the list of entities
	 */
	public static List<Entity> getList()
	{
		return entityList;
	}

}
