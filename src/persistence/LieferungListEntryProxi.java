package persistence;

public abstract class LieferungListEntryProxi extends LieferungProxi implements PersistentLieferungListEntryProxi {

  long entryId;

  public LieferungListEntryProxi(long objectId, long entryId) {
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