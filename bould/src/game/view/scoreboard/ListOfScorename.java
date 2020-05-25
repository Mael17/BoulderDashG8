package game.view.scoreboard;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Liste contenant les informations de chaque joueur en haut.
 */
public class ListOfScorename
{
	private static ListOfScorename singleton;
	private static List<Scorename> scorenamelist;

	/**
	 * Le générateur définit la liste sur null.
	 */
	private ListOfScorename()
	{
		scorenamelist = null;
	}

	/**
	 * Singleton de la liste des noms de score.
	 * 
	 * @return singleton
	 */
	public static ListOfScorename getInstance()
	{
		if (singleton == null)
		{
			singleton = new ListOfScorename();
		}
		return singleton;
	}

	/**
	 * Singleton de la liste des noms de score...
	 */
	public void start()
	{
		scorenamelist = new ArrayList<Scorename>();
	}

	/**
	 *Renvoie la liste.
*
* @return Renvoie la liste des noms de score
	 */
	public static List<Scorename> getList()
	{
		return scorenamelist;
	}

	/**
	 * Trier la liste des participants, le score le plus élevé et le temps le plus court sont
* premier sur la liste.
	 */
	public static void sortScorename()
	{
		if (scorenamelist != null)
		{
			Collections.sort(scorenamelist, new Comparator<Scorename>()
			{

				@Override
				public int compare(Scorename o1, Scorename o2)
				{
					if (o1.getPoints() < o2.getPoints() || o1.getPoints() == o2.getPoints() && o1.getTime() > o2.getTime())
					{
						return 1;
					}
					if (o1.getPoints() > o2.getPoints() || o1.getPoints() == o2.getPoints() && o1.getTime() < o2.getTime())
					{
						return -1;
					}
					return 0;
				}

			});
			int i;
			for (i = 0; i < scorenamelist.size(); i++)
			{
				scorenamelist.get(i).setRank(i + 1);
			}
		}
	}

	/**
	 * Ajoutez un nom de score dans la liste et placez les données de la liste dans un
* fichier de tableau de bord.
*
* @param scorename
*: l'objet scorename
	 */
	public void addNameTable(Scorename scorename)
	{
		ListOfScorename.getList().add(scorename);
		try
		{
			ScoreBoard.getInstance().writeScorenames();
		}
		catch (ClassNotFoundException | IOException | URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListOfScorename.sortScorename();
	}

	/** * Remplacez un nom de partition dans la liste et placez les données de la liste dans un fichier de * tableau de bord.
	 * 
	 * * @param scorename: l'objet scorename
	 */
	public void replaceNameTable(Scorename scorename)
	{
		int i = 0;
		while (i < ListOfScorename.getList().size() && !ListOfScorename.getList().get(i).equals(scorename))
		{
			i++;
		}
		ListOfScorename.getList().remove(i);
		ListOfScorename.getList().add(scorename);
		try
		{
			ScoreBoard.getInstance().writeScorenames();
		}
		catch (ClassNotFoundException | IOException | URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListOfScorename.sortScorename();
	}

	@Override
	public boolean equals(Object obj)
	{
		for (int i = 0; i < scorenamelist.size(); i++)
		{
			if (scorenamelist.get(i).equals(obj))
			{
				return true;
			}
		}
		return false;
	}
}
