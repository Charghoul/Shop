
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Kunde extends ViewObject implements KundeView{
    
    protected String benutzername;
    protected String passwort;
    
    public Kunde(String benutzername,String passwort,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.benutzername = benutzername;
        this.passwort = passwort;        
    }
    
    static public long getTypeId() {
        return 168;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getBenutzername()throws ModelException{
        return this.benutzername;
    }
    public void setBenutzername(String newValue) throws ModelException {
        this.benutzername = newValue;
    }
    public String getPasswort()throws ModelException{
        return this.passwort;
    }
    public void setPasswort(String newValue) throws ModelException {
        this.passwort = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKunde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKunde(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKunde(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    public int getBenutzernameIndex() throws ModelException {
        return 0;
    }
    public int getPasswortIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "benutzername";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "passwort";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getBenutzername();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getPasswort();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setBenutzername(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setPasswort(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
