package ttl.larku.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ttl.larku.domain.Student;

/**
 * @author whynot
 */
public class StudentDAO {

//    private Map<Integer, Student> students = new HashMap<>();
    private Map<Integer, Student> students = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);
//    private int nextId = 1;

    public Student insert(Student s) {
//    	int id = nextId++;
    	int id = nextId.getAndIncrement();
    	s.setId(id);
        students.put(s.getId(), s);

        return s;
    }

    public Student get(int id) {
        return students.get(id);
    }

    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

    public boolean delete(int id) {
//      Student s = students.remove(id);
//      if(s == null) {
//          return false;
//      }
//      return true;

       return students.remove(id) != null;
    }

    public boolean update(Student newStudent) {
        return students.replace(newStudent.getId(), newStudent) != null;
    }
}

class Someplaceelse {
    public static void main(String[] args) {
        StudentDAO sd = new StudentDAO();
        Student s = new Student();
        s.setId(10);
        sd.insert(s);
        List<Student> students = sd.getAll();

//        students.clear();

        students = sd.getAll();
        System.out.println(students);
    }
}
