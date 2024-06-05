import java.util.ArrayList;
import java.util.List;

public class Gubernur extends PegawaiNegara {
    private List<PNS> daftarPNS;

    public Gubernur(String NIP, double gajiPokok, String daerahKekuasaan) {
        super(NIP, gajiPokok, daerahKekuasaan);
        this.daftarPNS = new ArrayList<>();
    }

    public void mendataPNS(PNS pns) {
        if (!pns.getDaerahKekuasaan().equals(this.daerahKekuasaan)) {
            System.out.println("Error: Daerah kekuasaan PNS tidak sesuai.");
        } else {
            daftarPNS.add(pns);
        }
    }

    public void tambahkanDanaKeAPBN(double jumlah, APBN apbn) {
        apbn.tambahDana(jumlah);
    }

    @Override
    public double getTunjangan() {
        return gajiPokok + (daftarPNS.size() * 100000);
    }

    @Override
    public void bayarPajak(double jumlahPajak, APBN apbn) {
        apbn.tambahDana(jumlahPajak);
    }

    public String getNIP() {
        return NIP;
    }
}
