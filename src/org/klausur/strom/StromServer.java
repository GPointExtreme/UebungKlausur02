package org.klausur.strom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class StromServer {
	
	private static ArrayList<ProcessClient> list;

	public ArrayList<ProcessClient> getList() {
		return list;
	}

	public static void main(String[] args) {
		list = new ArrayList<>();
		try (
			ServerSocket server = new ServerSocket(1111);
			) {
			ServerConsole sc = new ServerConsole(server);
			Thread ts = new Thread(sc);
			ts.start();
			
				while(true) {
					Socket client = server.accept();
					ProcessClient pw = new ProcessClient(client);
					
					list.add(pw);
					
					Thread t = new Thread(pw);
					t.start();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
