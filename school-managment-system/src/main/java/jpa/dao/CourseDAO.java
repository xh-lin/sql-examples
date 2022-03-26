package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

public interface CourseDAO {

    /*
        –This method takes no parameter and returns every Course in the table.
    */
    List<Course> getAllCourses();

}
