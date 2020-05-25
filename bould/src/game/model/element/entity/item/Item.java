package game.model.element.entity.item;

import game.model.element.Position;
import game.model.element.entity.Entity;
import game.model.element.entity.ListOfEntities;
import game.model.map.MapElement;

/**
 * This is the class of all items, which are non-enemy objects that are
 * move They contain a position inherited from entity, a Spritechar that
 * represents the item, and state booleans.
 *
 */
public abstract class Item extends Entity
{

	private boolean collectable;
	private boolean moveable;
	private boolean rounded;

	/**
	 * Item Constructor.
	 * 
	 * @param pos
	 * @param collectable
	 * @param moveable
	 * @param rounded
	 */
	public Item(Position pos, boolean collectable, boolean moveable, boolean rounded)
	{
		super(pos);
		this.collectable = collectable;
		this.moveable = moveable;
		this.rounded = rounded;
	}

	/**
	 * Returns whether the object is collectable.
     *
     * @return if the object is collectable
	 */
	public boolean isCollectable()
	{
		return collectable;
	}

	/**
     * Returns whether the object can be moved.
     *
     * @return if the object can be moved
	 */
	public boolean isMoveable()
	{
		return moveable;
	}

	/**
	 * Returns if the object is round. If an object can slide.
     *
     * @return if the object is round
	 */
	public boolean isRounded()
	{
		return rounded;
	}

	@Override
	public void die()
	{
		ListOfEntities.getList().remove(this);
		MapElement.removeElement(this.getPosition());
	}
}
