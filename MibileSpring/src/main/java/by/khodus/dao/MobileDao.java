package by.khodus.dao;

import by.khodus.db.HibernateSessionFactoryUtil;
import by.khodus.entity.Mobile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MobileDao {



    public void save(Mobile mobile) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(mobile);
        tx1.commit();
        session.close();
    }

    public void update(Mobile mobile) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(mobile);
        tx1.commit();
        session.close();
    }

    public void delete(Mobile mobile) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(mobile);
        tx1.commit();
        session.close();
    }

    public Mobile findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Mobile.class, id);
    }

    /*public Mobile findByMobile(Mobile mobile) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Mobile.class, mobile);
    }*/

    public List<Mobile> findAll() {
        List<Mobile> mobiles = (List<Mobile>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Mobile order by id").list();
        return mobiles;
    }

    public MobileDao() {
    }
}