package ttl.larku.app.trick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author whynot
 */
interface TrickyNess {
    public void doTrick();
}

@Component
//@Profile("dev")
@Order(2)
@Qualifier("us-east")
class Trick1 implements TrickyNess {
    @Override
    public void doTrick() {
        System.out.println("Handstand");
    }
}

@Component
//@Profile("prod")
@Order(3)
@Qualifier("us-west")
class Trick2 implements TrickyNess {
    @Override
    public void doTrick() {
        System.out.println("Cartwheel");
    }
}

@Component
//@Profile("prod")
@Order(1)
@Qualifier("us-west")
class Trick3 implements TrickyNess {
    @Override
    public void doTrick() {
        System.out.println("Card Trick");
    }
}


@Component
class Circus {
    //    @Autowired(required = false)
//    @Qualifier("xyz")
//    @Resource(name = "trick2")
    private TrickyNess trick; //= new Trick2();

    @Autowired
    @Qualifier("us-west")
    private List<TrickyNess> allTricks;

    public void startShow() {
        //trick.doTrick();
        allTricks.forEach(TrickyNess::doTrick);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.scan("ttl.larku.app.trick");
        context.refresh();

        Circus circus = context.getBean("circus", Circus.class);
        circus.startShow();
    }
}
