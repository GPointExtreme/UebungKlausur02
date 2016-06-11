
public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private String jahrgang;
	private String geburtsdatum;
	
	public Student(int id, String name, String jahrgang, String geburtsdatum) {
		super();
		this.id = id;
		this.name = name;
		this.jahrgang = jahrgang;
		this.geburtsdatum = geburtsdatum;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", jahrgang=" + jahrgang + ", geburtsdatum=" + geburtsdatum
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJahrgang() {
		return jahrgang;
	}

	public void setJahrgang(String jahrgang) {
		this.jahrgang = jahrgang;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	@Override
	public int compareTo(Student o) {
		int i = this.name.compareTo(o.name);
		if(i != 0) {
			return i;
		}
		else {
			if(this.id < o.id) {
				return -1;
			}
			else if(this.id > o.id){
				return 1;
			}
		}
		return 0;
	}

}
