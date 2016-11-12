package persistence;

import model.*;

import java.util.Iterator;

public class Warenlager_WarenListeProxi extends PersistentListProxi<Position4Public> {

  	private PositionList list;
  	private Warenlager owner;

  	public Warenlager_WarenListeProxi(Warenlager owner) {
    	this.owner = owner;
  	}
  	public PositionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new PositionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theWarenlagerFacade.warenListeGet(this.owner.getId());
      		}
      		this.data = this.list.data;
    	}
    	return this.list;
  	}
  	public Iterator<Position4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Position4Public entry) throws PersistenceException {
    	if (entry != null) {
      		PositionList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade
        	               	.warenListeAdd(owner.getId(), entry);
      		}
      		list.add((Position4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade.warenListeRem(entry.getListEntryId());
    	}
    	
  	}
  	public Warenlager_WarenListeProxi copy(Warenlager owner) throws PersistenceException {
  		Warenlager_WarenListeProxi result = new Warenlager_WarenListeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Position4Public> entries = (this.list == null ? new java.util.Vector<Position4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Position4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theWarenlagerFacade
            	           .warenListeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
