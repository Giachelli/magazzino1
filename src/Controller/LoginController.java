package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.connectiondb.*;
import Model.LoginModel;
import View.LoginView1;
import com.application.*;
public class LoginController {
    private LoginModel model;
   
    private LoginView1 view1;
    Connection connection = null;
    
    public LoginController(LoginView1 view){
        this.view1 = view;
        
        view.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model = view1.getUser();
                if(checkUser(model)){
                    view1.showMessage("Login effettuato con successo!");
                    view1.frame.dispose();
                    Main window = new Main();
					window.main.setVisible(true);
                    
                }else{
                    view1.showMessage("Username o Passaword errati");
                }                
            } catch (Exception ex) {
                view1.showMessage(ex.getStackTrace().toString());
            }
        }
    }
    
    
    public boolean checkUser(LoginModel user) throws Exception {
    	
    	connection=sqlConnection.dbConnector();
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
} 
