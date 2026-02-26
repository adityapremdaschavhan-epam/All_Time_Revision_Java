package src.test.Testng_session1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

    @BeforeTest
    public void beforeTest() {
        System.out.println(">> @BeforeTest : Test-level setup (browser, base URL)");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(">> @AfterTest : Test-level teardown");
    }


    @Test()
    public void m1() {
        System.out.println("test m1");

    }

    @Test()
    public void m2() {
        System.out.println("TEST m2 ");
    }

    @Test()
    public void m3() {
        System.out.println("test ");
    }
    @Test()
    public void m4() {
        System.out.println("test ");
    }


}
