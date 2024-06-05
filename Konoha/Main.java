public class Main {
    public static void main(String[] args) {
        APBN apbn = new APBN(100000000);

        PNS pns1 = new PNS("12345", 5000000, "Konoha");
        PNS pns2 = new PNS("67890", 5500000, "Konoha");

        RakyatJelata rakyat1 = new RakyatJelata("Konoha", 50000);
        RakyatJelata rakyat2 = new RakyatJelata("Konoha", 150000);
        RakyatJelata rakyat3 = new RakyatJelata("Konoha", 90000);
        RakyatJelata rakyat4 = new RakyatJelata("Sunagakure", 90000);

        Gubernur gubernur = new Gubernur("54321", 8000000, "Konoha");

        DPRD dprd = new DPRD("09876", 6000000, "Konoha");

        pns1.mendataRakyat(rakyat1);
        pns1.mendataRakyat(rakyat2);
        pns1.mendataRakyat(rakyat3);
        pns1.mendataRakyat(rakyat4);

        pns1.salurkanBantuan(apbn);

        gubernur.mendataPNS(pns1);
        gubernur.mendataPNS(pns2);

        gubernur.tambahkanDanaKeAPBN(5000000, apbn);

        dprd.tambahKunjungan();
        dprd.tambahKunjungan();
        dprd.tambahKunjungan();

        pns1.bayarPajak(500000, apbn);
        pns2.bayarPajak(550000, apbn);
        gubernur.bayarPajak(800000, apbn);
        dprd.bayarPajak(600000, apbn);
        rakyat1.bayarPajak(10000, apbn);
        rakyat2.bayarPajak(20000, apbn);
        rakyat3.bayarPajak(15000, apbn);
        rakyat4.bayarPajak(15000, apbn);

        System.out.println("Total Dana APBN: " + apbn.getTotalDana());

        System.out.println("Informasi Pegawai Negeri Sipil:");
        System.out.println("NIP PNS1: " + pns1.getNIP());
        System.out.println("Daerah Kekuasaan PNS1: " + pns1.getDaerahKekuasaan());
        System.out.println("Tunjangan PNS1: " + pns1.getTunjangan());

        System.out.println("NIP PNS2: " + pns2.getNIP());
        System.out.println("Daerah Kekuasaan PNS2: " + pns2.getDaerahKekuasaan());
        System.out.println("Tunjangan PNS2: " + pns2.getTunjangan());

        System.out.println("Informasi Gubernur:");
        System.out.println("NIP Gubernur: " + gubernur.getNIP());
        System.out.println("Daerah Kekuasaan Gubernur: " + gubernur.getDaerahKekuasaan());
        System.out.println("Tunjangan Gubernur: " + gubernur.getTunjangan());

        System.out.println("Informasi DPRD:");
        System.out.println("NIP DPRD: " + dprd.getNIP());
        System.out.println("Daerah Kekuasaan DPRD: " + dprd.getDaerahKekuasaan());
        System.out.println("Tunjangan DPRD: " + dprd.getTunjangan());

        System.out.println("Kekayaan Rakyat1: " + rakyat1.getJumlahKekayaan());
        System.out.println("Kekayaan Rakyat2: " + rakyat2.getJumlahKekayaan());
        System.out.println("Kekayaan Rakyat3: " + rakyat3.getJumlahKekayaan());
        System.out.println("Kekayaan Rakyat4: " + rakyat4.getJumlahKekayaan());

        System.out.println("Pesan Kesalahan:");
        pns1.mendataRakyat(new RakyatJelata("Sunagakure", 70000));
    }
}
