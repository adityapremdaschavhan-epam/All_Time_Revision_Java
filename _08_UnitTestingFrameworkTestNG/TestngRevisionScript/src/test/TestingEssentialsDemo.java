package src.test;// TestNG does NOT create a new test class instance per DataProvider invocation by default.

import org.testng.Assert;
import org.testng.annotations.*;

public class TestingEssentialsDemo {

    private BankAccount account;
//
//    /* =========================================================
//       SUITE LEVEL
//       ========================================================= */
//
    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">>> @BeforeSuite : Runs ONCE before entire suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">>> @AfterSuite : Runs ONCE after entire suite");
    }
//
//    /* =========================================================
//       TEST LEVEL (testng.xml <test>)
//       ========================================================= */
//
    @BeforeTest
    public void beforeTest() {
        System.out.println(">>> @BeforeTest : Runs ONCE before <test> block");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(">>> @AfterTest : Runs ONCE after <test> block");
    }
//
//    /* =========================================================
//       CLASS LEVEL
//       ========================================================= */
//
    @BeforeClass
    public void beforeClass() {
        System.out.println(">>> @BeforeClass : Runs ONCE before class execution");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(">>> @AfterClass : Runs ONCE after class execution");
    }
//
//    /* =========================================================
//       METHOD LEVEL (MOST IMPORTANT)
//       ========================================================= */

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.out.println(">>> @BeforeMethod : Fresh BankAccount created");
        account = new BankAccount(0.0, "Aditya");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(">>> @AfterMethod : Cleaning up test data");
        account = null;
    }

    /* =========================================================
       HAPPY PATH TESTS
       ========================================================= */

    @Test(
            groups = "Happy-Path",
            priority = 1,
            description = "Deposit money into empty account"
    )
    public void shouldDepositIntoEmptyAccount() {
        account.deposit(100);
        Assert.assertEquals(account.getBalance(), 100.0);
        System.out.println("shouldDepositIntoEmptyAccount test method runs successfully");
    }
//
    @Test(
            groups = "Happy-Path",
            priority = 2,
            dependsOnMethods = "shouldDepositIntoEmptyAccount",
            description = "Withdraw money less than balance"
    )
    public void shouldWithdrawLessThanBalance() {
        account.deposit(500);
        account.withdraw(200);
        Assert.assertEquals(account.getBalance(), 300.0);
        System.out.println("shouldWithdrawLessThanBalance test method runs successfully");
    }

    /* =========================================================
       SAD PATH (EXCEPTION TESTING)
       ========================================================= */

    @Test(
            groups = "Sad-Path",
            priority = 10,
            description = "Withdraw more than balance should throw exception"
    )
    public void shouldFailWhenWithdrawMoreThanBalance() {
        account.deposit(100);

        IllegalArgumentException ex =
                Assert.expectThrows(
                        IllegalArgumentException.class,
                        () -> account.withdraw(500)
                );

        Assert.assertEquals(ex.getMessage(), "Insufficient balance");
        System.out.println("shouldFailWhenWithdrawMoreThanBalance runs successfully");
    }

    /* =========================================================
       DATA DRIVEN TESTING
       ========================================================= */

    @DataProvider(name = "depositData")
    public Object[][] depositData() {
        return new Object[][] {
                {100, 100},
                {200, 200},
                {500, 500}
        };
    }

    @Test(
            dataProvider = "depositData",
            groups = "Happy-Path",
            priority = 3
    )
    public void depositDataDrivenTest(double deposit, double expectedBalance) {
        account.deposit(deposit);
        Assert.assertEquals(account.getBalance(), expectedBalance);
        System.out.println(deposit + ":- depositDataDrivenTest runs successfully ");
    }

//    /* =========================================================
//       PARAMETERIZED TEST (FROM testng.xml)
//       ========================================================= */
//
//    @Parameters({"initialBalance", "withdrawAmount"})
//    @Test(
//            groups = "Happy-Path",
//            priority = 4
//    )
//    public void parameterizedWithdrawalTest(
//            @Optional("500") double initialBalance,
//            @Optional("200") double withdrawAmount) {
//
//        account.deposit(initialBalance);
//        account.withdraw(withdrawAmount);
//
//        Assert.assertEquals(
//                account.getBalance(),
//                initialBalance - withdrawAmount
//        );
//
//        System.out.println("parametrised test runs successfully");
//
//    }
}
