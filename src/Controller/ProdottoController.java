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
import Model.LoginModel;
import View.LoginView1;
import com.application.*;
import Model.ProdottoModel;
import View.ProdottoView;
import net.proteanit.sql.DbUtils;
public class ProdottoController {
	private ProdottoModel model;
	public ResultSet rs;   
    private ProdottoView view;
    Connection connection = null;
    
    public ProdottoController(ProdottoView view){
        this.view = view;
        
        view.addNomeProdottoListener(new ProdottoListener());
    }
    
    class ProdottoListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		connection=sqlConnection.dbConnector();
    		String nome;
 
    			model=view.getProdotto();
    			nome=model.getNome();
    			String sql ="select * from prodotto where nome='"+nome+"'order by prezzo";
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
}
/*public boolean checkProdotto(ProdottoModel user) throws Exception {
    	
    	
    	
    	//String query = "select user,pass from admin where user='"+user.getUserName()+"'and pass='"+user.getPassword()+"'";

        try {
           Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
            	view.table.setModel(DbUtils.resultSetToTableModel(rs));
            	
            	return true;
            }
            
            connection.close();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            throw e;
        } 
        
        return false;
      }*/

