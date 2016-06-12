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
	
	public ProcessClient(Socket client) {
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
				StudentenManager sm = new StudentenManager();
				String line;
				while((line = br.readLine()) != null) {
					String[] array = line.split(" ");
					if(array.length == 2 && array[0].equals("GET")) {
						try {
							ArrayList<Student> list = sm.load(array[1]);
							for (Student s : list) {
								pw.println(s.toString());
							}
							pw.flush();
						} catch (DataFileException e) {
							e.printStackTrace();
						}
					}
					else if(array.length == 5 && array[0].equals("GET")) {
						try {
							ArrayList<Student> list = sm.load(array[1]);
							Collections.sort(list);
							for (Student s : list) {
								pw.println(s.toString());
							}
							pw.flush();
						} catch (DataFileException e) {
							e.printStackTrace();
						}
					}
					else if(array[0].equals("EXIT")) {
						break;
					}
					else {
						pw.println("wrong input");
						pw.flush();
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
