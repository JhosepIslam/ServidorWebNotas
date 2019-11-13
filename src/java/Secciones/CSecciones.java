/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CSecciones {
    private final ArrayList ID_SECCION = new ArrayList();
    private final ArrayList ID_GRADO = new ArrayList();
    private final ArrayList SECCION = new ArrayList();
    private final ArrayList ESTADO = new ArrayList();
    
    private final Connection con = Conexiones.Conexion.getConection();
    public Secciones getSecciones(int Id_Grado) {
        Secciones secciones = new Secciones();
        
        
        try{
            CallableStatement sql = con.prepareCall("{call SP_GET_SECCIONES(?)}");
            sql.setInt(1, Id_Grado);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                ID_SECCION.add(res.getInt("ID_SECCION"));
                ID_GRADO.add(res.getInt("ID_GRADO"));
                SECCION.add(res.getString("SECCION"));
                ESTADO.add(res.getInt("ESTADO"));
            }
            secciones.setID_SECCION(ID_SECCION);
            secciones.setID_GRADO(ID_GRADO);
            secciones.setSECCION(SECCION);
            secciones.setESTADO(ESTADO);
        }catch(SQLException ex){}
        return secciones;
        
    }
    
    public Secciones CreateSeccion(int IdGrado,String Seccion){
        Secciones secciones = new Secciones();
        
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_CREATE_SECCION(?,?)}");
            sql.setInt(1, IdGrado);
            sql.setString(2, Seccion);
            sql.execute();
            
            secciones.setRESP_CONSULTA(true);
            
        } catch (SQLException e) {
            secciones.setRESP_CONSULTA(false);
        }
        
        return secciones;                
    }
    
    public Secciones DeleteSeccion(int Id_seccion){
        Secciones secciones = new Secciones();
        try {
            CallableStatement sql = con.prepareCall("{call SP_DELETE_SECCION(?)}");
            sql.setInt(1, Id_seccion);
            sql.execute();
            secciones.setRESP_CONSULTA(true);            
        } catch (SQLException e) {
            secciones.setRESP_CONSULTA(false);
        }
        
        return secciones;
    }
    
    
    
    
    
    
    
    
}
