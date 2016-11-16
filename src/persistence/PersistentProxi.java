package persistence;

import java.util.HashMap;

import common.ProxiInformation;
import common.RPCConstantsAndServices;

abstract class ProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId);
}
abstract class ListProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot implements PersistentProxiInterface {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[188];
        listProxiFactories[111] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new VerkaufListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[186] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelEntfernenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[90] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new EinkaufsManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[112] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AuslaufListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[148] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new FalseXListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BestellungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[187] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelEntnehmenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[171] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HerstellerManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new LieferartListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[99] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RegisterCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[155] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AendereArtikelCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[113] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NeuanlageListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[88] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceRegisterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[185] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelEinlagernCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[114] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new GeliefertListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[80] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceKundeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[166] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProduktgruppeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new PositionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[81] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceAdminListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[127] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[160] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StatusAuslaufCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[163] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NeuerArtikelCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[159] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StatusVerkaufCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KontoListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[115] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new VorbestellungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KundeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[169] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HerstellerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[116] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RueckversandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[97] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new LieferartManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[184] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProdGEntfernenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[117] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HinversandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[118] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AngenommenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[49] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new LieferungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[92] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new WarenlagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[8] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[9] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[150] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TrueXListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [188];
        proxiFactories[111] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new VerkaufProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[186] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelEntfernenCommandProxi(objectId);
            }
        };
        proxiFactories[90] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new EinkaufsManagerProxi(objectId);
            }
        };
        proxiFactories[112] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AuslaufProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[148] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new FalseXProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BestellungProxi(objectId);
            }
        };
        proxiFactories[187] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelEntnehmenCommandProxi(objectId);
            }
        };
        proxiFactories[171] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HerstellerManagerProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new LieferartProxi(objectId);
            }
        };
        proxiFactories[99] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RegisterCommandProxi(objectId);
            }
        };
        proxiFactories[155] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AendereArtikelCommandProxi(objectId);
            }
        };
        proxiFactories[113] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NeuanlageProxi(objectId);
            }
        };
        proxiFactories[88] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceRegisterProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[185] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelEinlagernCommandProxi(objectId);
            }
        };
        proxiFactories[114] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new GeliefertProxi(objectId);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceKundeProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelProxi(objectId);
            }
        };
        proxiFactories[166] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProduktgruppeProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new PositionProxi(objectId);
            }
        };
        proxiFactories[81] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceAdminProxi(objectId);
            }
        };
        proxiFactories[127] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelManagerProxi(objectId);
            }
        };
        proxiFactories[160] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StatusAuslaufCommandProxi(objectId);
            }
        };
        proxiFactories[163] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NeuerArtikelCommandProxi(objectId);
            }
        };
        proxiFactories[159] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StatusVerkaufCommandProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KontoProxi(objectId);
            }
        };
        proxiFactories[115] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new VorbestellungProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KundeProxi(objectId);
            }
        };
        proxiFactories[169] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HerstellerProxi(objectId);
            }
        };
        proxiFactories[116] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RueckversandProxi(objectId);
            }
        };
        proxiFactories[97] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new LieferartManagerProxi(objectId);
            }
        };
        proxiFactories[184] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProdGEntfernenCommandProxi(objectId);
            }
        };
        proxiFactories[117] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HinversandProxi(objectId);
            }
        };
        proxiFactories[118] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AngenommenProxi(objectId);
            }
        };
        proxiFactories[49] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new LieferungProxi(objectId);
            }
        };
        proxiFactories[92] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new WarenlagerProxi(objectId);
            }
        };
        proxiFactories[8] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[9] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[150] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TrueXProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxiInterface createProxi(ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxiInterface resultDecorator = (PersistentProxiInterface) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxiInterface createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
    if (classId == RPCConstantsAndServices.NullClassID) return null; 
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxiInterface result =  (PersistentProxiInterface)factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  (PersistentListEntryProxi)factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO (GOJA) Still needed for Decorator???
		super(object.getId());
		this.object = object;
		this.object.incrementUserCount();
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

	public void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
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
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	public Anything getThis() throws PersistenceException {
		return this.getTheObject().getThis();
	}
	
	
    	
	
	public void finalize(){
		if (this.object != null)this.object.decrementUserCount();
	}
}
