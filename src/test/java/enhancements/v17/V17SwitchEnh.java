package enhancements.v17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V17SwitchEnh {


    @Test
    public void userIfElseAndNewSwitch_thenGetSameResult() {
        assertEquals(oldWay(12), newWay(12));
    }


    static String oldWay(Object o) {

        if (o instanceof Integer i) {
            return "int" + i;
        } else if (o instanceof Long l) {
            return "long" + l;
        } else if (o instanceof Double d) {
            return "double" + d;
        } else {
            return null;
        }
    }

    static String newWay(Object o) {
        return switch (o) {
            case Integer i -> "int" + i;
            case Long l -> "long" + l;
            case Double d -> "double" + d;
            default -> null;
        };
    }

    @Test
    public void useNullInSwitch() {
        assertTrue(useNullInSwitch(null).equals("null"));
    }

    public static String useNullInSwitch(Object o) {
        return switch (o) {
            case Integer a -> a + "int";
            case null -> "null";
            default -> "default";
        };
    }

    @Test
    public void useMultipleConditionInSwitch() {
        assertEquals(useMultipleConditionInSwitch(-3), useMultipleConditionInSwitch("-3"));
    }

    public static String useMultipleConditionInSwitch(Object o) {
        return switch (o) {
            case Integer a && a > 0 -> "start with +";
            case Integer a && a < 0 -> "start with -";
            case String a && a.startsWith("-") -> "start with -";
            case String a && a.startsWith("+") -> "start with +";
            default -> "illegal";
        };
    }


}
