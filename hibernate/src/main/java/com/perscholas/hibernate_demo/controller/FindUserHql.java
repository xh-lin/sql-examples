package com.perscholas.hibernate_demo.controller;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.perscholas.hibernate_demo.model.User;

public class FindUserHql {

	public void findUser() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

	    String hql = "FROM User";
 	    Query query = session.createQuery(hql);
	    List<User> results = query. getResultList();

	    for (User u : results) {
            System.out.println(
                "User Id: " + u.getId() + "| Full Name: " + u.getFullname() +
                "| Email: " + u.getEmail() + "| Password: " + u.getPassword());
	    }
	}

}
