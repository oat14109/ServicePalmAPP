package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Weedreport generated by hbm2java
 */
public class Weedreport  implements java.io.Serializable {


     private Integer idWeed;
     private Farmer farmer;
     private Date date;
     private Date datereport;
     private Set palmtoweedreports = new HashSet(0);

    public Weedreport() {
    }

    public Weedreport(int idWeed, Farmer farmer) {
        this.idWeed = idWeed;
        this.farmer = farmer;
    }	
    public Weedreport(Farmer farmer) {
        this.farmer = farmer;
    }
    public Weedreport(Farmer farmer, Date datereport) {
        this.farmer = farmer;
        this.datereport = datereport;
    }
    public Weedreport(Farmer farmer, Date date, Date datereport, Set palmtoweedreports) {
       this.farmer = farmer;
       this.date = date;
       this.datereport = datereport;
       this.palmtoweedreports = palmtoweedreports;
    }
   
    public Integer getIdWeed() {
        return this.idWeed;
    }
    
    public void setIdWeed(Integer idWeed) {
        this.idWeed = idWeed;
    }
    public Farmer getFarmer() {
        return this.farmer;
    }
    
    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDatereport() {
        return this.datereport;
    }
    
    public void setDatereport(Date datereport) {
        this.datereport = datereport;
    }
    public Set getPalmtoweedreports() {
        return this.palmtoweedreports;
    }
    
    public void setPalmtoweedreports(Set palmtoweedreports) {
        this.palmtoweedreports = palmtoweedreports;
    }




}

