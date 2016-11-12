package persistence;

public class NeuanlageListEntryProxi extends NeuanlageProxi implements PersistentNeuanlageListEntryProxi {

  long entryId;

  public NeuanlageListEntryProxi(long objectId, long entryId) {
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