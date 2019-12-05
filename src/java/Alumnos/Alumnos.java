/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

import java.util.ArrayList;

public class Alumnos {
    
    private ArrayList APELLIDO,NOMBRE,NUMERO_ID,ID_ALUMNO,SECCION,GRADO;

    public ArrayList getNUMERO_ID() {
        return NUMERO_ID;
    }

    public void setNUMERO_ID(ArrayList NUMERO_ID) {
        this.NUMERO_ID = NUMERO_ID;
    }
    private boolean RESULT;

    public ArrayList getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(ArrayList APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public ArrayList getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(ArrayList NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

   

    public ArrayList getID_ALUMNO() {
        return ID_ALUMNO;
    }

    public void setID_ALUMNO(ArrayList ID_ALUMNO) {
        this.ID_ALUMNO = ID_ALUMNO;
    }

    public ArrayList getSECCION() {
        return SECCION;
    }

    public void setSECCION(ArrayList SECCION) {
        this.SECCION = SECCION;
    }

    public ArrayList getGRADO() {
        return GRADO;
    }

    public void setGRADO(ArrayList GRADO) {
        this.GRADO = GRADO;
    }

    public boolean isRESULT() {
        return RESULT;
    }

    public void setRESULT(boolean RESULT) {
        this.RESULT = RESULT;
    }
    
    
            
    
}
