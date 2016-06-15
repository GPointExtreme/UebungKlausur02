package org.klausur.strom;

public class Stromverbrauch {
	
	private int id;
	private String kundenNummer;
	private String datum;
	private int verbrauchInKwH;
	private char tarif;
	
	public Stromverbrauch(int id, String kundenNummer, String datum, int verbrauchInKwH, char tarif) {
		super();
		this.id = id;
		this.kundenNummer = kundenNummer;
		this.datum = datum;
		this.verbrauchInKwH = verbrauchInKwH;
		this.tarif = tarif;
	}

	public double calcPreis() {
		double betrag = 0;
		switch (tarif) {
		case 'A':
			return betrag = verbrauchInKwH * 0.24;
		case 'B':
			return betrag = verbrauchInKwH * 0.15;
		case 'C':
			return betrag = verbrauchInKwH * 0.12;
		default:
			return betrag;
		}
	}
	
	@Override
	public String toString() {
		return "Stromverbrauch [id=" + id + ", kundenNummer=" + kundenNummer + ", datum=" + datum + ", verbrauchInKwH="
				+ verbrauchInKwH + ", tarif=" + tarif + ", calcPreis()=" + calcPreis() + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKundenNummer() {
		return kundenNummer;
	}
	public void setKundenNummer(String kundenNummer) {
		this.kundenNummer = kundenNummer;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public int getVerbrauchInKwH() {
		return verbrauchInKwH;
	}
	public void setVerbrauchInKwH(int verbrauchInKwH) {
		this.verbrauchInKwH = verbrauchInKwH;
	}
	public char getTarif() {
		return tarif;
	}
	public void setTarif(char tarif) {
		this.tarif = tarif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id;
		result = prime * result + ((kundenNummer == null) ? 0 : kundenNummer.hashCode());
		result = prime * result + tarif;
		result = prime * result + verbrauchInKwH;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stromverbrauch other = (Stromverbrauch) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id != other.id)
			return false;
		if (kundenNummer == null) {
			if (other.kundenNummer != null)
				return false;
		} else if (!kundenNummer.equals(other.kundenNummer))
			return false;
		if (tarif != other.tarif)
			return false;
		if (verbrauchInKwH != other.verbrauchInKwH)
			return false;
		return true;
	}

}
