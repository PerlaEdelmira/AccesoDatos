package controlador;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import conexionBD.ConexionBD;
import modelo.Alumno;
public class AlumnoDAO {
	//metodo que permite realizar las Altas, Bajas, Cambios y Consultas
	
	public boolean agregarAlumno(Alumno a) {
			//INSERT INTO Alumnos VALUES("1","1","1","1",1,1,"1");
		//String sql = "INSERT INTO Alumnos VALUES(\"1\",\"1\",\"1\",\"1\",1,1,\"1\")";
		//String sql2 = "INSERT INTO Alumnos VALUES('2', '2', '2', '2', 1, 1, '1')";
		String sql3 = "INSERT INTO Alumnos VALUES('"+ a.getNumControl()+"', '"+ a.getNombre()+"', '"+a.getPrimerAp()
									+"', '" +a.getSegundoAp()+"', "+a.getEdad()+", "+a.getSemestre()+", '"+a.getCarrera()+"')";
		ConexionBD conexion = new ConexionBD();
		return conexion.ejecutarInstruccion(sql3);
		
	}
	public boolean eliminarAlumno(String nc) {
		String sql = "DELETE FROM alumnos WHERE"+ nc;
		ConexionBD conexion = new ConexionBD();
		return conexion.ejecutarInstruccion(sql);
	}
	public boolean modificarAlumno(Alumno a) {
		String sql = "UPDATE alumnos SET edad=3, semestre='3', carrera='3' WHERE NumControl='3'";
		return false;
	}
	//================ BUSCAR REGISTRO ===============
	public Alumno buscarAlumno(String numControl) {
		Alumno alumno = new Alumno();
		//SELECT * FROM alumnos WHERE NumControl = '1'
		String sql = "SELECT * FROM alumnos WHERE NumControl = '" + numControl+"'";
		ConexionBD conexion = new ConexionBD();
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			rs.last(); //se ubica en el ultimo registro
			alumno.setNumControl(rs.getString(1));
			alumno.setNombre(rs.getString(2));
			alumno.setPrimerAp(rs.getString(3));
			alumno.setSegundoAp(rs.getString(4));
			alumno.setEdad(rs.getByte(5));
			alumno.setSemestre(rs.getByte(6));
			alumno.setCarrera(rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return alumno;
		
	}
	
	//================ BUSCAR MULTIPLES REGISTROS ===========
	public ArrayList<Alumno>buscarAlumnos(String filtro){
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		//RECORRER el ResultSet mientras haya registro
		//SELECT * FROM alumnos
		Alumno alumno = new Alumno();
		String sql = "SELECT * FROM alumnos WHERE NumControl = '" + filtro +"'";
		ConexionBD conexion = new ConexionBD();
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);		
		try {
			rs.first();//CICLO
			Iterator i = listaAlumnos.iterator();
			while(i.hasNext()) {
				((Alumno)i.next()).setNumControl(rs.getString(1));
				((Alumno)i.next()).setNombre(rs.getString(2));
				alumno.setPrimerAp(rs.getString(3));
				alumno.setSegundoAp(rs.getString(4));
				alumno.setEdad(rs.getByte(5));
				alumno.setSemestre(rs.getByte(6));
				alumno.setCarrera(rs.getString(7));
				
				listaAlumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
	}
	public ArrayList<Alumno>consultasAlumnos(String caracter, ActionEvent e){
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		Alumno alumno = new Alumno();
		String sql = "SELECT * FROM alumnos WHERE " + e.getSource() + "='" + caracter +"'";
		ConexionBD conexion = new ConexionBD();
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		
		
		
		return listaAlumnos;
		
	}
}
