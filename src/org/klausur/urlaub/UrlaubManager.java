package org.klausur.urlaub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UrlaubManager {

	public ArrayList<Urlaub> load(String mitarbeiter) throws DataFileException{
		File file = new File("C://temp//urlaub.txt");
		ArrayList<Urlaub> list = new ArrayList<>();
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(",");
				if(array[1].equals(mitarbeiter)) {
					list.add(new Urlaub(Integer.parseInt(array[0]), array[1], array[2], array[3]));
				}
			}
		} catch (IOException e) {
			throw new DataFileException(e);
		}
		Collections.sort(list, new VonComparator());
		return list;
	}
	
	public ArrayList<Urlaub> loadAll() throws DataFileException{
		File file = new File("C://temp//urlaub.txt");
		ArrayList<Urlaub> list = new ArrayList<>();
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(",");
				list.add(new Urlaub(Integer.parseInt(array[0]), array[1], array[2], array[3]));
			}
		} catch (IOException e) {
			throw new DataFileException(e);
		}
		Collections.sort(list, new VonComparator());
		return list;
	}

}
