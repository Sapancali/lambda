package LambdaCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FonksiyonelProgramlama04 {
    public static void main(String[] args) {
        List<Integer>liste=new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(15);
        System.out.println(liste);
        toplam(liste);
        System.out.println();
        yedidenYuzeKadarTopla();
        belliBirSayidanBaskaBirSayiyaKadar(2,5);
        faktoriyelBulma(6);
        ikiSayiArasindakiCiftSayilarinToplami(4,9);
        rakamlarToplami(125,129);

    }
    //1. listteki butun elemanların toplamını bulan bir method yazın
    public static void toplam(List<Integer>liste){
        Integer toplam= liste.stream().reduce(0,Math::addExact);
        System.out.println(toplam);
    }
    //2. 7'den 100 e kadar olan sayıların toplamını bulan bir method yazın
    public static void yedidenYuzeKadarTopla(){
        //1.yol
//        Integer toplam= IntStream.range(7,101).reduce(0,Math::addExact);
        Integer toplam= IntStream.rangeClosed(7,100).reduce(0,Math::addExact);
        System.out.println(toplam);
    }
    public static void belliBirSayidanBaskaBirSayiyaKadar(int a,int b){
        Integer carpma= IntStream.rangeClosed(a,b).reduce(1,Math::multiplyExact);
        System.out.println(carpma);
    }
// Verilen bir sayının faktöriyelini hesaplayan bir method oluşturun
// 5!===5*4*3*2*1=120
    public static void faktoriyelBulma(int a){
        Integer faktoriyel= IntStream.rangeClosed(1,a).reduce(1,Math::multiplyExact);
        System.out.println(faktoriyel);
    }
    // verilen iki sayı arasındaki cift sayıların toplamını hesaplayan bir method oluşturun
    public static void ikiSayiArasindakiCiftSayilarinToplami(int a,int b){
        Integer toplam= IntStream.rangeClosed(a,b).filter(Utils::ciftSayiYazdir).sum();
        System.out.println(toplam);
    }
    // verilen iki sayı arasındaki her bir cift sayının rakamları toplamını hesaplayan bir method oluşturun
    public static void rakamlarToplami(int a,int b){
        Integer toplam= IntStream.rangeClosed(a,b).map(Utils::rakamlariTopla).sum();
        System.out.println(toplam);
    }


}
