package ttl.larku.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import ttl.larku.dao.repo.StudentRepository;
import ttl.larku.domain.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepo;

    @Test
    public void testFindByName() {
        List<Student> found = studentRepo.findByName("Manoj-h2");
        found.forEach(System.out::println);

        assertEquals(1, found.size());

    }

    @Test
    public void testFindByNameContaining() {
        List<Student> found = studentRepo.findByNameContainingIgnoreCase("manoj");
        found.forEach(System.out::println);

        assertEquals(1, found.size());

    }


}
