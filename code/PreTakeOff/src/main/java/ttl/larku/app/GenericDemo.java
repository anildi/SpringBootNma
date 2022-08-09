package ttl.larku.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author whynot
 *
 * Object                                    List<Object>
 *
 * Number                                    List<Number>
 *
 * Integer                                   List<Integer>
 */
public class GenericDemo {

    public static void main(String[] args) {
        GenericDemo gd = new GenericDemo();
        gd.go();
    }

    public void go() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(22.3);
        numbers.add(44.5);
        numbers.add(10);
        numbers.add(27);

        double sum = sum(numbers);
        System.out.println("sum: " + sum);

        List<Integer> lints = new ArrayList<>();
        lints.add(10);
        lints.add(20);
        lints.add(30);
//        lints.add(33.555);

        double intSum = sum(lints);
        Integer [] iarr = {0, 2, 5, 29};
        addAll(lints, iarr);

        addAll(numbers, iarr);

        System.out.println(lints);

        List<String> lstr = new ArrayList<>();
        int x = frequency(lstr, "abc");
        System.out.println("x: " + x);
//        sum(lstr);
        x = frequency(numbers, 44.5);
        System.out.println("x: " + x);
    }

//    static int 	frequency(Collection<Object> c, Object o) {
//        int result = 0;
//        for(Object obj : c)  {
//            if(obj.equals(o)) {
//                result++;
//            }
//        }
//        return result;
//    }

    //PECS - Producer Extends, Consumer Super
//    public static <T> void copy(List<? super T> dest, List<? extends T> src)

    static int 	frequency(Collection<?> c, Object o) {
        int result = 0;
        for(Object obj : c)  {
           if(obj.equals(o)) {
               result++;
           }
        }
        return result;
    }

    public <T> void addAll(List<? super T> input, T [] arr) {
//        Integer it = input.get(0);
        for(T i : arr) {
            input.add(i);
        }
    }

    public double sum(List<? extends Number> input) {
//        input.add(33.555);
        double sum = 0;
        for(Number n : input) {
            sum += n.doubleValue();
        }
        return sum;
    }

}
