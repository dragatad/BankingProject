import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomer extends BankManagerLogin{

    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addBtn = By.className("btn-default");


    public AddCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getPostCode() {
        return postCode;
    }

    public By getAddBtn() {
        return addBtn;
    }

    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void enterPostCode(String postCode){
        getDriver().findElement(this.postCode).sendKeys(postCode);
    }

    public void addCustomer(String firstName, String lastName, String postCode){
        clearField(this.firstName);
        enterFirstName(firstName);
        clearField(this.lastName);
        enterLastName(lastName);
        clearField(this.postCode);
        enterPostCode(postCode);
    }

    public boolean isAddBtnEnabled(){
        return getDriver().findElement(addBtn).isEnabled();
    }

    public void addCustomerClick(){
        getDriver().findElement(addBtn).click();
    }

    public String alertMessage(){
        return getDriver().switchTo().alert().getText();
    }

    public void alertMessageAccept(){
        getDriver().switchTo().alert().accept();
    }







}
