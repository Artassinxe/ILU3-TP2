package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

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
		ListIterator<E> iterator = liste.listIterator();
		for (int i = 0;i <= index;i++) { 
			obj = iterator.next();
			if (i == index) {
				iterator.remove();
			}
		}
		return obj;
	}
	
	public static <E> List<E> melanger(List<E> liste) {
		List<E> result = new ArrayList<>();
		while(!liste.isEmpty()) {
			result.add(Utils.extraire(liste));
		}
		return result;
	}
	
	public static <E> Boolean verifierMelange(List<E> liste1, List<E> liste2) {
		if (liste1.size() != liste2.size())
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
	    for (E obj : liste) {
	    	int lastIndex = newList.lastIndexOf(obj);
	    	if (lastIndex!=-1) newList.add(lastIndex, obj);
	    	else newList.add(obj);
	    }
	    return newList;
	}
	
	public static <E> Boolean verifierRassemblement(List<E> liste) {
		E obj = null;
		E nextObj = null;
		ListIterator<E> iterator = liste.listIterator();
		if(!iterator.hasNext()) return true;
		obj = iterator.next();
		
		while(iterator.hasNext()) { 
			nextObj = iterator.next();
			if (!obj.equals(nextObj)) {
				ListIterator<E> iterator2 = liste.listIterator(iterator.nextIndex());
				while(iterator2.hasNext()) {
					if(iterator2.next().equals(obj)) return false;
				}
			}
			obj = nextObj;
		}
		
		return true;
	}
	
}
