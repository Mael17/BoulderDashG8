package game.model.element.cell;

import game.model.element.Position;
import game.model.element.ElementTypes;

/**
 * Class representing titanium.
 */
public class Titanium extends Cell
{

	/**
	 * Titanium Constructor.
	 * 
	 * @param pos
	 */
	public Titanium(Position pos)
	{
		super(pos);
		this.setElementType(ElementTypes.Titanium);
	}

}
