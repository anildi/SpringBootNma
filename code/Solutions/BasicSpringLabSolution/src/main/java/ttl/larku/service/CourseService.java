/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.service;

import org.springframework.beans.factory.annotation.Autowired;
import ttl.larku.dao.BaseDAO;
import ttl.larku.domain.Course;

import java.util.List;

public class CourseService {

    //TODO - Dependency Injection using *EITHER* Annotations or XML.
    @Autowired
    //@Resource(name="courseDAO")
    private BaseDAO<Course> courseDAO;

    public Course createCourse(String code, String title) {
        Course course = new Course(code, title);
        course = courseDAO.create(course);

        return course;
    }

    public void deleteCourse(int id) {
        Course course = courseDAO.get(id);
        if (course != null) {
            courseDAO.delete(course);
        }
    }

    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    public Course getCourseByCode(String code) {
        List<Course> courses = courseDAO.getAll();
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    public Course getCourse(int id) {
        return courseDAO.get(id);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAll();
    }

    public BaseDAO<Course> getCourseDAO() {
        return courseDAO;
    }

    public void setCourseDAO(BaseDAO<Course> courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void clear() {
        courseDAO.deleteStore();
        courseDAO.createStore();
    }
}
