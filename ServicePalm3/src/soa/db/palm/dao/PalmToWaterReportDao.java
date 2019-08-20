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
import soa.db.palm.entity.Palmtowaterreport;
import soa.db.palm.entity.Waterreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToWaterReportDao {
   private static Session session;
    
    
    
     public static ArrayList<Palmtowaterreport> getAllPalmToWaterReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtowaterreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtowaterreport.class);  
        ArrayList<Palmtowaterreport> palmToWaterReports = (ArrayList<Palmtowaterreport>)sqlQuery.list();
        ArrayList<Palmtowaterreport> response = new ArrayList<Palmtowaterreport>();
        for(Palmtowaterreport palmToWaterReport : palmToWaterReports){
            Palmtowaterreport ptpd = palmToWaterReport;
            Waterreport wr = new Waterreport();
            wr.setIdWaterReport(palmToWaterReport.getWaterreport().getIdWaterReport());
            wr.setDate(palmToWaterReport.getWaterreport().getDate());
            wr.setPalmtowaterreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToWaterReport.getWaterreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToWaterReport.getWaterreport().getFarmer().getIdCard());
            p.setFname(palmToWaterReport.getWaterreport().getFarmer().getFname());
            p.setLname(palmToWaterReport.getWaterreport().getFarmer().getLname());
            p.setAddress(palmToWaterReport.getWaterreport().getFarmer().getAddress());
            p.setCity(palmToWaterReport.getWaterreport().getFarmer().getCity());
            p.setStatus(palmToWaterReport.getWaterreport().getFarmer().getStatus());
            if(palmToWaterReport.getWaterreport().getFarmer().getUsername() != null || palmToWaterReport.getWaterreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToWaterReport.getWaterreport().getFarmer().getUsername());
                p.setPassword(palmToWaterReport.getWaterreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToWaterReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToWaterReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToWaterReport.getAddressplam().getLat());
            ap.setLon(palmToWaterReport.getAddressplam().getLon());
            ap.setName(palmToWaterReport.getAddressplam().getName());
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
            ptpd.setWaterreport(wr);
            ptpd.setAddressplam(ap);
            
            response.add(ptpd);
        }
        return response;
    }
     
          public static Palmtowaterreport getPalmToWaterReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtowaterreport where idPalmToWater = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtowaterreport.class);  
        Palmtowaterreport palmToWaterReport = (Palmtowaterreport)sqlQuery.list().get(0);
        
            Palmtowaterreport ptpd = palmToWaterReport;
            Waterreport wr = new Waterreport();
            wr.setIdWaterReport(palmToWaterReport.getWaterreport().getIdWaterReport());
            wr.setDate(palmToWaterReport.getWaterreport().getDate());
            wr.setPalmtowaterreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToWaterReport.getWaterreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToWaterReport.getWaterreport().getFarmer().getIdCard());
            p.setFname(palmToWaterReport.getWaterreport().getFarmer().getFname());
            p.setLname(palmToWaterReport.getWaterreport().getFarmer().getLname());
            p.setAddress(palmToWaterReport.getWaterreport().getFarmer().getAddress());
            p.setCity(palmToWaterReport.getWaterreport().getFarmer().getCity());
            p.setStatus(palmToWaterReport.getWaterreport().getFarmer().getStatus());
            if(palmToWaterReport.getWaterreport().getFarmer().getUsername() != null || palmToWaterReport.getWaterreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToWaterReport.getWaterreport().getFarmer().getUsername());
                p.setPassword(palmToWaterReport.getWaterreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToWaterReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToWaterReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToWaterReport.getAddressplam().getLat());
            ap.setLon(palmToWaterReport.getAddressplam().getLon());
            ap.setName(palmToWaterReport.getAddressplam().getName());
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
            ptpd.setWaterreport(wr);
            ptpd.setAddressplam(ap);
            
           
        return ptpd;
    }
     
     public int create(Palmtowaterreport palmToWaterReport) {
         try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(palmToWaterReport);
            session.getTransaction().commit();
              return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtowaterreport palmToWaterReport) {
        try{
        session = SessionUtil.getOpenSession();
        session.beginTransaction();
        session.update(palmToWaterReport);
        session.getTransaction().commit();
       return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtowaterreport palmToWaterReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToWaterReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }  
}
