/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CAlumnos {
    Connection con = Conexiones.Conexion.getConection();
    
    public Alumno CreateAlumno(String NIE,String Nombre, String Apellido, String Fecha_Matricula,int Id_Seccion,String Password){
        Alumno alumno= new Alumno();
        
        try {
            CallableStatement  sql = con.prepareCall("{call SP_CREATE_ALUMNO(?,?,?,?,?,?)}");
            sql.setString(1,NIE.trim());
            sql.setString(2,Nombre.trim().toUpperCase());
            sql.setString(3, Apellido.trim().toUpperCase());
            sql.setString(4,Fecha_Matricula);
            sql.setInt(5, Id_Seccion);
            sql.setString(6, Password.trim());
            sql.execute();
            alumno.setRESULT(true);
        } catch (SQLException ex) {
            String re = ex.getMessage();
            alumno.setRESULT(false);
        }       
        return alumno;
    }
    
}
