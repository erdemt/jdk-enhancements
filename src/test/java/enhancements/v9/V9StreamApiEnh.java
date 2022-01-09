package enhancements.v9;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class V9StreamApiEnh {

    @Test
    public void whenUseStreamDropWhile_thenDropAllElementsUntilPredicateFail() {
        List<Integer> result1 = Stream.of(1, 2, 40, 60, 100).dropWhile(n -> n < 50).collect(Collectors.toList());
        assertEquals(List.of(60, 100), result1);
        List<Integer> result2 = Stream.of(1, 2, 40, 60, 100, 5, 200).dropWhile(n -> n < 50).collect(Collectors.toList());
        assertEquals(List.of(60, 100, 5, 200), result2);
    }

    @Test
    public  void whenUseStreamTakeWhile_thenTakeAllElementsUntilPredicateFail() {
        List<Integer> result1 = Stream.of(1, 2, 40, 60, 100).takeWhile(n -> n < 50).collect(Collectors.toList());
        assertEquals(List.of(1,2,40),result1);
        List<Integer> result2 =   Stream.of(1, 2, 40, 60, 100, 5, 200).takeWhile(n -> n < 50).collect(Collectors.toList());
        assertEquals(List.of(1,2,40),result2);
    }

    @Test
    public  void useStreamWithIterate() {
        Stream.iterate(1, i -> i < 10, i -> ++i).forEach(System.out::println);
    }

    @Test
    public void whenUseNullInNullableStream_thenConsiderNullValues() {
        Integer nullVal = null;
        assertEquals(List.of(), Stream.ofNullable(nullVal).collect(Collectors.toList()));
    }

    @Test
    public  void useOptionalToStream() {
      assertEquals(List.of(1),List.of(Optional.of(1),Optional.empty()).stream().flatMap(Optional::stream).collect(Collectors.toList()));
    }

}
