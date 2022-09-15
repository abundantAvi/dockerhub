package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shipment {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(css = ".flex-grow > .flex-1 > .sts-sidebar-menu-item:nth-child(4) > .sts-sidebar-menu-item__link > .sts-sidebar-menu-item__label")
    private WebElement shipmentClick;
    @FindBy(css = ".cursor-pointer:nth-child(2) > .px-6:nth-child(3)")
    private WebElement shipmentPage;
    @FindBy(css = "satis-copyable")
    private WebElement shipmentNum;


    public Shipment(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void getShipmentClick() {
        this.wait.until(ExpectedConditions.visibilityOf(this.shipmentClick));
        Actions act = new Actions(driver);
        act.doubleClick(shipmentClick).perform();
    }
    public void getShipmentPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.shipmentPage));
        this.shipmentPage.click();
    }
    public String getshipmentNum() {
        this.wait.until(ExpectedConditions.visibilityOf(this.shipmentNum));
        String b = shipmentNum.getText();
        String[] k = b.split("#");
        String number = k[1].trim();
        return number;
    }
}
