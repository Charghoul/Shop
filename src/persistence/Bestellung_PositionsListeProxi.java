package persistence;

import model.*;

import java.util.Iterator;

public class Bestellung_PositionsListeProxi extends PersistentListProxi<PositionInBestellung4Public> {

  	private PositionInBestellungList list;
  	private Bestellung owner;

  	public Bestellung_PositionsListeProxi(Bestellung owner) {
    	this.owner = owner;
  	}
  	public PositionInBestellungList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new PositionInBestellungList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theBestellungFacade.positionsListeGet(this.owner.getId());
      		}
      		this.data = this.list.data;
    	}
    	return this.list;
  	}
  	public Iterator<PositionInBestellung4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PositionInBestellung4Public entry) throws PersistenceException {
    	if (entry != null) {
      		PositionInBestellungList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
        	               	.positionsListeAdd(owner.getId(), entry);
      		}
      		list.add((PositionInBestellung4Public)PersistentProxi.createListEntryProxi(entry.getId(),
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
  		java.util.Iterator<PositionInBestellung4Public> entries = (this.list == null ? new java.util.Vector<PositionInBestellung4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PositionInBestellung4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theBestellungFacade
            	           .positionsListeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
