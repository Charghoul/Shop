package persistence;

public class HinversandListEntryProxi extends HinversandProxi implements PersistentHinversandListEntryProxi {

  long entryId;

  public HinversandListEntryProxi(long objectId, long entryId) {
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