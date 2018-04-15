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
 * Nom du fichier :    	labo1.communication.Transforme
 * crée :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.communication;

import java.util.ArrayList;
import java.util.List;

import labo1.formes.*;

/*
 * Classe permettant de décortiquer la chaine de caractère envoyée par le Serveur au Client.
 * Ainsi, elle permet de récupérer toutes les informations à l'aide de "Parse".
 * On définit aussi des Getter afin d'avoir accès à ces informations.
 */
public class Transforme {
	
	private Forme forme;
	private int id;
	private String formeName;
	private List<Integer> positions;
	
	/*
	 * Méthode permettant d'extraire l'id de la chaine de caractère.
	 */
	private int parseID(String str) {
		return Integer.parseInt(str.split(" ")[0]);
	}
	
	/*
	 * Méthode permettant d'extraire le nom de la forme de la chaine de caractère.
	 */
	private String parseFormeName(String str) {
		return str.split(" ")[1];
	}
	
	/*
	 * Méthode permettant d'extraire les différentes coordonnées de la chaine de caractère.
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
	 * Méthode permettant de créer la forme adéquate en fonctions des informations de la chaine de caractère.
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
	 * Getter permettant d'avoir accès à l'id
	 */
	public int getID() {
		return this.id;
	}
	/*
	 * Getter permettant d'avoir accès au nom de la forme
	 */
	public String getFormeName() {
		return this.formeName;
	}
	/*
	 * Getter permettant d'avoir accès aux coordonnées de la forme
	 */
	public List<Integer> getPositions() {
		return this.positions;
	}
	/*
	 * Getter permettant d'acceder à la forme crée à partir de toutes les informations de la chaine
	 */
	public Forme getForme() {
		return this.forme;
	}
	
	
	
}
