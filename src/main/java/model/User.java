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
import java.util.UUID;
import utils.UserDAO;

public class User {
    protected UUID idUser;
    protected String username;
    protected String nama;
    protected String email;
    protected String noHp;
    protected String password;
    protected String role;
    protected String alamat;
//    private int idIndex;
    public User() {
        UUID uuid = UUID.randomUUID();
        setIdUser(uuid);
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
    public User(String nama, String username, String email, String noHp, String alamat, String password) {
        UUID uuid = UUID.randomUUID();
        setIdUser(uuid);
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.noHp = noHp;
        this.alamat = alamat;
        this.password = password;
    }
    
        public User(UUID uuid, String nama, String username, String email, String noHp, String alamat, String password) {
        setIdUser(uuid);
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.noHp = noHp;
        this.alamat = alamat;
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public UUID getIdUser() {
        return idUser;
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
    
    @Override
    public String toString() {
        return "UserId: "+getIdUser()+ "\n" +
                "Nama: "+ getNama()+ "\n" +
                "Email: "+getEmail()+ "\n" +
                "Nomor Telepon: "+getNoHp()+
                "\nPassword: "+getPassword()+
                "\nRole: "+getRole()+ "\n";
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

    private void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}