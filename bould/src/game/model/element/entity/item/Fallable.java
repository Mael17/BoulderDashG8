package game.model.element.entity.item;

import game.model.element.Position;
import game.model.element.entity.ListOfEntities;
import game.model.map.MapElement;

/**
 * Class for falling diamonds and rocks.
 */
public abstract class Fallable extends Item
{
	protected StatusFallableEnum state;

	/**
	 * Fallible Constructor .
	 * 
	 * @param pos
	 * @param collectable
	 * @param moveable
	 * @param rounded
	 * @param solid
	 * @param state
	 */
	public Fallable(Position pos, boolean collectable, boolean moveable, boolean rounded, StatusFallableEnum state)
	{
		super(pos, collectable, moveable, rounded);
		this.state = state;
	}

	/**
	 * Returns the status of the fallible.
	 * 
	 * @return the state of the fallible.
	 */
	public StatusFallableEnum getState()
	{
		return state;
	}

	/**
	 * Sets the state of the fallible.
	 * 
	 * @param state
	 */
	public void setState(StatusFallableEnum state)
	{
		this.state = state;
	}

	@Override
	public void die()
	{
		this.state = StatusFallableEnum.DEAD;
		ListOfEntities.getList().remove(this);
		MapElement.removeElement(this.getPosition());
	}

	@Override
	public void changePosition()
	{
		MapElement.removeElement(this.getPosition());
		this.fall();
		this.makeMove();
		MapElement.setItem(this);
	}

	/**
	 *Change status depending on conditions
     * of the fallible. 
	 */
	public abstract void fall();
	
	// METODOS SIMPLES
	
	/**
	 * Returns if the fallible is still.
	 * @return boolean
	 */
	public boolean isIdle()
	{
		return this.state == StatusFallableEnum.IDLE;
	}
	
	/**
	 * Returns if the fallible is still.
	 * @return boolean
	 */
	public boolean isFalling()
	{
		return this.state == StatusFallableEnum.FALLINGOFF || this.state == StatusFallableEnum.FALLING;
	}
	
//	/**
//	 * Returns if the fallible is sliding.
//	 * @return boolean
//	 */
//	public boolean isSliding()
//	{
//		return this.state == StatusFallableEnum.SLIDINGLEFT || this.state == StatusFallableEnum.SLIDINGRIGHT;
//	}
//	
	
	

}
