package LambdaCourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FonksiyonelProgramlama05 {
    public static void main(String[] args) {
        Kurs turkceGunduz=new Kurs("Yaz","Turkce Gunduz",97,128);
        Kurs turkceGece=new Kurs("Kis","Turkce Gece",98,154);
        Kurs IngilizceGunduz=new Kurs("Ilkbahar","Ingilizce Gunduz",95,132);
        Kurs IngilizceGece=new Kurs("Kis","Ingilizce Gece",93,144);

        List<Kurs> kursList=new ArrayList<>();
        kursList.add(turkceGunduz);
        kursList.add(turkceGece);
        kursList.add(IngilizceGece);
        kursList.add(IngilizceGece);

        System.out.println(kursList);
        System.out.println(ortalama91Buyuk(kursList,92));
        System.out.println(herhangiBirKelimeVarMi(kursList));
        enYuksekOrtalama(kursList);

    }
    //1. ortalama puanın 91'den buyuk olup olmadğını check eden bir method yazın
    public static boolean ortalama91Buyuk(List<Kurs> kursList, int ortalama){
        return kursList.stream().allMatch(t->t.getNotOrtalamasi()>ortalama);
    }
    //2. En az bir kurs isminde "Turkce" kelimesi olup olmadğını check eden bir method yazın
    public static boolean herhangiBirKelimeVarMi(List<Kurs> kursList){
        return kursList.stream().anyMatch(t->t.getKursIsmi().contains("Turkce"));
    }
    //3. en yüksek ortalama puanı bulan bir method yazın
    public static void enYuksekOrtalama(List<Kurs> kursList){
        Kurs sonuc= kursList.stream().sorted(Comparator.comparing(Kurs::getNotOrtalamasi).reversed()).findFirst().get();
        System.out.println(sonuc);
    }

}
