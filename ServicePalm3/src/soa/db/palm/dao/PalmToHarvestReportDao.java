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
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.entity.Palmtoharvestreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToHarvestReportDao {
     private static Session session;
    
    
    
     public static ArrayList<Palmtoharvestreport> getAllPalmToHarvestReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtoharvestreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtoharvestreport.class);  
        ArrayList<Palmtoharvestreport> palmToHarvestReports = (ArrayList<Palmtoharvestreport>)sqlQuery.list();
        ArrayList<Palmtoharvestreport> response = new ArrayList<Palmtoharvestreport>();
        for(Palmtoharvestreport palmToHarvestReport : palmToHarvestReports){
            Palmtoharvestreport pthr = palmToHarvestReport;   
             Harvestreport hr = new Harvestreport();
            hr.setIdHarvestReport(palmToHarvestReport.getHarvestreport().getIdHarvestReport());
            hr.setDate(palmToHarvestReport.getHarvestreport().getDate());
            hr.setMoney(palmToHarvestReport.getHarvestreport().getMoney());
            hr.setNumToMoney(palmToHarvestReport.getHarvestreport().getNumToMoney());
            hr.setNumber(palmToHarvestReport.getHarvestreport().getNumber());
            hr.setImageharvestreports(null);
            hr.setPalmtoharvestreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToHarvestReport.getHarvestreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToHarvestReport.getHarvestreport().getFarmer().getIdCard());
            p.setFname(palmToHarvestReport.getHarvestreport().getFarmer().getFname());
            p.setLname(palmToHarvestReport.getHarvestreport().getFarmer().getLname());
            p.setAddress(palmToHarvestReport.getHarvestreport().getFarmer().getAddress());
            p.setCity(palmToHarvestReport.getHarvestreport().getFarmer().getCity());
            p.setStatus(palmToHarvestReport.getHarvestreport().getFarmer().getStatus());
            if(palmToHarvestReport.getHarvestreport().getFarmer().getUsername() != null || palmToHarvestReport.getHarvestreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToHarvestReport.getHarvestreport().getFarmer().getUsername());
                p.setPassword(palmToHarvestReport.getHarvestreport().getFarmer().getPassword());
            }
              Addressplam ap = new Addressplam();
            ap.setAddresss(palmToHarvestReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToHarvestReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToHarvestReport.getAddressplam().getLat());
            ap.setLon(palmToHarvestReport.getAddressplam().getLon());
            ap.setName(palmToHarvestReport.getAddressplam().getName());
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
            hr.setFarmer(p);
            pthr.setHarvestreport(hr);
            pthr.setAddressplam(ap);
            response.add(pthr);
        }
        return response;
    }
     
     public static Palmtoharvestreport getPalmToHarvestReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtoharvestreport where idPalmToHarvest = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtoharvestreport.class);  
        Palmtoharvestreport palmToHarvestReport = (Palmtoharvestreport)sqlQuery.list().get(0);
       
            Palmtoharvestreport pthr = palmToHarvestReport; 
             Harvestreport hr = new Harvestreport();
            hr.setIdHarvestReport(palmToHarvestReport.getHarvestreport().getIdHarvestReport());
            hr.setDate(palmToHarvestReport.getHarvestreport().getDate());
            hr.setMoney(palmToHarvestReport.getHarvestreport().getMoney());
            hr.setNumToMoney(palmToHarvestReport.getHarvestreport().getNumToMoney());
            hr.setNumber(palmToHarvestReport.getHarvestreport().getNumber());
            hr.setImageharvestreports(null);
            hr.setPalmtoharvestreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToHarvestReport.getHarvestreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToHarvestReport.getHarvestreport().getFarmer().getIdCard());
            p.setFname(palmToHarvestReport.getHarvestreport().getFarmer().getFname());
            p.setLname(palmToHarvestReport.getHarvestreport().getFarmer().getLname());
            p.setAddress(palmToHarvestReport.getHarvestreport().getFarmer().getAddress());
            p.setCity(palmToHarvestReport.getHarvestreport().getFarmer().getCity());
            p.setStatus(palmToHarvestReport.getHarvestreport().getFarmer().getStatus());
            if(palmToHarvestReport.getHarvestreport().getFarmer().getUsername() != null || palmToHarvestReport.getHarvestreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToHarvestReport.getHarvestreport().getFarmer().getUsername());
                p.setPassword(palmToHarvestReport.getHarvestreport().getFarmer().getPassword());
            }
              Addressplam ap = new Addressplam();
            ap.setAddresss(palmToHarvestReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToHarvestReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToHarvestReport.getAddressplam().getLat());
            ap.setLon(palmToHarvestReport.getAddressplam().getLon());
            ap.setName(palmToHarvestReport.getAddressplam().getName());
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
            hr.setFarmer(p);
            pthr.setHarvestreport(hr);
            pthr.setAddressplam(ap);
           
        return pthr;
    }
     
     public int create(Palmtoharvestreport palmToHarvestReport) {
         try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(palmToHarvestReport);
            session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtoharvestreport palmToHarvestReport) {
             try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(palmToHarvestReport);
                session.getTransaction().commit();
                  return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtoharvestreport palmToHarvestReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToHarvestReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
