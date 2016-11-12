package persistence;

public class KundeSearchList extends SearchListRoot<Kunde4Public> implements Iterable<Kunde4Public> {

	public KundeSearchList(SearchListRoot<Kunde4Public> list){
		super(list);
	}
	public KundeSearchList(){
		super();
	}
	
	public void add (Kunde4Public entry) {
		this.data.add(entry);
	}
	
	public void add(KundeSearchList list) throws PersistenceException{
		java.util.Iterator<Kunde4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Kunde4Public> iterator() {
		return this.data.iterator();
	}
  	public KundeSearchList copy() throws PersistenceException {
  		KundeSearchList result = new KundeSearchList();
  		result.add(this);
  		return result;
  	}
}


