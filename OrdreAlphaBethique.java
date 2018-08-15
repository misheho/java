package revisions;

import java.util.Comparator;

public class OrdreAlphaBethique implements Comparator<Contact> {	
	public int compare(Contact c1, Contact c2) {
		return (c1.getNom().compareTo(c2.getNom()));
	}

}
