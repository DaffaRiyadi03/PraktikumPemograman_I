package Tubes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Graph {
    private HashMap<String, Mahasiswa> mahasiswas;
    HashMap<String, MataKuliah> matakuliahs;
    private HashMap<String, ArrayList<String>> mahasiswaMataKuliahMap;

    public Graph() {
        mahasiswas = new HashMap<>();
        matakuliahs = new HashMap<>();
        mahasiswaMataKuliahMap = new HashMap<>();
    }

    public void addVertex(Object vertex) {
        if (vertex instanceof Mahasiswa) {
            Mahasiswa mahasiswa = (Mahasiswa) vertex;
            if (!mahasiswas.containsKey(mahasiswa.nrp)) {
                mahasiswas.put(mahasiswa.nrp, mahasiswa);
                mahasiswaMataKuliahMap.put(mahasiswa.nrp, new ArrayList<>());
                System.out.println("DATA MAHASISWA");
                System.out.println("Nama    :" + mahasiswa.nama );
                System.out.println("NRP    :" + mahasiswa.nrp);
                System.out.println("Berhasil ditambahkan.");
            } else {
                System.out.println("Data mahasiswa dengan NRP " + mahasiswa.nrp + " sudah ada.");
            }
        } else if (vertex instanceof MataKuliah) {
            MataKuliah matakuliah = (MataKuliah) vertex;
            if (!matakuliahs.containsKey(matakuliah.kode)) {
                matakuliahs.put(matakuliah.kode, matakuliah);
                System.out.println("DATA MATAKULIAH");
                System.out.println("Nama Matakuliah    :" + matakuliah.nama);
                System.out.println("Kode Matakuliah    :" + matakuliah.kode);
                System.out.println("Berhasil ditambahkan.");
            } else {
                System.out.println("Mata kuliah dengan kode " + matakuliah.kode + " sudah ada.");
            }
        }
    }

    public void addEdge(String nrp, String kode) {
        if (mahasiswas.containsKey(nrp) && matakuliahs.containsKey(kode)) {
            mahasiswaMataKuliahMap.get(nrp).add(kode);
            System.out.println("Mata kuliah dengan kode " + kode + " ditambahkan ke mahasiswa dengan NRP " + nrp + ".");
        } else {
            System.out.println("Mahasiswa atau mata kuliah tidak ditemukan.");
        }
    }

    public void cariMahasiswa(String nrp) {
        if (mahasiswas.containsKey(nrp)) {
            Mahasiswa mahasiswa = mahasiswas.get(nrp);
            System.out.println("DATA MAHASISWA");
            System.out.println("Nama    : " + mahasiswa.nama);
            System.out.println("NRP    : " + mahasiswa.nrp);
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    public void tampilkanGraf() {
        System.out.println("Daftar Mahasiswa dan Mata Kuliah yang Diambil:");
        for (String nrp : mahasiswaMataKuliahMap.keySet()) {
            Mahasiswa mahasiswa = mahasiswas.get(nrp);
            System.out.println("Mahasiswa    : " + mahasiswa.nama);
            System.out.println("NRP    : " + mahasiswa.nrp);
            System.out.println("Mata Kuliah:");
            for (String kode : mahasiswaMataKuliahMap.get(nrp)) {
                MataKuliah matakuliah = matakuliahs.get(kode);
                System.out.println("- " + matakuliah.nama + " (Kode: " + matakuliah.kode + ")");
            }
            System.out.println();
        }
    }
}