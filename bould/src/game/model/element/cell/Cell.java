package game.model.element.cell;

import game.model.element.Element;
import game.model.element.Position;
import game.model.map.MapElement;

/**
 *This class contains all objects on the map that do not move or fall.
 */ 
public abstract class Cell extends Element
{

	/**
	 * Constructor from Cell.
     *
	 * @param pos
	 */
	Cell(Position pos)
	{
		super(pos);
	}

	/**
	 * Do a behavior and delete a cell.
	 */
	public void die()
	{
		MapElement.removeElement(this.getPosition());
	}

}
