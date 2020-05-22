package game.model.element;


public class Element
{
	private ElementTypes type;
	private Position pos;

	
	public Element(Position pos)
	{
		super();
		this.pos = pos;
	}

	
	public ElementTypes getElementType()
	{
		return type;
	}

	
	public void setElementType(ElementTypes type)
	{
		this.type = type;
	}

	
	public Position getPosition()
	{
		return pos;
	}

	public void setPosition(Position pos)
	{
		this.pos = pos;
	}
	
	
	public void die()
	{
		
	}
	
	
	
	
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
