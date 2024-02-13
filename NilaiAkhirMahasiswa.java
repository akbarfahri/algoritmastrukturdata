import java.util.Scanner;

public class NilaiAkhirMahasiswa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("===============================");

        // Input nilai tugas
        System.out.print("Masukkan Nilai Tugas : ");
        int nilaiTugas = scanner.nextInt();

        // Input nilai kuis
        System.out.print("Masukkan Nilai Kuis : ");
        int nilaiKuis = scanner.nextInt();

        // Input nilai UTS
        System.out.print("Masukkan Nilai UTS : ");
        int nilaiUTS = scanner.nextInt();

        // Input nilai UAS
        System.out.print("Masukkan Nilai UAS : ");
        int nilaiUAS = scanner.nextInt();

        System.out.println("===============================");

        // Memeriksa apakah nilai berada dalam rentang yang valid (0-100)
        if (isValidNilai(nilaiTugas) && isValidNilai(nilaiKuis) && isValidNilai(nilaiUTS) && isValidNilai(nilaiUAS)) {
            // Menghitung nilai akhir berdasarkan bobot yang diberikan
            double nilaiAkhir = hitungNilaiAkhir(nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);

            // Menampilkan nilai akhir
            System.out.println("Nilai Akhir : " + nilaiAkhir);

            // Menentukan nilai huruf dan kualifikasi berdasarkan rentang tertentu
            tentukanNilaiHurufDanKualifikasi(nilaiAkhir);
        } else {
            System.out.println("Nilai tidak valid. Pastikan semua nilai berada dalam rentang 0-100.");
        }

        System.out.println("===============================");
    }

    // Fungsi untuk memeriksa apakah nilai berada dalam rentang 0-100
    static boolean isValidNilai(int nilai) {
        return nilai >= 0 && nilai <= 100;
    }

    // Fungsi untuk menghitung nilai akhir berdasarkan bobot yang diberikan
    static double hitungNilaiAkhir(int nilaiTugas, int nilaiKuis, int nilaiUTS, int nilaiUAS) {
        double bobotTugas = 0.2;
        double bobotKuis = 0.2;
        double bobotUTS = 0.3;
        double bobotUAS = 0.4;

        double nilaiAkhir = (nilaiTugas * bobotTugas) + (nilaiKuis * bobotKuis) + (nilaiUTS * bobotUTS) + (nilaiUAS * bobotUAS);

        return nilaiAkhir;
    }

    // Fungsi untuk menentukan nilai huruf dan kualifikasi berdasarkan rentang tertentu
    private static void tentukanNilaiHurufDanKualifikasi(double nilaiAkhir) {
        if (nilaiAkhir >= 80 && nilaiAkhir <= 100) {
            System.out.println("Nilai Huruf : A\nNilai Setara : 4\nKualifikasi : Sangat Baik");
        } else if (nilaiAkhir >= 73 && nilaiAkhir <= 79) {
            System.out.println("Nilai Huruf : B\nNilai Setara : 3.5\nKualifikasi : Lebih dari Baik");
        } else if (nilaiAkhir >= 65 && nilaiAkhir <= 72) {
            System.out.println("Nilai Huruf : B\nNilai Setara : 3\nKualifikasi : Baik");
        } else if (nilaiAkhir >= 60 && nilaiAkhir <= 64) {
            System.out.println("Nilai Huruf : C\nNilai Setara : 2.5\nKualifikasi : Lebih dari Cukup");
        } else if (nilaiAkhir >= 50 && nilaiAkhir <= 59) {
            System.out.println("Nilai Huruf : C\nNilai Setara : 2\nKualifikasi : Cukup");
        } else if (nilaiAkhir >= 39 && nilaiAkhir <= 49) {
            System.out.println("Nilai Huruf : D\nNilai Setara : 1\nKualifikasi : Kurang");
        } else if (nilaiAkhir >= 0 && nilaiAkhir <= 38) {
            System.out.println("Nilai Huruf : E\nNilai Setara : 0\nKualifikasi : Gagal");
        } else {
            System.out.println("Nilai diluar rentang klasifikasi.");
        }
    }
}
