package persistence;

public class ServiceAdminSearchList extends SearchListRoot<ServiceAdmin4Public> implements Iterable<ServiceAdmin4Public> {

	public ServiceAdminSearchList(SearchListRoot<ServiceAdmin4Public> list){
		super(list);
	}
	public ServiceAdminSearchList(){
		super();
	}
	
	public void add (ServiceAdmin4Public entry) {
		this.data.add(entry);
	}
	
	public void add(ServiceAdminSearchList list) throws PersistenceException{
		java.util.Iterator<ServiceAdmin4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ServiceAdmin4Public> iterator() {
		return this.data.iterator();
	}
  	public ServiceAdminSearchList copy() throws PersistenceException {
  		ServiceAdminSearchList result = new ServiceAdminSearchList();
  		result.add(this);
  		return result;
  	}
}


