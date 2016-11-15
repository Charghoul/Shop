package persistence;

import java.util.HashMap;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[182];
        iCProxiFactories[111] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new VerkaufICProxi(objectId);
            }
        };
        iCProxiFactories[2] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[90] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new EinkaufsManagerICProxi(objectId);
            }
        };
        iCProxiFactories[112] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AuslaufICProxi(objectId);
            }
        };
        iCProxiFactories[3] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[148] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FalseXICProxi(objectId);
            }
        };
        iCProxiFactories[35] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BestellungICProxi(objectId);
            }
        };
        iCProxiFactories[157] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelEntnehmenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[171] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HerstellerManagerICProxi(objectId);
            }
        };
        iCProxiFactories[37] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LieferartICProxi(objectId);
            }
        };
        iCProxiFactories[99] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RegisterCommandICProxi(objectId);
            }
        };
        iCProxiFactories[155] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AendereArtikelCommandICProxi(objectId);
            }
        };
        iCProxiFactories[113] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NeuanlageICProxi(objectId);
            }
        };
        iCProxiFactories[88] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceRegisterICProxi(objectId);
            }
        };
        iCProxiFactories[0] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[114] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new GeliefertICProxi(objectId);
            }
        };
        iCProxiFactories[80] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceKundeICProxi(objectId);
            }
        };
        iCProxiFactories[7] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelICProxi(objectId);
            }
        };
        iCProxiFactories[166] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProduktgruppeICProxi(objectId);
            }
        };
        iCProxiFactories[43] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PositionICProxi(objectId);
            }
        };
        iCProxiFactories[81] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceAdminICProxi(objectId);
            }
        };
        iCProxiFactories[127] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelManagerICProxi(objectId);
            }
        };
        iCProxiFactories[160] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StatusAuslaufCommandICProxi(objectId);
            }
        };
        iCProxiFactories[163] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NeuerArtikelCommandICProxi(objectId);
            }
        };
        iCProxiFactories[159] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StatusVerkaufCommandICProxi(objectId);
            }
        };
        iCProxiFactories[45] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KontoICProxi(objectId);
            }
        };
        iCProxiFactories[115] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new VorbestellungICProxi(objectId);
            }
        };
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KundeICProxi(objectId);
            }
        };
        iCProxiFactories[169] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HerstellerICProxi(objectId);
            }
        };
        iCProxiFactories[116] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RueckversandICProxi(objectId);
            }
        };
        iCProxiFactories[97] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LieferartManagerICProxi(objectId);
            }
        };
        iCProxiFactories[117] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HinversandICProxi(objectId);
            }
        };
        iCProxiFactories[118] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AngenommenICProxi(objectId);
            }
        };
        iCProxiFactories[49] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LieferungICProxi(objectId);
            }
        };
        iCProxiFactories[92] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new WarenlagerICProxi(objectId);
            }
        };
        iCProxiFactories[8] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[9] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[150] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TrueXICProxi(objectId);
            }
        };
		}
		return iCProxiFactories;
	  }

	public static PersistentInCacheProxi createInCacheProxi(long objectId, long classId) throws PersistenceException {
	    int index = (int) classId;
		if (index < 0) index = index * -1;
	    index = index - 101;
	    if (index > getTheICProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    ICProxiFactory factory = getTheICProxiFactories()[index];
	    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    PersistentInCacheProxi result =  factory.create(objectId);
	    return result;
	}

	protected PersistentObject object;
  	public int userCount;
	
	protected PersistentInCacheProxi(long id) {
		super(id);
		this.userCount = 0;
	}

	public PersistentInCacheProxi(PersistentObject object) {
		this(object.getId());
	}
	
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}

	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	protected abstract PersistentObject getRemote() throws PersistenceException;

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) this.object = getRemote();
		return this.object;
	}		
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		this.object = object;
	}
	protected synchronized void clear() throws PersistenceException {
		this.object = null;
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}

	public synchronized void incrementUserCount() {
		this.userCount++;
	}

	public static long recycleCounter = 0;
	public synchronized void decrementUserCount() {
		this.userCount--;
		if (this.isRemovable()){
			Cache.getTheCache().remove(this);
			PersistentInCacheProxi.recycleCounter ++;
		}
	}

	protected boolean isRemovable() {
		return this.userCount <= 0 ;
	}
	public synchronized void tryBreak() {
		try {
			if (!this.isDelayed$Persistence())this.object = null;
		} catch (PersistenceException e) {
			return;
		}
	}

	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	public Anything getThis() throws PersistenceException {
		return this.getTheObject().getThis();
	}
	
    
}
