package game.model.element.entity;

import java.util.HashMap;

import game.model.element.Element;
import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.map.MapChar;
import game.model.map.MapElement;

/**
 * Dynamic elements that can be moved. As Actor and Item. It has a hashmap
 * which contains the elements that the entity can pass.
  */
public abstract class Entity extends Element
{
	private HashMap<Integer, ElementTypes> passable = new HashMap<>();

	/**
	 * Generate an entity in a position.
	 * 
	 * @param pos
	 */
	public Entity(Position pos)
	{
		super(pos);
	}

	/**
 	 *Returns the elements that the entity can transfer.
     *
     * @return The hashmap of passable elements
     */ 
	public HashMap<Integer, ElementTypes> getPassable()
	{
		return passable;
	}

	/**
	 *Sets the elements that the entity can transfer. 
	 * @param passable
	 */
	public void setPassable(HashMap<Integer, ElementTypes> passable)
	{
		this.passable = passable;
	}

	/**
	 * Change the position of the entity before making a move.
	 */
	abstract public void changePosition();

	/**
	 *Makes the move of an entity. 
	 */
	abstract public void makeMove();

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
	 *Determine if this entity is Rockford.
     *
     * @return if this entity is Rockford 
	 */
	public boolean isRockford()
	{
		if (this.getElementType() == ElementTypes.Rockford)
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
	
	
	//////////////////// METODOS SIMPLES

	
	
	
	
	
	/**
	* Put the empty cell in passable.
	*/
	public void putEmptyPassable()
	{
		this.getPassable().put(ElementTypes.Empty.hashCode(), ElementTypes.Empty);
	}


     /**
     * Check in the hashmap if the cell below is passable for this
     * entity.
     *
     * @return boolean
     */
	public boolean canGoDown()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().getX(), this.getPosition().checkDown()).hashCode());
	}

	/**
	 *Check in the hashmap if the cell above is passable for this
     * entity. 
	 * 
	 * @return boolean
	 */
	public boolean canGoUp()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().getX(), this.getPosition().checkUp()).hashCode());
	}

	/**
	 * Check in the hashmap if the right cell is passable for this
     * entity.
	 * 
	 * @return boolean
	 */
	public boolean canGoRight()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkRight(), this.getPosition().getY()).hashCode());
	}

	/**
	 * Check in the hashmap if the left cell is passable for this
     * entity.
	 * 
	 * @return boolean
	 */
	public boolean canGoLeft()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkLeft(), this.getPosition().getY()).hashCode());
	}

	/**
	 *Check the hashmap if the bottom left cell is passable for
     * this entity. 
	 * 
	 * @return boolean
	 */
	public boolean canGoDownLeft()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkLeft(), this.getPosition().checkDown()).hashCode());
	}

	/**
	 * Check the hashmap if the bottom left cell is passable for
     * this entity.
	 * 
	 * @return boolean
	 */
	public boolean canGoDownRight()
	{
		return this.getPassable().containsKey(MapChar.getChar(this.getPosition().checkRight(), this.getPosition().checkDown()).hashCode());
	}

	/**
	 *  Check in the MapItem if the item below this entity is round.
	 * @return boolean
	 */
	public boolean itemBelowIsRounded()
	{
		if(MapElement.getItem(this.getPosition().getX(), this.getPosition().checkDown()) != null)
		{
			return MapElement.getItem(this.getPosition().getX(), this.getPosition().checkDown()).isRounded();
		}
		else
		{
			return false;
		}
	}

	/**
	 * Check in the MapItem if the item can fall for one of the two
     * sides.
	 * 
	 * @return boolean
	 */
	public boolean itemCanSlide()
	{
		return this.canGoLeft() && this.canGoDownLeft() || this.canGoRight() && this.canGoDownRight();
	}

	/**
	 * Check on the MapItem if the item below this entity is a magic wall
     * active.
	 * 
	 * @return boolean
	 */
	public boolean itemBelowIsMagic()
	{
		return MapElement.getWall(this.getPosition().getX(), this.getPosition().checkDown()).getMagicTimer() > 0;
	}

	/**
	 *  Check in the MapItem if the item below this entity is a wall.
	 * @return boolean
	 */
	public boolean itemBelowIsWall()
	{
		return MapElement.getWall(this.getPosition().getX(), this.getPosition().checkDown()) != null;
	}
	
	/**
	 *Remove the entity from the map and list. 
	 */
	public void removeEntity(Entity entity)
	{
		ListOfEntities.getList().remove(entity);
		MapElement.removeElement(entity.getPosition());
	}

}
