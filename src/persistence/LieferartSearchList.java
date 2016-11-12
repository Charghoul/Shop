package persistence;

public class LieferartSearchList extends SearchListRoot<Lieferart4Public> implements Iterable<Lieferart4Public> {

	public LieferartSearchList(SearchListRoot<Lieferart4Public> list){
		super(list);
	}
	public LieferartSearchList(){
		super();
	}
	
	public void add (Lieferart4Public entry) {
		this.data.add(entry);
	}
	
	public void add(LieferartSearchList list) throws PersistenceException{
		java.util.Iterator<Lieferart4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Lieferart4Public> iterator() {
		return this.data.iterator();
	}
  	public LieferartSearchList copy() throws PersistenceException {
  		LieferartSearchList result = new LieferartSearchList();
  		result.add(this);
  		return result;
  	}
}


