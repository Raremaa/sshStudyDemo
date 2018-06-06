package com.zing.test;

import com.zing.dao.CustomDao;
import com.zing.pojo.Customer;
import com.zing.service.CustomService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
    @Resource(name="sessionFactory")
    private SessionFactory sf;

    @Test
    //测试spring管理sessionFactory
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
    //测试hibernate
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

    @Resource(name = "customDao")
    private CustomDao customDao;
    @Test
    //测试Dao Hibernate模版
    public void fun3(){
        Customer c = customDao.getById((long) 2);
        System.out.println(c);
    }
    @Resource(name = "customService")
    private CustomService cs;
    @Test
    //测试aop事务
    public void fun4(){
        Customer c = new Customer();
        c.setCust_name("刘伟最丑");
        cs.save(c);
    }
}
