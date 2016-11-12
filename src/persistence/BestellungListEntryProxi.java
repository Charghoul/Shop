package persistence;

public class BestellungListEntryProxi extends BestellungProxi implements PersistentBestellungListEntryProxi {

  long entryId;

  public BestellungListEntryProxi(long objectId, long entryId) {
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