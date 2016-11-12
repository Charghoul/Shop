package persistence;

import java.util.*;

public class PositionList {

	protected Vector<Position4Public> data; //List of proxies
	protected PositionList() {
		this.data = new Vector<Position4Public>();
	}
	public Iterator<Position4Public> iterator(PersistentListProxi<Position4Public> listProxi) {
		return new PersistentListIterator<Position4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Position4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public PositionList copy() {
		PositionList result = new PositionList();
		result.data = (Vector<Position4Public>)this.data.clone();
		return result;
	}


}


