package org.klausur.strom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ServerConsole implements Runnable {
	
	StromServer ss = new StromServer();

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
