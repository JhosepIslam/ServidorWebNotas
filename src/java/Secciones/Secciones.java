/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secciones;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Secciones {
    private ArrayList ID_SECCION = new ArrayList();
    private ArrayList ID_GRADO = new ArrayList();
    private ArrayList SECCION = new ArrayList();
    private ArrayList ESTADO = new ArrayList();

     private String ERROR_MESSAGE;
     private boolean RESP_CONSULTA;

    public boolean isRESP_CONSULTA() {
        return RESP_CONSULTA;
    }

    public void setRESP_CONSULTA(boolean RESP_CONSULTA) {
        this.RESP_CONSULTA = RESP_CONSULTA;
    }
     

    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    public void setERROR_MESSAGE(String ERROR_MESSAGE) {
        this.ERROR_MESSAGE = ERROR_MESSAGE;
    }
     
     
    public ArrayList getID_SECCION() {
        return ID_SECCION;
    }

    public void setID_SECCION(ArrayList ID_SECCION) {
        this.ID_SECCION = ID_SECCION;
    }

    public ArrayList getID_GRADO() {
        return ID_GRADO;
    }

    public void setID_GRADO(ArrayList ID_GRADO) {
        this.ID_GRADO = ID_GRADO;
    }

    public ArrayList getSECCION() {
        return SECCION;
    }

    public void setSECCION(ArrayList SECCION) {
        this.SECCION = SECCION;
    }

    public ArrayList getESTADO() {
        return ESTADO;
    }

    public void setESTADO(ArrayList ESTADO) {
        this.ESTADO = ESTADO;
    }
    
    
    
    
    
}
