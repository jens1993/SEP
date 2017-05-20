package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnection {

        private Connection con = null;
        private Statement stmt = null;
        private String dbHost = "localhost"; // Hostname
        private String dbPort = "3306";      // Port -- Standard: 3306
        private String dbName = "test";   // Datenbankname
        private String dbUser = "test";     // Datenbankuser
        private String dbPass = "";      // Datenbankpasswort
        private String db_erstellung = "create table if not exists test12345 (t1 varchar(20))";
        private String db_nutzung = "USE Turnierverwaltung";


        SQLConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

                // Verbindung zur JDBC-Datenbank herstellen.
                con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "user=" + dbUser + "&" + "password=" + dbPass);
                System.out.println("Erfolg!");
                stmt = con.createStatement();
                stmt.executeUpdate(db_erstellung);

            } catch (ClassNotFoundException e) {
                System.out.println("Treiber nicht gefunden");
            } catch (SQLException e) {
                System.out.println("Verbindung nicht moglich");
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }

}
