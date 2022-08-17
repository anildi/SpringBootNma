/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.bind.annotation.ResponseStatus;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.dao.jpahibernate.JPAStudentDAO;
import ttl.larku.domain.Student;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class JPAStudentDAOTest {

    private String name1 = "Bloke";
    private String name2 = "Blokess";
    private String newName = "Karl Jung";
    private String phoneNumber1 = "290 298 4790";
    private String phoneNumber2 = "3838 939 93939";
    private Student student1;
    private Student student2;

//    @Autowired
    @Resource(name = "studentDAO")
    private JPAStudentDAO dao;

    @BeforeEach
    public void setup() {
    }


    @Test
    public void testGetAll() {
        List<Student> students = dao.getAll();
        assertEquals(4, students.size());
    }

    @Test
    public void testCreate() {
        Student student1 = new Student("Joe", "383 93 2020", Student.Status.FULL_TIME);
        int newId = dao.create(student1).getId();

        Student resultstudent = dao.get(newId);

        assertEquals(newId, resultstudent.getId());
    }

    @Test
    public void testUpdate() {
        int newId = dao.create(student1).getId();

        Student resultStudent = dao.get(newId);

        assertEquals(newId, resultStudent.getId());

        resultStudent.setName(newName);
        dao.update(resultStudent);

        resultStudent = dao.get(resultStudent.getId());
        assertEquals(newName, resultStudent.getName());
    }

    @Test
    public void testDelete() {
        int id1 = dao.create(student1).getId();

        Student resultStudent = dao.get(id1);
        assertEquals(resultStudent.getId(), id1);

        int beforeSize = dao.getAll().size();

        dao.delete(resultStudent);

        resultStudent = dao.get(id1);

        assertEquals(beforeSize - 1, dao.getAll().size());
        assertEquals(null, resultStudent);

    }

}
