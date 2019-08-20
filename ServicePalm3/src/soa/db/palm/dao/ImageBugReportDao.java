/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Imagebugreport;
import soa.db.palm.entity.Bugreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImageBugReportDao {
    private static Session session;
    
    
    public static ArrayList<Imagebugreport> getAllImageBugReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from imagebugreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imagebugreport.class);  
        ArrayList<Imagebugreport> imageBugReports = (ArrayList<Imagebugreport>)sqlQuery.list();
        ArrayList<Imagebugreport> response = new ArrayList<Imagebugreport>();
        for(Imagebugreport imageBugReport : imageBugReports){
            Imagebugreport ibr = imageBugReport;   
            Bugreport br = new Bugreport();
            br.setIdBug(imageBugReport.getBugreport().getIdBug());
            br.setDate(imageBugReport.getBugreport().getDate());
            br.setInsecticide(imageBugReport.getBugreport().getInsecticide());
            br.setImagebugreports(null);
            br.setPalmtobugreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imageBugReport.getBugreport().getFarmer().getIdFarmer());
            p.setIdCard(imageBugReport.getBugreport().getFarmer().getIdCard());
            p.setFname(imageBugReport.getBugreport().getFarmer().getFname());
            p.setLname(imageBugReport.getBugreport().getFarmer().getLname());
            p.setAddress(imageBugReport.getBugreport().getFarmer().getAddress());
            p.setCity(imageBugReport.getBugreport().getFarmer().getCity());
            p.setStatus(imageBugReport.getBugreport().getFarmer().getStatus());
            if(imageBugReport.getBugreport().getFarmer().getUsername() != null || imageBugReport.getBugreport().getFarmer().getPassword() != null)
            {
                p.setUsername(imageBugReport.getBugreport().getFarmer().getUsername());
                p.setPassword(imageBugReport.getBugreport().getFarmer().getPassword());
            }
                
            br.setFarmer(p);
            ibr.setBugreport(br);
            response.add(ibr);
        }
        return response;
    }
    
      public static Imagebugreport getImageBugReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from imagebugreport where idImageBug = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imagebugreport.class);  
        Imagebugreport imageBugReport = (Imagebugreport)sqlQuery.list().get(0);
   
            Imagebugreport ibr = imageBugReport;   
            ibr.setIdImageBug(id);
            Bugreport br = new Bugreport();
            br.setIdBug(imageBugReport.getBugreport().getIdBug());
            br.setDate(imageBugReport.getBugreport().getDate());
            br.setInsecticide(imageBugReport.getBugreport().getInsecticide());
            br.setImagebugreports(null);
            br.setPalmtobugreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imageBugReport.getBugreport().getFarmer().getIdFarmer());
            p.setIdCard(imageBugReport.getBugreport().getFarmer().getIdCard());
            p.setFname(imageBugReport.getBugreport().getFarmer().getFname());
            p.setLname(imageBugReport.getBugreport().getFarmer().getLname());
            p.setAddress(imageBugReport.getBugreport().getFarmer().getAddress());
            p.setCity(imageBugReport.getBugreport().getFarmer().getCity());
            p.setStatus(imageBugReport.getBugreport().getFarmer().getStatus());
            if(imageBugReport.getBugreport().getFarmer().getUsername() != null || imageBugReport.getBugreport().getFarmer().getPassword() != null)
            {
                p.setUsername(imageBugReport.getBugreport().getFarmer().getUsername());
                p.setPassword(imageBugReport.getBugreport().getFarmer().getPassword());
            }
                
            br.setFarmer(p);
            ibr.setBugreport(br);
        
        return ibr;
    }
    
     public int create(Imagebugreport imageBugReport) {
            try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(imageBugReport);
            session.getTransaction().commit();
                       return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Imagebugreport imageBugReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(imageBugReport);
                session.getTransaction().commit();
                return 1;
            }catch(Exception e){
                      return 0;
            }
    }

    public void delete(Imagebugreport imageBugReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(imageBugReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
