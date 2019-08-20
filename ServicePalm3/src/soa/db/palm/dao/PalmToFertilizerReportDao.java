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
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Palmtofertilizerreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToFertilizerReportDao {
     private static Session session;
    
    
    
     public static ArrayList<Palmtofertilizerreport> getAllPalmToFertilizerReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtofertilizerreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtofertilizerreport.class);  
        ArrayList<Palmtofertilizerreport> palmToFertilizerReports = (ArrayList<Palmtofertilizerreport>)sqlQuery.list();
        ArrayList<Palmtofertilizerreport> response = new ArrayList<Palmtofertilizerreport>();
        for(Palmtofertilizerreport palmToFertilizerReport : palmToFertilizerReports){
            Palmtofertilizerreport ptfr = palmToFertilizerReport; 
            Fertilizerreport fr = new Fertilizerreport();
            fr.setIdFertilizerReport(palmToFertilizerReport.getFertilizerreport().getIdFertilizerReport());
            fr.setDate(palmToFertilizerReport.getFertilizerreport().getDate());
            fr.setFertilizer(palmToFertilizerReport.getFertilizerreport().getFertilizer());
            fr.setVolume(palmToFertilizerReport.getFertilizerreport().getVolume());
            fr.setImagefertilizerreports(null);
            fr.setPalmtofertilizerreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToFertilizerReport.getFertilizerreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToFertilizerReport.getFertilizerreport().getFarmer().getIdCard());
            p.setFname(palmToFertilizerReport.getFertilizerreport().getFarmer().getFname());
            p.setLname(palmToFertilizerReport.getFertilizerreport().getFarmer().getLname());
            p.setAddress(palmToFertilizerReport.getFertilizerreport().getFarmer().getAddress());
            p.setCity(palmToFertilizerReport.getFertilizerreport().getFarmer().getCity());
            p.setStatus(palmToFertilizerReport.getFertilizerreport().getFarmer().getStatus());
            if(palmToFertilizerReport.getFertilizerreport().getFarmer().getUsername() != null || palmToFertilizerReport.getFertilizerreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToFertilizerReport.getFertilizerreport().getFarmer().getUsername());
                p.setPassword(palmToFertilizerReport.getFertilizerreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToFertilizerReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToFertilizerReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToFertilizerReport.getAddressplam().getLat());
            ap.setLon(palmToFertilizerReport.getAddressplam().getLon());
            ap.setName(palmToFertilizerReport.getAddressplam().getName());
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
            fr.setFarmer(p);
            ptfr.setFertilizerreport(fr);
            ptfr.setAddressplam(ap);
            response.add(ptfr);
        }
        return response;
    }
     
     public static Palmtofertilizerreport getPalmToFertilizerReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtofertilizerreport where idPalmToFertilizer = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtofertilizerreport.class);  
        Palmtofertilizerreport palmToFertilizerReport = (Palmtofertilizerreport)sqlQuery.list().get(0);
        
            Palmtofertilizerreport ptfr = palmToFertilizerReport; 
            Fertilizerreport fr = new Fertilizerreport();
            fr.setIdFertilizerReport(palmToFertilizerReport.getFertilizerreport().getIdFertilizerReport());
            fr.setDate(palmToFertilizerReport.getFertilizerreport().getDate());
            fr.setFertilizer(palmToFertilizerReport.getFertilizerreport().getFertilizer());
            fr.setVolume(palmToFertilizerReport.getFertilizerreport().getVolume());
            fr.setImagefertilizerreports(null);
            fr.setPalmtofertilizerreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToFertilizerReport.getFertilizerreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToFertilizerReport.getFertilizerreport().getFarmer().getIdCard());
            p.setFname(palmToFertilizerReport.getFertilizerreport().getFarmer().getFname());
            p.setLname(palmToFertilizerReport.getFertilizerreport().getFarmer().getLname());
            p.setAddress(palmToFertilizerReport.getFertilizerreport().getFarmer().getAddress());
            p.setCity(palmToFertilizerReport.getFertilizerreport().getFarmer().getCity());
            p.setStatus(palmToFertilizerReport.getFertilizerreport().getFarmer().getStatus());
            if(palmToFertilizerReport.getFertilizerreport().getFarmer().getUsername() != null || palmToFertilizerReport.getFertilizerreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToFertilizerReport.getFertilizerreport().getFarmer().getUsername());
                p.setPassword(palmToFertilizerReport.getFertilizerreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToFertilizerReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToFertilizerReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToFertilizerReport.getAddressplam().getLat());
            ap.setLon(palmToFertilizerReport.getAddressplam().getLon());
            ap.setName(palmToFertilizerReport.getAddressplam().getName());
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
            fr.setFarmer(p);
            ptfr.setFertilizerreport(fr);
            ptfr.setAddressplam(ap);
           
        return ptfr;
    }
     
     public int create(Palmtofertilizerreport palmToFertilizerReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(palmToFertilizerReport);
                session.getTransaction().commit();
                  return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtofertilizerreport palmToFertilizerReport) {
        try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.update(palmToFertilizerReport);
            session.getTransaction().commit();
                 return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtofertilizerreport palmToFertilizerReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToFertilizerReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
