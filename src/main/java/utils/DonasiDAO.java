/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Donasi;
import model.Kampanye;

/**
 *
 * @author aglalrizal
 */
public class DonasiDAO {
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public static void saveDonasi(Donasi d){
        try{
            con = BaseDAO.getCon();
            d.getKampanye().donasi(d.getJml_sumbangan());
            query = "INSERT INTO sumbangan VALUES ('%s', '%s', '%s', '%d')";
            query = String.format(
                    query,
                    d.getIdDonasi(),
                    d.getPerson().getIdUser(),
                    d.getKampanye().getIdKampanye(),
                    d.getJml_sumbangan());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
            System.out.println("Yeay, Donasi berhasil!");
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
    }
    
       public static long totalDonasi(Kampanye k){
        long total = 0;
        try{
            con = BaseDAO.getCon();
            String query = "select count(*) from sumbangan "
                    + "where idKampanye = '%s'";
            
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                query = "SELECT SUM(jml_sumbangan) FROM sumbangan where idKampanye = '%s'";
                query = String.format(query, k.getIdKampanye().toString());
                stmt = con.prepareStatement(query);
                ResultSet sumResult = stmt.executeQuery(query);
                if(sumResult.next()){
                    total = sumResult.getLong("SUM(jml_sumbangan)");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return total;
    }
    
}
