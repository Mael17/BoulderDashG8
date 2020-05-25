package game.model.element;

/**
 * Game element. Cell, item or actor.
 * It has a position and an identification character.
 */
public class Element
{
	private ElementTypes type;
	private Position pos;

	/**
	 * Element builder.
	 * 
	 * @param pos
	 */
	public Element(Position pos)
	{
		super();
		this.pos = pos;
	}

	/**
	 * Returns the representation of the element (SpriteChar) of the entity.
     *
     * @return character identification
	 */
	public ElementTypes getElementType()
	{
		return type;
	}

	/**
	 * Sets the representation of the element (SpriteChar) of the entity.
	 * 
	 * @param spritechar
	 */
	public void setElementType(ElementTypes type)
	{
		this.type = type;
	}

	/**
	 * Returns the position object.
     *
     * @return object position,(x,y)
	 */
	public Position getPosition()
	{
		return pos;
	}

	/**
	 * Sets the position object. (x, y)
	 * 
	 * @param pos
	 */
	public void setPosition(Position pos)
	{
		this.pos = pos;
	}
	
	/**
	 * It does a behavior and deletes the element.
	 */
	public void die()
	{
		
	}
	
	///////
	
	/**
	 * Returns if the item is a diamond.
	 * 
	 * @return if the item is a diamond
	 */
	public boolean isDiamond()
	{
		if (this.getElementType() == ElementTypes.Diamond)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns if it is a rock.
     *
     * @return if it's a rock
	 */
	public boolean isRock()
	{
		if (this.getElementType() == ElementTypes.Rock)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns if empty.
     *
     * @return if it is an empty block
	 */
	public boolean isEmpty()
	{
		if (this.getElementType() == ElementTypes.Empty)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @return if the cell is earth
	 */
	public boolean isDirt()
	{
		if (this.getElementType() == ElementTypes.Dirt)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 
	 * @return if the cell is a wall. 
	 */
	public boolean isWall()
	{
		if (this.getElementType() == ElementTypes.Wall)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @return if the cell is titanium 
	 */
	public boolean isTitanium()
	{
		if (this.getElementType() == ElementTypes.Titanium)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 
	 * @return if the cell is the output.
	 */
	public boolean isExit()
	{
		if (this.getElementType() == ElementTypes.ExitOpen
				|| this.getElementType() == ElementTypes.ExitClosed)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Determine if this entity is an actor.
     *
     * @return if this entity is an actor
	 */
	public boolean isActor()
	{
		if (this.getElementType().getKind().equals("Actor"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Determine if this entity is Rockford.
     *
     * @return if this entity is Rockford
	 */
	public boolean isRockford()
	{
		if (this.getElementType() == ElementTypes.Rockford
				|| this.getElementType() == ElementTypes.RockfordUp
				|| this.getElementType() == ElementTypes.RockfordDown
				|| this.getElementType() == ElementTypes.RockfordRight
				|| this.getElementType() == ElementTypes.RockfordLeft)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Determine if this entity is an Item.
     *
     * @return if this entity is an Item
	 */
	public boolean isItem()
	{
		if (this.getElementType().getKind().equals("Item"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
