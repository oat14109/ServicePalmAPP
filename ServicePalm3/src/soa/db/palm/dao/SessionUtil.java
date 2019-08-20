/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionUtil {
    private static SessionUtil instance=null;
    private SessionFactory sessionFactory;
    
    public static SessionUtil getInstance(){
            instance = new SessionUtil();
            return instance;
    }
    
    private SessionUtil(){
         try {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
                
        sessionFactory = configuration.buildSessionFactory();
         }
         catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
   
    public static Session getOpenSession(){
	Session session =  getInstance().sessionFactory.openSession();
        return session;
    }
     
   public static SessionFactory getSessionFactory() {
        return getInstance().sessionFactory;
    }
     
    public static void shutdown() {
     // Close caches and connection pools
     getSessionFactory().close();
    }
}
 