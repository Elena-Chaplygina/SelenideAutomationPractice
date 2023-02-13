package demoqa.tests.propeties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simpleProperty1Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); //opera
    }
    @Test
    void simpleProperty2Test() {
        String browserName = System.getProperty("browser","firefox");
        System.out.println(browserName); //firefox
    }
    @Test
    void simpleProperty3Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser","firefox");
        System.out.println(browserName); //opera
    }
    @Test
    @Tag("one_property")
    void simpleProperty4Test() {
        String browserName = System.getProperty("browser","firefox");
        System.out.println(browserName); //firefox
    }
    // gradle clean one_property
//gradle clean one_property -Dbrowser=safari

    @Test
    @Tag("hello")
    void simpleProperty5Test() {
        System.out.println("Hello, "+ System.getProperty("user_name", "unknown_student"));
    }
    // gradle clean hello_test
//    Hello, unknown_student

//gradle clean hello_test -Duser_name=Alex
//Hello, Alex
    //gradle clean hello_test -Duser_name=Alex Egorov - не правильно
    //gradle clean hello_test "-Duser_name=Alex Egorov"
    //gradle clean hello_test -Duser_name="Alex Egorov"



}
