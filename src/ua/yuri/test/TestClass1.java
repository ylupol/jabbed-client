package ua.yuri.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * User: yuri
 * Date: May 17, 2010
 */
public class TestClass1 {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("*beforeMethod in TestClass1");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("*afterMethod in TestClass1");
    }

    @Test
    public void testMethod1() {
        System.out.println("*testMethod1 from TestClass1");
    }

    @Test
    public void testMethod2() {
        System.out.println("*testMethod2 from TestClass1");
    }

    @Test
    public void testMethod3() {
        System.out.println("*testMethod3 from TestClass1");
    }
}
