package cartes;

public abstract class Limite extends Carte {

	public Limite(int nombreCarte) {
		super(nombreCarte);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    return true;
	}

}
