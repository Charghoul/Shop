package persistence;

public class LieferartManagerListEntryProxi extends LieferartManagerProxi implements PersistentLieferartManagerListEntryProxi {

  long entryId;

  public LieferartManagerListEntryProxi(long objectId, long entryId) {
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