package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class ServiceAdminConnection extends ServiceConnection {

	public ServiceAdminConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServiceAdminView getServiceAdminView(){
		return (ServiceAdminView)super.getServer();
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
    
    @SuppressWarnings("unchecked")
    public synchronized void neueLieferArt(LieferartManagerView lieferartManager, String name, long lieferzeit, common.Fraction preis) throws ModelException, ExcLieferartAlreadyExists{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (lieferartManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)lieferartManager).createProxiInformation());
            }
            parameters.add(name);
            parameters.add(new Long(lieferzeit).toString());
            parameters.add(preis.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "neueLieferArt", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -233)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void neuerArtikel(ArtikelManagerView artikelManager, String artikelnummer, String bezeichnung, common.Fraction preis, long minLagerbestand, long maxLagerbestand, long hstLieferzeit) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (artikelManager == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)artikelManager).createProxiInformation());
            }
            parameters.add(artikelnummer);
            parameters.add(bezeichnung);
            parameters.add(preis.toString());
            parameters.add(new Long(minLagerbestand).toString());
            parameters.add(new Long(maxLagerbestand).toString());
            parameters.add(new Long(hstLieferzeit).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "neuerArtikel", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -233)
                    throw ExcLieferartAlreadyExists.fromHashtableToExcLieferartAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -195)
                    throw ExcUserAlreadyExists.fromHashtableToExcUserAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -128)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
                    throw ExcArtikelAlreadyExists.fromHashtableToExcArtikelAlreadyExists((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -130)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
