package LambdaCourse;

import java.util.ArrayList;
import java.util.List;

public class FonksiyonelProgramlama02 {
    /*
    Method Referance: Class ismi ::Method ismi(method parantezleri yoktur kullanılmaz()
    orn; String :: Length
        ArrayList :: size
     */
    public static void main(String[] args) {
        List<Integer> liste=new ArrayList<>();
        liste.add(7);
        liste.add(10);
        liste.add(2);
        liste.add(5);
        liste.add(11);
        liste.add(6);
        liste.add(9);
        liste.add(16);

        System.out.println(liste);

        elemanlariAyniSatirdaYazdir(liste);
        System.out.println();
        ciftSayilariAyniSatirdaYazdir(liste);
        System.out.println();
        tekSayilarinKupunuAl(liste);
        System.out.println();
        kupleriToplami(liste);
        System.out.println();
        minSayiDegeri(liste);

    }
    // 1 - list elemanlarını bir boşluk bırakarak aynı satırda yazdıran bir method oluşturun
    public static void elemanlariAyniSatirdaYazdir(List<Integer> liste){
     liste.stream().forEach(Utils::elemanlariAyniSatirdaBirBoslukBirakarakYazdir);
    }
    public static void ciftSayilariAyniSatirdaYazdir(List<Integer> liste){
       liste.stream().filter(Utils::ciftSayiYazdir).forEach(Utils::elemanlariAyniSatirdaBirBoslukBirakarakYazdir);
    }
    //tek sayilarin küpünü alan ve aynı satirda yazdıran bir method yazın
    public static void tekSayilarinKupunuAl(List<Integer> liste){
        liste.stream().filter(Utils::tekSayiYazdir).map(Utils::sayininKupunuAl).forEach(Utils::elemanlariAyniSatirdaBirBoslukBirakarakYazdir);
    }
    //cift sayıların küpleri toplamı
    public static void kupleriToplami(List<Integer> liste){
       Integer toplam= liste.stream().filter(Utils::ciftSayiYazdir).map(Utils::sayininKupunuAl).reduce(0,Math::addExact);
        System.out.println(toplam);
    }
    // list in elemanlarının en kucuk değeri bulan bir method oluşturun
    public static void minSayiDegeri(List<Integer> liste){
        System.out.println(liste.stream().reduce(Integer.MAX_VALUE,Math::min));
    }
}
