package org.klausur.urlaub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ProzessClient implements Runnable{
	
	private Socket client;

	public ProzessClient(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {
		try (
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			) {
			UrlaubManager um = new UrlaubManager();
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(" ");
				if(array[0].equals("GET") && array[1].equals("ALL")) {
					try {
						ArrayList<Urlaub> list = um.loadAll();
						for (Urlaub urlaub : list) {
							pw.println(urlaub.toString());
						}
					} catch (DataFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(array[0].equals("GET") && array.length == 2) {
					try {
						ArrayList<Urlaub> list = um.load(array[1]);
						for (Urlaub urlaub : list) {
							pw.println(urlaub.toString());
						}
						pw.flush();
					} catch (DataFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(array[0].equals("EXIT")) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
