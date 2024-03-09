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

	public int getNombreCarte() {
		return nombreCarte;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }else {
	    	return true;
	    }
	}
	
}
