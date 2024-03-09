package cartes;

public class Botte extends Probleme {

	public Botte(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Botte : ");
		sb.append(this.getType().toString());
		return sb.toString();
	}

}
