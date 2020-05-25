package game.model.element.cell;

import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.element.entity.item.Diamond;
import game.model.element.entity.item.Fallable;
import game.model.element.entity.item.Rock;
import game.model.element.entity.item.StatusFallableEnum;
import game.model.map.MapElement;

/**
 *Class that represents the wall and magic wall.
 * The magic timer is the time of the magic wall before
 * to deactivate.
 */
public class Wall extends Cell
{
	private int magicTimer;

	/**
	 * Wall Construtor
	 * 
	 * @param pos
	 */
	public Wall(Position pos)
	{
		super(pos);
		this.magicTimer = 0;
		this.setElementType(ElementTypes.Wall);
	}

	/**
	 * Constructor of the wall for magic walls.
	 * 
	 * @param pos
	 * @param magicTime
	 */
	public Wall(Position pos, int magicTime)
	{
		super(pos);
		this.magicTimer = magicTime;
		this.setElementType(ElementTypes.Wall);
	}

	/**
	 *Returns the time of the magic wall.
     *
     * @return time of the magic wall
     */ 
	public int getMagicTimer()
	{
		return magicTimer;
	}

	/**
	 * Convert from rocks to diamonds.
	 * 
	 * @param stone
	 */
	public void conversion(Rock stone)
	{
		if (canConvert(stone))
		{

			this.setElementType(ElementTypes.WallMagic);
			rockToDiamond(stone);
			this.magicTimer--;
		}
		else
		{
			this.setElementType(ElementTypes.Wall);
		}

	}

	/**
	 * 
	 * Convert from diamonds to rocks.
	 * 
	 * @param diamond
	 */
	public void conversion(Diamond diamond)
	{
		if (canConvert(diamond))
		{
			this.setElementType(ElementTypes.WallMagic);
			diamondToRock(diamond);
			this.magicTimer--;
		}
		else
		{
			this.setElementType(ElementTypes.Wall);
		}

	}



	//////////////
	
	/**
	 * 
	 * @param fallibleitem
     * @return if the fallableitem can be converted
     */
	private boolean canConvert(Fallable fallableitem)
	{
		return (fallableitem.getPosition().getY() == this.getPosition().checkUp()) && (fallableitem.getState() == StatusFallableEnum.FALLING) && this.magicTimer > 0;
	}
	
	/**
	 * Transform rock to diamond
	 * @param stone
	 */
	private void rockToDiamond(Rock stone)
	{
		stone.die();
		Position diamondPos = new Position(this.getPosition().getX(), this.getPosition().checkDown());
		Diamond diamond = new Diamond(diamondPos, StatusFallableEnum.FALLINGOFF);
		MapElement.setItem(diamond);
	}
	
	/**
	 * Transform  diamond to rock.
	 * @param diamond
	 */
	private void diamondToRock(Diamond diamond)
	{
		diamond.die();
		Position rockPos = new Position(this.getPosition().getX(), this.getPosition().checkDown());
		Rock rock = new Rock(rockPos, StatusFallableEnum.FALLINGOFF);
		MapElement.setItem(rock);
	}
}
