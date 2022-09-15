package com.sel.tests;

import com.sel.pages.Boxture_LoginPage;
import com.sel.pages.Shipment;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class Boxture_ShipmentPageVerification extends BaseTest {

    private String username;
    private String password;
    private String shipmentNum;

    @BeforeTest
    @Parameters({"username1", "password"})
    public void setupParameters(String username1, String password) {
        this.username = username1;
        this.password = password;

    }
    @Test
    public void loginPage() throws AWTException, InterruptedException {

        Boxture_LoginPage loginPage = new Boxture_LoginPage(driver);
        loginPage.loginUrl();
        Thread.sleep(3000);
        loginPage.username_enter(username);
        loginPage.password_enter(password);
        loginPage.login_buttonClick();
    }
    @Test(dependsOnMethods = {"loginPage"})
    public void shipment() {
        Shipment shipment = new Shipment(driver);
        shipment.getShipmentClick();
        shipment.getShipmentPage();
        shipment.getshipmentNum();
        shipmentNum = shipment.getshipmentNum();
        System.out.println("Shipment Num "+ shipmentNum + "verified & SHIPMENT PAGE working succeessfully");

    }

}