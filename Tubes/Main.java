package Tubes;

import java.util.Scanner;

public class Main {
    private static Graph graph = new Graph();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;
        while (pilihan != 7) {
            cetakMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tambahMataKuliah();
                    break;
                case 3:
                    tambahMataKuliahKeMahasiswa();
                    break;
                case 4:
                    tampilkanMahasiswa();
                    break;
                case 5:
                    cariMahasiswa();
                    break;
                case 6:
                    tampilkanMataKuliah();
                    break;
                case 7:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void cetakMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tambah Mata Kuliah");
        System.out.println("3. Tambah Mata Kuliah ke Mahasiswa");
        System.out.println("4. Tampilkan Daftar Mahasiswa");
        System.out.println("5. Cari Mahasiswa");
        System.out.println("6. Tampilkan Daftar Mata Kuliah");
        System.out.println("7. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private static void tambahMahasiswa() {
        System.out.print("Masukkan nama mahasiswa: ");
        String namaMahasiswa = scanner.nextLine();
        System.out.print("Masukkan NRP mahasiswa: ");
        String nrpMahasiswa = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(namaMahasiswa, nrpMahasiswa);
        graph.addVertex(mahasiswa);
    }

    private static void tambahMataKuliah() {
        System.out.print("Masukkan nama mata kuliah: ");
        String namaMataKuliah = scanner.nextLine();
        System.out.print("Masukkan kode mata kuliah: ");
        String kodeMataKuliah = scanner.nextLine();
        MataKuliah matakuliah = new MataKuliah(namaMataKuliah, kodeMataKuliah);
        graph.addVertex(matakuliah);
    }

    private static void tambahMataKuliahKeMahasiswa() {
        System.out.print("Masukkan NRP mahasiswa: ");
        String nrpMahasiswa = scanner.nextLine();
        System.out.print("Masukkan kode mata kuliah: ");
        String kodeMataKuliah = scanner.nextLine();
        graph.addEdge(nrpMahasiswa, kodeMataKuliah);
    }

    private static void tampilkanMahasiswa() {
        graph.tampilkanGraf();
    }

    private static void cariMahasiswa() {
        System.out.print("Masukkan NRP : ");
        String nrpMahasiswa = scanner.nextLine();
        graph.cariMahasiswa(nrpMahasiswa);
    }

    private static void tampilkanMataKuliah() {
        System.out.println("Daftar Mata Kuliah:");
        for (MataKuliah matakuliah : graph.matakuliahs.values()) {
            System.out.println(matakuliah.nama + " (Kode: " + matakuliah.kode + ")");
        }
    }
}