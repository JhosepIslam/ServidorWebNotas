/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    
    static Connection conexion = null;
    
    public static Connection getConection(){
        String url ="jdbc:sqlserver://Islam\\SQLEXPRESS:1433;databaseName=Notas";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException ex){
        }
        
        try {
            conexion = DriverManager.getConnection(url,"sa","123");
        }catch(SQLException ex){}
        
        return conexion;
        
    }
    
    
    public static ResultSet Consulta(String Cosulta){
        Connection con = getConection();
        Statement declare;
        try {
            declare = con.createStatement();
            ResultSet respuesta = declare.executeQuery(Cosulta);
            return respuesta;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    
}
