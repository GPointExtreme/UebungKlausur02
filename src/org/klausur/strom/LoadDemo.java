package org.klausur.strom;

import java.util.ArrayList;

public class LoadDemo {

	public static void main(String[] args) {
		StromRepository sr = new StromRepository();
		
		try {
			ArrayList<Stromverbrauch> list = sr.load("0001", "2013-01-01", "2017-01-01");
			
			for (Stromverbrauch stromverbrauch : list) {
				System.out.println(stromverbrauch.toString());
			}
		} catch (DataFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
