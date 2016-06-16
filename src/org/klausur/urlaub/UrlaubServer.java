package org.klausur.urlaub;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UrlaubServer {

	public static void main(String[] args) {
		try (
			ServerSocket server = new ServerSocket(1111);
			) {
			while(true) {
				Socket client = server.accept();
				ProzessClient pc = new ProzessClient(client);
				Thread t = new Thread(pc);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
