package persistence;

public class GeliefertListEntryProxi extends GeliefertProxi implements PersistentGeliefertListEntryProxi {

  long entryId;

  public GeliefertListEntryProxi(long objectId, long entryId) {
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