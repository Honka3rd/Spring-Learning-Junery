package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest {
	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, "student", "student");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			// myStmt = myConn.createStatement();
//			int rowAffected = myStmt.executeUpdate(
//					"insert into employees" + "(`id`,`last_name`,`first_name`,`email`, `department`, `salary`)"
//							+ "values" + "(13,'Fire','on','go.Fires@foo.com', 'Legal', 98000.00)");
//			System.out.println("insert: " + rowAffected + " Row(s) affected");

//			int rowAffected = myStmt
//					.executeUpdate("update employees " + "set email='someone@gmail.com' " + "where id=1");
//			System.out.println("update: " + rowAffected + " Row(s) affected");

//			int rowAffected = myStmt.executeUpdate("delete from employees where first_name='on' and last_name='Fire'");
//			System.out.println("delete: " + rowAffected + " Row(s) affected");
			// 3. Execute SQL query
			// myRs = myStmt.executeQuery("select * from employees");

			// 4. Process the result set
//			while (myRs.next()) {
//				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + ", " + myRs.getString("email"));
//			}
			myStmt = myConn.prepareStatement("select * from employees where salary>? and department=?");
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + ", "
						+ myRs.getString("email"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}
	}
}
