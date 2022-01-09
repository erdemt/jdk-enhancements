package enhancements.v14;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class V14RecordEnh {

    //immutable, hashcode and equals will be implemented by invoke dynamic
    public record User(Long id, String name) {
    }

    //customize constructor
    public record User2(Long id, String name) {
        public User2() {
            this(null, null);
        }
    }

    //customize constructor2
    public record User3(Long id, String name) {
        public User3 { //inside of the constructor
            Objects.requireNonNull(id);
            Objects.requireNonNull(name);
        }
    }

    //customize constructor3
    public record User4(Long id, String name) {
        public User4() {
            this(-1L, "default");
        }
    }


    //extra method
    public record User5(Long id, String name) {
        public String getName() {
            return name;
        }
// compile error- immutable
//          public void setName(String name){
//             this.name=name;
//          }
    }


    public class SuperClassTest {

    }

    public interface InterfaceTest {

    }

//   records already extends Record class
//    public record User6 (Long id ,String name ) extends SuperClassTest{
//    }


    public record User7(Long id, String name) implements InterfaceTest {
    }


    @Test
    public void useRecord() {
        User user = new User(1L, "John");
        User user2 = new User(1L, "John");
        assertTrue(user.equals(user2));
        assertTrue(user.hashCode() == user2.hashCode());
    }


}
