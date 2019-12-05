
package Evaluaciones;

import java.util.ArrayList;

public class Evaluaciones {
    
    
    private ArrayList ID_EVALUACION,NUMERO_EVALUACION,INICIO,FIN,ESTADO;
    private boolean RESULT;

    public ArrayList getID_EVALUACION() {
        return ID_EVALUACION;
    }

    public void setID_EVALUACION(ArrayList ID_EVALUACION) {
        this.ID_EVALUACION = ID_EVALUACION;
    }

    public ArrayList getNUMERO_EVALUACION() {
        return NUMERO_EVALUACION;
    }

    public void setNUMERO_EVALUACION(ArrayList NUMERO_EVALUACION) {
        this.NUMERO_EVALUACION = NUMERO_EVALUACION;
    }

    public ArrayList getINICIO() {
        return INICIO;
    }

    public void setINICIO(ArrayList INICIO) {
        this.INICIO = INICIO;
    }

    public ArrayList getFIN() {
        return FIN;
    }

    public void setFIN(ArrayList FIN) {
        this.FIN = FIN;
    }

    public ArrayList getESTADO() {
        return ESTADO;
    }

    public void setESTADO(ArrayList ESTADO) {
        this.ESTADO = ESTADO;
    }

    public boolean isRESULT() {
        return RESULT;
    }

    public void setRESULT(boolean RESULT) {
        this.RESULT = RESULT;
    }
    
    
}
