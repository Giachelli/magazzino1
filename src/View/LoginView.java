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

/**
 * Classe LoginView1.java
 * Questa classe implementa la vista, ovvero tutti i componenti visivi relativi
 * e appartenenti al frame "frame".
 * 
 * @author Iezzi Valerio
 */
public class LoginView implements ActionListener{

	public JFrame frameLogin;
	
   
    private LoginModel model;
    private JButton btnAccedi;
    private JPasswordField textPass;
    private JTextField textUser;
	

	
	public LoginView() {
		
		frameLogin = new JFrame();
		frameLogin.setBounds(100, 100, 450, 200);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Inserisci Username:");
		lblUser.setBounds(109, 35, 131, 16);
		frameLogin.getContentPane().add(lblUser);
		
		JLabel lblPass = new JLabel("Inserisci Password:");
		lblPass.setBounds(109, 81, 131, 16);
		frameLogin.getContentPane().add(lblPass);
		
		textUser = new JTextField();
		textUser.setBounds(270, 30, 130, 26);
		frameLogin.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setColumns(10);
		textPass.setBounds(270, 76, 130, 26);
		frameLogin.getContentPane().add(textPass);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(20, 30, 77, 87);
		Image img= new ImageIcon(this.getClass().getResource("/userloginicon.png")).getImage();
		lblImg.setIcon(new ImageIcon(img));
		frameLogin.getContentPane().add(lblImg);
		
		
		
		btnAccedi = new JButton("Accedi");
		btnAccedi.setBounds(190, 131, 117, 29);
		btnAccedi.addActionListener(this);
		frameLogin.getContentPane().add(btnAccedi);

	}
	
	public void actionPerformed(ActionEvent e) {
    }
	/**
	 * getUser ci mermette di recuperare e passare al model il testo inserirto nelle textUser e textPass.
	 */
    public LoginModel getUser(){
        model = new LoginModel(textUser.getText().trim(), textPass.getText().trim());
        return model;       
    }
   
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
   
    /**
	 * Qui viene dichiarata la funzione/azione del pulsante btnAccedi, implementata poi nel controller.
	 */
	
    public void addLoginListener(ActionListener log) {
          btnAccedi.addActionListener(log);
          
          
        }

}
