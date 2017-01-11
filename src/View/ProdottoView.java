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
import Model.ProdottoModel;

public class ProdottoView implements ActionListener{

	public JFrame main;
   
	
	private ProdottoModel model;
	public String nome;
	public String marca;
	public  Float prezzo;
	public  Date inizio_offerta;
	public  Date fine_offerta;
	public  Boolean offerta;
	public  Float prezzo_offerta;
	public  Integer qta;
	public  Date scadenza;
	public  String scaffale;
	public  String settore;
	public  String reparto;
	public String img;
	private  JTextField textNomeProdotto;
	public JTable table;
	private JTextField textNome;
	private JTextField textMarca;
	private JTextField textPrezzo;
	private JTextField textPrezzoOfferta;
	private JTextField textQta;
	private JTextField textScadenza;
	private JTextField textScaffale;
	private JTextField textInizioOfferta;
	private JTextField textFineOfferta;
	private JTable table_1;
	private JTextField textNome1;
	private JTextField textMarca1;
	private JTextField textPrezzo1;
	private JTextField textPrezzoOfferta1;
	private JTextField textQta1;
	private JTextField textScadenza1;
	private JTextField textScaffale1;
	private JTextField textInizioOfferta1;
	private JTextField textFineOfferta1;
	private JCheckBox checkBoxOfferta;
	private JComboBox comboBoxSettore;
	private JComboBox comboBoxReparto;
	private JCheckBox checkBoxOfferta1;
	private JComboBox comboBoxSettore1;
	private JComboBox comboBoxReparto1;
	private JButton btnCerca;
	private JButton btnCercaOfferte;
	private JButton btnNomeProdotto;
	private JButton btnInserisci;
	private JButton btnAzzera;

	
	public ProdottoView() {
		
		main = new JFrame();
		main.setBounds(100, 100, 1280, 800);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.getContentPane().setLayout(null);
		
		
		JLabel lblBenvenuto = new JLabel("Benvenuto,");
		lblBenvenuto.setBounds(39, 6, 92, 16);
		lblBenvenuto.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		main.getContentPane().add(lblBenvenuto);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 34, 1244, 627);
		main.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cerca prodotto", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 71, 701, 484);
		panel.add(scrollPane);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(745, 72, 436, 332);
		
		panel.add(lblImg);
		
		JLabel lblSettoreImg = new JLabel("");
		lblSettoreImg.setBounds(818, 433, 141, 16);
		panel.add(lblSettoreImg);
		
		JLabel lblRepartoImg = new JLabel("");
		lblRepartoImg.setBounds(818, 473, 141, 16);
		panel.add(lblRepartoImg);
		

		table = new JTable();
		
		
		
	
		scrollPane.setViewportView(table);
		//ricorda questione database
		
		


		textNomeProdotto = new JTextField();
		textNomeProdotto.setBounds(170, 33, 147, 26);
		textNomeProdotto.setColumns(10);
		panel.add(textNomeProdotto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(635, 32, 141, 27);
		comboBox.addItem("");
		comboBox.addItem("Magazzino");
		comboBox.addItem("Utility");
		comboBox.addItem("Alimentare");
		panel.add(comboBox);
		
		JLabel lblReparto = new JLabel("Scegli reparto");
		lblReparto.setBounds(541, 36, 92, 16);
		panel.add(lblReparto);
		
		btnCerca = new JButton("Cerca per reparto");
		btnCerca.setBounds(771, 30, 161, 29);
		panel.add(btnCerca);
		
		

		btnCercaOfferte = new JButton("Cerca Offerte");
		btnCercaOfferte.setBounds(965, 30, 117, 29);
		panel.add(btnCercaOfferte);
		
		
		btnNomeProdotto = new JButton("Cerca per nome prodotto");
		btnNomeProdotto.setBounds(321, 31, 208, 29);
		panel.add(btnNomeProdotto);
		
		

		JLabel lblNomeProdotto = new JLabel("Inserisci nome prodotto");
		lblNomeProdotto.setBounds(6, 37, 159, 16);
		panel.add(lblNomeProdotto);
		
		JLabel lblSettore_1 = new JLabel("Settore:");
		lblSettore_1.setBounds(745, 433, 61, 16);
		panel.add(lblSettore_1);
		
		JLabel lblReparto_2 = new JLabel("Reparto:");
		lblReparto_2.setBounds(745, 473, 61, 16);
		panel.add(lblReparto_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Inserisci prodotto", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblInserisci = new JLabel("INSERISCI:");
		lblInserisci.setBounds(52, 29, 70, 16);
		panel_1.add(lblInserisci);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(52, 57, 44, 16);
		panel_1.add(lblNome);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(52, 95, 44, 16);
		panel_1.add(lblMarca);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(52, 141, 44, 16);
		panel_1.add(lblPrezzo);
		
		JLabel lblInizioOfferta = new JLabel("Inizio offerta");
		lblInizioOfferta.setBounds(344, 57, 81, 16);
		panel_1.add(lblInizioOfferta);
		
		JLabel lblFineOfferta = new JLabel("Fine offerta");
		lblFineOfferta.setBounds(344, 101, 81, 16);
		panel_1.add(lblFineOfferta);
		
		JLabel lblOfferta = new JLabel("Offerta");
		lblOfferta.setBounds(344, 154, 81, 16);
		panel_1.add(lblOfferta);
		
		JLabel lblPrezzoOfferta = new JLabel("Prezzo offerta");
		lblPrezzoOfferta.setBounds(344, 197, 87, 16);
		panel_1.add(lblPrezzoOfferta);
		
		JLabel lblQuantit = new JLabel("Quantità");
		lblQuantit.setBounds(52, 175, 61, 16);
		panel_1.add(lblQuantit);
		
		JLabel lblScadenza = new JLabel("Scadenza");
		lblScadenza.setBounds(52, 214, 61, 16);
		panel_1.add(lblScadenza);
		
		JLabel lblScaffale = new JLabel("Scaffale");
		lblScaffale.setBounds(52, 329, 87, 16);
		panel_1.add(lblScaffale);
		
		JLabel lblReparto_1 = new JLabel("Reparto");
		lblReparto_1.setBounds(52, 289, 48, 16);
		panel_1.add(lblReparto_1);
		
		textNome = new JTextField();
		textNome.setBounds(150, 52, 153, 26);
		panel_1.add(textNome);
		textNome.setColumns(10);
		nome=textNome.getText();
		
		textMarca = new JTextField();
		textMarca.setBounds(150, 90, 153, 26);
		textMarca.setColumns(10);
		panel_1.add(textMarca);
		marca=textMarca.getText();
		
		textPrezzo = new JTextField();
		textPrezzo.setBounds(150, 136, 75, 26);
		textPrezzo.setColumns(10);
		panel_1.add(textPrezzo);
		//prezzo=Float.parseFloat(textPrezzo.getText());
		
		textPrezzoOfferta = new JTextField();
		textPrezzoOfferta.setBounds(442, 192, 75, 26);
		textPrezzoOfferta.setColumns(10);
		panel_1.add(textPrezzoOfferta);
		//prezzo_offerta=Float.parseFloat(textPrezzoOfferta.getText());
		
		textQta = new JTextField();
		textQta.setBounds(150, 174, 153, 26);
		textQta.setColumns(10);
		panel_1.add(textQta);
		//qta=Integer.parseInt(textQta.getText());
		
		comboBoxSettore = new JComboBox();
		comboBoxSettore.setBounds(151, 246, 152, 27);
		panel_1.add(comboBoxSettore);
		comboBoxSettore.addItem("");
		comboBoxSettore.addItem("Frutta e Verdura");
		comboBoxSettore.addItem("Bancone alimentare");
		comboBoxSettore.addItem("Macelleria");
		comboBoxSettore.addItem("Pescheria");
		comboBoxSettore.addItem("Frigoriferi");
		comboBoxSettore.addItem("Congelatori");
		comboBoxSettore.addItem("Dolciario");
		comboBoxSettore.addItem("Panificio");
		comboBoxSettore.addItem("Bevande");
		comboBoxSettore.addItem("Pasta");
		comboBoxSettore.addItem("Condimenti");
		comboBoxSettore.addItem("Cancelleria");
		comboBoxSettore.addItem("Per la casa");
		comboBoxSettore.addItem("Igene");
		comboBoxSettore.addItem("Detersivi");
		settore=comboBoxSettore.getSelectedItem().toString();
		
		comboBoxReparto = new JComboBox();
		comboBoxReparto.setBounds(150, 285, 153, 27);
		panel_1.add(comboBoxReparto);
		comboBoxReparto.addItem("");
		comboBoxReparto.addItem("Alimentare");
		comboBoxReparto.addItem("Utility");
		comboBoxReparto.addItem("Magazzino");
		reparto=comboBoxReparto.getSelectedItem().toString();
		
		checkBoxOfferta = new JCheckBox("");
		checkBoxOfferta.setBounds(442, 154, 34, 23);
		panel_1.add(checkBoxOfferta);
		if (checkBoxOfferta.isSelected()==true){
			offerta=true;
		}else{
			offerta=false;
		}
		
		
		textScadenza = new JTextField();
		textScadenza.setBounds(150, 209, 153, 26);
		textScadenza.setColumns(10);
		panel_1.add(textScadenza);
		//scadenza=Date.valueOf(textScadenza.getText());
		
		textScaffale = new JTextField();
		textScaffale.setBounds(150, 324, 75, 26);
		panel_1.add(textScaffale);
		textScaffale.setColumns(10);
		scaffale=textScaffale.getText();
		
		textInizioOfferta = new JTextField();
		textInizioOfferta.setBounds(442, 52, 130, 26);
		panel_1.add(textInizioOfferta);
		textInizioOfferta.setColumns(10);
		//inizio_offerta=Date.valueOf(textInizioOfferta.getText());
		
		textFineOfferta = new JTextField();
		textFineOfferta.setColumns(10);
		textFineOfferta.setBounds(442, 96, 130, 26);
		panel_1.add(textFineOfferta);
		//fine_offerta=Date.valueOf(textFineOfferta.getText());
		
		String userDir = System.getProperty("user.home");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File (userDir +"/Documents/workspace/OOP1617/img"));
		fileChooser.setBounds(160, 353, 265, 151);

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		//img= fileChooser.getSelectedFile().getName();
	
		panel_1.add(fileChooser);
		
	
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(326, 535, 117, 29);
		panel_1.add(btnInserisci);
		
		JButton btnAzzera = new JButton("Azzera");
		btnAzzera.setBounds(455, 535, 117, 29);
		panel_1.add(btnAzzera);
		
		JLabel lblSettore = new JLabel("Settore");
		lblSettore.setBounds(52, 250, 44, 16);
		panel_1.add(lblSettore);
		
		JLabel label = new JLabel("(*)");
		label.setBounds(96, 57, 19, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setBounds(94, 95, 19, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setBounds(96, 141, 19, 16);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setBounds(110, 175, 19, 16);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setBounds(114, 214, 19, 16);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("(*)");
		label_5.setBounds(103, 250, 19, 16);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("(*)");
		label_6.setBounds(103, 289, 19, 16);
		panel_1.add(label_6);
		
		JLabel lblCampiObbligatori = new JLabel("(*) Campi obbligatori");
		lblCampiObbligatori.setBounds(52, 540, 139, 16);
		panel_1.add(lblCampiObbligatori);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(326, 45, 267, 184);
		panel_1.add(desktopPane);
		
		JLabel lblImgScaffale = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Scaffalatura.jpg")).getImage();
		lblImgScaffale.setIcon(new ImageIcon(img));
		lblImgScaffale.setBounds(617, 45, 550, 413);
		panel_1.add(lblImgScaffale);
		
		JLabel lblNewLabel = new JLabel("Scegli immagine");
		lblNewLabel.setBounds(52, 366, 107, 16);
		panel_1.add(lblNewLabel);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
    }
   

	public void addCercaRepartoListener(ActionListener log) {
       btnCerca.addActionListener(log);
       }
	
	public void addMouseListener(MouseAdapter prc)
	{
		table.addMouseListener(prc);
	}
	
	public void addCercaOffertaListener(ActionListener log)
	{
		btnCercaOfferte.addActionListener(log);
	
	}
	
	
	public void addNomeProdottoListener(ActionListener log) {
	       btnNomeProdotto.addActionListener(log);
	       }
	
	public void addInserisciProdottoListener(ActionListener log) {
	       btnInserisci.addActionListener(log);
	       }
	
	public void addAzzeraProdottoListener(ActionListener log) {
	       btnAzzera.addActionListener(log);
	       }
	  /*public ProdottoModel getProdotto(){
	        model = new ProdottoModel(nome,marca,prezzo,inizio_offerta,fine_offerta,offerta,prezzo_offerta,qta,scadenza,scaffale,settore,reparto,img);
	        return model;       
	    }*/
	  
	  public ProdottoModel getProdotto(){
	        model = new ProdottoModel(textNomeProdotto.getText().trim());
	        return model;       
	    }
	  public void showMessage(String msg){
	        JOptionPane.showMessageDialog(null, msg);
	    }
	
	

}
