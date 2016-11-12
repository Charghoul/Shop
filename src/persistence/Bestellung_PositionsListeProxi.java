package persistence;

import model.*;

import java.util.Iterator;

public class Bestellung_PositionsListeProxi extends PersistentListProxi<Position4Public> {

  	private PositionList list;
  	private Bestellung owner;

  	public Bestellung_PositionsListeProxi(Bestellung owner) {
    	this.owner = owner;
  	}
  	public PositionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new PositionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theBestellungFacade.positionsListeGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
        	               	.positionsListeAdd(owner.getId(), entry);
      		}
      		list.add((Position4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theBestellungFacade.positionsListeRem(entry.getListEntryId());
    	}
    	
  	}
  	public Bestellung_PositionsListeProxi copy(Bestellung owner) throws PersistenceException {
  		Bestellung_PositionsListeProxi result = new Bestellung_PositionsListeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Position4Public> entries = (this.list == null ? new java.util.Vector<Position4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Position4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
            	           .positionsListeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
