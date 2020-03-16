package com.test.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBLOB {

	private static Connection conn = null;
	private static String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";

	public static void main(String[] args) throws SQLException {
		String sql = "update employees set resume=? where email='john.doe@foo.com'";
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			// write
			conn = DriverManager.getConnection(dbURL, "student", "student");
			statement = conn.prepareStatement(sql);
			File file = new File("resources/body-asm2.png");
			FileInputStream input = new FileInputStream(file);
			statement.setBinaryStream(1, input);
			statement.executeUpdate();
			System.out.println("file injected");

			// read
			File profile = new File("retrieved_profile.png");
			FileOutputStream output = new FileOutputStream(profile);

			sql = "select resume from employees where email='john.doe@foo.com'";
			Statement retrievalStatement = conn.createStatement();
			res = retrievalStatement.executeQuery(sql);

			if (res.next()) {
				InputStream in = res.getBinaryStream("resume");
				byte[] buffer = new byte[1024];
				while (in.read(buffer) > 0) {
					output.write(buffer);
				}
				System.out.println("\nSaved to file: " + profile.getAbsolutePath());

				System.out.println("\nCompleted successfully!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

}
