/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Academico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CAcademicos {
    Connection con = Conexiones.Conexion.getConection();
    private final ArrayList NOMBRE = new ArrayList();
    private final ArrayList ID_SECCION_DOCENTE = new ArrayList();    
    private final ArrayList APELLIDO = new ArrayList();
    private final ArrayList ID_USUARIO = new ArrayList();
    private final ArrayList ID_DOCENTE = new ArrayList();
    private final ArrayList ESTADO = new ArrayList();
    private final ArrayList GRADO = new ArrayList();
    private final ArrayList SECCION = new ArrayList();
    private final ArrayList NOMBRE_MATERIA = new ArrayList();
    private final ArrayList CODIGO_MATERIA = new ArrayList();
    private final ArrayList ID_MATERIA_DOCENTE = new ArrayList();
    
    public Academicos getSeccionesSinNotas(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_SIN_NOTAS_ACADEMICO()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
    
    
    public Academicos getSeccionesConNotasAceptadas(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_MATERIAS_NOTAS_SUBIDAS_ACEPTADAS_ACADEMICO()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));                
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
       
    public Academicos getSeccionesConNotasRechazadas(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_MATERIAS_NOTAS_SUBIDAS_RECHAZADAS_ACADEMICO()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
        
        
    public Academicos getSeccionesConNotasRevision(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_MATERIAS_NOTAS_SUBIDAS_REVISION_ACADEMICO()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
    
    
    
    public Academicos getSeccionesConNotasAceptadasEXCEL(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_CON_NOTAS_ACADEMICA_EXCEL()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));                
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
       
    public Academicos getSeccionesConNotasRechazadasEXCEL(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_CON_NOTAS_RECHAZADA_ACADEMICA_EXCEL()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
        
        
    public Academicos getSeccionesConNotasRevisionEXCEL(){
        Academicos academicos = new Academicos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_CON_NOTAS_REVISION_ACADEMICA_EXCEL()}");
            ResultSet res = sql.executeQuery();
            
            
            while (res.next()) {                
                
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
                
            }
            
            academicos.setCODIGO_MATERIA(CODIGO_MATERIA);
            academicos.setGRADO(GRADO);
            academicos.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            academicos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            academicos.setSECCION(SECCION);          
        } catch (SQLException e) {
        }
        
        return academicos;
    }
    public Academicos AprobarExcel(int IdMateriaDocente){
        Academicos academicos = new Academicos();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_APROBAR_NOTAS_EXCEL_ACADEMICA(?)}");
            sql.setInt(1, IdMateriaDocente);
            sql.execute();
        } catch (SQLException e) {
        }
        
        return academicos;
    }
    
     public Academicos RechazarExcel(int IdMateriaDocente){
        Academicos academicos = new Academicos();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_RECHAZAR_NOTAS_EXCEL_ACADEMICA(?)}");
            sql.setInt(1, IdMateriaDocente);
            sql.execute();
        } catch (SQLException e) {
        }
        
        return academicos;
    }
     
     
     public Academicos RechazarNotas(int IdMateriaDocente){
        Academicos academicos = new Academicos();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_RECHAZAR_NOTAS_ACADEMICA(?)}");
            sql.setInt(1, IdMateriaDocente);
            sql.execute();
        } catch (SQLException e) {
        }
        
        return academicos;
    }
     public Academicos AprobarNotas(int IdMateriaDocente){
        Academicos academicos = new Academicos();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_APROBAR_NOTAS_ACADEMICA(?)}");
            sql.setInt(1, IdMateriaDocente);
            sql.execute();
        } catch (SQLException e) {
        }
        
        return academicos;
    }
     
     
     
      public String getPathArchivoExcel(int IdMateriaDocente){
         String Repuesta=null;
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_URL_ARCHIVO_NOTAS(?)}");
            sql.setInt(1, IdMateriaDocente);
            ResultSet res = sql.executeQuery();
            if (res.next()) {
                Repuesta = res.getString("FILE_PATH");
            }
     
        } catch (SQLException e) {
        }
        
        return Repuesta;
    }
        
}
