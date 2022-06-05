import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BankManagerLogin extends HomePage {

    private By addCustomerBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccountBtn = By.className("btn-primary");
    private By customersBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    private By homeBtn = By.xpath("/html/body/div/div/div[1]/button[1]");


    public BankManagerLogin(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getAddCustomerBtn() {
        return addCustomerBtn;
    }

    public By getOpenAccountBtn() {
        return openAccountBtn;
    }

    public By getHomeBtn() {
        return homeBtn;
    }

    boolean isManagerLoggedIn(){
        List<WebElement> elementList = getDriver().findElements(By.className("btn-lg"));
        if(elementList.size() == 0){
            return false;
        }
        return true;
    }

    public void addCustomer(){
        getDriver().findElement(addCustomerBtn).click();
    }

    boolean isOpenAccountBtnDisplayed(){
        return getDriver().findElement(openAccountBtn).isDisplayed();
    }

    public void openAccount(){
        getDriver().findElement(openAccountBtn).click();
    }

    public void logout(){
        getDriver().findElement(homeBtn).click();
    }


}
