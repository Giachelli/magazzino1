import java.sql.*;
import javax.swing.*;

public class sqlConnection {
	Connection conn = null;
	
	public static Connection dbConnector() {
		try
		{
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			String db= "jdbc:mysql://localhost:3306/OOP1617";
			Connection conn = DriverManager.getConnection(db,"root","root");
			//JOptionPane.showMessageDialog(null, "Connessione Riuscita!");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}	

	}
}
