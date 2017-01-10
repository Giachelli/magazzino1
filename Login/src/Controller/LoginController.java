package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.LoginModel;
import View.LoginView;


public class LoginController {
    private LoginModel model;
    private LoginView view;
    
    public LoginController(LoginView view){
        this.view = view;
        
        view.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                if(checkUser(model)){
                    view.showMessage("Login succesfully!");
                }else{
                    view.showMessage("Invalid username and/or password!");
                }                
            } catch (Exception ex) {
                view.showMessage(ex.getStackTrace().toString());
            }
        }
    }
    
    public boolean checkUser(LoginModel user) throws Exception {
        
        String dbUrl = "jdbc:mysql://localhost:3306/OOP1617";
        String dbClass = "com.mysql.jdbc.Driver";
        String query = "select id,user,pass from admin where user='"+user.getUserName()+"'and pass='"+user.getPassword()+"'";

        try {
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection (dbUrl);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
              return true;
            }
            
            con.close();
        }catch(Exception e) {
            throw e;
        } 
        return false;
      }
} 
