package cartes;

public abstract class Probleme extends Carte {
	private Type type;

	protected Probleme(int nombreCarte, Type type) {
		super(nombreCarte);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
