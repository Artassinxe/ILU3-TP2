package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Attaque : ");
		switch (this.getType()) {
		case FEU:
			sb.append("Le feu devient rouge");
			break;
		case ESSENCE:
			sb.append("Oups, plus d'essence");
			break;
		case CREVAISON:
			sb.append("Un pneu crevé et un !");
			break;
		case ACCIDENT:
			sb.append("Votre véhicule est accidenté");
			break;
		default:
			sb.append("non valide");
		}
		return sb.toString();
	}

}
