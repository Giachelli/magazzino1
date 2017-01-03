import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Panel;
import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;

public class Main{

	Connection connection = null;
	JFrame main;
	JFrame inserisciprodotto;
	Statement st;
	ResultSet rs;
	private JTextField textNomeProdotto;
	private JTable table;
	private JTextField txtNome;
	private JTextField textMarca;
	private JTextField textPrezzo;
	private JTextField textPrezzoOfferta;
	private JTextField textQta;
	private JTextField textScadenza;
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
		
		/*all'avvio mostra tutti i prodotti in magazzino*/
		String sql ="select * from prodotto where reparto='Magazzino'";
		st=connection.createStatement();
		rs=st.executeQuery(sql);
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
				
				String sql ="select * from prodotto where reparto='"+reparto+"'order by prezzo";
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
				
				String sql ="select * from prodotto where offerta='1'order by prezzo";
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
		lblInserisci.setBounds(52, 42, 70, 16);
		panel_1.add(lblInserisci);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(52, 85, 61, 16);
		panel_1.add(lblNome);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(52, 126, 61, 16);
		panel_1.add(lblMarca);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(52, 174, 61, 16);
		panel_1.add(lblPrezzo);
		
		JLabel lblInizioOfferta = new JLabel("Inizio offerta");
		lblInizioOfferta.setBounds(52, 217, 81, 16);
		panel_1.add(lblInizioOfferta);
		
		JLabel lblFineOfferta = new JLabel("Fine offerta");
		lblFineOfferta.setBounds(52, 260, 81, 16);
		panel_1.add(lblFineOfferta);
		
		JLabel lblOfferta = new JLabel("Offerta");
		lblOfferta.setBounds(52, 303, 81, 16);
		panel_1.add(lblOfferta);
		
		JLabel lblPrezzoOfferta = new JLabel("Prezzo offerta");
		lblPrezzoOfferta.setBounds(52, 340, 87, 16);
		panel_1.add(lblPrezzoOfferta);
		
		JLabel lblQuantit = new JLabel("Quantità");
		lblQuantit.setBounds(52, 380, 87, 16);
		panel_1.add(lblQuantit);
		
		JLabel lblScadenza = new JLabel("Scadenza");
		lblScadenza.setBounds(52, 420, 87, 16);
		panel_1.add(lblScadenza);
		
		JLabel lblScaffale = new JLabel("Scaffale");
		lblScaffale.setBounds(52, 461, 87, 16);
		panel_1.add(lblScaffale);
		
		JLabel lblReparto_1 = new JLabel("Reparto");
		lblReparto_1.setBounds(52, 540, 87, 16);
		panel_1.add(lblReparto_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(102, 80, 130, 26);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(102, 121, 130, 26);
		panel_1.add(textMarca);
		
		textPrezzo = new JTextField();
		textPrezzo.setColumns(10);
		textPrezzo.setBounds(102, 169, 130, 26);
		panel_1.add(textPrezzo);
		
		textPrezzoOfferta = new JTextField();
		textPrezzoOfferta.setColumns(10);
		textPrezzoOfferta.setBounds(150, 335, 130, 26);
		panel_1.add(textPrezzoOfferta);
		
		textQta = new JTextField();
		textQta.setColumns(10);
		textQta.setBounds(113, 375, 130, 26);
		panel_1.add(textQta);
		
		JComboBox comboBoxScaffale = new JComboBox();
		comboBoxScaffale.setBounds(110, 457, 133, 27);
		panel_1.add(comboBoxScaffale);
		
		JComboBox comboBoxSettore = new JComboBox();
		comboBoxSettore.setBounds(110, 496, 133, 27);
		panel_1.add(comboBoxSettore);
		
		
		JComboBox comboBoxReparto = new JComboBox();
		comboBoxReparto.setBounds(110, 536, 133, 27);
		panel_1.add(comboBoxReparto);
		
		JDateChooser dateInizioOfferta = new JDateChooser();
		dateInizioOfferta.setBounds(139, 207, 123, 26);
		panel_1.add(dateInizioOfferta);
		
		JDateChooser dateFineOfferta = new JDateChooser();
		dateFineOfferta.setBounds(139, 250, 123, 26);
		panel_1.add(dateFineOfferta);
		
		JCheckBox chckbxOfferta = new JCheckBox("");
		chckbxOfferta.setBounds(104, 299, 34, 23);
		panel_1.add(chckbxOfferta);
		
		JDateChooser dateScadenza = new JDateChooser();
		dateScadenza.setBounds(279, 410, 123, 26);
		panel_1.add(dateScadenza);
		
		textScadenza = new JTextField();
		textScadenza.setColumns(10);
		textScadenza.setBounds(123, 415, 130, 26);
		panel_1.add(textScadenza);
		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql ="insert into prodotto (nome,marca,prezzo,"
							+ "prezzo_offerta,qta,scadenza,id) values "
							+ "(?,?,?,?,?,?,?)";
					PreparedStatement pst =connection.prepareStatement(sql);
					
					pst.setString(1, txtNome.getText());
					pst.setString(2, textMarca.getText());
					pst.setString(3, textPrezzo.getText());
					//pst.setString(4, dateInizioOfferta.getDateFormatString());
					//pst.setString(5, dateFineOfferta.getDateFormatString());
					//pst.setString(4, chckbxOfferta.getText());
					pst.setString(4, textPrezzoOfferta.getText());
					pst.setString(5, textQta.getText());
					pst.setString(6, textScadenza.getText());
					//pst.setString(7, comboBoxScaffale.toString());
					//pst.setString(8, comboBoxSettore.toString());
					//pst.setString(9, comboBoxReparto.toString());
					pst.setString(7, "1");
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Dati inseriti!");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnInserisci.setBounds(326, 535, 117, 29);
		panel_1.add(btnInserisci);
		
		JButton btnAzzera = new JButton("Azzera");
		btnAzzera.setBounds(455, 535, 117, 29);
		panel_1.add(btnAzzera);
		
		JLabel lblSettore = new JLabel("Settore");
		lblSettore.setBounds(52, 500, 61, 16);
		panel_1.add(lblSettore);
		
		
		
		
		
		
		
		
		
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
