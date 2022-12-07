package Language;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Creating and defining a new annotation type
// Specifying a Retention Policy
// Providing values in an annotation

// A simple annotation type.
@Retention(RetentionPolicy.RUNTIME) // MyAnnotation uses @Retention to specify the RUNTIME retention policy.
@interface MyAnnotation {
    String stringValue() default "Testing";
    int intValue() default 9000;
}

public class Annotations {
    // Annotate a method
    @MyAnnotation()
    public static void myMethod() {
        Annotations an = new Annotations();

        try {
            Class c = an.getClass();

            Method m = c.getMethod("myMethod");

            MyAnnotation ann = m.getAnnotation(MyAnnotation.class);

            System.out.println(ann.stringValue() + " " + ann.intValue());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method ot Found!");
        }
    }

    public static void main (String[] args) {
        myMethod();
    }
}
