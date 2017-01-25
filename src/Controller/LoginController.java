package Controller;

import java.awt.Font;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.connectiondb.*;
import Model.LoginModel;
import Model.ProdottoModel;
import View.LoginView;
import View.ProdottoView;

import com.application.*;

/**
 * Classe LoginController.java
 * Questa classe implementa l'azione svolta alla pressione del btnLogin, andando a richiamare il model.
 * Per implementare il LoginListener abbiamo bisogno in particolare della funzione booleana checkUser.
 * Essa ci restituisce true o false, attraverso una query sql, se l'username e la password inseriti
 * sono presenti nel database.
 *  
 *     
 * @author Iezzi Valerio
 *
 */
public class LoginController {
    private LoginModel model;
   
    private LoginView view;
    public Connection connection = null;
    public String codice=null;
    public String id=null;
    public JLabel lblid;
    
    public LoginController(LoginView view){
        this.view = view;
        connection=sqlConnection.dbConnector();
        view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                
                JLabel labelLogin = new JLabel(model.getUserName());
				labelLogin.setBounds(143, 7, 61, 16);
				labelLogin.setFont(new Font("Lucida Grande", Font.BOLD, 16));
				
				/**
				 * Con questo if, passandogli la funzione checkUser, se restituisce true:
				 * visualizziamo il messaggio "Login effettuato con successo!"
				 * successivamente ci salviamo l'id dell'utente loggato attraverso la funzione checkid.
				 * Andiamo quindi a visualizzare, chiamando e inizializzando l'MVC del Prodotto, il main
				 * attraverso l'istruzione theView.main.setVisible(true); 
				 * in seguito aggiungiamo al main una label che contiene l'username dell'utente loggato,
				 * e il title della finesta da visualizzare ("Main Supermercato").
				 * Se invece restituisce false, ovvero l'utente non è stato trovato:
				 * viene visualizzato il messaggio "Username o Passaword errati".
				 */
				
                if(checkUser(model)){
                    view.showMessage("Login effettuato con successo!");
                    id=checkid(model);
                    
                    view.frameLogin.dispose();
                    ProdottoView theView = new ProdottoView();
            		ProdottoModel theModel= new ProdottoModel(); 
            		ProdottoController theController= new ProdottoController(theView);
            		
            		theController.id=id;
            		
            		theView.frameProdotto.setVisible(true);
            		theView.frameProdotto.add(labelLogin);
            		theView.frameProdotto.setTitle("Main Supermercato");
            		
                    
                    
                }else{
                	
                    view.showMessage("Username o Passaword errati");
                    
                }                
            } catch (Exception ex) {
                view.showMessage(ex.getStackTrace().toString());
            }
        }
    }
    
    
    public boolean checkUser(LoginModel user) throws Exception {
    	
    	
    	String query = "select user,pass from admin where user='"+user.getUserName()+"'and pass='"+user.getPassword()+"'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
              return true;
            }
            
            
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            throw e;
        } 
        return false;
      }
public String checkid(LoginModel user) throws Exception {
    	
    	
    	String query = "select id from admin where user='"+user.getUserName()+"'and pass='"+user.getPassword()+"'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
              codice=rs.getString(1);
              //System.out.println(codice);
            }
            
            //connection.close();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            throw e;
        }
		return codice; 
        
      }
} 
