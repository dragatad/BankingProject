import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homepage;
    private BankManagerLogin bankManagerLogin;
    private AddCustomer addCustomer;
    private OpenAccount openAccount;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(200));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homepage = new HomePage(driver, driverWait);
        bankManagerLogin = new BankManagerLogin(driver, driverWait);
        addCustomer = new AddCustomer(driver, driverWait);
        openAccount = new OpenAccount(driver, driverWait);

    }

    @Test (priority = 1)
    public void bankManagerLoginTest() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(bankManagerLogin.getBankManagerLoginBtn()));
        Assert.assertTrue(homepage.isBankManagerLoginButtonEnabled());
        homepage.clickBankManager();
        Assert.assertTrue(bankManagerLogin.isManagerLoggedIn());
    }

    @Test (priority = 2)
    public void addCustomerTest(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(bankManagerLogin.getAddCustomerBtn()));
        bankManagerLogin.addCustomer();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(addCustomer.getFirstName()));
        addCustomer.addCustomer("Luna","Lovegood","12345");
        Assert.assertTrue(addCustomer.isAddBtnEnabled());
        addCustomer.addCustomerClick();
        Assert.assertEquals(addCustomer.alertMessage(), "Customer added successfully with customer id :6");
        addCustomer.alertMessageAccept();
    }

    @Test
    public void openCustomerAccountTest(){
        //driverWait.until(ExpectedConditions.presenceOfElementLocated(bankManagerLogin.getOpenAccountBtn()));
        Assert.assertTrue(bankManagerLogin.isOpenAccountBtnDisplayed());
        bankManagerLogin.openAccount();
        openAccount.openCustomerAccount("Luna Lovegood", "Pound");
        Assert.assertTrue(openAccount.isProcessBtnEnabled());
        openAccount.processBtnClick();
        Assert.assertEquals(openAccount.alertMessage(),"Account created successfully with account Number :1016");
        openAccount.alertMessageAccept();
    }

    @Test
    public void bankManagerLogoutTest(){
        driverWait.until(ExpectedConditions.elementToBeClickable(bankManagerLogin.getHomeBtn()));
        bankManagerLogin.logout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }





}
