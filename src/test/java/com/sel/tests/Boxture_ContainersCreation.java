package com.sel.tests;

import com.sel.pages.Boxture_Containers;
import com.sel.pages.Boxture_LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class Boxture_ContainersCreation extends BaseTest {

    private String username;
    private String password;
    private String containerNumber;

    Boxture_Containers containers;

    @BeforeTest
    @Parameters({"username1", "password"})
    public void setupParameters(String username1, String password) {
        this.username = username1;
        this.password = password;

    }
    @Test
    public void containerCreate() throws AWTException, InterruptedException {

        Boxture_LoginPage loginPage = new Boxture_LoginPage(driver);
        loginPage.loginUrl();
        Thread.sleep(3000);
        loginPage.username_enter(username);
        loginPage.password_enter(password);
        loginPage.login_buttonClick();
    }
    @Test(dependsOnMethods = {"containerCreate"})
    public void container() throws InterruptedException {
        containers = new Boxture_Containers(driver);
        containers.setContainers();
        containers.setCreate();
        containers.setPackingMaterial("box 1");
        containers.setBinLoc("AVITESTBIN123");
        containers.setCreateContainer();
        containers.setclickOnNotification();
        containers.setNotificationCntainer();
        containerNumber = containers.setNotificationCntainer();
        System.out.println(containerNumber);

    }

}