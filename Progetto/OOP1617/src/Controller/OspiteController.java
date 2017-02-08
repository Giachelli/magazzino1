package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import com.connectiondb.*;
import Model.LoginModel;
import Model.OspiteModel;
import View.LoginView;
import View.OspiteView;
import net.proteanit.sql.DbUtils;
import Controller.LoginController;

/**
 * Classe OspiteController.java
 * Questa classe ci permette di implementate, richiamando il model, tutte le azioni dei pulsanti
 * realizzati nella view.
 *     
 * @author Iezzi Valerio
 *
 */
public class OspiteController {
	private OspiteModel model;
	private OspiteView view;
	public ResultSet rs;   
	public String id;
    Connection connection = null;
    public JLabel labelLogin;
    public String label;
    
    public OspiteController(OspiteView view){
    	
    	this.view = view;
        connection=sqlConnection.dbConnector();
        view.addCaricaListener(new VisualizzaProdotti());
        view.addCercaNomeListener(new CercaNomeProdotto());
        view.addCercaOfferteListener(new CercaOfferte());
        view.addCercaSettoreListener(new CercaProdottoSettore());
        view.addLogoutListener(new Logout());
    }
   
    class VisualizzaProdotti implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		String sql ="select * from prodotto where reparto='Utility' or reparto='Alimentare'";
    		try {
    			
    			PreparedStatement pst = connection.prepareStatement(sql);
    			ResultSet rs=pst.executeQuery(sql);
    			view.table.setModel(DbUtils.resultSetToTableModel(rs));
    			pst.close();
    			rs.close();
    		} catch (SQLException e1) {
    			
    			e1.printStackTrace();
    		}
        	
    		
    	}
    }
    
    class CercaNomeProdotto implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String nome;
 
    			model=view.getProdotto();
    			nome=model.getNome();
    			String sql ="select * from prodotto where nome='"+nome+"' order by prezzo";
    			try {
					Statement st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				view.table.setModel(DbUtils.resultSetToTableModel(rs));
                
    }}
    
    class CercaProdottoSettore implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String settore;
 
    			model=view.getProdotto();
    			settore=model.getSettore();
    			String sql ="select * from prodotto where settore='"+settore+"' ORDER BY qta ASC";
    			try {
					Statement st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				view.table.setModel(DbUtils.resultSetToTableModel(rs));
                
    }}
    
    class CercaOfferte implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    			String sql ="select * from prodotto where offerta='1' ORDER BY fine_offerta ASC";
			try {
				Statement st=connection.createStatement();
				rs=st.executeQuery(sql);
			} catch (SQLException e2) {
				
				e2.printStackTrace();
			}
			
			view.table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
                
    }
    
   
    
   
    class Logout implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		try {
				connection.close();
				view.frameOspite.dispose();
				
				LoginView theView = new LoginView();
				@SuppressWarnings("unused")
				LoginModel theModel = new LoginModel(); 
				@SuppressWarnings("unused")
				LoginController theController = new LoginController(theView);
				
				theView.frameLogin.setVisible(true);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
    		
    	}
   }
    
}
