package game.view;

import java.awt.GridBagConstraints;

/**
 * Il est utilisé pour définir la contrainte du gridbaglayout.
 *
 */
public class Constraint
{
	private static GridBagConstraints constraint = new GridBagConstraints();

	/**
	 * Définissez la position / les paramètres visuels d'un élément avant de l'ajouter
* sur le panneau.
	 * 
	 * @param constraint
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param weightx
	 * @param weighty
	 * @param anchor
	 * @param fill
	 */
	public static void setup(int x, int y, int width, int height, double weightx, double weighty, int anchor, int fill)
	{
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridwidth = width;
		constraint.gridheight = height;
		constraint.weightx = weightx;
		constraint.weighty = weighty;
		constraint.anchor = anchor;
		constraint.fill = fill;
	}

	/**
	 * Renvoie la contrainte.
	 * 
	 * @return constraint
	 */
	public static GridBagConstraints get()
	{
		return constraint;
	}
}
