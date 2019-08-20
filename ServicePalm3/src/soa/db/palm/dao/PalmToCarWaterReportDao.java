/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Palmtocarwaterreport;
import soa.db.palm.entity.Carwaterreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToCarWaterReportDao {
    private static Session session;
    
    
    
     public static ArrayList<Palmtocarwaterreport> getAllPalmToCarWaterReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtocarwaterreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtocarwaterreport.class);  
        ArrayList<Palmtocarwaterreport> palmToCarWaterReports = (ArrayList<Palmtocarwaterreport>)sqlQuery.list();
        ArrayList<Palmtocarwaterreport> response = new ArrayList<Palmtocarwaterreport>();
        for(Palmtocarwaterreport palmToCarWaterReport : palmToCarWaterReports){
            Palmtocarwaterreport ptcwr = palmToCarWaterReport;   
            Carwaterreport cwr = new Carwaterreport();
            cwr.setIdCarWaterReport(palmToCarWaterReport.getCarwaterreport().getIdCarWaterReport());
            cwr.setNumber(palmToCarWaterReport.getCarwaterreport().getNumber());
            cwr.setDate(palmToCarWaterReport.getCarwaterreport().getDate());
            cwr.setPalmtocarwaterreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToCarWaterReport.getCarwaterreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToCarWaterReport.getCarwaterreport().getFarmer().getIdCard());
            p.setFname(palmToCarWaterReport.getCarwaterreport().getFarmer().getFname());
            p.setLname(palmToCarWaterReport.getCarwaterreport().getFarmer().getLname());
            p.setAddress(palmToCarWaterReport.getCarwaterreport().getFarmer().getAddress());
            p.setCity(palmToCarWaterReport.getCarwaterreport().getFarmer().getCity());
            p.setStatus(palmToCarWaterReport.getCarwaterreport().getFarmer().getStatus());
            if(palmToCarWaterReport.getCarwaterreport().getFarmer().getUsername() != null || palmToCarWaterReport.getCarwaterreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToCarWaterReport.getCarwaterreport().getFarmer().getUsername());
                p.setPassword(palmToCarWaterReport.getCarwaterreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToCarWaterReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToCarWaterReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToCarWaterReport.getAddressplam().getLat());
            ap.setLon(palmToCarWaterReport.getAddressplam().getLon());
            ap.setName(palmToCarWaterReport.getAddressplam().getName());
            ap.setMakepalms(null);
            ap.setPalmtobugreports(null);
            ap.setPalmtocarwaterreports(null);
            ap.setPalmtocutleafreports(null);
            ap.setPalmtofertilizerreports(null);
            ap.setPalmtoharvestreports(null);
            ap.setPalmtoplantdiseaseses(null);
            ap.setPalmtowaterreports(null);
            ap.setPalmtoweedreports(null);
            ap.setFarmer(p);
            cwr.setFarmer(p);
            ptcwr.setCarwaterreport(cwr);
            ptcwr.setAddressplam(ap);
            response.add(ptcwr);
        }
        return response;
    }
     
        public static Palmtocarwaterreport getPalmToCarWaterReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtocarwaterreport where idPalmToCarWater = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtocarwaterreport.class);  
        Palmtocarwaterreport palmToCarWaterReport = (Palmtocarwaterreport)sqlQuery.list().get(0);
        
            Palmtocarwaterreport ptcwr = palmToCarWaterReport;   
            Carwaterreport cwr = new Carwaterreport();
            cwr.setIdCarWaterReport(palmToCarWaterReport.getCarwaterreport().getIdCarWaterReport());
            cwr.setNumber(palmToCarWaterReport.getCarwaterreport().getNumber());
            cwr.setDate(palmToCarWaterReport.getCarwaterreport().getDate());
            cwr.setPalmtocarwaterreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToCarWaterReport.getCarwaterreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToCarWaterReport.getCarwaterreport().getFarmer().getIdCard());
            p.setFname(palmToCarWaterReport.getCarwaterreport().getFarmer().getFname());
            p.setLname(palmToCarWaterReport.getCarwaterreport().getFarmer().getLname());
            p.setAddress(palmToCarWaterReport.getCarwaterreport().getFarmer().getAddress());
            p.setCity(palmToCarWaterReport.getCarwaterreport().getFarmer().getCity());
            p.setStatus(palmToCarWaterReport.getCarwaterreport().getFarmer().getStatus());
            if(palmToCarWaterReport.getCarwaterreport().getFarmer().getUsername() != null || palmToCarWaterReport.getCarwaterreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToCarWaterReport.getCarwaterreport().getFarmer().getUsername());
                p.setPassword(palmToCarWaterReport.getCarwaterreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToCarWaterReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToCarWaterReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToCarWaterReport.getAddressplam().getLat());
            ap.setLon(palmToCarWaterReport.getAddressplam().getLon());
            ap.setName(palmToCarWaterReport.getAddressplam().getName());
            ap.setMakepalms(null);
            ap.setPalmtobugreports(null);
            ap.setPalmtocarwaterreports(null);
            ap.setPalmtocutleafreports(null);
            ap.setPalmtofertilizerreports(null);
            ap.setPalmtoharvestreports(null);
            ap.setPalmtoplantdiseaseses(null);
            ap.setPalmtowaterreports(null);
            ap.setPalmtoweedreports(null);
            ap.setFarmer(p);
            cwr.setFarmer(p);
            ptcwr.setCarwaterreport(cwr);
            ptcwr.setAddressplam(ap);
            
        return ptcwr;
    }
     
     public int create(Palmtocarwaterreport palmToCarWaterReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(palmToCarWaterReport);
                session.getTransaction().commit();
                  return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtocarwaterreport palmToCarWaterReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(palmToCarWaterReport);
                session.getTransaction().commit();
               return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtocarwaterreport palmToCarWaterReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToCarWaterReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
