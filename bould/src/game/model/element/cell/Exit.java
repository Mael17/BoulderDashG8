package game.model.element.cell;

import game.model.element.Position;
import game.model.element.ElementTypes;
import game.model.element.entity.actor.Rockford;
import game.model.map.MapInstance;

/**
 *Output cell class
 */
public class Exit extends Cell
{

	private boolean isOpen;
	private static Exit exit;

	/**
	 *Output constructor.
	 * 
	 * @param pos
	 */
	private Exit()
	{
		super(new Position(0, 0));
		this.setElementType(ElementTypes.ExitClosed);
		this.isOpen = false;
	}

	/**
	 * Singleton output.
	 * 
	 * @return
	 */
	public static Exit getInstance()
	{
		if (exit == null)
		{
			exit = new Exit();
		}
		return exit;
	}

	/**
	 *  Reset the output to its default values.
	 */
	public void close()
	{
		this.setElementType(ElementTypes.ExitClosed);
		this.isOpen = false;
	}

	/**
	 * Open the exit.
	 */
	public void open()
	{
		Rockford player = Rockford.getInstance();
		if (player.getDiamonds() >= MapInstance.getInstance().getDiamondsneeded())
		{
			this.setElementType(ElementTypes.ExitOpen);
			this.isOpen = true;
		}
	}

	/**
	 * 
	 * @return if the exit is open for the player
	 */
	public boolean isOpen()
	{
		return isOpen;
	}

}
