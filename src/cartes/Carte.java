package cartes;

public abstract class Carte {
	public int nombreCarte;

	public Carte(int nombreCarte) {
		this.nombreCarte = nombreCarte;
	}

	public void setNombreCarte(int nombreCarte) {
		this.nombreCarte = nombreCarte;
	}

	public abstract String toString();
	
}
