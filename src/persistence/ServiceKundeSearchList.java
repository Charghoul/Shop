package persistence;

public class ServiceKundeSearchList extends SearchListRoot<ServiceKunde4Public> implements Iterable<ServiceKunde4Public> {

	public ServiceKundeSearchList(SearchListRoot<ServiceKunde4Public> list){
		super(list);
	}
	public ServiceKundeSearchList(){
		super();
	}
	
	public void add (ServiceKunde4Public entry) {
		this.data.add(entry);
	}
	
	public void add(ServiceKundeSearchList list) throws PersistenceException{
		java.util.Iterator<ServiceKunde4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ServiceKunde4Public> iterator() {
		return this.data.iterator();
	}
  	public ServiceKundeSearchList copy() throws PersistenceException {
  		ServiceKundeSearchList result = new ServiceKundeSearchList();
  		result.add(this);
  		return result;
  	}
}


