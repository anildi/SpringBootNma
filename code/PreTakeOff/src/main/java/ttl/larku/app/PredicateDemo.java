package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author whynot
 */
public class PredicateDemo {


    public static void main(String[] args) {
        PredicateDemo predicate = new PredicateDemo();
        //sorting.naturalOrdering();
//        predicate.go();
        predicate.go2();
    }

    public void go() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
        List<Student> withM = getStudentsNamesStartingWithM(students, "M");

        withM.forEach(System.out::println);
    }

    public void go2() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
        Checker checker = new WithM();

        Checker checker2 = new Checker() {
            @Override
            public boolean check(Student student) {
                return student.getName().startsWith("M");
            }
        };

        Checker checker3 = (Student student) -> {
                return student.getName().startsWith("M");
            };

        Checker checker4 = (student) -> student.getName().startsWith("M");

        Checker checker5 = student -> student.getName().startsWith("M");

        List<Student> withM = getGetStudentByCriteria(students, student -> student.getName().startsWith("M"));

        List<Student> olderThan40 = getGetStudentByCriteria(students, student -> {
            LocalDate now = LocalDate.now();
            return student.getDob().until(now, ChronoUnit.YEARS) > 40;
        });

        olderThan40.forEach(System.out::println);
    }

    public void go3() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
        List<Student> withM = betterSelector(students, s -> s.getName().startsWith("M"));

        List<String> lStr = List.of("Hello", "To", "youuuuuu");
        List<String> lgt6 = betterSelector(lStr, s -> s.length() > 6);

        List<String> lgt7 = bestSelector(lStr, s -> s.length() > 6);
    }

    public <T> List<T> bestSelector(List<T> input, Predicate<T> checker) {
        List<T> result = new ArrayList<>();
        for(T t : input) {
            if(checker.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    @FunctionalInterface
    interface BetterChecker<T>
    {
        public boolean check(T student);
    }

    public <T> List<T> betterSelector(List<T> students, BetterChecker<T> checker) {
        List<T> result = new ArrayList<>();
        for(T student : students) {
            if(checker.check(student)) {
                result.add(student);
            }
        }
        return result;
    }

    interface Checker
    {
        public boolean check(Student student);
    }

    public List<Student> getGetStudentByCriteria(List<Student> students, Checker checker) {
        List<Student> result = new ArrayList<>();
        for(Student student : students) {
            if(checker.check(student)) {
                result.add(student);
            }
        }
        return result;
    }


    public List<Student> getStudentsNamesStartingWithM(List<Student> students, String searchString) {
        List<Student> result = new ArrayList<>();
        for(Student student : students) {
            if(student.getName().startsWith(searchString)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getStudentsWithPhoneNumbers(List<Student> students, String searchString) {
        List<Student> result = new ArrayList<>();
        for(Student student : students) {
            if(student.getPhoneNumber().startsWith(searchString)) {
                result.add(student);
            }
        }
        return result;
    }



    public class WithM implements Checker
    {
        @Override
        public boolean check(Student student) {
            return student.getName().startsWith("M");
        }
    }

    public static void init(StudentService ss) {
        ss.addStudent("Manoj", "282 939 9944", LocalDate.of(2000, 10, 10), Student.Status.FULL_TIME);
        ss.addStudent("Shiraz", "282 939 9944", LocalDate.of(1999, 8, 10), Student.Status.HIBERNATING);
        ss.addStudent("Stan", "383 939 9944", LocalDate.of(1954, 10, 10), Student.Status.PART_TIME);
        ss.addStudent("Rachna", "282 939 9944", LocalDate.of(1970, 10, 10), Student.Status.FULL_TIME);
    }
}
