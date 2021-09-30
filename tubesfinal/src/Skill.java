public class Skill extends ElemenGame{
    int idSkill;

    public Skill(String nama, String deskripsi){
        super(nama, deskripsi);
    }

    public void gunakanSkill(Karakter karakterPil,int darah){
        if(getDeskripsi() == "Skill1"){
            skill1(karakterPil);
        }else if(getDeskripsi() == "Skill2"){
            skill2(karakterPil);
        }else if(getDeskripsi() == "Skill3"){
            skill3(karakterPil);
            if(karakterPil.getDarah()>darah){
                karakterPil.setDarah(darah);
            }
        }
    }

    public void pulihkanSkill(Karakter karakterPil){
        if(getDeskripsi() == "Skill1"){
            karakterPil.setTameng(karakterPil.getTameng() - (5 * karakterPil.getLevel()));
        }else if(getDeskripsi() == "Skill2"){
            karakterPil.setKerusakan(karakterPil.getKerusakan() - (5 * karakterPil.getLevel()));
        }else if(getDeskripsi() == "Skill3"){
            karakterPil.setDarah(karakterPil.getDarah());
        }
    }

    public void skill1(Karakter karakterPil){
        //menambah armor
        karakterPil.setTameng(karakterPil.getTameng() + (5 * karakterPil.getLevel()));
    }

    public void skill2(Karakter karakterPil){
        //menambah kerusakan
        karakterPil.setKerusakan(karakterPil.getKerusakan() + (5 * karakterPil.getLevel()));
    }

    public void skill3(Karakter karakterPil){
        //menambah darah
        karakterPil.setDarah(karakterPil.getDarah() + (50 * karakterPil.getLevel()));
    }
}
