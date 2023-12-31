package BengkelUcu;

import java.util.Scanner;

public class BengkelUcu {
    private static final int MAX_ANTRIAN = 5; // Number Maksimal Antri

    // Arrays to store booking information
    private static String[] namaPelanggan = new String[MAX_ANTRIAN];
    private static String[] jenisMotor = new String[MAX_ANTRIAN];
    private static String[] noPolisi = new String[MAX_ANTRIAN];
    private static String[] keluhan = new String[MAX_ANTRIAN];
    private static String[] statusAntrian = new String[MAX_ANTRIAN];
    private static double[] totalHargaServis = new double[MAX_ANTRIAN];
    private static String[][][]daftarAntrian = new String[MAX_ANTRIAN][6][2];

    // Queue front dan rear pointers
    private static int front = -1;
    private static int rear = -1;

    private static Scanner inputan = new Scanner(System.in);

    public static void main(String[] args) {
        // PROGRAM UTAMA
        while (true) {
            System.out.println("=== BENGKEL UCU ===");
            System.out.println("1. Antrian");
            System.out.println("2. Transaksi");
            System.out.println("3. Cara Penggunaan");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu (1/2/3/4): ");
            String pilihan = inputan.nextLine();

            // menu pilihan Antrian START
            if (pilihan.equals("1")) {
                System.out.println("1. Tambah Daftar Antrian");
                System.out.println("2. Lihat Daftar Antrian");
                System.out.println("3. Ubah Status Antrian");
                System.out.println("4. Reset Data Antrian");
                System.out.println("5. Keluar Dari Menu");

                System.out.print("Pilih menu (1/2/3/4/5): ");
                String opsiAntrian = inputan.nextLine();

                // menu pilihan Tambah daftar antrian
                if (opsiAntrian.equals("1")) {
                    tambahDaftarAntrian();
                    System.out.println("Daftar Antrian ditambahkan! ");

                    // menu pilihan lihat daftar antrian
                } else if (opsiAntrian.equals("2")) {
                    lihatdaftarAntrian();

                    // menu pilihan ubah status antrian
                } else if (opsiAntrian.equals("3")) {
                    // ubahStatusAntrian();

                } else if (opsiAntrian.equals("4")) {
                    System.out.println("Reset Antrian");

                } else if (opsiAntrian.equals("5"))
                    System.out.println();
                // MENU PILIHAN ANTRIAN END

                // MENU TRANSAKSI
            } else if (pilihan.equals("2")) {
                System.out.println("1. Print Struk");
                System.out.println("2. Keluar Dari Menu");
                System.out.println("Pilih menu (1/2)");

                String opsiTransaksi = inputan.nextLine();

                if (opsiTransaksi.equals("1")) {
                    printStruk();
                }

                // MENU STRUK
            } else if (pilihan.equals("3")) {
                System.out.println("Cara Penggunaan");

                // EXIT

            } else if (pilihan.equals("4")) {
                while (true) {
                    System.out.print("Ingin keluar dari apilkasi ? y / n");
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
                System.out.println("Salah input ngab");
            }

        }
    }

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

        // Check if the queue is full
        if (rear == MAX_ANTRIAN - 1) {
            System.out.println("Antrian penuh, mohon coba lagi nanti.");
            return;
        }

        // Enqueue the booking information
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
        daftarAntrian[rear][5][1] = "0"; // Initialize totalHargaServis for this queue
    }

    private static void lihatdaftarAntrian() {
        System.out.println("=== Daftar Antrian ===");
        if (front == -1) {
            System.out.println("Daftar antrian kosong.");
            return;
        }
    
        // Unicode table header
        System.out.println("┌─────┬─────────────────────┬───────────────┬──────────┬───────────────┬──────────────────────┬──────────────────┐");
        System.out.printf("│ %-4s│ %-19s│ %-12s│ %-7s│ %-12s| %-19s│ %-15s│%n", "ID", "Nama Pelanggan", "Jenis Motor", "No Polisi", "Keluhan", "Status Antrian", "Total Harga Servis");
        System.out.println("├─────┼─────────────────────┼───────────────┼──────────┼───────────────┼──────────────────────┼──────────────────┤");
        for (int i = front; i <= rear; i++) {
            System.out.printf("│ %-4d│ %-19s│ %-12s│ %-7s│ %-12s│ %-19s│ %-15s│%n",
                    i,
                    namaPelanggan[i],
                    jenisMotor[i],
                    noPolisi[i],
                    keluhan[i],
                    statusAntrian[i],
                    "Rp. " + totalHargaServis[i]);
        }
        // Unicode table footer
        System.out.println("└─────┴────────────────────┴────────────────┴──────────┴───────────────┴──────────────────────┴──────────────────┘");
    }
    
    
    // private static void ubahStatusAntrian() {
    // System.out.println("=== Ubah Status Antrian ===");
    // System.out.println("Masukan ID Antrian yang ingin di ubah statusnya");
    // int id = Integer.parseInt(inputan.nextLine());

    // if (id >= front && id <= rear) {
    // System.out.println("Masukan status baru (Selesai/Belum Selesai )");
    // String statusBaru = inputan.nextLine();
    // statusBooking[id] = statusBaru;
    // System.out.println("Status Booking di ubah! ");
    // } else {
    // System.out.println("ID tidak valid. Daftar Booking tidak ditemukan");
    // }
    // }

    private static void printStruk() {
        lihatdaftarAntrian();
    
        System.out.print("Masukkan nomor antrian untuk print struk: ");
        int nomorAntrian = Integer.parseInt(inputan.nextLine());
    
        if (nomorAntrian >= front && nomorAntrian <= rear) {
            System.out.print("Masukkan status antrian (Selesai/Belum Selesai): ");
            String statusInput = inputan.nextLine();
            daftarAntrian[nomorAntrian][4][1] = statusInput;
    
            System.out.print("Masukkan harga servis: ");
            double totalHargaServisInput = Double.parseDouble(inputan.nextLine());
            daftarAntrian[nomorAntrian][5][1] = String.valueOf(totalHargaServisInput);
    
            // Assume total harga sparepart is entered by the user, modify as needed
            System.out.print("Masukkan harga sparepart: ");
            double totalHargaSparepartInput = Double.parseDouble(inputan.nextLine());
    

            double totalPembayaran = totalHargaServisInput + totalHargaSparepartInput;
    
            System.out.println("=========================================");
            System.out.println("\t\t STRUK PEMBAYARAN");
            System.out.println("=========================================");
            System.out.printf("%-20s%-20s\n", "Nama Pelanggan:", daftarAntrian[nomorAntrian][0][1]);
            System.out.printf("%-20s%-20s\n", "Jenis Motor:", daftarAntrian[nomorAntrian][1][1]);
            System.out.printf("%-20s%-20s\n", "No Polisi:", daftarAntrian[nomorAntrian][2][1]);
            System.out.printf("%-20s%-20s\n", "Keluhan:", daftarAntrian[nomorAntrian][3][1]);
            System.out.printf("%-20s%-20s\n", "Status Antrian:", daftarAntrian[nomorAntrian][4][1]);
            System.out.printf("%-20s%-20s\n", "Total Harga Servis:", "Rp. " + totalHargaServisInput);
            System.out.printf("%-20s%-20s\n", "Total Harga Sparepart:", "Rp. " + totalHargaSparepartInput);
            System.out.println("=========================================");
    
            System.out.print("Tunai        = Rp. ");
            double tunai = Double.parseDouble(inputan.nextLine());
    
            System.out.println("=========================================");
            double kembalian = tunai - totalPembayaran;
            System.out.printf("%-20s%-20s\n", "Kembalian:", "Rp. " + kembalian);
            System.out.println("=========================================");
            System.out.println("Tgl. 01-01-2024     23:11:59        V.0.1");
            System.out.println("-----------------------------------------");
            System.out.println("\t\t Terima Kasih");
            System.out.println("-----------------------------------------");
            System.out.println("\t\t Nama Admin\n\n\n");
        } else {
            System.out.println("Nomor antrian tidak valid. Silakan coba lagi.");
        }
    }
    

    // private static double hitungTotalHargaSparepart() {
    //     // Implement sparepart logic here
    //     // For simplicity, return a fixed value for now
    //     return 50000; // Example value
    // }
}
