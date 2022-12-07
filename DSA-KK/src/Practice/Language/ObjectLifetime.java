package Language;

// Disposing of dead objects (Garbage collection)
// and recovering the memory

class Sphere {
    double radius;

    Sphere() {

    }

    Sphere(double radius) {
        this.radius = radius; // Set the radius
    }
}

public class ObjectLifetime {
    public static void main (String[] args) {
        Sphere sphere = new Sphere();

        System.gc();
    }
}
