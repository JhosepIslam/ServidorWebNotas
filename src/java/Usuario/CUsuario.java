/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Conexiones.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CUsuario {
    Connection con = Conexion.getConection();
    
    public Usuario CrearUsuario(String nombre_usuario , String Password, String nombre, String apellido, String Correo, int nivel){
        Usuario usuario = new Usuario();
        try {
            CallableStatement sql = con.prepareCall("{call SP_CREATE_USUARIO(?,?,?,?,?,?) }");
            sql.setString(1,nombre_usuario);
            sql.setString(2,Password);
            sql.setInt(3, nivel);
            sql.setString(4,nombre.toUpperCase());
            sql.setString(5,apellido.toUpperCase());
            sql.setString(6,Correo);
            
            sql.execute();
            
            usuario.setRESULT(true);
        } catch (SQLException e) {
            String result =e.getMessage();
            usuario.setRESULT(false);
        }
        
        return usuario;
    }
    
}
