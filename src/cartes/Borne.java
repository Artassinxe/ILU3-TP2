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

}
