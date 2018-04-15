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
 * Nom du fichier :    	labo1.communication.Transforme
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.communication;

import java.util.ArrayList;
import java.util.List;

import labo1.formes.*;

/*
 * Classe permettant de d�cortiquer la chaine de caract�re envoy�e par le Serveur au Client.
 * Ainsi, elle permet de r�cup�rer toutes les informations � l'aide de "Parse".
 * On d�finit aussi des Getter afin d'avoir acc�s � ces informations.
 */
public class Transforme {
	
	private Forme forme;
	private int id;
	private String formeName;
	private List<Integer> positions;
	
	/*
	 * M�thode permettant d'extraire l'id de la chaine de caract�re.
	 */
	private int parseID(String str) {
		return Integer.parseInt(str.split(" ")[0]);
	}
	
	/*
	 * M�thode permettant d'extraire le nom de la forme de la chaine de caract�re.
	 */
	private String parseFormeName(String str) {
		return str.split(" ")[1];
	}
	
	/*
	 * M�thode permettant d'extraire les diff�rentes coordonn�es de la chaine de caract�re.
	 */
	private List<Integer> parsePositions(String str) {
		List<Integer> pos = new ArrayList<Integer>();
		int max = 4;
		if (parseFormeName(str).equals("<CERCLE>") )
			max = 3;
		for (int i = 0; i<max ; i++) {
			pos.add(Integer.parseInt(str.split(" ")[i+2]));	
		}
		
		return pos;		
	}
	
	/*
	 * M�thode permettant de cr�er la forme ad�quate en fonctions des informations de la chaine de caract�re.
	 */
	private Forme parseForme(String str) {
		
		String shape = parseFormeName(str);
		List<Integer> pos = parsePositions(str);
		Forme f = null;
		
		if (shape.equals("<RECTANGLE>")) {
			f = new Rectangle(pos.get(0), pos.get(1), pos.get(2), pos.get(3));
		}
		
		if (shape.equals("<CARRE>")) {
			f = new Carre(pos.get(0), pos.get(1), pos.get(2), pos.get(3));
		}
		
		else if (shape.equals("<OVALE>")) {
			f = new Ovale(pos.get(0), pos.get(1), pos.get(2), pos.get(3));
		}
		
		else if (shape.equals("<LIGNE>")) {
			f = new Ligne(pos.get(0), pos.get(1), pos.get(2), pos.get(3));
		}
		
		else if (shape.equals("<CERCLE>")) {
			f = new Cercle(pos.get(0), pos.get(1), pos.get(2));
		}
		
		return f;
	}
	
	
	
	/*
	 * Constructeur de la classe
	 */
	public Transforme(String str) {
		this.id = parseID(str);
		this.formeName = parseFormeName(str);
		this.positions = parsePositions(str);
		this.forme = parseForme(str);
	}
	
	/*
	 * Getter permettant d'avoir acc�s � l'id
	 */
	public int getID() {
		return this.id;
	}
	/*
	 * Getter permettant d'avoir acc�s au nom de la forme
	 */
	public String getFormeName() {
		return this.formeName;
	}
	/*
	 * Getter permettant d'avoir acc�s aux coordonn�es de la forme
	 */
	public List<Integer> getPositions() {
		return this.positions;
	}
	/*
	 * Getter permettant d'acceder � la forme cr�e � partir de toutes les informations de la chaine
	 */
	public Forme getForme() {
		return this.forme;
	}
	
	
	
}
