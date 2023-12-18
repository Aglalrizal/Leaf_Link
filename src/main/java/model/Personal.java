/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aglalrizal
 */
import java.util.ArrayList;
import java.util.List;

public class Personal extends User {
    private List<Kampanye> riwayatKampanye = new ArrayList<>();
    public Personal(){
        super();
        this.role = "Personal";
    }
    public Personal(String username, String nama, String email, String noHp, String password){
        super(username, nama, email, noHp, password);
        this.role = "Personal";
    }
    public void addRiwayatKampanye(Kampanye kampanye){
        this.riwayatKampanye.add(kampanye);
    }
    public void showRiwayatKampanye(){

    }
    public String toString() {
        return "UserId: "+getIdUser()+ "\n" +
                "Nama: "+ getNama()+ "\n" +
                "Email: "+getEmail()+ "\n" +
                "No hp: "+getNoHp();
    }
}