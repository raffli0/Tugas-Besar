import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BengkelUcu {
    // fungsi psf untuk menjadikan variabel constanta
    private static final int MAX_ANTRIAN = 5; // Number Maksimal Antri

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
            System.out.println("│                   " + String.format("%-22s", "MAIN MENU") + "        │");
            System.out.println("└─────────────────────────────────────────────────┘");
            System.out.println("1. Antrian");
            System.out.println("2. Transaksi");
            System.out.println("3. Cara Penggunaan");
            System.out.println("4. About Us");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1/2/3/4/5): ");
            String pilihan = inputan.nextLine();

            // menu pilihan Antrian START
            if (pilihan.equals("1")) {
                System.out.println();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("1. Tambah Daftar Antrian");
                System.out.println("2. Lihat Daftar Antrian");
                System.out.println("3. Reset Data Antrian");
                System.out.println("4. Keluar Dari Menu");

                System.out.print("Pilih menu (1/2/3/4): ");
                String opsiAntrian = inputan.nextLine();

                // menu pilihan Tambah daftar antrian
                if (opsiAntrian.equals("1")) {
                    tambahDaftarAntrian();
                    System.out.println("Daftar Antrian ditambahkan! ");

                    // menu pilihan lihat daftar antrian
                } else if (opsiAntrian.equals("2")) {
                    lihatdaftarAntrian();

                    // menu pilihan reset daftar antrian
                } else if (opsiAntrian.equals("3")) {
                    resetDaftarAntrian();

                } else if (opsiAntrian.equals("4"))
                    // Clear screen
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                // MENU PILIHAN ANTRIAN END

                // MENU TRANSAKSI
            } else if (pilihan.equals("2")) {
                System.out.println();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("┌─────────────────────────────────────────────────┐");
                System.out.println("│                   " + String.format("%-22s", "TRANSAKSI") + "        │");
                System.out.println("└─────────────────────────────────────────────────┘");
                System.out.println("1. Print Struk");
                System.out.println("2. Keluar Dari Menu");

                System.out.print("Pilih menu (1/2): ");

                String opsiTransaksi = inputan.nextLine();

                if (opsiTransaksi.equals("1")) {
                    printStruk();
                } else if (opsiTransaksi.equals("2")) {
                    System.out.println();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
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
                System.out.println("   1. Tambah Daftar Antrian: Tambahkan pelanggan ke dalam antrian."); // tambahkan sedetail mungkin
                System.out.println("   2. Lihat Daftar Antrian: Lihat daftar pelanggan yang sedang dalam antrian.");
                System.out.println("   3. Reset Data Antrian: Hapus semua data antrian dan mulai dari awal.");
                System.out.println("   4. Keluar Dari Menu: Kembali ke menu utama.\n");
                
                System.out.println("2. Pilih menu 'Transaksi' untuk melakukan transaksi pembayaran.");
                System.out.println("   1. Print Struk: Pilih nomor antrian untuk mencetak struk pembayaran.\n");
                System.out.println("   2. Keluar Dari Menu: Kembali ke menu utama.\n");

                System.out.println("3. Pilih menu 'Cara Penggunaan' untuk melihat panduan penggunaan aplikasi.\n");

                System.out.println("4. Pilih menu 'About Us' untuk melihat Tentang Kami.\n");

                System.out.println("5. Pilih menu 'Keluar' untuk keluar dari aplikasi.\n");

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
                System.out.println("Input tidak valid");
            }
        }
    }
    // END OF MENU

    private static void tambahDaftarAntrian() {
        System.out.println("=== Tambah Daftar Antrian ===");
        System.out.print("Nama Pelanggan: ");
        String namaPelangganInput = inputan.nextLine();
        System.out.print("Jenis Motor: ");
        String jenisMotorInput = inputan.nextLine();
        System.out.print("No Polisi: ");
        String noPolisiInput = inputan.nextLine();
        System.out.print("Keluhan: ");
        String keluhanInput = inputan.nextLine();

        // Check jika antrian full
        if (rear == MAX_ANTRIAN - 1) {
            System.out.println("Antrian penuh, mohon coba lagi nanti.");
            return;
        }

        // Enqueue antrian (menambahkan)
        if (front == -1) {
            front = 0;
        }
        rear++;

        // simpan data ke dalam array 1 dimensi
        namaPelanggan[rear] = namaPelangganInput;
        jenisMotor[rear] = jenisMotorInput;
        noPolisi[rear] = noPolisiInput;
        keluhan[rear] = keluhanInput;
        statusAntrian[rear] = "Proses";
        totalHargaServis[rear] = 0;

        // simpan data ke dalam array multi dimensi
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
        daftarAntrian[rear][5][1] = "0"; // inisialisasi totalHargaServis for this queue
    }

    private static void lihatdaftarAntrian() {
        System.out.println("=== Daftar Antrian ===");
        if (front == -1) {
            System.out.println("Daftar antrian kosong.");
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
                    "Rp. " + totalHargaServis[i]);
        }
        // Unicode table footer
        System.out.println(
                "└─────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴───────────────────┘");
        // Daftar antrian end

        // Keluar dari menu
        System.out.print("Tekan Enter untuk kembali ke menu utama...");
        inputan.nextLine();
    }

    // private static void ubahStatusAntrian() {
    // System.out.println("=== Ubah Status Antrian ===");
    // System.out.println("Masukan ID Antrian yang ingin di ubah statusnya");
    // int id = Integer.parseInt(inputan.nextLine());

    // if (id >= front && id <= rear) {
    // System.out.println("Masukan status baru (Selesai/Belum Selesai )");
    // String statusBaru = inputan.nextLine();
    // statusAntrian[id] = statusBaru;
    // System.out.println("Status Booking di ubah! ");
    // } else {
    // System.out.println("ID tidak valid. Daftar Booking tidak ditemukan");
    // }
    // }

    private static void resetDaftarAntrian() {
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

        System.out.println("Data Antrian berhasil di reset");
    }

    private static void printStruk() {
        // menampilkan daftar antrian mulai
        System.out.println("=== Daftar Antrian ===");
        if (front == -1) {
            System.out.println("Daftar antrian kosong.");
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
                    "Rp. " + totalHargaServis[i]);
        }
        // Unicode table footer
        System.out.println(
                "└─────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴───────────────────┘");
        // Daftar antrian end

        // KODE PRINT STRUK MULAI
        System.out.print("Masukkan nomor antrian untuk print struk: ");
        int nomorAntrian = Integer.parseInt(inputan.nextLine());

        if (nomorAntrian >= front && nomorAntrian <= rear) {
            // System.out.print("Masukkan status antrian (Selesai/Belum Selesai): ");
            // String statusInput = inputan.nextLine();
            // daftarAntrian[nomorAntrian][4][1] = statusInput;

            System.out.print("Masukkan harga servis: ");
            double totalHargaServisInput = Double.parseDouble(inputan.nextLine());
            daftarAntrian[nomorAntrian][5][1] = String.valueOf(totalHargaServisInput);

            // Assume total harga sparepart is entered by the user, modify as needed
            System.out.print("Masukkan harga sparepart: ");
            double totalHargaSparepartInput = Double.parseDouble(inputan.nextLine());

            double totalPembayaran = totalHargaServisInput + totalHargaSparepartInput;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatTanggalWaktu = now.format(formatter);

            System.out.println("┌─────────────────────────────────────────────────┐");
            System.out.println("│\t\t STRUK PEMBAYARAN                 │");
            System.out.println("│                                                 │");
            System.out.println("└─────────────────────────────────────────────────┘");
            System.out.printf("%-20s%-20s\n", "Nama Pelanggan:", daftarAntrian[nomorAntrian][0][1]);
            System.out.printf("%-20s%-20s\n", "Jenis Motor:", daftarAntrian[nomorAntrian][1][1]);
            System.out.printf("%-20s%-20s\n", "No Polisi:", daftarAntrian[nomorAntrian][2][1]);
            System.out.printf("%-20s%-20s\n", "Keluhan:", daftarAntrian[nomorAntrian][3][1]);
            System.out.printf("%-20s%-20s\n", "Status Antrian:", daftarAntrian[nomorAntrian][4][1]);
            System.out.printf("%-20s%-20s\n", "Total Harga Servis:", "Rp. " + totalHargaServisInput);
            System.out.printf("%-20s%-20s\n", "Total Harga Sparepart:", "Rp. " + totalHargaSparepartInput);
            System.out.println("─────────────────────────────────────────────────");

            System.out.print("Tunai        = Rp. ");
            double tunai = Double.parseDouble(inputan.nextLine());

            if (tunai < totalHargaServisInput + totalHargaSparepartInput) {
                System.out.println("Uang anda kurang mohon coba lagi\n\n");
                printStruk();
            } else {

                System.out.println("─────────────────────────────────────────────────");
                double kembalian = tunai - totalPembayaran;
                System.out.printf("%-20s%-20s\n", "Kembalian:", "Rp. " + kembalian);
                System.out.println("─────────────────────────────────────────────────");
                System.out.println("Tgl.\t" + formatTanggalWaktu + " \t V 0.1");
                System.out.println("─────────────────────────────────────────────────");
                System.out.println("\t\t Terima Kasih");
                System.out.println("─────────────────────────────────────────────────");
                System.out.println("\t\t Nama Admin\n\n\n");
                System.out.println("─────────────────────────────────────────────────");
            }
        } else {
            System.out.println("Nomor antrian tidak valid. Silakan coba lagi.");
        }
        // KODE PRINT STRUK END

        // Keluar dari menu
        System.out.print("Tekan Enter untuk kembali ke menu utama...");
        inputan.nextLine();

        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

}
