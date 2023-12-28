/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Personal;

/**
 *
 * @author aglalrizal
 */
public class PersonalDAO {
     private static Connection con;
     private static Statement stmt;
     private static String query;
    
    public static boolean checkEmail(String email) {
        String checkUser = "SELECT COUNT(*) AS email_count FROM personal WHERE email = ?";
        con = BaseDAO.getCon();
        try (PreparedStatement pst = con.prepareStatement(checkUser)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int emailCount = rs.getInt("email_count");

                if (emailCount > 0) {
                    System.out.println("Registrasi gagal: Email sudah terdaftar.");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganisasiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BaseDAO.closeCon(con);
        }
        return false;
    }
       
    public static void registerPersonal(Personal user) {
        try {
            con = BaseDAO.getCon();
            
            String checkUser = "SELECT COUNT(*) AS email_count FROM personal WHERE email = '%s'";
            checkUser = String.format(checkUser, user.getEmail());
                stmt = con.prepareStatement(checkUser);
                ResultSet rs = stmt.executeQuery(checkUser);

            if (rs.next()) {
                int emailCount = rs.getInt("email_count");

                if (emailCount > 0) {
                    System.out.println("Registrasi gagal: Email sudah terdaftar.");
                    return;
                }
            }
            
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
            //stmt.executeUpdate(query);
            System.out.println("Registrasi Berhasil!");
        }catch(SQLException ex){
            System.err.print("Registrasi gagal: "+ ex.getMessage());
            System.exit(1);
        }   finally {
            BaseDAO.closeCon(con);
        }
    }
    public static Personal searchByUid(String idUser) {
        Personal u = null;
        try {
            con = BaseDAO.getCon();
            String query = "select * from personal where idUser = '%s'";
            query = String.format(query, idUser);

            stmt = con.prepareStatement(query);
            ResultSet rsUser = stmt.executeQuery(query);
            //Personal(UUID idUser, String nama, String username, String email, String noHp, String alamat, String password, String pekerjaan, String tanggalLahir)
            if (rsUser.next()) {
                    u = new Personal(UUID.fromString(rsUser.getString("idUser")), rsUser.getString("nama"), 
                    rsUser.getString("username"), rsUser.getString("email"), rsUser.getString("noHp"), 
                    rsUser.getString("alamat"), rsUser.getString("password"), rsUser.getString("pekerjaan"),
                    rsUser.getDate("tanggal_lahir"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return u;
    }
        public static Personal validatePersonal(String email, String password) {
        Personal u = null;
        try {
            con = BaseDAO.getCon();
            query = "select * from personal where email = '%s' and password = '%s' ";
            query = String.format(query,
                    email,
                    password);
            stmt = con.prepareStatement(query);
            ResultSet rsUser = stmt.executeQuery(query);
            if (rsUser.next()) {
                 u = new Personal(UUID.fromString(rsUser.getString("idUser")), rsUser.getString("nama"), 
                    rsUser.getString("username"), rsUser.getString("email"), rsUser.getString("noHp"), 
                    rsUser.getString("alamat"), rsUser.getString("password"), rsUser.getString("pekerjaan"),
                    rsUser.getDate("tanggal_lahir"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return u;
    }      
}
