package soa.db.palm.entity;
// Generated Apr 18, 2019 10:21:13 PM by Hibernate Tools 4.3.1



/**
 * Imageplantdiseases generated by hbm2java
 */
public class Imageplantdiseases  implements java.io.Serializable {


     private Integer idImagePlantDiseases;
     private Plantdiseases plantdiseases;
     private String image;
     private String url;

    public Imageplantdiseases() {
    }

	
    public Imageplantdiseases(Plantdiseases plantdiseases, String url) {
        this.plantdiseases = plantdiseases;
        this.url = url;
    }
    public Imageplantdiseases(Plantdiseases plantdiseases, String image, String url) {
       this.plantdiseases = plantdiseases;
       this.image = image;
       this.url = url;
    }
   
    public Integer getIdImagePlantDiseases() {
        return this.idImagePlantDiseases;
    }
    
    public void setIdImagePlantDiseases(Integer idImagePlantDiseases) {
        this.idImagePlantDiseases = idImagePlantDiseases;
    }
    public Plantdiseases getPlantdiseases() {
        return this.plantdiseases;
    }
    
    public void setPlantdiseases(Plantdiseases plantdiseases) {
        this.plantdiseases = plantdiseases;
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


