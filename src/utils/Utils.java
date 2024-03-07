package utils;

import java.util.List;
import java.util.Random;
import java.util.ListIterator;

public class Utils {
	
	public static <E> E extraire(List<E> liste) {
		if (liste.isEmpty()) {
	        return null;
	    }
		int index = new Random().nextInt(liste.size());
		return liste.remove(index);
	}
	
	public static <E> E extraireIterator(List<E> liste) {
		if (liste.isEmpty()) {
	        return null;
	    }
		int index = new Random().nextInt(liste.size());
		E obj = null;
		int i = 0;
		for (ListIterator<E> iterator = liste.listIterator();i <= index;) {
			obj = iterator.next();
			if (i == index) {
				iterator.remove();
			}
			i++;
		}
		return obj;
	}
	
	public static <E> List<E> melanger(List<E> liste) {
		for (ListIterator<E> iterator = liste.listIterator();iterator.hasNext();) {
			iterator.next();
			iterator.remove();
		}
		return liste;
	}
	
	
}
