package persistence;

public class ArtikelListEntryProxi extends ArtikelProxi implements PersistentArtikelListEntryProxi {

  long entryId;

  public ArtikelListEntryProxi(long objectId, long entryId) {
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