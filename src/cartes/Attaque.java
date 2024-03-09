package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Attaque : ");
		sb.append(this.getType().toString());
		return sb.toString();
	}

}
