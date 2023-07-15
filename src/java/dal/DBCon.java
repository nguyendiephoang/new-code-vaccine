/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

	public static String DRIVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String DBURL = "jdbc:sqlserver://localhost:1433;databaseName=vaccine;encrypt=false";
	public static String USERDB = "sa";
	public static String PASSDB = "123";

	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName(DRIVERNAME);
			conn = DriverManager.getConnection(DBURL, USERDB, PASSDB);
			System.out.println("Connect database success!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
        
        
        
        public static void main(String[] args) {
        try {
            System.out.println(new DBCon().getConnect());
        } catch (Exception e) {
        }
    }
}
