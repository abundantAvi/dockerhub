package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Boxture_Containers {
     public WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(linkText = "Containers")
    private WebElement containers;
    @FindBy(linkText = "Create")
    private WebElement create;
    @FindBy(xpath = "//input[@placeholder='Packing materialabc']")
    private WebElement packingMaterial;
    @FindBy(xpath = "//input[@placeholder='Bin location']")
    private WebElement binLoc;
    @FindBy(xpath = "//button[normalize-space()='Create Container']")
    private WebElement createContainer;


    @FindBy(xpath = "//span[normalize-space()='View notifications']")
    private WebElement notificationCntainer;
    @FindBy(css = ".py-1:nth-child(1) p")
    private WebElement a;

    @FindBy(css = ".h-8 > .w-6:nth-child(1)")
    private WebElement clickOnNotification;

    @FindBy(xpath = "//main/div/div/div/div/div/div/div[2]/h3/satis-copyable")
    private WebElement containerNum;

    public Boxture_Containers(WebDriver driver) {

        this.driver = driver;
       wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void setContainers() {
        wait.until(ExpectedConditions.visibilityOf(this.containers));
        containers.click();
    }
    public void setCreate() {
        wait.until(ExpectedConditions.visibilityOf(this.create));
        create.click();
    }
    public void setPackingMaterial(String packing_Material) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(this.packingMaterial));
        packingMaterial.click();
        packingMaterial.clear();
        packingMaterial.sendKeys(packing_Material);
        Thread.sleep(3000);
    }

    public void setBinLoc(String bin) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.binLoc));
        binLoc.click();
        binLoc.sendKeys(bin);
        Thread.sleep(3000);

    }

    public void setCreateContainer() throws InterruptedException {
        createContainer.click();
        Thread.sleep(3000);
    }
    public void setclickOnNotification() throws InterruptedException {
        clickOnNotification.click();
        Thread.sleep(3000);
    }

    public String setNotificationCntainer() throws InterruptedException {
        String b = a.getText().substring(10,18);
        return b;
    }
}
