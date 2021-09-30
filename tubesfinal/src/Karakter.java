import java.util.ArrayList;
import java.util.Scanner;

public class Karakter extends ElemenGame{
    private int darah;
    private int kerusakan;
    private int tameng;
    private int level;
    private int xp;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    private ArrayList<Skill> skillsBoss = new ArrayList<Skill>();
    private Boss boss;

    public Karakter(String nama, String deskripsi, int darah, int kerusakan, int tameng, boolean isKarakter){
        super(nama, deskripsi);
        this.darah = darah;
        this.kerusakan = kerusakan;
        this.tameng = tameng;
        level=1;
        xp=0;
        if(isKarakter) {
            menentukanSkill(nama);
        }
        menentukanBoss(nama);
    }

    private void menentukanBoss(String nama){
        if(nama == "Gundala"){
            boss = new Boss("Pengkor", "Seorang mafia jahat berusaha merencanakan aksi jahat" +
                    " dengan memberi racun di dalam beras dengan menargetkan wanita hamil", 250, 100, 20);
        }else if(nama == "Aquanus"){
            boss = new Boss("Raja Bur-bur", "Pemimpin bangsa burbur, penjajah planet zyba", 475
            , 100, 20);
        }else if(nama == "Si Buta dari Gua Hantu"){
            boss = new Boss("Mata Malaikat", "Seorang pemimpin yang menyerang desa yang ditinggali" +
                    " oleh Si Buta.", 800, 100,10);
        }
        Skill skillBoss1 = new Skill("Jubah Tungsten Carbide", "Skill1");
        Skill skillBoss2 = new Skill("Meriam Atom", "Skill2");
        Skill skillBoss3 = new Skill("Ramuan Misterius", "Skill3");
        skillsBoss.add(skillBoss1);
        skillsBoss.add(skillBoss2);
        skillsBoss.add(skillBoss3);
    }

    private void menentukanSkill(String nama){
        if(nama == "Gundala"){
            Skill skill1 = new Skill ("Listrik", "Skill1");
            Skill skill2 = new Skill ("Petir", "Skill2");
            Skill skill3 = new Skill ("Awan Hitam", "Skill3");
            skills.add(skill1);
            skills.add(skill2);
            skills.add(skill3);
        }else if(nama == "Aquanus"){
            Skill skill1 = new Skill ("Sabuk Sinar Pelangi", "Skill1");
            Skill skill2 = new Skill ("Ombak", "Skill2");
            Skill skill3 = new Skill ("Badai", "Skill3");
            skills.add(skill1);
            skills.add(skill2);
            skills.add(skill3);
        }else if(nama == "Si Buta dari Gua Hantu"){
            Skill skill1 = new Skill ("Ajian Gua Hantu", "Skill1");
            Skill skill2 = new Skill ("Keris", "Skill2");
            Skill skill3 = new Skill ("Jimat", "Skill3");
            skills.add(skill1);
            skills.add(skill2);
            skills.add(skill3);
        }
    }

    public void printKarakter(){
        System.out.println(getNama());
        System.out.println("Nama Karakter :" +getNama());
        System.out.println("Level Karakter :" +level);
        System.out.println("Darah :" +darah);
        System.out.println("Kerusakan :" +kerusakan);
        System.out.println("Tameng :" +tameng);
    }

    public void print(){
        System.out.println("Nama Karakter :" +getNama());
        System.out.println("Darah :" +darah);
    }

    public void printSkill(){
        int i=1;
        System.out.println("========== Skill yang Dimiliki ==========");
        for(Skill s:skills){
            System.out.println("["+i+"] "+s.getNama());
            i++;
        }
    }

    public Skill getSkillPilihan(int pilih, ArrayList<Skill> skill){
        int i=1;
        Skill skil=null;
        for (Skill s:skill){
            if(i==pilih){
                skil = s;
            }
            i++;
        }
        return skil;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        if(xp>(10*level)){
            xp = xp-(10*level);
            level++;
        }
    }

    public int getDarah() {
        return darah;
    }

    public void setDarah(int darah) {
        this.darah = darah;
    }

    public int getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(int kerusakan) {
        this.kerusakan = kerusakan;
    }

    public int getTameng() {
        return tameng;
    }

    public void setTameng(int tameng) {
        this.tameng = tameng;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public Boss getBoss() {
        return boss;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public ArrayList<Skill> getSkillsBoss() {
        return skillsBoss;
    }
}
