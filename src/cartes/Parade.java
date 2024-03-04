package cartes;

public class Parade extends Bataille {

	public Parade(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Parade : ");
		switch (this.getType()) {
		case FEU:
			sb.append("Le feu devient vert !");
			break;
		case ESSENCE:
			sb.append("Un camion citerne est en route !");
			break;
		case CREVAISON:
			sb.append("Pneu de secours à votre disposition !");
			break;
		case ACCIDENT:
			sb.append("Une dépanneuse est en route");
			break;
		default:
			sb.append("non valide");
		}
		return sb.toString();
	}

}
