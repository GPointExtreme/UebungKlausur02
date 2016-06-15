package org.klausur.strom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StromRepository {

	public ArrayList<Stromverbrauch> load(String kundenNr, String datumVon, String datumBis) throws DataFileException {
		ArrayList<Stromverbrauch> list = new ArrayList<>();
		File file = new File("C://temp//data.txt");
		
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(",");
				if(array[1].equals(kundenNr)) {
					if(array[2].compareTo(datumVon) >= 0) {
						if(array[2].compareTo(datumBis) <= 0) {
							char c = array[4].charAt(0);
							list.add(new Stromverbrauch(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), c));
						}
					}
				}
			}
		} catch (IOException e) {
			throw new DataFileException(e);
		}
		return list;
	}

}
