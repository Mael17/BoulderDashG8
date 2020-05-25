package game.controller.access;

import game.controller.LaunchGame;

/**
 * Access the game.
 *
 */
public class GameAccess
{
	/**
	 *Run the Game main to start playing.
	 */
	public static void launch()
	{
		LaunchGame.runGameThread();
	}
}
