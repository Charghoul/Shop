package model.meta;

public interface LieferungMssgs {
    void accept(LieferungMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LieferungDOWNMssgs extends ZeitObjektDOWNMssgs, LieferungMssgs{}
interface LieferungUPMssgs extends HstLieferungUPMssgs, KndLieferungUPMssgs, LieferungMssgs{}
