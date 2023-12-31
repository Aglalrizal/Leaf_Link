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
import model.Artikel;
import model.Organisasi;

/**
 *
 * @author aglalrizal
 */
public class ArtikelDAO {
    
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void saveArtikel(Organisasi organisasi, Artikel artikel){
        try{
            con = BaseDAO.getCon();
            organisasi.addArtikel(artikel);
            query = "INSERT INTO Artikel (idArtikel, judul, isi, idUser, image) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);

            // Menyetel nilai parameter pada PreparedStatement
            st.setString(1, artikel.getIdArtikel().toString());
            st.setString(2, artikel.getJudul());
            st.setString(3, artikel.getIsi());
            st.setString(4, organisasi.getIdUser().toString());
            st.setBytes(5, artikel.getDataGambar());

        // Eksekusi pernyataan PreparedStatement
            st.executeUpdate();
            System.out.println("Berhasil menambahkan Artikel!");
        }catch(SQLException ex){
            System.err.print("Error inserting data: "+ ex.getMessage());
            System.exit(1);
        } finally {
            BaseDAO.closeCon(con);
        }
    }
    
    public static ArrayList<Artikel> getAllbyOrganisasi(Organisasi u) {
        ArrayList<Artikel> res = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            query = "select * from artikel "
                    + "where idUser = '%s'";

            query = String.format(query, u.getIdUser().toString());
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Artikel a = new Artikel(UUID.fromString(rs.getString("idArtikel")),
                            rs.getString("judul"),
                            rs.getString("isi"),
                            u,
                            rs.getBytes("image"));
                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return res;
    }
    
    public static ArrayList<Artikel> getAll() {
        ArrayList<Artikel> all = new ArrayList<>();
        try {
            con = BaseDAO.getCon();
            query = "select * from artikel ";

            query = String.format(query);
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Artikel a = new Artikel(UUID.fromString(rs.getString("idArtikel")),
                            rs.getString("judul"),
                            rs.getString("isi"),
                            OrganisasiDAO.searchByUid(rs.getString("idUser")),
                            rs.getBytes("image"));
                all.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return all;
    }
    
    //pr get 1 data and delete artikel
}
