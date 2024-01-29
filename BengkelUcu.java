import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BengkelUcu {
    // fungsi psf untuk menjadikan variabel constanta
    private static final int MAX_ANTRIAN = 4; // Number Maksimal Antri

    // Arrays to store booking information
    private static String[] namaPelanggan = new String[MAX_ANTRIAN];
    private static String[] jenisMotor = new String[MAX_ANTRIAN];
    private static String[] noPolisi = new String[MAX_ANTRIAN];
    private static String[] keluhan = new String[MAX_ANTRIAN];
    private static String[] statusAntrian = new String[MAX_ANTRIAN];
    private static double[] totalHargaServis = new double[MAX_ANTRIAN];
    private static String[][][] daftarAntrian = new String[MAX_ANTRIAN][6][2];

    // Queue front dan rear pointers
    private static int front = -1; // depan
    private static int rear = -1; // belakang

    private static Scanner inputan = new Scanner(System.in);

    public static void main(String[] args) {
        // PROGRAM UTAMA
        while (true) {
            System.out.println();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("┌─────────────────────────────────────────────────┐");
            System.out.println("│                   " + String.format("%-22s", "MENU UTAMA") + "        │");
            System.out.println("└─────────────────────────────────────────────────┘");
            System.out.println("1. Antrian");
            System.out.println("2. Transaksi");
            System.out.println("3. Cara Penggunaan");
            System.out.println("4. About Us");
            System.out.println("5. Keluar\n");

            System.out.print("Pilih menu (1/2/3/4/5): ");
            String pilihan = inputan.nextLine();

            // menu pilihan Antrian START
            if (pilihan.equals("1")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("┌─────────────────────────────────────────────────┐");
                System.out.println("│                   " + String.format("%-22s", "MENU ANTRIAN") + "        │");
                System.out.println("└─────────────────────────────────────────────────┘");
                System.out.println("1. Tambah Daftar Antrian");
                System.out.println("2. Lihat Daftar Antrian");
                System.out.println("3. Reset Data Antrian");
                System.out.println("4. Hapus 1 Data Antrian");
                System.out.println("5. Keluar Dari Menu Antrian\n");

                System.out.print("Pilih menu (1/2/3/4): ");
                String opsiAntrian = inputan.nextLine();

                // menu pilihan Tambah daftar antrian
                if (opsiAntrian.equals("1")) {
                    tambahDaftarAntrian();

                    // menu pilihan lihat daftar antrian
                } else if (opsiAntrian.equals("2")) {
                    lihatdaftarAntrian();

                    // menu pilihan reset daftar antrian
                } else if (opsiAntrian.equals("3")) {
                    resetDaftarAntrian();

                } else if (opsiAntrian.equals("4")) {
                    hapusSatuDataAntrian();

                } else if (opsiAntrian.equals("5")) {
                    // Clear screen
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                } else {
                    // kondisi salah input
                    System.out.println("Input tidak valid");
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    inputan.nextLine();
                }
                // MENU PILIHAN ANTRIAN END

                // MENU TRANSAKSI
            } else if (pilihan.equals("2")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("┌─────────────────────────────────────────────────┐");
                System.out.println("│                  " + String.format("%-22s", "MENU TRANSAKSI") + "         │");
                System.out.println("└─────────────────────────────────────────────────┘");
                System.out.println("1. Print Struk");
                System.out.println("2. Keluar Dari Menu Transaksi\n");

                System.out.print("Pilih menu (1/2): ");

                String opsiTransaksi = inputan.nextLine();

                if (opsiTransaksi.equals("1")) {
                    printStruk();
                } else if (opsiTransaksi.equals("2")) {
                    System.out.println();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } else {
                    System.out.println("Input tidak valid");
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    inputan.nextLine();

                }

                // MENU HELP
            } else if (pilihan.equals("3")) {
                System.out.println();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("┌─────────────────────────────────────────────────┐");
                System.out.println("│                 " + String.format("%-22s", "CARA PENGGUNAAN") + "          │");
                System.out.println("└─────────────────────────────────────────────────┘");
                System.out.println("Aplikasi ini adalah sistem antrian dan transaksi untuk bengkel.\n");
                System.out.println("Berikut adalah langkah-langkah penggunaan aplikasi:\n");
                System.out.println("1. Pilih menu 'Antrian' untuk manajemen antrian pelanggan.");
                System.out.println("   1. Tambah Daftar Antrian: Tambahkan pelanggan ke dalam antrian.");
                System.out.println("   2. Lihat Daftar Antrian: Lihat daftar pelanggan yang sedang dalam antrian.");
                System.out.println("   3. Reset Data Antrian: Hapus semua data antrian dan mulai dari awal.");
                System.out.println("   4. Hapus 1 Data Antrian: Hapus 1 data antrian yang pertama masuk.");
                System.out.println("   5. Keluar Dari Menu: Kembali ke menu utama.\n");

                System.out.println("2. Pilih menu 'Transaksi' untuk melakukan transaksi pembayaran.");
                System.out.println("   1. Print Struk: Pilih nomor antrian untuk mencetak struk pembayaran.");
                System.out.println("   2. Keluar Dari Menu: Kembali ke menu utama.\n");

                System.out.println("3. Pilih menu 'Cara Penggunaan' untuk melihat panduan penggunaan aplikasi.\n");

                System.out.println("4. Pilih menu 'About Us' untuk melihat Tentang Kami.\n");

                System.out.println("5. Pilih menu 'Keluar' untuk keluar dari aplikasi.\n");
                System.out.println("   Jika salah menginputkan nomor maka akan muncul pesan input tidak valid");

                // Keluar dari menu cara penggunaan
                System.out.print("Tekan Enter untuk kembali ke menu utama...");
                inputan.nextLine();
                // Clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // MENU ABOUT US
            } else if (pilihan.equals("4")) {
                System.out.println();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("┌─────────────────────────────────────────────────┐");
                System.out.println("│                   " + String.format("%-22s", "ABOUT US") + "        │");
                System.out.println("└─────────────────────────────────────────────────┘");
                System.out.println("Developer : AING");
                System.out.println("Flowchart : IZAL");
                System.out.println("KONSEP : UMAM\n");

                // Keluar dari menu cara penggunaan
                System.out.print("Tekan Enter untuk kembali ke menu utama...");
                inputan.nextLine();
                // Clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // MENU EXIT
            } else if (pilihan.equals("5")) {
                while (true) {
                    System.out.print("Ingin keluar dari apilkasi ? y / n : ");
                    String userInput = inputan.nextLine();

                    if (userInput.equalsIgnoreCase("y")) {
                        System.out.println("Keluar dari aplikasi");
                        System.exit(0);
                    } else if (userInput.equalsIgnoreCase("n")) {
                        break;
                    } else {
                        System.out.println("Input tidak valid");
                    }
                }
            } else {
                // kondisi salah input
                System.out.println("Input tidak valid");
                System.out.print("Tekan Enter untuk melanjutkan...");
                inputan.nextLine();
            }
        }
    }
    // END OF MENU

    private static void tambahDaftarAntrian() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│               " + String.format("%-22s", "TAMBAH DAFTAR ANTRIAN") + "            │");
        System.out.println("└─────────────────────────────────────────────────┘");
        System.out.print("Nama Pelanggan: ");
        String namaPelangganInput = inputan.nextLine();
        System.out.print("Jenis Motor: ");
        String jenisMotorInput = inputan.nextLine();
        System.out.print("No Polisi: ");
        String noPolisiInput = inputan.nextLine();
        System.out.print("Keluhan: ");
        String keluhanInput = inputan.nextLine();

        // Check if the queue is full
        if (rear == MAX_ANTRIAN - 1) {
            System.out.println("Antrian penuh, mohon coba lagi nanti.");
            System.out.print("Tekan Enter untuk melanjutkan...");
            inputan.nextLine();
            return;
        } else {
            int id = rear + 1;
            System.out.println("Nomor antrian anda: " + id + "\ndaftar antrian ditambahkan!");
        }

        // Waktu antrian customer ketika menambahkan antrian
        LocalDateTime waktuMasukAntrian = LocalDateTime.now();

        // Estimasi waktu selesai set 30min servis
        LocalDateTime waktuEstimasiSelesai = waktuMasukAntrian.plusMinutes(30);

        // Format waktu masuk dan waktu selesai
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Update the estimated completion time for the next customers
        for (int i = rear; i >= 0; i--) {
            // Get the latest estimated completion time
            LocalDateTime waktuSelesai = waktuEstimasiSelesai;
            // Add 30 minutes to the latest estimated completion time
            waktuEstimasiSelesai = waktuSelesai.plusMinutes(30);
        }

        // Format the estimated completion time
        String formatWaktuSelesaiBerikutnya = waktuEstimasiSelesai.format(formatter);
        System.out.println("Estimasi waktu selesai berikutnya: " + formatWaktuSelesaiBerikutnya);
        System.out.print("Tekan Enter untuk melanjutkan...");
        inputan.nextLine();

        if (front == -1) {
            front = 0;
        }
        rear++;

        // Simpan data ke dalam array 1 dimensi
        namaPelanggan[rear] = namaPelangganInput;
        jenisMotor[rear] = jenisMotorInput;
        noPolisi[rear] = noPolisiInput;
        keluhan[rear] = keluhanInput;
        statusAntrian[rear] = "Proses";
        totalHargaServis[rear] = 0;

        // Simpan data ke dalam array multi dimensi
        daftarAntrian[rear][0][0] = "Nama Pelanggan";
        daftarAntrian[rear][0][1] = namaPelangganInput;
        daftarAntrian[rear][1][0] = "Jenis Motor";
        daftarAntrian[rear][1][1] = jenisMotorInput;
        daftarAntrian[rear][2][0] = "No Polisi";
        daftarAntrian[rear][2][1] = noPolisiInput;
        daftarAntrian[rear][3][0] = "Keluhan";
        daftarAntrian[rear][3][1] = keluhanInput;
        daftarAntrian[rear][4][0] = "Status";
        daftarAntrian[rear][4][1] = "Proses";
        daftarAntrian[rear][5][0] = "Total Harga Servis";
        daftarAntrian[rear][5][1] = "0"; // Inisialisasi totalHargaServis for this queue
    }

    private static void lihatdaftarAntrian() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│                 " + String.format("%-22s", "DAFTAR ANTRIAN") + "          │");
        System.out.println("└─────────────────────────────────────────────────┘");
        if (front == -1) {
            System.out.println("Daftar antrian kosong.\n");
            // Keluar dari menu
            System.out.print("Tekan Enter untuk kembali ke menu utama...");
            inputan.nextLine();
            return;
        }

        // Unicode table header
        System.out.println(
                "┌─────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┬───────────────────┐");
        System.out.printf("│ %-4s│ %-17s│ %-17s│ %-17s│ %-17s│ %-17s│ %-17s│%n", "ID", "Nama Pelanggan", "Jenis Motor",
                "No Polisi", "Keluhan", "Status Antrian", "Total Harga Servis");
        System.out.println(
                "├─────┼──────────────────┼──────────────────┼──────────────────┼──────────────────┼──────────────────┼───────────────────┤");
        for (int i = front; i <= rear; i++) {
            System.out.printf("│ %-4d│ %-17s│ %-17s│ %-17s│ %-17s│ %-17s│ %-18s│%n",
                    i,
                    namaPelanggan[i],
                    jenisMotor[i],
                    noPolisi[i],
                    keluhan[i],
                    statusAntrian[i],
                    "Rp. " + daftarAntrian[i][5][1]);
        }
        // Unicode table footer
        System.out.println(
                "└─────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴───────────────────┘");
        // Daftar antrian end

        // Keluar dari menu
        System.out.print("Tekan Enter untuk kembali ke menu utama...");
        inputan.nextLine();
    }

    private static void resetDaftarAntrian() { // fitur ini bisa diganti saat antrian selesai transaksi maka antrian //
                                               // dihapus
        // mengubah depan dan belakang menjadi ke nilai awal
        front = -1;
        rear = -1;

        // menghapus array
        namaPelanggan = new String[MAX_ANTRIAN];
        jenisMotor = new String[MAX_ANTRIAN];
        noPolisi = new String[MAX_ANTRIAN];
        keluhan = new String[MAX_ANTRIAN];
        statusAntrian = new String[MAX_ANTRIAN];
        totalHargaServis = new double[MAX_ANTRIAN];
        daftarAntrian = new String[MAX_ANTRIAN][6][2];

        System.out.println("\nData Antrian berhasil di reset");
        System.out.print("Tekan Enter untuk melanjutkan...");
        inputan.nextLine();
    }

    // Fungsi untuk menghapus satu data antrian (FIFO)
    private static void hapusSatuDataAntrian() {
        // Cek apakah antrian kosong
        if (front == -1) {
            System.out.println("Antrian kosong, tidak ada data yang dihapus.");
            System.out.print("Tekan Enter untuk melanjutkan...");
            inputan.nextLine();
            return;
        }

        // Ambil data dari antrian
        String namaPelangganHapus = namaPelanggan[front];
        String jenisMotorHapus = jenisMotor[front];
        String noPolisiHapus = noPolisi[front];
        String keluhanHapus = keluhan[front];

        // Tampilkan data yang akan dihapus
        System.out.println("Data Antrian yang dihapus:");
        System.out.println("Nama Pelanggan: " + namaPelangganHapus);
        System.out.println("Jenis Motor: " + jenisMotorHapus);
        System.out.println("No Polisi: " + noPolisiHapus);
        System.out.println("Keluhan: " + keluhanHapus);

        // Geser data antrian ke depan
        for (int i = front; i < rear; i++) {
            namaPelanggan[i] = namaPelanggan[i + 1];
            jenisMotor[i] = jenisMotor[i + 1];
            noPolisi[i] = noPolisi[i + 1];
            keluhan[i] = keluhan[i + 1];
        }

        // Kurangi nilai rear
        rear--;

        // Jika tidak ada data lagi, reset front dan rear
        if (rear == -1) {
            front = -1;
        }

        System.out.println("Data Antrian berhasil dihapus.");
        System.out.print("Tekan Enter untuk melanjutkan...");
        inputan.nextLine();
    }

    public static String formatTitik(double number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

    private static void printStruk() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│                  " + String.format("%-22s", "PRINT STRUK") + "         │");
        System.out.println("└─────────────────────────────────────────────────┘");
        // menampilkan daftar antrian mulai
        if (front == -1) {
            System.out.println("Daftar antrian kosong.\n");
            // Keluar dari menu
            System.out.print("Tekan Enter untuk kembali ke menu utama...");
            inputan.nextLine();
            return;
        }

        // Unicode table header
        System.out.println(
                "┌─────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┬───────────────────┐");
        System.out.printf("│ %-4s│ %-17s│ %-17s│ %-17s│ %-17s│ %-17s│ %-17s│%n", "ID", "Nama Pelanggan", "Jenis Motor",
                "No Polisi", "Keluhan", "Status Antrian", "Total Harga Servis");
        System.out.println(
                "├─────┼──────────────────┼──────────────────┼──────────────────┼──────────────────┼──────────────────┼───────────────────┤");
        for (int i = front; i <= rear; i++) {
            System.out.printf("│ %-4d│ %-17s│ %-17s│ %-17s│ %-17s│ %-17s│ %-18s│%n",
                    i,
                    namaPelanggan[i],
                    jenisMotor[i],
                    noPolisi[i],
                    keluhan[i],
                    statusAntrian[i],
                    "Rp. " + daftarAntrian[i][5][1]);
        }
        // Unicode table footer
        System.out.println(
                "└─────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴───────────────────┘");
        // Daftar antrian end

        // KODE PRINT STRUK MULAI
        System.out.print("Masukkan nomor antrian(ID) untuk print struk: ");
        int nomorAntrian = Integer.parseInt(inputan.nextLine());

        if (nomorAntrian >= front && nomorAntrian <= rear) {
            // Status antrian "selesai" otomatis

            // System.out.print("Masukkan harga servis: ");
            // double totalHargaServisInput = Double.parseDouble(inputan.nextLine());
            // daftarAntrian[nomorAntrian][5][1] = String.valueOf(totalHargaServisInput);
            
            double totalHargaServisInput = 0;
            double totalHargaSparepartInput = 0;
            double tunai = 0;
            boolean validInput = false;
            do {
                try {
                    System.out.print("Masukkan harga servis: ");
                    totalHargaServisInput = Double.parseDouble(inputan.nextLine());
                    System.out.print("Masukkan harga sparepart: ");
                    totalHargaSparepartInput = Double.parseDouble(inputan.nextLine());
                    System.out.print("Tunai        : Rp. ");
                    tunai = Double.parseDouble(inputan.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Inputan tidak valid. Silakan masukkan angka.");
                }
            } while (!validInput);

            // Update totalHargaServis di daftarAntrian array
            daftarAntrian[nomorAntrian][5][1] = String.valueOf(totalHargaServisInput);

            // Hitung total pembayaran
            double totalPembayaran = totalHargaServisInput + totalHargaSparepartInput;
            
            // Update totalPembayaran di daftarAntrian array
            daftarAntrian[nomorAntrian][5][1] = String.valueOf(totalPembayaran);

            // Ambil tanggal dan waktu sekarang
            LocalDateTime now = LocalDateTime.now();

            // Format tanggal dan waktu
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm ");
            String formatTanggal = now.format(formatter);

            // Update status antrian ke "Selesai"
            statusAntrian[nomorAntrian] = "Selesai";

            System.out.print("\033[H\033[2J");
            System.out.flush();
            // Print struk
            System.out.println("┌─────────────────────────────────────────────────┐");
            System.out.println("│\t\t STRUK PEMBAYARAN                 │");
            System.out.println("│                                                 │");
            System.out.println("└─────────────────────────────────────────────────┘");
            System.out.println("───────────────────────────────────────────────────");
            System.out.println("Tgl.\t" + formatTanggal + " \t");
            System.out.println("───────────────────────────────────────────────────");
            System.out.printf("%-20s%-20s\n", "Nama Pelanggan:                       ",daftarAntrian[nomorAntrian][0][1]);
            System.out.printf("%-20s%-20s\n", "Jenis Motor:                          ",daftarAntrian[nomorAntrian][1][1]);
            System.out.printf("%-20s%-20s\n", "No Polisi:                            ",daftarAntrian[nomorAntrian][2][1]);
            System.out.printf("%-20s%-20s\n", "Keluhan:                              ",daftarAntrian[nomorAntrian][3][1]);
            System.out.printf("%-20s%-20s\n", "Status Antrian:                       ",daftarAntrian[nomorAntrian][4][1]);
            System.out.printf("%-20s%-20s\n", "Harga Servis:                         ","Rp. " + formatTitik(totalHargaServisInput));
            System.out.printf("%-20s%-20s\n", "Harga Sparepart:                      ","Rp. " + formatTitik(totalHargaSparepartInput));
            System.out.println("───────────────────────────────────────────────────");
            System.out.printf("%-20s%-20s\n", "Total:                            ","Rp. " + formatTitik(totalPembayaran));

            // untuk format titik
            String tunaiFormatted = formatTitik(tunai);
            System.out.println("Tunai           = Rp. " + tunaiFormatted);

            // cek apakah tunai cukup
            if (tunai < totalHargaServisInput + totalHargaSparepartInput) {
                System.out.println("Maaf, pembayaran kurang. Transaksi tidak dilanjutkan.\n\n");
                System.out.println("Tekan Enter untuk melanjutkan...");
                inputan.nextLine();
                printStruk();
            } else {
                // System.out.println("───────────────────────────────────────────────────");
                double kembalian = tunai - totalPembayaran;
                System.out.printf("%-20s%-20s\n", "Kembalian:", "Rp. " + formatTitik(kembalian));
                System.out.println("───────────────────────────────────────────────────");
                System.out.println("\t\t    Terima Kasih");
                System.out.println("───────────────────────────────────────────────────");
                System.out.println("\t\t     Nama Admin");
                System.out.println("───────────────────────────────────────────────────");

                // // Hapus antrian dari array
                // for (int i = nomorAntrian; i < rear; i++) {
                // namaPelanggan[i] = namaPelanggan[i + 1];
                // jenisMotor[i] = jenisMotor[i + 1];
                // noPolisi[i] = noPolisi[i + 1];
                // keluhan[i] = keluhan[i + 1];
                // statusAntrian[i] = statusAntrian[i + 1];
                // totalHargaServis[i] = totalHargaServis[i + 1];
                // }

                // // Reset rear
                // // rear--;
                // // Tampilkan pesan sukses
                // System.out.println("Antrian berhasil diselesaikan dan dihapus.");
            }
        } else {
            System.out.println("Nomor antrian tidak valid. Silakan coba lagi.");
            System.out.print("Tekan Enter untuk melanjutkan...");
            inputan.nextLine();
            printStruk();
        }
        System.out.println("Transaksi berhasil...");
        System.out.print("Tekan Enter untuk melanjutkan");
        inputan.nextLine();
        printStruk();

    }

}
