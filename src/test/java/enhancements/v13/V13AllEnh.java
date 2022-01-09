package enhancements.v13;

import enhancements.v12.V12SwitchEnh;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V13AllEnh {


    @Test
    public void useReturnWithYield() {
        assertEquals(useReturnValueWithYield(1), "one or two");
    }

    /**
     * @see V12SwitchEnh#useReturnValueWithBreak()
     */
    public static String useReturnValueWithYield(int x) {
        return switch (x) {
            case 1, 2:
                yield "one or two";
            default:
                yield "not one or two";
        };
    }

    @Test
    public void whenUseTextBlock_thenGetSameResultWithOldWay() {
        String oldWay = "fist line\n" +
                "    second line and space\n" +
                "    second line and space\n" +
                "last line without space.\n";

        String newWay = """
                fist line
                    second line and space
                    second line and space
                last line without space.
                """;
       assertTrue(oldWay.equals(newWay));

        String jsonOldWay =
                "{\n" +
                "   \"name\":\"erdem\",\n" +
                "   \"age\":33\n" +
                "}\n";

        String jsonNewWay = """
                {
                   "name":"erdem",
                   "age":33
                }
                """;
        assertTrue(jsonOldWay.equals(jsonNewWay));
    }


}
