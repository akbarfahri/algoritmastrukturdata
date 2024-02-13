//code ini jika sesuai dengan tabel
import java.util.HashMap;
import java.util.Map;

public class bunga {

    // Data stock bunga
    static Map<String, Map<String, Integer>> stockBunga = new HashMap<>();
    static {
        stockBunga.put("RoyalGarden 1", Map.of("Aglonema", 10, "Keladi", 5, "Alocasia", 15, "Mawar", 7));
        stockBunga.put("RoyalGarden 2", Map.of("Aglonema", 6, "Keladi", 11, "Alocasia", 9, "Mawar", 12));
        stockBunga.put("RoyalGarden 3", Map.of("Aglonema", 2, "Keladi", 10, "Alocasia", 10, "Mawar", 5));
        stockBunga.put("RoyalGarden 4", Map.of("Aglonema", 5, "Keladi", 7, "Alocasia", 12, "Mawar", 9));
    }

    // Harga bunga
    static Map<String, Integer> hargaBunga = Map.of("Aglonema", 75000, "Keladi", 50000, "Alocasia", 60000, "Mawar", 10000);

    // Fungsi untuk menampilkan pendapatan setiap cabang jika semua bunga habis terjual
    static void pendapatanPerCabang() {
        for (Map.Entry<String, Map<String, Integer>> entry : stockBunga.entrySet()) {
            int pendapatan = entry.getValue().entrySet().stream()
                    .mapToInt(e -> e.getValue() * hargaBunga.get(e.getKey()))
                    .sum();
            System.out.println("Pendapatan " + entry.getKey() + ": Rp " + pendapatan);
        }
    }

    // Fungsi untuk mengetahui jumlah stock setiap jenis bunga pada cabang RoyalGarden 4
    static Map<String, Integer> stockPerJenisBunga(String cabang, Map<String, Integer> penguranganStock) {
        Map<String, Integer> stockRoyalGarden4 = new HashMap<>(stockBunga.get(cabang));

        // Mengurangkan stock sesuai dengan informasi tambahan (jika ada)
        if (penguranganStock != null) {
            penguranganStock.forEach((jenis, pengurangan) ->
                    stockRoyalGarden4.put(jenis, stockRoyalGarden4.get(jenis) - pengurangan));
        }

        return stockRoyalGarden4;
    }

    public static void main(String[] args) {
        // Contoh pemanggilan fungsi
        pendapatanPerCabang();
        
        Map<String, Integer> penguranganStock = new HashMap<>();
        penguranganStock.put("Aglonema", 1);
        penguranganStock.put("Keladi", 2);
        penguranganStock.put("Mawar", 5);

        Map<String, Integer> stockRoyalGarden4 = stockPerJenisBunga("RoyalGarden 4", penguranganStock);
        System.out.println("Stock RoyalGarden 4 setelah pengurangan: " + stockRoyalGarden4);
    }
}


// //code ini ketika kita ingin menginput data sendiri
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;

// public class bunga {

//     static Scanner scanner = new Scanner(System.in);

//     static Map<String, Map<String, Integer>> stockBunga = new HashMap<>();
//     static Map<String, Integer> hargaBunga = Map.of("Aglonema", 75000, "Keladi", 50000, "Alocasia", 60000, "Mawar", 10000);

//     public static void main(String[] args) {
//         // Input stock bunga dari pengguna
//         inputStockBunga();

//         // Contoh pemanggilan fungsi
//         pendapatanPerCabang();

//         Map<String, Integer> penguranganStock = new HashMap<>();
//         penguranganStock.put("Aglonema", 1);
//         penguranganStock.put("Keladi", 2);
//         penguranganStock.put("Mawar", 5);

//         Map<String, Integer> stockRoyalGarden4 = stockPerJenisBunga("RoyalGarden 4", penguranganStock);
//         System.out.println("Stock RoyalGarden 4 setelah pengurangan: " + stockRoyalGarden4);
//     }

//     static void inputStockBunga() {
//         System.out.println("Input stock bunga untuk setiap cabang RoyalGarden:");
//         for (int i = 1; i <= 4; i++) {
//             Map<String, Integer> stock = new HashMap<>();
//             System.out.println("Cabang RoyalGarden " + i + ":");
//             for (String jenis : hargaBunga.keySet()) {
//                 System.out.print("Jumlah stock " + jenis + ": ");
//                 int jumlahStock = scanner.nextInt();
//                 stock.put(jenis, jumlahStock);
//             }
//             stockBunga.put("RoyalGarden " + i, stock);
//         }
//     }

//     static void pendapatanPerCabang() {
//         for (Map.Entry<String, Map<String, Integer>> entry : stockBunga.entrySet()) {
//             int pendapatan = entry.getValue().entrySet().stream()
//                     .mapToInt(e -> e.getValue() * hargaBunga.get(e.getKey()))
//                     .sum();
//             System.out.println("Pendapatan " + entry.getKey() + ": Rp " + pendapatan);
//         }
//     }

//     static Map<String, Integer> stockPerJenisBunga(String cabang, Map<String, Integer> penguranganStock) {
//         Map<String, Integer> stockRoyalGarden4 = new HashMap<>(stockBunga.get(cabang));

//         if (penguranganStock != null) {
//             penguranganStock.forEach((jenis, pengurangan) ->
//                     stockRoyalGarden4.put(jenis, stockRoyalGarden4.get(jenis) - pengurangan));
//         }

//         return stockRoyalGarden4;
//     }
// }
