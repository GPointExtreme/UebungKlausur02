package org.klausur.strom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class StromServer {

	public static void main(String[] args) {
		ArrayList<Socket> list = new ArrayList<>();
		try (
			ServerSocket server = new ServerSocket(1111);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			) {
			while(true) {
				Socket client = server.accept();
				ProcessClient pw = new ProcessClient(client);
				
				list.add(client);
				
//				String line;
//				while((line = br.readLine()) != null) {
//					for (Socket socket : list) {
//						OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
//						PrintWriter p = new PrintWriter(osw);
//						p.println(line);
//						p.flush();
//					}
//				}
				
				Thread t = new Thread(pw);
				t.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
