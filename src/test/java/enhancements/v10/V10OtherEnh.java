package enhancements.v10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class V10OtherEnh {

    @Test
    public  void whenUseListCopy_thenGetUnmodifiableList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> unmodifiableRefOfTheList  =List.copyOf(list);
        assertThrows(UnsupportedOperationException.class,()->unmodifiableRefOfTheList.add(2));
        list.add(2);
        assertEquals(List.of(1,2),list);//modifiable but not immutable that's why we can manipulate with modifiable ref.
    }

    @Test
    public void whenUseOptionalOrElseThrowWithSuitableCondition_thenThrowSelectedException(){
        assertThrows(RuntimeException.class,
                ()->List.of(1,3,5).stream().filter(i->i%2==0).findAny().orElseThrow(RuntimeException::new)
        );
    }


}
