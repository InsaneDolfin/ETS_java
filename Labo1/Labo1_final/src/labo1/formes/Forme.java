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
 * Nom du fichier :    	labo1.formes.Forme
 * crée :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/

package labo1.formes;

import java.awt.Graphics2D;

/*
 * Classe abstraite définissant une forme au sens large et ses 4 coordonnées.
 */
public abstract class Forme {
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	
	/*
	 * Méthode implémentée dans chacunes des différentes formes.
	 */
	public abstract void dessine(Graphics2D g2);
}
