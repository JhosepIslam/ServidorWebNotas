
package Evaluaciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CEvaluaciones {
    Connection con = Conexiones.Conexion.getConection();
    
    private final ArrayList ID_EVALUACION = new ArrayList();
    private final ArrayList NUM_EVALUACION = new ArrayList();
    private final ArrayList INICIO = new ArrayList();
    private final ArrayList FIN = new ArrayList();
    
    
    
    public Evaluaciones SetEvaluacion(int numero_evaluacion, String inicio, String fin){
        Evaluaciones evaluaciones = new Evaluaciones();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_INSERT_EVALUACION(?,?,?) }");
            java.sql.Date Inicio=java.sql.Date.valueOf(inicio);
             java.sql.Date Fin=java.sql.Date.valueOf(fin);
            sql.setInt(1, numero_evaluacion);
            sql.setDate(2,  Inicio);
            sql.setDate(3,  Fin);
            sql.execute();
            evaluaciones.setRESULT(true);
            
        } catch (SQLException e) {
            evaluaciones.setRESULT(false);
            
        }       
        
        return evaluaciones;
    }
    public Evaluaciones DeleteEvaluacion(int IdEvaluacion){
        Evaluaciones evaluaciones = new Evaluaciones();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_DELETE_FECHA_EVALUACION(?) }");
            
            sql.setInt(1, IdEvaluacion);           
            sql.execute();
            evaluaciones.setRESULT(true);
            
        } catch (SQLException e) {
            evaluaciones.setRESULT(false);
            
        }       
        
        return evaluaciones;
    }
    
    public Evaluaciones validarEvaluacion(int numero_evaluacion, String inicio, String fin){
        Evaluaciones evaluaciones = new Evaluaciones();
        
        try {
            CallableStatement sql = con.prepareCall("{call SP_VALIDAR_FECHA_EVALUACION(?,?,?)}");
             java.sql.Date Inicio=java.sql.Date.valueOf(inicio);
             java.sql.Date Fin=java.sql.Date.valueOf(fin);
            sql.setInt(1, numero_evaluacion);
            sql.setDate(2,Inicio);
            sql.setDate(3, Fin);
            ResultSet res = sql.executeQuery();
            if (res.next()) {
                int result = res.getInt("RESULTADO");
                if (result == -1) {
                    evaluaciones.setRESULT(false);
                }else{
                    evaluaciones.setRESULT(true);
                }
            }           
        } catch (SQLException e) {
            evaluaciones.setRESULT(false);
            
        }       
        
        return evaluaciones;
    }
    
    
    public Evaluaciones ListEvaluaciones(){
        Evaluaciones evaluaciones = new Evaluaciones();
        try {
            CallableStatement sql = con.prepareCall("{call SP_LISTAR_FECHAS_EVALUACIONES()}");
            ResultSet result = sql.executeQuery();
            while(result.next()){
                ID_EVALUACION.add(result.getString("ID_FECHA_CARGA_EVALUACION"));
                NUM_EVALUACION.add(result.getString("NUM_EVALUACION"));
                INICIO.add(result.getString("INICIO"));
                FIN.add(result.getString("FIN"));
            }
            evaluaciones.setFIN(FIN);
            evaluaciones.setID_EVALUACION(ID_EVALUACION);
            evaluaciones.setINICIO(INICIO);
            evaluaciones.setNUMERO_EVALUACION(NUM_EVALUACION);
        } catch (SQLException e) {
            evaluaciones.setRESULT(false);
        }
        return evaluaciones;
    }
    public Evaluaciones getTodayEvaluation(){
        Evaluaciones evaluaciones = new Evaluaciones();
        try {
            CallableStatement sql = con.prepareCall("{call SP_GET_FECHA_DE_SUBIDA()}");
            ResultSet result = sql.executeQuery();
            while(result.next()){
                ID_EVALUACION.add(result.getString("ID_FECHA_CARGA_EVALUACION"));
                NUM_EVALUACION.add(result.getString("NUM_EVALUACION"));
                INICIO.add(result.getString("INICIO"));
                FIN.add(result.getString("FIN"));
            }
            evaluaciones.setFIN(FIN);
            evaluaciones.setID_EVALUACION(ID_EVALUACION);
            evaluaciones.setINICIO(INICIO);
            evaluaciones.setNUMERO_EVALUACION(NUM_EVALUACION);
        } catch (SQLException e) {
            evaluaciones.setRESULT(false);
        }
        return evaluaciones;
    }
}
