Feature: AnindaHavaleTestStep

  Scenario Outline: AnindaHavaleTestStep
    Given "hepsiburada.com" adresine "chromedriver" ile giris yap
    And "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com" sayfasinda oldugunu dogrula
    Then "Otostopçunun Galaksi Rehberi (Ciltli) - Douglas Adams" kitabını sepete ekle
    And "Otostopçunun Galaksi Rehberi (Ciltli) - Douglas Adams - Hepsiburada" sayfasinda oldugunu dogrula
    Then sepete git
    And "Sepetim" sayfasinda oldugunu dogrula
    Then alisverisi tamamla
    And "Teslimat Bilgileri" sayfasinda oldugunu dogrula
    Then teslimat yontemi ekranini gec
    And "Ödeme Bilgileri" sayfasinda oldugunu dogrula
    Then "Anında Havale" yontemini sec
    Then "<banka>" sec
    Then devam et butonuna tikla
    Then "Sipariş Özeti" sayfasinda oldugunu dogrula
    Then odeme bilgilerinden "<banka>" adini dogrula
    Then sepeti bosalt
    Then oturumu kapat
    Examples:
      | banka         |
      | AKBANK        |
      | IS_BANKASI    |
      | VAKIFBANK     |
      | KUVEYT_TURK   |
      | ALBARAKA_TURK |



