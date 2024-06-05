public class APBN {
    private double totalDana;

    public APBN(double totalDana) {
        this.totalDana = totalDana;
    }

    public void tambahDana(double jumlah) {
        totalDana += jumlah;
    }

    public void kurangiDana(double jumlah) {
        if (totalDana >= jumlah) {
            totalDana -= jumlah;
        } else {
            System.out.println("Error: Dana tidak mencukupi.");
        }
    }

    public double getTotalDana() {
        return totalDana;
    }
}
