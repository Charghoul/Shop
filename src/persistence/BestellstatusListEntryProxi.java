package persistence;

public abstract class BestellstatusListEntryProxi extends BestellstatusProxi implements PersistentBestellstatusListEntryProxi {

  long entryId;

  public BestellstatusListEntryProxi(long objectId, long entryId) {
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