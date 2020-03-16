package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCtransaction {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement statement = null;
		ResultSet res = null;
		String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		try {
			conn = DriverManager.getConnection(dbURL, "student", "student");
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			System.out.println("Salaries BEFORE\n");
			renderSalary(conn, "HR");
			renderSalary(conn, "Engineering");
			statement.executeUpdate("delete from employees where department='HR'");
			
			statement.executeUpdate("update employees set salary=30000 where department='Engineerning'");
			
			System.out.println("\n>> Transaction steps are ready.\n");
			
			boolean ok = askUserIfOkToSave();
			if(ok==true) {
				conn.commit();
				System.out.println("\n>> Transaction COMMITTED.\n");
			}else {
				conn.rollback();
				System.out.println("\n>> Transaction ROLLED BACK.\n");
			}
			
			System.out.println("Salaries AFTER\n");
			renderSalary(conn, "HR");
			renderSalary(conn, "Engineering");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(res, statement, conn);
		}
	}

	public static void renderSalary(Connection conn, String department) throws SQLException {
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			ps = conn.prepareStatement("select * from employees where department=?");
			ps.setString(1, department);
			res = ps.executeQuery();

			while (res.next()) {
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				Double salary = res.getDouble("salary");

				System.out.printf("%s %s %s %.2f\n", firstName, lastName, department, salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(res, ps, conn);
		}

	}

	public static boolean askUserIfOkToSave() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Is it ok to save? yes/no(any key press except 'yes')");
		String input = scanner.nextLine();
		scanner.close();
		if (input.equalsIgnoreCase("yes")) {
			return true;
		}
		return false;
	}

	public static void close(ResultSet res, Statement statement, Connection conn) throws SQLException {
		if (res != null) {
			res.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

}
