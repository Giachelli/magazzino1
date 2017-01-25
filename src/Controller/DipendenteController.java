package Controller;

import java.awt.event.ActionEvent;







import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.connectiondb.*;

import Controller.ProdottoController.ModificaProdotto;

import com.application.*;
import Model.DipendenteModel;
import Model.LoginModel;
import Model.ProdottoModel;
import Model.TurniModel;
import View.DipendenteView;
import View.LoginView;
import View.ProdottoView;
import View.TurniView;
import net.proteanit.sql.DbUtils;

public class DipendenteController {
	
		private DipendenteModel model;
		public ResultSet rs;   
	    private DipendenteView view;
	    Connection connection = null;
		public String id;

	    
	    public DipendenteController(DipendenteView view){
	        this.view = view;
	        connection=sqlConnection.dbConnector();
	        view.addNomeDipendenteListener(new DipendenteListener());
	    	view.addCercaMansioneListener(new CercaMansioneListener());
	    	view.addInserisciDipendenteListener(new InserisciDipendenteListener());
	    	view.addModificaListener(new ModificaDipendente());
	    	view.addCaricaListener(new CaricaDipendenti());
		    view.addCaricaListener_1(new CaricaDipendenti_1());
		    view.Logout(new Logout());
		    view.prodottoView(new prodottoView());
		    view.turniView(new turniView());
	    } 
	    
	    class turniView implements ActionListener {
	    	public void actionPerformed(ActionEvent e){
	    		
	    		TurniView theView = new TurniView();
	    		TurniModel theModel= new TurniModel(); 
	    		TurniController theController= new TurniController(theView);
	    		theController.id=id;
	    		theView.frameTurni.setVisible(true);
	    		view.frameDipendente.dispose();
				
	    		
	    }}
	    
	    class prodottoView implements ActionListener {
	    	public void actionPerformed(ActionEvent e){
	    		
	    		ProdottoView theView = new ProdottoView();
	    		ProdottoModel theModel= new ProdottoModel(); 
	    		ProdottoController theController= new ProdottoController(theView);
	    		theController.id=id;
	    		theView.frameProdotto.setVisible(true);
	    		view.frameDipendente.dispose();
				
	    		
	    }}
	    
	    class Logout implements ActionListener {
	    	public void actionPerformed(ActionEvent e){
	    		
				try {
					connection.close();
					view.frameDipendente.dispose();
					
					LoginView theView = new LoginView();
					LoginModel theModel = new LoginModel(); 
					LoginController theController = new LoginController(theView);
					
					theView.frameLogin.setVisible(true);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
	    		
	    }}
	    
	    class CaricaDipendenti implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		connection=sqlConnection.dbConnector();

	    		String mansione;
	    		String nome;
	    		String sql;
	    		
	    		model=view.getDipendente4();
	    		mansione=model.getMansione();
	    		nome=model.getNomeDipendente();
	    		
	    		if(nome.equals("")==true){
	    			sql ="select * from dipendente where mansione='"+mansione+"' ";
	    			
	    		}
	    		
	    		 else if(mansione.equals("")==true){
	    			 sql="select * from dipendente where nome='"+nome+"' or cognome='"+nome+"'order by data_assunzione";	
	    		}
	    		
	    		    else{
	    		    	 sql="select * from dipendente where mansione='"+mansione+"' and nome='"+nome+"' ";
	    		    }

	    		try {
	    		
	    		PreparedStatement pst = connection.prepareStatement(sql);
	    		ResultSet rs=pst.executeQuery(sql);
	    		view.tabella.setModel(DbUtils.resultSetToTableModel(rs));
	    		pst.close();
	    		rs.close();
	    	} catch (SQLException e1) {
	    		// TODO Auto-generated catch block
	    		e1.printStackTrace();
	    	}
	    	
	    	
	    	
	    	}
	    	
	    }
	   
	    class CaricaDipendenti_1 implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		connection=sqlConnection.dbConnector();
	     String sql="select * from dipendente where id='"+id+"' ";

	    		try {
	    		
	    		PreparedStatement pst = connection.prepareStatement(sql);
	    		ResultSet rs=pst.executeQuery(sql);
	    		view.tabella.setModel(DbUtils.resultSetToTableModel(rs));
	    		pst.close();
	    		rs.close();
	    	} catch (SQLException e1) {
	    		// TODO Auto-generated catch block
	    		e1.printStackTrace();
	    	}
	    	
	    	
	    	
	    	}
	    	
	    }
	   
	    
	    class DipendenteListener implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		connection=sqlConnection.dbConnector();
	 
	    		String nome;
	    		
	 
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
	    
	    class CercaMansioneListener implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		connection=sqlConnection.dbConnector();

	    		
	    		String mansione;
	 
	    			model=view.getDipendente();
	    			mansione=model.getMansione();
	    			String sql ="select * from dipendente where mansione='"+mansione+"' ";
	    			try {
						Statement st=connection.createStatement();
						rs=st.executeQuery(sql);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					view.table1.setModel(DbUtils.resultSetToTableModel(rs));
	                
	    }}
	    
	    class InserisciDipendenteListener implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    			
	    		model=view.getDipendente2();

	    		String NomeDipendente;
	    		NomeDipendente=model.getNomeDipendente();
	    		
	    		String CognomeDipendente;
	    		CognomeDipendente=model.getCognomeDipendente();
	    		
	    		String CodiceFisc;
	    		CodiceFisc=model.getCodiceFisc();
	    		
	    		Date AnnoNascita;
	    		AnnoNascita=model.getAnnoNascita();
	    		
	    		
	    		Date Data_Ass;
	    		Data_Ass=model.getData_Ass();
	    		
	    		
	    		String Indirizzo;
	    		Indirizzo=model.getIndirizzo();
	    		
	    		String Email;
	    		Email=model.getEmail();
	    		
	    		
	    		
	    		String Telefono;
	    		Telefono=model.getTelefono();
	    		
	    		Date Data_Lic;
	    		Data_Lic=model.getData_Lic();
	    		
	    		String Mansione;
	    		Mansione=model.getMansione();
	    	
	    		try{
	    		
	    			String sql ="insert into dipendente (nome,cognome,cod_fisc,indirizzo,datan,mansione,data_assunzione,id,email,data_licenziamento,telefono,id_turno) values (?,?,?,?,?,?,?,?,?,?,?,?)";
						
				PreparedStatement pst1 =connection.prepareStatement(sql);
				if (NomeDipendente.equals(" ")==true){
					JOptionPane.showMessageDialog(null, "Inserire nome dipendente!");
				}else{
					pst1.setString(1, NomeDipendente);
				}
				if (CognomeDipendente.equals(" ")==true){
					JOptionPane.showMessageDialog(null, "Inserire cognome dipendente!");
				}else{
					pst1.setString(2, CognomeDipendente);
				}
				if (CodiceFisc.equals(" ")==true){
					JOptionPane.showMessageDialog(null, "Inserire codice Fiscale!");
				}else{
					pst1.setString(3, CodiceFisc);
				}
				if (Indirizzo.equals(" ")==true){
					JOptionPane.showMessageDialog(null, "Inserire indirizzo");
				}else{
					pst1.setString(4, Indirizzo);
				}
				
			

				
				
				pst1.setDate(5, AnnoNascita);
				pst1.setString(6, Mansione);
				pst1.setDate(7, Data_Ass);
				pst1.setString(8, id);
				pst1.setString(9, Email);
				pst1.setDate(10, Data_Lic);
				pst1.setString(11, Telefono);
				pst1.setString(12, "1");
			    pst1.execute();
				
				JOptionPane.showMessageDialog(null, "Dipendente  inserito!");
				
				//view.refreshTabella(id);	
			    view.refreshForm();
				pst1.close();
			} catch (Exception e2){
				System.out.println(NomeDipendente);

				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
				e2.printStackTrace();
				
			
				
			}
	    }
	    }
	    class ModificaDipendente implements ActionListener {
	    	public void actionPerformed(ActionEvent e){
	
	    		    		
	    		    			
	    		    		model=view.getDipendente3();

	    		    		String NomeDipendente;
	    		    		NomeDipendente=model.getNomeDipendente();
	    		    		
	    		    		String CognomeDipendente;
	    		    		CognomeDipendente=model.getCognomeDipendente();
	    		    		
	    		    		String CodiceFisc;
	    		    		CodiceFisc=model.getCodiceFisc();
	    		    		
	    		    		Date AnnoNascita;
	    		    		AnnoNascita=model.getAnnoNascita();
	    		    		
	    		    		
	    		    		Date Data_Ass;
	    		    		Data_Ass=model.getData_Ass();
	    		    		
	    		    		
	    		    		String Indirizzo;
	    		    		Indirizzo=model.getIndirizzo();
	    		    		
	    		    		String Email;
	    		    		Email=model.getEmail();
	    		    		
	    		    		
	    		    		
	    		    		String Telefono;
	    		    		Telefono=model.getTelefono();
	    		    		
	    		    		Date Data_Lic;
	    		    		Data_Lic=model.getData_Lic();
	    		    		
	    		    		String Mansione;
	    		    		Mansione=model.getMansione();
	    		    	
	    		try{
	    		
	    		int row=view.tabella.getSelectedRow();
				String codice_=(view.tabella.getModel().getValueAt(row, 0)).toString();
				String query="UPDATE dipendente set nome=?, cognome=? , cod_fisc=?, indirizzo=?,email=?,"
						+ "datan=?,mansione=?,data_assunzione=?, data_licenziamento=?,telefono=?  where codice='"+codice_+"' and id='"+id+"'";
				
				
				PreparedStatement pst1=connection.prepareStatement(query);
				if (NomeDipendente.equals("")==true){
					JOptionPane.showMessageDialog(null, "Inserire nome!");
				}else{
					pst1.setString(1, NomeDipendente);
				}
				if (CognomeDipendente.equals("")==true){
					JOptionPane.showMessageDialog(null, "Inserire cognome!");
				}else{
					pst1.setString(2,CognomeDipendente);
				}
				if (CodiceFisc.equals("")==true){
					JOptionPane.showMessageDialog(null, "Inserire codice fiscale!");
				}else{
					pst1.setString(3,CodiceFisc);
				}
				if(Indirizzo.equals("")==true){
					JOptionPane.showMessageDialog(null, "Inserire indirizzo!");
				}else{
					pst1.setString(4, Indirizzo);
				}
				
				pst1.setString(5, Email);

				pst1.setDate(6, AnnoNascita);
				pst1.setString(7, Mansione);
				pst1.setDate(8, Data_Ass);
				pst1.setDate(9, Data_Lic);
				pst1.setString(10, Telefono);
			    pst1.execute();
				
				
				if(Mansione!=""){
					pst1.setString(7, Mansione);

				}else{
					JOptionPane.showMessageDialog(null, "Selezionare una mansione!");
					}
				
				pst1.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Dipendente modificato correttamente!");
				pst1.close();
				view.refreshForm();
			
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
						//e1.printStackTrace();
					}
	    	
	    		
	    }}
	    
	    
}





