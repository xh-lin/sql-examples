package com.perscholas.hibernate_demo.controller;

import java.util.List;

import javax.persistence.TypedQuery;

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

    public void findUserSelect() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        /* ------------  Example of HQL to get all the records------- */
	    String hql = "SELECT u FROM User u";
	    Query query = session.createQuery(hql);
	    List<User> list  =  query.getResultList();

	    for (User u : list) {
            System.out.println(
                "User Id: " + u.getId() + "| Full Name: " + u.getFullname() +
                "| Email: " + u.getEmail() + "| Password: " + u.getPassword());
        }
    }

    public void getRecordbyId() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

        String hql = "SELECT U FROM User U WHERE U.id < 5 ORDER BY U.id DESC";
        Query query = session.createQuery(hql);
        List<User> list  =  query.getResultList();

        for (User u : list) {
            System.out.println(
                "User Id: " + u.getId() + "| Full Name: " + u.getFullname() +
                "| Email: " + u.getEmail() + "| Password: " + u.getPassword());
        }
    }

    public void getmaxSalary() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT Max(U.salary) FROM User U";
		Query query = session.createQuery(hql);
		double maxSalary =  (Double) query.getSingleResult();

		System.out.println("Maximum Price:" + maxSalary);

        hql = "SELECT COUNT(*) FROM User U";
        List results = session.createQuery(hql).getResultList();
        System.out.println(results);
    }

    public void namedQueryExample() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM User u WHERE u.id = :id";
        TypedQuery query = session.createQuery(hql);
        query.setParameter("id",2);
        List<User> result = query.getResultList();

        for (User u : result) {
            System.out.println(
                "User Id: " + u.getId() + "| Full Name: " + u.getFullname() +
                "| Email: " + u.getEmail() + "| Password: " + u.getPassword());
        }
    }

}
