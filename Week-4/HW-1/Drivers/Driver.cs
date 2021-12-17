using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;


public class Driver
{
    private Driver()
    {
    }

    public static IWebDriver driver;

    public static WebDriver get()
    {
        if (driver == null)
        {
            driver = new ChromeDriver();
        }
        return (WebDriver)driver;
    }

    public static void closeDriver()
    {
        if (driver != null)
        {
            driver.Quit();
            driver = null;
        }
    }
}