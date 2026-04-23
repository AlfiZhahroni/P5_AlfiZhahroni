package Tugas;

import java.util.Scanner;

public class Tugas2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Sistem Penentuan UKT Terpadu ===");
        System.out.print("Pendapatan kotor orang tua per bulan: Rp ");
        double pendapatan = input.nextDouble();

        System.out.print("Jumlah tanggungan keluarga (di luar 2 orang tua): ");
        int tanggungan = input.nextInt();

        double pendapatanPerKapita = pendapatan / (tanggungan + 2);

        int golonganUKT;
        double nominalUKT;

        if (pendapatanPerKapita <= 500000) {
            golonganUKT = 1;
            nominalUKT = 500000;
        } else if (pendapatanPerKapita <= 1000000) {
            golonganUKT = 2;
            nominalUKT = 1000000;
        } else if (pendapatanPerKapita <= 2500000) {
            golonganUKT = 3;
            nominalUKT = 2500000;
        } else if (pendapatanPerKapita <= 5000000) {
            golonganUKT = 4;
            nominalUKT = 4000000;
        } else {
            golonganUKT = 5;
            nominalUKT = 6000000;
        }

        System.out.println("\nJalur Penerimaan Mahasiswa Baru:");
        System.out.println("1. SNBP (Undangan)");
        System.out.println("2. SNBT (Tulis)");
        System.out.println("3. Mandiri (Reguler)");
        System.out.print("Masukkan kode jalur (1-3): ");
        int jalurMasuk = input.nextInt();

        double totalTagihan = 0;
        double biayaPangkal = 0;

        switch (jalurMasuk) {
            case 1:
                System.out.println("Keterangan: Jalur SNBP. Subsidi penuh dari pemerintah.");
                totalTagihan = nominalUKT;
                break;
            case 2:
                System.out.println("Keterangan: Jalur SNBT. Dikenakan tarif UKT standar.");
                totalTagihan = nominalUKT;
                break;
            case 3:
                System.out.println("Keterangan: Jalur Mandiri. Dikenakan Iuran Pengembangan Institusi (IPI).");
                System.out.print("Pilihan Rumpun Ilmu (1: Saintek, 2: Soshum): ");
                int rumpun = input.nextInt();

                if (rumpun == 1) {
                    biayaPangkal = 15000000;
                } else if (rumpun == 2) {
                    biayaPangkal = 10000000;
                } else {
                    System.out.println("Galat: Rumpun ilmu tidak valid. Dikenakan IPI maksimal.");
                    biayaPangkal = 20000000;
                }
                totalTagihan = nominalUKT + biayaPangkal;
                break;
            default:
                System.out.println("Galat: Jalur masuk tidak valid. Penetapan otomatis ke Golongan Tertinggi.");
                golonganUKT = 5;
                nominalUKT = 6000000;
                totalTagihan = nominalUKT;
                break;
        }

        System.out.println("\n--- Rincian Tagihan Akhir ---");
        System.out.printf("Indeks Ekonomi per Kapita : Rp %.2f\n", pendapatanPerKapita);
        System.out.println("Kelompok Golongan UKT     : Golongan " + golonganUKT);
        System.out.printf("Nominal UKT Semester      : Rp %.2f\n", nominalUKT);
        if (biayaPangkal > 0) {
            System.out.printf("Iuran Institusi (IPI)     : Rp %.2f\n", biayaPangkal);
        }
        System.out.printf("TOTAL PEMBAYARAN          : Rp %.2f\n", totalTagihan);

        input.close();
    }
}