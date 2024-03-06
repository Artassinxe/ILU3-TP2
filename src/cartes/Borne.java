package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombreCarte, int km) {
		super(nombreCarte);
		this.km = km;
	}

	@Override
	public String toString() {
		return "Borne " + this.km + " km n°" + this.nombreCarte;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Borne toCompare = (Borne) obj;
	    return this.km == toCompare.km;
	}

}
