package cartes;

public class Parade extends Bataille {

	public Parade(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Parade : ");
		sb.append(this.getType().toString());
		return sb.toString();
	}

}
