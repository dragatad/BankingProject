import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Withdrawal extends CustomerLogin {
    private By amountWithdrawn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");


    public Withdrawal(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getAmountWithdrawn() {
        return amountWithdrawn;
    }

    public By getWithdrawBtn() {
        return withdrawBtn;
    }

    public void enterAmount(String amount){
        getDriver().findElement(this.amountWithdrawn).sendKeys(amount);
    }

    boolean isWithdrawButtonEnabled(){
        return getDriver().findElement(withdrawBtn).isEnabled();
    }

    public void depositClick(){
        getDriver().findElement(withdrawBtn).click();
    }
}
