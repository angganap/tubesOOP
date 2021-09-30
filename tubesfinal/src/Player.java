import java.util.ArrayList;

public class Player extends ElemenGame{
    private int xp;
    private int level;
    private int koin;
    private ArrayList<Karakter> karakterDimiliki = new ArrayList<Karakter>();

    //constructor
    public Player(String nama, String deskripsi , int xp, int level, int koin){
        super(nama, deskripsi);
        this.xp = xp;
        this.level = level;
        this.koin = koin;
    }

    public void tambahXP(){
        if (xp < 10 * level){
            xp = xp + 10;
            System.out.println("Xp player: "+xp);
        }else{
            tambahLevel();
            xp = 0;
        }
    }

    public void tambahLevel(){
        System.out.println("=======SELAMAT " +getNama()+ ", ANDA NAIK LEVEL=======");
        level++;
        tambahKoin(100 + level);
    }

    public void tambahKoin(int tambah){
        koin = koin + tambah;
    }

    public void kurangiKoin(int kurang){
        koin = koin - kurang;
        if(koin < 0){
            koin = 0;
        }
    }

    public void printInfo(){
        System.out.println("========INFORMASI PLAYER========");
        System.out.println("Nama :" +getNama());
        System.out.println("Bio :" +getDeskripsi());
        System.out.println("Level :" +level);
        System.out.println("XP :" +xp);
        System.out.println("Koin yang dimiliki : $" +koin);
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKoin() {
        return koin;
    }

    public void setKoin(int koin) {
        this.koin = koin;
    }

    public ArrayList<Karakter> getKarakterDimiliki() {
        return karakterDimiliki;
    }

    public void setKarakterDimiliki(ArrayList<Karakter> karakterDimiliki) {
        this.karakterDimiliki = karakterDimiliki;
    }
}
