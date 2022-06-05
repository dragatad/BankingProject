import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccount extends BankManagerLogin {

    private By customer = By.xpath("//*[@id=\"userSelect\"]");
    private By currency = By.xpath("//*[@id=\"currency\"]");
    private By processBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public OpenAccount(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getCustomer() {
        return customer;
    }

    public By getCurrency() {
        return currency;
    }

    public By getProcessBtn() {
        return processBtn;
    }

    public void selectCustomer(String customer){
        getDriver().findElement(this.customer).sendKeys(customer);
    }

    public void selectCurrency(String currency){
        getDriver().findElement(this.currency).sendKeys(currency);
    }

    public void openCustomerAccount(String customer, String currency){
        selectCustomer(customer);
        selectCurrency(currency);
    }

    public boolean isProcessBtnEnabled(){
        return getDriver().findElement(processBtn).isEnabled();
    }

    public void processBtnClick(){
        getDriver().findElement(processBtn).click();
    }

    public String alertMessage(){
        return getDriver().switchTo().alert().getText();
    }

    public void alertMessageAccept(){
        getDriver().switchTo().alert().accept();
    }


}
