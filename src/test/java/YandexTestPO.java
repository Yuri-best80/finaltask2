import Pages.SearchResultPage;
import base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class YandexTestPO extends TestBase {

    private SearchResultPage searchResultPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters("Browser")
    public void testInitialize(@Optional String browserName) throws IllegalAccessException {

        super.testInitialize(browserName);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    @Test
    public void e1verifyThatContactUsFormSendsSuccessFully() {

        searchResultPage.clickLinkContact();
        searchResultPage.selectDropDown();
        searchResultPage.inputMail();
        searchResultPage.inputOrderReference();
        searchResultPage.attachFiles();
        searchResultPage.inputMessage();

        Assert.assertTrue(searchResultPage.isSuccessfulMessageDisplayed(), " Successful message should be displayed");
    }

    @Test
    public void e2verifyThatErrorMessageAppearsIfMessageAreaIsEmpty() {

        searchResultPage.clickLinkContact();
        searchResultPage.selectDropDown();
        searchResultPage.inputMail();
        searchResultPage.inputOrderReference();
        searchResultPage.attachFiles();

        Assert.assertTrue(searchResultPage.isErrorMessageDisplayed().contains("The message cannot be blank."));
    }

    @Test
    public void e3verifyTheAbilityToRegister() {

        searchResultPage.clickLinkSign();
        searchResultPage.createMail();
        searchResultPage.createAccount();
        searchResultPage.radioButtonClick();
        searchResultPage.inputFirstName();
        searchResultPage.inputLastName();
        searchResultPage.inputPasswordAccount();
        searchResultPage.inputAddress();
        searchResultPage.inputCity();
        searchResultPage.inputState();
        searchResultPage.inputPostalCode();
        searchResultPage.inputCountry();
        searchResultPage.inputMobile();
        searchResultPage.inputAlias();
        searchResultPage.accountButtonClick();
        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("my-account"), "My account page should be opened");

    }

    @Test
    public void e4verifyTheAbilityToSearchItems() {

        searchResultPage.inputFieldSearch();
        searchResultPage.searchButtonClick();
        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("Blouse&submit_search"), "Search result page should be opened");

    }

    @Test
    public void e5verifyTheAbilityToAddAndDeleteItemsFromCart() {

        searchResultPage.inputFieldSearch();
        searchResultPage.searchButtonClick();
        Actions action = new Actions(driver);
        WebElement mainMenu = searchResultPage.searchText;
        action.moveToElement(mainMenu).moveToElement(searchResultPage.productSearch).click().build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.proceedToCheckout)).click();

        Assert.assertTrue(searchResultPage.isMyCardOrderDisplayed.getText().contains("Blouse"));
        Assert.assertTrue(searchResultPage.isMyCardOrderEmpty().contains("(empty)"));

    }

    @Test
    public void e6catalogTest() {

        Actions ac = new Actions(driver);
        WebElement we = searchResultPage.women;
        ac.moveToElement(we).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.subLinkTshirts)).click();

        Assert.assertTrue(searchResultPage.itemDisplayed.getText().contains("Faded Short Sleeve T-shirts"));
    }

    @Test
    public void e7proceedToCheckout() {

        searchResultPage.productNameClick();
        searchResultPage.addToCardButtonClick();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.proceedToCheckout)).click();
        searchResultPage.proceedToCheckoutClick();
        searchResultPage.inputMailSignIn();
        searchResultPage.inputPasswordSignIn();
        searchResultPage.signInButtonClick();
        searchResultPage.processAddressClick();
        searchResultPage.checkerClick();
        searchResultPage.processCarrierClick();
        searchResultPage.bankWireClick();
        searchResultPage.iConfirmMyOrderClick();
        searchResultPage.orderHistoryClick();

        Assert.assertTrue(searchResultPage.isBackToOrdersDisplayed().contains("Blouse - Color : Black, Size : S"));
    }
}
