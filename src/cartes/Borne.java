package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombreCarte, int km) {
		super(nombreCarte);
		this.km = km;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Borne à ");
		sb.append(this.km);
		sb.append(" km");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
	    Borne toCompare = (Borne) obj;
	    return this.km == toCompare.km;
	}
	
	public int getKm() {
		return this.km;
	}

}
