package Controller;

import java.awt.event.ActionEvent;





import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.connectiondb.*;

import Controller.LoginController.LoginListener;
import Controller.ProdottoController.ProdottoListener;
import Model.LoginModel;
import View.LoginView1;
import com.application.*;
import Model.DipendenteModel;
import View.DipendenteView;
import net.proteanit.sql.DbUtils;

public class DipendenteController {
	
		private DipendenteModel model;
		public ResultSet rs;   
	    private DipendenteView view;
	    Connection connection = null;
	    
	    public DipendenteController(DipendenteView view){
	        this.view = view;
	        
	        view.addNomeDipendenteListener(new DipendenteListener());
	    }
	    
	    class DipendenteListener implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		connection=sqlConnection.dbConnector();
	 
	    		String nome;
	    		String cognome;
	    		
	 
	    			model=view.getDipendente();
	    			nome=model.getNomeDipendente();
	    	
	    			String sql ="select * from dipendente where nome='"+nome+"' or cognome='"+nome+"'order by data_assunzione";
	    			try {
						Statement st=connection.createStatement();
						rs=st.executeQuery(sql);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					view.table1.setModel(DbUtils.resultSetToTableModel(rs));
	                
	    }
	    
	    }
	}


