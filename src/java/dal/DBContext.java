package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

	public static String DRIVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String DBURL = "jdbc:sqlserver://DESKTOP-TQLTGJM:1433;databaseName=vaccine3.0;encrypt=false";
	public static String USERDB = "sa";
	public static String PASSDB = "sa";

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
            System.out.println(new DBContext().getConnect());
        } catch (Exception e) {
        }
    }
}
