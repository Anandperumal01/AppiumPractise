package com.tests;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDemoTests {
    @Test
    public void apidemos() throws MalformedURLException {
        System.out.println(" i am inside api demos");

        System.out.println(" second Time");

        DesiredCapabilities capabilites =new DesiredCapabilities();
        capabilites.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilites.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilites.setCapability(MobileCapabilityType.DEVICE_NAME,"RZ8M740EBJT");


        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);

        System.out.println(" end of  api demos");

    }



}
