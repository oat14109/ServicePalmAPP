package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1



/**
 * Palmtofertilizerreport generated by hbm2java
 */
public class Palmtofertilizerreport  implements java.io.Serializable {


     private Integer idPalmToFertilizer;
     private Addressplam addressplam;
     private Fertilizerreport fertilizerreport;

    public Palmtofertilizerreport() {
    }

    public Palmtofertilizerreport(Addressplam addressplam, Fertilizerreport fertilizerreport) {
       this.addressplam = addressplam;
       this.fertilizerreport = fertilizerreport;
    }
   
    public Integer getIdPalmToFertilizer() {
        return this.idPalmToFertilizer;
    }
    
    public void setIdPalmToFertilizer(Integer idPalmToFertilizer) {
        this.idPalmToFertilizer = idPalmToFertilizer;
    }
    public Addressplam getAddressplam() {
        return this.addressplam;
    }
    
    public void setAddressplam(Addressplam addressplam) {
        this.addressplam = addressplam;
    }
    public Fertilizerreport getFertilizerreport() {
        return this.fertilizerreport;
    }
    
    public void setFertilizerreport(Fertilizerreport fertilizerreport) {
        this.fertilizerreport = fertilizerreport;
    }




}


