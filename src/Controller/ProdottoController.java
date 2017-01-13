package Controller;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.connectiondb.*;

import Controller.LoginController.LoginListener;
import Model.LoginModel;
import View.LoginView1;
import com.application.*;
import Model.ProdottoModel;
import View.ProdottoView;

import net.proteanit.sql.DbUtils;
public class ProdottoController {
	private ProdottoModel model;
	private LoginModel model2;
	private LoginView1 view1;
	public ResultSet rs;   
	public String id;
    private ProdottoView view;
    
    Connection connection = null;
    
    public ProdottoController(ProdottoView view){
    	
    	
        this.view = view;
        connection=sqlConnection.dbConnector();
        view.addNomeProdottoListener(new CercaProdottoNome());
        view.addCercaRepartoListener(new CercaProdottoReparto());
        view.addCercaOffertaListener(new CercaOfferte());
        view.addInserisciProdottoListener(new InserisciProdotto());
        view.addAzzeraProdottoListener(new AzzeraProdotto());
        view.addModificaListener(new ModificaProdotto());
        view.addEliminaListener(new EliminaProdotto());
        view.addLogoutListener(new Logout());
        view.addCaricaListener(new CaricaProdotti());
        view.addCarica2Listener(new CaricaProdotti2());
        view.addImmagineListener(new ScegliImmagine());
        view.addImmagine1Listener(new ScegliImmagine());
    }
    
    
    class ScegliImmagine implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
  			int returnVal = view.fileChooser.showDialog(null, "Carica");
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
				 view.img=view.fileChooser.getSelectedFile().getName().toString().trim();
			
  		  }
    	}
    }
    
    class CaricaProdotti implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String sql ="select * from prodotto where reparto='Magazzino' and qta < 5 and id='"+id+"'ORDER BY qta ASC";
    	try {
    		
    		PreparedStatement pst = connection.prepareStatement(sql);
    		ResultSet rs=pst.executeQuery(sql);
    		view.table.setModel(DbUtils.resultSetToTableModel(rs));
    		pst.close();
    		rs.close();
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	
    	
    	
    	}
    }
    class CaricaProdotti2 implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String sql ="select * from prodotto where id='"+id+"'";
    	try {
    		
    		PreparedStatement pst = connection.prepareStatement(sql);
    		ResultSet rs=pst.executeQuery(sql);
    		view.table_1.setModel(DbUtils.resultSetToTableModel(rs));
    		pst.close();
    		rs.close();
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	
    	
    	
    	}
    }
    	
    	
   
    
 class CercaProdottoNome implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String nome;
 
    			model=view.getProdotto();
    			nome=model.getNome();
    			String sql ="select * from prodotto where nome='"+nome+"'and id='"+id+"'order by prezzo";
    			try {
					Statement st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				view.table.setModel(DbUtils.resultSetToTableModel(rs));
                
    }}
    
    class CercaProdottoReparto implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		String reparto;
 
    			model=view.getProdotto();
    			reparto=model.getReparto();
    			String sql ="select * from prodotto where reparto='"+reparto+"'and id='"+id+"'ORDER BY qta ASC";
    			try {
					Statement st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				view.table.setModel(DbUtils.resultSetToTableModel(rs));
                
    }}
   
    class CercaOfferte implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    			String sql ="select * from prodotto where offerta='1' and id='"+id+"'ORDER BY fine_offerta ASC";
			try {
				Statement st=connection.createStatement();
				rs=st.executeQuery(sql);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			view.table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
                
    }
    class InserisciProdotto implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    			
    		model=view.getProdotto2();

    		String nome;
    		nome=model.getNome();
    		
    		String marca;
    		marca=model.getMarca();
    		
    		Float prezzo;
    		prezzo=model.getPrezzo();
    		
    		Date inizio_offerta;
    		inizio_offerta=model.getInizio_offerta();
    		
    		
    		Date fine_offerta;
    		fine_offerta=model.getFine_offerta();
    		
    		
    		Boolean offerta;
    		offerta=model.getOfferta();
    		
    		Float prezzo_offerta;
    		prezzo_offerta=model.getPrezzo_offerta();
    		
    		
    		
    		Integer qta;
    		qta=model.getQta();
    		
    		Date scadenza;
    		scadenza=model.getScadenza();
    		
    		String scaffale;
    		scaffale=model.getScaffale();
    		
    		
    		
    		String settore;
    		settore=model.getSettore();
    		
    		String reparto;
    		reparto=model.getReparto();
    		
    		String img;
    		img=model.getImg();
    		
    		
    			
    		try{
    		String sql ="insert into prodotto (nome,marca,prezzo,inizio_offerta,fine_offerta,offerta,"
					+ "prezzo_offerta,qta,scadenza,reparto,scaffale,settore,img,id) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst =connection.prepareStatement(sql);
			if (nome.equals("")==true){
				JOptionPane.showMessageDialog(null, "Inserire nome prodotto!");
			}else{
				pst.setString(1, nome);
			}
			if (marca.equals("")==true){
				JOptionPane.showMessageDialog(null, "Inserire marca prodotto!");
			}else{
				pst.setString(2, marca);
			}
			
				pst.setFloat(3, prezzo);
				
			//controllo se l'offerta è stata opzionata, se si controllo che il prezzo sia maggiore del prezzo offerta.
				//altrimenti setto a 0 l'offerta e a null il prezzo offerta.
				if (offerta==true){
				
					pst.setString(6, "1");
					if(prezzo_offerta!=null){
					if (prezzo>prezzo_offerta){
						
					pst.setFloat(7, prezzo_offerta);
					}else{
						JOptionPane.showMessageDialog(null, "Inserire prezzo offerta minore del prezzo di vendita!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Inserire prezzo offerta!");
					}
					if(fine_offerta.after(inizio_offerta)==true){
						pst.setDate(4, inizio_offerta);
						pst.setDate(5, fine_offerta);
					}else{
						JOptionPane.showMessageDialog(null, "Inserire data di fine offerta successiva alla data di inizio!");
					}
					
				
				}else{
				pst.setDate(4, null);
				pst.setDate(5, null);
				pst.setString(6, "0");
				pst.setString(7, null);
				}
			
			
				
				pst.setInt(8, qta);
				pst.setDate(9, scadenza);
				
				if(reparto!=""){
					pst.setString(10, reparto);
				
				
				}else{
				JOptionPane.showMessageDialog(null, "Selezionare un reparto!");
				}
				
				if(reparto=="Magazzino"){
					pst.setString(11, null);
				}else{
					if(scaffale.equals("")==true){
						JOptionPane.showMessageDialog(null, "Inserire scaffalatura!");
					}else if(scaffale.length()==2 || scaffale.length()==3){
						pst.setString(11, scaffale);
						
					}else{
					JOptionPane.showMessageDialog(null, "Inserire la scaffalatura corretta, come da immagine!");
				}
					
				}
					
				
				
				
				pst.setString(12, settore);
				pst.setString(13, img);
				pst.setString(14,id);
				
			
				pst.execute();
				JOptionPane.showMessageDialog(null, "Prodotto inserito!");
				
				
				
				view.refreshTable1(id);
				view.refreshTable(id);
				view.refreshForm();
				pst.close();
		} catch (Exception e2){
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
			//e2.printStackTrace();
			
		
			
		}
    }
    }
    class AzzeraProdotto implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		view.refreshForm();
                
    }}
    
    class EliminaProdotto implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		int action=JOptionPane.showConfirmDialog
					(null, "Sei sicuro di voler eliminare il prodotto selezionato?","Elimina", JOptionPane.YES_NO_OPTION);
			if (action==0){
			try{
			
				int row=view.table_1.getSelectedRow();
				String codice_=(view.table_1.getModel().getValueAt(row, 0)).toString();
				
				String query="Delete from prodotto where codice='"+codice_+"'";
				
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Prodotto eliminato correttamente!");
				pst.close();
				view.refreshTable1(id);
				view.refreshForm();
					}catch(Exception e1){
						
						e1.printStackTrace();
					}
    	}
    }}
    class Logout implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
			try {
				connection.close();
				view.main.dispose();
				
				LoginView1 theView = new LoginView1();
				LoginModel theModel = new LoginModel(); 
				LoginController theController = new LoginController(theView);
				
				theView.frame.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
    		
    }}
    class ModificaProdotto implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    			model=view.getProdotto3();
        		
    			String nome;
        		nome=model.getNome();
        		
        		String marca;
        		marca=model.getMarca();
        		
        		Float prezzo;
        		prezzo=model.getPrezzo();
        		
        		Date inizio_offerta;
        		inizio_offerta=model.getInizio_offerta();
        		
        		
        		Date fine_offerta;
        		fine_offerta=model.getFine_offerta();
        		
        		
        		Boolean offerta;
        		offerta=model.getOfferta();
        		
        		Float prezzo_offerta;
        		prezzo_offerta=model.getPrezzo_offerta();
        		
        		
        		
        		Integer qta;
        		qta=model.getQta();
        		
        		Date scadenza;
        		scadenza=model.getScadenza();
        		
        		String scaffale;
        		scaffale=model.getScaffale();
        		
        		
        		
        		String settore;
        		settore=model.getSettore();
        		
        		String reparto;
        		reparto=model.getReparto();
        		
        		String img;
        		img=model.getImg();
    		
    		try{
    		
    		int row=view.table_1.getSelectedRow();
			String codice_=(view.table_1.getModel().getValueAt(row, 0)).toString();
			String query="UPDATE prodotto set nome=?, marca=? , prezzo=?, inizio_offerta=?,fine_offerta=?, offerta=?, prezzo_offerta=?,"
					+ "qta=?,scadenza=?,reparto=?, scaffale=?,settore=?,img=?  where codice='"+codice_+"' and id='"+id+"'";
			
			
			PreparedStatement pst=connection.prepareStatement(query);
			if (nome.equals("")==true){
				JOptionPane.showMessageDialog(null, "Inserire nome prodotto!");
			}else{
				pst.setString(1, nome);
			}
			if (marca.equals("")==true){
				JOptionPane.showMessageDialog(null, "Inserire marca prodotto!");
			}else{
				pst.setString(2, marca);
			}
			
				pst.setFloat(3, prezzo);
				
			
			if (offerta==true){
				
					pst.setString(6, "1");
					if(prezzo_offerta!=null){
					if (prezzo>prezzo_offerta){
						
					pst.setFloat(7, prezzo_offerta);
					}else{
						JOptionPane.showMessageDialog(null, "Inserire prezzo offerta minore del prezzo di vendita!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Inserire prezzo offerta!");
					}
					if(fine_offerta.after(inizio_offerta)==true){
						pst.setDate(4, inizio_offerta);
						pst.setDate(5, fine_offerta);
					}else{
						JOptionPane.showMessageDialog(null, "Inserire data di fine offerta successiva alla data di inizio!");
					}
					
				
				}else{
				pst.setDate(4, null);
				pst.setDate(5, null);
				pst.setString(6, "0");
				pst.setString(7, null);
				}
			
			
				
				pst.setInt(8, qta);
				pst.setDate(9, scadenza);
				
				if(reparto!=""){
					pst.setString(10, reparto);
				
				
				}else{
				JOptionPane.showMessageDialog(null, "Selezionare un reparto!");
				}
				
				if(reparto=="Magazzino"){
					pst.setString(11, null);
				}else{
					if(scaffale.equals("")==true){
						JOptionPane.showMessageDialog(null, "Inserire scaffalatura!");
					}else if(scaffale.length()==2 || scaffale.length()==3){
						pst.setString(11, scaffale);
						
					}else{
					JOptionPane.showMessageDialog(null, "Inserire la scaffalatura corretta, come da immagine!");
				}
					
				}
				
				pst.setString(12, settore);
				
				
				
				
				pst.setString(13, img);
				
			
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Prodotto modificato correttamente!");
			pst.close();
			view.refreshTable1(id);
			view.refreshTable(id);
			view.refreshForm();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
					//e1.printStackTrace();
				}
    	
    		
    }}
    
    
}
                
    	



