package cartes;

public abstract class Carte {
	public int nombreCarte;

	public Carte(int nombreCarte) {
		this.nombreCarte = nombreCarte;
	}

	public int getNombreCarte() {
		return nombreCarte;
	}

	public void setNombreCarte(int nombreCarte) {
		this.nombreCarte = nombreCarte;
	}

	public abstract String toString();
	
}
