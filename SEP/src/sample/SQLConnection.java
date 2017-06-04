package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnection 
{

        private Connection con = null;
        private Statement stmt = null;
        private String dbHost = "localhost"; // Hostname
        private String dbPort = "3306";      // Port -- Standard: 3306
        private String dbName = "test";   // Datenbankname
        private String dbUser = "test";     // Datenbankuser
        private String dbPass = "";      // Datenbankpasswort
        private String db_erstellung = "create table if not exists test12345 (t1 varchar(20))";
        private String db_nutzung = "USE Turnierverwaltung";


        public SQLConnection() //eventuell nich pub
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber fÃ¼r JDBC Schnittstellen laden.

                // Verbindung zur JDBC-Datenbank herstellen.
                con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "user=" + dbUser + "&" + "password=" + dbPass); //con muss unbedingt irgendwo geschlossen werden
                System.out.println("Erfolg!");
                stmt = con.createStatement();
                stmt.executeUpdate(db_erstellung);

            } catch (ClassNotFoundException e) 
            {
                System.out.println("Treiber nicht gefunden");
            } catch (SQLException e) 
            {
                System.out.println("Verbindung nicht moglich");
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }

        public ResultSet executeSQL(String sql)
        {
        	try
        	{
        		Statement smt = con.createStatement();
        		
        		ResultSet res = stmt.executeQuery(sql);

        		return res;
        		
        	}
        	catch (SQLException e)
        	{
        		e.printStackTrace();
        	}
        	return null;
        }
        public int getSpielerID(String firstname, String lastname)
        {
        	String sql = "SELECT ID,vorname, nachname FROM Spieler";
        	ResultSet r = executeSQL(sql);
        	try {
        		while(r.next())
        		{
        			if(firstname.equals(r.getString(1))&&lastname.equals(r.getString(2))) //Spalte 1 = firstname
        			{
        				return r.getInt(1);
        			}
        		}
        		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return -1; //Überprüfung in main, ob nicht -1 return
        }
        public void PrintResult(ResultSet r) //als boolean machen, um zu prüfen ob erfolgreich (gilt für alle void sql klassen!) Booleans immer weiterleiten und ganz am ende ausgeben ob erfolgreich 
        {
        	try {
				while(r.next())
				{
					int maxColoums = r.getMetaData().getColumnCount();
					String print = "";
					for(int i =0; i<maxColoums; i++) //eventuell bei 1 starten
					{
						print += " ";
						print += r.getMetaData().getColumnName(i);
						print += " = ";
						print += r.getString(i);
					}
					System.out.println(print);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        public void insertSpieler (String firstname, String lastname)
        {
        	
        	
        	ResultSet r = executeSQL("SELECT * FROM TABELLE");
        	int index = 0;
        	try {
				if(r.last())
				{
					index = r.getInt(0);// ID vom letzten Objekt (Spalte 0)
				}
				/*Wenn if(r.last()) nicht funktioniert
				 * 
				 while(r.next())
				 {
				 	if(r.getInt(1)>index {
				 	index=r.getInt(1);
				 }
				 
				 */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				r.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		String sql = "INSERT INTO TABELLENNAME VALUES (?,?,?,?)"; //für jede Spalte ein "?", prepared Statements zur Verhinderung von SQL Injection
    		try {
				PreparedStatement prep = con.prepareStatement(sql);
				prep.setInt(0, index); //ID wird gesetzt
				prep.setString(1, firstname);
				prep.setString(2, lastname);
				//...
				prep.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		finally
    		{
    			prep.close();
    		}
        	
        	
        	//ResultSet r = executeSQL(sql);
        }
        
        /*
        public void selectAll()
        {
        	try
        	{
        		Statement smt = con.createStatement();
        		String sql = "Select * FROM Tabelle";
        		ResultSet res = stmt.executeQuery(sql);
        		while(res.next())
        		{
        			String id = res.getString(1);
        			String name = res.getString(2);
        		}
        		res.close();
        		stmt.close();
        		
        	}
        	catch (SQLException e)
        	{
        		e.printStackTrace();
        	}
        }
        */
        
}
