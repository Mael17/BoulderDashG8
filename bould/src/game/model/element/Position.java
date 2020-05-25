package game.model.element;

/**
 *This class has the x and y coordinates of a certain object.
 * return the surrounding positions and make increments / decrements
 * to simulate movement.
 */
public class Position
{
	private Integer X;
	private Integer Y;

	/**
	 * Constructor position.
	 * 
	 * @param x
	 * @param y
	 */
	public Position(int x, int y)
	{
		super();
		this.X = x;
		this.Y = y;
	}

	/**
	 * Returns coordinate X.
	 * 
	 * @return posx
	 */
	public Integer getX()
	{
		return X;
	}

	/**
	 * Returns coordinate Y.
	 * 
	 * @return posy
	 */
	public Integer getY()
	{
		return Y;
	}

	/**
	 * Set the positions X y Y.
	 * 
	 * @param posX
	 * @param posY
	 */
	public void setXY(int posX, int posY)
	{
		this.X = posX;
		this.Y = posY;
	}

	/**
	 * Increment Y, used to scroll down the map.
     */
	public void goDown()
	{
		this.Y++;
	}

	/**
	 *Decrements Y, used to move up the map. 
	 */
	public void goUp()
	{
		this.Y--;
	}

	/**
	 * Decrements X, used to move left on the map.
	 */
	public void goLeft()
	{
		this.X--;
	}

	/**
	 * 
	 * Increase X, used to move right on the map.
	 */
	public void goRight()
	{
		this.X++;
	}

	/**
	 * Returns what position is below the current position 
	 * 
	 * @return the y-coordinate of the object
	 */
	public Integer checkDown()
	{
		// array bound
		return this.Y + 1;
	}

	/**
	 * Returns which position is above the current position
     *
     * @return the coordinate and above the object
	 */
	public Integer checkUp()
	{
		return this.Y - 1;
	}

	/**
	 * Returns which position is to the left of the current position
     *
     * @return the x coordinate to the left of the object
     *
	 */
	public Integer checkLeft()
	{
		return this.X - 1;
	}

	/**
	 * Returns which position is to the right of the current position
     *
     * @return the x coordinate to the right of the object
     */
	
	public Integer checkRight()
	{
		return this.X + 1;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (X == null)
		{
			if (other.X != null)
				return false;
		}
		else if (!X.equals(other.X))
			return false;
		if (Y == null)
		{
			if (other.Y != null)
				return false;
		}
		else if (!Y.equals(other.Y))
			return false;
		return true;
	}

}
