/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aglalrizal
 */
public class UserDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;
    
    public UserDAO(){
        url = "jdbc:mysql://localhost/leaflink";
        uname = "root";
        pass = "";
        this.setConnectionAndStatement();
    }
    private void setConnectionAndStatement(){
        try{
            con = DriverManager.getConnection(url, uname, pass);
            stmt = con.createStatement();
        }catch (SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    public Boolean login(){
        return true;
    }
    public Boolean logout(){
        return true;
    }
}
