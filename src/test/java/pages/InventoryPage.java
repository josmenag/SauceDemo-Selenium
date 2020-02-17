package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {
    private WebDriver driver;
    private By firstElementAddToCartButton = By.cssSelector("div:nth-of-type(1) > .pricebar > .btn_inventory.btn_primary");
    private By firstElementRemoveFromCartButton = By.cssSelector(".btn_inventory.btn_secondary");
    private By burger = By.cssSelector(".bm-burger-button > button");
    private By sortingDropdown = By.cssSelector("div#inventory_filter_container > .product_sort_container");
    private By firstElementTitle = By.cssSelector(".inventory_list .inventory_item:nth-of-type(1) .inventory_item_name");
    private By firstElementImage = By.cssSelector(".inventory_list .inventory_item:nth-of-type(1) .inventory_item_img:nth-of-type(1) .inventory_item_img");
    private By dropdown = By.cssSelector("div#inventory_filter_container > .product_sort_container");
    private By aboutLinkInBurgerMenu = By.cssSelector("a#about_sidebar_link");


    public InventoryPage(WebDriver driver){this.driver = driver;}

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void addFirstElementToCart(){
        driver.findElement(firstElementAddToCartButton).click();
    }


    public void removeFirstElementFromCart(){
        driver.findElement(firstElementRemoveFromCartButton).click();
    }

    public void clickBurger(){
        driver.findElement(burger).click();
    }

    public void clickSortingDropdown(){
        driver.findElement(sortingDropdown).click();
    }

    public void clickFirstElementImage(){
        driver.findElement(firstElementImage).click();
    }

    public ItemDetailPage clickFirstElementTitle(){
        driver.findElement(firstElementTitle).click();
        return new ItemDetailPage(driver);
    }

    public void selectFromDropdown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOption(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

    public InventoryPage clickOnAllItemsLinkInBurger(){
        driver.findElement(aboutLinkInBurgerMenu).click();
        return new InventoryPage(driver);
    }

}
