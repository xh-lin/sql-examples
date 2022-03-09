package com.perscholas.hibernate_demo.controller;

import com.perscholas.hibernate_demo.model.Dep;
import com.perscholas.hibernate_demo.service.DepartmentService;

public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController() {
        departmentService = new DepartmentService();
    }

    public void creatingDepartment() {
        Dep department = new Dep("testName", "testState");
        departmentService.createDepartment(department);
    }

    public void updatingDepartment(int id) {
        Dep department = new Dep("newName", "newState");
        department.setId(id);
        departmentService.updateDepartment(department);
    }

    public void findingDepartment(int id) {
        departmentService.findDepartmentById(id);
    }

    public void deletingDepartment(int id) {
        departmentService.deleteDepartmentById(id);
    }

}
