package imt.ets.ele116.lab1.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Comm {
	Socket client;
	PrintStream output;
	BufferedReader input;
	public void connectionServeur() {
		
		try {
			client = new Socket("localhost", 10000);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void envoieChaine(String chaine) {
		try {
			output = new PrintStream(client.getOutputStream());
			output.println(chaine);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
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
