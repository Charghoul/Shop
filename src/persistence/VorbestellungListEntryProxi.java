package persistence;

public class VorbestellungListEntryProxi extends VorbestellungProxi implements PersistentVorbestellungListEntryProxi {

  long entryId;

  public VorbestellungListEntryProxi(long objectId, long entryId) {
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