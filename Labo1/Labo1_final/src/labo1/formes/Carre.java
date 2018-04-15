/****************************************************** 
 * 
 * Cours:				ELE116 
 * Session : 			Hiver
 * année:				2018
 * Groupe:				N/A
 * Projet :            	Laboratoire 1
 * Étudiants:    		Justin Guirautane // Jeffrey Tabet
 * Codes perm. :		GUIJ21099504	//	TABJ01079007
 * Professeur :        	Kim Khoa Nguyen
 * Nom du fichier :    	labo1.formes.Carre
 * crée :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.formes;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * Classe définissant un carré.
 */
public class Carre extends Forme{
	
	public Carre(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/*
	 * Méthode permettant de dessiner le carré à partir de ses coordonnées,
	 * défini sa couleur,
	 * défini le remplissage du carré.
	 */
	public void dessine(Graphics2D g2) {
		g2.setColor(Color.ORANGE);
		g2.drawRect(x1, y1, x2, y2);
		g2.fillRect(x1, y1, x2, y2);
	}

}