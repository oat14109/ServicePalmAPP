/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Rainreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class RainReportDao {
     private static Session session;
    
    
    public static ArrayList<Rainreport> getAllRainReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from rainreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Rainreport.class);  
        ArrayList<Rainreport> rainReports = (ArrayList<Rainreport>)sqlQuery.list();
        ArrayList<Rainreport> response = new ArrayList<Rainreport>();
        for(Rainreport rainReport : rainReports){
            Rainreport rr = rainReport;   
              Farmer p = new Farmer();
             p.setIdFarmer(rainReport.getFarmer().getIdFarmer());
            p.setIdCard(rainReport.getFarmer().getIdCard());
            p.setFname(rainReport.getFarmer().getFname());
            p.setLname(rainReport.getFarmer().getLname());
            p.setAddress(rainReport.getFarmer().getAddress());
            p.setCity(rainReport.getFarmer().getCity());
            p.setStatus(rainReport.getFarmer().getStatus());
            if(rainReport.getFarmer().getUsername() != null || rainReport.getFarmer().getPassword() != null)
            {
                p.setUsername(rainReport.getFarmer().getUsername());
                p.setPassword(rainReport.getFarmer().getPassword());
            }
                
            rr.setFarmer(p);
            response.add(rr);
        }
        return response;
    }
    
    
     public static Rainreport getRainReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from rainreport where idRain = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Rainreport.class);  
        Rainreport rainReport = (Rainreport)sqlQuery.list();
      
            Rainreport rr = rainReport; 
              Farmer p = new Farmer();
             p.setIdFarmer(rainReport.getFarmer().getIdFarmer());
            p.setIdCard(rainReport.getFarmer().getIdCard());
            p.setFname(rainReport.getFarmer().getFname());
            p.setLname(rainReport.getFarmer().getLname());
            p.setAddress(rainReport.getFarmer().getAddress());
            p.setCity(rainReport.getFarmer().getCity());
            p.setStatus(rainReport.getFarmer().getStatus());
            if(rainReport.getFarmer().getUsername() != null || rainReport.getFarmer().getPassword() != null)
            {
                p.setUsername(rainReport.getFarmer().getUsername());
                p.setPassword(rainReport.getFarmer().getPassword());
            }
                
            rr.setFarmer(p);
          
        return rr;
    }
     public int create(Rainreport rainReport) {
         try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(rainReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Rainreport rainReport) {
        try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(rainReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Rainreport rainReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(rainReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
