import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.*;

public class Login {

	JFrame login;
	Statement st;
	ResultSet rs;
	String user;
	String pass;
	public String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection connection = null;
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		connection=sqlConnection.dbConnector();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTextField txtUser;
		JPasswordField txtPass;
		
		login = new JFrame();
		login.getContentPane().setBackground(new Color(238, 238, 238));
		login.setBounds(100, 100, 450, 200);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInserisciUsername = new JLabel("Inserisci Username");
		lblInserisciUsername.setBounds(81, 36, 119, 16);
		
		txtUser = new JTextField();
		txtUser.setBounds(212, 31, 130, 26);
		txtUser.setColumns(10);
		
		JLabel lblInserisciPassword = new JLabel("Inserisci Password");
		lblInserisciPassword.setBounds(81, 80, 116, 16);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(212, 75, 130, 26);
		txtPass.setColumns(10);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.setBounds(170, 108, 86, 29);
		login.getContentPane().setLayout(null);
		login.getContentPane().add(lblInserisciUsername);
		login.getContentPane().add(txtUser);
		login.getContentPane().add(lblInserisciPassword);
		login.getContentPane().add(txtPass);
		login.getContentPane().add(btnAccedi);
		
		JLabel labelicon = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/userloginicon.png")).getImage();
		labelicon.setIcon(new ImageIcon(img));
		labelicon.setBounds(6, 36, 60, 64);
		login.getContentPane().add(labelicon);
		btnAccedi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try
				{
					
				user= txtUser.getText().trim();
				pass= txtPass.getText().trim();
				
				JLabel labelLogin = new JLabel(user);
				labelLogin.setBounds(143, 7, 61, 16);
				labelLogin.setFont(new Font("Lucida Grande", Font.BOLD, 16));
				
				
				
				String sql ="select id,user,pass from admin where user='"+user+"'and pass='"+pass+"'";
				st=connection.createStatement();
				rs=st.executeQuery(sql);
				
				
				int count = 0;
				while(rs.next())
				{
					count=count+1;
					id=rs.getString(1);
					
				}
				
				if (count == 1){
					JOptionPane.showMessageDialog(null, "Login effettuato con successo!");
					login.dispose();
					Main window = new Main();
					window.main.getContentPane().add(labelLogin);
					
					window.main.setVisible(true);
					
				}else if(count > 1){
					JOptionPane.showMessageDialog(null, "Amministratore Duplicato, accesso negato!");
				}else{
					JOptionPane.showMessageDialog(null, "Amministratore non trovato!");
				}
				rs.close();
				st.close();
				}
		
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});

	}
}
