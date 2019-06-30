/**
 * Created by olgabr on 2/4/2018.
 */
public class ClassLoaderExample {
    public static void main(String args[]) {
        SimpleClassLoader sc = new SimpleClassLoader();
        Object o;
        String tst = "TestClass";
        System.out.println("This program will use SimpleClassLoader.");
        if (args.length != 0)
            tst = args[0];
        try {
            o = (sc.loadClass(tst)).newInstance();
            ((LocalModule) o).start("none");
        } catch (Exception e) {
            System.out.println("Caught exception : "+e);
        }
    }
}