/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class FarmerDao {
     private static Session session;
    public static Farmer clone(Farmer user){
        Farmer u = new Farmer();
        u.setIdFarmer(user.getIdFarmer());
        u.setFname(user.getFname());
        u.setLname(user.getLname());
        return u;
    }
    
     
    public static ArrayList<Farmer> getAllFarmer(){
        session = SessionUtil.getOpenSession();
        String query = "select * from Farmer ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Farmer.class);  
        ArrayList<Farmer> users = (ArrayList<Farmer>)sqlQuery.list();
        ArrayList<Farmer> response = new ArrayList<Farmer>();
        for(Farmer user : users){
            Farmer u = user;   
            u.setAddressplams(null);
            u.setBugreports(null);
            u.setCarwaterreports(null);
            u.setCutleafreports(null);
            u.setEvents(null);
            u.setFertilizerreports(null);
            u.setHarvestreports(null);
            u.setPlantdiseaseses(null);
            u.setRainreports(null);
            u.setWaterreports(null);
            u.setWeedreports(null);
            response.add(u);
        }
        return response;
    }
    public static Farmer getFarmer(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from Farmer where idFarmer = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Farmer.class);  
        Farmer user = (Farmer)sqlQuery.list().get(0);
            user.setAddressplams(null);
            user.setBugreports(null);
            user.setCarwaterreports(null);
            user.setCutleafreports(null);
            user.setEvents(null);
            user.setFertilizerreports(null);
            user.setHarvestreports(null);
            user.setPlantdiseaseses(null);
            user.setRainreports(null);
            user.setWaterreports(null);
            user.setWeedreports(null);
        return user;
    }
    public static Farmer getFarmerByIdCard(Long id){
        session = SessionUtil.getOpenSession();
        String query = "select * from Farmer where idCard = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Farmer.class);  
        Farmer user = (Farmer)sqlQuery.list().get(0);
            user.setAddressplams(null);
            user.setBugreports(null);
            user.setCarwaterreports(null);
            user.setCutleafreports(null);
            user.setEvents(null);
            user.setFertilizerreports(null);
            user.setHarvestreports(null);
            user.setPlantdiseaseses(null);
            user.setRainreports(null);
            user.setWaterreports(null);
            user.setWeedreports(null);
        return user;
    }
    public int create(Farmer user) {
            try{
                    session = SessionUtil.getOpenSession();
                    session.beginTransaction();
                    session.save(user);
                    session.getTransaction().commit();
                        return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public int update(Farmer user) {
            try{
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
                   return 1;
            }catch(Exception e){
                   return 0;
            }
    }

    public void delete(Farmer user) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(user);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    
    
    
    public static void test(){
        try{
            Farmer users = FarmerDao.getFarmer(3);
            ObjectMapper map = new ObjectMapper();
            String result = map.writeValueAsString(users);
            System.out.println(result);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        FarmerDao Farmers = new FarmerDao();
        Farmer user1 = new Farmer();
        user1.setIdFarmer(1);
        user1.setFname("Nopphanan");
        user1.setLname("Mayoe");
        user1.setIdCard(1L);
        user1.setAddress("พิมลราข");
        user1.setStatus(0);
        user1.setCity("Nonthaburi");

       Farmer user2 = new Farmer();
        user2.setFname("Kingsuwan");
        user2.setLname("Mayoe");
        user2.setIdFarmer(2);
        //test();
        // insert
        Farmers.create(user1);
        //Farmers.create(user2);

    }
}
