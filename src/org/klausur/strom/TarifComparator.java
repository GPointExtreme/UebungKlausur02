package org.klausur.strom;

import java.util.Comparator;

public class TarifComparator implements Comparator<Stromverbrauch> {

	public TarifComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Stromverbrauch o1, Stromverbrauch o2) {
		if(o1.getTarif() < o2.getTarif()) {
			return -1;
		}
		else if(o1.getTarif() > o2.getTarif()) {
			return 1;
		}
		else {
			int i = o1.getDatum().compareTo(o2.getDatum());
			if(i != 0) {
				return i;
			}
		}
		return 0;
	}

}
