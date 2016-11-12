package persistence;

public class AuslaufListEntryProxi extends AuslaufProxi implements PersistentAuslaufListEntryProxi {

  long entryId;

  public AuslaufListEntryProxi(long objectId, long entryId) {
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