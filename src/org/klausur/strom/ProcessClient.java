package org.klausur.strom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class ProcessClient implements Runnable{
	
	private Socket client;
	private OutputStreamWriter osw;
	private PrintWriter pw;
	StromRepository sr = new StromRepository();

	public ProcessClient(Socket client) {
		super();
		this.client = client;
		try {
			this.osw = new OutputStreamWriter(client.getOutputStream());
			this.pw = new PrintWriter(osw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OutputStreamWriter getOsw() {
		return osw;
	}

	public PrintWriter getPw() {
		return pw;
	}

	@Override
	public void run() {
		try (
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			) {
			pw.println("HELLO");
			pw.flush();
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(" ");
				if(array[0].equals("get") && array[6].equals("datum")) {
					try {
						ArrayList<Stromverbrauch> list = sr.load(array[1], array[2], array[3]);
						Collections.sort(list, new DatumComparator());
						for (Stromverbrauch stromverbrauch : list) {
							pw.println(stromverbrauch.toString());
						}
						pw.flush();
					} catch (DataFileException e) {
						e.printStackTrace();
					}
				}
				else if(array[0].equals("get") && array[6].equals("tarif")) {
					try {
						ArrayList<Stromverbrauch> list = sr.load(array[1], array[2], array[3]);
						Collections.sort(list, new TarifComparator());
						for (Stromverbrauch stromverbrauch : list) {
							pw.println(stromverbrauch.toString());
						}
						pw.flush();
					} catch (DataFileException e) {
						e.printStackTrace();
					}
				}
				else if(array[0].equals("exit") || array[0].equals("bye")) {
					break;
				}
				else {
					pw.println("Nicht ok");
				}
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
