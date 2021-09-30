public class ElemenGame {
    private String nama;
    private String deskripsi;

    public ElemenGame(String nama, String deskripsi){
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
