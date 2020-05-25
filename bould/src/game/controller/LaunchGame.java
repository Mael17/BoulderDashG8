package game.controller;

import game.exception.LevelNotValidException;
import game.model.map.MapInstance;
import game.view.FrameMap;

import java.util.Timer;

/**
 * Launch class of the game. Run the GameThread.
 */
public class LaunchGame
{
	private static GameThread task;
	
	/**
	 *Create a timer and use the level stored in MapInstance, initialize to
     *Mapinstance, then if the level is valid build it. Initialize the
     * Frame the map and make it visible. Refresh everything and invoke the thread of
     * play with the timer. 
	 * 
	 * @param args
	 */
	public static void runGameThread()
	{
		int TASKSPEED = 110;
		int TASKDELAY = 1000;
		
		initializeMapInstance();
		initializeFrameMap();
		initializeGameThread(TASKSPEED, TASKDELAY);

	}

	/**
	 * Initialize game thread.
	 * @param TASKSPEED
	 * @param TASKDELAY
	 */
	private static void initializeGameThread(int TASKSPEED, int TASKDELAY)
	{
		Timer timer = new Timer("test");
		task = new GameThread(timer);
		timer.schedule(task, TASKDELAY, TASKSPEED);
	}

	/**
	 * Initialize framemap.
	 */
	private static void initializeFrameMap()
	{
		FrameMap.start();
		FrameMap.refresh();
		FrameMap.getInstance().setVisible(true);
	}

	/**
	 * Initialize map instance and set and build the level.
	 */
	private static void initializeMapInstance()
	{
		int selectedlevel;
		selectedlevel = MapInstance.getInstance().getSelectedLevel();
		MapInstance.start();
		try
		{
			MapInstance.getInstance().buildSelectedLevel(selectedlevel);
		}
		catch (LevelNotValidException e)
		{
			try
			{
				MapInstance.getInstance().buildSelectedLevel(1);
			}
			catch (LevelNotValidException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		MapInstance.getInstance().refresh();
	}

}