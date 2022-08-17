/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.dao.jpahibernate;

import org.springframework.transaction.annotation.Transactional;
import ttl.larku.dao.BaseDAO;
import ttl.larku.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Transactional
public class JPAStudentDAO implements BaseDAO<Student> {

    @PersistenceContext
    private EntityManager manager;

    private String from;

    public JPAStudentDAO(String from) {
        this.from = from + ": ";
    }

    public JPAStudentDAO() {
        this("JPA");
    }

    public boolean update(Student updateObject) {
        manager.merge(updateObject);
        return true;
    }

    public boolean delete(Student student) {
        manager.remove(student.getId());
        return true;
    }

    public Student create(Student newObject) {
        manager.persist(newObject);

        return newObject;
    }

    public Student get(int id) {
        return manager.find(Student.class, id);
    }

    public List<Student> getAll() {
        TypedQuery<Student> query = manager.createQuery("Select s from Student s", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    public void deleteStore() {
//        students = null;
    }

    public void createStore() {
//        students = new ConcurrentHashMap<>();
//        nextId = new AtomicInteger(1);
    }

    public Map<Integer, Student> getStudents() {
        return null;
    }
}
