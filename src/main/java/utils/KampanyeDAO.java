/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import model.Kampanye;
import model.Organisasi;

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
            query = "INSERT INTO Kampanye (idKampanye, namaKampanye, lokasi, deskripsi, targetPendanaan, jumlahVolunteer, idUser, tglPenanaman, jenisPohon, batasDonasi, image) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, k.getIdKampanye().toString());
            st.setString(2, k.getNama());
            st.setString(3, k.getLokasi());
            st.setString(4, k.getDeskripsi());
            st.setLong(5, k.getTargetPendanaan());
            st.setInt(6, k.getTargetVolunteer());
            st.setString(7, o.getIdUser().toString());
            st.setDate(8, (Date) k.getTanggalPenanaman());
            st.setString(9, k.getJenisPohon());
            st.setDate(10, (Date) k.getBatasDonasi());
            st.setBytes(11, k.getDataGambar());

            st.executeUpdate();
            System.out.println("Berhasil Membuat dan Menyimpan Kampanye!");
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
            query = "select * from kampanye "
                    + "where idUser = '%s'";

            query = String.format(query, u.getIdUser().toString());
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                //UUID idKampanye, String nama, String deskripsi, int targetVolunteer, String lokasi, 
                //long targetPendanaan, Date tanggalPenanaman, String jenisPohon, Date batasDonasi, 
                //byte[] dataGambar, Organisasi penyelenggara
                Kampanye k = new Kampanye(UUID.fromString(rs.getString("idKampanye")),
                            rs.getString("namaKampanye"),
                            rs.getString("deskripsi"),
                            rs.getInt("jumlahVolunteer"),
                            rs.getString("lokasi"),
                            rs.getInt("targetPendanaan"),
                            rs.getDate("tglPenanaman"),
                            rs.getString("jenisPohon"),
                            rs.getDate("batasDonasi"),
                            rs.getBytes("image"),
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
            query = "select * from kampanye";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            //UUID uuid, String nama, String lokasi, String deskripsi, int targetPendanaan, int jumlahVolunteer, Organisasi penyelenggara
            while (rs.next()) {
                Kampanye k = new Kampanye(UUID.fromString(rs.getString("idKampanye")),
                            rs.getString("namaKampanye"),
                            rs.getString("deskripsi"),
                            rs.getInt("jumlahVolunteer"),
                            rs.getString("lokasi"),
                            rs.getInt("targetPendanaan"),
                            rs.getDate("tglPenanaman"),
                            rs.getString("jenisPohon"),
                            rs.getDate("batasDonasi"),
                            rs.getBytes("image"),
                            OrganisasiDAO.searchByUid(rs.getString("idUser")));
                k.setSumbangan(DonasiDAO.totalDonasi(k));
                k.setVolunteer(VolunteerDAO.getAllbyKampanye(k));
                res.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return res;
    }
    
        public static Kampanye getKampanyeById(String id) {
        Kampanye k = null;
        try {
            con = BaseDAO.getCon();
            query = "select * from kampanye where idKampanye = '%s'";
            query = String.format(query, id);
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            //UUID uuid, String nama, String lokasi, String deskripsi, int targetPendanaan, int jumlahVolunteer, Organisasi penyelenggara
            if (rs.next()) {
                k = new Kampanye(UUID.fromString(rs.getString("idKampanye")),
                            rs.getString("namaKampanye"),
                            rs.getString("deskripsi"),
                            rs.getInt("jumlahVolunteer"),
                            rs.getString("lokasi"),
                            rs.getInt("targetPendanaan"),
                            rs.getDate("tglPenanaman"),
                            rs.getString("jenisPohon"),
                            rs.getDate("batasDonasi"),
                            rs.getBytes("image"),
                            OrganisasiDAO.searchByUid(rs.getString("idUser")));
                k.setSumbangan(DonasiDAO.totalDonasi(k));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return k;
    }
}
