package steps;

import base.BaseTestMethod;
import hepsiPAY.AnindaHavale;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AnindaHavaleTest_Step extends BaseTestMethod {

    AnindaHavale anindaHavale = new AnindaHavale();
    private Scenario scenario;
    private String bankaAdi;

    @Before
    public void beforeStep(Scenario scenario) {
        super.beforeTest();
        this.scenario = scenario;
    }

    @Given("{string} adresine giris yap")
    public void adresine_ile_giris_yap(String string) {
        anindaHavale.assertWebTitle("Hepsiburada.com");
        anindaHavale.girisYap();
    }

    @Given("{string} sayfasinda oldugunu dogrula")
    public void sayfasinda_oldugunu_dogrula(String baslik) {
        anindaHavale.waitForPageLoad(10L);
        anindaHavale.assertWebTitle(baslik);
    }

    @Then("kitabi sepete ekle")
    public void kitabi_sepete_ekle() {
        anindaHavale.kitapAdiylaAra();
        anindaHavale.sepeteEkle();
    }

    @Then("sepete git")
    public void sepete_git() {
        anindaHavale.sepeteGit();
    }

    @Then("asamayi gec")
    public void asamayi_gec() {
        anindaHavale.asamaGec();
    }

    @Then("{string} yontemini sec")
    public void yontemini_sec(String string) {
        anindaHavale.yontemSec(string);
    }

    @Then("{string} sec")
    public void sec(String banka) {
        bankaAdi = banka;
        anindaHavale.bankaSec(banka);
    }

    @Then("devam et butonuna tikla")
    public void devam_et_butonuna_tikla() {
        anindaHavale.asamaGec();
    }

    @Then("odeme bilgilerinden {string} adini dogrula")
    public void odeme_bilgilerinden_adini_dogrula(String bankaAdi) {
        anindaHavale.bankaAdiDogrula(bankaAdi);
    }

    @Then("sepeti bosalt")
    public void sepeti_bosalt() {
        anindaHavale.sepetiBosalt();
    }

    @After
    public void oturumu_kapat() {
        super.afterTest(scenario, bankaAdi);
    }
}
