import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Deposit extends CustomerLogin {

    //private By depositOption = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By amount = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By depositBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");


    public Deposit(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public By getAmount() {
        return amount;
    }

    public By getDepositBtn() {
        return depositBtn;
    }

    public void enterAmount(String amount){
        getDriver().findElement(this.amount).sendKeys(amount);
    }

    boolean isDepositButtonEnabled(){
        return getDriver().findElement(depositBtn).isEnabled();
    }

    public void depositClick(){
        getDriver().findElement(depositBtn).click();
    }


}
