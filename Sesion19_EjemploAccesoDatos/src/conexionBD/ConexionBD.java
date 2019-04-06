package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private Connection conexion;
	private Statement stm;
	private PreparedStatement pstm; //para su proyecto final, evitar SQL Injection
	
	ResultSet rs = null;
	public ConexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
									  //127.0.0.1
			String url = "jdbc:mysql://localhost/BD_Escuela1?useTimezone=true&serverTimezone=UTC";
															//Contraseña itsj
			conexion = DriverManager.getConnection(url,"root","per/.5la");
			
			System.out.println();
			System.out.println("Magia Magia con BD, ya casi soy ISC =)");
		} catch (ClassNotFoundException e ){
			System.out.println("No se Encontro el Controlador");
			System.out.println("Mejor me Dedico a las Redes ='(");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se Pudo Conectar al Servidor");
			System.out.println("Mejor me Dedico a las Redes ='(");
		}finally {
			//codigo que SIEMPRE SE EJECUTA
			//Cierre de la conexion a la BD, no se recomienda
		}
	}//constrctor
	public void cerrarConexion() {
		try {
			stm.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//metodos que ejecutan las operaciones ABCC (DDL, DML Y SQL)
	//Un metodo para DDL y DML
	//otro metodo para SQL
	
	public boolean ejecutarInstruccion(String sql) {
		try {
			stm = conexion.createStatement();
			int ejecucion;
			ejecucion = stm.executeUpdate(sql);
			return ejecucion == 1? true:false;
		} catch (SQLException e) {
			System.out.println("No se ejecuto la instruccion SQL");
			return false;
		}
	}
	//otro metodo para SQL (CONSULTAS)
	public ResultSet ejecutarConsultaRegistros(String sql) {
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("No se ejecuto la instruccion SQL");
		}
		return rs;
	}
	//public static void main(String[] args) {
	//	new ConexionBD();
	//}
}//class Conexion
