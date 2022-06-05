import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By customerLoginBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By bankManagerLoginBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getCustomerLoginBtn() {
        return customerLoginBtn;
    }

    public void setCustomerLoginBtn(By customerLoginBtn) {
        this.customerLoginBtn = customerLoginBtn;
    }

    public By getBankManagerLoginBtn() {
        return bankManagerLoginBtn;
    }

    public void setBankManagerLoginBtn(By bankManagerLoginBtn) {
        this.bankManagerLoginBtn = bankManagerLoginBtn;
    }

    public boolean isCustomerLoginButtonEnabled(){
        return getDriver().findElement(customerLoginBtn).isEnabled();
    }

    public void customerLogin(){
        getDriver().findElement(customerLoginBtn).click();
    }

    public boolean isBankManagerLoginButtonEnabled(){
        return getDriver().findElement(bankManagerLoginBtn).isEnabled();
    }

    public void clickBankManager(){
        getDriver().findElement(bankManagerLoginBtn).click();
    }






    }
