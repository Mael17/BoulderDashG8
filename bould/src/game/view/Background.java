package game.view;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Dessinez l'image d'arrière-plan dans le menu.
 *
 */
public class Background extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -477222138070292249L;
	private String dirwallpaper = "/res/Menu/wallpaper.jpg";
	private Image wallpaperimg;
	private Image img;
	private URL imgUrl;

	/**
	 * Fond de constructeur.
*
* @param gridBagLayout
	 */
	public Background(GridBagLayout gridBagLayout)
	{
		imgUrl = Background.class.getResource(dirwallpaper);
		this.setLayout(gridBagLayout);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(img, 0, 0, null);
	}

	/**
	 * Definit l'image d'arriere plan.
	 * 
	 * @param img
	 */
	public void setImage(Image img)
	{
		this.img = img;
	}

	/**
	 * Renvoie l'image d'arrière-plan.
	 * 
	 * @param img
	 */
	public Image getImage()
	{
		return this.img;
	}

	/**
	 * Définir l'image d'arrière-plan du menu.
	 */
	public void putBackground(JFrame frame)
	{
		if (imgUrl == null)
		{
			System.err.println("No se encuetra el archivo: " + dirwallpaper);
		}
		else
		{
			try
			{
				wallpaperimg = ImageIO.read(Background.class.getResource(dirwallpaper));
				wallpaperimg = wallpaperimg.getScaledInstance(frame.getSize().width, frame.getSize().height, Image.SCALE_DEFAULT);
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		this.setImage(wallpaperimg);
	}
}