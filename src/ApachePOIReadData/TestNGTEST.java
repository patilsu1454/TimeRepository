package ApachePOIReadData;

import org.testng.annotations.*;

public class TestNGTEST {

@BeforeClass
public void connectDb(){
System.out.println("Before Class:Db connection is successfull");
}

@BeforeMethod
public void openBrowser(){
System.out.println("Before Method:Browser opened");
}

@AfterMethod
public void closeBrowser(){
System.out.println("After Method:Browser Closed");
}

@Test
public void testChrome(){
System.out.println("Test1 :Chrome Test is Successful");
}

@Test
public void testMozilla(){
System.out.println("Test 2 :Firefox Test is Successful");
}

public void noAnno(){
System.out.println(" Method without @test :No Annotation method**************");
}

@Test
public void testIE(){
System.out.println("Test 3:IE Test is Successful");
}
@AfterClass
public void closeDb(){
System.out.println("After class:Db Connection is closed");
}

@AfterTest
public void aft(){
System.out.println("After Test is executed");
}
@BeforeTest
public void bft(){
System.out.println("Before Test is executed");
}

}

/*
@BeforeSuite will run only once before TestAccess. We are clear on this.

@BeforeTest will run twice, once before each set of test.

@BeforeMethod will run before each @Test method in test classes.

@BeforeClass will run before "each" test class mentioned in the testng.xml.

*/