package modelo;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Nota> {

	
	@Override

	public int compare(Nota o1, Nota o2) {
		
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
