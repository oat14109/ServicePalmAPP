package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1



/**
 * Imagebugreport generated by hbm2java
 */
public class Imagebugreport  implements java.io.Serializable {


     private Integer idImageBug;
     private Bugreport bugreport;
     private String image;
     private String url;

    public Imagebugreport() {
    }

	
    public Imagebugreport(Bugreport bugreport, String url) {
        this.bugreport = bugreport;
        this.url = url;
    }
    public Imagebugreport(Bugreport bugreport, String image, String url) {
       this.bugreport = bugreport;
       this.image = image;
       this.url = url;
    }
   
    public Integer getIdImageBug() {
        return this.idImageBug;
    }
    
    public void setIdImageBug(Integer idImageBug) {
        this.idImageBug = idImageBug;
    }
    public Bugreport getBugreport() {
        return this.bugreport;
    }
    
    public void setBugreport(Bugreport bugreport) {
        this.bugreport = bugreport;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }




}

