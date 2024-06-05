public class DPRD extends PegawaiNegara {
    private int jumlahKunjungan;

    public DPRD(String NIP, double gajiPokok, String daerahKekuasaan) {
        super(NIP, gajiPokok, daerahKekuasaan);
        this.jumlahKunjungan = 0;
    }

    public void tambahKunjungan() {
        jumlahKunjungan++;
    }

    @Override
    public double getTunjangan() {
        return gajiPokok + (jumlahKunjungan * 1000000);
    }

    @Override
    public void bayarPajak(double jumlahPajak, APBN apbn) {
        apbn.tambahDana(jumlahPajak);
    }

    public String getNIP() {
        return NIP;
    }
}
