public class RakyatJelata {
    private String alamat;
    private double jumlahKekayaan;

    public RakyatJelata(String alamat, double jumlahKekayaan) {
        this.alamat = alamat;
        this.jumlahKekayaan = jumlahKekayaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getJumlahKekayaan() {
        return jumlahKekayaan;
    }

    public void tambahKekayaan(double jumlah) {
        this.jumlahKekayaan += jumlah;
    }

    public void bayarPajak(double jumlahPajak, APBN apbn) {
        apbn.tambahDana(jumlahPajak);
    }
}
