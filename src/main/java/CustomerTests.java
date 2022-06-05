import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homepage;
    private CustomerLogin customerLogin;
    private Deposit deposit;
    private Withdrawal withdrawal;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(180));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homepage = new HomePage(driver, driverWait);
        customerLogin = new CustomerLogin(driver, driverWait);
        deposit = new Deposit(driver,driverWait);
        withdrawal = new Withdrawal(driver, driverWait);
    }

    @Test
    public void customerLoginTest(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(customerLogin.getCustomerLoginBtn()));
        Assert.assertTrue(homepage.isCustomerLoginButtonEnabled());
        homepage.customerLogin();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(customerLogin.getYourName()));
        customerLogin.selectYourName("Neville Longbottom");
        customerLogin.clickLoginBtn();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(customerLogin.getTransactions()));
        Assert.assertTrue(customerLogin.isCustomerLoggedIn());
    }

    @Test
    public void customerDepositTest(){
        Assert.assertTrue(customerLogin.isClickDepositDisplayed());
        customerLogin.clickDeposit();
        deposit.enterAmount("100");
        Assert.assertTrue(deposit.isDepositButtonEnabled());
        deposit.depositClick();

    }

    @Test
    public void customerLogoutTest(){
        customerLogin.logout();
        Assert.assertTrue(customerLogin.isCustomerLoggedOut());
    }

    @Test
    public void customerWithdrawalTest(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(customerLogin.getWithdrawal()));
        customerLogin.clickWithdraw();
        withdrawal.enterAmount("100");
        Assert.assertTrue(withdrawal.isWithdrawButtonEnabled());
        deposit.depositClick();

    }


    }
