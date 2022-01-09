package enhancements.v9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


/**
 * reminding:
 * Immutable is not the unmodifiable.
 * Unmodifiable collection is a view. The collection still can be changed by modifiable reference.
 * Immutable collection is a readonly copy can not be changed.
 *
 */
public class V9CollectionEnh {

    @Test
    public  void whenTryModifyImmutableCollection_thenThrowException(){
        Assertions.assertThrows(UnsupportedOperationException.class,()->List.of().add(1));
        Assertions.assertThrows(UnsupportedOperationException.class,()->Map.of().put("k","v"));
    }
}
