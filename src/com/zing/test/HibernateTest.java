package com.zing.test;

import com.zing.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {
    @Test
    public void fun1(){
        Configuration conf = new Configuration().configure();
        SessionFactory sf =  conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //------------------------------------------------

        //------------------------------------------------
        tx.commit();
        session.close();
        sf.close();
    }
}
