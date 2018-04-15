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
 * Nom du fichier :    	labo1.formes.Ovale
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.formes;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * Classe d�finissant un Ovale.
 */
public class Ovale extends Forme{
	
	public Ovale(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/*
	 * M�thode permettant de dessiner l'ovale � partir de ses coordonn�es,
	 * d�fini sa couleur,
	 * d�fini le remplissage de l'ovale.
	 */
	public void dessine(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.drawOval(x1, y1, x2, y2);
		g2.fillOval(x1, y1, x2, y2);
	}

}
