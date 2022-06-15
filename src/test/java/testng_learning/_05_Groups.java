package testng_learning;

import org.testng.annotations.Test;

public class _05_Groups {

   /*
   Login -> 1, 3, 5
   Purchase -> 2, 3, 4
   Functional -> 5
    */


    @Test(priority = 1,groups = "Login")
    public void test1(){
        System.out.println("This is Test1");
    }

    @Test(priority = 2, groups = "Purchase")
    public void test2(){
        System.out.println("This is Test2");
    }
    @Test(priority = 3, groups = {"Login", "Purchase"})
    public void test3(){
        System.out.println("This is Test3");
    }
    @Test(priority = 4,groups = "Purchase")
    public void test4(){
        System.out.println("This is Test4");
    }

    @Test(priority = 5,groups ={"Login","Purchase"})
    public void test5(){
        System.out.println("This is Test5");
    }
}
