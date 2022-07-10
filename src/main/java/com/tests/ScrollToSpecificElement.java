package com.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScrollToSpecificElement {


    AndroidDriver driver;
    @Test
    public void specificElement() throws MalformedURLException, InterruptedException {
        System.out.println(" i am inside api demos");

        System.out.println(" second Time");

        DesiredCapabilities capabilites = new DesiredCapabilities();
        capabilites.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/ApiDemos-debug.apk");
        capabilites.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilites.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8M740EBJT");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilites);

        System.out.println(" end of  api demos");

        WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));

        views.click();
        scrollTospecificelement(By.xpath("//android.widget.TextView[@text='TextFields']"));
        driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Testing");

        Thread.sleep(5000);
        //driver.close();
        driver.quit();


      // Generic Xpath derivation

        // .. parent
        //   --->//android.widget.LinearLayout/android.widget.TextView[@content-desc='Task Conquer World']/../android.widget.CheckBox
        // -->//android.widget.LinearLayout/android.widget.TextView[@content-desc='Task Conquer World']/following-sibling::android.widget.CheckBox


    }

    public void scrollTospecificelement(By by){

          while(driver.findElements(by).isEmpty())  // ==0
          {
              Dimension dimensions=driver.manage().window().getSize();
              Double screenHeightStart=dimensions.getHeight()*0.5;
              int scrollStart=screenHeightStart.intValue();
              Double screenHeightEnd=dimensions.getHeight()*0.2;
              int scrollEnd=screenHeightEnd.intValue();
              int center=(int)(dimensions.width*0.5);
              new AndroidTouchAction(driver)
                      .press(PointOption.point(center,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                      .moveTo(PointOption.point(center,scrollEnd)).release().perform();

          }
          if(!driver.findElements(by).isEmpty())
          {
              driver.findElement(by).click();
          }

    }
}
