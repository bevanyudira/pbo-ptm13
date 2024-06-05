import java.util.ArrayList;
import java.util.List;

public class PNS extends PegawaiNegara {
    private List<RakyatJelata> daftarRakyat;

    public PNS(String NIP, double gajiPokok, String daerahKekuasaan) {
        super(NIP, gajiPokok, daerahKekuasaan);
        this.daftarRakyat = new ArrayList<>();
    }

    public void mendataRakyat(RakyatJelata rakyat) {
        if (!rakyat.getAlamat().equals(this.daerahKekuasaan)) {
            System.out.println("Error: Alamat rakyat tidak sesuai dengan daerah kekuasaan PNS.");
        } else {
            daftarRakyat.add(rakyat);
        }
    }

    public void salurkanBantuan(APBN apbn) {
        double totalBantuan = 0;
        for (RakyatJelata rakyat : daftarRakyat) {
            totalBantuan += rakyat.getJumlahKekayaan() * 0.1;
        }
        apbn.kurangiDana(totalBantuan);
        System.out.println("Bantuan telah disalurkan ke rakyat oleh PNS dengan NIP: " + NIP);
    }

    @Override
    public double getTunjangan() {
        return gajiPokok + (daftarRakyat.size() * 100000);
    }

    @Override
    public void bayarPajak(double jumlahPajak, APBN apbn) {
        apbn.tambahDana(jumlahPajak);
    }

    public String getNIP() {
        return NIP;
    }
}
