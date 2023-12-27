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
import model.Organisasi;

/**
 *
 * @author aglalrizal
 */
public class OrganisasiDAO {
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void registerOrganisasi(Organisasi user) {
        try {
            con = BaseDAO.getCon();
            
//            String checkUser = "SELECT COUNT(*) AS email_count FROM organisasi WHERE email = '%s'";
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
//            
            query = "INSERT INTO organisasi VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
            query = String.format(
                    query,
                    user.getIdUser(),
                    user.getUsername(),
                    user.getNama(),
                    user.getEmail(),
                    user.getNoHp(),
                    user.getAlamat(),
                    user.getPassword(),
                    user.getDeskripsi());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
            System.out.println("Registrasi Berhasil!");
        }catch(SQLException ex){
            System.err.print("Registrasi gagal: "+ ex.getMessage());
            System.exit(1);
        }   finally {
            BaseDAO.closeCon(con);
        }
    }
    
    public static Organisasi searchByUid(String idUser) {
        Organisasi u = null;
        try {
            con = BaseDAO.getCon();
            query = "select * from organisasi where idUser = '%s'";
            query = String.format(query, idUser);

            stmt = con.prepareStatement(query);
            ResultSet rsUser = stmt.executeQuery(query);
            if (rsUser.next()) {
                    u = new Organisasi(UUID.fromString(rsUser.getString("idUser")), rsUser.getString("nama"), 
                    rsUser.getString("username"), rsUser.getString("email"), rsUser.getString("noHp"), 
                    rsUser.getString("alamat"), rsUser.getString("password"), rsUser.getString("deskripsi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return u;
    }
    
        public static Organisasi validateOrganisasi(String email, String password) {
        Organisasi u = null;
        try {
            con = BaseDAO.getCon();
            query = "select idUser from organisasi where email = '%s' and password = '%s' ";
            query = String.format(query,
                    email,
                    password);
            stmt = con.prepareStatement(query);
            ResultSet rsUser = stmt.executeQuery(query);
            if (rsUser.next()) {
                u = new Organisasi(UUID.fromString(rsUser.getString("idUser")), 
                        rsUser.getString("nama"), rsUser.getString("username"), 
                        rsUser.getString("email"), rsUser.getString("noHp"), 
                        rsUser.getString("alamat"), rsUser.getString("password"), 
                        rsUser.getString("deskripsi"));
                u.setListKampanye(KampanyeDAO.getAllbyOrganisasi(u));
                u.setListArtikel(ArtikelDAO.getAllbyOrganisasi(u));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return u;
    }
        
}
