package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1



/**
 * Palmtocutleafreport generated by hbm2java
 */
public class Palmtocutleafreport  implements java.io.Serializable {


     private Integer idPalmToCutLeaf;
     private Addressplam addressplam;
     private Cutleafreport cutleafreport;

    public Palmtocutleafreport() {
    }

    public Palmtocutleafreport(Addressplam addressplam, Cutleafreport cutleafreport) {
       this.addressplam = addressplam;
       this.cutleafreport = cutleafreport;
    }
   
    public Integer getIdPalmToCutLeaf() {
        return this.idPalmToCutLeaf;
    }
    
    public void setIdPalmToCutLeaf(Integer idPalmToCutLeaf) {
        this.idPalmToCutLeaf = idPalmToCutLeaf;
    }
    public Addressplam getAddressplam() {
        return this.addressplam;
    }
    
    public void setAddressplam(Addressplam addressplam) {
        this.addressplam = addressplam;
    }
    public Cutleafreport getCutleafreport() {
        return this.cutleafreport;
    }
    
    public void setCutleafreport(Cutleafreport cutleafreport) {
        this.cutleafreport = cutleafreport;
    }




}


