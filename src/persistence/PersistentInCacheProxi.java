package persistence;

import java.util.HashMap;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[177];
        iCProxiFactories[0] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelEntfernenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[2] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new EinkaufsManagerICProxi(objectId);
            }
        };
        iCProxiFactories[3] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[4] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceAdminZeitManagerICProxi(objectId);
            }
        };
        iCProxiFactories[5] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelEntnehmenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[172] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AnnehmenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[6] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HerstellerManagerICProxi(objectId);
            }
        };
        iCProxiFactories[7] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LieferartICProxi(objectId);
            }
        };
        iCProxiFactories[8] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RegisterCommandICProxi(objectId);
            }
        };
        iCProxiFactories[9] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new deactivatedICProxi(objectId);
            }
        };
        iCProxiFactories[10] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NeuanlageICProxi(objectId);
            }
        };
        iCProxiFactories[11] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceRegisterICProxi(objectId);
            }
        };
        iCProxiFactories[12] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[13] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HstLieferungICProxi(objectId);
            }
        };
        iCProxiFactories[173] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AbbuchenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[14] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KndLieferungICProxi(objectId);
            }
        };
        iCProxiFactories[15] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceKundeICProxi(objectId);
            }
        };
        iCProxiFactories[16] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KndAnnahmeICProxi(objectId);
            }
        };
        iCProxiFactories[17] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ZuEinkaufswHinzCommandICProxi(objectId);
            }
        };
        iCProxiFactories[18] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProduktKatalogICProxi(objectId);
            }
        };
        iCProxiFactories[20] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceShopProduktKatalogICProxi(objectId);
            }
        };
        iCProxiFactories[176] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NeuePositionCommandICProxi(objectId);
            }
        };
        iCProxiFactories[21] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelICProxi(objectId);
            }
        };
        iCProxiFactories[22] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProduktgruppeICProxi(objectId);
            }
        };
        iCProxiFactories[24] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PositionICProxi(objectId);
            }
        };
        iCProxiFactories[25] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceAdminKundenManagerICProxi(objectId);
            }
        };
        iCProxiFactories[26] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceAdminICProxi(objectId);
            }
        };
        iCProxiFactories[27] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelManagerICProxi(objectId);
            }
        };
        iCProxiFactories[28] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AendereLieferartNameCommandICProxi(objectId);
            }
        };
        iCProxiFactories[29] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProduktgruppeEntfernenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[30] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StatusVerkaufCommandICProxi(objectId);
            }
        };
        iCProxiFactories[174] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AuszahlenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[31] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KontoICProxi(objectId);
            }
        };
        iCProxiFactories[32] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HerstellerICProxi(objectId);
            }
        };
        iCProxiFactories[33] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AngenommenICProxi(objectId);
            }
        };
        iCProxiFactories[34] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RetourePositionICProxi(objectId);
            }
        };
        iCProxiFactories[35] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ZuruecksendenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[36] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BestellenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[37] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AendereMinLagerbestandCommandICProxi(objectId);
            }
        };
        iCProxiFactories[38] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new WarenlagerICProxi(objectId);
            }
        };
        iCProxiFactories[39] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[171] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AendereBezeichnungCommandICProxi(objectId);
            }
        };
        iCProxiFactories[40] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new VorbestellenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[41] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new VerkaufICProxi(objectId);
            }
        };
        iCProxiFactories[43] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AuslaufICProxi(objectId);
            }
        };
        iCProxiFactories[45] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BestellungICProxi(objectId);
            }
        };
        iCProxiFactories[46] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KundenManagerICProxi(objectId);
            }
        };
        iCProxiFactories[47] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServiceKundeBestellManagerICProxi(objectId);
            }
        };
        iCProxiFactories[48] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AnzeigenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[51] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ZeitManagerZeitObjektListeICProxi(objectId);
            }
        };
        iCProxiFactories[52] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ArtikelEinlagernCommandICProxi(objectId);
            }
        };
        iCProxiFactories[53] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new GeliefertICProxi(objectId);
            }
        };
        iCProxiFactories[175] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AendereHstLieferzeitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[55] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RetoureLieferungICProxi(objectId);
            }
        };
        iCProxiFactories[59] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BestellManagerICProxi(objectId);
            }
        };
        iCProxiFactories[60] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StatusAuslaufCommandICProxi(objectId);
            }
        };
        iCProxiFactories[61] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NeuerArtikelCommandICProxi(objectId);
            }
        };
        iCProxiFactories[62] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ZeitManagerICProxi(objectId);
            }
        };
        iCProxiFactories[63] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SubjICProxi(objectId);
            }
        };
        iCProxiFactories[64] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SuchManagerICProxi(objectId);
            }
        };
        iCProxiFactories[65] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new VorbestellungICProxi(objectId);
            }
        };
        iCProxiFactories[66] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PositionInBestellungICProxi(objectId);
            }
        };
        iCProxiFactories[67] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new KundeICProxi(objectId);
            }
        };
        iCProxiFactories[68] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RueckversandICProxi(objectId);
            }
        };
        iCProxiFactories[69] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AendereMaxLagerbestandCommandICProxi(objectId);
            }
        };
        iCProxiFactories[70] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LieferartManagerICProxi(objectId);
            }
        };
        iCProxiFactories[71] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HinversandICProxi(objectId);
            }
        };
        iCProxiFactories[72] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AllesZuruecksendenCommandICProxi(objectId);
            }
        };
        iCProxiFactories[74] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[75] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new activatedICProxi(objectId);
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
	
    protected void setDltd() throws PersistenceException {
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }

}
