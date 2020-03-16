package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class JDBCstoredProcedure {
	

	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		Connection conn = null;
		CallableStatement statement = null;
		ResultSet resSet = null;
		
		try {
			
			conn = DriverManager.getConnection(dbUrl, "student", "student");
			System.out.println("before");
			showSalaries(conn, "Engineering");
			statement = conn.prepareCall("{call increase_salaries_for_department(?, ?)}");
			statement.setString(1, "Engineering");
			statement.setDouble(2, 10000);
			statement.execute();
			System.out.println("----------");
			System.out.println("after");
			showSalaries(conn, "Engineering");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (resSet != null) {
				resSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conn != null) {
				conn.close();
			}
		}
		
	}
	
	private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select * from employees where department=?");

			myStmt.setString(1, theDepartment);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
