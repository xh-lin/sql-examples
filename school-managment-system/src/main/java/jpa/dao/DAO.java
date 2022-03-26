package jpa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// boilerplate code
public abstract class DAO {

    protected SessionFactory factory;
    protected Session session;
    protected Transaction tx;

    protected void connect() {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        tx = session.beginTransaction();
    }

    protected void dispose() {
        tx.commit();
        session.close();
        factory.close();
    }

}
