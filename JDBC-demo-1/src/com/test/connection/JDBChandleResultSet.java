package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;

public class JDBChandleResultSet {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		CallableStatement statement = null;
		String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		ResultSet res = null;
		
		try {
			conn = DriverManager.getConnection(dbURL, "student", "student");
			statement = conn.prepareCall("call get_employees_for_department(?)");
			statement.setString(1, "Engineering");
			statement.execute();
			res = statement.getResultSet();
			while(res.next()) {
				System.out.println(res.getString("first_name"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(res != null) {
				res.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
	}

}
