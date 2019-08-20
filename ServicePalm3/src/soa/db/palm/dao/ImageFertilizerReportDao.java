/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Imagefertilizerreport;
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImageFertilizerReportDao {
    private static Session session;
    
    
    public static ArrayList<Imagefertilizerreport> getAllImageFertilizerReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from imagefertilizerreport ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imagefertilizerreport.class);  
        ArrayList<Imagefertilizerreport> imageFertilizerReports = (ArrayList<Imagefertilizerreport>)sqlQuery.list();
        ArrayList<Imagefertilizerreport> response = new ArrayList<Imagefertilizerreport>();
        for(Imagefertilizerreport imageFertilizerReport : imageFertilizerReports){
            Imagefertilizerreport ifr = imageFertilizerReport;   
            Fertilizerreport fr = new Fertilizerreport();
            fr.setIdFertilizerReport(imageFertilizerReport.getFertilizerreport().getIdFertilizerReport());
            fr.setDate(imageFertilizerReport.getFertilizerreport().getDate());
            fr.setFertilizer(imageFertilizerReport.getFertilizerreport().getFertilizer());
            fr.setVolume(imageFertilizerReport.getFertilizerreport().getVolume());
            fr.setImagefertilizerreports(null);
            fr.setPalmtofertilizerreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imageFertilizerReport.getFertilizerreport().getFarmer().getIdFarmer());
            p.setIdCard(imageFertilizerReport.getFertilizerreport().getFarmer().getIdCard());
            p.setFname(imageFertilizerReport.getFertilizerreport().getFarmer().getFname());
            p.setLname(imageFertilizerReport.getFertilizerreport().getFarmer().getLname());
            p.setAddress(imageFertilizerReport.getFertilizerreport().getFarmer().getAddress());
            p.setCity(imageFertilizerReport.getFertilizerreport().getFarmer().getCity());
            p.setStatus(imageFertilizerReport.getFertilizerreport().getFarmer().getStatus());
            if(imageFertilizerReport.getFertilizerreport().getFarmer().getUsername() != null || imageFertilizerReport.getFertilizerreport().getFarmer().getPassword() != null)
            {
                p.setUsername(imageFertilizerReport.getFertilizerreport().getFarmer().getUsername());
                p.setPassword(imageFertilizerReport.getFertilizerreport().getFarmer().getPassword());
            }
            fr.setFarmer(p);
            ifr.setFertilizerreport(fr);
            response.add(ifr);
        }
        return response;
    }
    
     public static Imagefertilizerreport getImageFertilizerReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from imagefertilizerreport where idImageFertilizer ='"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Imagefertilizerreport.class);  
        Imagefertilizerreport imageFertilizerReport = (Imagefertilizerreport)sqlQuery.list();
       
            Imagefertilizerreport ifr = imageFertilizerReport;   
            ifr.setIdImageFertilizer(id);
            Fertilizerreport fr = new Fertilizerreport();
            fr.setIdFertilizerReport(imageFertilizerReport.getFertilizerreport().getIdFertilizerReport());
            fr.setDate(imageFertilizerReport.getFertilizerreport().getDate());
            fr.setFertilizer(imageFertilizerReport.getFertilizerreport().getFertilizer());
            fr.setVolume(imageFertilizerReport.getFertilizerreport().getVolume());
            fr.setImagefertilizerreports(null);
            fr.setPalmtofertilizerreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(imageFertilizerReport.getFertilizerreport().getFarmer().getIdFarmer());
            p.setIdCard(imageFertilizerReport.getFertilizerreport().getFarmer().getIdCard());
            p.setFname(imageFertilizerReport.getFertilizerreport().getFarmer().getFname());
            p.setLname(imageFertilizerReport.getFertilizerreport().getFarmer().getLname());
            p.setAddress(imageFertilizerReport.getFertilizerreport().getFarmer().getAddress());
            p.setCity(imageFertilizerReport.getFertilizerreport().getFarmer().getCity());
            p.setStatus(imageFertilizerReport.getFertilizerreport().getFarmer().getStatus());
            if(imageFertilizerReport.getFertilizerreport().getFarmer().getUsername() != null || imageFertilizerReport.getFertilizerreport().getFarmer().getPassword() != null)
            {
                p.setUsername(imageFertilizerReport.getFertilizerreport().getFarmer().getUsername());
                p.setPassword(imageFertilizerReport.getFertilizerreport().getFarmer().getPassword());
            }
            fr.setFarmer(p);
            ifr.setFertilizerreport(fr);
           
        return ifr;
    }
     public int create(Imagefertilizerreport imageFertilizerReport) {
         try {

            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(imageFertilizerReport);
            session.getTransaction().commit();
                         return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Imagefertilizerreport imageFertilizerReport) {
        try {
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(imageFertilizerReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Imagefertilizerreport imageFertilizerReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(imageFertilizerReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
