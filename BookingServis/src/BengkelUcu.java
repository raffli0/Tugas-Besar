package BengkelUcu;

import java.util.Scanner;

public class BengkelUcu {
    private static final int MAX_ANTRIAN = 5; // Number Maksimal Booking

    // Arrays to store booking information
    private static String[] namaPelanggan = new String[MAX_ANTRIAN];
    private static String[] jenisMotor = new String[MAX_ANTRIAN];
    private static String[] noPolisi = new String[MAX_ANTRIAN];
    private static String[] keluhan = new String[MAX_ANTRIAN];
    private static String[] statusAntrian = new String[MAX_ANTRIAN];
    private static double[] totalHargaServis = new double[MAX_ANTRIAN];
    private static String[][][] daftarAntrian = new String[MAX_ANTRIAN][6][2];
    
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

            // menu pilihan Booking START
            if (pilihan.equals("1")) {
                System.out.println("1. Tambah Daftar Antrian");
                System.out.println("2. Lihat Daftar Antrian");
                System.out.println("3. Ubah Status Antrian");
                System.out.println("4. Reset Data Antrian");
                System.out.println("5. Keluar");

                System.out.print("Pilih menu (1/2/3/4/5): ");
                String opsiBooking = inputan.nextLine();

                // menu pilihan Tambah daftar booking
                if (opsiBooking.equals("1")) {
                    tambahDaftarAntrian();
                    System.out.println("Daftar Antrian ditambahkan! ");

                // menu pilihan lihat daftar booking
                } else if (opsiBooking.equals("2")) {
                    lihatdaftarAntrian();

                // menu pilihan ubah status booking
                } else if (opsiBooking.equals("3")) {
                    // ubahStatusBooking();

                } else if (opsiBooking.equals("4")) {
                    System.out.println("Reset Antrian");
                } else if (opsiBooking.equals("5"))
                    System.out.println();
                // MENU PILIHAN BOOKING END

            // MENU TRANSAKSI
            } else if (pilihan.equals("2")) {
                System.out.println("1. Print Struk");

                System.out.println("Pilih menu (1/2)");

                String opsiTransaksi = inputan.nextLine();

                if(opsiTransaksi.equals("1")) {
                    printStruk();
                }

            // MENU STRUK
            } else if (pilihan.equals("3")) {
                System.out.println("Cara Penggunaan");
            // EXIT
            } else {
                System.out.println("EXIT");
                break; // Exit the loop and end the program
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
        noPolisi[rear] = jenisMotorInput;
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
        daftarAntrian[rear][4][1] = "Belum Selesai";
        daftarAntrian[rear][5][0] = "Total Harga Servis";
        daftarAntrian[rear][5][1] = "0"; // Initialize totalHargaServis for this booking
    }

    private static void lihatdaftarAntrian() {
        System.out.println("=== Daftar Antrian ===");
        if (front == -1) {
            System.out.println("Daftar antrian kosong.");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println("ID: " + i);
            System.out.println("Nama Pelanggan: " + namaPelanggan[i]);
            System.out.println("Jenis Motor: " + jenisMotor[i]);
            System.out.println("No Polisi: " + noPolisi[i]);
            System.out.println("Keluhan: " + keluhan[i]);
            System.out.println("Status Booking: " + statusAntrian[i]);
            System.out.println("Total Harga Servis: Rp. " + totalHargaServis[i]);
            System.out.println("================================");
        }
    }

    // private static void ubahStatusBooking() {
    //     System.out.println("=== Ubah Status Antrian ===");
    //     System.out.println("Masukan ID Antrian yang ingin di ubah statusnya");
    //     int id = Integer.parseInt(inputan.nextLine());

    //     if (id >= front && id <= rear) {
    //         System.out.println("Masukan status baru (Selesai/Belum Selesai)");
    //         String statusBaru = inputan.nextLine();
    //         statusBooking[id] = statusBaru;
    //         System.out.println("Status Booking di ubah! ");
    //     } else {
    //         System.out.println("ID tidak valid. Daftar Booking tidak ditemukan");
    //     }
    // }

    private static void printStruk() {
        lihatdaftarAntrian();

        System.out.print("Masukkan nomor antrian untuk print struk: ");
        int nomorAntrian = Integer.parseInt(inputan.nextLine());

        if (nomorAntrian >= front && nomorAntrian <= rear) {
            double totalHargaServisBooking = totalHargaServis[nomorAntrian];
            double totalHargaSparepart = hitungTotalHargaSparepart();


            System.out.println("=========================================");
            System.out.println("\t\t STRUK PEMBAYARAN");
            System.out.println("=========================================");
            System.out.printf("%-20s%-20s\n", "Nama Pelanggan:", daftarAntrian[nomorAntrian][0][1]);
            System.out.printf("%-20s%-20s\n", "Jenis Motor:", daftarAntrian[nomorAntrian][1][1]);
            System.out.printf("%-20s%-20s\n", "No Polisi:", daftarAntrian[nomorAntrian][2][1]);
            System.out.printf("%-20s%-20s\n", "Keluhan:", daftarAntrian[nomorAntrian][3][1]);
            System.out.printf("%-20s%-20s\n", "Status Booking:", daftarAntrian[nomorAntrian][4][1]);
            System.out.printf("%-20s%-20s\n", "Total Harga Servis:", "Rp. " + totalHargaServisBooking);
            System.out.printf("%-20s%-20s\n", "Total Harga Sparepart:", "Rp. " + totalHargaSparepart);
            System.out.println("=========================================");
            double totalPembayaran = totalHargaServisBooking + totalHargaSparepart;
            System.out.printf("%-20s%-20s\n", "Total Pembayaran Sebelum Potongan:", "Rp. " + totalPembayaran);

            // Apply potongan based on totalPembayaran
            double potongan = (totalPembayaran >= 200000) ? 100000 : 0;
            System.out.printf("%-20s%-20s\n", "Besarnya Potongan:", "Rp. " + potongan);

            // Calculate jumByr after applying potongan
            double jumByr = totalPembayaran - potongan;
            System.out.printf("%-20s%-20s\n", "Total Pembayaran Setelah Potongan:", "Rp. " + jumByr);

            System.out.print("Tunai        = Rp. ");
            int tunai = Integer.parseInt(inputan.nextLine());
            System.out.println("=========================================");
            double kembalian = tunai - jumByr;
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

    private static double hitungTotalHargaSparepart() {
        // Implement sparepart logic here
        // For simplicity, return a fixed value for now
        return 50000; // Example value
    }
}



