/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Docentes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CDocentes {
    
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
    
    
    public Docente GetDocentes (){
        Docente docente = new Docente();
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_LIST_DOCENTES()}");
            ResultSet res = sql.executeQuery();
            
            while(res.next()){
                ID_USUARIO.add(res.getString("ID_USUARIO"));
                ID_DOCENTE.add(res.getString("ID_DOCENTE"));
                NOMBRE.add(res.getString("NOMBRE"));
                APELLIDO.add(res.getString("APELLIDO"));
                ESTADO.add(res.getString("ESTADO"));
            }
            
            docente.setAPELLIDO(APELLIDO);
            docente.setESTADO(ESTADO);
            docente.setID_DOCENTE(ID_DOCENTE);
            docente.setID_USUARIO(ID_USUARIO);
            docente.setNOMBRE(NOMBRE);
            
            
        } catch (SQLException e) {
            String error =e.getMessage();
            docente.setRESULT(false);
        }
        return docente;
    }
    public Docente getSeccionesMateriasListDocente(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_GET_LIST_SECCIONES_MATERIAS_DOCENTES(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                ID_SECCION_DOCENTE.add(res.getString("ID_SECCION_DOCENTE"));
                ID_DOCENTE.add(res.getString("ID_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }
            docente.setID_SECCION_DOCENTE(ID_SECCION_DOCENTE);
            docente.setGRADO(GRADO);
            docente.setSECCION(SECCION);
            docente.setID_DOCENTE(ID_DOCENTE);
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            
        } catch (SQLException e) {
        }              
        return docente;
    }
    
    public Docente deleteDocente(int IdDocente){
        Docente docente = new Docente();
        try {
            CallableStatement sql = con.prepareCall("{call SP_DELETE_DOCENTE(?)}");
            sql.setInt(1, IdDocente);
            sql.execute();
            docente.setRESULT(true);
        } catch (SQLException e) {
            docente.setRESULT(false);
        }
        return docente;
    }
    
    public Docente getMateriasDocente(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_GET_MATERIAS_DOCENTE(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }            
            docente.setGRADO(GRADO);
            docente.setSECCION(SECCION);            
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            docente.setCODIGO_MATERIA(CODIGO_MATERIA);
            docente.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            
        } catch (SQLException e) {
        }              
        return docente;
    }
    
     public Docente getIdDocente(String Usuario){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_GET_DOCENTE_ID(?)}");
            sql.setString(1, Usuario);
            ResultSet res = sql.executeQuery();
            while(res.next()){               
                
                ID_DOCENTE.add(res.getString("ID_DOCENTE"));               
                
            }            
            docente.setID_DOCENTE(ID_DOCENTE);
            
            
        } catch (SQLException e) {
        }              
        return docente;
    }
     
     
     public Docente getMisSecciones(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_MIS_SECCIONES(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));                
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }            
            docente.setGRADO(GRADO);
            docente.setSECCION(SECCION);            
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            docente.setCODIGO_MATERIA(CODIGO_MATERIA);
            
            
        } catch (SQLException e) {
        }              
        return docente;
    }
     
     
     public Docente getMisSeccionesSinNotas(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_SIN_NOTAS(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }            
            docente.setGRADO(GRADO);
            docente.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            docente.setSECCION(SECCION);            
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            docente.setCODIGO_MATERIA(CODIGO_MATERIA);
            
            
        } catch (SQLException e) {
        }              
        return docente;
    }
    
     public Docente getMisSeccionesConNotas(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_CON_NOTAS(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }            
            docente.setGRADO(GRADO);
            docente.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            docente.setSECCION(SECCION);            
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            docente.setCODIGO_MATERIA(CODIGO_MATERIA);
            
            
        } catch (SQLException e) {
        }              
        return docente;
    }
     
      public Docente getMisSeccionesConNotasRevision(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_CON_NOTAS_REVISION(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }            
            docente.setGRADO(GRADO);
            docente.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            docente.setSECCION(SECCION);            
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            docente.setCODIGO_MATERIA(CODIGO_MATERIA);
            
            
        } catch (SQLException e) {
        }              
        return docente;
    }
      
      public Docente getMisSeccionesConNotasRechazado(int id_docente){
        
        Docente docente = new Docente();
        try {
            
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_SECCIONES_CON_NOTAS_RECHAZADO(?)}");
            sql.setInt(1, id_docente);
            ResultSet res = sql.executeQuery();
            while(res.next()){
                GRADO.add(res.getString("GRADO"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));   
                ID_MATERIA_DOCENTE.add(res.getString("ID_MATERIA_DOCENTE"));
                SECCION.add(res.getString("SECCION"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
            }            
            docente.setGRADO(GRADO);
            docente.setID_MATERIA_DOCENTE(ID_MATERIA_DOCENTE);
            docente.setSECCION(SECCION);            
            docente.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            docente.setCODIGO_MATERIA(CODIGO_MATERIA);
            
            
        } catch (SQLException e) {
        }              
        return docente;
    }
    
}
