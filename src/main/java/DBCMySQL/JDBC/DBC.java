package DBCMySQL.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBC implements AutoCloseable{
	static private Connection conn;
	private static DBC dbc;

	private DBC() {
		String url;
		String bd;
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("mySQL.props"));
			url = props.getProperty("url");
			bd = props.getProperty("bd");
			conn = DriverManager.getConnection(url + bd, props);
			System.out.println("conectado");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public DBC getInstance() {
		if (dbc == null)
			dbc = new DBC();
		return dbc;
	}

	static public Connection getConexion() {
		if (dbc == null)
			dbc = new DBC();
		return conn;
	}
	public void close() throws SQLException {
		if(dbc != null)
			conn.close();
		System.out.println("cierra");
	}
}
