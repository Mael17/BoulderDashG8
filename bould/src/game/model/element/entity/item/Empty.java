package game.model.element.entity.item;

import game.model.element.Position;
import game.model.element.ElementTypes;

/**
 * Class that represents an empty item.
 */
public class Empty extends Item
{

	/**
	 * Empty Constructor. 
	 * 
	 * @param pos
	 */
	public Empty(Position pos)
	{
		super(pos, false, false, false);
		this.setElementType(ElementTypes.Empty);
	}

	@Override
	public void changePosition()
	{

	}

	@Override
	public void makeMove()
	{

	}

}
