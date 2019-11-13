/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grados;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Grados {
    private ArrayList ID  = new ArrayList();
    private ArrayList GRADO= new ArrayList();
    private ArrayList ESTADO = new ArrayList();
    private ArrayList SECCIONES = new ArrayList();
    
    private boolean CONSULTA_RESULT;
    private String ERROR_MESSAGE; 

    public boolean isCONSULTA_RESULT() {
        return CONSULTA_RESULT;
    }

    public void setCONSULTA_RESULT(boolean CONSULTA_RESULT) {
        this.CONSULTA_RESULT = CONSULTA_RESULT;
    }

    
    
    public ArrayList getID() {
        return ID;
    }

    public void setID(ArrayList ID) {
        this.ID = ID;
    }

    public ArrayList getGRADO() {
        return GRADO;
    }

    public void setGRADO(ArrayList GRADO) {
        this.GRADO = GRADO;
    }

    public ArrayList getESTADO() {
        return ESTADO;
    }

    public void setESTADO(ArrayList ESTADO) {
        this.ESTADO = ESTADO;
    }

    public ArrayList getSECCIONES() {
        return SECCIONES;
    }

    public void setSECCIONES(ArrayList SECCIONES) {
        this.SECCIONES = SECCIONES;
    }

    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    public void setERROR_MESSAGE(String ERROR_MESSAGE) {
        this.ERROR_MESSAGE = ERROR_MESSAGE;
    }

    
    
    
    
    
    
}
