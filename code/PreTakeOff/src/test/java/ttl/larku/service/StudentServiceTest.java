package ttl.larku.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ttl.larku.domain.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author whynot
 */
public class StudentServiceTest {

    private StudentService studentService;
    private int goodId = 10;
    private int badId = 10000;

    @BeforeEach
    public void init() {
        studentService = new StudentService();
        Student student = new Student(goodId, "Joe", "383 9393 9393", LocalDate.of(2000, 10, 10), Student.Status.FULL_TIME);
        studentService.addStudent(student);
    }

    @Test
    public void testAddStudent() {
        Student s = studentService.getStudent(goodId);

        assertNotNull(s);
        assertEquals(10, s.getId());
    }
}
