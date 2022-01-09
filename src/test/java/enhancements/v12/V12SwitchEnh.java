package enhancements.v12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V12SwitchEnh {

    @Test
    public void useMultipleCaseLabel() {
        assertEquals(multipleCase("multiple"), multipleCase("case"));
    }

    @Test
    public void useReturnValueWithArrow() {
        assertEquals(returnWithArrow(3), returnWithArrow(5));

    }

    @Test
    public void useReturnValueWithBreak() {
        System.out.println(returnWithBreak(-1));
    }


    public static String multipleCase(String str) {
        String result = "";
        switch (str) {
            case "multiple", "case":
                result = "multiple case";
                break;
            case "test":
                result = "test";
                break;
        }
        return result;
    }

    public static String returnWithArrow(int number) {
        return switch (number) {
            case 1, 3, 5, 7, 9 -> "odd";
            case 0, 2, 4, 6 -> "even";
            default -> "out of the range";
        };
    }


    public static String returnWithBreak(int number) {
//        return switch (number) {
//            case 1:
//            case 2:
//                break "asdasd";
//            case 3:
//                break "three";
//            case 4:
//            case 5:
//            case 6:
//                break "four or five or six";
//            default:
//                break "unknown";
//        };

        return "Java 12 value breaks syntax is no longer compiled in Java 13, uses yield instead!!!, current jdk is 17 thats why this method can not be compiled.";
    }

}
