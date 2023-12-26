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
import java.util.UUID;
import model.Organisasi;
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
}