package dbc.JDBC;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
		Connection c = DBC.getConexion();

    }
}
