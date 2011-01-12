package ua.yuri.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * User: yuri
 * Date: May 17, 2010
 */
public class TestClass2 {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("**beforeMethod in TestClass2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("**afterMethod in TestClass2");
    }

    @Test
    public void testMethod1() {
        System.out.println("**testMethod1 from TestClass2");
    }

    @Test
    public void testMethod2() {
        System.out.println("**testMethod2 from TestClass2");
    }

    @Test
    public void testMethod3() {
        System.out.println("**testMethod3 from TestClass2");
    }
}
