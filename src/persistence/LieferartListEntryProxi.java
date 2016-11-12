package persistence;

public class LieferartListEntryProxi extends LieferartProxi implements PersistentLieferartListEntryProxi {

  long entryId;

  public LieferartListEntryProxi(long objectId, long entryId) {
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