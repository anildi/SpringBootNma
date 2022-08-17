package ttl.larku.app;

import ttl.larku.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author whynot
 */
public class JPADemo {

    public static void main(String[] args) {
        JPADemo jpaDemo = new JPADemo();
        //jpaDemo.addStudent();
        jpaDemo.updateStudent();
        jpaDemo.dumpAllStudents();
    }
    private EntityManagerFactory factory;

    public JPADemo() {
        factory = Persistence.createEntityManagerFactory("LarkUPU_SE");
    }

    public void dumpAllStudents() {
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Student> query = manager.createQuery("Select s from Student s", Student.class);
        List<Student> students = query.getResultList();

        students.forEach(System.out::println);
    }

    public void addStudent() {
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Student student = new Student("Barney", "383 838 8383", Student.Status.HIBERNATING);

        manager.persist(student);

        manager.getTransaction().commit();

    }

    public void updateStudent() {
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Student student = manager.find(Student.class, 22);
        student.setPhoneNumber("999 9938 93287");

        manager.getTransaction().commit();

    }
}
