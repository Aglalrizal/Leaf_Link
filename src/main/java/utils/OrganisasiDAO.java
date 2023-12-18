/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.Artikel;
import model.Kampanye;
import model.Organisasi;

/**
 *
 * @author aglalrizal
 */
public class OrganisasiDAO {
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void saveArtikel(Organisasi organisasi, Artikel artikel){
        try{
            con = BaseDAO.getCon();
            organisasi.addArtikel(artikel);
            query = "INSERT INTO Artikel VALUES ('%s', '%s', '%s', '%s')";
            query = String.format(
                    query,
                    artikel.getIdArtikel(),
                    artikel.getJudul(),
                    artikel.getIsi(),
                    organisasi.getIdUser());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        }catch(SQLException ex){
            System.err.print("Error inserting data: "+ ex.getMessage());
            System.exit(1);
        } finally {
            BaseDAO.closeCon(con);
        }
    }
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
            System.out.println("Berhasil menambahkan data!");
        }catch(SQLException ex){
            System.err.print("Error inserting data: "+ ex.getMessage());
            System.exit(1);
        } finally {
            BaseDAO.closeCon(con);
        }
    }
}
