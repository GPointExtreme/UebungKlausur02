package org.klausur.urlaub;

import java.util.Comparator;

public class VonComparator implements Comparator<Urlaub> {

	public VonComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Urlaub o1, Urlaub o2) {
		int i = o1.getVon().compareTo(o2.getVon());
		if(i != 0) {
			return i*-1;
		}
		else {
			int j = o1.getMitarbeiter().compareTo(o2.getMitarbeiter());
			if(j != 0) {
				return j;
			}
		}
		return 0;
	}

}
