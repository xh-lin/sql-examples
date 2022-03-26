package jpa.service;

import java.util.ArrayList;
import java.util.List;

import jpa.PasswordEncryptor;
import jpa.dao.DAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends DAO implements StudentDAO {

    private static final String SELECT_ALL_STUDENTS = "SELECT s FROM Student s";

    private PasswordEncryptor encryptor = new PasswordEncryptor();

    @Override
    public List<Student> getAllStudents() {
        List<Student> students;
        connect();
        students = session.createQuery(SELECT_ALL_STUDENTS, Student.class).getResultList();
        dispose();
        return students;
    }


    // if student email is invalid, will return null
    @Override
    public Student getStudentByEmail(String sEmail) {
        Student student;
        connect();
        student = session.get(Student.class, sEmail);
        dispose();
        return student;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        Student student = getStudentByEmail(sEmail);
        return student != null && encryptor.validate(sPassword, student.getSPass());
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        Student student = getStudentByEmail(sEmail);
        if (student == null) return;

        Course course;
        connect();
        course = session.get(Course.class, cId);
        // if course id is valid and student hasn't registered this course
        if (course != null && !student.getSCourses().contains(course)) {
            student.getSCourses().add(course);
            session.merge(student);
        }
        dispose();
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        Student student = getStudentByEmail(sEmail);
        if (student == null) {
            return new ArrayList<>();
        }
        return student.getSCourses();
    }

}
