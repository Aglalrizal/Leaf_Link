/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import model.Donasi;
import model.Kampanye;
import model.Organisasi;
import model.Personal;

/**
 *
 * @author aglalrizal
 */
public class KampanyeDAO {
    
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void saveKampanye(Organisasi o, Kampanye k){
        try{
            con = BaseDAO.getCon();
            o.addKampanye(k);
            query = "INSERT INTO Kampanye VALUES ('%s', '%s', '%s', '%s', '%d', '%d', '%s')";
            query = String.format(
                    query,
                    k.getIdKampanye(),
                    k.getNama(),
                    k.getLokasi(),
                    k.getDeskripsi(),
                    k.getTargetPendanaan(),
                    k.getJumlahVolunteer(),
                    o.getIdUser());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan Kampanye!");
        }catch(SQLException ex){
            System.err.print("Error inserting data: "+ ex.getMessage());
            System.exit(1);
        } finally {
            BaseDAO.closeCon(con);
        }
    }
    
    public static ArrayList<Kampanye> getAllbyOrganisasi(Organisasi u) {
        ArrayList<Kampanye> res = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            String query = "select * from kampanye "
                    + "where idUser = '%s'";

            query = String.format(query, u.getIdUser().toString());
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            //UUID uuid, String nama, String lokasi, String deskripsi, int targetPendanaan, int jumlahVolunteer, Organisasi penyelenggara
            while (rs.next()) {
                Kampanye k = new Kampanye(UUID.fromString(rs.getString(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            u);
                k.setSumbangan(DonasiDAO.totalDonasi(k));
                res.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return res;
    }
    public static ArrayList<Kampanye> getAll() {
        ArrayList<Kampanye> res = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            String query = "select * from kampanye";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            //UUID uuid, String nama, String lokasi, String deskripsi, int targetPendanaan, int jumlahVolunteer, Organisasi penyelenggara
            while (rs.next()) {
                Kampanye k = new Kampanye(UUID.fromString(rs.getString(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            OrganisasiDAO.searchByUid(rs.getString(7)));
                k.setSumbangan(DonasiDAO.totalDonasi(k));
                res.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return res;
    }
}
