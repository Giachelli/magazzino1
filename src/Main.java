import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.FlowLayout;

import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.Color;

public class Main{

	Connection connection = null;
	JFrame main;
	JFrame inserisciprodotto;
	Statement st;
	ResultSet rs;
	Float prezzo1;
	
	private JTextField textNomeProdotto;
	private JTable table;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable1(){
		
		try {
			String sql1 ="select * from prodotto";
			st=connection.createStatement();
			rs=st.executeQuery(sql1);
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void refreshTable(){
		
		try {
			String sql ="select * from prodotto as prodotto where reparto='Magazzino' and qta < 5 ORDER BY qta ASC";
			PreparedStatement pst=connection.prepareStatement(sql);
			rs=pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
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
		
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Main() throws SQLException {
		connection=sqlConnection.dbConnector();
		initialize();
		
	}
	

	
	
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
		scrollPane.setBounds(16, 71, 1181, 484);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		/*all'avvio mostra tutti i prodotti in magazzino con quantità minore di 5*/
		
		String sql ="select * from prodotto as prodotto where reparto='Magazzino' and qta < 5 ORDER BY qta ASC";
		PreparedStatement pst=connection.prepareStatement(sql);
		
		rs=pst.executeQuery(sql);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		 
		
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
		
		JButton btnCerca = new JButton("Cerca per reparto");
		btnCerca.setBounds(771, 30, 161, 29);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String reparto;
				
				reparto=comboBox.getSelectedItem().toString();
				
				String sql ="select * from prodotto where reparto='"+reparto+"'ORDER BY qta ASC";
				try {
					st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
		});
		panel.add(btnCerca);
		
		JButton btnCercaOfferte = new JButton("Cerca Offerte");
		btnCercaOfferte.setBounds(965, 30, 117, 29);
		btnCercaOfferte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql ="select * from prodotto where offerta='1'ORDER BY fine_offerta ASC";
				try {
					st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
		});
		panel.add(btnCercaOfferte);
		
		JButton btnNomeProdotto = new JButton("Cerca per nome prodotto");
		btnNomeProdotto.setBounds(321, 31, 208, 29);
		btnNomeProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome;
				nome= textNomeProdotto.getText().trim();
		
				String sql ="select * from prodotto where nome='"+nome+"'order by prezzo";
				try {
					st=connection.createStatement();
					rs=st.executeQuery(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
		});
		
		panel.add(btnNomeProdotto);
		
		JLabel lblNomeProdotto = new JLabel("Inserisci nome prodotto");
		lblNomeProdotto.setBounds(6, 37, 159, 16);
		panel.add(lblNomeProdotto);
		
		
		
		
		
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
		lblScaffale.setBounds(52, 324, 87, 16);
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
		textScaffale.setBounds(150, 319, 75, 26);
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
		
	
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(326, 535, 117, 29);
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Float prezzo, prezzo_offerta;
				prezzo=Float.parseFloat(textPrezzo.getText());
				if(textPrezzoOfferta.getText().isEmpty()==false){
					prezzo_offerta=Float.parseFloat(textPrezzoOfferta.getText());
				}else{
					prezzo_offerta=null;
				}
				
				Integer qta;
				qta=Integer.parseInt(textQta.getText());
				Date scadenza, inizio_offerta, fine_offerta;
				scadenza=Date.valueOf(textScadenza.getText());//controllare data scadenza
				if (textInizioOfferta.getText().isEmpty()==false){
					inizio_offerta=Date.valueOf(textInizioOfferta.getText());
				}else{
					inizio_offerta=null;
				}
				if(textFineOfferta.getText().isEmpty()==false){
					fine_offerta=Date.valueOf(textFineOfferta.getText());
				}else{
					fine_offerta=null;
				}
				
				String nome;
				nome=textNome.getText();
				String marca;
				marca=textMarca.getText();
				String scaffale;
				if(textScaffale.getText().isEmpty()==false){
					scaffale=textScaffale.getText();
				}else{
					scaffale=null;
				}
				
				
				
					String sql ="insert into prodotto (nome,marca,prezzo,inizio_offerta,fine_offerta,offerta,"
							+ "prezzo_offerta,qta,scadenza,scaffale,settore,reparto,id) values "
							+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst =connection.prepareStatement(sql);
					if (nome.equals("")==true){
						JOptionPane.showMessageDialog(null, "Inserire nome prodotto!");
					}else{
						pst.setString(1, nome);
					}
					if (marca.equals("")==true){
						JOptionPane.showMessageDialog(null, "Inserire marca prodotto!");
					}else{
						pst.setString(2, marca);
					}
					
						pst.setFloat(3, prezzo);
						
						pst.setDate(4, inizio_offerta);
						pst.setDate(5, fine_offerta);
					//controllo se l'offerta è stata opzionata, se si controllo che il prezzo sia maggiore del prezzo offerta.
						//altrimenti setto a 0 l'offerta e a null il prezzo offerta.
						if (checkBoxOfferta.isSelected()==true){
						
							pst.setString(6, "1");
							if (prezzo>prezzo_offerta){
							pst.setFloat(7, prezzo_offerta);
							
							}else{
							JOptionPane.showMessageDialog(null, "Inserire prezzo offerta minore del prezzo di vendita!");
							}
						
						}else{
						pst.setString(6, "0");
						pst.setString(7, null);
						}
					
					
						
						pst.setInt(8, qta);
						pst.setDate(9, scadenza);
						pst.setString(10, scaffale);
						pst.setString(11, comboBoxSettore.getSelectedItem().toString());
						if(comboBoxReparto.getSelectedItem().toString()==""){
							JOptionPane.showMessageDialog(null, "Inserire il reparto del prodotto!");
						}else{
							pst.setString(12, comboBoxReparto.getSelectedItem().toString());
						}
						
						pst.setString(13, "1");
						//manca da fare il controllo sull'amministratore che inserisce i prodotti, ho iserito io 1 manualmente
					
						pst.execute();
						JOptionPane.showMessageDialog(null, "Prodotto inserito!");
						refreshTable1();
						refreshTable();
						refreshForm();
						pst.close();
				} catch (Exception e2){
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
					//e2.printStackTrace();
					
				}
				
			}
		});
		panel_1.add(btnInserisci);
		
		JButton btnAzzera = new JButton("Azzera");
		btnAzzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshForm();
			}
		});
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
		lblCampiObbligatori.setBounds(52, 360, 139, 16);
		panel_1.add(lblCampiObbligatori);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(326, 45, 267, 184);
		panel_1.add(desktopPane);
		
		JLabel lblImgScaffale = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Scaffalatura.jpg")).getImage();
		lblImgScaffale.setIcon(new ImageIcon(img));
		lblImgScaffale.setBounds(617, 45, 550, 413);
		panel_1.add(lblImgScaffale);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Modifica Prodotto", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 24, 805, 495);
		panel_2.add(scrollPane_1);
		
		comboBoxSettore1 = new JComboBox();
		comboBoxSettore1.setBounds(1024, 428, 133, 27);
		panel_2.add(comboBoxSettore1);
		comboBoxSettore1.addItem("");
		comboBoxSettore1.addItem("Frutta e Verdura");
		comboBoxSettore1.addItem("Bancone alimentare");
		comboBoxSettore1.addItem("Macelleria");
		comboBoxSettore1.addItem("Pescheria");
		comboBoxSettore1.addItem("Frigoriferi");
		comboBoxSettore1.addItem("Congelatori");
		comboBoxSettore1.addItem("Dolciario");
		comboBoxSettore1.addItem("Panificio");
		comboBoxSettore1.addItem("Bevande");
		comboBoxSettore1.addItem("Pasta");
		comboBoxSettore1.addItem("Condimenti");
		comboBoxSettore1.addItem("Cancelleria");
		comboBoxSettore1.addItem("Per la casa");
		comboBoxSettore1.addItem("Igene");
		comboBoxSettore1.addItem("Detersivi");
		
		comboBoxReparto1 = new JComboBox();
		comboBoxReparto1.setBounds(1024, 467, 133, 27);
		panel_2.add(comboBoxReparto1);
		comboBoxReparto1.addItem("");
		comboBoxReparto1.addItem("Alimentare");
		comboBoxReparto1.addItem("Utility");
		comboBoxReparto1.addItem("Magazzino");
		
		checkBoxOfferta1 = new JCheckBox("");
		checkBoxOfferta1.setBounds(1027, 279, 34, 23);
		panel_2.add(checkBoxOfferta1);
		
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
						prezzo1=Float.parseFloat(textPrezzo1.getText());
						
						textPrezzoOfferta1.setText(rs.getString("prezzo_offerta"));
						
						textQta1.setText(rs.getString("qta"));
						textScadenza1.setText(rs.getString("scadenza"));
						textInizioOfferta1.setText(rs.getString("inizio_offerta"));
						textFineOfferta1.setText(rs.getString("fine_offerta"));
						textScaffale1.setText(rs.getString("scaffale"));
						int settore=0;
						int reparto=0;
						String rep;
						String set;
						set=rs.getString("settore");
						rep=rs.getString("reparto");
						if(set.equals("Frutta e Verdura")){
							settore=1;
						}else if(set.equals("Bancone alimentare")){
							settore=2;
						}else if(set.equals("Macelleria")){
							settore=3;
						}else if(set.equals("Pescheria")){
							settore=4;
						}else if(set.equals("Frigoriferi")){
							settore=5;
						}else if(set.equals("Congelatori")){
							settore=6;
						}else if(set.equals("Dolciario")){
							settore=7;
						}else if(set.equals("Panificio")){
							settore=8;
						}else if(set.equals("Bevande")){
							settore=9;
						}else if(set.equals("Pasta")){
							settore=10;
						}else if(set.equals("Condimenti")){
							settore=11;
						}else if(set.equals("Cancelleria")){
							settore=12;
						}else if(set.equals("Per la casa")){
							settore=13;
						}else if(set.equals("Igene")){
							settore=14;
						}else if(set.equals("Detersivi")){
							settore=15;
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
		String sql1 ="select * from prodotto";
		st=connection.createStatement();
		rs=st.executeQuery(sql1);
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		
		JLabel lblModifica = new JLabel("MODIFICA:");
		lblModifica.setBounds(929, 24, 70, 16);
		panel_2.add(lblModifica);
		
		JLabel lblNome1 = new JLabel("Nome");
		lblNome1.setBounds(929, 52, 44, 16);
		panel_2.add(lblNome1);
		
		JLabel lblMarca1= new JLabel("Marca");
		lblMarca1.setBounds(929, 90, 44, 16);
		panel_2.add(lblMarca1);
		
		JLabel lblPrezzo1 = new JLabel("Prezzo");
		lblPrezzo1.setBounds(929, 136, 44, 16);
		panel_2.add(lblPrezzo1);
		
		JLabel lblInizioOfferta1 = new JLabel("Inizio offerta");
		lblInizioOfferta1.setBounds(929, 182, 81, 16);
		panel_2.add(lblInizioOfferta1);
		
		JLabel lblFineOfferta1 = new JLabel("Fine offerta");
		lblFineOfferta1.setBounds(929, 226, 81, 16);
		panel_2.add(lblFineOfferta1);
		
		JLabel lblOfferta1 = new JLabel("Offerta");
		lblOfferta1.setBounds(929, 279, 81, 16);
		panel_2.add(lblOfferta1);
		
		JLabel lblPrezzoOfferta1 = new JLabel("Prezzo offerta");
		lblPrezzoOfferta1.setBounds(929, 322, 87, 16);
		panel_2.add(lblPrezzoOfferta1);
		
		JLabel lblQta1 = new JLabel("Quantità");
		lblQta1.setBounds(929, 358, 61, 16);
		panel_2.add(lblQta1);
		
		JLabel lblScadenza1 = new JLabel("Scadenza");
		lblScadenza1.setBounds(929, 397, 61, 16);
		panel_2.add(lblScadenza1);
		
		JLabel lblScaffale1 = new JLabel("Scaffale");
		lblScaffale1.setBounds(929, 507, 87, 16);
		panel_2.add(lblScaffale1);
		
		JLabel lblReparto1= new JLabel("Reparto");
		lblReparto1.setBounds(929, 471, 48, 16);
		panel_2.add(lblReparto1);
		
		textNome1 = new JTextField();
		textNome1.setColumns(10);
		textNome1.setBounds(1027, 47, 130, 26);
		panel_2.add(textNome1);
		
		textMarca1 = new JTextField();
		textMarca1.setColumns(10);
		textMarca1.setBounds(1027, 85, 130, 26);
		panel_2.add(textMarca1);
		
		textPrezzo1 = new JTextField();
		textPrezzo1.setColumns(10);
		textPrezzo1.setBounds(1027, 131, 75, 26);
		panel_2.add(textPrezzo1);
		
		textPrezzoOfferta1 = new JTextField();
		textPrezzoOfferta1.setColumns(10);
		textPrezzoOfferta1.setBounds(1027, 317, 75, 26);
		panel_2.add(textPrezzoOfferta1);
		
		textQta1 = new JTextField();
		textQta1.setColumns(10);
		textQta1.setBounds(1027, 353, 75, 26);
		panel_2.add(textQta1);
		
		
		
		textScadenza1 = new JTextField();
		textScadenza1.setColumns(10);
		textScadenza1.setBounds(1027, 392, 130, 26);
		panel_2.add(textScadenza1);
		
		textScaffale1 = new JTextField();
		textScaffale1.setColumns(10);
		textScaffale1.setBounds(1024, 502, 75, 26);
		panel_2.add(textScaffale1);
		
		textInizioOfferta1 = new JTextField();
		textInizioOfferta1.setColumns(10);
		textInizioOfferta1.setBounds(1027, 177, 130, 26);
		panel_2.add(textInizioOfferta1);
		
		textFineOfferta1 = new JTextField();
		textFineOfferta1.setColumns(10);
		textFineOfferta1.setBounds(1027, 221, 130, 26);
		panel_2.add(textFineOfferta1);
		
		JLabel label_19 = new JLabel("Settore");
		label_19.setBounds(929, 433, 44, 16);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("(*)");
		label_20.setBounds(973, 52, 19, 16);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("(*)");
		label_21.setBounds(971, 90, 19, 16);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel("(*)");
		label_22.setBounds(973, 136, 19, 16);
		panel_2.add(label_22);
		
		JLabel label_23 = new JLabel("(*)");
		label_23.setBounds(987, 358, 19, 16);
		panel_2.add(label_23);
		
		JLabel label_24 = new JLabel("(*)");
		label_24.setBounds(991, 397, 19, 16);
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel("(*)");
		label_25.setBounds(980, 433, 19, 16);
		panel_2.add(label_25);
		
		JLabel label_26 = new JLabel("(*)");
		label_26.setBounds(973, 471, 19, 16);
		panel_2.add(label_26);
		
		JLabel label_27 = new JLabel("(*) Campi obbligatori");
		label_27.setBounds(929, 543, 139, 16);
		panel_2.add(label_27);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Float prezzo, prezzo_offerta;
					prezzo=Float.parseFloat(textPrezzo1.getText());
					if(textPrezzoOfferta1.getText().isEmpty()==false){
						prezzo_offerta=Float.parseFloat(textPrezzoOfferta1.getText());
					}else{
						prezzo_offerta=null;
					}
					
					Integer qta;
					qta=Integer.parseInt(textQta1.getText());
					Date scadenza, inizio_offerta, fine_offerta;
					scadenza=Date.valueOf(textScadenza1.getText());//controllare data scadenza
					if (textInizioOfferta1.getText().isEmpty()==false){
						inizio_offerta=Date.valueOf(textInizioOfferta1.getText());
					}else{
						inizio_offerta=null;
					}
					if(textFineOfferta1.getText().isEmpty()==false){
						fine_offerta=Date.valueOf(textFineOfferta1.getText());
					}else{
						fine_offerta=null;
					}
					
					String nome;
					nome=textNome1.getText();
					String marca;
					marca=textMarca1.getText();
					String scaffale;
					if(textScaffale1.getText().isEmpty()==false){
						scaffale=textScaffale1.getText();
					}else{
						scaffale=null;
					}
				
				
				
				
				
				int row=table_1.getSelectedRow();
				String codice_=(table_1.getModel().getValueAt(row, 0)).toString();
				String query="UPDATE prodotto set nome=?, marca=? , prezzo=?, offerta=?, prezzo_offerta=?, inizio_offerta=?,"
						+ "fine_offerta=?, qta=?,scadenza=?, scaffale=?, settore=?, reparto=?where codice='"+codice_+"'";
				
				
				PreparedStatement pst=connection.prepareStatement(query);
				if (nome.equals("")==true){
					JOptionPane.showMessageDialog(null, "Inserire nome prodotto!");
				}else{
					pst.setString(1, nome);
				}
				if (marca.equals("")==true){
					JOptionPane.showMessageDialog(null, "Inserire marca prodotto!");
				}else{
					pst.setString(2, marca);
				}
				
				pst.setFloat(3, prezzo);
				if (checkBoxOfferta1.isSelected()==true){
					
					pst.setString(4, "1");
					if (prezzo>prezzo_offerta){
					pst.setFloat(5, prezzo_offerta);
					
					}else{
					JOptionPane.showMessageDialog(null, "Inserire prezzo offerta minore del prezzo di vendita!");
					}
				
				}else{
				pst.setString(4, "0");
				pst.setString(5, null);
				}
				pst.setDate(6, inizio_offerta);
				pst.setDate(7, fine_offerta);
				pst.setInt(8, qta);
				pst.setDate(9, scadenza);
				pst.setString(10, scaffale);
				pst.setString(11, comboBoxSettore1.getSelectedItem().toString());
				if(comboBoxReparto1.getSelectedItem().toString()==""){
					JOptionPane.showMessageDialog(null, "Inserire il reparto del prodotto!");
				}else{
					pst.setString(12, comboBoxReparto1.getSelectedItem().toString());
				}
				
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Prodotto modificato correttamente!");
				pst.close();
				refreshTable1();
				refreshTable();
				refreshForm();
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Inserire i campi obbligatori o in modo corretto!");
						e1.printStackTrace();
					}
					
					
			}
					
			
		});
		btnModifica.setBounds(587, 538, 117, 29);
		panel_2.add(btnModifica);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action=JOptionPane.showConfirmDialog
						(null, "Sei sicuro di voler eliminare il prodotto selezionato?","Elimina", JOptionPane.YES_NO_OPTION);
				if (action==0){
				try{
				
					int row=table_1.getSelectedRow();
					String codice_=(table_1.getModel().getValueAt(row, 0)).toString();
					
					String query="Delete from prodotto where codice='"+codice_+"'";
					
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Prodotto eliminato correttamente!");
					pst.close();
					refreshTable1();
					refreshForm();
						}catch(Exception e1){
							
							e1.printStackTrace();
						}
				}		
						
				}
				
			
		});
		btnElimina.setBounds(716, 538, 117, 29);
		panel_2.add(btnElimina);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(916, 170, 256, 176);
		panel_2.add(desktopPane_1);
		
		
		
		
		
		
		
	
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					st.close();
					rs.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				main.dispose();
				
				try {
					Login window = new Login();
					window.login.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogout.setBounds(258, 2, 92, 29);
		main.getContentPane().add(btnLogout);
		
		
		
		
	}

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
