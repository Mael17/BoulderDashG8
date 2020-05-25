package game.view.scoreboard;

//import java.io.InputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
//import java.net.URL;

/**
 * Il est utilisé pour charger et enregistrer la liste des noms de score dans un fichier.
 *
 */
public class ScoreBoard
{
	private static ScoreBoard scoreboard;
	private String filename;
	private String foldername;
	private File folder;
	private File file;
	private String path;

	private ScoreBoard()
	{
		this.filename = "scoreboard.dat";
		this.foldername = "Boulder Dash";

		this.path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + foldername;
		this.folder = new File(path);
		this.file = new File(path, filename);
	}

	public static ScoreBoard getInstance() throws FileNotFoundException, URISyntaxException
	{
		if (scoreboard == null)
		{
			scoreboard = new ScoreBoard();
		}
		return scoreboard;
	}

	/**
	 * Essayez de lire le fichier, s'il n'existe pas, créez-le, s'il existe, lisez-le
*
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void findFileAndRead() throws IOException, ClassNotFoundException
	{
		checkIfFolderExists();
		if (file.exists())
		{
			System.out.println(path + "\\" + filename + " already exists");
			readScorenames();
		}
		else if (!file.exists())
		{
			System.out.println(path + "\\" + filename + " doesn't exist");
		}
		else
		{
			System.out.println(path + "\\" + filename + " was not created");
		}
	}

	/**
	 * Lisez le fichier et mettez les données dans une liste de noms de score. a également ordonné
* la liste.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readScorenames() throws IOException, ClassNotFoundException
	{
		FileInputStream streamin = new FileInputStream(file);
		// InputStream streamin =
		// getClass().getResourceAsStream("/res/Menu/Scoreboard.dat");
		if (streamin.available() != 0)
		{
			ObjectInputStream input = null;
			input = new ObjectInputStream(streamin);
			readingScorenames(input);
			input.close();
		}
	}

	/**
	* Écrivez le fichier.
	 * 
	 * @param scorenamelist
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void writeScorenames() throws IOException, ClassNotFoundException
	{
		FileOutputStream streamout = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(streamout);
		writingScorenames(output);
		output.close();
	}

	//////////////////

	/**
	 * Supprimez les données de la liste des noms de score.
	 * 
	 * @param output
	 * @throws IOException
	 */
	private void writingScorenames(ObjectOutputStream output) throws IOException
	{
		for (int i = 0; i < ListOfScorename.getList().size(); i++)
		{
			output.writeObject(ListOfScorename.getList().get(i));
		}
	}

	/**
	 *Lisez le fichier et mettez les données dans une liste de noms de score.
	 * 
	 * @param endfile
	 * @param input
	 * @return Si termino el archivo
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readingScorenames(ObjectInputStream input) throws IOException, ClassNotFoundException
	{
		boolean endfile = false;
		Scorename participant;

		while (!endfile)
		{
			try
			{
				participant = (Scorename) input.readObject();
				ListOfScorename.getList().add(participant);
			}
			catch (EOFException e)
			{
				endfile = true;
				// e.printStackTrace();
			}
		}
	}

	/**
	 * Essayez de trouver le répertoire, sinon il le crée.
	 * 
	 */
	private void checkIfFolderExists()
	{
		if (folder.exists())
		{
			System.out.println(path + " already exists");
		}
		else if (folder.mkdirs())
		{
			System.out.println(path + " was created");
		}
		else
		{
			System.out.println(path + " was not created");
		}
	}

}
