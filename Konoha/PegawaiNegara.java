public abstract class PegawaiNegara {
    protected String NIP;
    protected double gajiPokok;
    protected String daerahKekuasaan;

    public PegawaiNegara(String NIP, double gajiPokok, String daerahKekuasaan) {
        this.NIP = NIP;
        this.gajiPokok = gajiPokok;
        this.daerahKekuasaan = daerahKekuasaan;
    }

    public abstract double getTunjangan();

    public abstract void bayarPajak(double jumlahPajak, APBN apbn);

    public String getNIP() {
        return NIP;
    }

    public String getDaerahKekuasaan() {
        return daerahKekuasaan;
    }
}
