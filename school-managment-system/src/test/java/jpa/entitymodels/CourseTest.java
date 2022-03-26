package jpa.entitymodels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    void testGetCId() {
        // given
        Course course = new Course(1, "Full Stack", "Eric");
        // when
        int actualId = course.getCId();
        // then
        Assertions.assertEquals(1, actualId);
    }

    @Test
    void testSetCId() {
        // given
        Course course = new Course();
        // when
        course.setCId(1);
        // then
        int actualId = course.getCId();
        Assertions.assertEquals(1, actualId);
    }

}
