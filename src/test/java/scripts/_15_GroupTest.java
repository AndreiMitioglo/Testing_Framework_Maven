package scripts;

import org.testng.annotations.Test;

public class _15_GroupTest {
    @Test(groups= {"Functional", "Login"})
    public void test6(){
        System.out.println("Thi is test 6");

    }
}
