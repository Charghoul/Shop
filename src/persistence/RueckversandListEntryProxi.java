package persistence;

public class RueckversandListEntryProxi extends RueckversandProxi implements PersistentRueckversandListEntryProxi {

  long entryId;

  public RueckversandListEntryProxi(long objectId, long entryId) {
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