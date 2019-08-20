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
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class AddressPlamDao {
     private static Session session;
    
    
    public static ArrayList<Addressplam> getAllAddressPlam(){
        session = SessionUtil.getOpenSession();
        String query = "select * from addressplam ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Addressplam.class);  
        ArrayList<Addressplam> addressPlams = (ArrayList<Addressplam>)sqlQuery.list();
        ArrayList<Addressplam> response = new ArrayList<Addressplam>();
        for(Addressplam addressPlam : addressPlams){
            Addressplam ar = addressPlam; 
            ar.setPalmtobugreports(null);
            ar.setPalmtocarwaterreports(null);
            ar.setPalmtocutleafreports(null);
            ar.setPalmtofertilizerreports(null);
            ar.setPalmtoharvestreports(null);
            ar.setPalmtoplantdiseaseses(null);
            ar.setPalmtowaterreports(null);
            ar.setPalmtoweedreports(null);
              Farmer p = new Farmer();
             p.setIdFarmer(addressPlam.getFarmer().getIdFarmer());
            p.setIdCard(addressPlam.getFarmer().getIdCard());
            p.setFname(addressPlam.getFarmer().getFname());
            p.setLname(addressPlam.getFarmer().getLname());
            p.setAddress(addressPlam.getFarmer().getAddress());
            p.setCity(addressPlam.getFarmer().getCity());
            p.setStatus(addressPlam.getFarmer().getStatus());
            if(addressPlam.getFarmer().getUsername() != null || addressPlam.getFarmer().getPassword() != null)
            {
                p.setUsername(addressPlam.getFarmer().getUsername());
                p.setPassword(addressPlam.getFarmer().getPassword());
            }
                
            ar.setFarmer(p);
            
            response.add(ar);
            
        }
        return response;
    }
    
     public static Addressplam getAddressPlam(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from addressplam where idAddressPlam = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Addressplam.class);  
        Addressplam addressPlam = (Addressplam)sqlQuery.list().get(0);
            Addressplam ar = addressPlam; 
            ar.setPalmtobugreports(null);
            ar.setPalmtocarwaterreports(null);
            ar.setPalmtocutleafreports(null);
            ar.setPalmtofertilizerreports(null);
            ar.setPalmtoharvestreports(null);
            ar.setPalmtoplantdiseaseses(null);
            ar.setPalmtowaterreports(null);
            ar.setPalmtoweedreports(null);
              Farmer p = new Farmer();
             p.setIdFarmer(addressPlam.getFarmer().getIdFarmer());
            p.setIdCard(addressPlam.getFarmer().getIdCard());
            p.setFname(addressPlam.getFarmer().getFname());
            p.setLname(addressPlam.getFarmer().getLname());
            p.setAddress(addressPlam.getFarmer().getAddress());
            p.setCity(addressPlam.getFarmer().getCity());
            p.setStatus(addressPlam.getFarmer().getStatus());
            if(addressPlam.getFarmer().getUsername() != null || addressPlam.getFarmer().getPassword() != null)
            {
                p.setUsername(addressPlam.getFarmer().getUsername());
                p.setPassword(addressPlam.getFarmer().getPassword());
            }
                
            ar.setFarmer(p);
            return ar;
    }
    
     public int create(Addressplam addressPlam) {
         try{
                    session = SessionUtil.getOpenSession();
                    session.beginTransaction();
                    session.save(addressPlam);
                    session.getTransaction().commit();
                         return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Addressplam addressPlam) {
        try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(addressPlam);
                session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Addressplam addressPlam) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(addressPlam);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
