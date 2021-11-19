package hepsiPAY;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum BankaAdlariListesi_Enum {

    AKBANK("Akbank"),


    IS_BANKASI("İş Bankası"),


    VAKIFBANK("Vakıfbank"),


    KUVEYT_TURK("Kuveyt Türk"),


    ALBARAKA_TURK("AlBaraka Türk");

    @Getter
    private String bankaAdi;
}
