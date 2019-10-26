/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
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
        ResultSet res =Conexiones.Conexion.Consulta("exec sp_login "+"'"+Usuario+"'");    

        try {
            if (res.next()) {
                String usuario = res.getString("NOMBRE_USUARIO");
                String pass = res.getString("CLAVE");
                int nivel = res.getInt("NIVEL");
                
                if (Usuario.equals(usuario) && Pass.equals(pass) ) {                    
                    return nivel;
                }else  return -0;                
            }else  return -0;
           
        } catch (SQLException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
            return  0;
        }
        
        
        
    }

    
  
}
