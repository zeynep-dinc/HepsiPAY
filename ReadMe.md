#HEPSİBURADA ÖDEME SİSTEMİ

##Kullanılan Teknolojiler ve Kütüphaneler

<ul>
<li>Java</li>
<li>Maven</li>
<li>Cucumber</li>
<li>Lombok</li>
</ul>

##Gereksinimler

<ul>
<li>JDK 16</li>
<li>Google Chrome Tarayıcısı versiyon 96</li>
<li>Firefox Tarayıcısı</li>
</ul>

##İşleyiş ve proje yapısı
Proje BDD tasarım kalıbına uygun bir şekilde oluşturulmaya çalışılmıştır.
<br>
<br>
<u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/test/java/features"> src\test\java\features:</a></u> Adımların senaryo şeklinde Gherkin formatında yazıldığı konum<br>
&nbsp;&nbsp;<a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/test/java/features/AnindaHavaleTest.feature">AnındaHavaleTest</a>

<u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/test/java/steps">src\test\java\steps:</a></u> .feature uzantılı dosyaların implement edildiği konum
<br>
&nbsp;&nbsp;<a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/test/java/steps/AnindaHavaleTest_Step.java">AnındaHavaleTest_Step</a>
<p>
<u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/main/resources/config.properties"> src\main\resources\config.properties:</a></u> Projenin tarayıcı(driver) konumlarının, kullanıcı bilgilerinin tutulduğu konfigürasyon dosyası
<br>
<u><a href="https://github.com/zeynepdinc12/HepsiPAY/tree/master/src/main/resources/drivers">src\main\resources\drivers:</a></u> Projenin tarayıcılarının bulunduğu konumları
</p>

<p>
<u>src\main\java\hepsiPAY:</u> Projenin tarayıcı(driver) konumlarının, kullanıcı değişkenlerinin bulunduğu konum
<ul>
<li><u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/main/java/hepsiPAY/BankaAdlariListesi_Enum.java">BankaAdlariListesi_Enum.java:</a></u> Banka isimlerinin yer aldığı enum class</li> 
<li><u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/main/java/hepsiPAY/AnindaHavale.java">AnindaHavale.java:</a></u> Anında Havele testinin ekranında yer alan değişkenlerinin tutulduğu class</li> 
</ul>
<p>
<u><a href="https://github.com/zeynepdinc12/HepsiPAY/tree/master/src/main/java/base">src\main\java\base:</a></u> Projenin temel komutlarının,fonksiyonlarının yazıldığı ve tutulduğu konum.
<ul>
<li><u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/main/java/base/Driver.java">Driver.java:</a></u> config.properties dosyasının okunduğu ve driverların çalıştırıldığı class</li> 
<li><u><a href="https://github.com/zeynepdinc12/HepsiPAY/blob/master/src/main/java/base/BaseTestFunctions.java">BaseTestFunctions.java:</a></u> temel fonksiyonların tutulduğu class</li> 
</ul>
