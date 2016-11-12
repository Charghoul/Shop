package persistence;

public class ServiceRegisterListEntryProxi extends ServiceRegisterProxi implements PersistentServiceRegisterListEntryProxi {

  long entryId;

  public ServiceRegisterListEntryProxi(long objectId, long entryId) {
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