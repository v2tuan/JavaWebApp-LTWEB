package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
    private final String serverName = "V2-TUANS";
    private final String dbName = "LTWEB";
    private final String portnumber = "1433";
    private final String instance = "MSSQLSERVER"; // can empty if there is only one instance of SQL Server
    private final String username = "sa";
    private final String password = "1234567890";

    public Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portnumber + ";instanceName=" + instance
                    + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:sqlserver://" + serverName + ":" + portnumber + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
            // Check if connection is successful
            if (conn != null) {
//				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//				System.out.println("Driver name: " + dm.getDriverName());
//				System.out.println("Driver version: " + dm.getDriverVersion());
//				System.out.println("Product name: " + dm.getDatabaseProductName());
//				System.out.println("Product version: " + dm.getDatabaseProductVersion());
                return conn;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    // test run: right click -> Run as -> Java application
    public static void main(String[] args) {
        try {
            Connection conn = new DBConnectSQL().getConnection();
            if (conn != null) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection.");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
