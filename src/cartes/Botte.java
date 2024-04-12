package cartes;

import java.util.HashMap;
import java.util.Map;

public class Botte extends Probleme {

	public Botte(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}
	
	private static final Map<Type, String> BOTTES;

    static {
        BOTTES = new HashMap<>();
        BOTTES.put(Type.ACCIDENT, "As du volant");
        BOTTES.put(Type.CREVAISON, "Increvable");
        BOTTES.put(Type.ESSENCE, "Citerne d'essence");
        BOTTES.put(Type.FEU, "Véhicule prioritaire");
        BOTTES.put(Type.VITESSE, "Véhicule prioritaire");
    }

    @Override
    public String toString() {
        return BOTTES.get(getType());
    }

}
