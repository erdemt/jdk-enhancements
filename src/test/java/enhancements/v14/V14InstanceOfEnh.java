package enhancements.v14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V14InstanceOfEnh {

    @Test
    public void useInstanceOfWithOldAndNewWay() {
        assertEquals(oldWayInstanceOf(3), newWayInstanceOf(3));
    }


    public static String oldWayInstanceOf(Object o) {
        if (o instanceof String) {
            String val = (String) o;
            return "str" + val;
        } else if (o instanceof Integer) {
            Integer val = (Integer) o;
            return "int" + val;
        }
        return null;
    }

    public static String newWayInstanceOf(Object o) {
        if (o instanceof String val) {
            return "str" + val;
        } else if (o instanceof Integer val) {
            return "int" + val;
        }
        return null;
    }


}
