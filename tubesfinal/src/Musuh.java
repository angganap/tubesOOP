import java.util.ArrayList;

public class Musuh extends Karakter implements KarakteristikMusuh{

    public Musuh(String nama, String deskripsi, int darah, int kerusakan) {
        super(nama, deskripsi, darah, kerusakan, 0, false);
    }

    public void seranganMusuh(Karakter karakterTerpilih){
        karakterTerpilih.setDarah(karakterTerpilih.getDarah() - getKerusakan() + karakterTerpilih.getTameng());
        setDarah(getDarah() - karakterTerpilih.getKerusakan() + getTameng());
    }
}

