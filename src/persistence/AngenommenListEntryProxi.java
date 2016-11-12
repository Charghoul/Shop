package persistence;

public class AngenommenListEntryProxi extends AngenommenProxi implements PersistentAngenommenListEntryProxi {

  long entryId;

  public AngenommenListEntryProxi(long objectId, long entryId) {
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