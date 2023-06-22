package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class NestedFrames_Texts {
    ChromeDriver driver;
    
    public NestedFrames_Texts()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        //Open URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //Locate the Frame top Using Locator "Name"   "frame-top"
        driver.switchTo().frame("frame-top");
        //Switch the Frame Left Using Locator "Name"  "frame-left"
        driver.switchTo().frame("frame-left");
        
        //Get the Left text  Using Locator "XPath"  "//body[contains(text(),'LEFT')]"
        WebElement left= driver.findElementByXPath("//body[contains(text(),'LEFT')]");
        System.out.println("The text present in the left: "+left.getText());
       //Switch to parent frame 
        driver.switchTo().parentFrame();
        //Switch the Frame Middle Using Locator "Name" "frame-middle"
        driver.switchTo().frame("frame-middle");
        //Get the Middle text  Using Locator "XPath"   //div[contains(text(),'MIDDLE')]
        WebElement middle= driver.findElementByXPath("//div[contains(text(),'MIDDLE')]");
        System.out.println("The text present in the middle: "+middle.getText());
         //Switch to parent frame 
        driver.switchTo().parentFrame();
        //Switch the Frame Right Using Locator "Name" "frame-right"
        driver.switchTo().frame("frame-right");
        //Get the Right text  Using Locator "XPath"   //body[contains(text(),'RIGHT')]
        WebElement right= driver.findElementByXPath("//body[contains(text(),'RIGHT')]");
        System.out.println("The text present in the right: "+right.getText());
        //Switch to defaultContent  using driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();
        //Switch the Frame Bottom Using Locator "Name" "frame-bottom"
        driver.switchTo().frame("frame-bottom");
        //Get the Bottom text  Using Locator "XPath" //body[contains(text(),'BOTTOM')]
        WebElement bottom= driver.findElementByXPath("//body[contains(text(),'BOTTOM')]");
        System.out.println("The text present in the bottom: "+bottom.getText());
        //Switch to defaultContent  using driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();
  
     
    }


}



