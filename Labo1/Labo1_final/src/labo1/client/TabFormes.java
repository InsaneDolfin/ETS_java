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
 * Nom du fichier :    	labo1.client.TabFormes
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.client;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

//import labo1.communication.*;
import labo1.formes.*;


/*
 * Cette classe permet la gestion du tableau contenant les formes qui seront affich�es � l'�cran.
 */

public class TabFormes {
	
	private int TabLength = 10;
	private List<Forme> tabForme;
	
	public TabFormes() {
		this.tabForme = new ArrayList<Forme>();
	}
	
	/*
	 * Ajout d'une forme au tableau.
	 * Si le tableau comporte moins de 10 �l�ments, on ajoute naturellement.
	 * Sinon, on retire la premi�re forme cr�e et on ajoute la nouvelle � la fin.
	 */
	public void add(Forme f) {
		if (this.tabForme.size() < TabLength)
			this.tabForme.add(f);
		else {
			this.tabForme.remove(0);
			this.tabForme.add(f);
		}
	}
	
	/*
	 * M�thode permettant de retirer un �l�ment du tableau en indiquand son index.
	 */
	public void remove(int index) {
		this.tabForme.remove(index);
	}
	
	/*
	 * M�thode permettant d'obtenir la taille du tableau.
	 */
	public int getSize() {
		return this.tabForme.size();
	}
	
	/*
	 * M�thode permettant de r�cup�rer la forme correspondant � l'index indiqu�
	 */
	public Forme getForme(int index) {
		return this.tabForme.get(index);
	}
	
	/*
	 * M�thode permettant de dessiner la totalit� des formes contenues dans le tableau.
	 * On utilise pour cela la m�thode "dessine" d�finie dans la classe abstraite "Forme"
	 */
	public void dessine(Graphics2D g2) {
		for (int i=0 ; i<tabForme.size(); i++) {
			getForme(i).dessine(g2);
		}
	}
	
	/*
	 * M�thode permettant de r�cup�rer la totalit� du tableau.
	 */
	public List<Forme> getTab() {
		return this.tabForme;
	}
}
