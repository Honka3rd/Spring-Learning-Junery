package com.test.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCCLOBAndConfigFile {
	static Properties props = new Properties();
	static Connection conn = null;
	static PreparedStatement statement = null;
	static ResultSet res = null;
	static Statement retrievalStatement = null;
	static FileOutputStream output = null;

	public static void main(String[] args) throws SQLException, IOException {
		try {
			// connect using properties file
			props.load(new FileInputStream("resources/properties"));
			String dbURL = props.getProperty("dbURL");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("connected");

			// inject file
			File file = new File("resources/sample_resume.txt");
			FileReader reader = new FileReader(file);

			String sql = "update employees set resume=? where email='john.doe@foo.com'";
			statement = conn.prepareStatement(sql);
			statement.setCharacterStream(1, reader);
			statement.executeUpdate();
			System.out.println("file injected");

			// load file out
			sql = "select resume from employees where email='john.doe@foo.com'";
			retrievalStatement = conn.createStatement();
			res = retrievalStatement.executeQuery(sql);

			File text = new File("Text.txt");
			output = new FileOutputStream(text);
			if (res.next()) {
				Reader in = res.getCharacterStream("resume");
				int c;
				while ((c = in.read()) > 0) {
					output.write(c);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
			if (output != null) {
				output.close();
			}
		}
	}

}
