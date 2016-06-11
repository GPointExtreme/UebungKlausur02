import java.util.Comparator;

public class GeburtsdatumComparator implements Comparator<Student> {

	public GeburtsdatumComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Student o1, Student o2) {
		int i = o1.getGeburtsdatum().compareTo(o2.getGeburtsdatum());
		if(i != 0) {
			return i;
		}
		else {
			int j = o1.getName().compareTo(o2.getName());
			if(i != 0) {
				return j;
			}
		}
		return 0;
	}

}
