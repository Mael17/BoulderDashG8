package game.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import game.controller.access.MapAccess;
import game.view.scoreboard.ListOfScorename;
import game.view.scoreboard.Scorename;

/**
 * Panneau qui apparaît à la fin du jeu. Il est chargé de sauvegarder le score du
  * joueur dans le tableau.
 */
public class FrameEnd extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1861437422306275617L;
	private static FrameEnd frameend;
	private static JPanel panelend;

	// panelend
	private JTextField field;
	private JButton button;
	private JLabel scoreinfo;
	private Integer time;

	private FrameEnd()
	{
		setLayout(new FlowLayout());
		setResizable(false);
		buildPanelEnd();
		add(panelend);
		pack();
		setSize(250, 150);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static FrameEnd getInstance()
	{
		if (frameend == null)
		{
			frameend = new FrameEnd();
		}
		return frameend;
	}

	/**
	 * Construisez le panneau.
	 */
	public void buildPanelEnd()
	{

		panelend = new JPanel();
		panelend.setLayout(new GridBagLayout());

		scoreinfo = new JLabel("text", SwingConstants.CENTER);
		scoreinfo.setSize(100, 50);
		scoreinfo.setHorizontalAlignment(SwingConstants.CENTER);
		panelend.add(scoreinfo);

		field = new JTextField();
		field.setEditable(true);
		field.setSize(100, 50);
		Constraint.setup(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		panelend.add(field, Constraint.get());

		button = new JButton("Save score");
		button.addActionListener(new ActionListener()
		{

			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String name = field.getText();
				if (nameIsValid(name))
				{
					if (name.length() > 20)
						name = name.substring(0, 20);
					Scorename scorename = new Scorename(0, name, MapAccess.getTotalScore(), frameend.time);

					if (ListOfScorename.getInstance().equals(scorename))
					{
						setVisible(false);
						FrameNameExists.runFrameNameExists(scorename);
					}
					else
					{
						ListOfScorename.getInstance().addNameTable(scorename);
						setVisible(false);
						FrameMenu.runFrameMenu();
					}

				}
				else
				{
					field.setText("INVALIDO!");
				}
			}
		});
		Constraint.setup(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		panelend.add(button, Constraint.get());
	}

	/**
	 *Vérifiez si le nom du joueur est valide.
	 * 
	 * @param name
	 * @return si le nom du joueur est valide
	 */
	private boolean nameIsValid(String name)
	{
		if (name.length() > 2 && !name.contains(" ") && !name.equals("INVALIDO!"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * si le nom du joueur est valide...
	 * 
	 * @param time
	 */
	public static void setTime(Integer time)
	{
		frameend.time = time;
	}

	/**
	 * Actualisez le panneau Fin.
	 */
	private void refreshPanelEnd()
	{
		if (MapAccess.getTotalScore() != null && frameend.time != null)
		{
			scoreinfo.setText("Puntuacion: " + MapAccess.getTotalScore().toString() + "\n " + "Tiempo: " + frameend.time.toString());
		}
	}

	/**
	 *Montrez le cadre.
	 * 
	 * @param args
	 */
	public static void runFrameEnd(String[] args)
	{
		FrameEnd runFrameEnd = FrameEnd.getInstance();
		runFrameEnd.refreshPanelEnd();
		runFrameEnd.setVisible(true);
	}

}
