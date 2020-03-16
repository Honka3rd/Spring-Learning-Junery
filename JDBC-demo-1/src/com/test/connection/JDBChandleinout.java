package com.test.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBChandleinout {

	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		Connection conn = null;
		CallableStatement statement = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, "student", "student");
			statement = conn.prepareCall("{call greet_the_department(?)}");
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setString(1, "Engineering");
			statement.execute();
			String res = statement.getString(1);
			System.out.println(res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(statement != null) {
				statement.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}

	}

}
