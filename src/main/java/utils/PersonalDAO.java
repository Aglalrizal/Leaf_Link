/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import model.Personal;
import model.User;

/**
 *
 * @author aglalrizal
 */
public class PersonalDAO {
     private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void registerPersonal(Personal user) {
        try {
            con = BaseDAO.getCon();
            
//            String checkUser = "SELECT COUNT(*) AS email_count FROM personal WHERE email = '%s'";
//            checkUser = String.format(checkUser, user.getEmail());
//                stmt = con.prepareStatement(checkUser);
//                ResultSet rs = stmt.executeQuery(checkUser);
//
//            if (rs.next()) {
//                int emailCount = rs.getInt("email_count");
//
//                if (emailCount > 0) {
//                    System.out.println("Registrasi gagal: Email sudah terdaftar.");
//                    return;
//                }
//            }
            
            query = "INSERT INTO personal VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
            query = String.format(
                    query,
                    user.getIdUser(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getNama(),
                    user.getTanggalLahir(),
                    user.getNoHp(),
                    user.getAlamat(),
                    user.getPekerjaan(),
                    user.getPassword());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
//            stmt.executeUpdate(query);
            System.out.println("Registrasi Berhasil!");
        }catch(SQLException ex){
            System.err.print("Registrasi gagal: "+ ex.getMessage());
            System.exit(1);
        }   finally {
            BaseDAO.closeCon(con);
        }
    }
//        public static User validatePersonal(String email, String password) {
//        User u = null;
//        try {
//            con = BaseDAO.getCon();
//            query = "select idUser from personal where email = '%s' and password = '%s' ";
//            query = String.format(query,
//                    email,
//                    password);
//            stmt = con.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery(query);
//            if (rs.next()) {
//                u = new User(UUID.fromString(rs.getString("idUser")), rs.getString("username"), rs.getString("nama"), rs.getString("email"), rs.getString("noHp"), rs.getString("alamat"), password, rs.getString("deskripsi"), rs.getString("role"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            BaseDAO.closeCon(con);
//        }
//        return u;
//    }
//        
}
