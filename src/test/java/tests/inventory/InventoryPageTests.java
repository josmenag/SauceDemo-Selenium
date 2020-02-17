package tests.inventory;

import tests.base.BaseTests;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.ItemDetailPage;

import static org.testng.Assert.*;

public class InventoryPageTests extends BaseTests {
    private String standartUsername = "standard_user";
    private String lockedOutUsername = "locked_out_user";
    private String problemUsername = "problem_user";
    private String performanceGLitchUsername = "performance_glitch_user";
    private String password = "secret_sauce";

    @Test
    public void testClickOnItemTitle(){
        InventoryPage inventoryPage = this.loginPage.login(standartUsername,password);
        ItemDetailPage itemDetailPage = inventoryPage.clickFirstElementTitle();
        assertEquals(itemDetailPage.getItemName(),"Sauce Labs Backpack","Incorrect product");
    }

    @Test
    public void testSelectOption(){
        InventoryPage inventoryPage = this.loginPage.login(standartUsername,password);
        inventoryPage.clickSortingDropdown();
        String option = "Name (A to Z)";

        inventoryPage.selectFromDropdown(option);
        var selectedOptions = inventoryPage.getSelectedOption();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

    @Test
    public void testBurgerMenuAppears(){
        InventoryPage inventoryPage = this.loginPage.login(standartUsername,password);
        inventoryPage.clickBurger();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inventoryPage.clickOnAllItemsLinkInBurger();
        assertEquals(inventoryPage.getURL(), "https://saucelabs.com/");
    }
}
