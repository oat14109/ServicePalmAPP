/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Cutleafreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class CutLeafReportDao {
     private static Session session;
    
    
    public static ArrayList<Cutleafreport> getAllCutLeafReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from cutleafreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Cutleafreport.class);  
        ArrayList<Cutleafreport> cutLeafReports = (ArrayList<Cutleafreport>)sqlQuery.list();
        ArrayList<Cutleafreport> response = new ArrayList<Cutleafreport>();
        for(Cutleafreport cutLeafReport : cutLeafReports){
            Cutleafreport clr = cutLeafReport;
             Farmer p = new Farmer();
            clr.setPalmtocutleafreports(null);
             p.setIdFarmer(cutLeafReport.getFarmer().getIdFarmer());
            p.setIdCard(cutLeafReport.getFarmer().getIdCard());
            p.setFname(cutLeafReport.getFarmer().getFname());
            p.setLname(cutLeafReport.getFarmer().getLname());
            p.setAddress(cutLeafReport.getFarmer().getAddress());
            p.setCity(cutLeafReport.getFarmer().getCity());
            p.setStatus(cutLeafReport.getFarmer().getStatus());
            if(cutLeafReport.getFarmer().getUsername() != null || cutLeafReport.getFarmer().getPassword() != null)
            {
                p.setUsername(cutLeafReport.getFarmer().getUsername());
                p.setPassword(cutLeafReport.getFarmer().getPassword());
            }
                
            clr.setFarmer(p);
            response.add(clr);
        }
        return response;
    }
    
     public static Cutleafreport getCutLeafReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from cutleafreport where idCutLeafReport = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Cutleafreport.class);  
        Cutleafreport cutLeafReport = (Cutleafreport)sqlQuery.list().get(0);
 
            Cutleafreport clr = cutLeafReport;
             Farmer p = new Farmer();
            clr.setPalmtocutleafreports(null);
             p.setIdFarmer(cutLeafReport.getFarmer().getIdFarmer());
            p.setIdCard(cutLeafReport.getFarmer().getIdCard());
            p.setFname(cutLeafReport.getFarmer().getFname());
            p.setLname(cutLeafReport.getFarmer().getLname());
            p.setAddress(cutLeafReport.getFarmer().getAddress());
            p.setCity(cutLeafReport.getFarmer().getCity());
            p.setStatus(cutLeafReport.getFarmer().getStatus());
            if(cutLeafReport.getFarmer().getUsername() != null || cutLeafReport.getFarmer().getPassword() != null)
            {
                p.setUsername(cutLeafReport.getFarmer().getUsername());
                p.setPassword(cutLeafReport.getFarmer().getPassword());
            }
                
            clr.setFarmer(p);
         return clr;
    }
     public int create(Cutleafreport cutLeafReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(cutLeafReport);
                session.getTransaction().commit();
             return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Cutleafreport cutLeafReport) {
            try{
                    session = SessionUtil.getOpenSession();
                    session.beginTransaction();
                    session.update(cutLeafReport);
                    session.getTransaction().commit();
                     return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Cutleafreport cutLeafReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(cutLeafReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
