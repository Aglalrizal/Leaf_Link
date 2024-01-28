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
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kampanye;
import model.Personal;
import model.Volunteer;

/**
 *
 * @author aglalrizal
 */
public class VolunteerDAO {
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void saveVolunteer(Volunteer v){
        try{
            con = BaseDAO.getCon();
           //d.getKampanye().donasi(d.getJml_sumbangan());
            v.getRelawan().addRiwayatVolunteer(v.getKampanye());
            v.getKampanye().addVolunteer(v.getRelawan());
            query = "INSERT INTO volunteer VALUES ('%s', '%s', '%s')";
            query = String.format(
                    query,
                    v.getIdVolunteer(),
                    v.getRelawan().getIdUser(),
                    v.getKampanye().getIdKampanye());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
            System.out.println("Yeay, Berhasil bergabung!");
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
    }
    
    public static ArrayList<Volunteer> getAllbyUser(Personal u) {
        ArrayList<Volunteer> res = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            query = "select * from volunteer "
                    + "where idUser = '%s'";

            query = String.format(query, u.getIdUser().toString());
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Volunteer a = new Volunteer(UUID.fromString(rs.getString("idVolunteer")),
                            PersonalDAO.searchByUid(rs.getString("idUser")),
                            KampanyeDAO.getKampanyeById(rs.getString("idKampanye")));
                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return res;
    }
    
    public static ArrayList<Personal> getAllbyKampanye(Kampanye k) {
        ArrayList<Personal> res = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            query = "select * from volunteer "
                    + "where idKampanye = '%s'";

            query = String.format(query, k.getIdKampanye().toString());
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Personal a = PersonalDAO.searchByUid(rs.getString("idUser"));
                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return res;
    }
    
    public static ArrayList<Volunteer> getAll() {
        ArrayList<Volunteer> all = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            query = "select * from volunteer";

            query = String.format(query);
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Volunteer a = new Volunteer(UUID.fromString(rs.getString("idVolunteer")),
                            PersonalDAO.searchByUid(rs.getString("idUser")),
                            KampanyeDAO.getKampanyeById(rs.getString("idKampanye")));
                all.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return all;
    }            
    public static int getJumlahVolunteer(String id){
        int count = 0;
        try{
            con = BaseDAO.getCon();
            String query = "select count(*) from volunteer "
                    + "where idKampanye = '%s'";
            
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                count = rs.getInt(1);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return count;
    }
    
        public static boolean isRegistered(String idUser, String idKampanye) {
        String checkUser = "SELECT COUNT(*) AS register_count FROM volunteer WHERE idUser = ? AND idKampanye = ?";
        con = BaseDAO.getCon();
        try (PreparedStatement pst = con.prepareStatement(checkUser)) {
            pst.setString(1, idUser);
            pst.setString(2, idKampanye);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int registerCount = rs.getInt("register_count");

                if (registerCount > 0) {
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
}
