package persistence;

public class WarenlagerListEntryProxi extends WarenlagerProxi implements PersistentWarenlagerListEntryProxi {

  long entryId;

  public WarenlagerListEntryProxi(long objectId, long entryId) {
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