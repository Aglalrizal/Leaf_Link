/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 *
 * @author aglalrizal
 */
public class UserDAO {
    private static Connection con;
    private static Statement stmt;
    private static String query;
    
    public Boolean login(){
        return true;
    }
    public Boolean logout(){
        return true;
    }
//    public Boolean register(){
//        return false;
//    }
//    
//    public void register(User user){
//        try{
//            query = "INSERT INTO user VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
//            query = String.format(
//                    query,
//                    user.getIdUser(),
//                    user.getUsername(),
//                    user.getNama(),
//                    user.getEmail(),
//                    user.getNoHp(),
//                    user.getPassword(),
//                    user.getDeskripsi(),
//                    user.getRole());
//            stmt.executeUpdate(query);
//            System.out.println("Registrasi Berhasil!");
//        }catch(SQLException ex){
//            System.err.print("Registrasi gagal: "+ ex.getMessage());
//            System.exit(1);
//        }
//    }  
//    public int getCurrentIndex(){
//        try{
//            query = "SELECT COUNT(idUser) FROM user";
//            query = String.format(query);
//            ResultSet rs = stmt.executeQuery(query);
//            if(rs.next() != false){
//                return rs.getInt(1);
//            }else{
//                System.out.println("Data tidak ditemukan");
//            }
//        } catch(SQLException ex){
//            System.err.print("Error getting the data: "+ex.getMessage());
//        }
//        return 0;
//    }
        public static void registerUser(User user) {
        try {
            con = BaseDAO.getCon();
            
            String checkUser = "SELECT COUNT(*) AS email_count FROM user WHERE email = '%s'";
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
            
            query = "INSERT INTO user VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
            query = String.format(
                    query,
                    user.getIdUser(),
                    user.getUsername(),
                    user.getNama(),
                    user.getEmail(),
                    user.getNoHp(),
                    user.getPassword(),
                    user.getDeskripsi(),
                    user.getRole());
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
}
//p.getDepartment());
//            st = con.prepareStatement(query);
//            st.executeUpdate();
//            faculty.put(p.getSsn(), p);
//        } catch (SQLException ex) {
//            System.err.print("Error saving the data: "
//                    + ex.getMessage());
//            System.exit(1);
//        }