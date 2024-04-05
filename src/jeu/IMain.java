package jeu;
import java.util.*;
import cartes.*;

public interface IMain {
	
void prendre(Carte carte);

void jouer(Carte carte);

Iterator<Carte> iterator();

}
