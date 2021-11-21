Feature: AnindaHavaleTestStep

  Scenario Outline: AnindaHavaleTestStep
    Given "hepsiburada.com" adresine giris yap
    And "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com" sayfasinda oldugunu dogrula
    Then kitabi sepete ekle
    Then sepete git
    And "Sepetim" sayfasinda oldugunu dogrula
    Then asamayi gec
    And "Teslimat Bilgileri" sayfasinda oldugunu dogrula
    Then asamayi gec
    And "Ödeme Bilgileri" sayfasinda oldugunu dogrula
    Then "Anında Havale" yontemini sec
    Then "<banka>" sec
    Then devam et butonuna tikla
    Then "Sipariş Özeti" sayfasinda oldugunu dogrula
    Then odeme bilgilerinden "<banka>" adini dogrula
    Then sepeti bosalt
    Examples:
      | banka         |
      | Akbank        |
      | İş Bankası    |
      | Vakıfbank     |
      | Kuveyt Türk   |
      | AlBaraka Türk |



