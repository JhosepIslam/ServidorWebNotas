/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Conversiones.Convertor;
import Grados.CGrados;
import Grados.Grados;
import Secciones.CSecciones;
import Secciones.Secciones;
import Usuario.Login;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    /**
     * This is a sample web service operation
     * @param Usuario
     * @param Pass
     * @return 
     */
    
  
    @WebMethod(operationName = "login")
    public int Login(String Usuario , String Pass) {
        
        Login login = new Login(Usuario,Pass);
        
        return login.getNivel();
    } 
        
       @WebMethod(operationName="GetNiveles")
        public String GetNiveles(){
            ResultSet res = Conexiones.Conexion.Consulta("SP_GET_NIVELES");
            try {
                String JSONNiveles = Conversiones.Convertor.convertToJSON(res);   
                return JSONNiveles;
                
           } catch (Exception e) {
           }
            return null;
            
        }       
        
         @WebMethod(operationName="GetUsuarioIfExits")
        public boolean GetUsuarioIfExits(String Usuario){
            ResultSet res = Conexiones.Conexion.Consulta("SP_GET_USER '"+Usuario+"'");
            try {
                if (res.next()) {
                    return true;
                }
           } catch (SQLException e) {
           }
            return false;
            
        } 
        
        @WebMethod(operationName="GetCarnetIfExists")
        public boolean GetCarnetIfExists(String Carnet){
            ResultSet res = Conexiones.Conexion.Consulta("SP_GET_ALUMNO '"+Carnet+"'");
             try {
                if (res.next()) {
                    return true;
                }
           } catch (SQLException e) {
           }
            return false;
            
        }
        
        @WebMethod(operationName="GetGrados")
        public Grados GetGrados(){ 
            CGrados cGrados = new CGrados();
            Grados grados = cGrados.ListGrados();
            return grados;
            
        }
        
        @WebMethod(operationName="GetSecciones")
        public Secciones GetSecciones(int id_grado){
            CSecciones cSecciones = new CSecciones();
            Secciones secciones = cSecciones.getSecciones(id_grado);
            return secciones;            
        }
        
        @WebMethod(operationName="GetListGrados_Info")
        public Grados GetListGrados_Info(){
             CGrados cGrados = new CGrados();
            Grados grados = cGrados.GetListGrados_Info();
            return grados;
            
        }
        
        @WebMethod(operationName = "DeleteGrado")
        public Grados DelGrados(int id_grado){
            CGrados cGrados = new CGrados();
            Grados grados = cGrados.DeleteGrados(id_grado);
            return grados;
            
        }
        
        @WebMethod(operationName = "CreateGrado")
        public Grados CreateGrado(String Grado){
            CGrados cGrados = new CGrados();
            Grados grados = cGrados.CreateGrado(Grado.toUpperCase());
            return grados;
        }
        
        @WebMethod(operationName = "CreateSeccion")
        public Secciones CreateSeccion(int Id_Grado,String Seccion){
            CSecciones cSecciones = new CSecciones();
            Secciones secciones = cSecciones.CreateSeccion(Id_Grado, Seccion.toUpperCase());
            return secciones;
                    
        }
        
        @WebMethod(operationName = "UpdateNombreGrado")
        public Grados UpdateNombreGrado(int ID, String Grado){
            CGrados cGrados = new CGrados();
            Grados grados = cGrados.UpdateGrado(ID, Grado.toUpperCase());
            return grados;
        }
        
        @WebMethod(operationName = "DeleteSeccion")
        public Secciones DeleteSeccion(@WebParam(name = "ID") int ID){
            CSecciones cSecciones = new CSecciones();
            Secciones secciones = cSecciones.DeleteSeccion(ID);
            return secciones;
                    
        }
        
        
 }

    
  

