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

import com.connectiondb.sqlConnection;

import Model.LoginModel;
import Model.ProdottoModel;
import net.proteanit.sql.DbUtils;
import Model.DipendenteModel;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Component;

public class DipendenteView implements ActionListener{

	Connection connection = null;

	public JFrame frameDipendente;
	private DipendenteModel model;
	public String NomeDipendente;
	public String CognomeDipendente;
	public String CodiceFisc;
	public String Indirizzo;
	public String Email;
	public Date AnnoNascita;
    public String Mansione;
	public Date Data_Assunzione;
	public Date Data_Licen;
	public Integer id;
	public Integer Telefono;
	public String immag;
	public JTable table1;
	private  JTextField textNomeDipendente;
	private JButton btnCercaMansione;
	private JButton btnNomeDipendente;
	public JButton btnModifica;
	public JButton btnElimina;
	public JButton btnCaricaDip1;
	public JLabel lblImmagine;
	private JComboBox comboBoxRep;
	private JComboBox comboBoxMansione;
	private JComboBox comboBoxRep1;
    private JTextField textNomeDipendente1;
	private JTextField textCognomeDipendente1;
	private JTextField textCodiceFiscale1;
	private JTextField textIndirizzo1;
	private JTextField textEmail1;
	private JTextField textAnnoNascita1;
	private JTextField textDataAssunzione1;
	private JTextField textDataLicenziamento1;
	private JTextField textTelefono1;
    private JTextField textNomeDipendente2;
	private JTextField textCognomeDipendente2;
	private JTextField textCodiceFiscale2;
	private JTextField textIndirizzo2;
	private JTextField textEmail2;
	private JTextField textAnnoNascita2;
	private JTextField textDataAssunzione2;
	private JTextField textDataLicenziamento2;
	private JTextField textTelefono2;
    private JButton btnInserisciDip;
    public JButton btnCaricaTutti;
    private JTextField textNomeDipendente3;
    private JTextField textMansione3;
    private JButton btnCaricaTutti_1;
    public JTable tabella;
    private JButton btnProdotto;
    private JButton btnTurni;
    private JButton btnLogout;
    private JComboBox TurnoBox;
    private JLabel Turno;
    private JComboBox TurnoBox2;
    
    

    public void fillComboBox(){
		try {
			 String sql="select * from turno";
             PreparedStatement pst=connection.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
             while(rs.next())
			 {
				TurnoBox.addItem(rs.getString("nome_turno"));
			 };
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    }
    public void fillComboBox2(){
		try {
			 String sql="select * from turno";
             PreparedStatement pst=connection.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
             while(rs.next())
			 {
				TurnoBox2.addItem(rs.getString("nome_turno"));
			 };
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    
	public DipendenteView() {
		
		frameDipendente = new JFrame();
		frameDipendente.setBounds(new Rectangle(100, 100, 1278, 714));
		frameDipendente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDipendente.getContentPane().setLayout(null);
		
		connection=sqlConnection.dbConnector();
		
		JLabel lblBenvenuto = new JLabel("Benvenuto,");
		lblBenvenuto.setBounds(39, 6, 92, 16);
		lblBenvenuto.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		frameDipendente.getContentPane().add(lblBenvenuto);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 34, 1244, 627);
		frameDipendente.getContentPane().add(tabbedPane);
				
				JPanel panel_1 = new JPanel();
				tabbedPane.addTab("Inserisci dipendente", null, panel_1, null);
				panel_1.setLayout(null);
				
				JLabel lblInserisci = new JLabel("INSERISCI:");
				lblInserisci.setBounds(52, 29, 70, 16);
				panel_1.add(lblInserisci);
				
				JLabel lblNomeDipendente1 = new JLabel("Nome: ");
				lblNomeDipendente1.setBounds(20, 57, 87, 16);
				panel_1.add(lblNomeDipendente1);
				
				JLabel lblCognomeDipendente1 = new JLabel("Cognome: ");
				lblCognomeDipendente1 .setBounds(20, 95, 70, 16);
				panel_1.add(lblCognomeDipendente1);
				
				JLabel lblPrezzo = new JLabel("Codice Fiscale: ");
				lblPrezzo.setBounds(20, 141, 102, 16);
				panel_1.add(lblPrezzo);
				
				JLabel lblInizioOfferta = new JLabel("Indirizzo: ");
				lblInizioOfferta.setBounds(20, 186, 81, 16);
				panel_1.add(lblInizioOfferta);
				
				JLabel lblFineOfferta = new JLabel("Email: ");
				lblFineOfferta.setBounds(20, 234, 54, 16);
				panel_1.add(lblFineOfferta);
				
				JLabel lblOfferta = new JLabel("Anno di nascita:");
				lblOfferta.setBounds(20, 273, 102, 16);
				panel_1.add(lblOfferta);
				
				JLabel lblPrezzoOfferta = new JLabel("Mansione: ");
				lblPrezzoOfferta.setBounds(20, 461, 70, 16);
				panel_1.add(lblPrezzoOfferta);
				
				JLabel lblQuantit = new JLabel("Data assunzione: ");
				lblQuantit.setBounds(20, 318, 130, 16);
				panel_1.add(lblQuantit);
				
				JLabel lblScadenza = new JLabel("Data licenziamento: ");
				lblScadenza.setBounds(20, 372, 130, 16);
				panel_1.add(lblScadenza);
				
				JLabel lblScaffale = new JLabel("Telefono: ");
				lblScaffale.setBounds(20, 418, 87, 16);
				panel_1.add(lblScaffale);
				
				
				textNomeDipendente1 = new JTextField();
				textNomeDipendente1.setBounds(150, 52, 153, 26);
				textNomeDipendente1.setColumns(10);
				panel_1.add(textNomeDipendente1);
				
						
				textCognomeDipendente1 = new JTextField();
				textCognomeDipendente1.setBounds(150, 90, 153, 26);
				textCognomeDipendente1.setColumns(10);
				panel_1.add(textCognomeDipendente1);
						

				textCodiceFiscale1 = new JTextField();
				textCodiceFiscale1.setBounds(150, 136, 153, 26);
				textCodiceFiscale1.setColumns(10);
				panel_1.add(textCodiceFiscale1);
							
							
				textIndirizzo1 = new JTextField();
				textIndirizzo1.setBounds(150, 181, 153, 26);
				textIndirizzo1.setColumns(10);
				panel_1.add(textIndirizzo1);
							
				textEmail1 = new JTextField();
				textEmail1.setBounds(150, 229, 153, 26);
				textEmail1.setColumns(10);
				panel_1.add(textEmail1);
									
									
									
				comboBoxMansione = new JComboBox();
				comboBoxMansione.setBounds(150, 457, 153, 27);
				panel_1.add(comboBoxMansione);
				comboBoxMansione.addItem("");
				comboBoxMansione.addItem("Cassa");
				comboBoxMansione.addItem("Sala");
				comboBoxMansione.addItem("Banco");
									
										
				textAnnoNascita1 = new JTextField();
				textAnnoNascita1.setBounds(150, 268, 153, 26);
				textAnnoNascita1.setColumns(10);
				panel_1.add(textAnnoNascita1);
										
				textDataAssunzione1 = new JTextField();
				textDataAssunzione1.setBounds(150, 313, 153, 26);
				textDataAssunzione1.setColumns(10);
				panel_1.add(textDataAssunzione1);
											
			    textTelefono1= new JTextField();
			    textTelefono1.setColumns(10);
			    textTelefono1.setBounds(150, 413, 153, 26);
			    panel_1.add(textTelefono1);
														
															
				textDataLicenziamento1 = new JTextField();
				textDataLicenziamento1.setBounds(150, 367, 153, 26);
				textDataLicenziamento1.setColumns(10);
				panel_1.add(textDataLicenziamento1);
															
			    btnInserisciDip = new JButton("Inserisci");
			    btnInserisciDip.setBounds(89, 519, 117, 29);
			    panel_1.add(btnInserisciDip);
															
			    JLabel lblNewLabel_3 = new JLabel("*");
			    lblNewLabel_3.setBounds(62, 52, 61, 16);
			    panel_1.add(lblNewLabel_3);
															
			    JLabel label = new JLabel("*");
			    label.setBounds(89, 85, 13, 16);
			    panel_1.add(label);
															
			    JLabel label_1 = new JLabel("*");
			    label_1.setBounds(115, 136, 13, 16);
			    panel_1.add(label_1);
														
			    JLabel label_2 = new JLabel("*");
			    label_2.setBounds(89, 186, 13, 16);
			    panel_1.add(label_2);
														
			    JLabel label_3 = new JLabel("*");
			    label_3.setBounds(122, 267, 61, 16);
			    panel_1.add(label_3);
														
			    JLabel label_4 = new JLabel("*");
				label_4.setBounds(125, 313, 13, 16);
				panel_1.add(label_4);
															
				JLabel label_5 = new JLabel("*");
				label_5.setBounds(89, 461, 13, 16);
				panel_1.add(label_5);
				
				JLabel label_6 = new JLabel("(*) Campi obbligatori");
				label_6.setBounds(242, 559, 139, 16);
				panel_1.add(label_6);
				
				
                TurnoBox = new JComboBox();
				TurnoBox.setBounds(449, 53, 184, 27);
				panel_1.add(TurnoBox);
				
				Turno = new JLabel("Turno:");
				Turno.setBounds(363, 57, 61, 16);
				panel_1.add(Turno);
				
				
				fillComboBox();
				
				
				JPanel panel = new JPanel();
				tabbedPane.addTab("Cerca dipendente", null, panel, null);
				tabbedPane.setEnabledAt(1, true);
				panel.setLayout(null);
				

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(16, 72, 692, 317);
				panel.add(scrollPane);
				
				
				JLabel lblImg = new JLabel("");
				lblImg.setBounds(720, 72, 260, 317);
				panel.add(lblImg);
				
				

				JLabel lblNomeImg = new JLabel("");
				lblNomeImg.setBounds(792, 180, 188, 16);
				panel.add(lblNomeImg);
				
				JLabel lblCognomeImg = new JLabel("");
				lblCognomeImg.setBounds(825, 200, 162, 14);
				panel.add(lblCognomeImg);
				
				JLabel lblMansioneImg = new JLabel("");
				lblMansioneImg.setBounds(818, 220, 148, 16);
				panel.add(lblMansioneImg);
				
				JLabel lblEmailImg = new JLabel("");
				lblEmailImg.setBounds(792, 240, 188, 16);
				panel.add(lblEmailImg);
				
				JLabel lblTelefonoImg = new JLabel("");
				lblTelefonoImg.setBounds(812, 260, 168, 16);
				panel.add(lblTelefonoImg);
				
				
				

				table1 = new JTable();
				table1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try{
							int row=table1.getSelectedRow();
							String codice_=(table1.getModel().getValueAt(row, 0)).toString();
							String query="select * from dipendente where codice='"+codice_+"'";
							PreparedStatement pst=connection.prepareStatement(query);
							ResultSet rs=pst.executeQuery();
							while(rs.next()){
								lblNomeImg.setText(rs.getString("nome"));
								lblCognomeImg.setText(rs.getString("cognome"));
								lblMansioneImg.setText(rs.getString("mansione"));
						        lblEmailImg.setText(rs.getString("email"));
								
						        lblTelefonoImg.setText(rs.getString("telefono"));
						     
							
						}
							pst.close();
						}catch(Exception e1){
							e1.printStackTrace();
						}

				}
				});

				
				scrollPane.setViewportView(table1);
				
				
				


				textNomeDipendente = new JTextField();
				textNomeDipendente.setBounds(104, 33, 141, 26);
				textNomeDipendente.setColumns(10);
				panel.add(textNomeDipendente);
				
				comboBoxRep = new JComboBox();
				comboBoxRep.setBounds(635, 32, 141, 27);
				comboBoxRep.addItem("");
				comboBoxRep.addItem("Cassa");
				comboBoxRep.addItem("Sala");
				comboBoxRep.addItem("Banco");
				panel.add(comboBoxRep);
				
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
				lblCognomeDipe.setBounds(745, 200, 68, 16);
				panel.add(lblCognomeDipe);
				
				JLabel lblMans = new JLabel("Mansione: ");
				lblMans.setBounds(745, 220, 68, 16);
				panel.add(lblMans);
				
				JLabel lblEmail= new JLabel("Email: ");
				lblEmail.setBounds(745, 240, 48, 16);
				panel.add(lblEmail);
				
				JLabel lblTel = new JLabel("Telefono: ");
				lblTel.setBounds(745, 260, 68, 16);
				panel.add(lblTel);
				
				

				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("Modifica Dipendente", null, panel_2, null);
				panel_2.setLayout(null);
				
				comboBoxRep1 = new JComboBox();
				comboBoxRep1.setBounds(998, 328, 133, 27);
				panel_2.add(comboBoxRep1);
				comboBoxRep1.addItem("");
				comboBoxRep1.addItem("Cassa");
				comboBoxRep1.addItem("Sala");
				comboBoxRep1.addItem("Banco");
				
				JLabel lblModifica = new JLabel("MODIFICA:");
				lblModifica.setBounds(872, 6, 70, 16);
				panel_2.add(lblModifica);
				
				JLabel lblNome1 = new JLabel("Nome");
				lblNome1.setBounds(856, 30, 44, 16);
				panel_2.add(lblNome1);
				
				JLabel lblCognome1= new JLabel("Cognome");
				lblCognome1.setBounds(856, 58, 70, 16);
				panel_2.add(lblCognome1);
				
				JLabel lblCodiceFiscale1 = new JLabel("Codice fiscale");
				lblCodiceFiscale1.setBounds(856, 86, 98, 16);
				panel_2.add(lblCodiceFiscale1);
				
				JLabel lblIndirizzo1=new JLabel("Indirizzo");
				lblIndirizzo1.setBounds(856, 114, 64, 16);
				panel_2.add(lblIndirizzo1);
				
				JLabel lblEmail1=new JLabel("Email");
				lblEmail1.setBounds(856, 142, 64, 16);
				panel_2.add(lblEmail1);
				
				JLabel lblAnnoNascita1=new JLabel("Anno di nascita");
				lblAnnoNascita1.setBounds(856, 170, 117, 16);
				panel_2.add(lblAnnoNascita1);
				
				JLabel lblDataAssunzione1=new JLabel("Anno di assunzione");
				lblDataAssunzione1.setBounds(856, 198, 124, 16);
				panel_2.add(lblDataAssunzione1);
				
				JLabel lblDataLicenziamento1=new JLabel("Anno di licenziamento");
				lblDataLicenziamento1.setBounds(856, 227, 236, 16);
				panel_2.add(lblDataLicenziamento1);
				
				JLabel lblTelefono1=new JLabel("Telefono");
				lblTelefono1.setBounds(856, 255, 86, 16);
				panel_2.add(lblTelefono1);
				
				textNomeDipendente2 = new JTextField();
				textNomeDipendente2.setColumns(10);
				textNomeDipendente2.setBounds(1001, 30, 130, 26);
				panel_2.add(textNomeDipendente2);
				
				textCognomeDipendente2 = new JTextField();
				textCognomeDipendente2.setColumns(10);
				textCognomeDipendente2.setBounds(1001, 53, 130, 26);
				panel_2.add(textCognomeDipendente2);
				
				textCodiceFiscale2 = new JTextField();
				textCodiceFiscale2.setColumns(10);
				textCodiceFiscale2.setBounds(1001, 81, 133, 26);
				panel_2.add(textCodiceFiscale2);
				
				textIndirizzo2 = new JTextField();
				textIndirizzo2.setColumns(10);
				textIndirizzo2.setBounds(1001, 109, 133, 26);
				panel_2.add(textIndirizzo2);
				
				textEmail2 = new JTextField();
				textEmail2.setColumns(10);
				textEmail2.setBounds(1001, 137, 133, 26);
				panel_2.add(textEmail2);
				
				textAnnoNascita2 = new JTextField();
				textAnnoNascita2.setColumns(10);
				textAnnoNascita2.setBounds(1001, 165, 133, 26);
				panel_2.add(textAnnoNascita2);
				
				textDataAssunzione2 = new JTextField();
				textDataAssunzione2.setColumns(10);
				textDataAssunzione2.setBounds(1001, 193, 133, 26);
				panel_2.add(textDataAssunzione2);
				
				textDataLicenziamento2 = new JTextField();
				textDataLicenziamento2.setColumns(10);
				textDataLicenziamento2.setBounds(1001, 222, 133, 26);
				panel_2.add(textDataLicenziamento2);
				
				textTelefono2 = new JTextField();
				textTelefono2.setColumns(10);
				textTelefono2.setBounds(1001, 250, 133, 26);
				panel_2.add(textTelefono2);
				
				
			
				
				
				JLabel label_19 = new JLabel("Mansione");
				label_19.setBounds(856, 332, 77, 16);
				panel_2.add(label_19);
				
				JLabel label_20 = new JLabel("(*)");
				label_20.setBounds(901, 30, 19, 16);
				panel_2.add(label_20);
				
				JLabel label_21 = new JLabel("(*)");
				label_21.setBounds(924, 53, 19, 16);
				panel_2.add(label_21);
				
				JLabel label_22 = new JLabel("(*)");
				label_22.setBounds(950, 81, 19, 16);
				panel_2.add(label_22);
				
				JLabel label_23 = new JLabel("(*)");
				label_23.setBounds(923, 114, 19, 16);
				panel_2.add(label_23);
				
				JLabel label_24 = new JLabel("(*)");
				label_24.setBounds(987, 193, 19, 21);
				panel_2.add(label_24);
				
				JLabel label_25 = new JLabel("(*)");
				label_25.setBounds(962, 165, 19, 16);
				panel_2.add(label_25);
				
				JLabel label_26 = new JLabel("(*)");
				label_26.setBounds(924, 328, 19, 16);
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
				
				btnCaricaDip1 = new JButton("Cerca dipendenti");
				btnCaricaDip1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnCaricaDip1.setBounds(1023, 490, 152, 29);
				panel_2.add(btnCaricaDip1);
				
				lblImmagine = new JLabel("");
				lblImmagine.setBounds(1047, 444, 61, 16);
				panel_2.add(lblImmagine);
				
				JLabel lblNewLabel = new JLabel("Cerca per: ");
				lblNewLabel.setBounds(856, 360, 86, 16);
				panel_2.add(lblNewLabel);
				
				textNomeDipendente3 = new JTextField();
				textNomeDipendente3.setBounds(998, 379, 130, 26);
				panel_2.add(textNomeDipendente3);
				textNomeDipendente3.setColumns(10);
				
				textMansione3 = new JTextField();
				textMansione3.setBounds(998, 417, 130, 26);
				panel_2.add(textMansione3);
				textMansione3.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Nome");
				lblNewLabel_1.setBounds(856, 384, 61, 16);
				panel_2.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Mansione");
				lblNewLabel_2.setBounds(856, 422, 61, 16);
				panel_2.add(lblNewLabel_2);
				
				btnCaricaTutti_1= new JButton("Carica tutti");
				btnCaricaTutti_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnCaricaTutti_1.setBounds(856, 490, 150, 29);
				panel_2.add(btnCaricaTutti_1);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(31, 58, 752, 383);
				panel_2.add(scrollPane_1);
				
				tabella = new JTable();
				tabella.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try{
							int row=tabella.getSelectedRow();
							String codice_=(tabella.getModel().getValueAt(row, 0)).toString();
							String query="select * from dipendente where codice='"+codice_+"'";
							PreparedStatement pst=connection.prepareStatement(query);
							ResultSet rs=pst.executeQuery();
							String id_turno=null;
							while(rs.next()){
								textNomeDipendente2.setText(rs.getString("nome"));
								textCognomeDipendente2.setText(rs.getString("cognome"));
								textCodiceFiscale2.setText(rs.getString("cod_fisc"));
						        textIndirizzo2.setText(rs.getString("indirizzo"));
								
						        textEmail2.setText(rs.getString("email"));
						        textAnnoNascita2.setText(rs.getString("datan"));
						        textDataAssunzione2.setText(rs.getString("data_assunzione"));
						        textDataLicenziamento2.setText(rs.getString("data_licenziamento"));
						        textTelefono2.setText(rs.getString("telefono"));
						        id_turno=rs.getString("id_turno");
						        
								int mansione=0;
								
								String man;

								man=rs.getString("mansione");
								
								if(man.equals("Cassa")){
									mansione=1;
								}else if(man.equals("Sala")){
									mansione=2;
								}else if(man.equals("Banco")){
									mansione=3;
								}else{
									mansione=0;
								}
								
								comboBoxRep1.setSelectedIndex(mansione);
								
								
							}
							try{
								String nome_turno=null;
						        String query2="select nome_turno from turno where id_turno='"+id_turno+"'";
						        Statement stmt = connection.createStatement();
								ResultSet rs2=stmt.executeQuery(query2);
								while(rs2.next()){
									nome_turno=rs2.getString(1);
								}

								TurnoBox2.setSelectedItem(nome_turno);
							}catch(Exception e1){
								e1.printStackTrace();
							}
							
							
							pst.close();
						}catch(Exception e1){
							e1.printStackTrace();
						}
					}
				});
				scrollPane_1.setViewportView(tabella);
				
				TurnoBox2 = new JComboBox();
				TurnoBox2.setBounds(998, 288, 177, 27);
				panel_2.add(TurnoBox2);
				
				fillComboBox2();
				
				JLabel lblNomeTurno = new JLabel("Nome turno");
				lblNomeTurno.setBounds(856, 292, 98, 16);
				panel_2.add(lblNomeTurno);
				
				btnTurni = new JButton("Turni");
				btnTurni.setBounds(409, 2, 117, 29);
				frameDipendente.getContentPane().add(btnTurni);
				
				btnLogout = new JButton("Logout");
				btnLogout.setBounds(1155, 2, 117, 29);
				frameDipendente.getContentPane().add(btnLogout);
				
				btnProdotto = new JButton("Prodotto");
				btnProdotto.setBounds(294, 2, 117, 29);
				frameDipendente.getContentPane().add(btnProdotto);
				


	
	}
	

public void refreshTabella1(String codice){
		
		try {
			String sql1 ="select * from dipendente where id='"+codice+"'";
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(sql1);
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void refreshTabella(String codice){
	
	try {
		String sql1 ="select * from dipendente where id='"+codice+"'";
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(sql1);
		tabella.setModel(DbUtils.resultSetToTableModel(rs));
		st.close();
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	public void refreshForm(){
		textNomeDipendente1.setText("");
		textCognomeDipendente1.setText("");
		textIndirizzo1.setText("");
		textEmail1.setText("");
		textCodiceFiscale1.setText("");
		textAnnoNascita1.setText("");
		comboBoxMansione.setSelectedItem("");
		textDataAssunzione1.setText("");
		textDataLicenziamento1.setText("");
		textTelefono1.setText("");
		textNomeDipendente2.setText("");
		textCognomeDipendente2.setText("");
		textIndirizzo2.setText("");
		textEmail2.setText("");
		textCodiceFiscale2.setText("");
		textAnnoNascita2.setText("");
		textDataAssunzione2.setText("");
		textDataLicenziamento2.setText("");
		textTelefono2.setText("");
		comboBoxRep1.setSelectedItem("");
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
	        model = new DipendenteModel(textNomeDipendente.getText().trim(), comboBoxRep.getSelectedItem().toString(), TurnoBox.getSelectedItem().toString());
	        return model;       
	    }
	  
	  
	  public DipendenteModel getDipendente2(){
		  String Mansione=null; Date AnnoNascita=null; Date Data_Assunzione=null;
		  Date Data_Licen=null; String Nome_Turno=null;
		
		  
		  if(textAnnoNascita1.getText().isEmpty()==false){	
			  try{
			  AnnoNascita=Date.valueOf(textAnnoNascita1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di nascita correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  AnnoNascita=null;
			  
		  }
		  if(textDataAssunzione1.getText().isEmpty()==false){	
			  try{
			  Data_Assunzione=Date.valueOf(textDataAssunzione1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di assunzione correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  Data_Assunzione=null;
		  }
		  if(textDataLicenziamento1.getText().isEmpty()==false){	
			  try{
			  Data_Licen=Date.valueOf(textDataLicenziamento1.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di licenziamento corretta! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  Data_Licen=null;
		  }
		
			  
			     Nome_Turno=TurnoBox.getSelectedItem().toString();
				 Mansione=comboBoxMansione.getSelectedItem().toString();

			 model = new DipendenteModel(textNomeDipendente1.getText().trim(),textCognomeDipendente1.getText().trim(),textCodiceFiscale1.getText().trim(),
				  textIndirizzo1.getText().trim(), textEmail1.getText().trim(),AnnoNascita,Mansione,Data_Assunzione,Data_Licen, id, 
				  textTelefono1.getText().trim(),Nome_Turno ); 
		  return model;
	  }
	  

	  public DipendenteModel getDipendente3(){
		  String Mansione=null; Date AnnoNascita=null; Date Data_Assunzione=null;
		  Date Data_Licen=null; String Nome_Turno=null;
		
		  
		  if(textAnnoNascita2.getText().isEmpty()==false){	
			  try{
			  AnnoNascita=Date.valueOf(textAnnoNascita2.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di nascita correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  AnnoNascita=null;
			  
		  }
		  if(textDataAssunzione2.getText().isEmpty()==false){	
			  try{
			  Data_Assunzione=Date.valueOf(textDataAssunzione2.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di assunzione correttamente! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  Data_Assunzione=null;
		  }
		  if(textDataLicenziamento2.getText().isEmpty()==false){	
			  try{
			  Data_Licen=Date.valueOf(textDataLicenziamento2.getText().trim());
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null, "Inserire la data di licenziamento corretta! ES:(aaaa-mm-gg)");
			  }
		  }else{
			  Data_Licen=null;
		  }
		
			  
		  		Nome_Turno=TurnoBox2.getSelectedItem().toString();
				 Mansione=comboBoxRep1.getSelectedItem().toString();

			 model = new DipendenteModel(textNomeDipendente2.getText().trim(),textCognomeDipendente2.getText().trim(),textCodiceFiscale2.getText().trim(),
				  textIndirizzo2.getText().trim(), textEmail2.getText().trim(),AnnoNascita,Mansione,Data_Assunzione,Data_Licen, id, 
				  textTelefono2.getText().trim(), Nome_Turno); 
		  return model;
	  }
	  
	  public DipendenteModel getDipendente4(){
	        model = new DipendenteModel(textNomeDipendente3.getText().trim(), textMansione3.getText().trim());
	        return model;       
	    }
	  
		public void addInserisciDipendenteListener(ActionListener log) {
		       btnInserisciDip.addActionListener(log);
		       }
		
		
		 public void addModificaListener(ActionListener log) {
		  	btnModifica.addActionListener(log);
	       }
	      public void addEliminaListener(ActionListener log) {
		  	btnElimina.addActionListener(log);
	       }
	      public void addCaricaListener(ActionListener log) {
			  	btnCaricaDip1.addActionListener(log);
		       }
	  
	    public void addCaricaListener_1(ActionListener log) {
			  	btnCaricaTutti_1.addActionListener(log);
		       }
		       
	    public void prodottoView(ActionListener log) {
		  	btnProdotto.addActionListener(log);
	       }
	    public void turniView(ActionListener log) {
		  	btnTurni.addActionListener(log);
	       }
	    public void Logout(ActionListener log) {
		  	btnLogout.addActionListener(log);
	       }
		
	  public void showMessage(String msg){
	        JOptionPane.showMessageDialog(null, msg);
	
}
}