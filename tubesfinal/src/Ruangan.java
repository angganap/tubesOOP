import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan{
    private Skill objSkill;
    private Musuh objMusuh;
    private Player objPlayer;
    private Karakter karakterTerpilih;
    private int darahBoss;
    private int darahKarakter;
    Scanner in = new Scanner(System.in);

    public void serang(int pilih,KarakteristikMusuh musuhSerang){
        if(pilih==1){
            musuhSerang.seranganMusuh(karakterTerpilih);
        }
        else if(pilih==2){
            int pilihSkill;
            karakterTerpilih.printSkill();
            System.out.print("Masukan Pilihan Skill : ");
            pilihSkill = in.nextInt();
            objSkill=karakterTerpilih.getSkillPilihan(pilihSkill,karakterTerpilih.getSkills());
            objSkill.gunakanSkill(karakterTerpilih,darahKarakter);
            musuhSerang.seranganMusuh(karakterTerpilih);
            objSkill.pulihkanSkill(karakterTerpilih);
        }
    }

    public void hasil(Karakter musuh,int koin,String ket){
        if(karakterTerpilih.getDarah()>0 && musuh.getDarah()<=0){
            musuh.setDarah(0);
            System.out.println("SELAMAT ANDA TELAH MENGALAHKAN MUSUH");
            karakterTerpilih.setXp(karakterTerpilih.getXp()+10);
            objPlayer.tambahKoin(koin);
            if(ket.equals("boss")){
                objPlayer.tambahXP();
            }
        }
        else if(karakterTerpilih.getDarah()<=0 && musuh.getDarah()>0){
            karakterTerpilih.setDarah(0);
            System.out.println("GAME OVER");
        }
    }

    public void pulihkan(){
        karakterTerpilih.setDarah(darahKarakter);
    }

    public void arenaPertarungan(Karakter karakterTerpilih, Player objPlayer){
        this.karakterTerpilih = karakterTerpilih;
        this.objPlayer = objPlayer;
        darahKarakter=karakterTerpilih.getDarah();
        darahBoss=karakterTerpilih.getBoss().getDarah();
        int pilih;
        for(int i=1;i<=3;i++){
            if(i==3){
                int n=1;
                int gunakan=1;
                while (karakterTerpilih.getDarah()>0 && karakterTerpilih.getBoss().getDarah()>0){
                    System.out.println("Ruangan ke-"+i);
                    System.out.print("1. Serang Bos\n2. Gunakan Skill\n3. Keluar\n\nMasukan pilihan Anda : ");
                    pilih = in.nextInt();
                    if(n%5==0){
                        Skill skillPilih = karakterTerpilih.getSkillPilihan(gunakan%3,karakterTerpilih.getSkillsBoss());
                        skillPilih.gunakanSkill(karakterTerpilih.getBoss(),darahBoss);
                    }
                    if(pilih==3){
                        pulihkan();
                        break;
                    }
                    else{
                        serang(pilih,karakterTerpilih.getBoss());
                    }
                    if(n%5==0){
                        karakterTerpilih.getSkillPilihan(gunakan%3,karakterTerpilih.getSkillsBoss()).pulihkanSkill(objMusuh);
                        gunakan++;
                    }
                    if(karakterTerpilih.getBoss().getDarah()<=0){
                        karakterTerpilih.getBoss().setDarah(0);
                    }
                    if(karakterTerpilih.getDarah()<=0){
                        karakterTerpilih.setDarah(0);
                    }
                    System.out.println("\n===============================");
                    System.out.println("Karakter:");
                    karakterTerpilih.print();
                    System.out.println("\nMusuh:");
                    karakterTerpilih.getBoss().print();
                    System.out.println("===============================\n");
                    n++;
                }
                hasil(karakterTerpilih.getBoss(),30,"boss");
                pulihkan();
            }
            else{
                for(int j=0;j<(i*2);j++){
                    objMusuh = new Musuh("Prajurit", "Musnahkan para prajurit!", 100, 25);
                    while(karakterTerpilih.getDarah()>0 && objMusuh.getDarah()>0){
                        System.out.println("Ruangan ke-"+i);
                        System.out.print("1. Serang Musuh\n2. Gunakan Skill\n3. Keluar\n\nMasukan pilihan Anda : ");
                        pilih = in.nextInt();
                        if(pilih==3){
                            pulihkan();
                            break;
                        }
                        else{
                            serang(pilih,objMusuh);
                        }
                        if(objMusuh.getDarah()<=0){
                            objMusuh.setDarah(0);
                        }
                        if(karakterTerpilih.getDarah()<=0){
                            karakterTerpilih.setDarah(0);
                        }
                        System.out.println("\n===============================");
                        System.out.println("Karakter:");
                        karakterTerpilih.print();
                        System.out.println("\nMusuh:");
                        objMusuh.print();
                        System.out.println("===============================\n");
                    }
                    hasil(objMusuh,5,"prajurit");
                }
            }
        }
    }

}
