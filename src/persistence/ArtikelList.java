package persistence;

import java.util.*;

public class ArtikelList  extends ArtikelSearchList{

	protected ArtikelList() {
		super();
	}
	public Iterator<Artikel4Public> iterator(PersistentListProxi<Artikel4Public> listProxi) {
		return new PersistentListIterator<Artikel4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Artikel4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ArtikelList copy() {
		ArtikelList result = new ArtikelList();
		result.data = (Vector<Artikel4Public>)this.data.clone();
		return result;
	}


}


