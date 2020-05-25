package game.controller.access;

import game.model.map.MapInstance;
import game.model.map.MapChar;

/**
 * 
 *Map access in the model. 
 *
 */
public class MapAccess
{
	/**
	 * Refresh the map, and the information of the level and total score.
	 */
	public static void refresh()
	{
		MapInstance.getInstance().refresh();
	}

	/**
	 * 
	 * 
	 * @return level height
	 */
	public static Integer getHeight()
	{
		return MapInstance.getInstance().getLevelReader().getHEIGHT();
	}

	/**
	 * 
	 * 
	 * @return level length.
	 */
	public static Integer getWidth()
	{
		return MapInstance.getInstance().getLevelReader().getWIDTH();
	}

	/**
	 * 
	 * 
	 * @return chosen level .
	 */
	public static Integer getLevel()
	{
		return MapInstance.getInstance().getSelectedLevel();
	}

	/**
	 * 
	 * 
	 * @return necessary level diamonds 
	 */
	public static Integer getDiamondsneeded()
	{
		return MapInstance.getInstance().getDiamondsneeded();
	}

	/**
	 * 
	 * 
	 * @return limited time map.
	 */
	public static Integer getTimer()
	{
		return MapInstance.getInstance().getTimer().intValue();
	}

	/**
	 *
	 * 
	 * @return player total score
	 */
	public static Integer getTotalScore()
	{
		return MapInstance.getInstance().getPlayerscore();
	}

	/**
	 * 
	 * 
	 * @return character of an element
	 */
	public static char getCellChar(int x, int y)
	{
		return MapChar.getChar(x, y).getLetter();
	}

	/**
	 * Sets the number of the current level.
	 * 
	 * @param selectedlevels
	 */
	public static void setSelectedLevel(Integer selectedlevels)
	{
		MapInstance.getInstance().setSelectedLevel(selectedlevels);
	}

}
