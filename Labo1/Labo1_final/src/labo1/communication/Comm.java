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
 * Nom du fichier :    	labo1.communication.Comm
 * cr�e :         		2018-01-15
 * Date dern. modif.   	2018-01-25

 * *******************************************************/


package labo1.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * Classe permettant de g�rer la connection/d�connection � un serveur qu'il soit distant ou local.
 * Permet aussi de g�rer les �changes avec le serveur.
 * (Classe "g�n�rique", peut �tre utilis�e dans des projets diff�rents.
 */
public class Comm {
	Socket client;
	PrintStream output;
	BufferedReader input;
	
	/*
	 * M�thode permettant la connection au serveur dont on sp�cifie son adresse et le port.
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
	 * M�thode permettant d'instancier un canal d'�change avec le serveur dans le sens client -> Serveur 
	 * pour lui envoyer une chaine de caract�re
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
	 * M�thode permettant d'instancier un canal d'�change avec le serveur dans le sens Serveur -> Client 
	 * pour recevoir une chaine de caract�re
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
	 * M�thode permettant la d�connection entre Client et Serveur.
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
