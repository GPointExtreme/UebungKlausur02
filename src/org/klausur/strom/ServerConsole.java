package org.klausur.strom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ServerConsole implements Runnable {
	
	private ServerSocket server;
	public boolean stop;
	StromServer ss = new StromServer();

	public ServerConsole(ServerSocket server) {
		super();
		this.server = server;
	}

	@Override
	public void run() {
		try (
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			) {
			String line;
			while((line = br.readLine()) != null) {
				ArrayList<ProcessClient> list = ss.getList();
				for (ProcessClient pc : list) {
					PrintWriter pw = pc.getPw();
					
					pw.println(line);
					pw.flush();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
