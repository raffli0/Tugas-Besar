import java.util.ArrayList;
import java.util.Scanner;


public class BookingServis {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);

        ArrayList<String> namaPelanggan = new ArrayList<>();
        ArrayList<String> jenisMotor = new ArrayList<>();
        ArrayList<String> noPolisi = new ArrayList<>();
        ArrayList<String> keluhan = new ArrayList<>();
        

        ArrayList<String> namaSparepart = new ArrayList<>();
        ArrayList<String> stokSparepart = new ArrayList<>();
        ArrayList<String> hargaSparepart = new ArrayList<>();
        
        // PROGRAM UTAMA
        while (true) {
            System.out.println("=== BENGKEL UCU ===");
            System.out.println("1. Booking Servis");
            System.out.println("2. Sparepart");
            System.out.println("3. Print Struk");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu (1/2/3/4): ");
            String pilihan = inputan.nextLine();

            // menu pilihan Booking START
            if(pilihan.equals("1")) {
                System.out.println("1. Tambah Daftar Booking");
                System.out.println("2. Lihat Daftar Booking");
                System.out.println("3. Ubah Status Booking");
                System.out.println("4. Keluar");

                System.out.print("Pilih menu (1/2/3): ");
                String opsiBooking = inputan.nextLine();

                // menu pilihan Tambah daftar booking
                if(opsiBooking.equals("1")) {
                    System.out.println("=== Tambah Daftar Servis ===");
                    System.out.print("Nama Pelanggan: ");
                    String namaPelangganInput = inputan.nextLine();
                    System.out.print("Jenis Motor: ");
                    String jenisMotorInput = inputan.nextLine();
                    System.out.print("No Polisi: ");
                    String noPolisiInput = inputan.nextLine();
                    System.out.print("Keluhan: ");
                    String keluhanInput = inputan.nextLine();

                    namaPelanggan.add(namaPelangganInput);
                    jenisMotor.add(jenisMotorInput);
                    noPolisi.add(noPolisiInput);
                    keluhan.add(keluhanInput);

                    // soon looping daftar booking y/t
                    System.out.println("Daftar Booking ditambahkan! ");

                // menu pilihan lihat daftar booking
                }else if(opsiBooking.equals("2")) {
                    System.out.println("=== Daftar Booking ===");
                    for (int i = 0; i < namaPelanggan.size(); i++) {
                        System.out.println("ID: " + i);
                        System.out.println("Nama Pelanggan: " + namaPelanggan.get(i));
                        System.out.println("Jenis Motor: " + jenisMotor.get(i));
                        System.out.println("No Polisi: " + noPolisi.get(i));
                        System.out.println("Keluhan: " + keluhan.get(i));
                        
                        System.out.println("================================");
                    }

                // menu pilihan ubah status booking
                }else if(opsiBooking.equals("3")) {
                    System.out.println("=== Ubah Status Booking ===");
                    System.out.println("Masukan ID Booking yang ingin di ubah statusnya");
                    int id = Integer.parseInt(inputan.nextLine());

                    if(id >= 0 && id < namaPelanggan.size()) {
                        System.out.println("Masukan status baru (Selesai/Belum Selesai)");
                        String statusBaru = inputan.nextLine();
                        System.out.println("Status Booking di ubah! ");
                    }else {
                        System.out.println("ID tidak valid. Daftar Booking tidak ditemukan");

                    }
                }else if(opsiBooking.equals("4")) {
                    System.out.println();
                }
                // MENU PILIHAN BOOKING END
            
            // MENU SPAREPART
            }else if (pilihan.equals("2")) {
                System.out.println("IYE MENU SPAREPART");
            
            // MENU STRUK
            }else if(pilihan.equals("3")) {
                System.out.println("PRINT STRUK EUY");

            // EXIT
            }else {
                System.out.println("EXIT");
            }
            // END
        }
        
    }
}
