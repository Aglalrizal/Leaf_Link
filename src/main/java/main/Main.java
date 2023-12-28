package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Artikel;
import model.Kampanye;
import model.Organisasi;
import model.Personal;
import utils.ArtikelDAO;
import utils.KampanyeDAO;
import utils.OrganisasiDAO;
import utils.PersonalDAO;
/**
 *
 * @author rizal
 */
public class Main {
    public static void main(String[] args) {
        
//        //Buat Organisasi
//        Organisasi o1 = new Organisasi("Leaflink-o1", "leaflink", "leaflink@upi.edu1", "08123456780", "dimaana-mana hatiku senang", "leaflink6", "leaflink organisasi");
//        Organisasi o2 = new Organisasi("Leaflink-o2", "leaflink", "leaflink@upi.edu2", "08123456780", "dimaana-mana hatiku senang", "leaflink6", "leaflink organisasi");
//        
//        //Daftar dan simpan di database
//        OrganisasiDAO.registerOrganisasi(o1);
//        OrganisasiDAO.registerOrganisasi(o2);
//        
//        //Print Data Organisasi
//        System.out.println(o1.toString());
//        System.out.println(o2.toString());
//        
//        //Buat Artikel
//        Artikel a1 = new Artikel("judul 1", "konten 1");
//        Artikel a2 = new Artikel("judul 2", "konten 2");
//        Artikel a3 = new Artikel("judul 3", "konten 3");
//        Artikel a4 = new Artikel("judul 4", "konten 4"); 
//        Artikel a5 = new Artikel("judul 4", "konten 5");
//        
//        //Simpan artikel di dua organisasi
//        o1.buatArtikel(a1);
//        o1.buatArtikel(a2);
//        o2.buatArtikel(a3);
//        o2.buatArtikel(a4);
//        o2.buatArtikel(a5);
//        
//        //biar ada jarak aja si
//        System.out.println("");
//        
//        //Buat Kampanye
//        //constructor kampanye -> public Kampanye(String nama, String deskripsi, int jumlahVolunteer, String lokasi, long targetPendanaan)
//        Kampanye k1 = new Kampanye("Kampanye 1", "kampanye1", 20, "Bumi", 2000000);
//        Kampanye k2 = new Kampanye("Kampanye 2", "kampanye2", 20, "Bumi", 2000000);
//        Kampanye k3 = new Kampanye("Kampanye 3", "kampanye3", 20, "Bumi", 2000000);
//        Kampanye k4 = new Kampanye("Kampanye 4", "kampanye4", 20, "Bumi", 2000000);
//        Kampanye k5 = new Kampanye("Kampanye 5", "kampanye4", 20, "Bumi", 2000000);
//        
//        //Simpan kampanye 
//        o1.buatKampanye(k1);
//        o1.buatKampanye(k2);
//        o1.buatKampanye(k3);
//        o2.buatKampanye(k4);
//        o2.buatKampanye(k5);
//
//        //Format tanggal
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date tanggalLahir = null;
//        try {
//             tanggalLahir = dateFormat.parse("2002-04-20");
//        }catch(ParseException e) {
//             e.printStackTrace();
//        }
//        String tanggalFormatted = dateFormat.format(tanggalLahir);
//            
//        //Buat akun personal
//        //constructor class Personal ->Personal(String username, String nama, String email, String noHp, String alamat, String password, String pekerjaan, Date tanggalLahir)
////        Personal p1 = new Personal("Leaflink Person", "leafLinkPerson", "person1@leaflink.com", 
////                                        "1234567890", "ini alamat upi pwk ya", "password123", 
////                                        "Rektor aamiin", tanggalFormatted);
//        
//        //biar ada jarak aja si
//        System.out.println("");
//        
//        //Tampilkan data akun personal di atas
//        p1.display();
//        
//        //Daftarkan dan simpan akun personal tersebut di database
//        PersonalDAO.registerPersonal(p1);
//        System.out.println("");
//        
//        //biar ada jarak aja si
//        System.out.println("");
//        
//        //Menampilkan Seluruh Kampanye
//        System.out.println("================================================");
//        System.out.println("================Seluruh Kampanye================");
//        System.out.println("================================================");
//        ArrayList<Kampanye> allKampanye = KampanyeDAO.getAll();
//        for(Kampanye k : allKampanye){
//            System.out.println(k.toString());
//        }
//        System.out.println("================================================");
//        //Menampilkan Kampanye oleh user o1
//        System.out.println("================================================");
//        System.out.println("================Semua Kampanye oleh o1================");
//        System.out.println("================================================");
//        o1.displayKampanye();
//        
//        //Menampilkan Kampanye oleh user o2
//        System.out.println("================================================");
//        System.out.println("================Semua Kampanye oleh o2================");
//        System.out.println("================================================");
//        o2.displayKampanye();
//        System.out.println("================================================");
//        
//        //user p1 melakukan donasi
//        p1.donasi(200000, k1);
//        p1.donasi(200001, k1);
//        p1.donasi(200002, k1);
//        p1.donasi(200003, k1);
//        p1.donasi(200004, k1);
//        p1.donasi(200005, k4);
//        
//        //user p1 mendaftar volunteer
//        p1.volunteer(k4);
//        p1.volunteer(k5);
//        p1.volunteer(k1);
//        p1.volunteer(k2);
//        
//        //biar ada jarak aja si
//        System.out.println("");
//        
//        //judul
//        System.out.println("======================================================================================");
//        System.out.println("================Kampanye setelah user p1 donasi dan daftar volunteer==================");
//        System.out.println("======================================================================================");
//        
//        //biar ada jarak aja si
//        System.out.println("");
//        
//        //Menampilkan Kampanye oleh user o1 setelah user p1 melakukan donasi
//        System.out.println("=======================================================");
//        System.out.println("================Kampanye oleh user o1==================");
//        System.out.println("=======================================================");
//        o1.displayKampanye();
//        System.out.println("=======================================================");
//        //Menampilkan Kampanye oleh user o2 setelah user p1 melakukan donasi
//        System.out.println("================Kampanye oleh user o1==================");
//        System.out.println("=======================================================");
//        o2.displayKampanye();
//        System.out.println("=======================================================");
//        //Menampilkan seluruh Artikel
//        System.out.println("=================Semua Artikel==================");
//        System.out.println("================================================");
//        ArrayList<Artikel> allArtikel = ArtikelDAO.getAll();
//        for(Artikel a : allArtikel){
//            System.out.println(a.toString());
//        }
//        System.out.println("================================================");
//        //Menampilkan artikel oleh user o1
//        System.out.println("================Artikel oleh user o1===============");
//        System.out.println("===================================================");
//        o1.displayArtikel();
//        System.out.println("===================================================");
//        //Menampilkan artikel oleh user o2
//        System.out.println("================Artikel oleh user o2===============");
//        System.out.println("===================================================");
//        o2.displayArtikel();
//        System.out.println("===================================================");
//        
//        
//        
//        //Menampilkan riwayat donasi user p1
//        System.out.println("=======================================================");
//        System.out.println("================Riwayat Donasi user p1==================");
//        System.out.println("=======================================================");
//        p1.showRiwayatDonasi();
//        
//        //Menampilkan riwayat volunteer
//        System.out.println("=======================================================");
//        System.out.println("================Riwayat Volunteer user p1==================");
//        System.out.println("=======================================================");
//        p1.showRiwayatVolunteer();
    }
}
