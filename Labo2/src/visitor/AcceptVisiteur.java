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
 * Nom du fichier :    	labo2.visitor.AcceptVisiteur
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/

package visitor;

// interface permettant de realiser la fonction accept definie dans les noeuds.
public interface AcceptVisiteur {
	public void accept(Visiteur visiteur);
}
