package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage {

    @FindBy(linkText = "Contact us")
    private WebElement contactLink;
    @FindBy(linkText = "Sign in")
    private WebElement signLink;
    @FindBy(xpath = "//a[@class='sf-with-ul']")
    public WebElement women;
    @FindBy(xpath = "//a[@title='T-shirts']")
    public WebElement subLinkTshirts;
    @FindBy(id = "id_contact")
    private WebElement dropDownListSubjectHeading;
    @FindBy(id = "email")
    private WebElement fieldMail;
    @FindBy(id = "email_create")
    private WebElement emailCreate;
    @FindBy(xpath = "//*[@id='SubmitCreate']")
    private WebElement crateAccountButton;
    @FindBy(id = "id_order")
    private WebElement fieldOrder;
    @FindBy(xpath = "//*[@id='fileUpload']")
    private WebElement attachFile;
    @FindBy(id = "message")
    private WebElement inputMessage;
    @FindBy(id = "submitMessage")
    private WebElement sendButton;
    @FindBy(xpath = "//p[@class='alert alert-success']  ")
    private WebElement successfulSubmission;
    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement errorMessage;
//Sign in/////////////////////////////////////////////////////////////////////
    @FindBy(id = "email")
    private WebElement signInEmail;
    @FindBy(id = "passwd")
    private WebElement signInPassword;
    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;
//Create account/////////////////////////////////////////////////////////////
    @FindBy(id = "id_gender1")
    private WebElement accountGender;
    @FindBy(id = "customer_firstname")
    private WebElement accountFirstName;
    @FindBy(id = "customer_lastname")
    private WebElement accountLastName;
    @FindBy(id = "passwd")
    private WebElement accountPassword;
    @FindBy(id = "address1")
    private WebElement accountAddress;
    @FindBy(id = "city")
    private WebElement accountCity;
    @FindBy(id = "id_state")
    private WebElement accountState;
    @FindBy(id = "postcode")
    private WebElement accountZip;
    @FindBy(id = "id_country")
    private WebElement accountCountry;
    @FindBy(id = "phone_mobile")
    private WebElement accountMobile;
    @FindBy(id = "alias")
    private WebElement accountAlias;
    @FindBy(xpath = "//*[@id='submitAccount']")
    private WebElement accountButton;
//Create account end/////////////////////////////////////////////////////
    @FindBy(xpath = "//*[@id='search_query_top']")
    private WebElement fieldSearch;
    @FindBy(xpath = "//*[@id='searchbox']/button")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@title='Blouse']")
    public WebElement searchText;
    @FindBy(xpath = "//h5[@itemprop='name']/a[@title='Faded Short Sleeve T-shirts']")
    public WebElement itemDisplayed;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']/i")
    private WebElement trashCarButton;
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    private WebElement myCardLink;
    @FindBy(xpath = "//*[@id='center_column']/p/a")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement processAddress;
    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement processCarrier;
    @FindBy(xpath = "//*[@id='cgv']")
    private WebElement checker;
    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement bankWire;
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private WebElement iConfirmMyOrder;
    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    private WebElement orderHistory;
    @FindBy(xpath = "//td[@class='cart_description']/p/a")
    public WebElement isMyCardOrderDisplayed;
    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private WebElement isMyCardOrderEmpty;
    @FindBy(xpath = "//td[@class='history_link bold footable-first-column']/a")
    private WebElement backToOrdersLink;
    @FindBy(xpath = "//tr[@class='item']/td[@class='bold']/label")
    private WebElement orderReference;
    @FindBy(xpath = "//td[@class='bold']/label")
    private WebElement isOrderHistoryDisplayed;
    @FindBy(xpath = "//a[@data-id-product='2']")
    public WebElement productSearch;
    @FindBy(xpath = "//span[@class='cross']")
    public WebElement crossButton;
    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']/span")
    public WebElement proceedToCheckout;
    @FindBy(xpath = "//a[@class='product-name'][@title='Blouse']")
    public WebElement productNameLink;
    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    public WebElement addToCardButton;


    private WebDriver driver;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLinkContact(){ contactLink.click(); }

    public void clickLinkSign() {
        signLink.click();
    }
    //Create email account
    public void createMail() { emailCreate.sendKeys("start7@mail.ru");} // change mail for enter account
    //Input email account
    public void inputMail() { fieldMail.sendKeys("start7@mail.ru"); } // change mail for enter account
    //Enter email
    public void inputMailSignIn() { signInEmail.sendKeys("start7@mail.ru");} // change mail for enter account
    //Enter password
    public void inputPasswordSignIn() {
        signInPassword.sendKeys("12345678");
    }
    //Create password
    public void inputPasswordAccount() {
        accountPassword.sendKeys("12345678");
    }

    public void inputOrderReference() {
               fieldOrder.sendKeys("Model  demo_7");
        }

    public void selectDropDown() {
            Select dropdown = new Select(dropDownListSubjectHeading);
            dropdown.selectByIndex(2);
    }
    public void attachFiles() {
            attachFile.sendKeys("C:\\file.txt");
    }
    public void inputMessage() {
                inputMessage.sendKeys("New message");
        }

    public boolean isSuccessfulMessageDisplayed() {
        sendButton.click();
        return successfulSubmission.isDisplayed();
    }
    public String isErrorMessageDisplayed() {
        sendButton.click();
        return errorMessage.getText();
    }


    public void createAccount() {
        crateAccountButton.click();
    }

    public void inputFieldSearch() {
        fieldSearch.sendKeys("Blouse");
    }
    public void searchButtonClick() {
        searchButton.click();
    }


    public void  processAddressClick() {
        processAddress.click();
    }

    public void  checkerClick() {
        checker.click();
    }
    public void  productNameClick() {
        productNameLink.click();
    }
    public void  addToCardButtonClick() {
        addToCardButton.click();
    }
    public void  processCarrierClick() {
        processCarrier.click();
    }

    public void  bankWireClick() {
        bankWire.click();
    }
    public void  iConfirmMyOrderClick() {
        iConfirmMyOrder.click();
    }

    public void  orderHistoryClick() {
        orderHistory.click();
    }

    //method Create Account
    public void radioButtonClick() {
        accountGender.click();
    }
    public void inputFirstName() {
        accountFirstName.sendKeys("Ivan");
    }
    public void inputLastName() {
        accountLastName.sendKeys("Ivanov");
    }


    public void inputAddress() {
        accountAddress.sendKeys("Street");
    }
    public void inputCity() {
        accountCity.sendKeys("City,23");
    }
    public void inputState() {

        Select dropdown = new Select(accountState);
        dropdown.selectByIndex(1);
           }
    public void inputPostalCode() {
        accountZip.sendKeys("36101");
    }
    public void inputCountry() {
        accountCountry.sendKeys("U.S.A.");
    }
    public void inputMobile() {
        accountMobile.sendKeys("+1(000)0000000");
    }
    public void inputAlias() {
        accountAlias.sendKeys("Alias@mail.ru");
    }
    public void accountButtonClick() {
        accountButton.click();

    }
    public void signInButtonClick() {
        signInButton.click();

    }
   public void proceedToCheckoutClick() {
        proceedToCheckoutButton.click();
    }


    public String isMyCardOrderEmpty() {
        trashCarButton.click();
        return isMyCardOrderEmpty.getText();
    }

    public String isBackToOrdersDisplayed() {
        backToOrdersLink.click();
        orderReference.click();
        return isOrderHistoryDisplayed.getText();
    }

}