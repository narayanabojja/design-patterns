package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite Pattern is a structural design pattern that allows you to
 * compose objects into tree structures to represent part-whole hierarchies. It
 * lets clients treat individual objects and compositions of objects uniformly.
 * 
 * In Java, the Composite Pattern is useful when you have a hierarchy of objects
 * and you want to treat individual objects and groups of objects in the same
 * way.
 */

// Component
interface Graphic {
    void print();
}

// Leaf
class Ellipse implements Graphic {
    public void print() {
        System.out.println("Ellipse");
    }
}

// Leaf
class Rectangle implements Graphic {
    public void print() {
        System.out.println("Rectangle");
    }
}

// Composite
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void print() {
        for (Graphic graphic : graphics) {
            graphic.print();
        }
    }
}

// Client
public class CompositePatternExample {
    public static void main(String[] args) {
        Ellipse ellipse = new Ellipse();
        Rectangle rectangle = new Rectangle();

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(ellipse);
        compositeGraphic.add(rectangle);

        compositeGraphic.print();
    }
}
