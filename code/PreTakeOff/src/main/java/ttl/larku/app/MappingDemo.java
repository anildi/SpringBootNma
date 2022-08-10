package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author whynot
 */
public class MappingDemo {


    public static void main(String[] args) {
        MappingDemo mapping = new MappingDemo();
//        mapping.go();
        mapping.go2();
    }

    public void go() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
        List<String> names1 = extractNames(students);

//        names1.forEach(System.out::println);

        List<String> names2 = betterExtractNames(students, s -> s.getName());
        names2.forEach(System.out::println);

        List<String> names3 = evenBetterExtractNames(students, s -> s.getName());
        names3.forEach(System.out::println);

        List<LocalDate> dobs = evenBetterExtractNames(students, s -> s.getDob());
        List<LocalDate> dobs2 = map(students, s -> s.getDob());
    }

    public void go2() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
        List<Student> s1 = filter(students, s -> s.getDob().until(LocalDate.now(), ChronoUnit.YEARS) > 40);
        List<String> s2 = map(s1, s -> s.getName());
        List<String> s6 = map(s1, Student::getName);

        List<String> s3 = map(filter(students, s -> s.getDob().until(LocalDate.now(), ChronoUnit.YEARS) > 40),
                s -> s.getName());

        List<String> s4 = students.stream()
//                .peek(st -> System.out.println("Peek 1: " + st))
                .filter(student -> student.getDob().until(LocalDate.now(), ChronoUnit.YEARS) > 40)
//                .peek(st -> System.out.println("Peek 2: " + st))
                .map(student -> student.getName())
//                .peek(st -> System.out.println("Peek 3: " + st))
                .collect(Collectors.toList());

        //void 	accept(T t)
//        s4.forEach(student -> System.out.println(student));
        Consumer<String> c = new MyConsumer();
//        s4.forEach(c);

        s4.forEach(s -> myPrettyPrinter(s));
        s4.forEach(this::myPrettyPrinter);

        Map<String, String> map = Map.of("a", "a value", "b", "b value");
        //void 	accept(T t, U u)
        //map.forEach((k, v) -> System.out.println(k + ": " + v));
        map.forEach(this::myMapPrinter);
    }

    public void myMapPrinter(Object key, Object value) {
        System.out.println("[[ " + key + ", " + value + " ]]");
    }

    public void myPrettyPrinter(Object s) {
        //Lots' of stuff
        System.out.println("[[ " + s + " ]]");

        //Other stuff
    }

    class MyConsumer implements Consumer<String>
    {
        @Override
        public void accept(String student) {
            System.out.println(student);
        }
    }

    public <T, R> List<R> map(List<T> input, Function<T, R> extractor) {
        List<R> result = new ArrayList<>();
        for(T s : input) {
            result.add(extractor.apply(s));
        }
        return result;
    }

    public <T> List<T> filter(List<T> input, Predicate<T> checker) {
        List<T> result = new ArrayList<>();
        for(T t : input) {
            if(checker.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    interface BetterExtractor<T, R>
    {
        public R extract(T t);
    }

    public <T, R> List<R> evenBetterExtractNames(List<T> input, BetterExtractor<T, R> extractor) {
        List<R> result = new ArrayList<>();
        for(T s : input) {
            result.add(extractor.extract(s));
        }
        return result;
    }

    interface Extractor
    {
        public String extract(Student student);
    }

    public List<String> betterExtractNames(List<Student> input, Extractor extractor) {
        List<String> result = new ArrayList<>();
        for(Student s : input) {
            result.add(extractor.extract(s));
        }
        return result;
    }

    public List<String> extractNames(List<Student> input) {
        List<String> result = new ArrayList<>();
        for(Student s : input) {
            result.add(s.getName());
        }
        return result;
    }



    public static void init(StudentService ss) {
        ss.addStudent("Manoj", "282 939 9944", LocalDate.of(2000, 10, 10), Student.Status.FULL_TIME);
        ss.addStudent("Shiraz", "282 939 9944", LocalDate.of(1999, 8, 10), Student.Status.HIBERNATING);
        ss.addStudent("Stan", "383 939 9944", LocalDate.of(1954, 10, 10), Student.Status.PART_TIME);
        ss.addStudent("Rachna", "282 939 9944", LocalDate.of(1970, 10, 10), Student.Status.FULL_TIME);
    }
}
