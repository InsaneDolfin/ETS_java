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
 * Nom du fichier :    	labo1.communication.CommForme
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.communication;

/*
 * Classe permettant d'adapter la classe g�n�rique "Comm" � notre projet.
 */
public class CommForme extends Comm {
	
	

	/*
	 * La chaine de caractere "GET" sert de flag pour notre serveur, lui permettant de savoir que nous attendons 
	 * sa r�ponse.
	 */
	public void envoieGET() {
		this.envoieChaine("GET");
		
	}
	
	/*
	 * La chaine de caractere "END" sert de flag pour notre serveur, lui permettant de savoir que nous nous
	 * d�connectons.
	 */
	public void envoieEND() {
		this.envoieChaine("END");
	}
}
