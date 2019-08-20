/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class FertilizerReportDao {
    private static Session session;
    
    
    public static ArrayList<Fertilizerreport> getAllFertilizerReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from fertilizerreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Fertilizerreport.class);  
        ArrayList<Fertilizerreport> fertilizerReports = (ArrayList<Fertilizerreport>)sqlQuery.list();
        ArrayList<Fertilizerreport> response = new ArrayList<Fertilizerreport>();
        for(Fertilizerreport fertilizerReport : fertilizerReports){
            Farmer p = new Farmer();
            Fertilizerreport fr = fertilizerReport;
            fr.setImagefertilizerreports(null);
            fr.setPalmtofertilizerreports(null);
             p.setIdFarmer(fertilizerReport.getFarmer().getIdFarmer());
            p.setIdCard(fertilizerReport.getFarmer().getIdCard());
            p.setFname(fertilizerReport.getFarmer().getFname());
            p.setLname(fertilizerReport.getFarmer().getLname());
            p.setAddress(fertilizerReport.getFarmer().getAddress());
            p.setCity(fertilizerReport.getFarmer().getCity());
            p.setStatus(fertilizerReport.getFarmer().getStatus());
            if(fertilizerReport.getFarmer().getUsername() != null || fertilizerReport.getFarmer().getPassword() != null)
            {
                p.setUsername(fertilizerReport.getFarmer().getUsername());
                p.setPassword(fertilizerReport.getFarmer().getPassword());
            }
                
            fr.setFarmer(p);
            response.add(fr);
        }
        return response;
    }
    
     public static Fertilizerreport getFertilizerReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from fertilizerreport Where idFertilizerReport = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Fertilizerreport.class);  
        Fertilizerreport fertilizerReport = (Fertilizerreport)sqlQuery.list().get(0);
       
     
            Farmer p = new Farmer();
            Fertilizerreport fr = fertilizerReport;
            fr.setImagefertilizerreports(null);
            fr.setPalmtofertilizerreports(null);
             p.setIdFarmer(fertilizerReport.getFarmer().getIdFarmer());
            p.setIdCard(fertilizerReport.getFarmer().getIdCard());
            p.setFname(fertilizerReport.getFarmer().getFname());
            p.setLname(fertilizerReport.getFarmer().getLname());
            p.setAddress(fertilizerReport.getFarmer().getAddress());
            p.setCity(fertilizerReport.getFarmer().getCity());
            p.setStatus(fertilizerReport.getFarmer().getStatus());
            if(fertilizerReport.getFarmer().getUsername() != null || fertilizerReport.getFarmer().getPassword() != null)
            {
                p.setUsername(fertilizerReport.getFarmer().getUsername());
                p.setPassword(fertilizerReport.getFarmer().getPassword());
            }
                
            fr.setFarmer(p);
          
          return fr;
    }
    
     public int create(Fertilizerreport fertilizerReport) {
            try {
                    session = SessionUtil.getOpenSession();
                    session.beginTransaction();
                    session.save(fertilizerReport);
                    session.getTransaction().commit();
                    return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Fertilizerreport fertilizerReport) {
            try {

                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(fertilizerReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Fertilizerreport fertilizerReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(fertilizerReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}


