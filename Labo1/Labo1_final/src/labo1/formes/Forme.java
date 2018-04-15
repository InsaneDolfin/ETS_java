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
 * Nom du fichier :    	labo1.formes.Forme
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/

package labo1.formes;

import java.awt.Graphics2D;

/*
 * Classe abstraite d�finissant une forme au sens large et ses 4 coordonn�es.
 */
public abstract class Forme {
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	
	/*
	 * M�thode impl�ment�e dans chacunes des diff�rentes formes.
	 */
	public abstract void dessine(Graphics2D g2);
}
