package com.zing.dao;

import com.zing.pojo.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

//HibernateDaoSupport 为dao注入sessionFactory
public class CustomDaoImpl extends HibernateDaoSupport implements CustomDao{
    @Override
    //匿名内部类 要用id 声明为final
    public Customer getById(final Long id) {
        /*//HQL
        return this.getHibernateTemplate().execute(new HibernateCallback<Customer>() {
            @Override
            public Customer doInHibernate(Session session) throws HibernateException {
                String hql = "from Customer where cust_id = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0,id);
                Customer customer = (Customer) query.uniqueResult();
                return customer;
            }
        });*/

        //Criteria
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        dc.add(Restrictions.eq("cust_id",id));
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc);
        if(list != null & list.size() >0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }
}
