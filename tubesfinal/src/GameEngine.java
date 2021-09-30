import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {

    private ArrayList<Karakter> pilKarakter = new ArrayList<Karakter>();
    private Ruangan objRuangan = new Ruangan();
    private Player objPlayer;
    private Karakter objKarakter;
    private Toko objToko;
    private static Scanner in = new Scanner(System.in);
    private String namaPlayer;

    private void simpanFile(){
        try {
            System.out.println(objPlayer.getNama()+ ":");
            FileWriter tulisLevel = new FileWriter("E:/PBO/tubesfinal/data/" + objPlayer.getNama() + "Level.txt");
            tulisLevel.write(String.valueOf(objPlayer.getLevel()));
            FileWriter tulisXp = new FileWriter("E:/PBO/tubesfinal/data/" + objPlayer.getNama() + "Xp.txt");
            tulisXp.write(String.valueOf(objPlayer.getXp()));
            tulisLevel.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Data Tersimpan");
    }

    private boolean pilihUser() {
        boolean adaFile = false;
        int pilih;
        boolean buatBaru = false;
        String pilihan;
        System.out.println("Username yang tersedia:");

        //pengecekan file yang tersimpan dengan memanggil fungsi lihatfile
        adaFile = lihatFile();
        if (adaFile == true){
            //jika file ada
            System.out.println();
            System.out.println("[1] Buat player baru");
            System.out.println("[2] Pilih file");
            System.out.print("Pilihan: ");
            pilih = in.nextInt();
            if (pilih == 1){
                //buat player baru
                System.out.print("Nama player:");
                namaPlayer = in.next();
                buatFile(namaPlayer);
                buatBaru = true;
            }else if (pilih == 2){
                //memilih player yang sudah tersedia
                System.out.print("Nama file: ");
                pilihan = in.next();
                bacausername(pilihan);
            }
        }else{
            //kondisi file kosong
            System.out.println("Belum ada yang tersimpan!");
            System.out.println();
            System.out.print("Nama player:");
            namaPlayer = in.nextLine();
            buatFile(namaPlayer);
            buatBaru = true;
        }
        return buatBaru;
    }

    private boolean lihatFile() {
        boolean adaFile = false;
        String[] files;
        File f = new File ("E:/PBO/tubesfinal/loadGame");
        files = f.list();
        for(String file : files){
            adaFile = true;
            System.out.println(file);
        }
        return adaFile;
    }

    private void buatFile(String namaPlayer) {
        try{
            //file menyimpan nama player
            File objFile = new File("E:/PBO/tubesfinal/loadGame/" +namaPlayer+ ".txt");
            objFile.createNewFile();
            System.out.println("File dengan nama "+namaPlayer+ " berhasil dibuat");

            //menyimpan data XP
            FileWriter tulisXp = new FileWriter("E:/PBO/tubesfinal/data/"
                    +namaPlayer+ "Xp.txt");
            tulisXp.write("0"); //menset XP dari awal, yakni 0
            tulisXp.close();

            //menyimpan data level
            FileWriter tulisLevel = new FileWriter("E:/PBO/tubesfinal/data/"
                    +namaPlayer+ "Level.txt");
            tulisLevel.write("1"); //menset level dari awal, yakni 1
            tulisLevel.close();

            //menyimpan data koin
            FileWriter tulisKoin = new FileWriter("E:/PBO/tubesfinal/data/"
                    +namaPlayer+ "Koin.txt");
            tulisKoin.write("0"); //menset koin dari awal, yakni 0
            tulisKoin.close();

            objPlayer = new Player(namaPlayer,"Player",0,1,0);

            //menyimpan data karakter
            isiKarakter();
            int cc = 0;
            for(Karakter karakter : pilKarakter){
                cc++;
                FileWriter tulisKarakter = new FileWriter("E:/PBO/tubesfinal/dataKarakter/"
                        +namaPlayer+ " Karakter" +cc+ ".txt");
                tulisKarakter.write(karakter.getNama()+ "," +Integer.toString(karakter.getLevel())+ "," +karakter.getDeskripsi()+ ","
                        +Integer.toString(karakter.getDarah())+ "," +Integer.toString(karakter.getKerusakan())+
                        "," +Integer.toString(karakter.getTameng()));
                tulisKarakter.close();
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void bacausername(String pil){
        try{
            String namaUser;
            int levelUser, xpUser, koinUser;
            System.out.println();

            //lihat username
            File lihatUsername = new File("E:/PBO/tubesfinal/loadGame/" +pil+ ".txt");
            Scanner nama = new Scanner (lihatUsername);

            //lihat level
            File lihatLevel = new File("E:/PBO/tubesfinal/data/" +pil+ "Level.txt");
            Scanner level = new Scanner (lihatLevel);

            //lihat xp
            File lihatXp = new File("E://PBO//tubesfinal/data/" +pil+ "Xp.txt");
            Scanner xp = new Scanner (lihatXp);

            //lihat koin
            File lihatKoin = new File("E:/PBO/tubesfinal/data/" +pil+ "Koin.txt");
            Scanner koin = new Scanner (lihatKoin);

            objPlayer=new Player(pil,"Player",xp.nextInt(),level.nextInt(),koin.nextInt());
            System.out.println("Username:" +objPlayer.getNama());
            System.out.println("Level:" +objPlayer.getLevel());
            System.out.println("Xp:" +objPlayer.getXp());
            System.out.println("Koin :" +objPlayer.getKoin());

            nama.close();
            level.close();
            xp.close();
            koin.close();

            //lihat karakter
            int cc = 0;
            boolean ulang=true;
            while(ulang){
                cc++;
                File lihatKarakter = new File("E:/PBO/tubesfinal/dataKarakter/" +pil
                        + " Karakter" +cc+ ".txt");
                Scanner detail = new Scanner(lihatKarakter );
                if(lihatKarakter!=null){
                    String[] baca = detail.nextLine().split(",");
                    isiKarakter(baca[0], baca[1], baca[2], baca[3], baca[4], baca[5]);
                }
                else {
                    ulang=false;
                }
                detail.close();
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void isiKarakter(){
        Karakter karakter1 = new Karakter("Gundala", "Gundala si putra petir siap memberantas" +
                " kejahatan yang dilakukan oleh pengkor dan anak buahnya", 500, 40,
                15, true);
        Karakter karakter2 = new Karakter("Aquanus", "Aquanus mendapat kukatan super setelah diberi" +
                " sabuk sinar pelangi oleh seseorang untuk membalas dendam kepada bangsa bur-bur",
                475, 65, 20, true);
        Karakter karakter3 = new Karakter("Si Buta dari Gua Hantu", "Si Buta siap untuk membalas" +
                " dendam dahulu orang yang pernah menghancurkan desanya", 800, 25, 20,
                true);
        pilKarakter.add(karakter1);
        pilKarakter.add(karakter2);
        pilKarakter.add(karakter3);
    }

    public void isiKarakter(String nama, String level, String deskripsi, String darah, String kerusakan, String tameng){
        Karakter karakter = new Karakter(nama, deskripsi, Integer.parseInt(darah), Integer.parseInt(kerusakan),
                Integer.parseInt(tameng), true);
        pilKarakter.add(karakter);
    }

    public void pilihKarakter(){
        int no = 0;
        System.out.println("=======PILIH KARAKTER=======");
        for(Karakter pilih : pilKarakter){
            no++;
            System.out.print(no+ ". ");
            System.out.println(pilih.getNama());
        }
        System.out.print("Pilihan anda: ");
        int pil = in.nextInt();
        objKarakter = pilKarakter.get(pil-1);
    }

    public void mulai(){
        objRuangan.arenaPertarungan(objKarakter, objPlayer);
    }

    public static void main(String[] args) {
        boolean isBaru;
        boolean isBermain = true;
        GameEngine mygame = new GameEngine();
        isBaru = mygame.pilihUser();
        while(isBermain){
            if(isBaru == true){
                mygame.pilihKarakter();
                mygame.mulai();
            }else{
                System.out.println("=====MENU=====");
                System.out.println("[1] Pilih Karakter");
                System.out.println("[2] Mulai Bermain");
                System.out.println("[3] Toko");
                System.out.println("[4] Keluar");
                System.out.print("Masukan Pilihan Anda : ");
                int menu = in.nextInt();
                if (menu == 1) {
                    mygame.pilihKarakter();
                    mygame.mulai();
                } else if (menu == 2) {
                    mygame.mulai();
                } else if (menu == 3){
                    mygame.objToko.beliKarakter(mygame.objPlayer.getKoin());
                } else {
                    System.out.println("Anda Keluar");
                }
            }
        }
    }
}
