import java.util.Scanner;

public class deretBilangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai n: ");
        double n = scanner.nextLong();

        // Mengambil dua digit terakhir dari n
        int twoDigitN = (int) (n % 100);

        generateSequence(twoDigitN);

        scanner.close();
    }

    static void generateSequence(int n) {
        for (int i = 1; i <= n; i++) {
            if (i == 6 || i == 10) {
                System.out.print("x ");
            } else if (i % 2 != 0) {
                System.out.print("* ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
