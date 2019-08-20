/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Waterreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class WaterReportDao {
      private static Session session;
    
    
    public static ArrayList<Waterreport> getAllWaterReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from waterreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Waterreport.class);  
        ArrayList<Waterreport> waterReports = (ArrayList<Waterreport>)sqlQuery.list();
        ArrayList<Waterreport> response = new ArrayList<Waterreport>();
        for(Waterreport waterReport : waterReports){
            Waterreport wr = waterReport; 
            wr.setPalmtowaterreports(null);
              Farmer p = new Farmer();
             p.setIdFarmer(waterReport.getFarmer().getIdFarmer());
            p.setIdCard(waterReport.getFarmer().getIdCard());
            p.setFname(waterReport.getFarmer().getFname());
            p.setLname(waterReport.getFarmer().getLname());
            p.setAddress(waterReport.getFarmer().getAddress());
            p.setCity(waterReport.getFarmer().getCity());
            p.setStatus(waterReport.getFarmer().getStatus());
            if(waterReport.getFarmer().getUsername() != null || waterReport.getFarmer().getPassword() != null)
            {
                p.setUsername(waterReport.getFarmer().getUsername());
                p.setPassword(waterReport.getFarmer().getPassword());
            }
                
            wr.setFarmer(p);
            response.add(wr);
        }
        return response;
    }
    
       public static Waterreport getWaterReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from waterreport where idWaterReport = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Waterreport.class);  
       Waterreport waterReport = (Waterreport)sqlQuery.list();
      
            Waterreport wr = waterReport; 
            wr.setPalmtowaterreports(null);
            
              Farmer p = new Farmer();
             p.setIdFarmer(waterReport.getFarmer().getIdFarmer());
            p.setIdCard(waterReport.getFarmer().getIdCard());
            p.setFname(waterReport.getFarmer().getFname());
            p.setLname(waterReport.getFarmer().getLname());
            p.setAddress(waterReport.getFarmer().getAddress());
            p.setCity(waterReport.getFarmer().getCity());
            p.setStatus(waterReport.getFarmer().getStatus());
            if(waterReport.getFarmer().getUsername() != null || waterReport.getFarmer().getPassword() != null)
            {
                p.setUsername(waterReport.getFarmer().getUsername());
                p.setPassword(waterReport.getFarmer().getPassword());
            }
                
            wr.setFarmer(p);
            
        return wr;
    }
    
     public int create(Waterreport waterReport) {
         try
         {
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(waterReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Waterreport waterReport) {
        try{
             session = SessionUtil.getOpenSession();
             session.beginTransaction();
             session.update(waterReport);
             session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Waterreport waterReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(waterReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
