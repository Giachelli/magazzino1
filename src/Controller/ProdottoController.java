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

import Model.DipendenteModel;
import Model.LoginModel;
import View.DipendenteView;
import View.LoginView;

import Model.ProdottoModel;
import Model.TurniModel;
import View.ProdottoView;
import View.TurniView;
import net.proteanit.sql.DbUtils;

/**
 * Classe ProdottoController.java
 * Questa classe ci permette di implementate, richiamando il model, tutte le azioni dei pulsanti
 * realizzati nella view.
 *     
 * @author Iezzi Valerio
 *
 */
public class ProdottoController {
	private ProdottoModel model;

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
        view.dipendeteView(new dipendenteView());
        view.turniView(new turniView());
    }
   
    class turniView implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		TurniView theView = new TurniView();
    		TurniModel theModel= new TurniModel(); 
    		TurniController theController= new TurniController(theView);
    		theController.id=id;
    		theView.frameTurni.setVisible(true);
    		view.frameProdotto.dispose();
    	}
    }
    
    class dipendenteView implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		DipendenteView theView = new DipendenteView();
    		DipendenteModel theModel= new DipendenteModel(); 
    		DipendenteController theController= new DipendenteController(theView);
    		theController.id=id;
    		theView.frameDipendente.setVisible(true);
    		view.frameProdotto.dispose();
    	}
    }
    
    class ScegliImmagine implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
  			int returnVal = view.fileChooser.showDialog(null, "Carica");
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
				 view.img=view.fileChooser.getSelectedFile().getName().toString().trim();
			
  		  }
    	}
    }
    /**
     * CaricaProdotti ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per la visualizzazione nella view.table di tutti i prodotti con 
     * reparto= Magazzino e con quantità minore di 5 (ovvero in esaurimento) dell'utente loggato,
     * ordinati per quatità (qta).
     *
     */
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
    		
    		e1.printStackTrace();
    	}
    	
    	
    	
    	}
    }
    
    /**
     * CaricaProdotti2 ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per la visualizzazione nella view.table_1 di tutti i prodotti 
     * dell'utente loggato. Questo servirà a mostrare tutti i prodotti nella tabella pronti
     * per la modifica.
     *
     */
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
    
    
    
    /**
     * CercaProdottoNome ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per la visualizzazione nella view.table di tutti i prodotti, con 
     * nome del proddotto uguale a quello inserito, dell'utente loggato, ordinati per prezzo.
     *
     */ 	
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
/**
 * CercaProdottoReparto ci permette, attraverso una connessione stabilita a priori con il db, 
 * di eseguire una query per la visualizzazione nella view.table di tutti i prodotti del reparto 
 * selezionato (Magazzino, Utility, Alimentare), dell'utente loggato, ordinati per quantità ascendente.
 *
 */ 
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
   
    /**
     * CercaOfferte ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per la visualizzazione nella view.table di tutti i prodotti, con 
     * offerta uguale a 1, dell'utente loggato, ordinati per data di fine_offerta ascendente.
     *
     */ 
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
    
    /**
     * InserisciProdotto ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per l'inserimento nel database di un prodotto.
     */ 
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
				
				/**
			     * Controllo se l'offerta è stata opzionata, in caso affermativo:
			     * 
			     * - setto offerta a 1 e procedo con il
			     * - controllo che il prezzo offerta non è nullo e di nuovo in caso affermativo,
			     * - controllo che il prezzo sia maggiore del prezzo offerta, a questo punto 
			     * - setto il prezzo offerta, altrimenti visualizzo i relativi messaggi di errore.
			     * - Adesso controllo se la data di fine offerta viene dopo la data di inizio e in caso
			     *   affermativo setto le date di inizio e fine offerta altrimenti visualizzo un messaggio di errore.
			     * 
			     * In caso negativo (ovvero l'offerta non è stata opzionata):
			     * setto data inizio e fine offerta a null, l'offerta a 0, e il prezzo offerta a null.
			     *
			     */ 
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
				/**
				 * Controllo se il reparto è magazzino, setto lo scaffale a null,
				 * altrimenti controllo che lo scaffale sia stato inserito e che sia di lunghezza 
				 * 2 o 3 come da immaggine della scaffalatura, in caso di errore visualizzo i messaggi
				 * relativi.
			     *
			     */ 
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
    /**
     * EliminaProdotto ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per l'eliminazione dal databale del prodotto selezionato in tabella table_1.
     * Viene memorizzato il codice della riga selezionata dalla table_1
     * e questo codice viene passato alla query, che esegue l'eliminazione del prodotto corrispondente.
     * Se tutto va a buon fine, viene visualizzato un messaggio di conferma e aggiornata la table_1 e
     * ripulita la form. 
     *
     */ 
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
    /**
     * Logout ci permette di:
     * - chiudere la connessione con il db;
     * - chiudere il main;
     * - chiamare e inizializzare l'MVC del Login;
     * - rendere visibile il frame della theView.
     *
     */ 
    class Logout implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
			try {
				connection.close();
				view.frameProdotto.dispose();
				
				LoginView theView = new LoginView();
				LoginModel theModel = new LoginModel(); 
				LoginController theController = new LoginController(theView);
				
				theView.frameLogin.setVisible(true);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
    		
    }}
    
    /**
     * ModificaProdotto ci permette, attraverso una connessione stabilita a priori con il db, 
     * di eseguire una query per l'update del prodotto.
     *
     */ 
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
    		/**
    		 * Viene recuperato il codice del prodotto dalla riga selezionata nella table_1.
    		 * Successivamente eseguo la query di aggiornamento del prodotto avente quel codice.
    		 * Esegue tutti i controlli per i vari campi, come nel caso dell'inserimento.
    		 * In caso affermativo visualizza un messaggio "Prodotto modificato correttamente!"
    		 * altrimenti "Inserire i campi obbligatori o in modo corretto!".
    		 */
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
                
    	



