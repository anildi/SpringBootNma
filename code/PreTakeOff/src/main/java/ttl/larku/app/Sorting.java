package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author whynot
 */
public class Sorting {


    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        //sorting.naturalOrdering();
        sorting.comparator();
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {

    }

    public void naturalOrdering() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
//        Collections.sort(students);

        students.forEach(System.out::println);
    }

    public static <T> void sort(List<T> list, Comparator<T> c) {

    }

    public void comparator() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
        NameComparator nc = new NameComparator();

        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Student> l1 = (Student o1, Student o2) -> {
            return o1.getName().compareTo(o2.getName());
        };

        Comparator<Student> l2 = (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        };

        Comparator<Student> l3 = (o1, o2) -> o1.getName().compareTo(o2.getName());

        Collections.sort(students, l3);

        Collections.sort(students, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        students.forEach(System.out::println);

        Collections.sort(students, (o1, o2) -> {
            return o1.getDob().compareTo(o2.getDob());
        });
        students.forEach(System.out::println);
    }

    public class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static void init(StudentService ss) {
        ss.addStudent("Manoj", "282 939 9944", LocalDate.of(2000, 10, 10), Student.Status.FULL_TIME);
        ss.addStudent("Shiraz", "282 939 9944", LocalDate.of(1999, 8, 10), Student.Status.HIBERNATING);
        ss.addStudent("Stan", "383 939 9944", LocalDate.of(1954, 10, 10), Student.Status.PART_TIME);
        ss.addStudent("Rachna", "282 939 9944", LocalDate.of(1970, 10, 10), Student.Status.FULL_TIME);
    }
}
