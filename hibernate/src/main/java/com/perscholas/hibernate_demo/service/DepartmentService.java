package com.perscholas.hibernate_demo.service;

import com.perscholas.hibernate_demo.model.Dep;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DepartmentService {

    private SessionFactory factory;
    private Session session;
    private Transaction tx;

    public void createDepartment(Dep department) {
        connect();
        session.save(department);
        tx.commit();
        dispose();
    }

    public void updateDepartment(Dep department) {
        connect();
        session.merge(department);
        tx.commit();
        dispose();
    }

    public void findDepartmentById(int id) {
        connect();
        Dep department = session.load(Dep.class, id);
        System.out.println(department);
		tx.commit();
        dispose();
    }

    public void deleteDepartmentById(int id) {
        connect();
        Dep department = new Dep();
        department.setId(id);
        session.delete(department);
        tx.commit();
        dispose();
    }

    private void connect() {
        factory = new Configuration().configure().buildSessionFactory();
    	session = factory.openSession();
        tx = session.beginTransaction();
    }

    private void dispose() {
        session.close();
        factory.close();
    }

}
