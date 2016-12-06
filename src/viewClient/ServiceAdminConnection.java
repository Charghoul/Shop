package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class ServiceAdminConnection extends ServiceShopConnection {

	public ServiceAdminConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServiceAdminView getServiceAdminView(){
		return (ServiceAdminView)super.getServer();
	}

    @SuppressWarnings("unchecked")
    public synchronized ArtikelManagerView artikel_Path_In_ArtikelAnhaengen() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikel_Path_In_ArtikelAnhaengen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -251)
                    throw ExcIllogicalDataEntry.fromHashtableToExcIllogicalDataEntry((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -254)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -255)
                    throw ExcStatusDidNotChange.fromHashtableToExcStatusDidNotChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -256)
                    throw ExcAuszahlungGroesserGutgaben.fromHashtableToExcAuszahlungGroesserGutgaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -257)
                    throw ExcArtikelHatKeinenHersteller.fromHashtableToExcArtikelHatKeinenHersteller((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -258)
                    throw ExcHasChildren.fromHashtableToExcHasChildren((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -259)
                    throw ExcUserAlreadyExists.fromHashtableToExcUserAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -260)
                    throw ExcInconsistentStatusChange.fromHashtableToExcInconsistentStatusChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -262)
                    throw ExcArtikelNochNichtVerfuegbar.fromHashtableToExcArtikelNochNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -263)
                    throw ExcArtikelNichtVerfuegbar.fromHashtableToExcArtikelNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -264)
                    throw ExcArtikelAlreadyExists.fromHashtableToExcArtikelAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -265)
                    throw ExcEinkaufslisteNichtVerfuegbar.fromHashtableToExcEinkaufslisteNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -267)
                    throw ExcArtikelDoesNotExist.fromHashtableToExcArtikelDoesNotExist((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -269)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -270)
                    throw ExcHasNoParent.fromHashtableToExcHasNoParent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -271)
                    throw ExcWarenwertUeberKontoguthaben.fromHashtableToExcWarenwertUeberKontoguthaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ArtikelManagerView result = (ArtikelManagerView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ArtikelManagerView artikel_Path_In_ArtikelEinlagern() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikel_Path_In_ArtikelEinlagern", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -251)
                    throw ExcIllogicalDataEntry.fromHashtableToExcIllogicalDataEntry((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -254)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -255)
                    throw ExcStatusDidNotChange.fromHashtableToExcStatusDidNotChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -256)
                    throw ExcAuszahlungGroesserGutgaben.fromHashtableToExcAuszahlungGroesserGutgaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -257)
                    throw ExcArtikelHatKeinenHersteller.fromHashtableToExcArtikelHatKeinenHersteller((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -258)
                    throw ExcHasChildren.fromHashtableToExcHasChildren((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -259)
                    throw ExcUserAlreadyExists.fromHashtableToExcUserAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -260)
                    throw ExcInconsistentStatusChange.fromHashtableToExcInconsistentStatusChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -262)
                    throw ExcArtikelNochNichtVerfuegbar.fromHashtableToExcArtikelNochNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -263)
                    throw ExcArtikelNichtVerfuegbar.fromHashtableToExcArtikelNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -264)
                    throw ExcArtikelAlreadyExists.fromHashtableToExcArtikelAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -265)
                    throw ExcEinkaufslisteNichtVerfuegbar.fromHashtableToExcEinkaufslisteNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -267)
                    throw ExcArtikelDoesNotExist.fromHashtableToExcArtikelDoesNotExist((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -269)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -270)
                    throw ExcHasNoParent.fromHashtableToExcHasNoParent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -271)
                    throw ExcWarenwertUeberKontoguthaben.fromHashtableToExcWarenwertUeberKontoguthaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ArtikelManagerView result = (ArtikelManagerView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ArtikelManagerView artikel_Path_In_ArtikelEntnehmen() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikel_Path_In_ArtikelEntnehmen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -251)
                    throw ExcIllogicalDataEntry.fromHashtableToExcIllogicalDataEntry((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -254)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -255)
                    throw ExcStatusDidNotChange.fromHashtableToExcStatusDidNotChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -256)
                    throw ExcAuszahlungGroesserGutgaben.fromHashtableToExcAuszahlungGroesserGutgaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -257)
                    throw ExcArtikelHatKeinenHersteller.fromHashtableToExcArtikelHatKeinenHersteller((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -258)
                    throw ExcHasChildren.fromHashtableToExcHasChildren((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -259)
                    throw ExcUserAlreadyExists.fromHashtableToExcUserAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -260)
                    throw ExcInconsistentStatusChange.fromHashtableToExcInconsistentStatusChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -262)
                    throw ExcArtikelNochNichtVerfuegbar.fromHashtableToExcArtikelNochNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -263)
                    throw ExcArtikelNichtVerfuegbar.fromHashtableToExcArtikelNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -264)
                    throw ExcArtikelAlreadyExists.fromHashtableToExcArtikelAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -265)
                    throw ExcEinkaufslisteNichtVerfuegbar.fromHashtableToExcEinkaufslisteNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -267)
                    throw ExcArtikelDoesNotExist.fromHashtableToExcArtikelDoesNotExist((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -269)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -270)
                    throw ExcHasNoParent.fromHashtableToExcHasNoParent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -271)
                    throw ExcWarenwertUeberKontoguthaben.fromHashtableToExcWarenwertUeberKontoguthaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ArtikelManagerView result = (ArtikelManagerView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized HerstellerManagerView hersteller_Path_In_HerstellerHinzufuegen() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "hersteller_Path_In_HerstellerHinzufuegen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -251)
                    throw ExcIllogicalDataEntry.fromHashtableToExcIllogicalDataEntry((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -254)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -255)
                    throw ExcStatusDidNotChange.fromHashtableToExcStatusDidNotChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -256)
                    throw ExcAuszahlungGroesserGutgaben.fromHashtableToExcAuszahlungGroesserGutgaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -257)
                    throw ExcArtikelHatKeinenHersteller.fromHashtableToExcArtikelHatKeinenHersteller((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -258)
                    throw ExcHasChildren.fromHashtableToExcHasChildren((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -259)
                    throw ExcUserAlreadyExists.fromHashtableToExcUserAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -260)
                    throw ExcInconsistentStatusChange.fromHashtableToExcInconsistentStatusChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -262)
                    throw ExcArtikelNochNichtVerfuegbar.fromHashtableToExcArtikelNochNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -263)
                    throw ExcArtikelNichtVerfuegbar.fromHashtableToExcArtikelNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -264)
                    throw ExcArtikelAlreadyExists.fromHashtableToExcArtikelAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -265)
                    throw ExcEinkaufslisteNichtVerfuegbar.fromHashtableToExcEinkaufslisteNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -267)
                    throw ExcArtikelDoesNotExist.fromHashtableToExcArtikelDoesNotExist((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -269)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -270)
                    throw ExcHasNoParent.fromHashtableToExcHasNoParent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -271)
                    throw ExcWarenwertUeberKontoguthaben.fromHashtableToExcWarenwertUeberKontoguthaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                HerstellerManagerView result = (HerstellerManagerView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized WarenlagerView position_Path_In_ArtikelEntfernen() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "position_Path_In_ArtikelEntfernen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -251)
                    throw ExcIllogicalDataEntry.fromHashtableToExcIllogicalDataEntry((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -254)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -255)
                    throw ExcStatusDidNotChange.fromHashtableToExcStatusDidNotChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -256)
                    throw ExcAuszahlungGroesserGutgaben.fromHashtableToExcAuszahlungGroesserGutgaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -257)
                    throw ExcArtikelHatKeinenHersteller.fromHashtableToExcArtikelHatKeinenHersteller((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -258)
                    throw ExcHasChildren.fromHashtableToExcHasChildren((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -259)
                    throw ExcUserAlreadyExists.fromHashtableToExcUserAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -260)
                    throw ExcInconsistentStatusChange.fromHashtableToExcInconsistentStatusChange((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -262)
                    throw ExcArtikelNochNichtVerfuegbar.fromHashtableToExcArtikelNochNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -263)
                    throw ExcArtikelNichtVerfuegbar.fromHashtableToExcArtikelNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -264)
                    throw ExcArtikelAlreadyExists.fromHashtableToExcArtikelAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -265)
                    throw ExcEinkaufslisteNichtVerfuegbar.fromHashtableToExcEinkaufslisteNichtVerfuegbar((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -267)
                    throw ExcArtikelDoesNotExist.fromHashtableToExcArtikelDoesNotExist((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -269)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -270)
                    throw ExcHasNoParent.fromHashtableToExcHasNoParent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -271)
                    throw ExcWarenwertUeberKontoguthaben.fromHashtableToExcWarenwertUeberKontoguthaben((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                WarenlagerView result = (WarenlagerView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized String serviceAdmin_Menu_Filter(Anything anything) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (anything == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)anything).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "serviceAdmin_Menu_Filter", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return (String)success.get(common.RPCConstantsAndServices.ResultFieldName);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereAnnahmezeit(ZeitManagerView zeitManager, long neueZeit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (zeitManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)zeitManager).createProxiInformation());
            }
            parameters.add(new Long(neueZeit).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereAnnahmezeit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereBezeichnung(ArtikelView artikel, String bezeichnung) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(bezeichnung);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereBezeichnung", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void aendereHersteller(HerstellerView hersteller, String name) throws ModelException, ExcAlreadyExists{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (hersteller == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)hersteller).createProxiInformation());
            }
            parameters.add(name);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereHersteller", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereHstLieferzeit(ArtikelView artikel, long hstLieferzeit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(new Long(hstLieferzeit).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereHstLieferzeit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereLieferartDauer(LieferartView lieferart, long dauer) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (lieferart == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)lieferart).createProxiInformation());
            }
            parameters.add(new Long(dauer).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereLieferartDauer", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereLieferartName(LieferartView lieferart, String name) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (lieferart == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)lieferart).createProxiInformation());
            }
            parameters.add(name);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereLieferartName", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereLieferartPreis(LieferartView lieferart, long preis) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (lieferart == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)lieferart).createProxiInformation());
            }
            parameters.add(new Long(preis).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereLieferartPreis", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereMaxAnlieferungsVersuche(ZeitManagerView zeitManager, long maxAnlieferungsVersuche) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (zeitManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)zeitManager).createProxiInformation());
            }
            parameters.add(new Long(maxAnlieferungsVersuche).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereMaxAnlieferungsVersuche", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereMaxLagerbestand(ArtikelView artikel, long maxLagerbestand) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(new Long(maxLagerbestand).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereMaxLagerbestand", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void aendereMenge(PositionView position, long menge) throws ModelException, ExcLagerbestandUnderZero, ExcLagerbestandOverMax{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (position == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)position).createProxiInformation());
            }
            parameters.add(new Long(menge).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereMenge", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereMinLagerbestand(ArtikelView artikel, long minLagerbestand) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(new Long(minLagerbestand).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereMinLagerbestand", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aenderePreis(ArtikelView artikel, long preis) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(new Long(preis).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aenderePreis", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereRetoureZeit(ZeitManagerView zeitManager, long retoureZeit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (zeitManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)zeitManager).createProxiInformation());
            }
            parameters.add(new Long(retoureZeit).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereRetoureZeit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereRueckversandGebuehr(LieferartManagerView lieferartManager, long percent) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (lieferartManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)lieferartManager).createProxiInformation());
            }
            parameters.add(new Long(percent).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereRueckversandGebuehr", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereStandardGuthaben(KundenManagerView kundenManager, long guthaben) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (kundenManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)kundenManager).createProxiInformation());
            }
            parameters.add(new Long(guthaben).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereStandardGuthaben", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void aendereStandardLimit(KundenManagerView kundenManager, long limit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (kundenManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)kundenManager).createProxiInformation());
            }
            parameters.add(new Long(limit).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "aendereStandardLimit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void artikelAbhaengen(ProduktgruppeView produktgruppe, ArtikelView artikel) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (produktgruppe == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)produktgruppe).createProxiInformation());
            }
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikelAbhaengen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void artikelAnhaengen(ProduktgruppeView produktgruppe, ArtikelView artikel) throws ModelException, ExcAlreadyExists, CycleException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (produktgruppe == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)produktgruppe).createProxiInformation());
            }
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikelAnhaengen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void artikelEinlagern(WarenlagerView warenlager, ArtikelView artikel, long menge) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (warenlager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)warenlager).createProxiInformation());
            }
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(new Long(menge).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikelEinlagern", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void artikelEntfernen(WarenlagerView warenlager, PositionView position) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (warenlager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)warenlager).createProxiInformation());
            }
            if (position == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)position).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikelEntfernen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void artikelEntnehmen(WarenlagerView warenlager, ArtikelView artikel, long menge) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (warenlager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)warenlager).createProxiInformation());
            }
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            parameters.add(new Long(menge).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "artikelEntnehmen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void erhoeheMenge(PositionView position, long menge) throws ModelException, ExcLagerbestandOverMax{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (position == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)position).createProxiInformation());
            }
            parameters.add(new Long(menge).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "erhoeheMenge", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -252)
                    throw ExcLagerbestandOverMax.fromHashtableToExcLagerbestandOverMax((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void herstellerHinzufuegen(ArtikelView artikel, HerstellerView hersteller) throws ModelException, ExcAlreadyExists{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            if (hersteller == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)hersteller).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "herstellerHinzufuegen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void neueLieferArt(LieferartManagerView lieferartManager, String name, long lieferzeit, long preis) throws ModelException, ExcAlreadyExists{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (lieferartManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)lieferartManager).createProxiInformation());
            }
            parameters.add(name);
            parameters.add(new Long(lieferzeit).toString());
            parameters.add(new Long(preis).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "neueLieferArt", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void neuerArtikel(ArtikelManagerView artikelManager, String artikelnummer, String bezeichnung, long preis, long minLagerbestand, long maxLagerbestand, long hstLieferzeit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikelManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikelManager).createProxiInformation());
            }
            parameters.add(artikelnummer);
            parameters.add(bezeichnung);
            parameters.add(new Long(preis).toString());
            parameters.add(new Long(minLagerbestand).toString());
            parameters.add(new Long(maxLagerbestand).toString());
            parameters.add(new Long(hstLieferzeit).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "neuerArtikel", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void neuerHersteller(HerstellerManagerView herstellerManager, String name) throws ModelException, ExcAlreadyExists{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (herstellerManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)herstellerManager).createProxiInformation());
            }
            parameters.add(name);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "neuerHersteller", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void produktgruppeEntfernen(ProduktgruppeView produktgruppe) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (produktgruppe == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)produktgruppe).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "produktgruppeEntfernen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void produktgruppeHinzufuegen(ProduktgruppeView produktgruppe, String name) throws ModelException, ExcAlreadyExists, CycleException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (produktgruppe == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)produktgruppe).createProxiInformation());
            }
            parameters.add(name);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "produktgruppeHinzufuegen", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
                    throw ExcAlreadyExists.fromHashtableToExcAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -261)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void statusAuslauf(ArtikelView artikel) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "statusAuslauf", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void statusVerkauf(ArtikelView artikel) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikel == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikel).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "statusVerkauf", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void verringereMenge(PositionView position, long menge) throws ModelException, ExcLagerbestandUnderZero{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (position == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)position).createProxiInformation());
            }
            parameters.add(new Long(menge).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "verringereMenge", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -253)
                    throw ExcLagerbestandUnderZero.fromHashtableToExcLagerbestandUnderZero((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
