package game.controller.access;

import game.model.element.cell.Exit;
import game.model.element.entity.Entity;
import game.model.element.entity.ListOfEntities;

/**
 * Access the elements of the model.
 *
 */
public class ElementAccess
{

	/**
	 * Return if the entity is in the entity list. (if she is alive)
	 * 
	 * @param ent
	 *            : entity
	 * @return true if he is alive ent
	 */

	public static boolean entityIsAlive(Entity ent)
	{
		return ListOfEntities.getList().contains(ent);
	}

	/**
	 *Open the exit.
	 */
	public static void openExit()
	{
		Exit.getInstance().open();
	}

}
