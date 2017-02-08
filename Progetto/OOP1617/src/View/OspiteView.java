package View;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.connectiondb.sqlConnection;
import Model.OspiteModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe OspiteView.java
 * Questa classe implementa la vista, ovvero tutti i componenti visivi relativi
 * e appartenenti al frame "frameOspite".
 * 
 * @author Iezzi Valerio
 */
public class OspiteView implements ActionListener{

	public JFrame frameOspite;
	private OspiteModel model;
	Connection connection = null;
	private JTextField textNomeProdotto;
	public JTable table;
	private JButton btnCercaNome;
	private JComboBox<String> comboBoxSettore;
	private JButton btnCercaSettore;
	private JButton btnVisualizzaOfferte;
	private JScrollPane scrollPane;
	private JLabel lblImgProdotto;
	private JLabel lblSettore1;
	private JLabel lblScadenza1;
	private JLabel lblImgScaffale;
	private JButton btnVisualizza;
	private JButton btnLogout;
	private JLabel lblNome;
	private JLabel lblPrezzo;
	private JLabel lblPrezzoOfferta;
	private JLabel lblPrezzoOfferta1;
	private JLabel lblPrezzo1;
	private JLabel lblNome1;
	private JLabel lblScaffale;
	private JLabel lblScaffale1;
	private JLabel lblMarca;
	private JLabel lblMarca1;
	private JLabel lblInizioOfferta;
	private JLabel lblFineOfferta;
	private JLabel lblInizioOfferta1;
	private JLabel lblFineOfferta1;


	public OspiteView() {
		frameOspite = new JFrame();
		frameOspite.setBounds(100, 100, 1280, 800);
		frameOspite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameOspite.getContentPane().setLayout(null);
		frameOspite.setTitle("Ospite");
		connection=sqlConnection.dbConnector();
		
		JLabel lblInserisciNomeProdotto = new JLabel("Inserisci nome prodotto");
		lblInserisciNomeProdotto.setBounds(52, 48, 158, 16);
		frameOspite.getContentPane().add(lblInserisciNomeProdotto);
		
		textNomeProdotto = new JTextField();
		textNomeProdotto.setBounds(222, 43, 130, 26);
		frameOspite.getContentPane().add(textNomeProdotto);
		textNomeProdotto.setColumns(10);
		
		btnCercaNome = new JButton("Cerca per nome");
		btnCercaNome.setBounds(364, 43, 142, 29);
		frameOspite.getContentPane().add(btnCercaNome);
		
		comboBoxSettore = new JComboBox<String>();
		comboBoxSettore.setBounds(628, 44, 152, 27);
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
		frameOspite.getContentPane().add(comboBoxSettore);
		
		JLabel lblScegliSettore = new JLabel("Scegli settore");
		lblScegliSettore.setBounds(533, 48, 99, 16);
		frameOspite.getContentPane().add(lblScegliSettore);
		
		btnCercaSettore = new JButton("Cerca per settore");
		btnCercaSettore.setBounds(792, 43, 142, 29);
		frameOspite.getContentPane().add(btnCercaSettore);
		
		btnVisualizzaOfferte = new JButton("Visualizza Offerte");
		btnVisualizzaOfferte.setBounds(996, 43, 152, 29);
		frameOspite.getContentPane().add(btnVisualizzaOfferte);
		
		lblImgProdotto = new JLabel("");
		lblImgProdotto.setBounds(52, 432, 338, 248);
		frameOspite.getContentPane().add(lblImgProdotto);
		
		lblImgScaffale = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Scaffalatura.jpg")).getImage();
		lblImgScaffale.setIcon(new ImageIcon(img));
		lblImgScaffale.setBounds(711, 87, 550, 405);
		frameOspite.getContentPane().add(lblImgScaffale);
		
		JLabel lblSettore = new JLabel("Settore:");
		lblSettore.setBounds(402, 488, 61, 16);
		frameOspite.getContentPane().add(lblSettore);
		
		JLabel lblScadenza = new JLabel("Scadenza:");
		lblScadenza.setBounds(402, 516, 74, 16);
		frameOspite.getContentPane().add(lblScadenza);
		
		lblSettore1 = new JLabel("");
		lblSettore1.setBounds(454, 488, 217, 16);
		frameOspite.getContentPane().add(lblSettore1);
		
		lblScadenza1 = new JLabel("");
		lblScadenza1.setBounds(475, 516, 196, 16);
		frameOspite.getContentPane().add(lblScadenza1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 87, 619, 333);
		frameOspite.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					lblImgProdotto.setVisible(false);
					lblSettore1.setVisible(false);
					lblScadenza1.setVisible(false);
					lblPrezzo1.setVisible(false);
					lblPrezzoOfferta1.setVisible(false);
					lblNome1.setVisible(false);
					lblMarca1.setVisible(false);
					lblInizioOfferta1.setVisible(false);
					lblFineOfferta1.setVisible(false);
					lblScaffale1.setVisible(false);
					
					int row=table.getSelectedRow();
					String nome= (table.getModel().getValueAt(row, 1)).toString();
					String marca=(table.getModel().getValueAt(row, 2)).toString();
					String prezzo=(table.getModel().getValueAt(row, 3)).toString();
					String scadenza=(table.getModel().getValueAt(row, 9)).toString();
					String scaffale=(table.getModel().getValueAt(row, 10)).toString();
					String settore=(table.getModel().getValueAt(row, 11)).toString();
					
					lblSettore1.setText(settore);
					lblScadenza1.setText(scadenza);
					lblPrezzo1.setText(prezzo);
					lblNome1.setText(nome);
					lblMarca1.setText(marca);
					lblScaffale1.setText(scaffale);
					lblSettore1.setVisible(true);
					lblScadenza1.setVisible(true);
					lblPrezzo1.setVisible(true);
					lblNome1.setVisible(true);
					lblMarca1.setVisible(true);
					lblScaffale1.setVisible(true);
					
					
					String img1=(table.getModel().getValueAt(row, 13)).toString();
					
					Image img= new ImageIcon(this.getClass().getResource("/"+img1+"")).getImage();
					lblImgProdotto.setVisible(true);
					lblImgProdotto.setIcon(new ImageIcon(img));
					
					String codice_=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from prodotto where codice='"+codice_+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while(rs.next()){
						lblPrezzoOfferta1.setText(rs.getString("prezzo_offerta"));
						lblInizioOfferta1.setText(rs.getString("inizio_offerta"));
						lblFineOfferta1.setText(rs.getString("fine_offerta"));
					}
					lblPrezzoOfferta1.setVisible(true);
					lblInizioOfferta1.setVisible(true);
					lblFineOfferta1.setVisible(true);
					
				}catch(Exception e1){
					//e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		btnVisualizza = new JButton("Visualizza prodotti");
		btnVisualizza.setBounds(52, 7, 158, 29);
		frameOspite.getContentPane().add(btnVisualizza);
		
		btnLogout = new JButton("Esci");
		btnLogout.setBounds(1157, 7, 117, 29);
		frameOspite.getContentPane().add(btnLogout);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(402, 432, 61, 16);
		frameOspite.getContentPane().add(lblNome);
		
		lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setBounds(402, 570, 61, 16);
		frameOspite.getContentPane().add(lblPrezzo);
		
		lblPrezzoOfferta = new JLabel("Prezzo offerta:");
		lblPrezzoOfferta.setBounds(402, 598, 91, 16);
		frameOspite.getContentPane().add(lblPrezzoOfferta);
		
		lblPrezzoOfferta1 = new JLabel("");
		lblPrezzoOfferta1.setBounds(498, 598, 173, 16);
		frameOspite.getContentPane().add(lblPrezzoOfferta1);
		
		lblPrezzo1 = new JLabel("");
		lblPrezzo1.setBounds(454, 570, 217, 16);
		frameOspite.getContentPane().add(lblPrezzo1);
		
		lblNome1 = new JLabel("");
		lblNome1.setBounds(454, 432, 217, 16);
		frameOspite.getContentPane().add(lblNome1);
		
		lblScaffale = new JLabel("Scaffale:");
		lblScaffale.setBounds(402, 542, 61, 16);
		frameOspite.getContentPane().add(lblScaffale);
		
		lblScaffale1 = new JLabel("");
		lblScaffale1.setBounds(468, 542, 203, 16);
		frameOspite.getContentPane().add(lblScaffale1);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(402, 460, 46, 16);
		frameOspite.getContentPane().add(lblMarca);
		
		lblMarca1 = new JLabel("");
		lblMarca1.setBounds(454, 460, 217, 16);
		frameOspite.getContentPane().add(lblMarca1);
		
		lblInizioOfferta = new JLabel("Inizio Offerta:");
		lblInizioOfferta.setBounds(402, 623, 91, 16);
		frameOspite.getContentPane().add(lblInizioOfferta);
		
		lblFineOfferta = new JLabel("Fine Offerta:");
		lblFineOfferta.setBounds(402, 651, 91, 16);
		frameOspite.getContentPane().add(lblFineOfferta);
		
		lblInizioOfferta1 = new JLabel("");
		lblInizioOfferta1.setBounds(498, 623, 173, 16);
		frameOspite.getContentPane().add(lblInizioOfferta1);
		
		lblFineOfferta1 = new JLabel("");
		lblFineOfferta1.setBounds(498, 651, 173, 16);
		frameOspite.getContentPane().add(lblFineOfferta1);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
    }
	
	public void addCaricaListener(ActionListener log) {
	  	btnVisualizza.addActionListener(log);
       }
	public void addCercaNomeListener(ActionListener log) {
	  	btnCercaNome.addActionListener(log);
       }
	public void addCercaOfferteListener(ActionListener log) {
	  	btnVisualizzaOfferte.addActionListener(log);
       }
	public void addCercaSettoreListener(ActionListener log) {
	  	btnCercaSettore.addActionListener(log);
       }
	public void addLogoutListener(ActionListener log) {
	  	btnLogout.addActionListener(log);
       }
	public OspiteModel getProdotto(){
	        model = new OspiteModel(textNomeProdotto.getText().trim(),comboBoxSettore.getSelectedItem().toString());
	        return model;       
	    }

}
