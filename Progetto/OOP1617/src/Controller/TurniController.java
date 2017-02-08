package Controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.connectiondb.*;
import Model.DipendenteModel;
import Model.LoginModel;
import View.DipendenteView;
import View.LoginView;
import Model.ProdottoModel;
import Model.TurniModel;
import View.ProdottoView;
import View.TurniView;
import net.proteanit.sql.DbUtils;


public class TurniController {
	private TurniModel model;
	public ResultSet rs;   
	public String id;
    private TurniView view;
    public JLabel labelLogin;
    public String label;
    Connection connection = null;
	
    
    public TurniController (TurniView view) {
    	this.view = view;
        connection=sqlConnection.dbConnector();
        
        view.addCaricaTurnoListener(new CaricaTurno());
        view.addCaricaTurnoListener1(new CaricaTurno1());
        view.addEliminaTurnoListener(new EliminaTurno());
        view.addModificaTurnoListener(new ModificaTurno());
        view.addInserisciTurnoListener(new InserisciTurno());
        view.prodottoView(new prodottoView());
        view.dipendenteView(new dipendenteView());
        view.Logout(new Logout());
        
        labelLogin = new JLabel();
    	labelLogin.setBounds(143, 7, 61, 16);
    	labelLogin.setFont(new Font("Lucida Grande", Font.BOLD, 16));
    	view.frameTurni.setTitle("Main Supermercato");
    }
    
    class dipendenteView implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		DipendenteView theView = new DipendenteView();
    		@SuppressWarnings("unused")
			DipendenteModel theModel= new DipendenteModel(); 
    		DipendenteController theController= new DipendenteController(theView);
    		theController.id=id;
    		theController.label=label;
    		theView.frameDipendente.setVisible(true);
    		labelLogin.setText(label);
    		theView.frameDipendente.add(labelLogin);
    		view.frameTurni.dispose();
			
    		
    }}
    
    class prodottoView implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		ProdottoView theView = new ProdottoView();
    		@SuppressWarnings("unused")
			ProdottoModel theModel= new ProdottoModel(); 
    		ProdottoController theController= new ProdottoController(theView);
    		theController.id=id;
    		theController.label=label;
    		theView.frameProdotto.setVisible(true);
    		labelLogin.setText(label);
    		theView.frameProdotto.add(labelLogin);
    		view.frameTurni.dispose();
			
    		
    }}
    
    class Logout implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
			try {
				connection.close();
				view.frameTurni.dispose();
				
				LoginView theView = new LoginView();
				@SuppressWarnings("unused")
				LoginModel theModel = new LoginModel(); 
				@SuppressWarnings("unused")
				LoginController theController = new LoginController(theView);
				
				theView.frameLogin.setVisible(true);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
    		
    }}
    
    class CaricaTurno implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String sql ="select id_turno,nome_turno,lunedi,martedi,mercoledi,giovedi,venerdi,sabato,tot_ore_settimanali from turno where id='"+id+"'";
        	try {
        		
        		PreparedStatement pst = connection.prepareStatement(sql);
        		ResultSet rs=pst.executeQuery(sql);
        		view.table_2.setModel(DbUtils.resultSetToTableModel(rs));
        		pst.close();
        		rs.close();
        	} catch (SQLException e1) {
        		
        		e1.printStackTrace();
        	}
			
  		  }
    	}
    
    class CaricaTurno1 implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String sql ="select id_turno,nome_turno,lunedi,martedi,mercoledi,giovedi,venerdi,sabato,tot_ore_settimanali from turno where id='"+id+"'";
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
    class EliminaTurno implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		int action=JOptionPane.showConfirmDialog
					(null, "Sei sicuro di voler eliminare il turno selezionato?","Elimina", JOptionPane.YES_NO_OPTION);
			if (action==0){
			try{
			
				int row=view.table_2.getSelectedRow();
				String codice_=(view.table_2.getModel().getValueAt(row, 0)).toString();
				
				String query="Delete from turno where id_turno='"+codice_+"'";
				
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Turno eliminato correttamente!");
				pst.close();
				view.refreshTableTurno(id);
				view.refreshFormTurno();
					}catch(Exception e1){
						
						e1.printStackTrace();
				}
			}
    	}

    }
    class ModificaTurno implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    			model=view.getTurno();
        	
        		String nome=model.getNomeTurno();
        		String lunedi=model.getLunedi();
        		String martedi=model.getMartedi();
        		String mercoledi=model.getMercoledi();
        		String giovedi=model.getGiovedi();
        		String venerdi=model.getVenerdi();
        		String sabato=model.getSabato();
        		int ore = model.Calcola_ore();
    		
    		try{
    		int row=view.table_2.getSelectedRow();
			String codice_=(view.table_2.getModel().getValueAt(row, 0)).toString();
			String query="UPDATE turno set nome_turno=?, lunedi=? , martedi=?, mercoledi=?,giovedi=?, venerdi=?, sabato=?, tot_ore_settimanali=?"
					+ " where id_turno='"+codice_+"' and id='"+id+"'";
			
			
			PreparedStatement pst=connection.prepareStatement(query);
			if (nome.equals("")==true){
				JOptionPane.showMessageDialog(null, "Inserire nome turno!");
			}else{
				pst.setString(1, nome);
			}
			
			if (lunedi.equals("")==true){
			}else pst.setString(2, lunedi);
			
			if(martedi.equals("")==true){
			}else pst.setString(3, martedi);
			
			if(mercoledi.equals("")==true){
			}else pst.setString(4, mercoledi);
			
			if(giovedi.equals("")==true){
			}else pst.setString(5, giovedi);
			
			if(venerdi.equals("")==true){
			}else pst.setString(6, venerdi);
			
			if(sabato.equals("")==true){
			}else pst.setString(7, sabato);
			
				pst.setInt(8, ore);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Turno modificato correttamente!");
			pst.close();
			view.refreshTableTurno(id);
			view.refreshFormTurno();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
					//e1.printStackTrace();
				}
    	
    		
    }}
    
    class InserisciTurno implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    			model=view.getTurno1();
        	
        		String nome=model.getNomeTurno();
        		String lunedi=model.getLunedi();
        		String martedi=model.getMartedi();
        		String mercoledi=model.getMercoledi();
        		String giovedi=model.getGiovedi();
        		String venerdi=model.getVenerdi();
        		String sabato=model.getSabato();
    		
    		try{
			String query="Insert into turno (nome_turno,lunedi,martedi,mercoledi,giovedi,venerdi,sabato,tot_ore_settimanali, id) values (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst=connection.prepareStatement(query);
			if (nome.equals("")==true){
				JOptionPane.showMessageDialog(null, "Inserire nome turno!");
			}else{
				pst.setString(1, nome);
			}
			
			if (lunedi.equals("")==true){
			}else pst.setString(2, lunedi);
			
			if(martedi.equals("")==true){
			}else pst.setString(3, martedi);
			
			if(mercoledi.equals("")==true){
			}else pst.setString(4, mercoledi);
			
			if(giovedi.equals("")==true){
			}else pst.setString(5, giovedi);
			
			if(venerdi.equals("")==true){
			}else pst.setString(6, venerdi);
			
			if(sabato.equals("")==true){
			}else pst.setString(7, sabato);
			
				pst.setInt(8, model.Calcola_ore());
				pst.setString(9, id);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Turno inserito correttamente!");
			pst.close();
			view.refreshTableTurno(id);
			view.refreshFormTurno();
			view.refreshFormTurno1();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori");
					e1.printStackTrace();
				}
    	
    		
    }}
    
}

