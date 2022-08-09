package ttl.larku.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ttl.larku.domain.Student;

/**
 * @author whynot
 */
public class StudentDAOTest {

    private StudentDAO dao;
    private int goodId = 1;
    private int badId = 10000;

    @BeforeAll
    public static void uberInit() {

    }

    @BeforeEach
    public void init() {
        dao = new StudentDAO();
        Student student = new Student("Joe", "383 9393 9393", LocalDate.of(2000, 10, 10), Student.Status.FULL_TIME);
        dao.insert(student);
    }

    @Test
    public void testInsert() {
        Student insertedStudent = dao.get(goodId);

        assertNotNull(insertedStudent);
        assertEquals(goodId, insertedStudent.getId());
    }

    @Test
    public void testDeleteExisting() {
        Student student = dao.get(goodId);

        boolean result = dao.delete(goodId);

        assertTrue(result);
    }

    @Test
    public void testDeleteNotExisting() {
        boolean result = dao.delete(1000000);

        assertFalse(result);
    }

    @Test
    public void testUpdateExisting() {
        Student student = dao.get(goodId);

        student.setName("Sammy");
        boolean result = dao.update(student);

        assertTrue(result);
    }

//    @Test
    public void testUpdateNotExisting() {
        Student student = dao.get(goodId);

        student.setId(100000);
        student.setName("Sammy");
        boolean result = dao.update(student);

        assertFalse(result);
    }
}
