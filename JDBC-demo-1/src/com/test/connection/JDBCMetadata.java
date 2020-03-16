package com.test.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMetadata {

	private static Connection conn = null;
	private static String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
	private static ResultSet res = null;

	public static void main(String[] args) throws SQLException {
		try {
			conn = DriverManager.getConnection(dbURL, "student", "student");
			DatabaseMetaData meta = conn.getMetaData();

			System.out.println("Meta data");
			System.out.println(meta.getDriverName());
			System.out.println(meta.getDatabaseMajorVersion());
			System.out.println(meta.getSQLKeywords());
			System.out.println(meta.getDatabaseProductName());
			System.out.println(meta.getMaxRowSize());

			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String[] types = null;

			res = meta.getTables(catalog, schemaPattern, tableNamePattern, types);

			while (res.next()) {
				System.out.println(res.getString("TABLE_NAME"));
			}

			String columnNamePattern = null;
			res = meta.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
			while (res.next()) {
				System.out.println(res.getString("COLUMN_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (res != null) {
				res.close();
			}

			if (conn != null) {
				conn.close();
			}
		}

	}

}
