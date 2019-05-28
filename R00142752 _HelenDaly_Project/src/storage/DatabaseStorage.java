package storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//
public class DatabaseStorage implements StorageIntface{
	// JDBC driver name and database URL
		/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/dental";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "";
		Connection conn;
		Statement stmt;
		ResultSet rs;
	
	@Override
	public boolean save(Object o) {
		//to save to database
		this.MakeConnection();
		this.executeUpdate(o.toString());
		this.CloseConnection();
		
		return false;
	}
	@Override
	public Object load() {
		this.MakeConnection();
		Object o = this.executeQueryForResults(o.toString());
		this.CloseConnection();
		// to load from database
		return o;
	};*/
}
