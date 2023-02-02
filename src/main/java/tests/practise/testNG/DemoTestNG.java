package tests.practise.testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTestNG {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }


}
