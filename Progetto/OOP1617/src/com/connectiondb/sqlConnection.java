package com.connectiondb;

import java.sql.*;

import javax.swing.*;

/**
 * Classe sqlConnection.java
 * Permette di creare la connessione con il database,
 * andando a definire il tipo di database attraverso il driver,
 * il link e il nome del db, con i relativi nome utente e password per l'accesso.
 * Con il blocco try/catch, se la connessione non va a buon fine, viene gestita l'eccezzione
 * con un messaggio di errore.
 * 
 * @author Iezzi Valerio
 *
 */
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
