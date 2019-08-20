package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Rainreport generated by hbm2java
 */
public class Rainreport  implements java.io.Serializable {


     private Integer idRain;
     private Farmer farmer;
     private Date date;
     private Date time;
     private Integer hoursOrMinute;
     private Double volume;
     private Date datereport;

    public Rainreport() {
    }
    public Rainreport(int idRain, Farmer farmer) {
        this.idRain = idRain;
        this.farmer = farmer;
    }	
    public Rainreport(Farmer farmer) {
        this.farmer = farmer;
    }
	
    public Rainreport(Farmer farmer, Date datereport) {
        this.farmer = farmer;
        this.datereport = datereport;
    }
    public Rainreport(Farmer farmer, Date date, Date time, Integer hoursOrMinute, Double volume, Date datereport) {
       this.farmer = farmer;
       this.date = date;
       this.time = time;
       this.hoursOrMinute = hoursOrMinute;
       this.volume = volume;
       this.datereport = datereport;
    }
   
    public Integer getIdRain() {
        return this.idRain;
    }
    
    public void setIdRain(Integer idRain) {
        this.idRain = idRain;
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
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    public Integer getHoursOrMinute() {
        return this.hoursOrMinute;
    }
    
    public void setHoursOrMinute(Integer hoursOrMinute) {
        this.hoursOrMinute = hoursOrMinute;
    }
    public Double getVolume() {
        return this.volume;
    }
    
    public void setVolume(Double volume) {
        this.volume = volume;
    }
    public Date getDatereport() {
        return this.datereport;
    }
    
    public void setDatereport(Date datereport) {
        this.datereport = datereport;
    }




}

