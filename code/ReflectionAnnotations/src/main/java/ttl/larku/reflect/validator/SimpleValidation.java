package ttl.larku.reflect.validator;

/**
 * @author whynot
 */
public class SimpleValidation {

    public static void main(String[] args) {
        Car c = new Car();
        c.setModelName("Toyota");

        boolean result = validateCar(c);

    }

    public static boolean validateCar(Car c) {
        if(c.getModelName() == null) {
            return false;
        }
        return true;
    }
}
