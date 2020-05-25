package game.controller.access;

import game.controller.input.Keyboard;
import game.model.Direction;
import game.model.element.entity.actor.Rockford;

/**
 * 
 * Model player access.
 *
 */
public class PlayerAccess
{
	/**
	 *It makes the player move smoothly with the keyboard. And update
     * the movement. 
	 */
	public static void updateMove()
	{
		Rockford player = Rockford.getInstance(); // try catch sonido
		if (Keyboard.isUp())
		{
			player.move(Direction.UP);
		}
		if (Keyboard.isDown())
		{
			player.move(Direction.DOWN);
		}
		if (Keyboard.isLeft())
		{
			player.move(Direction.LEFT);
		}
		if (Keyboard.isRight())
		{
			player.move(Direction.RIGHT);
		}
	}

	/**
	 * Reset rockford to its initial values.
	 */
	public static void resetPlayer()
	{
		Rockford.getInstance().reset();
	}

	/**
	 * 
	 * @return returns rockford
	 */
	public static Rockford getPlayer()
	{
		return Rockford.getInstance();
	}

	/**
	 *
	 * @return rockford diamonds
	 */
	public static Integer getDiamonds()
	{
		return Rockford.getInstance().getDiamonds();
	}

	/**
	 * 
	 * @return rockford lives
	 */
	public static Integer getLives()
	{
		return Rockford.getInstance().getLives();
	}

	/**
	 * 
	 * @return rockford score won in the level
	 */
	public static Integer getScore()
	{
		return Rockford.getInstance().getScore();
	}

}
