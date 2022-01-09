package enhancements.v10;

public class V10LocalVariableTypeInferenceEnh {

    public static void test(){
      var a =5;
      int var =2;// not backward compatible & not reserved keyword
      //var x; compile time error,must be initialized
    }
}
