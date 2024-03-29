package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Addressplam generated by hbm2java
 */
public class Addressplam  implements java.io.Serializable {


     private Integer idAddressPlam;
     private Farmer farmer;
     private String name;
     private Integer lat;
     private Integer lon;
     private String addresss;
     private String pathImage;
     private String nameImage;
     private Set palmtobugreports = new HashSet(0);
     private Set palmtoweedreports = new HashSet(0);
     private Set palmtocarwaterreports = new HashSet(0);
     private Set palmtoharvestreports = new HashSet(0);
     private Set palmtocutleafreports = new HashSet(0);
     private Set palmtofertilizerreports = new HashSet(0);
     private Set makepalms = new HashSet(0);
     private Set palmtoplantdiseaseses = new HashSet(0);
     private Set palmtowaterreports = new HashSet(0);

    public Addressplam() {
    }
    public Addressplam(int idAddressPlam, Farmer farmer) {
        this.idAddressPlam = idAddressPlam;
        this.farmer = farmer;
    }	
    public Addressplam(Farmer farmer) {
        this.farmer = farmer;
    }

    public Addressplam(Farmer farmer, String name, Integer lat, Integer lon, String addresss,String pathImage,String nameImage, Set palmtobugreports, Set palmtoweedreports, Set palmtocarwaterreports, Set palmtoharvestreports, Set palmtocutleafreports, Set palmtofertilizerreports, Set makepalms, Set palmtoplantdiseaseses, Set palmtowaterreports) {
       this.farmer = farmer;
       this.name = name;
       this.lat = lat;
       this.lon = lon;
       this.addresss = addresss;
       this.pathImage = pathImage;
       this.nameImage = nameImage;
       this.palmtobugreports = palmtobugreports;
       this.palmtoweedreports = palmtoweedreports;
       this.palmtocarwaterreports = palmtocarwaterreports;
       this.palmtoharvestreports = palmtoharvestreports;
       this.palmtocutleafreports = palmtocutleafreports;
       this.palmtofertilizerreports = palmtofertilizerreports;
       this.makepalms = makepalms;
       this.palmtoplantdiseaseses = palmtoplantdiseaseses;
       this.palmtowaterreports = palmtowaterreports;
    }
   
    public Integer getIdAddressPlam() {
        return this.idAddressPlam;
    }
    
    public void setIdAddressPlam(Integer idAddressPlam) {
        this.idAddressPlam = idAddressPlam;
    }
    public Farmer getFarmer() {
        return this.farmer;
    }
    
    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getLat() {
        return this.lat;
    }
    
    public void setLat(Integer lat) {
        this.lat = lat;
    }
    public Integer getLon() {
        return this.lon;
    }
    
    public void setLon(Integer lon) {
        this.lon = lon;
    }
    public String getAddresss() {
        return this.addresss;
    }
    
    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }
     public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
    public Set getPalmtobugreports() {
        return this.palmtobugreports;
    }
    
    public void setPalmtobugreports(Set palmtobugreports) {
        this.palmtobugreports = palmtobugreports;
    }
    public Set getPalmtoweedreports() {
        return this.palmtoweedreports;
    }
    
    public void setPalmtoweedreports(Set palmtoweedreports) {
        this.palmtoweedreports = palmtoweedreports;
    }
    public Set getPalmtocarwaterreports() {
        return this.palmtocarwaterreports;
    }
    
    public void setPalmtocarwaterreports(Set palmtocarwaterreports) {
        this.palmtocarwaterreports = palmtocarwaterreports;
    }
    public Set getPalmtoharvestreports() {
        return this.palmtoharvestreports;
    }
    
    public void setPalmtoharvestreports(Set palmtoharvestreports) {
        this.palmtoharvestreports = palmtoharvestreports;
    }
    public Set getPalmtocutleafreports() {
        return this.palmtocutleafreports;
    }
    
    public void setPalmtocutleafreports(Set palmtocutleafreports) {
        this.palmtocutleafreports = palmtocutleafreports;
    }
    public Set getPalmtofertilizerreports() {
        return this.palmtofertilizerreports;
    }
    
    public void setPalmtofertilizerreports(Set palmtofertilizerreports) {
        this.palmtofertilizerreports = palmtofertilizerreports;
    }
    public Set getMakepalms() {
        return this.makepalms;
    }
    
    public void setMakepalms(Set makepalms) {
        this.makepalms = makepalms;
    }
    public Set getPalmtoplantdiseaseses() {
        return this.palmtoplantdiseaseses;
    }
    
    public void setPalmtoplantdiseaseses(Set palmtoplantdiseaseses) {
        this.palmtoplantdiseaseses = palmtoplantdiseaseses;
    }
    public Set getPalmtowaterreports() {
        return this.palmtowaterreports;
    }
    
    public void setPalmtowaterreports(Set palmtowaterreports) {
        this.palmtowaterreports = palmtowaterreports;
    }




}


