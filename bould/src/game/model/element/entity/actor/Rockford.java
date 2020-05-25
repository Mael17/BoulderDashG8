package game.model.element.entity.actor;

import game.controller.PlaySound;
import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.element.cell.Dirt;
import game.model.element.cell.Exit;
import game.model.element.entity.item.Diamond;
import game.model.element.entity.item.Rock;
import game.model.map.MapElement;
import game.model.map.MapInstance;

/**
 * This class is the one that contains the main character: Rockford Contains his
 * score, your diamonds and if you are pushing or not, in addition to
 * actor properties
 */
public class Rockford extends Actor
{
	private Integer score;
	private Integer lives;
	private Integer diamonds;
	private boolean isPushing;
	private static Rockford player;

	/**
	 * Rockford Constructor  .
	 */
	private Rockford()
	{
		super(new Position(0, 0));
		this.reset();
	}

	/**
	 * Rockford Singleton.
	 * 
	 * @return Rockford
	 */
	public static Rockford getInstance()
	{
		if (player == null)
		{
			player = new Rockford();
		}
		return player;
	}

	/**
	 * Reset Rockford.
	 */
	public void reset()
	{
		this.setElementType(ElementTypes.Rockford);
		this.lives = 3;
		this.score = 0;
		this.diamonds = 0;
		this.isPushing = false;
		this.putPassables();
	}
	
	/**
	 * Returns the score obtained on the current map.
     *
     * @return score obtained on the current map
	 */
	public Integer getScore()
	{
		return score;
	}

	/**
	 * Returns the diamonds obtained on the current map.
     *
     * @return diamonds obtained on the current map
	 */
	public Integer getDiamonds()
	{
		return diamonds;
	}

	/**
	 * Returns the lives of the player.
     *
     * @return the lives of the player
	 */
	public Integer getLives()
	{
		return lives;
	}

	/**
 	 * Returns if Rockford is pushing something.
     *
     * @return if Rockford is pushing something
	 */
	public boolean isPushing()
	{
		return isPushing;
	}

	@Override
	public void die()
	{
		if (state != StatusActorEnum.DEAD)
		{
			this.dying();
		}
		removeEntity(this);
	}
	
	/**
	 * Rockford dies and explodes.
	 */
	private void dying()
	{
		decrementLives();
		saveScore();
		PlaySound.explosion();
		this.explode();
	}

	/**
	 * Remove the land from the game.
	 * 
	 * @param dirt:
	 *            Earth block
	 */
	public void dig(Dirt dirt)
	{
		if (dirt != null && dirt.isDirty())
		{
			this.digging(dirt);
		}
		else
		{
			this.walking();
		}
	}
	
	/**
	 * Rockford cava.
	 */
	private void digging(Dirt dirt)
	{
		PlaySound.dig();
		dirt.removeDirt();
	}
	
	/**
	 * Rockford walks.
	 */
	private void walking()
	{
		PlaySound.step();
	}

	/**
	 * If it is a diamond, collect it.
	 * 
	 * @param diamond:
	 *                Diamond block
	 */
	public void collect(Diamond diamond)
	{
		if (diamond != null && diamond.isCollectable())
		{
			this.collecting(diamond);
		}
	}

	/**
	 * It deals with moving Rockford into the matrix, it also checks if the cell
     * destination is solid to move. Rockford automatically digs the ground.
     *
	 */
	public boolean isInExit()
	{
		Exit door = Exit.getInstance();
		if (playerInExit(door))
		{
			addScore();
			return true;
		}
		else
		{
			return false;
		}
	}



	@Override
	public void changePosition()
	{
		MapElement.removeElement(getPosition());
		this.makeMove();
		MapElement.setActor(this);
	}

	@Override
	public void makeMove()
	{
		switch (state)
		{
			case MOVINGUP:
				makeMoveUp();
				this.setElementType(ElementTypes.RockfordUp);
				break;
			case MOVINGDOWN:
				makeMoveDown();
				this.setElementType(ElementTypes.RockfordDown);
				break;
			case MOVINGRIGHT:
				makeMoveRight();
				this.setElementType(ElementTypes.RockfordRight);
				break;
			case MOVINGLEFT:
				makeMoveLeft();
				this.setElementType(ElementTypes.RockfordLeft);
				break;
			case IDLE:
				this.collect(MapElement.getDiamond(getPosition()));
				this.setElementType(ElementTypes.Rockford);
				break;
			default:
				break;
		}
		state = StatusActorEnum.IDLE;
	}

	@Override
	public void makeMoveUp()
	{
		if (this.canGoUp())
		{
			getPosition().goUp();
			this.dig(MapElement.getDirt(getPosition()));
			this.collect(MapElement.getDiamond(getPosition()));
		}
		else
		{
			this.collect(MapElement.getDiamond(getPosition()));
		}
	}

	@Override
	public void makeMoveDown()
	{
		if (this.canGoDown())
		{
			getPosition().goDown();
			this.dig(MapElement.getDirt(getPosition()));
			this.collect(MapElement.getDiamond(getPosition()));
		}
		else
		{
			this.collect(MapElement.getDiamond(getPosition()));
		}
	}

	@Override
	public void makeMoveRight()
	{
		if (this.canGoRight())
		{
			getPosition().goRight();
			this.dig(MapElement.getDirt(getPosition()));
			this.collect(MapElement.getDiamond(getPosition()));
		}
		else if (itemRightMoveable())
		{
			this.push(MapElement.getRock(getPosition().checkRight(), getPosition().getY()));
		}
		else
		{
			this.collect(MapElement.getDiamond(getPosition()));
		}
	}

	@Override
	public void makeMoveLeft()
	{
		if (this.canGoLeft())
		{
			getPosition().goLeft();
			this.dig(MapElement.getDirt(getPosition()));
			this.collect(MapElement.getDiamond(getPosition()));
		}
		else if (itemLeftMoveable())
		{
			this.push(MapElement.getRock(getPosition().checkLeft(), getPosition().getY()));
		}
		else
		{
			this.collect(MapElement.getDiamond(getPosition()));
		}
	}

	/**
	 * This method makes that if you are pushing a rock, the state is put
     * correspondent
	 * 
	 * @param rock:Rock
	 *            block
	 */
	public void push(Rock rock)
	{
		switch (state)
		{
			case MOVINGRIGHT:
				if (rock != null && rock.isMoveable() && rock.canGoRight())
				{
					this.pushingright(rock);
					this.dig(MapElement.getDirt(getPosition()));
					this.collect(MapElement.getDiamond(getPosition()));
				}
				break;
			case MOVINGLEFT:
				if (rock != null && rock.isMoveable() && rock.canGoLeft())
				{
					this.pushingleft(rock);
					this.dig(MapElement.getDirt(getPosition()));
					this.collect(MapElement.getDiamond(getPosition()));
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void rotate()
	{
		// TODO Auto-generated method stub
		
	}
	
	// SIMPLE METHODS
	
	/**
	 * Puts the Rockford passables.
	 */
	private void putPassables()
	{
		this.getPassable().put(ElementTypes.Empty.hashCode(), ElementTypes.Empty);
		this.getPassable().put(ElementTypes.Dirt.hashCode(), ElementTypes.Dirt);
		this.getPassable().put(ElementTypes.Diamond.hashCode(), ElementTypes.Diamond);
		this.getPassable().put(ElementTypes.ExitOpen.hashCode(), ElementTypes.ExitOpen);
	}
	
	/**
	 * Collect the diamond.
	 */
	private void collecting(Diamond diamond)
	{
		PlaySound.diamond();
		diamonds++;
		diamond.collected();
		if (!Exit.getInstance().isOpen())
		{
			score += MapInstance.getInstance().getDiamondvalue();
		}
		else
		{
			score += MapInstance.getInstance().getDiamondbonus();
		}
	}

	/**
	 * Decrease a rockford life.
	 */
	private void decrementLives()
	{
		state = StatusActorEnum.DEAD;
		if (this.lives > 0)
		{
			this.lives--;
		}
	}
	
	/**
	 *  Save the score, reset the score and rockford diamonds.
	 */
	private void saveScore()
	{
		MapInstance.getInstance().setPlayerscore(score);
		this.score = MapInstance.getInstance().getPlayerscore();
		this.diamonds = 0;
	}
	
	/**
	 *  Save the score and add it, reset the score and rockford diamonds.
	 */
	private void addScore()
	{
		score += 1 + MapInstance.getInstance().getSelectedLevel();
		MapInstance.getInstance().setPlayerscore(score + MapInstance.getInstance().getPlayerscore());
		diamonds = 0;
	}
	
	/**
	 * 
	 * @param door
	 * @return if rockford is at the exit
	 */
	private boolean playerInExit(Exit door)
	{
		return player.getPosition().equals(door.getPosition());
	}
	
	/**
	 * Push the rock to the right.
	 * @param rock
	 */
	private void pushingright(Rock rock)
	{
		PlaySound.push();
		isPushing = true;
		rock.pushed(this);
		isPushing = false;
		getPosition().goRight();
	}
	
	/**
	 * Push the rock to the left.
	 * @param rock
	 */
	private void pushingleft(Rock rock)
	{
		PlaySound.push();
		isPushing = true;
		rock.pushed(this);
		isPushing = false;
		getPosition().goLeft();
	}
	
	/**
	 * 
	 * @return if the right item is a moveable
	 */
	private boolean itemRightMoveable()
	{
		if(MapElement.getItem(getPosition().checkRight(), getPosition().getY()) != null)
		{
			return MapElement.getItem(getPosition().checkRight(), getPosition().getY()).isMoveable();
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @return if the left item is a moveable
	 */
	private boolean itemLeftMoveable()
	{
		if(MapElement.getItem(getPosition().checkLeft(), getPosition().getY()) != null)
		{
			return MapElement.getItem(getPosition().checkLeft(), getPosition().getY()).isMoveable();
		}
		else
		{
			return false;
		}
		
	}

}
