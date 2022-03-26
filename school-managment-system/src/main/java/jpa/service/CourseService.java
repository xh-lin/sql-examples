package jpa.service;

import java.util.List;

import jpa.dao.CourseDAO;
import jpa.dao.DAO;
import jpa.entitymodels.Course;

public class CourseService extends DAO implements CourseDAO {

    private static final String SELECT_ALL_COURSES = "SELECT c FROM Course c";

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses;
        connect();
        courses = session.createQuery(SELECT_ALL_COURSES, Course.class).getResultList();
        dispose();
        return courses;
    }

}
