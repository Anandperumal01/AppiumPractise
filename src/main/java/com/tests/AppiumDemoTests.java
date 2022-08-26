package com.tests;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDemoTests {
    AndroidDriver driver;

    @Test
    public void apidemos() throws MalformedURLException, InterruptedException {
        System.out.println(" i am inside api demos");

        System.out.println(" second Time");

        DesiredCapabilities capabilites =new DesiredCapabilities();
        System.out.println(" second Time");

        capabilites.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
      //  capabilites.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilites.setCapability(MobileCapabilityType.DEVICE_NAME,"RZ8M740EBJT");


        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);

        System.out.println(" end of  api demos");

        WebElement views=driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));



      //  WebElement expandablelists=driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));

        // normal click

       // driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        //Tab on views
        AppiumDemoTests.tap(driver,views);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
        WebElement three=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='3']"));
        three.click();
        Thread.sleep(5000);
        WebElement source=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='15']"));
        WebElement target=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='45']"));
      //  TouchAction swipe=new AndroidTouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(source))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(ElementOption.element(target)).release().perform();
        TouchAction swipe1=new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(ElementOption.element(target)).release().perform();
        Thread.sleep(5000);
        //Tab on views
        //tap on expandable  list based on coordinates
     //   AppiumDemoTests.tapUsingCoordinates(driver,264,1344);

    //    WebElement customadapter=driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
    //    customadapter.click();

      //  WebElement peoplenames=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));


        // long press on peoplenames
      //  TouchAction pe=new AndroidTouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(peoplenames))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).perform();


        // TouchAction pe=new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peoplenames))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(7))).perform();

        Thread.sleep(5000);

        driver.quit();







    }

    public static void tap(AndroidDriver driver,WebElement views){

        TouchAction ta=new AndroidTouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

    }


    public static void tapUsingCoordinates(AndroidDriver driver,int x, int y){

        TouchAction ta=new AndroidTouchAction(driver).tap(PointOption.point(x,y)).perform();

    }



}
