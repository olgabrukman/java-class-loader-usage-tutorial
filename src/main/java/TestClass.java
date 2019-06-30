/**
 * Created by olgabr on 2/4/2018.
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class TestClass implements LocalModule {
    /*
     * This is an example of a class reference that will be resolved
     * at load time.
     */
    List<Integer> list = new ArrayList<>();
    /** This is our start function */
    public void start(String opt) {
        /* This reference will be resolved at run time. */
        Random r;
        System.out.println("Running the Test class, option was                   '"+opt+"'");
        System.out.println("Now initializing a Random object.");
        r = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(new Integer(r.nextInt()));
        }
        /* This reference should get the cached copy of random. */
        r = new Random();
        System.out.println("A series of 5 random numbers: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+": "+list.get(i));
        }
    }
}