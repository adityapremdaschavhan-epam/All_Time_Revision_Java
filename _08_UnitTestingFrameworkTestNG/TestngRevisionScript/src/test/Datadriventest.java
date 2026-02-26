package src.test;

import org.Testng.revision.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriventest {

    Calculator calculator;

    @BeforeClass
    public void setup(){
        calculator = new Calculator();
    }

    @DataProvider(name="additionTestData")
    public Object[][] getAddData(){
        Object[][] data = {
            {3,5,8},
            {2,0,2}
        };
        return data;
    }

    @Test(dataProvider = "additionTestData")
    public void AdditionTestCase(int a,int b,int expectedResult){
        Assert.assertEquals(calculator.add(a,b),expectedResult);
        System.out.println("data provider addition test cases are executed successfully");
    }

}
