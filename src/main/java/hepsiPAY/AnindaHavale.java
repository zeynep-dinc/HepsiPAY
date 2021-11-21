package hepsiPAY;

import base.BaseTestFunctions;
import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Random;

public class AnindaHavale extends BaseTestFunctions {
    WebDriver driver;
    private String kitapAdi;
    String []kitaplar={"Nutuk","Otostopçunun Galaksi Rehberi (Ciltli) - Douglas Adams Kitabı","Tek Adam","Cin Ali","Taht Oyunları Game of Thrones","The Hobbit and The Lord of the Rings","lalalalalalalala"};
    Random random=new Random();
    int indis=random.nextInt(kitaplar.length);
    public AnindaHavale(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
        kitapAdi=kitaplar[indis];
    }

    @FindBy(xpath = "//div[@id='myAccount']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@id='login']")
    private WebElement loginButton;

    @FindBy(name = "username")
    private WebElement usernameTextBox;

    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(className = "desktopOldAutosuggestTheme-input")
    private WebElement searchTextBox;

    @FindBy(xpath = "//span[text()=' ile ilgili sonuç bulunamamıştır']")
    private WebElement urunYoksaTextElement;

    @FindBy(xpath = "//div/div/div/div/div/ul/li[1]/div/a/div[2]/div[1]")
    private WebElement firstItemIcon;

    @FindBy(xpath = "//button[@id='addToCart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'Ürün sepetinizde')]")
    private WebElement urunSepetinizdeTextElement;

    @FindBy(xpath = "//li[text()='Ürün sepete eklenemedi']")
    private WebElement urunEklenemediTextElement;

    @FindBy(className = "checkoutui-Modal-2iZXl")
    private WebElement yuklenemediPopupKapatIcon;

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
        elementToBeClickable(myAccountButton);
        waitFor(2);
        elementToBeClickable(loginButton);
        waitFor(2);
        sendKeysFunction(usernameTextBox,getUserName);
        actionSendKeys(Keys.ENTER);
        waitFor(2);
        sendKeysFunction(passwordTextBox,getPassword);
        actionSendKeys(Keys.ENTER);
        waitFor(2);
    }

    public void urunKontrol(){
        try {
            if (urunYoksaTextElement.isDisplayed()) {
                //Burada neden bilmiyorum ama sendKeysFunction'daki clean çalışmadı bende kitap adı kadar backspace'e bastırdım.
                elementToBeClickable(searchTextBox);
                for(int i=0;i<kitapAdi.length();i++){
                    actionSendKeys(Keys.BACK_SPACE);
                }
                kitapAdi="Cin Ali";
                sendKeysFunction(searchTextBox, kitapAdi);
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
        sendKeysFunction(searchTextBox, kitapAdi);
        actionSendKeys(Keys.ENTER);
        waitFor(2);
        urunKontrol();
        elementToBeClickable(firstItemIcon);
        try {
            tabiDegistir();
            assertWebTitle(kitapAdi);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sepeteEkle(){
        elementToBeClickable(addToCartButton);
        waitFor(5);
    }


    public void sepeteEklendiPopupMi(){
        try {
            if(popUpSepeteGitButton.isDisplayed()) {
                System.out.println("PopUp açıldı. Sepete git butonuna tıklandı.");
                elementToBeClickable(popUpSepeteGitButton);
                actionSendKeys(Keys.F5);
            } else if(urunEklenemediTextElement.isDisplayed()){
                System.out.println("Sepete ekleme yapılamadı.");
                elementToBeClickable(yuklenemediPopupKapatIcon);
                actionSendKeys(Keys.F5);
            }
        }
        catch (Exception exception){
            exception.getMessage();
        }
    }
    public void sepeteGit(){
        waitFor(2);
        sepeteEklendiPopupMi();
        actionSendKeys(Keys.ESCAPE);
        elementToBeClickable(bannerSepeteGitButton);
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
        waitFor(3);
    }

    public void bankaSec(String bankaAdi){
        //Bu for döngüsü 14 inç gibi küçük ekranlarda sığmama probleminin önüne geçilmek için yazılmıştır.
        for(int i=0;i<7;i++){
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
