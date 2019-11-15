/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

/**
 *
 * @author LENOVO
 */
public class Alumno {
    
    private String NIE,NOMBRE,APELLIDO,FECHA_MATRICULA;
    private int ID_ALUMNOS,ID_SECCION;

    private boolean RESULT;

    public boolean isRESULT() {
        return RESULT;
    }

    public void setRESULT(boolean RESULT) {
        this.RESULT = RESULT;
    }
        
    public String getNIE() {
        return NIE;
    }

    public void setNIE(String NIE) {
        this.NIE = NIE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getFECHA_MATRICULA() {
        return FECHA_MATRICULA;
    }

    public void setFECHA_MATRICULA(String FECHA_MATRICULA) {
        this.FECHA_MATRICULA = FECHA_MATRICULA;
    }

    public int getID_ALUMNOS() {
        return ID_ALUMNOS;
    }

    public void setID_ALUMNOS(int ID_ALUMNOS) {
        this.ID_ALUMNOS = ID_ALUMNOS;
    }

    public int getID_SECCION() {
        return ID_SECCION;
    }

    public void setID_SECCION(int ID_SECCION) {
        this.ID_SECCION = ID_SECCION;
    }
    
    
    
    
    
}
