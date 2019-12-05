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

public class CMaterias {
    Connection con = Conexion.getConection();
    private final ArrayList CODIGO_MATERIA = new ArrayList();
    private final ArrayList NOMBRE_MATERIA = new ArrayList();
    private final ArrayList ID_MATERIA = new ArrayList();
    private final ArrayList ESTADO = new ArrayList();
    private final ArrayList FECHA = new ArrayList();
    
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
    
    public Materias ValidarCodigoMateria(String CODIGO_MATERIA){
        Materias materias = new Materias();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_VALIDAR_CODIGO_MATERIA(?)}");
            sql.setString(1, CODIGO_MATERIA);
            ResultSet result = sql.executeQuery();
           
            if (result.next()) {
                //falso y ya existe uno 
                materias.setRESULT(false);
            }else{
                //verdadero si se puede utilizar
                materias.setRESULT(true);
            }
        } catch (SQLException e) {
        }
        
        return materias;
    }
    
    public Materias ListarMateriasGrado(int ID_GRADO){
        Materias materias = new Materias();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_MATERIAS_GRADOS(?)}");
            sql.setInt(1, ID_GRADO);
            ResultSet result = sql.executeQuery();
            while (result.next()) {                
                ID_MATERIA.add(result.getString("ID_MATERIA"));
                NOMBRE_MATERIA.add(result.getString("NOMBRE_MATERIA"));
                CODIGO_MATERIA.add(result.getString("CODIGO_MATERIA"));                
            }
            materias.setCODIGO_MATERIA(CODIGO_MATERIA);
            materias.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            materias.setID_MATERIA(ID_MATERIA);
            
        } catch (SQLException e) {
            String er= e.getMessage();
            materias.setRESULT(false);
        }
        return materias;
        
    }
    
       public Materias ListMateriasNotInGradosMaterias(int ID_GRADO){
        Materias materias = new Materias();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_MATERIAS(?)}");
            sql.setInt(1, ID_GRADO);
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
    
      public Materias CreateGradoMateria(int ID_MATERIA , int ID_GRADO){
        Materias materias = new Materias();
        try {          
            
            CallableStatement sql = con.prepareCall("{call SP_CREATE_GRADO_MATERIA(?,?)}");
            
            sql.setInt(1, ID_MATERIA);  
            sql.setInt(2, ID_GRADO);
            sql.execute();
            materias.setRESULT(true);
        } catch (SQLException ex) {
            materias.setRESULT(false);
        }
        return materias;
    }
      
      public Materias DeleteGradoMateria(int ID_MATERIA , int ID_GRADO){
        Materias materias = new Materias();
        try {          
            
            CallableStatement sql = con.prepareCall("{call SP_DELETE_GRADO_MATERIA(?,?)}");
            
            sql.setInt(1, ID_MATERIA);  
            sql.setInt(2, ID_GRADO);
            sql.execute();
            materias.setRESULT(true);
        } catch (SQLException ex) {
            materias.setRESULT(false);
        }
        return materias;
    }
    
      //doncentes
      public Materias GetMateriasWithoutDocenteBySeccion(int idSeccion){
          Materias materias = new Materias();
        try {          
            
            CallableStatement sql = con.prepareCall("{call SP_GET_LIST_MATERIAS_WITHOUT_DOCENTE(?)}");            
            sql.setInt(1, idSeccion);  
            ResultSet result = sql.executeQuery();
                        
            while(result.next()){
                ID_MATERIA.add(result.getString("ID_MATERIA"));
                CODIGO_MATERIA.add(result.getString("CODIGO_MATERIA"));
                NOMBRE_MATERIA.add(result.getString("NOMBRE_MATERIA"));                
            }
            materias.setCODIGO_MATERIA(CODIGO_MATERIA);
            materias.setID_MATERIA(ID_MATERIA);
            materias.setNOMBRE_MATERIA(NOMBRE_MATERIA);
           
        } catch (SQLException ex) {
            materias.setRESULT(false);
        }
        return materias;
      }
      
      public Materias InsertarMateriaDocente(int IdDocente,int IdMateria,int idSeccion){
          Materias materias = new Materias();
        try {          
            
            CallableStatement sql = con.prepareCall("{call SP_INSERT_MATERIA_DOCENTE(?,?,?)}");            
            sql.setInt(1, IdDocente);  
            sql.setInt(2, idSeccion);
            sql.setInt(3, IdMateria); 
                          
            sql.execute();
            materias.setRESULT(true);
           
        } catch (SQLException ex) {
            materias.setRESULT(false);
        }
        return materias;
      }
      
      public Materias DeleteMateria_Docente(int idMateriaDocente){
          Materias materias = new Materias();
          try {
              CallableStatement sql = con.prepareCall("{call SP_DELETE_MATERIA_DOCENTE(?)}");
              sql.setInt(1, idMateriaDocente);
              sql.execute();
              materias.setRESULT(true);
              
          } catch (SQLException e) {
              materias.setRESULT(false);
          }
          
          return materias;
      }
      
      
      
}
