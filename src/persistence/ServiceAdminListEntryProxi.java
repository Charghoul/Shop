package persistence;

public class ServiceAdminListEntryProxi extends ServiceAdminProxi implements PersistentServiceAdminListEntryProxi {

  long entryId;

  public ServiceAdminListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}