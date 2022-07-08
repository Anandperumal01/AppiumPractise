package com.tests;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDemoTests {
    AndroidDriver driver;
    @Test
    public void apidemos() throws MalformedURLException {
        System.out.println(" i am inside api demos");

        System.out.println(" second Time");

        DesiredCapabilities capabilites =new DesiredCapabilities();
        capabilites.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilites.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilites.setCapability(MobileCapabilityType.DEVICE_NAME,"RZ8M740EBJT");


        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);

        System.out.println(" end of  api demos");

        WebElement views=driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));


       // driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        //Tab
        AppiumDemoTests.tap(driver,views);




    }

    public static void tap(AndroidDriver driver,WebElement views){

        TouchAction ta=new AndroidTouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

    }



}
