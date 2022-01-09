package enhancements.v11;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class V11OtherEnh {

    @Test
    public void useCollectionToArray(){
       String[] arr = {};
       assertEquals(arr.getClass(),List.of().toArray(String[]::new).getClass());
    }
    @Test
    public void usePredicateNot(){
        long notBlankCount =Stream.of("abc","xyz").filter(Predicate.not(String::isBlank)).count();
        assertEquals(notBlankCount,2L);
    }
}
