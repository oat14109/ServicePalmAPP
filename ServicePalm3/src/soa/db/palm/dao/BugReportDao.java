/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Bugreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class BugReportDao {
    private static Session session;
    
    
    public static ArrayList<Bugreport> getAllBugReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from bugreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Bugreport.class);  
        ArrayList<Bugreport> bugReports = (ArrayList<Bugreport>)sqlQuery.list();
        ArrayList<Bugreport> response = new ArrayList<Bugreport>();
        for(Bugreport bugReport : bugReports){
            Bugreport br = bugReport;   
            br.setPalmtobugreports(null);
            br.setImagebugreports(null);
               Farmer p = new Farmer();
             p.setIdFarmer(bugReport.getFarmer().getIdFarmer());
            p.setIdCard(bugReport.getFarmer().getIdCard());
            p.setFname(bugReport.getFarmer().getFname());
            p.setLname(bugReport.getFarmer().getLname());
            p.setAddress(bugReport.getFarmer().getAddress());
            p.setCity(bugReport.getFarmer().getCity());
            p.setStatus(bugReport.getFarmer().getStatus());
            if(bugReport.getFarmer().getUsername() != null || bugReport.getFarmer().getPassword() != null)
            {
                p.setUsername(bugReport.getFarmer().getUsername());
                p.setPassword(bugReport.getFarmer().getPassword());
            }
                
            br.setFarmer(p);
            
            response.add(br);
        }
        return response;
    }
    
    public static Bugreport getBugReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from bugreport where idBug = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Bugreport.class);  
        Bugreport bugReport = (Bugreport)sqlQuery.list().get(0);
            Bugreport br = bugReport;   
            br.setPalmtobugreports(null);
            br.setImagebugreports(null);
               Farmer p = new Farmer();
             p.setIdFarmer(bugReport.getFarmer().getIdFarmer());
            p.setIdCard(bugReport.getFarmer().getIdCard());
            p.setFname(bugReport.getFarmer().getFname());
            p.setLname(bugReport.getFarmer().getLname());
            p.setAddress(bugReport.getFarmer().getAddress());
            p.setCity(bugReport.getFarmer().getCity());
            p.setStatus(bugReport.getFarmer().getStatus());
            if(bugReport.getFarmer().getUsername() != null || bugReport.getFarmer().getPassword() != null)
            {
                p.setUsername(bugReport.getFarmer().getUsername());
                p.setPassword(bugReport.getFarmer().getPassword());
            }
                
            br.setFarmer(p);
            
        return br;
    }
    
     public int create(Bugreport bugReport) {
         try {
       
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(bugReport);
            session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Bugreport bugReport) {
        try {
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.update(bugReport);
            session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Bugreport bugReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(bugReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
