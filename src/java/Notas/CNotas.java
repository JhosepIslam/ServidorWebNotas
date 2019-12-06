
package Notas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class CNotas {
    Connection con = Conexiones.Conexion.getConection();
    
    public Notas subirNotasARevision(String FilePath,int IdMateriaDocente){
        Notas notas = new Notas();
         try {
            CallableStatement sql = con.prepareCall("{call SP_INSERTAR_NOTA_EXCEL(?,?)}");
            sql.setInt(1, IdMateriaDocente);
            sql.setString(2, FilePath);
            sql.execute();
            notas.setRESULT(true);
        } catch (SQLException e) {
            notas.setRESULT(true);
        }
        return notas;
    }
    
    public Notas cancelarRevisionNotas(int IdMateriaDocente){
        Notas notas = new Notas();
        try {
            CallableStatement sql = con.prepareCall("{call SP_CANCELAR_REVISION_NOTAS(?)}");
            sql.setInt(1, IdMateriaDocente);
            sql.execute();
        } catch (SQLException e) {
        }
        return notas;
    }
    
    
}