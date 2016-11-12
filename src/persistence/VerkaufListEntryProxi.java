package persistence;

public class VerkaufListEntryProxi extends VerkaufProxi implements PersistentVerkaufListEntryProxi {

  long entryId;

  public VerkaufListEntryProxi(long objectId, long entryId) {
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