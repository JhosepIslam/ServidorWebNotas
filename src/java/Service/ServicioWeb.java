/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Alumnos.Alumno;
import Alumnos.CAlumnos;
import Alumnos.CAlumnosP;
import Docentes.CDocentes;
import Docentes.Docente;
import Grados.CGrados;
import Grados.Grados;
import Materias.CMaterias;
import Materias.Materias;
import Secciones.CSecciones;
import Secciones.Secciones;
import Usuario.CUsuario;
import Usuario.Login;
import Usuario.Usuario;
import Alumnos.Alumnos;
import Evaluaciones.CEvaluaciones;
import Evaluaciones.Evaluaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

  
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
        
        //docentes
          @WebMethod(operationName = "GetListDocentes")
        public Docente GetListDocentes(){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.GetDocentes();           
            return docente;
        }
        
          @WebMethod(operationName = "DeleteDocente")
        public Docente DeleteDocente(@WebParam(name = "IdDocente")int IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.deleteDocente(IdDocente);           
            return docente;
        }       
         @WebMethod(operationName = "GetListGradosWithSecciones")
        public Grados GetListGradosWithSecciones(){
              CGrados cGrados = new CGrados();
              Grados grados = cGrados.GetGradosWithSecciones();              
            return grados;
        }
         @WebMethod(operationName = "GetMateriasWithoutDocenteBySeccion")
        public Materias GetMateriasWithoutDocenteBySeccion(@WebParam(name = "IdSeccion")int IdSeccion){
              CMaterias cMaterias = new CMaterias();
              Materias materias = cMaterias.GetMateriasWithoutDocenteBySeccion(IdSeccion);
            return materias;
        }
        
         @WebMethod(operationName = "InsertarMateriaDocente")
        public Materias InsertarMateriaDocente(@WebParam(name = "IdDocente")int IdDocente,@WebParam(name = "IdMateria")int IdMateria,@WebParam(name = "IdSeccion")int IdSeccion){
              CMaterias cMaterias = new CMaterias();
              Materias materias = cMaterias.InsertarMateriaDocente(IdDocente, IdMateria, IdSeccion);
            return materias;
        }
          @WebMethod(operationName = "GetMateriaDocente")
        public Docente GetMateriaDocente(@WebParam(name = "IdDocente")int IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getMateriasDocente(IdDocente);           
            return docente;
        }
        @WebMethod(operationName = "DeleteMateriaDocente")
        public Materias DeleteMateriaDocente(@WebParam(name = "IdMateriaDocente")int IdMateriaDocente){
              CMaterias cMaterias = new CMaterias();
              Materias materias = cMaterias.DeleteMateria_Docente(IdMateriaDocente);
            return materias;
        }
        
        
         @WebMethod(operationName = "getGradosByDocente")
        public Grados getGradosByDocente(@WebParam(name = "IdDocente")int IdDocente){
              CGrados cGrados = new CGrados();
              Grados grados = cGrados.GetGradosByDocente(IdDocente);              
            return grados;
        }
        @WebMethod(operationName = "getSeccionesByDocente")
        public Secciones getSeccionesByDocente(@WebParam(name = "IdDocente")int IdDocente,@WebParam(name = "IdGrado")int IdGrado){
              CSecciones cSecciones = new CSecciones();
              Secciones secciones = cSecciones.getSeccionesByDocente(IdGrado,IdDocente);              
            return secciones;
        }
        
        
        @WebMethod(operationName = "getIdDocente")
        public Docente getIdDocente(@WebParam(name = "Usuario")String  Usuario){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getIdDocente(Usuario);              
            return docente;
        }
        
        @WebMethod(operationName = "ListAlumnosfromSeccion")
        public Alumnos ListAlumnosfromSeccion(@WebParam(name = "IdSeccion")int IdSeccion){
            CAlumnosP cAlumnosP = new CAlumnosP();
            Alumnos alumnos = cAlumnosP.ListAlumnosFromSeccion(IdSeccion);
            return alumnos;
        }
        
        
        @WebMethod(operationName = "getMisSecciones")
        public Docente getMisSecciones(@WebParam(name = "IdDocente")int  IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getMisSecciones(IdDocente);
            return docente;
        }
        
        
        @WebMethod(operationName = "getSeccionesSinNotas")
        public Docente getSeccionesSinNotas(@WebParam(name = "IdDocente")int  IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getMisSeccionesSinNotas(IdDocente);
            return docente;
        }
        
        @WebMethod(operationName = "getSeccionesConNotas")
        public Docente getSeccionesConNotas(@WebParam(name = "IdDocente")int  IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getMisSeccionesConNotas(IdDocente);
            return docente;
        }
        @WebMethod(operationName = "getSeccionesConNotasRevision")
        public Docente getSeccionesConNotasRevision(@WebParam(name = "IdDocente")int  IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getMisSeccionesConNotasRevision(IdDocente);
            return docente;
        }
        @WebMethod(operationName = "getSeccionesConNotasRechazado")
        public Docente getSeccionesConNotasRechazado(@WebParam(name = "IdDocente")int  IdDocente){
              CDocentes cDocentes = new CDocentes();
              Docente docente = cDocentes.getMisSeccionesConNotasRechazado(IdDocente);
            return docente;
        }
        
        //evaluaciones
        
        @WebMethod(operationName = "setEvaluacion")
        public Evaluaciones setEvaluacion(@WebParam(name = "Num_Eval")int Num_Eval,@WebParam(name = "Inicio")String Inicio,@WebParam(name = "Fin")String Fin ){
            CEvaluaciones cEvaluaciones = new CEvaluaciones();
            Evaluaciones evaluaciones = cEvaluaciones.SetEvaluacion(Num_Eval, Inicio, Fin);
            return evaluaciones;                    
        }
        
         @WebMethod(operationName = "validarEvaluacion")
        public Evaluaciones validarEvaluacion(@WebParam(name = "Num_Eval")int Num_Eval,@WebParam(name = "Inicio")String Inicio,@WebParam(name = "Fin")String Fin ){
            CEvaluaciones cEvaluaciones = new CEvaluaciones();
            Evaluaciones evaluaciones = cEvaluaciones.validarEvaluacion(Num_Eval, Inicio, Fin);
            return evaluaciones;                    
        }
        @WebMethod(operationName = "DeleteEvaluacion")
        public Evaluaciones DeleteEvaluacion(@WebParam(name = "IdEval")int IdEval){
            CEvaluaciones cEvaluaciones = new CEvaluaciones();
            Evaluaciones evaluaciones = cEvaluaciones.DeleteEvaluacion(IdEval);
            return evaluaciones;                    
        }
        
        @WebMethod(operationName = "ListEvaluaciones")
        public Evaluaciones ListEvaluaciones(){
            CEvaluaciones cEvaluaciones = new CEvaluaciones();
            Evaluaciones evaluaciones = cEvaluaciones.ListEvaluaciones();
            return evaluaciones;                    
        }
        
        @WebMethod(operationName = "EvaluaciondeHoy")
        public Evaluaciones EvaluaciondeHoy(){
            CEvaluaciones cEvaluaciones = new CEvaluaciones();
            Evaluaciones evaluaciones = cEvaluaciones.getTodayEvaluation();
            return evaluaciones;                    
        }
        
 }

    
  

