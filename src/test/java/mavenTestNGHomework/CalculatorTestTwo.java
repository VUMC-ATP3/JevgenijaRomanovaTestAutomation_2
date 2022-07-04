package mavenTestNGHomework;

import calculatorNineHW.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;


public class CalculatorTestTwo {
    private Calculator calculator;

    @Test
    public void testAdd(){
        System.out.println("Method for addition");
        int actualResult = calculator.add(5,3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(calculator.add(5,3), 8);
        Assert.assertEquals(calculator.add(0,0), 0);
        Assert.assertEquals(calculator.add(10,5), 15);
    }

    @Test
    public void testSubtract(){
        System.out.println("Method for subtraction");
        int actualResult = calculator.substract(5,3);
        int expectedResult = 2;
        Assert.assertEquals(calculator.substract(5,3), 2);
        Assert.assertEquals(calculator.substract(0,0), 0);
        Assert.assertEquals(calculator.substract(10,5), 5);
    }

    @Test
    public void  testMultiplication(){
        System.out.println("Method for multiplication");
        int actualResult = calculator.multiply(5,3);
        int expectedResult = 15;
        Assert.assertEquals(calculator.multiply(5,3),15);
        Assert.assertEquals(calculator.multiply(5,0),0);
        Assert.assertEquals(calculator.multiply(10,5),50);
    }

    @Test
    public void testDivision(){
        System.out.println("Method for division");
        float actualResult = calculator.divide(9,3);
        float expectedResult = 3;
        Assert.assertEquals(calculator.divide(9,3),3);
        Assert.assertEquals(calculator.divide(9,1),9);
        Assert.assertEquals(calculator.divide(30,10),3);
    }

    @BeforeMethod
    public void beforeTest(){
        System.out.println("Tests ir sācies");
    }

    @BeforeClass
    public void beforeMethod(){
        this.calculator = new Calculator();
    }

   @AfterTest
    public void afterTest(){
       System.out.println("Testi pabeigti");

   }

    }

