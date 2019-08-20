/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Carwaterreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class CarWaterReportDao {
     private static Session session;
    
    
    public static ArrayList<Carwaterreport> getAllCarWaterReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from carwaterreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Carwaterreport.class);  
        ArrayList<Carwaterreport> carWaterReports = (ArrayList<Carwaterreport>)sqlQuery.list();
        ArrayList<Carwaterreport> response = new ArrayList<Carwaterreport>();
        for(Carwaterreport carWaterReport : carWaterReports){
            Carwaterreport cwr = carWaterReport;
            cwr.setPalmtocarwaterreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(carWaterReport.getFarmer().getIdFarmer());
            p.setIdCard(carWaterReport.getFarmer().getIdCard());
            p.setFname(carWaterReport.getFarmer().getFname());
            p.setLname(carWaterReport.getFarmer().getLname());
            p.setAddress(carWaterReport.getFarmer().getAddress());
            p.setCity(carWaterReport.getFarmer().getCity());
            p.setStatus(carWaterReport.getFarmer().getStatus());
            if(carWaterReport.getFarmer().getUsername() != null || carWaterReport.getFarmer().getPassword() != null)
            {
                p.setUsername(carWaterReport.getFarmer().getUsername());
                p.setPassword(carWaterReport.getFarmer().getPassword());
            }
                
            cwr.setFarmer(p);
            response.add(cwr);
        }
        return response;
    }
    
      public static Carwaterreport getCarWaterReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from carwaterreport where idCarWaterReport ='"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Carwaterreport.class);  
        Carwaterreport carWaterReport = (Carwaterreport)sqlQuery.list().get(0);
            Carwaterreport cwr = carWaterReport;
            cwr.setPalmtocarwaterreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(carWaterReport.getFarmer().getIdFarmer());
            p.setIdCard(carWaterReport.getFarmer().getIdCard());
            p.setFname(carWaterReport.getFarmer().getFname());
            p.setLname(carWaterReport.getFarmer().getLname());
            p.setAddress(carWaterReport.getFarmer().getAddress());
            p.setCity(carWaterReport.getFarmer().getCity());
            p.setStatus(carWaterReport.getFarmer().getStatus());
            if(carWaterReport.getFarmer().getUsername() != null || carWaterReport.getFarmer().getPassword() != null)
            {
                p.setUsername(carWaterReport.getFarmer().getUsername());
                p.setPassword(carWaterReport.getFarmer().getPassword());
            }
                
            cwr.setFarmer(p);
       
        return cwr;
    }
    
    
     public int create(Carwaterreport carWaterReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(carWaterReport);
                session.getTransaction().commit();
                return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Carwaterreport carWaterReport) {
        try {
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.update(carWaterReport);
            session.getTransaction().commit();
            return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Carwaterreport carWaterReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(carWaterReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
