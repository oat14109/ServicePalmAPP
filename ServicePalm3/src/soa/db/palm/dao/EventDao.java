/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;
import java.util.ArrayList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import soa.db.palm.entity.Event;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class EventDao {
 private static Session session;
    
    
    public static ArrayList<Event> getAllEvent(){
        session = SessionUtil.getOpenSession();
        String query = "select * from event ";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Event.class);  
        ArrayList<Event> events = (ArrayList<Event>)sqlQuery.list();
        ArrayList<Event> response = new ArrayList<Event>();
        for(Event event : events){
            Farmer p = new Farmer();
            Event e = event;  
             p.setIdFarmer(event.getFarmer().getIdFarmer());
            p.setIdCard(event.getFarmer().getIdCard());
            p.setFname(event.getFarmer().getFname());
            p.setLname(event.getFarmer().getLname());
            p.setAddress(event.getFarmer().getAddress());
            p.setCity(event.getFarmer().getCity());
            p.setStatus(event.getFarmer().getStatus());
            if(event.getFarmer().getUsername() != null || event.getFarmer().getPassword() != null)
            {
                p.setUsername(event.getFarmer().getUsername());
                p.setPassword(event.getFarmer().getPassword());
            }
                
            e.setFarmer(p);
            response.add(e);
        }
        return response;
    }
    
     public static Event getEvent(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from event where idEvent = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Event.class);  
        Event event = (Event)sqlQuery.list().get(0);
       
            Farmer p = new Farmer();
            Event e = event;  
             p.setIdFarmer(event.getFarmer().getIdFarmer());
            p.setIdCard(event.getFarmer().getIdCard());
            p.setFname(event.getFarmer().getFname());
            p.setLname(event.getFarmer().getLname());
            p.setAddress(event.getFarmer().getAddress());
            p.setCity(event.getFarmer().getCity());
            p.setStatus(event.getFarmer().getStatus());
            if(event.getFarmer().getUsername() != null || event.getFarmer().getPassword() != null)
            {
                p.setUsername(event.getFarmer().getUsername());
                p.setPassword(event.getFarmer().getPassword());
            }
                
            e.setFarmer(p);
            
        return e;
    }
      public static ArrayList<Event> getEventByIdFermer(int id){
        session = SessionUtil.getOpenSession();
        String query = "select * from event where Farmer_idFarmer = '"+id+"'";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(Event.class);  
        ArrayList<Event> events = (ArrayList<Event>)sqlQuery.list();
        ArrayList<Event> response = new ArrayList<Event>();
        for(Event event : events){
            Farmer p = new Farmer();
            Event e = event;  
             p.setIdFarmer(event.getFarmer().getIdFarmer());
            p.setIdCard(event.getFarmer().getIdCard());
            p.setFname(event.getFarmer().getFname());
            p.setLname(event.getFarmer().getLname());
            p.setAddress(event.getFarmer().getAddress());
            p.setCity(event.getFarmer().getCity());
            p.setStatus(event.getFarmer().getStatus());
            if(event.getFarmer().getUsername() != null || event.getFarmer().getPassword() != null)
            {
                p.setUsername(event.getFarmer().getUsername());
                p.setPassword(event.getFarmer().getPassword());
            }
                
            e.setFarmer(p);
            response.add(e);
        }
        return response;
    }
    
     public int create(Event event) {
           try {
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.save(event);
                session.getTransaction().commit();
                 return 1;
            }catch(Exception e){
                        return 0;
                    }
    }
    public int update(Event event) {
            try {
                session = SessionUtil.getOpenSession();
                session.beginTransaction();
                session.update(event);
                session.getTransaction().commit();
             return 1;
            }catch(Exception e){
                        return 0;
                    }
    }

    public void delete(Event event) {
     session = SessionUtil.getOpenSession();
     session.beginTransaction();
     session.delete(event);
     session.getTransaction().commit();
    }
    public static void closeSession(){
        session.close();
    }
    
    public static void main(String[] args){
      
    }
}
