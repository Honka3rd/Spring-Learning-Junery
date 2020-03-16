package com.test.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBChandleout {

	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		Connection conn = null;
		CallableStatement statement = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, "student", "student");
			statement = conn.prepareCall("{call get_count_for_department(?, ?)}");
			statement.setString(1, "Engineering");
			statement.registerOutParameter(2, Types.INTEGER);
			statement.execute();
			int count = statement.getInt(2);
			System.out.println(count);
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
