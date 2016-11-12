package persistence;

import model.*;

import java.util.Iterator;

public class ArtikelManager_ArtikelListeProxi extends PersistentListProxi<Artikel4Public> {

  	private ArtikelList list;
  	private ArtikelManager owner;

  	public ArtikelManager_ArtikelListeProxi(ArtikelManager owner) {
    	this.owner = owner;
  	}
  	public ArtikelList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ArtikelList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theArtikelManagerFacade.artikelListeGet(this.owner.getId());
      		}
      		this.data = this.list.data;
    	}
    	return this.list;
  	}
  	public Iterator<Artikel4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Artikel4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ArtikelList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
        	               	.artikelListeAdd(owner.getId(), entry);
      		}
      		list.add((Artikel4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade.artikelListeRem(entry.getListEntryId());
    	}
    	
  	}
  	public ArtikelManager_ArtikelListeProxi copy(ArtikelManager owner) throws PersistenceException {
  		ArtikelManager_ArtikelListeProxi result = new ArtikelManager_ArtikelListeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Artikel4Public> entries = (this.list == null ? new java.util.Vector<Artikel4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Artikel4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theArtikelManagerFacade
            	           .artikelListeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
