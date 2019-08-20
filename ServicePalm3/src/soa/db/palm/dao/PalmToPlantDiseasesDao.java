/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Palmtoplantdiseases;
import soa.db.palm.entity.Farmer;
import soa.db.palm.entity.Plantdiseases;
/**
 *
 * @author oat
 */
public class PalmToPlantDiseasesDao {
      private static Session session;
    
    
    
     public static ArrayList<Palmtoplantdiseases> getAllPalmToPlantDiseases(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtoplantdiseases";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtoplantdiseases.class);  
        ArrayList<Palmtoplantdiseases> palmToPlantDiseases = (ArrayList<Palmtoplantdiseases>)sqlQuery.list();
        ArrayList<Palmtoplantdiseases> response = new ArrayList<Palmtoplantdiseases>();
        for(Palmtoplantdiseases palmToPlantDisease : palmToPlantDiseases){
            Palmtoplantdiseases ptpd = palmToPlantDisease;   
            Plantdiseases pd = new Plantdiseases();
            pd.setIdPlantDiseases(palmToPlantDisease.getPlantdiseases().getIdPlantDiseases());
            pd.setDate(palmToPlantDisease.getPlantdiseases().getDate());
            pd.setDiseases(palmToPlantDisease.getPlantdiseases().getDiseases());
            pd.setSymptom(palmToPlantDisease.getPlantdiseases().getSymptom());
            pd.setImageplantdiseaseses(null);
            pd.setPalmtoplantdiseaseses(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToPlantDisease.getPlantdiseases().getFarmer().getIdFarmer());
            p.setIdCard(palmToPlantDisease.getPlantdiseases().getFarmer().getIdCard());
            p.setFname(palmToPlantDisease.getPlantdiseases().getFarmer().getFname());
            p.setLname(palmToPlantDisease.getPlantdiseases().getFarmer().getLname());
            p.setAddress(palmToPlantDisease.getPlantdiseases().getFarmer().getAddress());
            p.setCity(palmToPlantDisease.getPlantdiseases().getFarmer().getCity());
            p.setStatus(palmToPlantDisease.getPlantdiseases().getFarmer().getStatus());
            if(palmToPlantDisease.getPlantdiseases().getFarmer().getUsername() != null || palmToPlantDisease.getPlantdiseases().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToPlantDisease.getPlantdiseases().getFarmer().getUsername());
                p.setPassword(palmToPlantDisease.getPlantdiseases().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToPlantDisease.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToPlantDisease.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToPlantDisease.getAddressplam().getLat());
            ap.setLon(palmToPlantDisease.getAddressplam().getLon());
            ap.setName(palmToPlantDisease.getAddressplam().getName());
            ap.setMakepalms(null);
            ap.setPalmtobugreports(null);
            ap.setPalmtocarwaterreports(null);
            ap.setPalmtocutleafreports(null);
            ap.setPalmtofertilizerreports(null);
            ap.setPalmtoharvestreports(null);
            ap.setPalmtoplantdiseaseses(null);
            ap.setPalmtowaterreports(null);
            ap.setPalmtoweedreports(null);
            ap.setFarmer(p);
            pd.setFarmer(p);
            ptpd.setPlantdiseases(pd);
            ptpd.setAddressplam(ap);
            response.add(ptpd);
        }
        return response;
    }
     
      public static Palmtoplantdiseases getPalmToPlantDiseases(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtoplantdiseases where idPalmToPlantDiseases = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtoplantdiseases.class);  
        Palmtoplantdiseases palmToPlantDisease = (Palmtoplantdiseases)sqlQuery.list().get(0);
      
            Palmtoplantdiseases ptpd = palmToPlantDisease;  
            Plantdiseases pd = new Plantdiseases();
            pd.setIdPlantDiseases(palmToPlantDisease.getPlantdiseases().getIdPlantDiseases());
            pd.setDate(palmToPlantDisease.getPlantdiseases().getDate());
            pd.setDiseases(palmToPlantDisease.getPlantdiseases().getDiseases());
            pd.setSymptom(palmToPlantDisease.getPlantdiseases().getSymptom());
            pd.setImageplantdiseaseses(null);
            pd.setPalmtoplantdiseaseses(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToPlantDisease.getPlantdiseases().getFarmer().getIdFarmer());
            p.setIdCard(palmToPlantDisease.getPlantdiseases().getFarmer().getIdCard());
            p.setFname(palmToPlantDisease.getPlantdiseases().getFarmer().getFname());
            p.setLname(palmToPlantDisease.getPlantdiseases().getFarmer().getLname());
            p.setAddress(palmToPlantDisease.getPlantdiseases().getFarmer().getAddress());
            p.setCity(palmToPlantDisease.getPlantdiseases().getFarmer().getCity());
            p.setStatus(palmToPlantDisease.getPlantdiseases().getFarmer().getStatus());
            if(palmToPlantDisease.getPlantdiseases().getFarmer().getUsername() != null || palmToPlantDisease.getPlantdiseases().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToPlantDisease.getPlantdiseases().getFarmer().getUsername());
                p.setPassword(palmToPlantDisease.getPlantdiseases().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToPlantDisease.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToPlantDisease.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToPlantDisease.getAddressplam().getLat());
            ap.setLon(palmToPlantDisease.getAddressplam().getLon());
            ap.setName(palmToPlantDisease.getAddressplam().getName());
            ap.setMakepalms(null);
            ap.setPalmtobugreports(null);
            ap.setPalmtocarwaterreports(null);
            ap.setPalmtocutleafreports(null);
            ap.setPalmtofertilizerreports(null);
            ap.setPalmtoharvestreports(null);
            ap.setPalmtoplantdiseaseses(null);
            ap.setPalmtowaterreports(null);
            ap.setPalmtoweedreports(null);
            ap.setFarmer(p);
            pd.setFarmer(p);
            ptpd.setPlantdiseases(pd);
            ptpd.setAddressplam(ap);
           
        return ptpd;
    }
     
     public int create(Palmtoplantdiseases palmToPlantDiseases) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(palmToPlantDiseases);
                session.getTransaction().commit();
                  return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtoplantdiseases palmToPlantDiseases) {
        try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.update(palmToPlantDiseases);
            session.getTransaction().commit();
              return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtoplantdiseases palmToPlantDiseases) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToPlantDiseases);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
