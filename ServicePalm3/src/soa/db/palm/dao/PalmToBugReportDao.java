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
import soa.db.palm.entity.Bugreport;
import soa.db.palm.entity.Palmtobugreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToBugReportDao {
    private static Session session;
    
    
    
     public static ArrayList<Palmtobugreport> getAllPalmToBugReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtobugreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtobugreport.class);  
        ArrayList<Palmtobugreport> palmToBugReports = (ArrayList<Palmtobugreport>)sqlQuery.list();
        ArrayList<Palmtobugreport> response = new ArrayList<Palmtobugreport>();
        for(Palmtobugreport palmToBugReport : palmToBugReports){
            Palmtobugreport ptbr = palmToBugReport;  
            Bugreport br = new Bugreport();
            br.setIdBug(palmToBugReport.getBugreport().getIdBug());
            br.setDate(palmToBugReport.getBugreport().getDate());
            br.setInsecticide(palmToBugReport.getBugreport().getInsecticide());
            br.setImagebugreports(null);
            br.setPalmtobugreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToBugReport.getBugreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToBugReport.getBugreport().getFarmer().getIdCard());
            p.setFname(palmToBugReport.getBugreport().getFarmer().getFname());
            p.setLname(palmToBugReport.getBugreport().getFarmer().getLname());
            p.setAddress(palmToBugReport.getBugreport().getFarmer().getAddress());
            p.setCity(palmToBugReport.getBugreport().getFarmer().getCity());
            p.setStatus(palmToBugReport.getBugreport().getFarmer().getStatus());
            if(palmToBugReport.getBugreport().getFarmer().getUsername() != null || palmToBugReport.getBugreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToBugReport.getBugreport().getFarmer().getUsername());
                p.setPassword(palmToBugReport.getBugreport().getFarmer().getPassword());
            }
            Addressplam ap = new Addressplam();
            ap.setAddresss(palmToBugReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToBugReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToBugReport.getAddressplam().getLat());
            ap.setLon(palmToBugReport.getAddressplam().getLon());
            ap.setName(palmToBugReport.getAddressplam().getName());
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
            br.setFarmer(p);
            ptbr.setAddressplam(ap);
            ptbr.setBugreport(br);
            response.add(ptbr);
        }
        return response;
    }
     
     public static Palmtobugreport getPalmToBugReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtobugreport where idPalmToBug = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtobugreport.class);  
        Palmtobugreport palmToBugReport = (Palmtobugreport)sqlQuery.list().get(0);
        
            Palmtobugreport ptbr = palmToBugReport;  
            Bugreport br = new Bugreport();
            br.setIdBug(palmToBugReport.getBugreport().getIdBug());
            br.setDate(palmToBugReport.getBugreport().getDate());
            br.setInsecticide(palmToBugReport.getBugreport().getInsecticide());
            br.setImagebugreports(null);
            br.setPalmtobugreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToBugReport.getBugreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToBugReport.getBugreport().getFarmer().getIdCard());
            p.setFname(palmToBugReport.getBugreport().getFarmer().getFname());
            p.setLname(palmToBugReport.getBugreport().getFarmer().getLname());
            p.setAddress(palmToBugReport.getBugreport().getFarmer().getAddress());
            p.setCity(palmToBugReport.getBugreport().getFarmer().getCity());
            p.setStatus(palmToBugReport.getBugreport().getFarmer().getStatus());
            if(palmToBugReport.getBugreport().getFarmer().getUsername() != null || palmToBugReport.getBugreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToBugReport.getBugreport().getFarmer().getUsername());
                p.setPassword(palmToBugReport.getBugreport().getFarmer().getPassword());
            }
            Addressplam ap = new Addressplam();
            ap.setAddresss(palmToBugReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToBugReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToBugReport.getAddressplam().getLat());
            ap.setLon(palmToBugReport.getAddressplam().getLon());
            ap.setName(palmToBugReport.getAddressplam().getName());
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
            br.setFarmer(p);
            ptbr.setAddressplam(ap);
            ptbr.setBugreport(br);
           
        return ptbr;
    }
     
     public int create(Palmtobugreport palmToBugReport) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(palmToBugReport);
                session.getTransaction().commit();
                  return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtobugreport palmToBugReport) {
           try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.update(palmToBugReport);
            session.getTransaction().commit();
                return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtobugreport palmToBugReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToBugReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
