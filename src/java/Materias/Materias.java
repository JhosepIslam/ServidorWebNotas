/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materias;

import java.util.ArrayList;

public class Materias {
    
    private ArrayList CODIGO_MATERIA,NOMBRE_MATERIA, ID_MATERIA, ESTADO, FECHA;
    private boolean RESULT;

    public boolean isRESULT() {
        return RESULT;
    }

    public void setRESULT(boolean RESULT) {
        this.RESULT = RESULT;
    }
    

    public ArrayList getCODIGO_MATERIA() {
        return CODIGO_MATERIA;
    }

    public void setCODIGO_MATERIA(ArrayList CODIGO_MATERIA) {
        this.CODIGO_MATERIA = CODIGO_MATERIA;
    }

    public ArrayList getNOMBRE_MATERIA() {
        return NOMBRE_MATERIA;
    }

    public void setNOMBRE_MATERIA(ArrayList NOMBRE_MATERIA) {
        this.NOMBRE_MATERIA = NOMBRE_MATERIA;
    }

    public ArrayList getID_MATERIA() {
        return ID_MATERIA;
    }

    public void setID_MATERIA(ArrayList ID_MATERIA) {
        this.ID_MATERIA = ID_MATERIA;
    }

    public ArrayList getESTADO() {
        return ESTADO;
    }

    public void setESTADO(ArrayList ESTADO) {
        this.ESTADO = ESTADO;
    }

    public ArrayList getFECHA() {
        return FECHA;
    }

    public void setFECHA(ArrayList FECHA) {
        this.FECHA = FECHA;
    }
    
    
}
