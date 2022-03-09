package com.perscholas.hibernate_demo.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.perscholas.hibernate_demo.model.User;

public class DeletingUser {

	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		User u = new User();
	    u.setId(3);
	    session.delete(u);

	    tx.commit();
	    session.close();
	    factory.close();
    }

}
