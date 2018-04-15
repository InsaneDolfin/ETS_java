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
 * Nom du fichier :    	labo1.communication.Comm
 * crée :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * Classe permettant de gérer la connection/déconnection à un serveur qu'il soit distant ou local.
 * Permet aussi de gérer les échanges avec le serveur.
 * (Classe "générique", peut être utilisée dans des projets différents.
 */
public class Comm {
	Socket client;
	PrintStream output;
	BufferedReader input;
	
	/*
	 * Méthode permettant la connection au serveur dont on spécifie son adresse et le port.
	 */
	public void connectionServeur() {
		
		try {
			client = new Socket("localhost", 10000);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/*
	 * Méthode permettant d'instancier un canal d'échange avec le serveur dans le sens client -> Serveur 
	 * pour lui envoyer une chaine de caractère
	 */
	public void envoieChaine(String chaine) {
		try {
			output = new PrintStream(client.getOutputStream());
			output.println(chaine);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/*
	 * Méthode permettant d'instancier un canal d'échange avec le serveur dans le sens Serveur -> Client 
	 * pour recevoir une chaine de caractère
	 */
	public String recoieChaine() {
		try {
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String data = input.readLine();
			return data;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
	/*
	 * Méthode permettant la déconnection entre Client et Serveur.
	 */
	public void terminerConnection() {
		try {
			output.close();
			input.close();
			client.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	

}
