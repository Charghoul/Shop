package persistence;

public class ServiceKundeListEntryProxi extends ServiceKundeProxi implements PersistentServiceKundeListEntryProxi {

  long entryId;

  public ServiceKundeListEntryProxi(long objectId, long entryId) {
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