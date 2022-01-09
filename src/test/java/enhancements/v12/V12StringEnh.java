package enhancements.v12;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class V12StringEnh {

    @Test
    public void whenUseStringIndentMethod_thenAdjustIndentationWithGivenParam(){
        String test= "This is the test line .\nnext line .\nnext line again.";
        String indent5 = "     ";
        test =test.indent(5);
        boolean all5indent= test.lines().allMatch(s->s.startsWith(indent5));
        assertTrue(all5indent);

        String test2= "       This is the test line .\n next line .\n   next line again.";
        test =test2.indent(-100);
        boolean all0indent= test.lines().noneMatch(s-> s.startsWith(" "));
        assertTrue(all0indent);
    }

    Function<String,String> myF = s->s+"applied";
    @Test
    public  void whenUseStringTransformMethod_thenGetFunctionAppliedString(){
             assertEquals("test".transform(myF),"testapplied");
    }

}
