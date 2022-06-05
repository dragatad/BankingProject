import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomerLogin extends HomePage {

    private By yourName = By.id("userSelect");
    private By loginBtn = By.className("btn-default");
    private By transactions = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]");
    private By deposit = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withdrawal = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By logoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");


    public CustomerLogin(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getYourName() {
        return yourName;
    }

    public void setYourName(By yourName) {
        this.yourName = yourName;
    }

    public By getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(By loginBtn) {
        this.loginBtn = loginBtn;
    }

    public By getTransactions() {
        return transactions;
    }

    public void setTransactions(By transactions) {
        this.transactions = transactions;
    }

    public By getDeposit() {
        return deposit;
    }

    public void setDeposit(By deposit) {
        this.deposit = deposit;
    }

    public By getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(By withdrawal) {
        this.withdrawal = withdrawal;
    }

    public void selectYourName(String yourName){
        getDriver().findElement(this.yourName).sendKeys(yourName);
    }

    public void clickLoginBtn(){
        getDriver().findElement(loginBtn).click();
    }

    boolean isCustomerLoggedIn(){
        return getDriver().findElement(transactions).isDisplayed();
    }

    public void logout(){
        getDriver().findElement(logoutBtn).click();
    }

    boolean isCustomerLoggedOut(){
        return getDriver().findElement(yourName).isDisplayed();
    }

    boolean isClickDepositDisplayed(){
        return getDriver().findElement(deposit).isDisplayed();
    }

    public void clickDeposit(){
        getDriver().findElement(deposit).click();
    }

    public void clickWithdraw(){
        getDriver().findElement(withdrawal).click();
    }








}
