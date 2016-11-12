package persistence;

public class EinkaufsManagerListEntryProxi extends EinkaufsManagerProxi implements PersistentEinkaufsManagerListEntryProxi {

  long entryId;

  public EinkaufsManagerListEntryProxi(long objectId, long entryId) {
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