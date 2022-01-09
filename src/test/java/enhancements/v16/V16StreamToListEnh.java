package enhancements.v16;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class V16StreamToListEnh {

    @Test
    public void useStreamToListNewAndOldWay_thenGetSameResult() {
        //oldWay
        List<Integer> oldWay = Stream.of(1).collect(Collectors.toList());
        //new way
        List<Integer> newWay = Stream.of(1).toList();
        assertEquals(newWay, oldWay);

    }
}
