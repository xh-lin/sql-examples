package com.perscholas.hibernate_demo;

import com.perscholas.hibernate_demo.controller.DepartmentController;
import com.perscholas.hibernate_demo.controller.FindUserHql;

public class App
{
    private static void Hql() {
        FindUserHql u = new FindUserHql();
        u.findUser();
        u.findUserSelect();
        u.getRecordbyId();
        u.getmaxSalary();
        u.namedQueryExample();
    }

    private static void DepartmentActivity() {
        DepartmentController dc = new DepartmentController();
        int id = 1; // change this id
        dc.creatingDepartment();
        dc.updatingDepartment(id);
        dc.findingDepartment(id);
        dc.deletingDepartment(id);
    }

    public static void main( String[] args ) {
        Hql();
        DepartmentActivity();
    }

}
