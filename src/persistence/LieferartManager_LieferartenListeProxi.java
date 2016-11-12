package persistence;

import model.*;

import java.util.Iterator;

public class LieferartManager_LieferartenListeProxi extends PersistentListProxi<Lieferart4Public> {

  	private LieferartList list;
  	private LieferartManager owner;

  	public LieferartManager_LieferartenListeProxi(LieferartManager owner) {
    	this.owner = owner;
  	}
  	public LieferartList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new LieferartList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theLieferartManagerFacade.lieferartenListeGet(this.owner.getId());
      		}
      		this.data = this.list.data;
    	}
    	return this.list;
  	}
  	public Iterator<Lieferart4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Lieferart4Public entry) throws PersistenceException {
    	if (entry != null) {
      		LieferartList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
        	               	.lieferartenListeAdd(owner.getId(), entry);
      		}
      		list.add((Lieferart4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade.lieferartenListeRem(entry.getListEntryId());
    	}
    	
  	}
  	public LieferartManager_LieferartenListeProxi copy(LieferartManager owner) throws PersistenceException {
  		LieferartManager_LieferartenListeProxi result = new LieferartManager_LieferartenListeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Lieferart4Public> entries = (this.list == null ? new java.util.Vector<Lieferart4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Lieferart4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theLieferartManagerFacade
            	           .lieferartenListeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
