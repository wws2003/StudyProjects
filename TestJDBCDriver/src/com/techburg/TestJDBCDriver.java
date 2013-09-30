package com.techburg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBCDriver {
	public static void main(String[] args) {
		 String userName="root";
		 String password="1";
		 String host="localhost";
		 String port = "3306";
		 Connection conn;
		 
		// Attempt to load database driver
		try
		{
			String url = "jdbc:mysql://"+host + ":"  + port ;
			System.out.println(url);
			//Load driver, DI is right here !
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();

			conn = DriverManager.getConnection (url, userName, password);
		}
		catch (ClassNotFoundException cnfe) // driver not found
		{
			conn=null;
			System.err.println ("Unable to load database driver" + cnfe.getMessage());
			//throw new DatabaseConnectionException(cnfe);
		} 
		catch(InstantiationException ie)
		{
			conn=null;
			System.err.println ("Unable to Create database driver" + ie.getMessage());
			//throw new DatabaseConnectionException(ie); 
		}
		catch (IllegalAccessException iae)
		{
			conn=null;
			System.err.println ("Unable to Create database driver " + iae.getMessage());
			//throw new DatabaseConnectionException(iae);
		} catch (SQLException sqle) {
			conn=null;
			System.err.println ("SQL error" + sqle.getMessage());
			//throw new DatabaseConnectionException(sqle);
		}

		if (conn!=null)
		{
			System.out.println ("Database connection established"); 
			return;
		}
		else
		{
			System.err.println ("Database connection Failed"); 
			return;
		}

	}
}
