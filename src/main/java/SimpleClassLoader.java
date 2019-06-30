import java.util.HashMap;
import java.util.Map;

/**
 * Created by olgabr on 2/4/2018.
 */
public class SimpleClassLoader extends ClassLoader {
    private static Map<String, Class> classes = new HashMap<>();
    public synchronized Class loadClass(String className, boolean resolveIt) throws ClassNotFoundException {
        Class result;
        System.out.println(" >>>>>> Load class : " + className);
         /* Check our local cache of classes */
        result = classes.get(className);
        if (result != null) {
            System.out.println(" >>>>>> returning cached result.");
            return result;
        }
        /* Check with the primordial class loader */
        try {
            result = super.findSystemClass(className);
            System.out.println(" >>>>>> returning system class (in CLASSPATH).");
            return result;
        } catch (ClassNotFoundException e) {
            System.out.println("        >>>>>> Not a system class.");
        }
        /* Try to load it from our repository */
        byte[] classData = getClassImplFromDataBase(className);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        /* Define it (parse the class file) */
        result = defineClass(className, classData, 0, classData.length);
        if (resolveIt) {
            resolveClass(result);
        }
        classes.put(className, result);
        System.out.println("        >>>>>> Returning newly loaded class.");
        return result;
    }

    private byte[] getClassImplFromDataBase(String className) {
        String newClassName = "store\\"+className+".impl";
        return new byte[0];
    }
}
