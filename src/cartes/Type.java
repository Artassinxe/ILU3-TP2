package cartes;

public enum Type {
	FEU, ESSENCE, CREVAISON, ACCIDENT,VITESSE;

	@Override
	public String toString() {
		switch (this) {
		case FEU:
			return "Feu";
		case ESSENCE:
			return "Essence";
		case CREVAISON:
			return "Crevaison";
		case ACCIDENT:
			return "Accident";
		default:
			return "Type non défini";
		}
	}
}
