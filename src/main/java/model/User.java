/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aglalrizal
 */
import java.util.Scanner;

public class User {
    protected String userId;
    protected String username;
    protected String nama;
    protected String email;
    protected String noHp;
    protected String password;
    protected String role;
    private String deskripsi;
    public static int idIndex = 0;
    public User() {
        setUserId();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        this.username = scanner.nextLine();
        System.out.println("Nama: ");
        this.nama = scanner.nextLine();
        System.out.println("Email: ");
        this.email = scanner.nextLine();
        System.out.println("noHp: ");
        this.noHp = scanner.nextLine();
        System.out.println("Password: ");
        this.password = scanner.nextLine();
    }
    public User(String nama, String username, String email, String noHp, String password) {
        setUserId();
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.noHp = noHp;
        this.password = password;
    }
    
    public User(String nama, String username, String email, String noHp, String password, String deskripsi) {
        setUserId();
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.noHp = noHp;
        this.password = password;
        this.deskripsi = deskripsi;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(){
        idIndex++;
        this.userId = "lflk"+idIndex;
    }
    @Override
    public String toString() {
        return "UserId: "+getUserId()+ "\n" +
                "Nama: "+ getNama()+ "\n" +
                "Email: "+getEmail()+ "\n" +
                "No hp: "+getNoHp()+"\n";
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}