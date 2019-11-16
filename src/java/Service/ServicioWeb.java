/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Alumnos.Alumno;
import Alumnos.CAlumnos;
import Grados.CGrados;
import Grados.Grados;
import Materias.CMaterias;
import Materias.Materias;
import Secciones.CSecciones;
import Secciones.Secciones;
import Usuario.CUsuario;
import Usuario.Login;
import Usuario.Usuario;
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
        
        @WebMethod(operationName = "CreateUser")
        public Usuario CreateUser(@WebParam(name = "Usuario")String Nombre_Usuario,@WebParam(name = "Pass")String Password,
                @WebParam(name = "Nombre")String Nombre,@WebParam(name = "Apellido")String Apellido,@WebParam(name = "Correo")String Correo,
                @WebParam(name = "Nivel")int Nivel
        ){
            CUsuario cUsuario = new CUsuario();
            Usuario usuario = cUsuario.CrearUsuario(Nombre_Usuario, Password, Nombre, Apellido, Correo, Nivel);
            return usuario;            
        }
        
         @WebMethod(operationName = "CreateAlumno")
        public Alumno CreateAlumno(@WebParam(name = "nie")String nie,@WebParam(name = "Nombre")String Nombre,
                @WebParam(name = "Apellido")String Apellido,@WebParam(name = "Fecha_Matricula")String Fecha_Matricula,
                @WebParam(name = "ID_seccion")int ID_seccion,@WebParam(name = "Password")String Password
        ){
             CAlumnos cAlumnos = new CAlumnos();
             Alumno alumno = cAlumnos.CreateAlumno(nie, Nombre, Apellido, Fecha_Matricula, ID_seccion,Password);
             return alumno;        
        }

        
        @WebMethod(operationName = "CreateMateria")
        public Materias CreateMateria(@WebParam(name="Codigo")String Codigo ,@WebParam(name="Nombre")String Nombre){
            CMaterias cMaterias = new CMaterias();
            Materias materias = cMaterias.CrearMateria(Codigo, Nombre);
            return materias;
        }
        
        @WebMethod(operationName = "DeleteMateria")
        public Materias DeleteMateria(@WebParam(name ="ID_Materia")int ID_Materia){
            CMaterias cMaterias = new CMaterias();
            Materias materias = cMaterias.DeleteMaterias(ID_Materia);
            return materias;                    
        }
        
        @WebMethod(operationName = "ListMaterias")
        public Materias ListMaterias(){
            CMaterias cMateris = new CMaterias();
            Materias materias= cMateris.ListMaterias();
            return materias;
        }
        
        @WebMethod(operationName = "ValidarCodigoMateria")
        public Materias ValidarCodigoMateria(@WebParam(name="CODIGO")String CODIGO){
            CMaterias cMaterias = new CMaterias();
            Materias materias = cMaterias.ValidarCodigoMateria(CODIGO);
            return materias;
                    
        }
        @WebMethod(operationName = "ListarMateriasGrados")
        public Materias ListarMateriasGrados(@WebParam(name="ID_GRADO")int ID_Grado){
            CMaterias cMaterias = new CMaterias();
            Materias materias = cMaterias.ListarMateriasGrado(ID_Grado);
            return materias;
        }

        @WebMethod(operationName = "ListMateriasNotInGrados")
        public Materias ListMateriasNotInGrados(@WebParam(name="ID_GRADO")int ID_GRADO){
            CMaterias cMateris = new CMaterias();
            Materias materias= cMateris.ListMateriasNotInGradosMaterias(ID_GRADO);
            return materias;
        }
        
        
         @WebMethod(operationName = "CreateMateriaGrado")
        public Materias CreateMateriaGrado(@WebParam(name="ID_MATERIA")int ID_MATERIA ,@WebParam(name="ID_GRADO")int ID_GRADO){
            CMaterias cMaterias = new CMaterias();
            Materias materias = cMaterias.CreateGradoMateria(ID_MATERIA, ID_GRADO);
            return materias;
        }
        
          @WebMethod(operationName = "DeleteMateriaGrado")
        public Materias DeleteMateriaGrado(@WebParam(name="ID_MATERIA")int ID_MATERIA ,@WebParam(name="ID_GRADO")int ID_GRADO){
            CMaterias cMaterias = new CMaterias();
            Materias materias = cMaterias.DeleteGradoMateria(ID_MATERIA, ID_GRADO);
            return materias;
        }
       
 }

    
  

