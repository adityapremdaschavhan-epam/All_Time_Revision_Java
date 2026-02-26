package test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

/*
 ============================================================================
  TESTNG FUNDAMENTALS & MENTALITY DEMO
 ----------------------------------------------------------------------------
  This file is meant for:
  - Lifetime TestNG revision
  - Understanding execution flow
  - Understanding WHY things exist, not just HOW
 ============================================================================
*/

/*
 Listener is attached at class level
 This helps understand when TestNG invokes lifecycle hooks
*/

//@Listeners(TestNGListenerDemo.class)
public class TestNGFundamentalsDemo {
     /*
     =========================
     SUITE LEVEL
     =========================
     Runs ONCE before & after entire test suite
    */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">> @BeforeSuite : Environment setup (DB, config, reports)");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">> @AfterSuite : Global cleanup & report finalization");
    }

    /*
     =========================
     TEST LEVEL (from testng.xml <test>)
     =========================
     Runs once per <test> tag in suite XML
    */

    @BeforeTest
    public void beforeTest() {
        System.out.println(">> @BeforeTest : Test-level setup (browser, base URL)");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(">> @AfterTest : Test-level teardown");
    }

    /*
     =========================
     CLASS LEVEL
     =========================
     Runs once per class
    */

    @BeforeClass
    public void beforeClass() {
        System.out.println(">> @BeforeClass : Class-level setup");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(">> @AfterClass : Class-level cleanup");
    }

    /*
     =========================
     METHOD LEVEL
     =========================
     Runs before & after EACH @Test
    */

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(">> @BeforeMethod : Fresh state before test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(">> @AfterMethod : Cleanup after test method");
    }

    /*
     =========================================================
     1️⃣ HAPPY PATH TESTS (PRIORITY + GROUPS)
     =========================================================
     Morals:
     - Test normal behavior FIRST
     - Priority = readability, NOT dependency
    */

    @Test(priority = 1, groups = {"happy-path"})
    public void depositValidAmount() {
        System.out.println("TEST: Deposit valid amount");
        Assert.assertTrue(true);
    }

    @Test(priority = 2, groups = {"happy-path"})
    public void withdrawLessThanBalance() {
        System.out.println("TEST: Withdraw less than balance");
        Assert.assertTrue(true);
    }

    @Test(priority = 3, groups = {"happy-path"})
    public void withdrawEqualToBalance() {
        System.out.println("TEST: Withdraw equal to balance");
        Assert.assertTrue(true);
    }

    /*
     =========================================================
     2️⃣ NEGATIVE PATH TESTS (EXCEPTIONS)
     =========================================================
     Morals:
     - Failure behavior is ALSO business logic
     - Exception tests are behavior tests
    */

    @Test(priority = 10, groups = {"negative-path"})
    public void withdrawMoreThanBalance() {
        System.out.println("TEST: Withdraw more than balance");

        IllegalArgumentException ex =
                Assert.expectThrows(IllegalArgumentException.class,
                        () -> {
                            throw new IllegalArgumentException("Insufficient balance");
                        });

        Assert.assertEquals(ex.getMessage(), "Insufficient balance");
    }

    /*
     =========================================================
     3️⃣ DEPENDENCY DEMO
     =========================================================
     Morals:
     - Use dependency ONLY when logic demands it
     - Failed dependency SKIPS dependent test
    */

    @Test(groups = {"dependency-demo"})
    public void login() {
        System.out.println("TEST: Login successful");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "login", groups = {"dependency-demo"})
    public void viewDashboard() {
        System.out.println("TEST: Dashboard visible only after login");
        Assert.assertTrue(true);
    }

    /*
     =========================================================
     4️⃣ DATA-DRIVEN TESTING (DataProvider)
     =========================================================
     Morals:
     - Same logic, multiple inputs
     - Avoid duplicate test methods
    */

    @DataProvider(name = "withdrawData")
    public Object[][] withdrawData() {
        return new Object[][]{
                {100, 50},
                {200, 100},
                {300, 150}
        };
    }

    @Test(dataProvider = "withdrawData", groups = {"data-driven"})
    public void withdrawUsingDataProvider(int balance, int withdrawAmount) {
        System.out.println("TEST: DataDriven -> balance=" + balance + ", withdraw=" + withdrawAmount);
        Assert.assertTrue(balance >= withdrawAmount);
    }

    /*
     =========================================================
     5️⃣ PARAMETERIZED TESTING (from XML)
     =========================================================
     Morals:
     - Externalize configuration
     - Avoid hardcoding environment values
    */

    @Parameters({"browser", "env"})
    @Test(groups = {"parameterized"})
    public void parameterizedTest(String browser, String env) {
        System.out.println("TEST: Running on Browser=" + browser + ", Env=" + env);
        Assert.assertNotNull(browser);
    }

}
