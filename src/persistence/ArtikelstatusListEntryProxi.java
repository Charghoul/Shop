package persistence;

public abstract class ArtikelstatusListEntryProxi extends ArtikelstatusProxi implements PersistentArtikelstatusListEntryProxi {

  long entryId;

  public ArtikelstatusListEntryProxi(long objectId, long entryId) {
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