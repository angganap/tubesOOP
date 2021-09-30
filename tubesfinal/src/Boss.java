import java.util.ArrayList;

public class Boss extends Karakter implements KarakteristikMusuh{
    int gunakan;//gunakan skill
    private ArrayList <Skill> skillBoss = new ArrayList<Skill>();

    public Boss(String nama, String deskripsi, int darah, int kerusakan, int tameng) {
        super(nama, deskripsi, darah, kerusakan, tameng, false);
        setLevel(1);
    }

    public void seranganMusuh(Karakter karakterTerpilih){
        karakterTerpilih.setDarah(karakterTerpilih.getDarah() - getKerusakan() + karakterTerpilih.getTameng());
        setDarah(getDarah() - karakterTerpilih.getKerusakan() + getTameng());
    }

    public void setSkillBoss(ArrayList<Skill> skillBoss) {
        this.skillBoss = skillBoss;
    }
}
