package org.klausur.strom;

import java.util.Comparator;

public class DatumComparator implements Comparator<Stromverbrauch> {

	public DatumComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Stromverbrauch o1, Stromverbrauch o2) {
		int i = o1.getDatum().compareTo(o2.getDatum());
		if(i != 0) {
			return i;
		}
		return 0;
	}

}
