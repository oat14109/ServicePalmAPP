/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Imageharvestreport;
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImageHarvestReportDao {
     private static Session session;
    
    
    public static ArrayList<Imageharvestreport> getAllImageHarvestReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from imageharvestreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imageharvestreport.class);  
        ArrayList<Imageharvestreport> imageHarvestReports = (ArrayList<Imageharvestreport>)sqlQuery.list();
        ArrayList<Imageharvestreport> response = new ArrayList<Imageharvestreport>();
        for(Imageharvestreport imageHarvestReport : imageHarvestReports){
            Imageharvestreport ihr = imageHarvestReport;   
            Harvestreport hr = new Harvestreport();
            hr.setIdHarvestReport(imageHarvestReport.getHarvestreport().getIdHarvestReport());
            hr.setDate(imageHarvestReport.getHarvestreport().getDate());
            hr.setMoney(imageHarvestReport.getHarvestreport().getMoney());
            hr.setNumToMoney(imageHarvestReport.getHarvestreport().getNumToMoney());
            hr.setNumber(imageHarvestReport.getHarvestreport().getNumber());
            hr.setImageharvestreports(null);
            hr.setPalmtoharvestreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imageHarvestReport.getHarvestreport().getFarmer().getIdFarmer());
            p.setIdCard(imageHarvestReport.getHarvestreport().getFarmer().getIdCard());
            p.setFname(imageHarvestReport.getHarvestreport().getFarmer().getFname());
            p.setLname(imageHarvestReport.getHarvestreport().getFarmer().getLname());
            p.setAddress(imageHarvestReport.getHarvestreport().getFarmer().getAddress());
            p.setCity(imageHarvestReport.getHarvestreport().getFarmer().getCity());
            p.setStatus(imageHarvestReport.getHarvestreport().getFarmer().getStatus());
            if(imageHarvestReport.getHarvestreport().getFarmer().getUsername() != null || imageHarvestReport.getHarvestreport().getFarmer().getPassword() != null)
            {
                p.setUsername(imageHarvestReport.getHarvestreport().getFarmer().getUsername());
                p.setPassword(imageHarvestReport.getHarvestreport().getFarmer().getPassword());
            }
            hr.setFarmer(p);
            ihr.setHarvestreport(hr);
            
            response.add(ihr);
        }
        return response;
    }
    public static Imageharvestreport getImageHarvestReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from imageharvestreport where idImageHarvest ='"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imageharvestreport.class);  
        Imageharvestreport imageHarvestReport = (Imageharvestreport)sqlQuery.list();
        
            Imageharvestreport ihr = imageHarvestReport;   
            Harvestreport hr = new Harvestreport();
            hr.setIdHarvestReport(imageHarvestReport.getHarvestreport().getIdHarvestReport());
            hr.setDate(imageHarvestReport.getHarvestreport().getDate());
            hr.setMoney(imageHarvestReport.getHarvestreport().getMoney());
            hr.setNumToMoney(imageHarvestReport.getHarvestreport().getNumToMoney());
            hr.setNumber(imageHarvestReport.getHarvestreport().getNumber());
            hr.setImageharvestreports(null);
            hr.setPalmtoharvestreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imageHarvestReport.getHarvestreport().getFarmer().getIdFarmer());
            p.setIdCard(imageHarvestReport.getHarvestreport().getFarmer().getIdCard());
            p.setFname(imageHarvestReport.getHarvestreport().getFarmer().getFname());
            p.setLname(imageHarvestReport.getHarvestreport().getFarmer().getLname());
            p.setAddress(imageHarvestReport.getHarvestreport().getFarmer().getAddress());
            p.setCity(imageHarvestReport.getHarvestreport().getFarmer().getCity());
            p.setStatus(imageHarvestReport.getHarvestreport().getFarmer().getStatus());
            if(imageHarvestReport.getHarvestreport().getFarmer().getUsername() != null || imageHarvestReport.getHarvestreport().getFarmer().getPassword() != null)
            {
                p.setUsername(imageHarvestReport.getHarvestreport().getFarmer().getUsername());
                p.setPassword(imageHarvestReport.getHarvestreport().getFarmer().getPassword());
            }
            hr.setFarmer(p);
            ihr.setHarvestreport(hr);
            
           
        return ihr;
    }
     public int create(Imageharvestreport imageHarvestReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(imageHarvestReport);
                session.getTransaction().commit();
                 return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Imageharvestreport imageHarvestReport) {
             try{ 
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(imageHarvestReport);
                session.getTransaction().commit();
                 return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Imageharvestreport imageHarvestReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(imageHarvestReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
