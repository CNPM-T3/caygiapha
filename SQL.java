package caygiapha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADT
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SQL {
    static private Connection conn=null;
    static public boolean Connection(String url){
        try {
            conn=DriverManager.getConnection(url);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, "Connect is null.", ex);
            return false;
        }
    }
    
    static public boolean Connect(String url,String user,String password){
        try {
            conn=DriverManager.getConnection(url,user,password);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, "Connect is null.", ex);
            return false;
        }
        
    }
    static public Connection getConnection(){
        return conn;
    }
    static public boolean disconnect(){
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
