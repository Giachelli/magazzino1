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
import View.LoginView1;
import View.ProdottoView;

import com.application.*;
public class LoginController {
    private LoginModel model;
   
    private LoginView1 view1;
    public Connection connection = null;
    public String codice=null;
    public String id=null;
    public JLabel lblid;
    
    public LoginController(LoginView1 view){
        this.view1 = view;
        connection=sqlConnection.dbConnector();
        view.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model = view1.getUser();
                
                JLabel labelLogin = new JLabel(model.getUserName());
				labelLogin.setBounds(143, 7, 61, 16);
				labelLogin.setFont(new Font("Lucida Grande", Font.BOLD, 16));
				
				
				
                if(checkUser(model)){
                    view1.showMessage("Login effettuato con successo!");
                    id=checkid(model);
                    
                    view1.frame.dispose();
                    ProdottoView theView = new ProdottoView();
            		ProdottoModel theModel= new ProdottoModel(); 
            		ProdottoController theController= new ProdottoController(theView);
            		
            		theController.id=id;
            		
            		theView.main.setVisible(true);
            		theView.main.add(labelLogin);
            		theView.main.setTitle("Main Supermercato");
            		
                    
                    
                }else{
                    view1.showMessage("Username o Passaword errati");
                }                
            } catch (Exception ex) {
                view1.showMessage(ex.getStackTrace().toString());
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
            
            connection.close();
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
            
            connection.close();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            throw e;
        }
		return codice; 
        
      }
} 
