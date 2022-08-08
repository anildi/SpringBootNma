package ttl.larku.service;

import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author whynot
 */
public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public Student addStudent(String name, String phoneNumber, LocalDate dob, Student.Status status) {
        Student s = new Student(name, phoneNumber, dob, status);
        return addStudent(s);
    }

    public Student addStudent(Student s) {

        LocalDate now = LocalDate.now();
        long age = s.getDob().until(now, ChronoUnit.YEARS);
        if(age < 17) {
            throw new RuntimeException("Need to be at least 17 years old");
        }

        return studentDAO.insert(s);
    }

    public Student getStudent(int id) {
        return studentDAO.get(id);
    }
}
