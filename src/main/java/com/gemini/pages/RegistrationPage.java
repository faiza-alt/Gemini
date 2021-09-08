package com.gemini.pages;
import com.gemini.base.TestBase;
import org.openqa.selenium.*;

public class RegistrationPage extends TestBase {

    //  Object Repository

    By GeminiLogo_Locator = By.xpath("//a[@href='https://gemini.com/']/img");
    By existingAccount_Locator = By.xpath("//p/a[text()='Join an existing institutional account?']");
    By companyName = By.name("company.legalName");
    By companyTypeBox = By.xpath("//div[@class='css-9a2vyg e5i1odf0']/label/div[2]/div/div/div[2]/div/input[contains(@id,'companyType')]");
    By otherDescription = By.name("company.companyTypeDetail");
    By state = By.xpath("//div[@class='css-13wozid e5i1odf0']/label/div[2]/div/div/div[2]/div/input");
    By FName = By.name("personal.legalName.firstName");
    By LName = By.name("personal.legalName.lastName");
    By email = By.name("personal.email");
    By submitBtn = By.xpath("//button[@data-testid='InstitutionSubmit']");
    By successMsg = By.xpath("//div/h3[text()='Thanks for Registering!']");
    By BusinessCountry = By.xpath("(//div[@class='css-9a2vyg e5i1odf0']/label/div)[6]/div/div/div[2]/div/input");
    By midName = By.name("personal.legalName.middleName");
    By personalInfoLink = By.linkText("Why am I providing personal information?");
    By infoTextBox = By.xpath("//div[@class='Content FreeWidth']");


    //Constructor to initialize the WebDriver
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    //Registration page methods\\
    public boolean isPageLogoDisplayed() {
        WebElement logo = driver.findElement(GeminiLogo_Locator);
        return logo.isDisplayed();
    }

    public boolean isExistingAccountLinkDisplayed() {
        WebElement existingAccountLink = driver.findElement(existingAccount_Locator);
        return existingAccountLink.isDisplayed();
    }

    //Company Name
    public void enterCompanyName(String companyLegalName) {
        WebElement companyNameBox = driver.findElement(companyName);
        companyNameBox.sendKeys(companyLegalName);
    }

    // Company Type
    public void selectCompanyType(String companyType) {
        WebElement selectCompanyType = driver.findElement(companyTypeBox);
        selectCompanyType.sendKeys(companyType);
        selectCompanyType.sendKeys(Keys.ENTER);

    }

    //Add other description for company type
    public void setOtherDescription(String addOtherDescription) {
        WebElement companyTypeDescription = driver.findElement(otherDescription);
        companyTypeDescription.sendKeys(addOtherDescription);
    }

    //Select state
    public void selectState(String State) {
        WebElement StateEle = driver.findElement(state);
        StateEle.sendKeys(State);
        StateEle.sendKeys(Keys.ENTER);
    }

    //Enter credentials
    public void enterCredentials(String firstName, String lastName, String Email) {
        driver.findElement(FName).sendKeys(firstName);
        driver.findElement(LName).sendKeys(lastName);
        driver.findElement(email).sendKeys(Email);

    }

    //click on continue Btn
    public void clickOnContinue() {
        WebElement continueBtn = driver.findElement(submitBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", continueBtn);
    }

    //Success Message Verification
    public String getActualSuccessMessage() {
        WebElement Msg = driver.findElement(successMsg);
        return Msg.getText();
    }

    //Select Business Country
    public void selectBusinessCountry(String country) {
        WebElement businessCountryBox = driver.findElement(BusinessCountry);
        businessCountryBox.sendKeys(country);
        businessCountryBox.sendKeys(Keys.ENTER);

    }

    public void middleName(String middleName) {
        driver.findElement(midName).sendKeys(middleName);
    }

    public boolean isPersonalInfoLinkDisplayed() {
        return driver.findElement(personalInfoLink).isDisplayed();
    }

}
