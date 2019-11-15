/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materias;

import Conexiones.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author LENOVO
 */
public class CMaterias {
    Connection con = Conexion.getConection();
    private ArrayList CODIGO_MATERIA = new ArrayList()
            ,NOMBRE_MATERIA= new ArrayList()
            , ID_MATERIA= new ArrayList()
            , ESTADO= new ArrayList()
            , FECHA= new ArrayList();
    
    public Materias CrearMateria(String Codigo,String Nombre){
        Materias materias = new Materias();
        try {
            CallableStatement sql = con.prepareCall("{call SP_CREATE_MATERIA(?,?)}");
            sql.setString(1, Codigo.trim().toUpperCase());
            sql.setString(2, Nombre.trim().toUpperCase());
            sql.execute();
            materias.setRESULT(true);
            
        } catch (SQLException ex) {
            materias.setRESULT(false);
        }
        return materias;
    }
    
    public Materias ListMaterias(){
        Materias materias = new Materias();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LIST_MATERIAS()}");
            ResultSet result = sql.executeQuery();
            
            while (result.next()) {
                ID_MATERIA.add(result.getString("ID_MATERIA"));
                CODIGO_MATERIA.add(result.getString("CODIGO_MATERIA"));
                NOMBRE_MATERIA.add(result.getString("NOMBRE_MATERIA"));                
                ESTADO.add(result.getString("ESTADO"));
                FECHA.add(result.getString("FECHA"));
            }
            materias.setCODIGO_MATERIA(CODIGO_MATERIA);
            materias.setID_MATERIA(ID_MATERIA);
            materias.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            materias.setESTADO(ESTADO);
            materias.setFECHA(FECHA);           
            
        } catch (SQLException e) {
            String er = e.getMessage();
            materias.setRESULT(false);
        }
        return materias;
        
    }
    
    public Materias DeleteMaterias(int ID_MATERIA){
        Materias materias = new Materias();
        try {          
            
            CallableStatement sql = con.prepareCall("{call SP_DELETE_MATERIA(?)}");
            
            sql.setInt(1, ID_MATERIA);            
            sql.execute();
            materias.setRESULT(true);
        } catch (SQLException ex) {
            materias.setRESULT(false);
        }
        return materias;
    }
    
    
    
}
