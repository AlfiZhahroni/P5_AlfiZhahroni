package Latihan;

import java.util.Scanner;

public class Latihan1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float kehadiran, nilai_akhir;
        char grade = 'E';

        System.out.print("Input Kehadiran : ");
        kehadiran = input.nextFloat();

        System.out.print("Input Nilai Akhir : ");
        nilai_akhir = input.nextFloat();

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
