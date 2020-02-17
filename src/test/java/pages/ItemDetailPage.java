package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailPage {
    private WebDriver driver;
    private By itemName = By.cssSelector(".inventory_details_name");
    private By removeButton = By.cssSelector(".btn_inventory.btn_secondary");
    private By backButton = By.cssSelector(".inventory_details_back_button");

    public ItemDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }

    public InventoryPage clickBackButton(){
        driver.findElement(backButton).click();
        return new InventoryPage(driver);
    }






}
