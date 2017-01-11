package View;


import java.awt.Image
;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.LoginModel;

public class LoginView1 implements ActionListener{

	public JFrame frame;
	
   
    private LoginModel model;
    private JButton btnAccedi;
    private JPasswordField textPass;
    private JTextField textUser;
	/*
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView1 window = new LoginView1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the application.
	 */
	public LoginView1() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Inserisci Username:");
		lblUser.setBounds(109, 35, 131, 16);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPass = new JLabel("Inserisci Password:");
		lblPass.setBounds(109, 81, 131, 16);
		frame.getContentPane().add(lblPass);
		
		textUser = new JTextField();
		textUser.setBounds(270, 30, 130, 26);
		frame.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setColumns(10);
		textPass.setBounds(270, 76, 130, 26);
		frame.getContentPane().add(textPass);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(20, 30, 77, 87);
		Image img= new ImageIcon(this.getClass().getResource("/userloginicon.png")).getImage();
		lblImg.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblImg);
		
		btnAccedi = new JButton("Accedi");
		btnAccedi.setBounds(190, 131, 117, 29);
		btnAccedi.addActionListener(this);
		frame.getContentPane().add(btnAccedi);

	}
	
	public void actionPerformed(ActionEvent e) {
    }
   
    public LoginModel getUser(){
        model = new LoginModel(textUser.getText().trim(), textPass.getText().trim());
        return model;       
    }
   
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
   
    
	
    public void addLoginListener(ActionListener log) {
          btnAccedi.addActionListener(log);
          
          
        }

}
