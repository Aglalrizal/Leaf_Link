/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import model.Organisasi;
import model.User;
import model.Personal;
import utils.UserDAO;
/**
 *
 * @author rizal
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Personal p1 = new Personal("Leaflink", "leaflink", "leaflink@upi.edu", "0812345678", "leaflink");
//        Personal p2 = new Personal("Leaflink2", "leaflink2", "leaflink2@upi.edu", "08123456789", "leaflink2");
////        uD.register(p1);
//        uD.register(p2);
//        Organisasi o1 = new Organisasi("Leaflink3", "leaflink3", "leaflink3@upi.edu", "08123456789", "leaflink3", "acep");
//        uD.register(o1);
        Organisasi o2 = new Organisasi("Leaflink", "leaflink", "leaflink@upi.edu", "08123456780", "leaflink6", "leaflink");
        UserDAO.registerUser(o2);
        System.out.println(o2.toString());
        o2.buatArtikel("leaflink artikel judul", "leaflink artikel isi");
        o2.buatKampanye("leaflink kampanye", "purwakarta", "leaflink", 15000000, 30);
    }
}
