package game.model;

import game.exception.LevelNotValidException;
import game.model.element.entity.actor.Rockford;
import game.model.map.MapInstance;
import game.model.map.MapChar;
import java.util.Scanner;

/**
 * Launches the game without a graphic interface. Useful for debuting.
 * It works in turns and with the keyboard and the console.
 */
public class Console
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		final int STARTLEVEL = 1;
		boolean gameIsStopped = false;

		startMapAndSetLevel(STARTLEVEL);
		refreshMapAndPrint();
		writeIntroInConsole();
		
		Rockford player = Rockford.getInstance();
		while (!gameIsStopped)
		{
			gameIsStopped = doTurn(in, gameIsStopped, player);
		}
		writeInfoInConsole();
		in.close();
	}

	/**
	 * Escribe en la consola el mensaje inicial.
	 */
	private static void writeIntroInConsole()
	{
		System.out.println("Usar las teclas (w)(a)(s)(d) para mover a Rockford, (e) para esperar, apretar (q) para quitar el nivel");
	}

	/**
	 * Write the information in console.
	 */
	private static void writeInfoInConsole()
	{
		System.out.println("FIN DEL NIVEL: " + MapInstance.getInstance().getSelectedLevel());
		System.out.println("FIN DEL PROGRAMA");
	}

	/**
	 * It is the turn.
	 * @param in
	 * @param quit
	 * @param player
	 * @return if the player removed 
	 */ 
	private static boolean doTurn(Scanner in, boolean quit, Rockford player)
	{
		quit = pressKeyToMove(in, quit, player);

		refreshMapAndPrint();
		if (!quit)
		{
			quit = player.isInExit();
		}
		return quit;
	}

	/**
	 * Press key to do something.
	 * @param in
	 * @param quit
	 * @param player
	 * @return if the player hit the remove key
	 */
	private static boolean pressKeyToMove(Scanner in, boolean quit, Rockford player)
	{
		String dir = in.next();
		switch (dir)
		{
			case "w":
				player.move(Direction.UP);
				break;
			case "s":
				player.move(Direction.DOWN);
				break;
			case "d":
				player.move(Direction.RIGHT);
				break;
			case "a":
				player.move(Direction.LEFT);
				break;
			case "e":
				break;
			case "q":
				quit = true;
				break;
			default:
				break;
		}
		return quit;
	}

	/**
	 * Refresh the map and print it.
	 */
	private static void refreshMapAndPrint()
	{
		MapInstance.getInstance().refresh();
		MapChar.imprimirMapa();
	}

	/**
	 * Set the initial level.
	 * @param STARTLEVEL
	 */
	private static void startMapAndSetLevel(final int STARTLEVEL)
	{
		MapInstance.start();

		try
		{
			MapInstance.getInstance().buildSelectedLevel(STARTLEVEL);
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
	}

}