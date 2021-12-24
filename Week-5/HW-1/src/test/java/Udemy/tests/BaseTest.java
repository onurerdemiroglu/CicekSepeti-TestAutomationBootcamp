package Udemy.tests;

import Udemy.utilities.Driver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Driver {


    @BeforeClass
    public void setUp() throws MalformedURLException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
