package cartes;

public class Botte extends Probleme {

	public Botte(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Botte : ");
		switch (this.getType()) {
		case FEU:
			sb.append("Vous êtes désormais un véhicule prioritaire");
			break;
		case ESSENCE:
			sb.append("Immunité contre les pannes d'essence");
			break;
		case CREVAISON:
			sb.append("Immunité contre les crevaisons");
			break;
		case ACCIDENT:
			sb.append("Vous êtes un as du volant, fini les accidents");
			break;
		default:
			sb.append("non valide");
		}
		return sb.toString();
	}

}
