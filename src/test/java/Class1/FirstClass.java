package Class1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstClass {


    //Annotation
    @Test
    public void method1(){
        System.out.println("hi");

        int a =10;
        int b = 20;
        boolean res = b>a;
        Assert.assertTrue(res,"res is not as expexted");






    };

    @Test
    public void method2(){
        System.out.println("hello");
    };


}
