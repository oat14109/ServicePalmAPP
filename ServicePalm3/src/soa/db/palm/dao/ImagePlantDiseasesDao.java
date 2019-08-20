/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Imageplantdiseases;
import soa.db.palm.entity.Plantdiseases;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImagePlantDiseasesDao {
    private static Session session;
    
    
    
     public static ArrayList<Imageplantdiseases> getAllImagePlantDiseases(){
        session = SessionUtil.getOpenSession();
        String query = "select * from imageplantdiseases";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imageplantdiseases.class);  
        ArrayList<Imageplantdiseases> imagePlantDiseases = (ArrayList<Imageplantdiseases>)sqlQuery.list();
        ArrayList<Imageplantdiseases> response = new ArrayList<Imageplantdiseases>();
        for(Imageplantdiseases imagePlantDisease : imagePlantDiseases){
            Imageplantdiseases ipd = imagePlantDisease;   
            Plantdiseases pd = new Plantdiseases();
            pd.setIdPlantDiseases(imagePlantDisease.getPlantdiseases().getIdPlantDiseases());
            pd.setDate(imagePlantDisease.getPlantdiseases().getDate());
            pd.setDiseases(imagePlantDisease.getPlantdiseases().getDiseases());
            pd.setSymptom(imagePlantDisease.getPlantdiseases().getSymptom());
            pd.setImageplantdiseaseses(null);
            pd.setPalmtoplantdiseaseses(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imagePlantDisease.getPlantdiseases().getFarmer().getIdFarmer());
            p.setIdCard(imagePlantDisease.getPlantdiseases().getFarmer().getIdCard());
            p.setFname(imagePlantDisease.getPlantdiseases().getFarmer().getFname());
            p.setLname(imagePlantDisease.getPlantdiseases().getFarmer().getLname());
            p.setAddress(imagePlantDisease.getPlantdiseases().getFarmer().getAddress());
            p.setCity(imagePlantDisease.getPlantdiseases().getFarmer().getCity());
            p.setStatus(imagePlantDisease.getPlantdiseases().getFarmer().getStatus());
            if(imagePlantDisease.getPlantdiseases().getFarmer().getUsername() != null || imagePlantDisease.getPlantdiseases().getFarmer().getPassword() != null)
            {
                p.setUsername(imagePlantDisease.getPlantdiseases().getFarmer().getUsername());
                p.setPassword(imagePlantDisease.getPlantdiseases().getFarmer().getPassword());
            }
            pd.setFarmer(p);
            ipd.setPlantdiseases(pd);
            
            response.add(ipd);
        }
        return response;
    }
     
      public static Imageplantdiseases getImagePlantDiseases(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from imageplantdiseases where idImagePlantDiseases ='"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imageplantdiseases.class);  
        Imageplantdiseases imagePlantDisease = (Imageplantdiseases)sqlQuery.list();
     
            Imageplantdiseases ipd = imagePlantDisease;   
            Plantdiseases pd = new Plantdiseases();
            pd.setIdPlantDiseases(imagePlantDisease.getPlantdiseases().getIdPlantDiseases());
            pd.setDate(imagePlantDisease.getPlantdiseases().getDate());
            pd.setDiseases(imagePlantDisease.getPlantdiseases().getDiseases());
            pd.setSymptom(imagePlantDisease.getPlantdiseases().getSymptom());
            pd.setImageplantdiseaseses(null);
            pd.setPalmtoplantdiseaseses(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imagePlantDisease.getPlantdiseases().getFarmer().getIdFarmer());
            p.setIdCard(imagePlantDisease.getPlantdiseases().getFarmer().getIdCard());
            p.setFname(imagePlantDisease.getPlantdiseases().getFarmer().getFname());
            p.setLname(imagePlantDisease.getPlantdiseases().getFarmer().getLname());
            p.setAddress(imagePlantDisease.getPlantdiseases().getFarmer().getAddress());
            p.setCity(imagePlantDisease.getPlantdiseases().getFarmer().getCity());
            p.setStatus(imagePlantDisease.getPlantdiseases().getFarmer().getStatus());
            if(imagePlantDisease.getPlantdiseases().getFarmer().getUsername() != null || imagePlantDisease.getPlantdiseases().getFarmer().getPassword() != null)
            {
                p.setUsername(imagePlantDisease.getPlantdiseases().getFarmer().getUsername());
                p.setPassword(imagePlantDisease.getPlantdiseases().getFarmer().getPassword());
            }
            pd.setFarmer(p);
            ipd.setPlantdiseases(pd);
            
           
        return ipd;
    }
     
     public int create(Imageplantdiseases imagePlantDiseases) {
                try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(imagePlantDiseases);
            session.getTransaction().commit();
                         return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Imageplantdiseases imagePlantDiseases) {
        try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.update(imagePlantDiseases);
            session.getTransaction().commit();
                         return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Imageplantdiseases imagePlantDiseases) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(imagePlantDiseases);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
