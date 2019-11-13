/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author LENOVO
 */
public class CGrados {
    
    private final ArrayList ID = new ArrayList();
    private final ArrayList GRADO= new ArrayList();
    private final ArrayList ESTADO= new ArrayList();
    private final ArrayList SECCIONES= new ArrayList();
    private final Connection con = Conexiones.Conexion.getConection();
    
    public Grados ListGrados(){
        Grados grados = new Grados();        
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_GRADOS()}");
            ResultSet res = sql.executeQuery();
             
                while(res.next()){                                                                     
                        ID.add(res.getInt("ID_GRADO"));
                        GRADO.add(res.getString("GRADO"));
                        ESTADO.add(res.getInt("ESTADO"));    
                }               
                grados.setID(ID);
                grados.setGRADO(GRADO);
                grados.setESTADO(ESTADO);                
            
        } catch (SQLException e) {
            grados.setERROR_MESSAGE(e.getMessage());
        }
        
        
        return grados;
    }
    
    public Grados GetListGrados_Info(){
        Grados grados = new Grados();        
        try {
            CallableStatement sql  = con.prepareCall("{call SP_LIST_INFO_GRADOS()}");
            ResultSet res = sql.executeQuery();
            
            
                while(res.next()){
                    ID.add(res.getInt("ID_GRADO"));
                    GRADO.add(res.getString("GRADO"));
                    SECCIONES.add(res.getInt("SECCIONES"));
                }
                grados.setID(ID);
                grados.setGRADO(GRADO);
                grados.setSECCIONES(SECCIONES);                         
                        
           
        } catch (SQLException e) {
            grados.setERROR_MESSAGE(e.getMessage());
        }
        
        return grados;
    }
    
    
    public Grados DeleteGrados(int id_grado){
        Grados grados = new Grados();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_DELETE_GRADOS(?)}");
            sql.setInt(1, id_grado);
            boolean a = sql.execute();
            grados.setCONSULTA_RESULT(a);
            
        } catch (SQLException e) {
            grados.setCONSULTA_RESULT(false);
        }
        
        return grados;
    }
    
    public Grados CreateGrado(String Grado){
        Grados grados = new Grados();
        try {
            CallableStatement sql = con.prepareCall("{call SP_CREATE_GRADO(?)}");
            sql.setString(1, Grado);
            sql.execute();
            grados.setCONSULTA_RESULT(true);
        } catch (SQLException ex) {           
            grados.setCONSULTA_RESULT(false);
        }
        
        return grados;
    }
    public Grados UpdateGrado(int Id_grado, String Grado){
        Grados grados = new Grados();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_UPDATE_GRADO(?,?)}");
            sql.setInt(1, Id_grado);
            sql.setString(2, Grado);
            sql.execute();
            grados.setCONSULTA_RESULT(true);
        } catch (SQLException e) {
            grados.setCONSULTA_RESULT(false);
        }
        
        return grados;
    }
  
    
    
    
    
}
