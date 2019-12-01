/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

public class Usuario {    

    private String NOMBRE_USUARIO;
    private String PASSWORD,NOMBRE,APELLIDO,CORREO;
    
    private int NIVEL,CODIGO_DOCENTE, ID_USUARIO;
    private boolean RESULT;

    public boolean isRESULT() {
        return RESULT;
    }

    public void setRESULT(boolean RESULT) {
        this.RESULT = RESULT;
    }
    

    public String getNOMBRE_USUARIO() {
        return NOMBRE_USUARIO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public int getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(int NIVEL) {
        this.NIVEL = NIVEL;
    }

    public int getCODIGO_DOCENTE() {
        return CODIGO_DOCENTE;
    }

    public void setCODIGO_DOCENTE(int CODIGO_DOCENTE) {
        this.CODIGO_DOCENTE = CODIGO_DOCENTE;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }
    

    public void setNOMBRE_USUARIO(String NOMBRE_USUARIO) {
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
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
    
    
    
}
