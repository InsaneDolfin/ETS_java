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
 * Nom du fichier :    	labo1.formes.Triangle
 * crée :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;


/*
 * Classe définissant un Triangle (inutile dans notre projet. Le serveur n'envoi pas de requete de triangle).
 */
public class Triangle extends Forme {
	
	public Triangle(int x1, int x2, int y1, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/*
	 * Méthode permettant de dessiner le triangle à partir de ses coordonnées,
	 * défini sa couleur,
	 * défini le remplissage du triangle.
	 */
	public void dessine(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		int[] px = {x1,x2,Math.round((x2-x1)/2)+x1};
		int[] py = {y1,y2,Math.round((x2-x1)/2)};
		Polygon myPoly = new Polygon(px,py,3);
        g2.fill(myPoly);
        g2.draw(myPoly);
	}

}
