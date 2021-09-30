import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toko {
    HashMap<Karakter, Integer> jualan = new HashMap<>();

    public Toko (){
        Karakter godam = new Karakter("Godam", "Godam merupakan manusia yang dikutuk masuk kedalam" +
                " cincin sakti dikarenakan melanggar sumpah. Gunakan cincin sakti untuk berubah wujud menjadi" +
                " godam", 625, 45, 20, true);
        Karakter herbintang = new Karakter("Herbintang", "Seseorang masuk ke alam lain melalui " +
                " perantara roh di dalam pisau, dimana alam tersebut terdapat kakek cahaya yang memberi kekuatan " +
                "herbintang", 625, 50, 20, true);
        jualan.put(godam, 1);
        jualan.put(herbintang, 2);
    }

    public void printJualan(){
        int no = 0;
        int harga = 0;
        for(Map.Entry<Karakter, Integer> entry : jualan.entrySet()){
            no++;
            if(entry.getValue() == 1){
                harga = 100;
            }else if(entry.getValue() == 2){
                harga= 300;
            }
            System.out.print(no+". ");
            System.out.println(entry.getKey().getNama()+ "dengan harga:" +harga);
        }
    }

    public Karakter beliKarakter(int koin){
        Scanner in = new Scanner(System.in);
        printJualan();
        System.out.println("Masukan pilihan karakter anda : ");
        String pil = in.nextLine();
        for(Map.Entry<Karakter, Integer> entry : jualan.entrySet()){
            if(entry.getKey().getNama() == pil){
                if(entry.getValue() == 1){
                    koin = koin - 100;
                }else if (entry.getValue() == 2){
                    koin = koin - 300;
                }
                Karakter temp = entry.getKey();
                jualan.remove(entry.getKey());
                return temp;
            }
        }
        return null;
    }
}
