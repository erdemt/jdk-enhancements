package enhancements.v9;

public class V9PrivateInterfaceEnh {
    interface MyInterface{
        private void test(){}
        // public void test2(){}  compile time error should be default
    }
}


