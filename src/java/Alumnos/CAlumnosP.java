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
    private final ArrayList SECCION = new ArrayList();
    private final ArrayList GRADO = new ArrayList();
            
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
}
