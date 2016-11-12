package persistence;

public class ArtikelManagerListEntryProxi extends ArtikelManagerProxi implements PersistentArtikelManagerListEntryProxi {

  long entryId;

  public ArtikelManagerListEntryProxi(long objectId, long entryId) {
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