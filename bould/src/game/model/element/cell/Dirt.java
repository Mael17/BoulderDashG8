package game.model.element.cell;

import game.model.element.Position;
import game.model.element.ElementTypes;

/**
 * Class of the cell ground and empty (if dirty is false).
 */
public class Dirt extends Cell
{
	private boolean dirty;

	/**
	 * Constructor Earth
	 * 
	 * @param pos
	 */
	public Dirt(Position pos)
	{
		super(pos);
		this.dirty = true;
		this.setElementType(ElementTypes.Dirt);
	}

	/**
	 * 
     * Earth constructor to generate an empty cell with a dirty argument
     * to remove the soil from the cell.
	 * 
	 * @param pos
	 * @param dirty
	 */
	public Dirt(Position pos, boolean dirty)
	{
		super(pos);
		this.dirty = dirty;
		if (!dirty)
		{
			this.setElementType(ElementTypes.Empty);
		}
		else
		{
			this.setElementType(ElementTypes.Dirt);
		}
	}

	/**
	 * 
	 * @return  if there is dirt in the cell 
	 */
	public boolean isDirty()
	{
		return dirty;
	}

	/**
	 * Remove the dirt from the cell.
	 */
	public void removeDirt()
	{
		this.dirty = false;
		this.setElementType(ElementTypes.Empty);
	}

	@Override
	public void die()
	{
		this.removeDirt();
	}
}
