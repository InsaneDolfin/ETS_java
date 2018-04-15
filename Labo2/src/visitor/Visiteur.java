/****************************************************** 
 * 
 * Cours:				ELE116 
 * Session : 			Hiver
 * ann�e:				2018
 * Groupe:				N/A
 * Projet :            	Laboratoire 2
 * �tudiants:    		Justin Guirautane // Jeffrey Tabet
 * Codes perm. :		GUIJ21099504	//	TABJ01079007
 * Professeur :        	Kim Khoa Nguyen
 * Nom du fichier :    	labo2.visitor.Visiteur
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/

package visitor;

import arbre.Node;

// Interfacec permettant de creer et de recuperer le fichier HTML qui sera affiche a l'ecran
public interface Visiteur {
	public void visit(Node node);
	public String getHTML();
}
