package ttl.larku.app;

import java.util.ArrayList;
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
