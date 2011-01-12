package ua.yuri;

import org.testng.annotations.*;

public class SimpleTest {
    int a;
    @BeforeMethod
    public void setUp() {
        System.out.println("setUp()");
        a=5;

    }

    @Test(groups = {"fast"})
    public void aFastTest() {
        System.out.println("Fast test");
        
    }

    @Test(groups = {"slow"})
    public void aSlowTest() {
        System.out.println("Slow Test");
    }
}
