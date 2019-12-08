/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CAlumnosP {
    Connection con = Conexiones.Conexion.getConection();
    private final ArrayList APELLIDO = new ArrayList();
    private final ArrayList NOMBRE = new ArrayList();
    private final ArrayList NUMERO_ID = new ArrayList();
    private final ArrayList ID_ALUMNO = new ArrayList();
    private final ArrayList ID_GRADO = new ArrayList();
    private final ArrayList SECCION = new ArrayList();
    private final ArrayList GRADO = new ArrayList();
    private final ArrayList CODIGO_MATERIA = new ArrayList();
    private final ArrayList NOMBRE_MATERIA = new ArrayList();
    private final ArrayList NOTA = new ArrayList();
    
    private final ArrayList ID_FECHA_EVALUACION = new ArrayList();
    private final ArrayList NUM_EVALUACION = new ArrayList();
    private final ArrayList ID_MATERIA = new ArrayList();
    private final ArrayList FIN = new ArrayList();
    
    public Alumnos ListAlumnosFromSeccion(int IdSeccion){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LIST_ALUMNOS_FROM_SECCION(?)}");
            sql.setInt(1,IdSeccion);
            
            ResultSet res = sql.executeQuery();
            while(res.next()){
                APELLIDO.add(res.getString("APELLIDO"));
                NUMERO_ID.add(res.getString("NUMERO_ID"));
                NOMBRE.add(res.getString("NOMBRE"));
                GRADO.add(res.getString("GRADO"));
                
            }
            alumnos.setAPELLIDO(APELLIDO);
            alumnos.setGRADO(GRADO);
            alumnos.setNOMBRE(NOMBRE);
            alumnos.setNUMERO_ID(NUMERO_ID);
            
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
    
    
    
    public Alumnos ListAlumnosNotas(int IdMateriaDocente){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_ALUMNOS_SUBIR_NOTAS(?)}");
            sql.setInt(1,IdMateriaDocente);
            
            ResultSet res = sql.executeQuery();
            while(res.next()){
                APELLIDO.add(res.getString("APELLIDO"));
                NUMERO_ID.add(res.getString("NUMERO_ID"));
                NOMBRE.add(res.getString("NOMBRE"));
                GRADO.add(res.getString("GRADO"));
                SECCION.add(res.getString("SECCION"));
                ID_ALUMNO.add(res.getString("ID_ALUMNO"));
                
            }
            alumnos.setAPELLIDO(APELLIDO);
            alumnos.setGRADO(GRADO);
            alumnos.setNOMBRE(NOMBRE);
            alumnos.setNUMERO_ID(NUMERO_ID);
            alumnos.setID_ALUMNO(ID_ALUMNO);
            alumnos.setSECCION(SECCION);
            
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
    
    //para revisar las notas subidas a los alumnos
    public Alumnos ListAlumnosNotasRevisionAcademica(int IdMateriaDocente){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_NOTAS_ALUMNOS_ACADEMICA(?)}");
            sql.setInt(1,IdMateriaDocente);
            
            ResultSet res = sql.executeQuery();
            while(res.next()){
                APELLIDO.add(res.getString("APELLIDO"));
                NUMERO_ID.add(res.getString("NUMERO_ID"));
                NOMBRE.add(res.getString("NOMBRE"));
                GRADO.add(res.getString("GRADO"));
                SECCION.add(res.getString("SECCION"));
                
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));
                NOTA.add(res.getString("NOTA"));
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));
                
            }
            alumnos.setAPELLIDO(APELLIDO);
            alumnos.setGRADO(GRADO);
            alumnos.setNOMBRE(NOMBRE);
            alumnos.setNUMERO_ID(NUMERO_ID);
            
            alumnos.setSECCION(SECCION);
            alumnos.setNOTA(NOTA);
            alumnos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            alumnos.setCODIGO_MATERIA(CODIGO_MATERIA);
            
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
    
    
    // para obtener las notas subidas
        public Alumnos getMiID(String Usuario){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_ALUMNOS_GET_MI_ID(?)}");
            sql.setString(1,Usuario);
            
            ResultSet res = sql.executeQuery();
            if (res.next()) {
                ID_ALUMNO.add(res.getString("ID_ALUMNO"));
            }
            alumnos.setID_ALUMNO(ID_ALUMNO);
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
        
        
        
        
     public Alumnos getMiEvaluaciones(){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_ALUMNOS_GET_EVALUACIONES()}");            
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                ID_FECHA_EVALUACION.add(res.getString("ID_FECHA_CARGA_EVALUACION"));
                NUM_EVALUACION.add(res.getString("NUM_EVALUACION"));                
            }
            alumnos.setID_FECHA_EVALUACION(ID_FECHA_EVALUACION);
            alumnos.setNUM_EVALUACION(NUM_EVALUACION);
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
     
     public int getMiSeccion(int IdAlumno){
        int id=0;
        try {
            CallableStatement sql = con.prepareCall("{call SP_ALUMNOS_GET_MI_SECCION(?)}");            
            sql.setInt(1, IdAlumno);
            ResultSet res = sql.executeQuery();
            if (res.next()) {
                id = res.getInt("ID_SECCION");
            }
           
        } catch (SQLException e) {
           
        }
        return id;
    }
     
      public Alumnos getMisMaterias(int IdSeccion){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_ALUMNOS_GET_MIS_MATERIAS(?)}");   
            sql.setInt(1, IdSeccion);
      
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));                
                ID_MATERIA.add(res.getString("ID_MATERIA")); 
            }
            alumnos.setCODIGO_MATERIA(CODIGO_MATERIA);
            alumnos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            alumnos.setID_MATERIA(ID_MATERIA);
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
     
     
     public Alumnos getMisNotas(int IdAlumno,int IdMateria, int IdEvaluacion){
        Alumnos alumnos = new Alumnos();
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_MIS_NOTAS_ALUMNOS(?,?,?)}");   
            sql.setInt(1, IdAlumno);
            sql.setInt(2, IdMateria);
            sql.setInt(3, IdEvaluacion);
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                CODIGO_MATERIA.add(res.getString("CODIGO_MATERIA"));
                NOMBRE_MATERIA.add(res.getString("NOMBRE_MATERIA"));                
                NOTA.add(res.getString("NOTA")); 
            }
            alumnos.setCODIGO_MATERIA(CODIGO_MATERIA);
            alumnos.setNOMBRE_MATERIA(NOMBRE_MATERIA);
            alumnos.setNOTA(NOTA);
        } catch (SQLException e) {
            alumnos.setRESULT(false);
        }
        return alumnos;
    }
     
        
}
