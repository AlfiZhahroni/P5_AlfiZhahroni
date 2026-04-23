package Latihan;

import java.util.Scanner;

public class Latihan2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float kehadiran, nilai_akhir, tugas, uts, uas, realisasi;
        float b_kehadiran, b_tugas, b_uts, b_uas;
        char grade = 'E';

        System.out.print("Input realisasi Pertemuan: ");
        realisasi = input.nextFloat();

        System.out.print("Input Kehadiran : ");
        kehadiran = input.nextFloat();

        System.out.print("Input Nilai Tugas : ");
        tugas = input.nextFloat();

        System.out.print("Input Nilai UTS : ");
        uts = input.nextFloat();

        System.out.print("Input Nilai UAS : ");
        uas = input.nextFloat();

        b_kehadiran = (kehadiran / realisasi) * 10;
        b_tugas = (tugas * 20) / 100;
        b_uts = (uts * 30) / 100;
        b_uas = (uas * 40) / 100;
        nilai_akhir = b_kehadiran + b_tugas + b_uts + b_uas;

        if (nilai_akhir >= 80) {
            grade = 'A';
        } else if ((nilai_akhir >= 70) && (nilai_akhir < 80)) {
            grade = 'B';
        } else if ((nilai_akhir >= 60) && (nilai_akhir < 70)) {
            grade = 'C';
        } else if ((nilai_akhir >= 55) && (nilai_akhir < 60)) {
            grade = 'D';
        } else if (nilai_akhir < 55) {
            grade = 'E';
        }
        float presentasi_kehadiran = kehadiran * 100 / 21;
        if (presentasi_kehadiran >= 75) {
            System.out.println("Nilai : " + nilai_akhir + "dengan grade " + grade);
        } else {
            if (nilai_akhir >= 55) {
                nilai_akhir = 55;
                grade = 'D';
                System.out.println("Nilai : " + nilai_akhir + "dengan grade " + grade);
                System.out.println("Tidak Lulus");
            } else {
                grade = 'E';
                System.out.println("Nilai : " + nilai_akhir + "dengan grade " + grade);
                System.out.println("Tidak Lulus");
            }
        }

    }
}