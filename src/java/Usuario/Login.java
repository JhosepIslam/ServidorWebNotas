
package Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
     
    private  int Nivel = 0;

    public int getNivel() {
        return Nivel;
    }
        public Login( String Usuario, String Pass){
            Connection con = Conexiones.Conexion.getConection();
        
            
            

        try {
            CallableStatement sql = con.prepareCall("{call sp_login(?) }");
            sql.setString(1, Usuario);          
            ResultSet res = sql.executeQuery();

            if (res.next()) {
                String usuario = res.getString("NOMBRE_USUARIO");
                String pass = res.getString("CLAVE");
                int nivel = res.getInt("NIVEL");
                
                if (Usuario.equals(usuario) && Pass.equals(pass) ) {                    
                    Nivel = nivel;
                }else  Nivel =0;                
            }else  Nivel = 0;
           
        } catch (SQLException ex) {       
            Nivel = 0;
        }
        
        }
    
}
