package LambdaCourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FonksiyonelProgramlama03 {
    public static void main(String[] args) {
        List<String> liste= new ArrayList<>();
        liste.add("Ali");
        liste.add("Bunyamin");
        liste.add("Mert");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");

        System.out.println(liste);
        buyukHarfeCevir(liste);
        System.out.println();
        uzunluklarinaGoreSirala(liste);
        System.out.println();
        sonKaraktereGoreSirala(liste);
        System.out.println();
        onceUzunlukSonraIlkKaraktereGoreSirala(liste);
        System.out.println();
   //     uzunlukBestenUzunsaSil(liste);
   //     aIleBaslayanNIleBiten(liste);
        System.out.println();
        uzunlugunKaresiFarkliOlanElemanlariTerstenYazma(liste);
        System.out.println("---");
        elemanmariUzunlugu12denKucuk(liste);
        System.out.println("---");
        ilkHarficheckEt(liste);
        System.out.println("---");
        sonKaraktereBak(liste);

    }
    //1. butun elemanları büyük harfe ceviren bir method yazın
    public static void buyukHarfeCevir(List<String> liste){
        liste.
                stream().map(String::toUpperCase).forEach(Utils::elemanlariAyniSatirdaBirBoslukBirakarakYazdir);
    }
    //2. Stringleri uzunluklarına sıralayan bir method oluşturun
    public static void uzunluklarinaGoreSirala(List<String> liste){
     liste.
             stream().sorted(Comparator.comparing(String::length)).
             forEach(System.out::println);
    }
    //3. elemanları en son karaktere göre sıralayan bir method oluşturun
    public static void sonKaraktereGoreSirala(List<String> liste){
        liste.
                stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                forEach(System.out::println);
    }
    //4. elemanları önce uzunluklarına göre sonra ilk karaktere göre sıralayan bir method oluşturun
    public static void onceUzunlukSonraIlkKaraktereGoreSirala(List<String> liste){
        liste.
                stream().
                sorted(Comparator.comparing(String::length).thenComparing(t->t.charAt(0))).
                forEach(System.out::println);
    }
    //5. elemanlardan uzunluğu 5 karakterden fazla olanı silen bir method oluşturun
 /*   public static void uzunlukBestenUzunsaSil(List<String> liste){
        liste.removeIf(t->t.length()>5);
        System.out.println(liste);
    }*/
    //6. elemanlardan "A" "a" ile başlayan ve "N" "n" harfi ile biten elemanları silen bir method oluşturun
 /*   public static void aIleBaslayanNIleBiten(List<String> liste){
        liste.removeIf(t->t.charAt(0)=='A' || t.charAt(0)=='a'|| t.charAt(t.length()-1)=='N'|| t.charAt(t.length()-1)=='n');
        System.out.println(liste);
    }*/

    //7. her bir elemanın uzunluğunun karesini alan ve farklı olanları tersten yazdıran bir method oluşturun
    public static void uzunlugunKaresiFarkliOlanElemanlariTerstenYazma(List<String> liste){
        liste.
                stream().
                map(String::length).
                map(Utils::sayininKaresiniAl).
                distinct().sorted(Comparator.reverseOrder()).
                forEach(Utils::elemanlariAyniSatirdaBirBoslukBirakarakYazdir);
    }
    //8. listin butun elemanlarının uzunluğunun 12 den kucuk olup olmadığını bulan bir method yazın
    public static void elemanmariUzunlugu12denKucuk(List<String> liste){
        boolean sonuc= liste.stream().allMatch(t->t.length()<12);
        System.out.println(sonuc);
    }
    //9. elemanların herhangi birinin ilk harfinin "x" ile başlayıp başlamadığını bulan bir method yazın
    public static void ilkHarficheckEt(List<String> liste){
        boolean sonuc= liste.stream().noneMatch(t->t.startsWith("x"));
        System.out.println(sonuc);
    }
    //10 elemanlardan en az birinin son harfinin "o" harfi olduğunu bulan bir method yazın
    public static void sonKaraktereBak(List<String> liste){
       boolean sonuc= liste.stream().anyMatch(t->t.endsWith("O")||t.endsWith("o"));
        System.out.println(sonuc);
    }
}
