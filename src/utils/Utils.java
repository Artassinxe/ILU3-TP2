package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Collections;

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
	
	public static <E> Boolean verifierMelange(List<E> liste1, List<E> liste2) {
		if (liste1.size() != liste2.size() || liste1.isEmpty() || liste2.isEmpty())
			return false;
		List<E> knownObj = new ArrayList<>();
		for (ListIterator<E> iterator = liste1.listIterator();iterator.hasNext();) {
			E obj = iterator.next();
			if (!knownObj.contains(obj)) {
				if (Collections.frequency(liste1, obj) != Collections.frequency(liste2, obj)) 
					return false;
				else knownObj.add(obj);
			}
		}
		return true;
	}
	
	public static <E> List<E> rassembler(List<E> liste) {
	    List<E> newList = new ArrayList<>();
	    int lastIndex = 0;
	    for (E obj : liste) {
	    	lastIndex = newList.lastIndexOf(obj);
	    	if (lastIndex!=-1) newList.add(lastIndex, obj);
	    	else newList.add(obj);
	    }
	    return newList;
	}
	
	public static <E> Boolean verifierRassemblement(List<E> liste) {
		return true;
	}
	
}
