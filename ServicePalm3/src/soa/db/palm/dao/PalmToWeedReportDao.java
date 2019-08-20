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
import soa.db.palm.entity.Palmtoweedreport;
import soa.db.palm.entity.Farmer;
import soa.db.palm.entity.Weedreport;
/**
 *
 * @author oat
 */
public class PalmToWeedReportDao {
     private static Session session;
     
     public static ArrayList<Palmtoweedreport> getAllPalmToWeedReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtoweedreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtoweedreport.class);  
        ArrayList<Palmtoweedreport> palmToWeedReports = (ArrayList<Palmtoweedreport>)sqlQuery.list();
        ArrayList<Palmtoweedreport> response = new ArrayList<Palmtoweedreport>();
        for(Palmtoweedreport palmToWeedReport : palmToWeedReports){
            Palmtoweedreport ptwr = palmToWeedReport;   
            Weedreport wr = new Weedreport();
            wr.setIdWeed(palmToWeedReport.getWeedreport().getIdWeed());
            wr.setDate(palmToWeedReport.getWeedreport().getDate());
            wr.setPalmtoweedreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToWeedReport.getWeedreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToWeedReport.getWeedreport().getFarmer().getIdCard());
            p.setFname(palmToWeedReport.getWeedreport().getFarmer().getFname());
            p.setLname(palmToWeedReport.getWeedreport().getFarmer().getLname());
            p.setAddress(palmToWeedReport.getWeedreport().getFarmer().getAddress());
            p.setCity(palmToWeedReport.getWeedreport().getFarmer().getCity());
            p.setStatus(palmToWeedReport.getWeedreport().getFarmer().getStatus());
            if(palmToWeedReport.getWeedreport().getFarmer().getUsername() != null || palmToWeedReport.getWeedreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToWeedReport.getWeedreport().getFarmer().getUsername());
                p.setPassword(palmToWeedReport.getWeedreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToWeedReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToWeedReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToWeedReport.getAddressplam().getLat());
            ap.setLon(palmToWeedReport.getAddressplam().getLon());
            ap.setName(palmToWeedReport.getAddressplam().getName());
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
            wr.setFarmer(p);
            ptwr.setWeedreport(wr);
            ptwr.setAddressplam(ap);
            response.add(ptwr);
        }
        return response;
    }
     
          public static Palmtoweedreport getPalmToWeedReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtoweedreport where idPalmToWeedReport = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtoweedreport.class);  
        Palmtoweedreport palmToWeedReport = (Palmtoweedreport)sqlQuery.list().get(0);
        
            Palmtoweedreport ptwr = palmToWeedReport;   
            Weedreport wr = new Weedreport();
            wr.setIdWeed(palmToWeedReport.getWeedreport().getIdWeed());
            wr.setDate(palmToWeedReport.getWeedreport().getDate());
            wr.setPalmtoweedreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToWeedReport.getWeedreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToWeedReport.getWeedreport().getFarmer().getIdCard());
            p.setFname(palmToWeedReport.getWeedreport().getFarmer().getFname());
            p.setLname(palmToWeedReport.getWeedreport().getFarmer().getLname());
            p.setAddress(palmToWeedReport.getWeedreport().getFarmer().getAddress());
            p.setCity(palmToWeedReport.getWeedreport().getFarmer().getCity());
            p.setStatus(palmToWeedReport.getWeedreport().getFarmer().getStatus());
            if(palmToWeedReport.getWeedreport().getFarmer().getUsername() != null || palmToWeedReport.getWeedreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToWeedReport.getWeedreport().getFarmer().getUsername());
                p.setPassword(palmToWeedReport.getWeedreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToWeedReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToWeedReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToWeedReport.getAddressplam().getLat());
            ap.setLon(palmToWeedReport.getAddressplam().getLon());
            ap.setName(palmToWeedReport.getAddressplam().getName());
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
            wr.setFarmer(p);
            ptwr.setWeedreport(wr);
            ptwr.setAddressplam(ap);
            
        return ptwr;
    }
     
     public int create(Palmtoweedreport palmToWeedReport) {
         try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(palmToWeedReport);
            session.getTransaction().commit();
       return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtoweedreport palmToWeedReport) {
        try{
        session = SessionUtil.getOpenSession();
        session.beginTransaction();
        session.update(palmToWeedReport);
        session.getTransaction().commit();
       return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtoweedreport palmToWeedReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToWeedReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }  
}
