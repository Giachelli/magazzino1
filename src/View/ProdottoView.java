package View;

import java.awt.EventQueue;




import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Font;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.LoginModel;
import Model.ProdottoModel;
//import Controller.ProdottoController;
import Controller.LoginController;
import net.proteanit.sql.DbUtils;
import com.connectiondb.*;


import View.LoginView;
import com.application.*;


/**
 * Classe ProdottoView.java
 * Questa classe implementa la vista, ovvero tutti i componenti visivi 
 * relativi e appartenenti al frame "main".
 * 
 * @author Iezzi Valerio
 */
public class ProdottoView implements ActionListener{

	public JFrame frameProdotto;
	Connection connection = null;
	
	private ProdottoModel model;
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
	public JTable table_1;
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
	private JComboBox comboBox;
	public JFileChooser fileChooser;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnLogout;
	private JButton btnCarica;
	private JButton btnCarica2;
	private JButton btnImmagine;
	private JButton btnImmagine1;
	public JLabel lblImmagine;
	private JButton btnDipendenti;
	private JButton btnTurni;

	
	public ProdottoView() {
		
		frameProdotto = new JFrame();
		frameProdotto.setBounds(100, 100, 1280, 800);
		frameProdotto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameProdotto.getContentPane().setLayout(null);
		
        connection=sqlConnection.dbConnector();

		JLabel lblBenvenuto = new JLabel("Benvenuto,");
		lblBenvenuto.setBounds(39, 6, 92, 16);
		lblBenvenuto.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		frameProdotto.getContentPane().add(lblBenvenuto);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 34, 1244, 627);
		frameProdotto.getContentPane().add(tabbedPane);
		
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
		lblSettoreImg.setBounds(818, 433, 200, 16);
		panel.add(lblSettoreImg);
		
		JLabel lblRepartoImg = new JLabel("");
		lblRepartoImg.setBounds(818, 473, 200, 16);
		panel.add(lblRepartoImg);
		

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					lblImg.setVisible(false);
					lblSettoreImg.setVisible(false);
					lblRepartoImg.setVisible(false);
					int row=table.getSelectedRow();
					String settore=(table.getModel().getValueAt(row, 11)).toString();
					String reparto=(table.getModel().getValueAt(row, 12)).toString();
					lblSettoreImg.setVisible(true);
					lblRepartoImg.setVisible(true);
					lblSettoreImg.setText(settore);
					lblRepartoImg.setText(reparto);
					
					String img1=(table.getModel().getValueAt(row, 13)).toString();
					
					Image img= new ImageIcon(this.getClass().getResource("/"+img1+"")).getImage();
					lblImg.setVisible(true);
					
					lblImg.setIcon(new ImageIcon(img));
					
					}catch(Exception e1){
					//e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		textNomeProdotto = new JTextField();
		textNomeProdotto.setBounds(170, 33, 147, 26);
		textNomeProdotto.setColumns(10);
		panel.add(textNomeProdotto);
		
		
		comboBox = new JComboBox();
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
		
		btnCarica = new JButton("Carica prodotti in magazzino");
		btnCarica.setBounds(0, 6, 208, 29);
		panel.add(btnCarica);
		
		
		//inizioPanel_1
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
		
		
		textMarca = new JTextField();
		textMarca.setBounds(150, 90, 153, 26);
		textMarca.setColumns(10);
		panel_1.add(textMarca);
	
		
		textPrezzo = new JTextField();
		textPrezzo.setBounds(150, 136, 75, 26);
		textPrezzo.setColumns(10);
		panel_1.add(textPrezzo);
		
		
		textPrezzoOfferta = new JTextField();
		textPrezzoOfferta.setBounds(442, 192, 75, 26);
		textPrezzoOfferta.setColumns(10);
		
		panel_1.add(textPrezzoOfferta);
		
		
		textQta = new JTextField();
		textQta.setBounds(150, 174, 153, 26);
		textQta.setColumns(10);
		panel_1.add(textQta);
		
		
		comboBoxSettore = new JComboBox();
		comboBoxSettore.setBounds(151, 246, 152, 27);
		panel_1.add(comboBoxSettore);
		comboBoxSettore.addItem("");
		comboBoxSettore.addItem("Frutta & Verdura");
		comboBoxSettore.addItem("I Freschi & Surgelati");
		comboBoxSettore.addItem("Panetteria & Pasticceria");
		comboBoxSettore.addItem("Macelleria, Polletteria & Pescheria");
		comboBoxSettore.addItem("Salumi & Formaggi");
		comboBoxSettore.addItem("Le stagioni di Iperal");
		comboBoxSettore.addItem("Alimentari confezionati");
		comboBoxSettore.addItem("Bazar & Tessile");
		comboBoxSettore.addItem("Elettronica");
		comboBoxSettore.addItem("Profumeria & Infanzia");
		comboBoxSettore.addItem("Detergenza & Pulizia casa");
		comboBoxSettore.addItem("Prodotti per animali");
		comboBoxSettore.addItem("Liquidi & Bevande");
		
		
		comboBoxReparto = new JComboBox();
		comboBoxReparto.setBounds(150, 285, 153, 27);
		panel_1.add(comboBoxReparto);
		comboBoxReparto.addItem("");
		comboBoxReparto.addItem("Alimentare");
		comboBoxReparto.addItem("Utility");
		comboBoxReparto.addItem("Magazzino");
	
		
		checkBoxOfferta = new JCheckBox("");
		checkBoxOfferta.setBounds(442, 154, 34, 23);
		panel_1.add(checkBoxOfferta);
		
		
		
		textScadenza = new JTextField();
		textScadenza.setBounds(150, 209, 153, 26);
		textScadenza.setColumns(10);
		panel_1.add(textScadenza);
		
		
		textScaffale = new JTextField();
		textScaffale.setBounds(150, 324, 75, 26);
		panel_1.add(textScaffale);
		
		textScaffale.setColumns(10);
	
		
		textInizioOfferta = new JTextField();
		textInizioOfferta.setBounds(442, 52, 130, 26);
		panel_1.add(textInizioOfferta);
		
		textInizioOfferta.setColumns(10);
	
		
		textFineOfferta = new JTextField();
		textFineOfferta.setColumns(10);
		textFineOfferta.setBounds(442, 96, 130, 26);
		
		panel_1.add(textFineOfferta);
		
		
		String userDir = System.getProperty("user.home");
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File (userDir +"/Documents/workspace/OOP1617/img"));
		//fileChooser.setBounds(160, 353, 265, 151);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileFilter filtroJpg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
		FileFilter filtroPng = new FileNameExtensionFilter("PNG file", "png");
		fileChooser.addChoosableFileFilter(filtroPng);
		fileChooser.setFileFilter(filtroJpg);
		
		panel_1.add(fileChooser);
		
	
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(326, 535, 117, 29);
		panel_1.add(btnInserisci);
		
		btnAzzera = new JButton("Azzera");
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
		
		btnImmagine = new JButton("Scegli immagine");
		btnImmagine.setBounds(160, 361, 151, 29);
		panel_1.add(btnImmagine);
		
		
		//InizioPanel_2
		

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Modifica Prodotto", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 34, 805, 485);
		panel_2.add(scrollPane_1);
		
		comboBoxSettore1 = new JComboBox();
		comboBoxSettore1.setBounds(980, 328, 133, 27);
		panel_2.add(comboBoxSettore1);
		comboBoxSettore1.addItem("");
		comboBoxSettore1.addItem("Frutta & Verdura");
		comboBoxSettore1.addItem("I Freschi & Surgelati");
		comboBoxSettore1.addItem("Panetteria & Pasticceria");
		comboBoxSettore1.addItem("Macelleria, Polletteria & Pescheria");
		comboBoxSettore1.addItem("Salumi & Formaggi");
		comboBoxSettore1.addItem("Le stagioni di Iperal");
		comboBoxSettore1.addItem("Alimentari confezionati");
		comboBoxSettore1.addItem("Bazar & Tessile");
		comboBoxSettore1.addItem("Elettronica");
		comboBoxSettore1.addItem("Profumeria & Infanzia");
		comboBoxSettore1.addItem("Detergenza & Pulizia casa");
		comboBoxSettore1.addItem("Prodotti per animali");
		comboBoxSettore1.addItem("Liquidi & Bevande");
		
		
		comboBoxReparto1 = new JComboBox();
		comboBoxReparto1.setBounds(980, 367, 133, 27);
		panel_2.add(comboBoxReparto1);
		comboBoxReparto1.addItem("");
		comboBoxReparto1.addItem("Alimentare");
		comboBoxReparto1.addItem("Utility");
		comboBoxReparto1.addItem("Magazzino");
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					int row=table_1.getSelectedRow();
					String codice_=(table_1.getModel().getValueAt(row, 0)).toString();
					String query="select * from prodotto where codice='"+codice_+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while(rs.next()){
						textNome1.setText(rs.getString("nome"));
						textMarca1.setText(rs.getString("marca"));
						textPrezzo1.setText(rs.getString("prezzo"));
						
						
						textPrezzoOfferta1.setText(rs.getString("prezzo_offerta"));
						
						textQta1.setText(rs.getString("qta"));
						textScadenza1.setText(rs.getString("scadenza"));
						textInizioOfferta1.setText(rs.getString("inizio_offerta"));
						textFineOfferta1.setText(rs.getString("fine_offerta"));
						textScaffale1.setText(rs.getString("scaffale"));
						lblImmagine.setText(rs.getString("img"));
						int settore=0;
						int reparto=0;
						String rep;
						String set;
						set=rs.getString("settore");
						rep=rs.getString("reparto");
						if(set.equals("Frutta & Verdura")){
							settore=1;
						}else if(set.equals("I Freschi & Surgelati")){
							settore=2;
						}else if(set.equals("Panetteria & Pasticceria")){
							settore=3;
						}else if(set.equals("Macelleria, Polletteria & Pescheria")){
							settore=4;
						}else if(set.equals("Salumi & Formaggi")){
							settore=5;
						}else if(set.equals("Le stagioni di Iperal")){
							settore=6;
						}else if(set.equals("Alimentari confezionati")){
							settore=7;
						}else if(set.equals("Bazar & Tessile")){
							settore=8;
						}else if(set.equals("Elettronica")){
							settore=9;
						}else if(set.equals("Profumeria & Infanzia")){
							settore=10;
						}else if(set.equals("Detergenza & Pulizia casa")){
							settore=11;
						}else if(set.equals("Prodotti per animali")){
							settore=12;
						}else if(set.equals("Liquidi & Bevande")){
							settore=13;
						}else{
							settore=0;
						}
						
						if(rep.equals("Alimentare")){
							reparto=1;
						}else if(rep.equals("Utility")){
							reparto=2;
						}else if(rep.equals("Magazzino")){
							reparto=3;
						}else{
							reparto=0;
						}
						
						comboBoxSettore1.setSelectedIndex(settore);
						comboBoxReparto1.setSelectedIndex(reparto);
						
						int offerta;
						offerta=Integer.parseInt(rs.getString("offerta"));
						if (offerta==1){
							checkBoxOfferta1.setSelected(true);
						}else{
							checkBoxOfferta1.setSelected(false);
						}
					}
					pst.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		
		scrollPane_1.setViewportView(table_1);
		JLabel lblModifica = new JLabel("MODIFICA:");
		lblModifica.setBounds(872, 6, 70, 16);
		panel_2.add(lblModifica);
		
		JLabel lblNome1 = new JLabel("Nome");
		lblNome1.setBounds(872, 30, 44, 16);
		panel_2.add(lblNome1);
		
		JLabel lblMarca1= new JLabel("Marca");
		lblMarca1.setBounds(872, 58, 44, 16);
		panel_2.add(lblMarca1);
		
		JLabel lblPrezzo1 = new JLabel("Prezzo");
		lblPrezzo1.setBounds(872, 86, 44, 16);
		panel_2.add(lblPrezzo1);
		
		JLabel lblQta1 = new JLabel("Quantità");
		lblQta1.setBounds(872, 276, 61, 16);
		panel_2.add(lblQta1);
		
		JLabel lblScadenza1 = new JLabel("Scadenza");
		lblScadenza1.setBounds(872, 304, 61, 16);
		panel_2.add(lblScadenza1);
		
		JLabel lblScaffale1 = new JLabel("Scaffale");
		lblScaffale1.setBounds(872, 406, 87, 16);
		panel_2.add(lblScaffale1);
		
		JLabel lblReparto1= new JLabel("Reparto");
		lblReparto1.setBounds(872, 367, 48, 16);
		panel_2.add(lblReparto1);
		
		textNome1 = new JTextField();
		textNome1.setColumns(10);
		textNome1.setBounds(980, 25, 130, 26);
		panel_2.add(textNome1);
		
		textMarca1 = new JTextField();
		textMarca1.setColumns(10);
		textMarca1.setBounds(980, 53, 130, 26);
		panel_2.add(textMarca1);
		
		textPrezzo1 = new JTextField();
		textPrezzo1.setColumns(10);
		textPrezzo1.setBounds(980, 81, 75, 26);
		panel_2.add(textPrezzo1);
		
		textQta1 = new JTextField();
		textQta1.setColumns(10);
		textQta1.setBounds(980, 271, 75, 26);
		panel_2.add(textQta1);
		
		
		
		textScadenza1 = new JTextField();
		textScadenza1.setColumns(10);
		textScadenza1.setBounds(980, 299, 130, 26);
		panel_2.add(textScadenza1);
		
		textScaffale1 = new JTextField();
		textScaffale1.setColumns(10);
		textScaffale1.setBounds(980, 401, 75, 26);
		panel_2.add(textScaffale1);
		
		JLabel label_19 = new JLabel("Settore");
		label_19.setBounds(872, 332, 44, 16);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("(*)");
		label_20.setBounds(914, 30, 19, 16);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("(*)");
		label_21.setBounds(914, 58, 19, 16);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel("(*)");
		label_22.setBounds(923, 86, 19, 16);
		panel_2.add(label_22);
		
		JLabel label_23 = new JLabel("(*)");
		label_23.setBounds(927, 276, 19, 16);
		panel_2.add(label_23);
		
		JLabel label_24 = new JLabel("(*)");
		label_24.setBounds(937, 302, 19, 21);
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel("(*)");
		label_25.setBounds(923, 332, 19, 16);
		panel_2.add(label_25);
		
		JLabel label_26 = new JLabel("(*)");
		label_26.setBounds(923, 367, 19, 16);
		panel_2.add(label_26);
		
		JLabel label_27 = new JLabel("(*) Campi obbligatori");
		label_27.setBounds(929, 543, 139, 16);
		panel_2.add(label_27);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(587, 538, 117, 29);
		panel_2.add(btnModifica);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(716, 538, 117, 29);
		panel_2.add(btnElimina);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(861, 114, 256, 143);
		panel_2.add(desktopPane_1);
		
		JLabel lblInizioOfferta1 = new JLabel("Inizio offerta");
		lblInizioOfferta1.setBounds(16, 11, 81, 16);
		desktopPane_1.add(lblInizioOfferta1);
		
		textInizioOfferta1 = new JTextField();
		textInizioOfferta1.setBounds(120, 6, 130, 26);
		desktopPane_1.add(textInizioOfferta1);
		textInizioOfferta1.setColumns(10);
		
		JLabel lblFineOfferta1 = new JLabel("Fine offerta");
		lblFineOfferta1.setBounds(16, 40, 81, 21);
		desktopPane_1.add(lblFineOfferta1);
		
		textFineOfferta1 = new JTextField();
		textFineOfferta1.setBounds(120, 37, 130, 26);
		desktopPane_1.add(textFineOfferta1);
		textFineOfferta1.setColumns(10);
		
		JLabel lblOfferta1 = new JLabel("Offerta");
		lblOfferta1.setBounds(16, 76, 81, 16);
		desktopPane_1.add(lblOfferta1);
		
		checkBoxOfferta1 = new JCheckBox("");
		checkBoxOfferta1.setBounds(120, 75, 34, 23);
		desktopPane_1.add(checkBoxOfferta1);
		
		JLabel lblPrezzoOfferta1 = new JLabel("Prezzo offerta");
		lblPrezzoOfferta1.setBounds(16, 110, 87, 16);
		desktopPane_1.add(lblPrezzoOfferta1);
		
		textPrezzoOfferta1 = new JTextField();
		textPrezzoOfferta1.setBounds(120, 105, 75, 26);
		desktopPane_1.add(textPrezzoOfferta1);
		textPrezzoOfferta1.setColumns(10);
		
		btnCarica2 = new JButton("Carica prodotti");
		btnCarica2.setBounds(21, 6, 139, 29);
		panel_2.add(btnCarica2);
		
		btnImmagine1 = new JButton("Scegli immagine");
		btnImmagine1.setBounds(872, 439, 152, 29);
		panel_2.add(btnImmagine1);
		
		lblImmagine = new JLabel("");
		lblImmagine.setBounds(1047, 444, 61, 16);
		panel_2.add(lblImmagine);
	
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1182, 2, 92, 29);
		frameProdotto.getContentPane().add(btnLogout);
		
		btnDipendenti = new JButton("Dipendenti");
		btnDipendenti.setBounds(284, 2, 117, 29);
		frameProdotto.getContentPane().add(btnDipendenti);
		
		btnTurni = new JButton("Turni");
		btnTurni.setBounds(400, 2, 117, 29);
		frameProdotto.getContentPane().add(btnTurni);
		
	}
	
	/**
	 * refreshTable1, con connessione preventiva al db, esegue una query che
	 * visualizza nella table_1 tutti i prodotti dell'utente loggato. 
	 */	
public void refreshTable1(String codice){
		
		try {
			String sql1 ="select * from prodotto where id='"+codice+"'";
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(sql1);
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * refreshTable, con connessione preventiva al db, esegue una query che
 * visualizza nella table tutti i prodotti dell'utente loggato con reparto= Magazzino e quantità <5
 * ordinati per quantità ascendente. 
 */		
public void refreshTable(String codice){
		
		try {
			String sql ="select * from prodotto where reparto='Magazzino' and qta < 5 and id='"+codice+"'ORDER BY qta ASC";
			PreparedStatement pst=connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void refreshForm(){
		textNome.setText("");
		textMarca.setText("");
		textPrezzo.setText("");
		textQta.setText("");
		textScadenza.setText("");
		textInizioOfferta.setText("");
		textFineOfferta.setText("");
		textPrezzoOfferta.setText("");
		textScaffale.setText("");
		checkBoxOfferta.setSelected(false);;
		comboBoxSettore.setSelectedItem("");
		comboBoxReparto.setSelectedItem("");
		textNome1.setText("");
		textMarca1.setText("");
		textPrezzo1.setText("");
		textQta1.setText("");
		textScadenza1.setText("");
		textInizioOfferta1.setText("");
		textFineOfferta1.setText("");
		textPrezzoOfferta1.setText("");
		textScaffale1.setText("");
		checkBoxOfferta1.setSelected(false);
		comboBoxSettore1.setSelectedItem("");
		comboBoxReparto1.setSelectedItem("");

	}
	
	public void mostraprodotti(String codice){
		connection=sqlConnection.dbConnector();
		String sql ="select * from prodotto where reparto='Magazzino' and qta < 5 and id='"+codice+"'ORDER BY qta ASC";
	try {
		
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		pst.close();
		rs.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
}
	public void mostraprodotti2(String codice){
		//connection=sqlConnection.dbConnector();
		String sql1 ="select * from prodotto where id='"+codice+"'";
		
		try {
			Statement st=connection.createStatement();
			 ResultSet rs = st.executeQuery(sql1);
			 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			 st.close();
			 rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
    }
   

	public void addCercaRepartoListener(ActionListener log) {
       btnCerca.addActionListener(log);
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
	  
	/**
	 * getProdotto:
	 * recupero e passa al model il nome del prodotto dalla textNomeProdotto, e il reparto selezionato dalla comboBox.
	 * 
	 */	
	  public ProdottoModel getProdotto(){
	        model = new ProdottoModel(textNomeProdotto.getText().trim(),comboBox.getSelectedItem().toString());
	        return model;       
	    }
	  
	  /**
		 * getProdotto2:
		 * recupera e passa al model tutti i campi inseriti nella form per l'inserimento del prodotto.
		 * 
		 */	
	  public ProdottoModel getProdotto2(){
		  String reparto = null;
		  Date inizio_offerta = null,fine_offerta=null,scadenza = null;
		  Float prezzo_offerta = null,prezzo = null;
		  Integer qta = null;
		
		  
		  if(textInizioOfferta.getText().isEmpty()==false){	
			  try{
			  inizio_offerta=Date.valueOf(textInizioOfferta.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di inizio offerta correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  inizio_offerta=null;
			  
		  }
		  if(textFineOfferta.getText().isEmpty()==false){	
			  try{
			  fine_offerta=Date.valueOf(textFineOfferta.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di fine o correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  fine_offerta=null;
		  }
		  if(textPrezzoOfferta.getText().isEmpty()==false){	
			  try{
			  prezzo_offerta=Float.parseFloat(textPrezzoOfferta.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire il prezzo offerta correttamente! ES:(2.0)");
			  }
		  }else{
			  prezzo_offerta=null;
		  }
		
			  
		  if(textPrezzo.getText().isEmpty()==false){
			  try{
			  prezzo=Float.parseFloat(textPrezzo.getText().trim());
			  }catch(Exception e){
			  JOptionPane.showMessageDialog(null, "Inserire il prezzo correttamente! ES:(2.0)");
			  }
		  }else{
				  
			  }  
		   
		  if(textScadenza.getText().isEmpty()==false){	
			  try{
			  scadenza=Date.valueOf(textScadenza.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  
		  }
		  
		  
		  if(textQta.getText().isEmpty()==false){
			  try{
			  qta=Integer.parseInt(textQta.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la quantità in modo corretto!");
			  }
		  }else{
			  
		  }
		  
		 
			 reparto=comboBoxReparto.getSelectedItem().toString();
			
			 model = new ProdottoModel(textNome.getText().trim(),textMarca.getText().trim(),prezzo,
				  prezzo_offerta,qta,comboBoxSettore.getSelectedItem().toString(),
				  reparto,checkBoxOfferta.isSelected(),scadenza,
				  textScaffale.getText().trim(),inizio_offerta,fine_offerta,img); 
		  return model;
	  }
	  /**
		 * getProdotto3:
		 * recupera e passa al model tutti i campi inseriti nella form per la modifica del prodotto.
		 * 
		 */	
	  public ProdottoModel getProdotto3(){
		  String reparto = null;
		  Date inizio_offerta = null,fine_offerta=null,scadenza = null;
		  Float prezzo_offerta = null,prezzo = null;
		  Integer qta = null;
		  
		  if(textInizioOfferta1.getText().isEmpty()==false){	
			  try{
			  inizio_offerta=Date.valueOf(textInizioOfferta1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di inizio offerta correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  inizio_offerta=null;
			  
		  }
		  if(textFineOfferta1.getText().isEmpty()==false){	
			  try{
			  fine_offerta=Date.valueOf(textFineOfferta1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di fine o correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  fine_offerta=null;
		  }
		  if(textPrezzoOfferta1.getText().isEmpty()==false){	
			  try{
			  prezzo_offerta=Float.parseFloat(textPrezzoOfferta1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire il prezzo offerta correttamente! ES:(2.0)");
			  }
		  }else{
			  prezzo_offerta=null;
		  }
		
			  
		  if(textPrezzo1.getText().isEmpty()==false){
			  try{
			  prezzo=Float.parseFloat(textPrezzo1.getText().trim());
			  }catch(Exception e){
			  JOptionPane.showMessageDialog(null, "Inserire il prezzo correttamente! ES:(2.0)");
			  }
		  }else{
				  
			  }  
		   
		  if(textScadenza1.getText().isEmpty()==false){	
			  try{
			  scadenza=Date.valueOf(textScadenza1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  
		  }
		  
		  
		  if(textQta1.getText().isEmpty()==false){
			  try{
			  qta=Integer.parseInt(textQta1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la quantità in modo corretto!");
			  }
		  }else{
			  
		  }
		  
		  reparto=comboBoxReparto1.getSelectedItem().toString();
		  
		  
		  model = new ProdottoModel(textNome1.getText().trim(),textMarca1.getText().trim(),prezzo,
				  prezzo_offerta,qta,comboBoxSettore1.getSelectedItem().toString(),
				  reparto,checkBoxOfferta1.isSelected(),scadenza,
				  textScaffale1.getText().trim(),inizio_offerta,fine_offerta,img);
		  return model;
	  }
	  public void showMessage(String msg){
	        JOptionPane.showMessageDialog(null, msg);
	    }
	
	  public void addModificaListener(ActionListener log) {
		  	btnModifica.addActionListener(log);
	       }
	  public void addEliminaListener(ActionListener log) {
		  	btnElimina.addActionListener(log);
	       }
	  public void addLogoutListener(ActionListener log) {
		  	btnLogout.addActionListener(log);
	       }
	  public void addCaricaListener(ActionListener log) {
		  	btnCarica.addActionListener(log);
	       }
	  public void addCarica2Listener(ActionListener log) {
		  	btnCarica2.addActionListener(log);
	       }
	  public void addImmagineListener(ActionListener log) {
		  	btnImmagine.addActionListener(log);
	       }
	  public void addImmagine1Listener(ActionListener log) {
		  	btnImmagine1.addActionListener(log);
	       }
	  public void dipendeteView(ActionListener log) {
		  	btnDipendenti.addActionListener(log);
	       }
	  public void turniView(ActionListener log) {
		  	btnTurni.addActionListener(log);
	       }
}