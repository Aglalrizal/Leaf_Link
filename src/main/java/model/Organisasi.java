/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import model.Artikel;
import utils.ArtikelDAO;
import utils.KampanyeDAO;
import utils.OrganisasiDAO;

/**
 *
 * @author aglalrizal
 */

public class Organisasi extends User {
    private ArrayList<Kampanye> listKampanye = new ArrayList<>();
    private ArrayList<Artikel> listArtikel = new ArrayList<>();
    private String deskripsi;
    public Organisasi(){
        super();
        Scanner scanner = new Scanner(System.in);
        this.role = "Organisasi";
    }
    
    public Organisasi(String nama, String username, String email, String noHp, String alamat, String password, String deskripsi){
        super(nama, username, email, noHp, alamat, password);
        this.role = "Organisasi";
        this.deskripsi = deskripsi;
    }
    
    public Organisasi(UUID idUser, String nama, String username, String email, String noHp, String alamat, String password, String deskripsi){
        super(idUser, nama, username, email, noHp, alamat, password);
        this.role = "Organisasi";
        this.deskripsi = deskripsi;
    }
    
    public void addArtikel(Artikel artikel){
        listArtikel.add(artikel);
    }
    public void buatArtikel(Artikel a){
        a.setAuthor(this);
        ArtikelDAO.saveArtikel(this, a);
    }
    public void addKampanye(Kampanye k){
        listKampanye.add(k);
    }
    
    public void buatKampanye(Kampanye k){
        k.setPenyelenggara(this);
        KampanyeDAO.saveKampanye(this, k);
    }

    public ArrayList<Kampanye> getListKampanye() {
        return listKampanye;
    }

    public void setListKampanye(ArrayList<Kampanye> listKampanye) {
        this.listKampanye = listKampanye;
    }

    public ArrayList<Artikel> getListArtikel() {
        return listArtikel;
    }

    public void setListArtikel(ArrayList<Artikel> listArtikel) {
        this.listArtikel = listArtikel;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public void displayKampanye()         
    {
        for(Kampanye k : this.listKampanye)
        {
            System.out.println(k.toString());
        }
    }
    
    public void displayArtikel()
    {
        for(Artikel a : this.listArtikel)
        {
            System.out.println(a.toString());
        }
    }
    @Override
    public String toString(){
        return super.toString()+
               "Deskripsi: "+ getDeskripsi()+"\n";
    }
}