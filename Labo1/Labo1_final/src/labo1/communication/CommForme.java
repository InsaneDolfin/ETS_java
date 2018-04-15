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
 * Nom du fichier :    	labo1.communication.CommForme
 * crée :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.communication;

/*
 * Classe permettant d'adapter la classe générique "Comm" à notre projet.
 */
public class CommForme extends Comm {
	
	

	/*
	 * La chaine de caractere "GET" sert de flag pour notre serveur, lui permettant de savoir que nous attendons 
	 * sa réponse.
	 */
	public void envoieGET() {
		this.envoieChaine("GET");
		
	}
	
	/*
	 * La chaine de caractere "END" sert de flag pour notre serveur, lui permettant de savoir que nous nous
	 * déconnectons.
	 */
	public void envoieEND() {
		this.envoieChaine("END");
	}
}
