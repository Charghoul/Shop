package persistence;

import java.util.*;

public class LieferartList  extends LieferartSearchList{

	protected LieferartList() {
		super();
	}
	public Iterator<Lieferart4Public> iterator(PersistentListProxi<Lieferart4Public> listProxi) {
		return new PersistentListIterator<Lieferart4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Lieferart4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public LieferartList copy() {
		LieferartList result = new LieferartList();
		result.data = (Vector<Lieferart4Public>)this.data.clone();
		return result;
	}


}


