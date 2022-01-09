package enhancements.v12;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class V12CollectorsTeeingEnh {


    @Test
    public void useTeeingToFindCountAndMaxValueInList() {

        List<Number> result = List.of(5, 3, 4, 634, 2, 4).stream().collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.maxBy(Comparator.naturalOrder()),
                (resultOfCount, resultOfComparing) -> {
                    return List.of(resultOfCount, resultOfComparing.get());
                }
        ));

        assertEquals(result.get(0).longValue(), 6l);
        assertEquals(result.get(1).longValue(), 634l);

    }

    @Test
    public void findMinMaxValueByTeeing(){
        Map<String,Integer> result =   Stream.of(1,43,65,7,4,3,2,7).collect(Collectors.teeing(
                Collectors.minBy(Integer::compare),
                Collectors.maxBy(Integer::compare),
                (min,max)->{
                    return Map.of("min",min.get(),"max",max.get());
                }
        ));
        assertEquals(result.get("min"),1);
        assertEquals(result.get("max"),65);
    }


}
