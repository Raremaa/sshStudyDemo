package com.zing.test;

import com.zing.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
    @Resource(name="sessionFactory")
    private SessionFactory sf;

    @Test
    public void fun2(){
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //------------------------------------------------
        Customer c = new Customer();
        c.setCust_name("刘伟"+Math.random());
        session.save(c);
        //------------------------------------------------
        tx.commit();
        session.close();
    }

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
