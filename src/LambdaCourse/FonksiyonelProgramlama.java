package LambdaCourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FonksiyonelProgramlama {
    /*
    1- Lambda fonsiyonel bir programlamadır
    2- Fonksiyonel programlama Java 8 den sonra geldi. dolayısıyla sonraki versiyonlarda lambda kullanılabilir
    önceki versiyonlarda structured programing kullanılıyorda. java 8 den sonra hem yapılandırılmış hemde fonksiyonel
    programlama beraber kullanıldı
    3-Structured programing bize "bir şeyin nasıl yapılması gerektiğini" fakat fonksiyonel programlama ise bize "ne yapmamız
    gerektiğini" söyler
    4- Fonksiyonel programlama SADECE collections ve Arrays ile calışır
     */


// 1 - list elemanlarını bir boşluk bırakarak aynı satırda yazdıran bir method oluşturun(structured)

    public static void elemaniYazdir(List<Integer> liste){
        for(Integer w:liste){
            System.out.print(w+" ");
        }
    }
    // 1 - list elemanlarını bir boşluk bırakarak aynı satırda yazdıran bir method oluşturun(functinal)

    public static void elemaniYazdir01(List<Integer> liste){
        liste.stream().forEach(t-> System.out.print(t+" "));

    }
    //2-1- list elemanlarından çift olanları aralarında boşluk bırakarak yazdıran bir method oluşturun(structured)
    public static void ciftSayilariYazdir(List<Integer> liste){
        for (Integer w:liste){
            if(w%2==0){
                System.out.print(w+" ");
            }
        }
    }
    //2-1- list elemanlarından çift olanları aralarında boşluk bırakarak yazdıran bir method oluşturun(functional)

    public static void ciftSayilariYazdir01(List<Integer> liste){
        liste.stream().filter(t-> t%2==0).forEach(t-> System.out.print(t+" "));
    }
// 3- list elemanlarından cift olanların karelerini alan bir method oluşturun
    public static void ciftlerinKaresiniAl(List<Integer> liste){
        liste.stream().filter(t-> t%2==0).map(t-> t*t).forEach(t-> System.out.print(t+" "));
    }
// 4- list elemanlarından birbirinden farklı olan tek sayıların küpünü alan ve aynı satırda yazdıran bir method oluşturun
    public static void farkliTekSayilarinKupu(List<Integer> liste){
  //     liste.stream().filter(t->t%2!=0).distinct().map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    liste.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    }

// 5- list elemanlarından birbirinden farklı olan tek sayıların küpünü alan ve bunların toplamını yazdıran bir method oluşturun
public static void tekSayilarinKupleriToplami(List<Integer> liste){
     Integer toplam= liste.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).reduce(0,(t,u)->t+u);
    System.out.println(toplam);
}
//6. list elemanlarından en buyük değeri bulan bir method yazınınz
    public static void enBuyukDeger(List<Integer> liste){
        System.out.println(liste.stream().reduce(Integer.MIN_VALUE,(t,u)->t>u ? t : u));
     }
     //7. listede bulunan elliden büyük çift sayıları yazdır
     public static void ellidenBuyukCiftSayi(List<Integer> liste){
    liste.stream().filter(t->(t>50 && t%2==0)).forEach(t-> System.out.print(t+" "));
     }
//7. listede bulunan elliden büyük en kücük çift sayıyı  yazdır
     public static void ellidenBuyukEnKucukSayi(List<Integer> liste){
 //        System.out.println(liste.stream().filter(t->(t>50 && t%2==0)).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t,u)->u));
        Integer eleman= liste.stream().filter(t->(t>50 && t%2==0)).sorted().findFirst().get();
         System.out.println(eleman);
     }


    public static void main(String[] args) {
        List<Integer> liste=new ArrayList<>();
        liste.add(7);
        liste.add(11);
        liste.add(120);
        liste.add(52);
        liste.add(84);
        liste.add(6);
        liste.add(5);
        liste.add(7);

        System.out.println(liste);
        elemaniYazdir(liste);
        System.out.println();
        elemaniYazdir01(liste);
        System.out.println();
        ciftSayilariYazdir(liste);
        System.out.println();
        ciftSayilariYazdir01(liste);
        System.out.println();
        ciftlerinKaresiniAl(liste);
        System.out.println();
        farkliTekSayilarinKupu(liste);
        System.out.println();
        tekSayilarinKupleriToplami(liste);
        enBuyukDeger(liste);
        ellidenBuyukCiftSayi(liste);
        System.out.println();
        ellidenBuyukEnKucukSayi(liste);

    }
}
