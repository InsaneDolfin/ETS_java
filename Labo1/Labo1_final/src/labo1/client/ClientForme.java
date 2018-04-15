/****************************************************** 
 * 
 * Cours:				ELE116 
 * Session : 			Hiver
 * ann�e:				2018
 * Groupe:				N/A
 * Projet :            	Laboratoire 1
 * �tudiants:    		Justin Guirautane // Jeffrey Tabet
 * Codes perm. :		GUIJ21099504	//	TABJ01079007
 * Professeur :        	Kim Khoa Nguyen
 * Nom du fichier :    	labo1.client.ClientForme
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import ca.etsmtl.log.util.IDLogger;
import labo1.communication.CommForme;
import labo1.communication.Transforme;
import labo1.formes.Forme;

/**
 * <code>SqueletteSwingApplication</code> est un exemple d'une
 * application en Java qui fournit une interface Swing, avec un simple
 * menu et un dessin.
 *
 * <h4>References</h4> 
 * <ul> 
 *
 * <li>C. Fuhrman, &quot;Notes de cours de LOG120,&quot; &Eacute;cole
 * de technologie sup&eacute;rieure, Montr&eacute;al, Qu&eacute;bec,
 * Canada, 2002
 *
 * <li>Xemacs (for generation of the initial template), <a target="_top" 
 * href="http://www.xemacs.org">www.xemacs.org</a>, 2002 
 *
 * <li><a target="_top" 
 * href="http://java.sun.com/docs/books/tutorial/uiswing/painting/overview.html">Overview
 * of Custom Painting</a>, une partie du tutoriel Java de Sun, 2002.
 *
 * <li>Java Software, <a target="_top" 
 * href="http://java.sun.com/j2se/javadoc/writingdoccomments/index.html">&quot;How
 * to Write Doc Comments for the Javadoc<sup>TM</sup> Tool,&quot;</a>
 * 2002
 *
 * </ul>
 *
 * Distribution originale &agrave; partir du 
 * <a target="_top" href="https://cours.ele.etsmtl.ca/academique/log120/">site Web</a>
 * du cours LOG120.
 * 
 * Created: Tue May 28 11:31:18 2002
 *
 * @author <a href="mailto:christopher.fuhrman@etsmtl.ca">Christopher Fuhrman</a>
 *
 * @version 1.1
 */


public class ClientForme extends JFrame implements ActionListener {
	
	private static final String 
    TITRE_APPLICATION = "app.frame.title",
	MENU_FICHIER_TITRE = "app.frame.menus.file.title",
	MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
	MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
	MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
	MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop",
	MENU_AIDE_TITRE = "app.frame.menus.help.title",
	MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int MENU_DESSIN_DEMARRER_TOUCHE_MASK =	ActionEvent.CTRL_MASK;

	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC = KeyEvent.VK_A;
	private static final int MENU_DESSIN_ARRETER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final String 
		MESSAGE_DIALOGUE_NO_DE_FORMES = "app.frame.dialog.shapeCount",
		MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	private static final int 
	    NOMBRE_DE_FORMES = 150,
		DELAI_ENTRE_FORMES_MSEC = 1000,
		DELAI_QUITTER_MSEC = 200;

	private static final int 
	    CANEVAS_LARGEUR = 500,
		CANEVAS_HAUTEUR = 500,
		MARGE_H = 50,
		MARGE_V = 60,
		FORME_MAX_LARGEUR = 200,
		FORME_MAX_HAUTEUR = 200;
		
	private int nombreDeFormes = NOMBRE_DE_FORMES;
	
	private Forme forme;
	private TabFormes tab = new TabFormes();
	//IDLogger logger = IDLogger.getInstance();
	
	private boolean workerActive;
	private JMenuItem demarrerMenuItem;
	private JMenuItem arreterMenuItem;
	
	class CustomCanvas extends JPanel {

		public CustomCanvas()
		{
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.setBackground(Color.white);
		}

		public Dimension getPreferredSize() {
			return new Dimension(CANEVAS_LARGEUR, CANEVAS_HAUTEUR);
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			/*
			if (forme != null)
			{
				// faire un cast (transtypage) en Graphics2D depour avoir plus de fonctionnalit�
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
				forme.dessine(g2d);
			}		
			*/
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
			System.out.println(tab);
			
			tab.dessine(g2d);
			
			
		}
	}
	
	public ClientForme() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}
	
	public static void main(String[] args)
	{
		ClientForme frame = new ClientForme();

		frame.makeFileMenu();
		frame.makeDrawMenu();
		frame.makeHelpMenu();

		frame.updateMenus();

		ApplicationSupport.launch(
			frame,
			ApplicationSupport.getResource("app.frame.title"),
			0,
			0,
			CANEVAS_LARGEUR + MARGE_H,
			CANEVAS_HAUTEUR + MARGE_V);

		frame.setLocationRelativeTo(null);
	}

	private JMenu makeFileMenu() {
		JMenu fileMenu =
			ApplicationSupport.addMenu(
				this,
				MENU_FICHIER_TITRE,
				new String[] { MENU_FICHIER_QUITTER });

		fileMenu.getItem(0).addActionListener(this);
		
		fileMenu.getItem(0).setAccelerator(
			KeyStroke.getKeyStroke(
				MENU_FICHIER_QUITTER_TOUCHE_RACC,
				MENU_FICHIER_QUITTER_TOUCHE_MASK));

		return fileMenu;
	}

	private JMenu makeDrawMenu() {
		JMenu drawMenu =
			ApplicationSupport.addMenu(
				this,
				MENU_DESSIN_TITRE,
				new String[] { MENU_DESSIN_DEMARRER, MENU_DESSIN_ARRETER });

		this.demarrerMenuItem = drawMenu.getItem(0);
		this.demarrerMenuItem.addActionListener(this);
		
		this.demarrerMenuItem.setAccelerator(
			KeyStroke.getKeyStroke(
				MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));

		
		this.arreterMenuItem = drawMenu.getItem(1);
		this.arreterMenuItem.addActionListener(this);
		
		this.arreterMenuItem.setAccelerator(
			KeyStroke.getKeyStroke(
				MENU_DESSIN_ARRETER_TOUCHE_RACC,
				MENU_DESSIN_ARRETER_TOUCHE_MASK));

		return drawMenu;
	}

	private JMenu makeHelpMenu() {
		JMenu helpMenu =
			ApplicationSupport.addMenu(
				this,
				MENU_AIDE_TITRE,
				new String[] { MENU_AIDE_PROPOS });

		helpMenu.getItem(0).addActionListener(this);

		return helpMenu;
	}

	private void updateMenus() {
		demarrerMenuItem.setEnabled(!this.workerActive);
		arreterMenuItem.setEnabled(this.workerActive);
	}

	public void actionPerformed(ActionEvent arg0)
	{
		JMenuItem source = (JMenuItem) (arg0.getSource());
		
		// ici, on traite l'article "D�marrer"
		if (source
			.getText()
			.equals(ApplicationSupport.getResource(MENU_DESSIN_DEMARRER))
			&& !this.workerActive)
		{
			/*
			 * Demander � l'usager combien de fois il veut que la forme change
			 */
			JOptionPane.setDefaultLocale(ApplicationSupport.getLocale());
			String stringTemp =
				JOptionPane.showInputDialog(
					ApplicationSupport.getResource(
						MESSAGE_DIALOGUE_NO_DE_FORMES),
					Integer.toString(NOMBRE_DE_FORMES));
			if (stringTemp!= null) {
				this.nombreDeFormes = Integer.parseInt(stringTemp); 
	
				/*
				 * On "dessine" ensuite les formes. C'est une activit� passive 
				 * plut�t qu'active, car il y a une forme definie dans le programme, mais
				 * elle va �voluer dans le temps, en se dessinant avec chaque changement.
				 * Ainsi, c'est une sorte d'animation qui prendra un certain temps.
				 * 
				 * Avec Java Swing, le Thread qui traite les
				 * appels � la m�thode actionPerformed est le m�me qui r�pond � tous les
				 * �venements de la GUI. Si on lui donnait � faire ensuite un traitement
				 * long (l'animation), il ne pourrait plus r�pondre aux �venements. 
				 * Pour �viter ce probl�me, on d�l�gue le travail long � un thread 
				 * special selon une strat�gie propos�e par Sun. C'est le SwingWorker.
				 * Pour plus d'informations sur cette approche, voir
				 * http://java.sun.com/products/jfc/tsc/articles/threads/threads2.html
				 * ou chercher "SwingWorker" dans le tutorial Java de Sun.
				 */
				final SwingWorker worker = new SwingWorker()
				{
					public Object construct()
					{
						//...code that might take a while to execute is here...
		                dessinerFormes();
						workerActive = false;
						updateMenus();
						return new Integer(0);
					}
				};
				worker.start(); //required for SwingWorker 3
				this.workerActive = true;
			}
		} else
			/*
			 * Traiter l'article de menu qui arr�te le SwingWorker
			 * On met � false la valeur de l'attribut "workerActive" car la m�thode 
			 * dessinerFormes() va le tester dans sa boucle 
			 */
			if (source
				.getText()
				.equals(ApplicationSupport.getResource(MENU_DESSIN_ARRETER))
				&& this.workerActive)
			{
				this.workerActive = false;
			} else
				/*
				 * Traiter l'article "A propos de ..." ici
				 */
				if (source
					.getText()
					.equals(ApplicationSupport.getResource(MENU_AIDE_PROPOS)))
				{
					JOptionPane.showMessageDialog(
						this,
						ApplicationSupport.getResource(
							MESSAGE_DIALOGUE_A_PROPOS),
						ApplicationSupport.getResource(MENU_AIDE_PROPOS),
						JOptionPane.INFORMATION_MESSAGE);
				} else
					/*
					 * Traiter l'article "Quitter" ici
					 * On devrait arr�ter le SwingWorker par principe, s'il est activ�
					 */
					if (source
						.getText()
						.equals(
							ApplicationSupport.getResource(
								MENU_FICHIER_QUITTER)))
					{
						if (this.workerActive)
						{
							this.workerActive = false;
							try
							{
								// pause courte pour permettre le worker de terminer
								Thread.sleep(DELAI_QUITTER_MSEC);
							} catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						}
						System.exit(0);
					}

		updateMenus(); // changer l'�tat des menus selon les fanions

	}
	
	protected void dessinerFormes()
	{
		CommForme com = new CommForme();
		com.connectionServeur();
		
		
		IDLogger logger = IDLogger.getInstance();
		for (int i = 0; i < this.nombreDeFormes && this.workerActive; i++)
		{
			/*
			this.forme =
				new Ellipse2D.Double(
					Math.random() * CANEVAS_LARGEUR,
					Math.random() * CANEVAS_HAUTEUR,
					Math.random() * FORME_MAX_LARGEUR,
					Math.random() * FORME_MAX_HAUTEUR);
			*/
			
			
			String t = com.recoieChaine();
			com.envoieGET();
			t = com.recoieChaine();
			System.out.println(t);
			
			Transforme transf = new Transforme(t);
			this.forme = transf.getForme();
			
			tab.add(forme);
			logger.logID(transf.getID());
			System.out.println(transf.getID());
			//System.out.println(tab.getSize());
			
			
			
			
			/* 
			 * L'instruction suivante demande au syst�me de redessiner le JFrame
			 * (notre SqueletteSwingApplication). Puisqu'elle est compos�e d'un
			 * JPanel (notre CustomCanvas, la classe interne), la m�thode 
			 * "paintComponent()" de ce dernier sera appel�e par le syst�me. 
			 * � l'int�rieur de paintComponent, l'objet "forme" sera utilis� 
			 * pour faire le dessin.
			 * Le dessin se fait d'une mani�re indirecte -- ceci est une 
			 * caract�ristique de pratiquement tout syst�me avec les fen�tres.
			 */
			
			this.repaint();
			try
			{
				// pause de N millisecondes
				Thread.sleep(DELAI_ENTRE_FORMES_MSEC);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		com.envoieEND();
		
		System.out.println(tab.getTab());
	}
}
