package hepsiPAY;

import base.BaseTestFunctions;
import base.Driver;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class AnindaHavale extends BaseTestFunctions {
    WebDriver driver;
    private String kitapAdi;
    String []kitaplar={"Nutuk","Otostopcunun Galaksi Rehberi","Tek Adam","Cin Ali","Taht Oyunları Game of Thrones","The Hobbit and The Lord of the Rings","lalalalalalalala"};
    Random random=new Random();
    int indis=random.nextInt(kitaplar.length);
    public AnindaHavale(){
        driver= Driver.getDriver("chromeDriver");
        PageFactory.initElements(driver,this);
        kitapAdi=kitaplar[indis];
    }

    @FindBy(xpath = "//div[@id='myAccount']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[@id='login']")
    private WebElement loginLink;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(className = "desktopOldAutosuggestTheme-input")
    private WebElement searchBox;

    @FindBy(xpath = "//span[text()=' ile ilgili sonuç bulunamamıştır']")
    private WebElement urunYoksa;

    @FindBy(xpath = "//div/div/div/div/div/ul/li[1]/div/a/div[2]/div[1]")
    private WebElement firstItem;

    @FindBy(xpath = "//button[@id='addToCart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'Ürün sepetinizde')]")
    private WebElement urunSepetinizde;

    @FindBy(xpath = "//button[text()='Sepete git']")
    private WebElement popUpSepeteGitButton;

    @FindBy(xpath = "//*[@id='shoppingCart']")
    private WebElement bannerSepeteGitButton;

    @FindBy(id="continue_step_btn")
    private WebElement alisverisiTamamlaButton;

    @FindBy(xpath = "//div/header/div/div/div[1]/div/a")
    private WebElement sepeteDonButton;

    @FindBy(xpath = "//a[@class='product_delete_1zR-0']")
    private WebElement sepettenKaldirButton;

    @FindBy(xpath = "//div[2]/div[4]/div[2]/div[2]/div/div/div/button[2]")
    private WebElement silButton;

    private WebElement yontemAdiTextElement;
    private WebElement bankaAdiTextElement;

    public void girisYap(){
        elementToBeClickable(myAccount);
        waitFor(2);
        elementToBeClickable(loginLink);
        waitFor(2);
        sendKeysFunction(username,"zeynepdinc.23@gmail.com");
        actionSendKeys(Keys.ENTER);
        waitFor(2);
        sendKeysFunction(password,"1r1B8kar");
        actionSendKeys(Keys.ENTER);
        waitFor(2);
    }

    public void urunKontrol(){
        try {
            if (urunYoksa.isDisplayed()) {
                //Burada neden bilmiyorum ama sendKeysFunction'daki clean çalışmadı bende kitap adı kadar backspace'e bastırdım.
                elementToBeClickable(searchBox);
                for(int i=0;i<kitapAdi.length();i++){
                    actionSendKeys(Keys.BACK_SPACE);
                }
                kitapAdi="Cin Ali";
                sendKeysFunction(searchBox, kitapAdi);
                actionSendKeys(Keys.ENTER);
                waitFor(2);
            }
            else{
                System.out.println("ürün var.");
            }
        }
        catch (Exception ex){
            System.out.println("Ürün var sorun yok.");
        }
    }
    public void kitapAdiylaAra(){
        sendKeysFunction(searchBox, kitapAdi);
        actionSendKeys(Keys.ENTER);
        waitFor(2);
        urunKontrol();
        elementToBeClickable(firstItem);
        try {
            tabiDegistir();
            assertWebTitle(kitapAdi);
        } catch (InterruptedException e) {
            e.printStackTrace();
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            screenshot.mkdir();//Dosya konumu: C:\Users\zeyne\AppData\Local\Temp\
        }
    }

    public void sepeteEkle(){
        elementToBeClickable(addToCartButton);
        waitFor(5);
       // isDisplay(urunSepetinizde);
    }

    public void sepeteEklendiPopupMi(){
        try {
            if (popUpSepeteGitButton.isDisplayed()) {
                elementToBeClickable(popUpSepeteGitButton);
            } else {
                actionSendKeys(Keys.ESCAPE);
                elementToBeClickable(bannerSepeteGitButton);
            }
        }
        catch (Exception exception){
            exception.getMessage();
        }
    }
    public void sepeteGit(){
        waitFor(2);
        sepeteEklendiPopupMi();
      //  elementToBeClickable(bannerSepeteGitButton);
    }
    public void asamaGec(){
        waitFor(2);
        elementToBeClickable(alisverisiTamamlaButton);
        waitFor(3);
    }


    public void yontemSec(String yontemAdi){
        waitFor(5);
        yontemAdiTextElement=driver.findElement(By.xpath("//h3[text()='"+yontemAdi+"']"));
        elementToBeClickable(yontemAdiTextElement);
        waitFor(2);
    }

    public void bankaSec(String bankaAdi){
        for(int i=0;i<8;i++){
            actionSendKeys(Keys.ARROW_DOWN);
        }
        bankaAdiTextElement=driver.findElement(By.xpath("(//p[@class='sardesPaymentPage-MoneyTransfer-bank_name'])[text()='"+bankaAdi+"']"));
        elementToBeClickable(bankaAdiTextElement);
        waitFor(2);
    }

    public void bankaAdiDogrula(String bankaAdi){
        actionSendKeys(Keys.PAGE_DOWN);
        bankaAdiTextElement=driver.findElement(By.xpath("//span[text()='"+bankaAdi+"']"));
        isDisplay(bankaAdiTextElement);
    }
    public void sepetiBosalt(){
        actionSendKeys(Keys.PAGE_UP);
        elementToBeClickable(sepeteDonButton);
        waitFor(2);
        actionSendKeys(Keys.F5);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        elementToBeClickable(sepettenKaldirButton);
        waitFor(5);
        if(silButton.isDisplayed()) {
            elementToBeClickable(silButton);
        }
        else waitFor(2);
    }
}
