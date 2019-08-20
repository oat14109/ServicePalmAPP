/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Plantdiseases;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PlantDiseasesDao {
     private static Session session;
    
    
    public static ArrayList<Plantdiseases> getAllPlantDiseases(){
        session = SessionUtil.getOpenSession();
        String query = "select * from plantdiseases ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Plantdiseases.class);  
        ArrayList<Plantdiseases> plantDiseases = (ArrayList<Plantdiseases>)sqlQuery.list();
        ArrayList<Plantdiseases> response = new ArrayList<Plantdiseases>();
        for(Plantdiseases plantDisease : plantDiseases){
            Plantdiseases pd = plantDisease;   
            pd.setImageplantdiseaseses(null);
            pd.setPalmtoplantdiseaseses(null);
            Farmer p = new Farmer();
             p.setIdFarmer(plantDisease.getFarmer().getIdFarmer());
            p.setIdCard(plantDisease.getFarmer().getIdCard());
            p.setFname(plantDisease.getFarmer().getFname());
            p.setLname(plantDisease.getFarmer().getLname());
            p.setAddress(plantDisease.getFarmer().getAddress());
            p.setCity(plantDisease.getFarmer().getCity());
            p.setStatus(plantDisease.getFarmer().getStatus());
            if(plantDisease.getFarmer().getUsername() != null || plantDisease.getFarmer().getPassword() != null)
            {
                p.setUsername(plantDisease.getFarmer().getUsername());
                p.setPassword(plantDisease.getFarmer().getPassword());
            }
                
            pd.setFarmer(p);
      

            response.add(pd);
        }
        return response;
    }
    
        
    public static Plantdiseases getPlantDiseases(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from plantdiseases where idPlantDiseases ='"+id+"";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Plantdiseases.class);  
        Plantdiseases plantDisease = (Plantdiseases)sqlQuery.list();
       
            Plantdiseases pd = plantDisease;   
            pd.setImageplantdiseaseses(null);
            pd.setPalmtoplantdiseaseses(null);
            Farmer p = new Farmer();
             p.setIdFarmer(plantDisease.getFarmer().getIdFarmer());
            p.setIdCard(plantDisease.getFarmer().getIdCard());
            p.setFname(plantDisease.getFarmer().getFname());
            p.setLname(plantDisease.getFarmer().getLname());
            p.setAddress(plantDisease.getFarmer().getAddress());
            p.setCity(plantDisease.getFarmer().getCity());
            p.setStatus(plantDisease.getFarmer().getStatus());
            if(plantDisease.getFarmer().getUsername() != null || plantDisease.getFarmer().getPassword() != null)
            {
                p.setUsername(plantDisease.getFarmer().getUsername());
                p.setPassword(plantDisease.getFarmer().getPassword());
            }
                
            pd.setFarmer(p);
      

          
        return pd;
    }
    
    
     public int create(Plantdiseases plantDiseases) {
         try {
         
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(plantDiseases);
            session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Plantdiseases plantDiseases) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(plantDiseases);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Plantdiseases plantDiseases) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(plantDiseases);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
