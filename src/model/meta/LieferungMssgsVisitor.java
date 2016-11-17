package model.meta;

public interface LieferungMssgsVisitor extends LieferungDOWNMssgsVisitor, LieferungUPMssgsVisitor {}


interface LieferungDOWNMssgsVisitor extends HstLieferungDOWNMssgsVisitor, KndLieferungDOWNMssgsVisitor {

    
}


interface LieferungUPMssgsVisitor extends ZeitObjektUPMssgsVisitor {

    
}
