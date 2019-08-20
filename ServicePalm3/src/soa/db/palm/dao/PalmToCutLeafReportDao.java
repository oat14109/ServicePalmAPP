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
import soa.db.palm.entity.Cutleafreport;
import soa.db.palm.entity.Palmtocutleafreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToCutLeafReportDao {
    private static Session session;
    
    
    
     public static ArrayList<Palmtocutleafreport> getAllPalmToCutLeafReport(){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtocutleafreport";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtocutleafreport.class);  
        ArrayList<Palmtocutleafreport> palmToCutLeafReports = (ArrayList<Palmtocutleafreport>)sqlQuery.list();
        ArrayList<Palmtocutleafreport> response = new ArrayList<Palmtocutleafreport>();
        for(Palmtocutleafreport palmToCutLeafReport : palmToCutLeafReports){
            Palmtocutleafreport ptclr = palmToCutLeafReport; 
            Cutleafreport clr = new Cutleafreport();
            clr.setIdCutLeafReport(palmToCutLeafReport.getCutleafreport().getIdCutLeafReport());
            clr.setDate(palmToCutLeafReport.getCutleafreport().getDate());
            clr.setPalmtocutleafreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToCutLeafReport.getCutleafreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToCutLeafReport.getCutleafreport().getFarmer().getIdCard());
            p.setFname(palmToCutLeafReport.getCutleafreport().getFarmer().getFname());
            p.setLname(palmToCutLeafReport.getCutleafreport().getFarmer().getLname());
            p.setAddress(palmToCutLeafReport.getCutleafreport().getFarmer().getAddress());
            p.setCity(palmToCutLeafReport.getCutleafreport().getFarmer().getCity());
            p.setStatus(palmToCutLeafReport.getCutleafreport().getFarmer().getStatus());
            if(palmToCutLeafReport.getCutleafreport().getFarmer().getUsername() != null || palmToCutLeafReport.getCutleafreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToCutLeafReport.getCutleafreport().getFarmer().getUsername());
                p.setPassword(palmToCutLeafReport.getCutleafreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToCutLeafReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToCutLeafReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToCutLeafReport.getAddressplam().getLat());
            ap.setLon(palmToCutLeafReport.getAddressplam().getLon());
            ap.setName(palmToCutLeafReport.getAddressplam().getName());
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
            clr.setFarmer(p);
            ptclr.setAddressplam(ap);
            ptclr.setCutleafreport(clr);
            response.add(ptclr);
            
        }
        return response;
    }
     
        public static Palmtocutleafreport getPalmToCutLeafReport(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from palmtocutleafreport where idPalmToCutLeaf = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Palmtocutleafreport.class);  
        Palmtocutleafreport palmToCutLeafReport = (Palmtocutleafreport)sqlQuery.list().get(0);

            Palmtocutleafreport ptclr = palmToCutLeafReport;
            Cutleafreport clr = new Cutleafreport();
            clr.setIdCutLeafReport(palmToCutLeafReport.getCutleafreport().getIdCutLeafReport());
            clr.setDate(palmToCutLeafReport.getCutleafreport().getDate());
            clr.setPalmtocutleafreports(null);
            Farmer p = new Farmer();
             p.setIdFarmer(palmToCutLeafReport.getCutleafreport().getFarmer().getIdFarmer());
            p.setIdCard(palmToCutLeafReport.getCutleafreport().getFarmer().getIdCard());
            p.setFname(palmToCutLeafReport.getCutleafreport().getFarmer().getFname());
            p.setLname(palmToCutLeafReport.getCutleafreport().getFarmer().getLname());
            p.setAddress(palmToCutLeafReport.getCutleafreport().getFarmer().getAddress());
            p.setCity(palmToCutLeafReport.getCutleafreport().getFarmer().getCity());
            p.setStatus(palmToCutLeafReport.getCutleafreport().getFarmer().getStatus());
            if(palmToCutLeafReport.getCutleafreport().getFarmer().getUsername() != null || palmToCutLeafReport.getCutleafreport().getFarmer().getPassword() != null)
            {
                p.setUsername(palmToCutLeafReport.getCutleafreport().getFarmer().getUsername());
                p.setPassword(palmToCutLeafReport.getCutleafreport().getFarmer().getPassword());
            }
             Addressplam ap = new Addressplam();
            ap.setAddresss(palmToCutLeafReport.getAddressplam().getAddresss());
            ap.setIdAddressPlam(palmToCutLeafReport.getAddressplam().getIdAddressPlam());
            ap.setLat(palmToCutLeafReport.getAddressplam().getLat());
            ap.setLon(palmToCutLeafReport.getAddressplam().getLon());
            ap.setName(palmToCutLeafReport.getAddressplam().getName());
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
            clr.setFarmer(p);
            ptclr.setAddressplam(ap);
            ptclr.setCutleafreport(clr);
           
            
        return ptclr;
    }
     
     public int create(Palmtocutleafreport palmToCutLeafReport) {
         try{
            session = SessionUtil.getOpenSession();
            session.beginTransaction();
            session.save(palmToCutLeafReport);
            session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Palmtocutleafreport palmToCutLeafReport) {
        try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(palmToCutLeafReport);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Palmtocutleafreport palmToCutLeafReport) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(palmToCutLeafReport);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    } 
}
