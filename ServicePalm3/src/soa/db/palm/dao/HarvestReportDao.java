/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import java.util.Date;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class HarvestReportDao {
     private static Session session;
    public static Harvestreport clone(Harvestreport harvestReport,Farmer user){
        Harvestreport hr = new Harvestreport();
        hr.setIdHarvestReport(harvestReport.getIdHarvestReport());
        hr.setMoney(harvestReport.getMoney());
        hr.setNumToMoney(harvestReport.getNumToMoney());
        hr.setNumber(harvestReport.getNumber());
        hr.setDate(harvestReport.getDate());
        hr.setFarmer(user);
        return hr;
    }
    
    
    public static ArrayList<Harvestreport> getAllHarvestReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from harvestreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Harvestreport.class);  
        ArrayList<Harvestreport> harvestReports = (ArrayList<Harvestreport>)sqlQuery.list();
        ArrayList<Harvestreport> response = new ArrayList<Harvestreport>();
        for(Harvestreport harvestReport : harvestReports){
            Farmer p = new Farmer();
            Harvestreport hr = harvestReport;   
            hr.setImageharvestreports(null);
            hr.setPalmtoharvestreports(null);
            p.setIdFarmer(harvestReport.getFarmer().getIdFarmer());
            p.setIdCard(harvestReport.getFarmer().getIdCard());
            p.setFname(harvestReport.getFarmer().getFname());
            p.setLname(harvestReport.getFarmer().getLname());
            p.setAddress(harvestReport.getFarmer().getAddress());
            p.setCity(harvestReport.getFarmer().getCity());
            p.setStatus(harvestReport.getFarmer().getStatus());
            if(harvestReport.getFarmer().getUsername() != null || harvestReport.getFarmer().getPassword() != null)
            {
                p.setUsername(harvestReport.getFarmer().getUsername());
                p.setPassword(harvestReport.getFarmer().getPassword());
            }
                
            hr.setFarmer(p);
            response.add(hr);
        }
        return response;
    }
    
     public static Harvestreport getHarvestReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from harvestreport Where idHarvestReport = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Harvestreport.class);  
        Harvestreport harvestReport = (Harvestreport)sqlQuery.list().get(0);
      
            Farmer p = new Farmer();
            Harvestreport hr = harvestReport;   
            hr.setImageharvestreports(null);
            hr.setPalmtoharvestreports(null);
            p.setIdFarmer(harvestReport.getFarmer().getIdFarmer());
            p.setIdCard(harvestReport.getFarmer().getIdCard());
            p.setFname(harvestReport.getFarmer().getFname());
            p.setLname(harvestReport.getFarmer().getLname());
            p.setAddress(harvestReport.getFarmer().getAddress());
            p.setCity(harvestReport.getFarmer().getCity());
            p.setStatus(harvestReport.getFarmer().getStatus());
            if(harvestReport.getFarmer().getUsername() != null || harvestReport.getFarmer().getPassword() != null)
            {
                p.setUsername(harvestReport.getFarmer().getUsername());
                p.setPassword(harvestReport.getFarmer().getPassword());
            }  
            hr.setFarmer(p);
          
        return hr;
    }
    
     public int create(Harvestreport harvestReport) {
            try {
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(harvestReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Harvestreport harvestReport) {
        try {
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(harvestReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Harvestreport harvestReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(harvestReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
        HarvestReportDao h = new HarvestReportDao();
        Harvestreport test = new Harvestreport();
       Farmer user2 = new Farmer();
        user2.setIdFarmer(2);
        Date d = new Date(2018, 6, 23);
        test.setDate(d);
        test.setMoney(2);
        test.setNumToMoney(1);
        test.setNumber(2);
        test.setFarmer(user2);
        test.setIdHarvestReport(3);
        
        // insert
       h.create(test);
    }
}
