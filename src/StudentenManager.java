import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StudentenManager {
	
	private static Object lock = new Object();
	
	public ArrayList<Student> load(String jahrgang) throws DataFileException {
		synchronized (lock) {
			File file = new File("C://temp//"+jahrgang+".txt");
			ArrayList<Student> list = new ArrayList<>();
			try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);	
				) {
				String line;
				while((line=br.readLine()) != null) {
					String[] array = line.split(",");
					list.add(new Student(Integer.parseInt(array[0]), array[1], array[2], array[3]));
				}
			} catch (FileNotFoundException e) {
				new DataFileException(e);
			} catch (IOException e) {
				new DataFileException(e);
			}
			Collections.sort(list, new GeburtsdatumComparator());
			return list;
		}
	}
}
