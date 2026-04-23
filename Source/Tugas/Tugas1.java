package Tugas;

import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Sistem Evaluasi Akademik Berbasis SKS ===");
        System.out.print("Masukkan jumlah mata kuliah diselesaikan: ");
        int jumlahMK = input.nextInt();

        int totalSKS = 0;
        double totalNilaiMutu = 0.0;
        boolean temukanNilaiKritis = false;

        for (int i = 1; i <= jumlahMK; i++) {
            System.out.print("SKS MK ke-" + i + ": ");
            int sks = input.nextInt();

            System.out.print("Nilai Huruf (A/B/C/D/E) MK ke-" + i + ": ");
            char huruf = input.next().toUpperCase().charAt(0);

            double bobotAngka;
            switch (huruf) {
                case 'A':
                    bobotAngka = 4.0;
                    break;
                case 'B':
                    bobotAngka = 3.0;
                    break;
                case 'C':
                    bobotAngka = 2.0;
                    break;
                case 'D':
                    bobotAngka = 1.0;
                    break;
                case 'E':
                    bobotAngka = 0.0;
                    temukanNilaiKritis = true;
                    break;
                default:
                    bobotAngka = 0.0;
                    System.out.println("Karakter tidak valid, otomatis bernilai 0.");
                    break;
            }

            totalSKS += sks;
            totalNilaiMutu += (bobotAngka * sks);
        }

        double ipk = (totalSKS > 0) ? totalNilaiMutu / totalSKS : 0.0;
        System.out.printf("\n[Hasil] IPK Akhir: %.2f (Total SKS: %d)\n", ipk, totalSKS);

        if (temukanNilaiKritis) {
            System.out.println("Status: Peringatan Akademik Khusus.");
            System.out.println(
                    "Tindakan: Terdapat nilai E. Mahasiswa wajib mengulang mata kuliah terkait sebelum mengambil tugas akhir.");
        } else if (ipk >= 3.5) {
            System.out.println("Status: Cum Laude.");
            System.out.println("Tindakan: Memenuhi syarat pengajuan asisten lab dan beasiswa. Diizinkan 24 SKS.");
        } else if (ipk >= 3.0) {
            System.out.println("Status: Sangat Memuaskan.");
            System.out.println("Tindakan: Batas aman. Diizinkan mengambil 22 SKS semester depan.");
        } else if (ipk >= 2.0) {
            System.out.println("Status: Memuaskan.");
            System.out.println("Tindakan: Standar minimal kelulusan terpenuhi. Diizinkan mengambil 20 SKS.");
        } else {
            System.out.println("Status: Kurang.");
            System.out.println("Tindakan: Masuk masa evaluasi. Wajib bimbingan dengan dosen wali. Maksimal 18 SKS.");
        }

        input.close();
    }
}