package View;

import java.awt.EventQueue;



import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Font;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.LoginModel;
import Model.DipendenteModel;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Component;

public class DipendenteView implements ActionListener{

	public JFrame frame;
	private DipendenteModel model;
	public String NomeDipendente;
	public String CognomeDipendente;
	public String CodiceFisc;
	public String Indirizzo;
	public String Email;
	public Date AnnoNascita;
	public enum Mansione{ 
		Cassa,
		Sala,
		Banco,
	};
	public Date Data_Assunzione;
	public Date Data_Licen;
	public Integer id;
	public JTable table1;
	private  JTextField textNomeDipendente;
	private JButton btnCercaMansione;
	private JButton btnNomeDipendente;
	

	


	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DipendenteView window = new DipendenteView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public DipendenteView() {
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(100, 100, 1278, 714));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBenvenuto = new JLabel("Benvenuto,");
		lblBenvenuto.setBounds(39, 6, 92, 16);
		lblBenvenuto.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		frame.getContentPane().add(lblBenvenuto);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 34, 1244, 627);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cerca dipendente", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 72, 692, 317);
		panel.add(scrollPane);
		
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(720, 72, 260, 317);
		panel.add(lblImg);
		
		

		JLabel lblNomeImg = new JLabel("");
		lblNomeImg.setBounds(748, 214, 61, 27);
		panel.add(lblNomeImg);
		
		JLabel lblCognomeImg = new JLabel("");
		lblCognomeImg.setBounds(748, 239, 79, 35);
		panel.add(lblCognomeImg);
		
		JLabel lblMansioneImg = new JLabel("");
		lblMansioneImg.setBounds(748, 264, 79, 35);
		panel.add(lblMansioneImg);
		
		JLabel lblEmailImg = new JLabel("");
		lblEmailImg.setBounds(748, 289, 79, 35);
		panel.add(lblEmailImg);
		
		JLabel lblTelefonoImg = new JLabel("");
		lblTelefonoImg.setBounds(748, 309, 79, 35);
		panel.add(lblTelefonoImg);
		
		
		

		table1 = new JTable();
		
		
		
	
		scrollPane.setViewportView(table1);
		//ricorda questione database
		
		


		textNomeDipendente = new JTextField();
		textNomeDipendente.setBounds(104, 33, 141, 26);
		textNomeDipendente.setColumns(10);
		panel.add(textNomeDipendente);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(635, 32, 141, 27);
		comboBox.addItem("");
		comboBox.addItem("Cassa");
		comboBox.addItem("Sala");
		comboBox.addItem("Banco");
		panel.add(comboBox);
		
		JLabel lblReparto = new JLabel("Scegli la mansione:");
		lblReparto.setBounds(508, 36, 125, 16);
		panel.add(lblReparto);
		
		btnCercaMansione = new JButton("Cerca per mansione");
		btnCercaMansione.setBounds(771, 30, 161, 29);
		panel.add(btnCercaMansione);
		
		btnNomeDipendente = new JButton("Cerca per nome");
		btnNomeDipendente.setBounds(257, 31, 148, 29);
		panel.add(btnNomeDipendente);
		
		JLabel lblNomeDipendente = new JLabel("Inserisci nome:");
		lblNomeDipendente.setBounds(6, 37, 104, 16);
		panel.add(lblNomeDipendente);
		
		JLabel lblNomeDipe = new JLabel("Nome: ");
		lblNomeDipe.setBounds(745, 180, 61, 16);
		panel.add(lblNomeDipe);
		
		JLabel lblCognomeDipe = new JLabel("Cognome: ");
		lblCognomeDipe.setBounds(745, 200, 61, 16);
		panel.add(lblCognomeDipe);
		
		JLabel lblMans = new JLabel("Mansione: ");
		lblMans.setBounds(745, 220, 61, 16);
		panel.add(lblMans);
		
		JLabel lblEmail= new JLabel("Email: ");
		lblEmail.setBounds(745, 240, 61, 16);
		panel.add(lblEmail);
		
		JLabel lblTel = new JLabel("Telefono: ");
		lblTel.setBounds(745, 260, 61, 16);
		panel.add(lblTel);
		
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
    }
   

	public void addNomeDipendenteListener(ActionListener log) {
       btnNomeDipendente.addActionListener(log);
       }
	

	public void addCercaMansioneListener(ActionListener log)
	{
		btnCercaMansione.addActionListener(log);
	
	}
	
	public void addMouseListener(MouseAdapter prc)
	{
		table1.addMouseListener(prc);
	}
	
	  public DipendenteModel getDipendente(){
	        model = new DipendenteModel(textNomeDipendente.getText().trim());
	        return model;       
	    }
	  
	  public void showMessage(String msg){
	        JOptionPane.showMessageDialog(null, msg);
	
}
}
