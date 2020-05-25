package game.controller;

import java.util.Timer;
import java.util.TimerTask;

import game.controller.access.ElementAccess;
import game.controller.access.MapAccess;
import game.controller.access.PlayerAccess;
import game.model.map.MapInstance;
import game.view.FrameEnd;
import game.view.FrameMap;
import game.view.sound.Sound;

/**
 *Game thread. 
 */
public class GameThread extends TimerTask
{
	private int turn = 0;
	private Timer timer;
	private boolean stop = false;

	boolean lost = false;
	boolean won = false;
	// Rockford player = PlayerAccess.getPlayer();

	/**
	 * Constructor, timer the thread.
	 * 
	 * @param timer
	 */
	public GameThread(Timer timer)
	{
		this.timer = timer;
	}

	/** Loop execution.
     * <p>
     * 1. Increase a turn and remove the elements from the panel.
     * <p>
     * 2. Refresh the game every turn.
     * <p>
     * 3. Lose if you have no more lives, win if you reach the exit.
     * <p>
     * 4. Each turn checks if the player won or lost, does something in each
     * case.
     * <p>
     * 5. When he loses, the game stops, he executes the score entry frame
     * and end the timer.
     * <p>
	 * 
	 */
	public void run()
	{
		nextTurn();
		if (!stop)
		{
			doGameTurn();
		}
		else
		{
			doLastTurn();
		}
	}

	/**
	 * It takes a turn of the game.
	 */
	private void doGameTurn()
	{
		if (!lost && !won)
		{
			refreshMapAndFrame();
			
			checkPlayerCondition();
			ElementAccess.openExit();
			System.out.println(turn);
		}
		else if (lost)
		{
			Sound.lost();
			refreshMapAndFrame();

			if (playerHasLost())
			{
				stop = true;
			}

			MapInstance.getInstance().levelRestart();
			lost = false;
		}
		else if (won)
		{
			Sound.won();
			refreshMapAndFrame();

			won = false;
			if (playerNotInLevel())
			{
				stop = true;
			}

			nextLevel();
			MapInstance.getInstance().levelRestart();
		}
	}
	
	/**
	 *Does the last turn. 
	 */
	private void doLastTurn()
	{
		Integer time = turn;

		startEnterScore(time);
		disposeFrameMap();

		timer.cancel();
	}

	/**
	 * Check the player's condition. If he died, he has no time left,
     * lost their lives or is on the way out doing something.
	 */
	private void checkPlayerCondition()
	{
		if (playerExists() && PlayerAccess.getPlayer().isInExit())
		{
			won = true;
		}
		if (playerIsDead())
		{
			MapInstance.getInstance().levelRestart();
		}
		if (playerHasLost())
		{
			lost = true;
		}
		if (runOutOfTime())
		{
			PlayerAccess.getPlayer().die();
		}
	}

	/**
	 * Drill or framemap.
	 */
	private void disposeFrameMap()
	{
		FrameMap.getInstance().setVisible(false);
		FrameMap.disposeFrame();
	}

	/**
	 * Makes the frame appear to enter the score.
	 * @param time
	 */
	private void startEnterScore(Integer time)
	{
		FrameEnd.getInstance();
		FrameEnd.setTime(time);
		FrameEnd.runFrameEnd(null);
	}

	/**
	 *set the next level
	 */
	private void nextLevel()
	{
		MapInstance.getInstance().setSelectedLevel(MapInstance.getInstance().getSelectedLevel() + 1);
	}

	/**
	 * 
	 * @return if it is not in the level the player
	 */
	private boolean playerNotInLevel()
	{
		return !MapInstance.getInstance().levelHasRockford();
	}

	/**
	 * 
	 * @return if there is no more time
	 */
	private boolean runOutOfTime()
	{
		return MapAccess.getTimer() == 0;
	}

	/**
	 * 
	 * @return If the player lost
	 */
	private boolean playerHasLost()
	{
		return PlayerAccess.getPlayer().getLives() == 0;
	}

	/**
	 * 
	 * @return If the player died
	 */
	private boolean playerIsDead()
	{
		return !ElementAccess.entityIsAlive(PlayerAccess.getPlayer());
	}

	/**
	 * 
	 * @return If the player exists
	 */
	private boolean playerExists()
	{
		return PlayerAccess.getPlayer() != null;
	}

	/**
	 * Refresh the map and framemap.
	 */
	private void refreshMapAndFrame()
	{
		MapAccess.refresh();
		FrameMap.refresh();
	}

	/**
	 * Next turn, it always runs every turn.
	 */
	private void nextTurn()
	{
		turn++;
		FrameMap.remove();
	}

}
