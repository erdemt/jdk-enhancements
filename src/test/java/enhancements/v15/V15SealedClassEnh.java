package enhancements.v15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class V15SealedClassEnh {

    //can be used with interface as well.
    //Using with the Records is a nice option.

    /**
     * permits Circle, Square, Polygon classes mut directly extend Shape
     */
    public sealed class Shape permits Circle, Square, Polygon {
    }

    /**
     * classes which extends sealed class must be final, sealed or non-sealed
     * this is the final one
     */
    final class Circle extends Shape {

    }

    /**
     * classes which extends sealed class must be final, sealed or non-sealed
     * this is the non-sealed one
     */
    non-sealed class Square extends Shape {

    }

    /**
     * classes which extends sealed class must be final, sealed or non-sealed
     * this is the sealed one
     * <p>
     * sealed classes must have a subclass
     */
    sealed class Polygon extends Shape {

    }

    final class Rectangle extends Polygon {

    }

    class BiqSquare extends Square {

    }


    @Test
    public void userSealedClassReflection() {

        assertTrue(Shape.class.isSealed());
        assertTrue(Rectangle.class.getSuperclass().getSuperclass().isSealed());
        assertTrue(Arrays.stream(Rectangle.class.getSuperclass().getSuperclass().getPermittedSubclasses()).collect(Collectors.toList()).contains(Circle.class));
    }


}
