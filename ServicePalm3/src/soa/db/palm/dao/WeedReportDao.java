/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Weedreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class WeedReportDao {
       private static Session session;
    
    
    public static ArrayList<Weedreport> getAllWeedReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from weedreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Weedreport.class);  
        ArrayList<Weedreport> weedReports = (ArrayList<Weedreport>)sqlQuery.list();
        ArrayList<Weedreport> response = new ArrayList<Weedreport>();
        for(Weedreport weedReport : weedReports){
            Weedreport wr = weedReport;   
            wr.setPalmtoweedreports(null);
             Farmer p = new Farmer();
             p.setIdFarmer(weedReport.getFarmer().getIdFarmer());
            p.setIdCard(weedReport.getFarmer().getIdCard());
            p.setFname(weedReport.getFarmer().getFname());
            p.setLname(weedReport.getFarmer().getLname());
            p.setAddress(weedReport.getFarmer().getAddress());
            p.setCity(weedReport.getFarmer().getCity());
            p.setStatus(weedReport.getFarmer().getStatus());
            if(weedReport.getFarmer().getUsername() != null || weedReport.getFarmer().getPassword() != null)
            {
                p.setUsername(weedReport.getFarmer().getUsername());
                p.setPassword(weedReport.getFarmer().getPassword());
            }
                
            wr.setFarmer(p);
            response.add(wr);
        }
        return response;
    }
    
      public static Weedreport getWeedReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from weedreport where idWeed = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Weedreport.class);  
        Weedreport weedReport = (Weedreport)sqlQuery.list();
       
            Weedreport wr = weedReport;  
            wr.setPalmtoweedreports(null);
             Farmer p = new Farmer();
             p.setIdFarmer(weedReport.getFarmer().getIdFarmer());
            p.setIdCard(weedReport.getFarmer().getIdCard());
            p.setFname(weedReport.getFarmer().getFname());
            p.setLname(weedReport.getFarmer().getLname());
            p.setAddress(weedReport.getFarmer().getAddress());
            p.setCity(weedReport.getFarmer().getCity());
            p.setStatus(weedReport.getFarmer().getStatus());
            if(weedReport.getFarmer().getUsername() != null || weedReport.getFarmer().getPassword() != null)
            {
                p.setUsername(weedReport.getFarmer().getUsername());
                p.setPassword(weedReport.getFarmer().getPassword());
            }
                
            wr.setFarmer(p);
           
        return wr;
    }
     public int create(Weedreport weedReport) {
         try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(weedReport);
                session.getTransaction().commit();
                       return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Weedreport weedReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(weedReport);
                session.getTransaction().commit();
                            return 1;
            }catch(Exception e){
                             return 0;
                    }
    }

    public void delete(Weedreport weedReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(weedReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
