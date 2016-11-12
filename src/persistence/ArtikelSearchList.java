package persistence;

public class ArtikelSearchList extends SearchListRoot<Artikel4Public> implements Iterable<Artikel4Public> {

	public ArtikelSearchList(SearchListRoot<Artikel4Public> list){
		super(list);
	}
	public ArtikelSearchList(){
		super();
	}
	
	public void add (Artikel4Public entry) {
		this.data.add(entry);
	}
	
	public void add(ArtikelSearchList list) throws PersistenceException{
		java.util.Iterator<Artikel4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Artikel4Public> iterator() {
		return this.data.iterator();
	}
  	public ArtikelSearchList copy() throws PersistenceException {
  		ArtikelSearchList result = new ArtikelSearchList();
  		result.add(this);
  		return result;
  	}
}


