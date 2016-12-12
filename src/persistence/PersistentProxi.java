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
		listProxiFactories = new ListProxiFactory[177];
        listProxiFactories[0] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelEntfernenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new EinkaufsManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceAdminZeitManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[5] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelEntnehmenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[172] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AnnehmenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[6] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HerstellerManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new LieferartListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[8] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RegisterCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[9] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new deactivatedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[10] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NeuanlageListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[11] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceRegisterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[12] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HstLieferungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[173] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AbbuchenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KndLieferungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceKundeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[16] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KndAnnahmeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ZuEinkaufswHinzCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProduktKatalogListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceShopProduktKatalogListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[176] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NeuePositionCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[21] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProduktgruppeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[24] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new PositionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceAdminKundenManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[26] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceAdminListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[27] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[28] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AendereLieferartNameCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[29] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProduktgruppeEntfernenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[30] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StatusVerkaufCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[174] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AuszahlenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[31] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KontoListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[32] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HerstellerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[33] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AngenommenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[34] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RetourePositionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ZuruecksendenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[36] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BestellenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AendereMinLagerbestandCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[38] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new WarenlagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[39] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[171] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AendereBezeichnungCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[40] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new VorbestellenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new VerkaufListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AuslaufListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BestellungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[46] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KundenManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[47] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServiceKundeBestellManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[48] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AnzeigenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[51] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ZeitManagerZeitObjektListeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[52] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ArtikelEinlagernCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[53] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new GeliefertListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[175] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AendereHstLieferzeitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[55] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RetoureLieferungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[59] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BestellManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[60] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StatusAuslaufCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[61] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NeuerArtikelCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[62] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ZeitManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[63] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SubjListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[64] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SuchManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[65] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new VorbestellungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[66] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new PositionInBestellungListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[67] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new KundeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[68] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RueckversandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[69] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AendereMaxLagerbestandCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[70] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new LieferartManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[71] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new HinversandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[72] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AllesZuruecksendenCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[74] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[75] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new activatedListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [177];
        proxiFactories[0] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelEntfernenCommandProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new EinkaufsManagerProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceAdminZeitManagerProxi(objectId);
            }
        };
        proxiFactories[5] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelEntnehmenCommandProxi(objectId);
            }
        };
        proxiFactories[172] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AnnehmenCommandProxi(objectId);
            }
        };
        proxiFactories[6] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HerstellerManagerProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new LieferartProxi(objectId);
            }
        };
        proxiFactories[8] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RegisterCommandProxi(objectId);
            }
        };
        proxiFactories[9] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new deactivatedProxi(objectId);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NeuanlageProxi(objectId);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceRegisterProxi(objectId);
            }
        };
        proxiFactories[12] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HstLieferungProxi(objectId);
            }
        };
        proxiFactories[173] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AbbuchenCommandProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KndLieferungProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceKundeProxi(objectId);
            }
        };
        proxiFactories[16] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KndAnnahmeProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ZuEinkaufswHinzCommandProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProduktKatalogProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceShopProduktKatalogProxi(objectId);
            }
        };
        proxiFactories[176] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NeuePositionCommandProxi(objectId);
            }
        };
        proxiFactories[21] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProduktgruppeProxi(objectId);
            }
        };
        proxiFactories[24] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new PositionProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceAdminKundenManagerProxi(objectId);
            }
        };
        proxiFactories[26] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceAdminProxi(objectId);
            }
        };
        proxiFactories[27] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelManagerProxi(objectId);
            }
        };
        proxiFactories[28] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AendereLieferartNameCommandProxi(objectId);
            }
        };
        proxiFactories[29] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProduktgruppeEntfernenCommandProxi(objectId);
            }
        };
        proxiFactories[30] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StatusVerkaufCommandProxi(objectId);
            }
        };
        proxiFactories[174] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AuszahlenCommandProxi(objectId);
            }
        };
        proxiFactories[31] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KontoProxi(objectId);
            }
        };
        proxiFactories[32] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HerstellerProxi(objectId);
            }
        };
        proxiFactories[33] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AngenommenProxi(objectId);
            }
        };
        proxiFactories[34] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RetourePositionProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ZuruecksendenCommandProxi(objectId);
            }
        };
        proxiFactories[36] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BestellenCommandProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AendereMinLagerbestandCommandProxi(objectId);
            }
        };
        proxiFactories[38] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new WarenlagerProxi(objectId);
            }
        };
        proxiFactories[39] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[171] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AendereBezeichnungCommandProxi(objectId);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new VorbestellenCommandProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new VerkaufProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AuslaufProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BestellungProxi(objectId);
            }
        };
        proxiFactories[46] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KundenManagerProxi(objectId);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServiceKundeBestellManagerProxi(objectId);
            }
        };
        proxiFactories[48] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AnzeigenCommandProxi(objectId);
            }
        };
        proxiFactories[51] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ZeitManagerZeitObjektListeProxi(objectId);
            }
        };
        proxiFactories[52] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ArtikelEinlagernCommandProxi(objectId);
            }
        };
        proxiFactories[53] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new GeliefertProxi(objectId);
            }
        };
        proxiFactories[175] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AendereHstLieferzeitCommandProxi(objectId);
            }
        };
        proxiFactories[55] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RetoureLieferungProxi(objectId);
            }
        };
        proxiFactories[59] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BestellManagerProxi(objectId);
            }
        };
        proxiFactories[60] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StatusAuslaufCommandProxi(objectId);
            }
        };
        proxiFactories[61] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NeuerArtikelCommandProxi(objectId);
            }
        };
        proxiFactories[62] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ZeitManagerProxi(objectId);
            }
        };
        proxiFactories[63] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SubjProxi(objectId);
            }
        };
        proxiFactories[64] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SuchManagerProxi(objectId);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new VorbestellungProxi(objectId);
            }
        };
        proxiFactories[66] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new PositionInBestellungProxi(objectId);
            }
        };
        proxiFactories[67] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new KundeProxi(objectId);
            }
        };
        proxiFactories[68] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RueckversandProxi(objectId);
            }
        };
        proxiFactories[69] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AendereMaxLagerbestandCommandProxi(objectId);
            }
        };
        proxiFactories[70] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new LieferartManagerProxi(objectId);
            }
        };
        proxiFactories[71] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new HinversandProxi(objectId);
            }
        };
        proxiFactories[72] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AllesZuruecksendenCommandProxi(objectId);
            }
        };
        proxiFactories[74] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[75] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new activatedProxi(objectId);
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
	
	
    protected void setDltd() throws PersistenceException{
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }
	
	
//	public void finalize(){
//		if (this.object != null)this.object.decrementUserCount();
//	}
}
