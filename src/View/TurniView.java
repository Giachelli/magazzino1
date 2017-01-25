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
import Model.TurniModel;
//import Controller.ProdottoController;
import Controller.LoginController;
import net.proteanit.sql.DbUtils;
import com.connectiondb.*;


import View.LoginView;
import com.application.*;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JFrame;


public class TurniView implements ActionListener{

	public JFrame frameTurni;
	Connection connection = null;
	
	private JTextField textNomeTurno;
	private JComboBox comboBoxLunedi;
	private JComboBox comboBoxMartedi;
	private JComboBox comboBoxMercoledi;
	private JComboBox comboBoxGiovedi;
	private JComboBox comboBoxVenerdi;
	private JComboBox comboBoxSabato;
	private JButton btnEliminaTurno;
	private JButton btnModificaTurno;
	private JButton btnVisualizzaTurni;
	public JTable table_2;
	private JTextField textNomeTurno1;
	private JComboBox comboBoxLunedi1;
	private JComboBox comboBoxMartedi1;
	private JComboBox comboBoxMercoledi1;
	private JComboBox comboBoxGiovedi1;
	private JComboBox comboBoxVenerdi1;
	private JButton btnInserisciTurno;
	private JComboBox comboBoxSabato1;
	private JButton btnProdotto;
	private JButton btnDipendenti;
	private JButton btnLogout;

	public TurniView() {
		frameTurni = new JFrame();
		frameTurni.setBounds(100, 100, 1280, 800);
		frameTurni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTurni.getContentPane().setLayout(null);
		
		connection=sqlConnection.dbConnector();

		JLabel lblBenvenuto = new JLabel("Benvenuto,");
		lblBenvenuto.setBounds(39, 6, 92, 16);
		lblBenvenuto.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		frameTurni.getContentPane().add(lblBenvenuto);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 34, 1244, 627);
		frameTurni.getContentPane().add(tabbedPane);
		
		
		//inizio panel 1
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Modifica/Elimina Turni", null, panel_4, null);
		panel_4.setLayout(null);
		
		btnVisualizzaTurni = new JButton("Visualizza Turni");
		btnVisualizzaTurni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizzaTurni.setBounds(28, 11, 145, 32);
		panel_4.add(btnVisualizzaTurni);
		
		JLabel lblNomeTurno = new JLabel("Nome Turno");
		lblNomeTurno.setBounds(769, 50, 94, 14);
		panel_4.add(lblNomeTurno);
		
		JLabel lblNewLabel_1 = new JLabel("Luned\u00EC");
		lblNewLabel_1.setBounds(769, 110, 94, 14);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marted\u00EC");
		lblNewLabel_2.setBounds(769, 170, 94, 14);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mercoled\u00EC");
		lblNewLabel_3.setBounds(769, 230, 94, 14);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gioved\u00EC");
		lblNewLabel_4.setBounds(769, 290, 94, 14);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Venerd\u00EC");
		lblNewLabel_5.setBounds(769, 350, 94, 14);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sabato");
		lblNewLabel_6.setBounds(769, 410, 94, 14);
		panel_4.add(lblNewLabel_6);
		
		btnEliminaTurno = new JButton("Elimina");
		btnEliminaTurno.setBounds(808, 495, 89, 23);
		panel_4.add(btnEliminaTurno);
		
		btnModificaTurno = new JButton("Modifica");
		btnModificaTurno.setBounds(957, 495, 89, 23);
		panel_4.add(btnModificaTurno);
		
		textNomeTurno = new JTextField();
		textNomeTurno.setBounds(993, 50, 124, 20);
		panel_4.add(textNomeTurno);
		textNomeTurno.setColumns(10);
		
		comboBoxLunedi = new JComboBox();
		comboBoxLunedi.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxLunedi.setBounds(993, 110, 124, 17);
		panel_4.add(comboBoxLunedi);
		
		comboBoxMartedi = new JComboBox();
		comboBoxMartedi.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxMartedi.setBounds(993, 170, 124, 17);
		panel_4.add(comboBoxMartedi);
		
		comboBoxMercoledi = new JComboBox();
		comboBoxMercoledi.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxMercoledi.setBounds(993, 230, 124, 17);
		panel_4.add(comboBoxMercoledi);
		
		comboBoxGiovedi = new JComboBox();
		comboBoxGiovedi.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxGiovedi.setBounds(993, 290, 124, 17);
		panel_4.add(comboBoxGiovedi);
		
		comboBoxVenerdi = new JComboBox();
		comboBoxVenerdi.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxVenerdi.setBounds(993, 350, 124, 17);
		panel_4.add(comboBoxVenerdi);
		
		comboBoxSabato = new JComboBox();
		comboBoxSabato.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxSabato.setBounds(993, 410, 124, 17);
		panel_4.add(comboBoxSabato);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(28, 69, 654, 272);
		panel_4.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					int row=table_2.getSelectedRow();
					String codice_=(table_2.getModel().getValueAt(row, 0)).toString();
					String query="select * from turno where id_turno='"+codice_+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while(rs.next()){
						textNomeTurno.setText(rs.getString("nome_turno"));
						int orario;
						
						String turno=rs.getString("lunedi");
						if(turno.equals("Mattina")){
							orario=1;
						}else if(turno.equals("Pomeriggio")){
							orario=2;
						}else if(turno.equals("Riposo")){
							orario=3;
						}else{
							orario=0;
						}
						comboBoxLunedi.setSelectedIndex(orario);
						
						turno=rs.getString("martedi");
						if(turno.equals("Mattina")){
							orario=1;
						}else if(turno.equals("Pomeriggio")){
							orario=2;
						}else if(turno.equals("Riposo")){
							orario=3;
						}else{
							orario=0;
						}
						comboBoxMartedi.setSelectedIndex(orario);
						
						turno=rs.getString("mercoledi");
						if(turno.equals("Mattina")){
							orario=1;
						}else if(turno.equals("Pomeriggio")){
							orario=2;
						}else if(turno.equals("Riposo")){
							orario=3;
						}else{
							orario=0;
						}
						comboBoxMercoledi.setSelectedIndex(orario);
						
						turno=rs.getString("giovedi");
						if(turno.equals("Mattina")){
							orario=1;
						}else if(turno.equals("Pomeriggio")){
							orario=2;
						}else if(turno.equals("Riposo")){
							orario=3;
						}else{
							orario=0;
						}
						comboBoxGiovedi.setSelectedIndex(orario);
						
						turno=rs.getString("venerdi");
						if(turno.equals("Mattina")){
							orario=1;
						}else if(turno.equals("Pomeriggio")){
							orario=2;
						}else if(turno.equals("Riposo")){
							orario=3;
						}else{
							orario=0;
						}
						comboBoxVenerdi.setSelectedIndex(orario);
						
						turno=rs.getString("sabato");
						if(turno.equals("Mattina")){
							orario=1;
						}else if(turno.equals("Pomeriggio")){
							orario=2;
						}else if(turno.equals("Riposo")){
							orario=3;
						}else{
							orario=0;
						}
						comboBoxSabato.setSelectedIndex(orario);
						
						
					}
					pst.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		
		
		//inizio panel 5
		JPanel panel_5 = new JPanel();			
		tabbedPane.addTab("Inserisci Turno", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel label_7 = new JLabel("Nome Turno");
		label_7.setBounds(126, 58, 94, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Luned\u00EC");
		label_8.setBounds(126, 118, 94, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("Marted\u00EC");
		label_9.setBounds(126, 178, 94, 14);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Mercoled\u00EC");
		label_10.setBounds(126, 238, 94, 14);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Gioved\u00EC");
		label_11.setBounds(126, 298, 94, 14);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Venerd\u00EC");
		label_12.setBounds(126, 358, 94, 14);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("Sabato");
		label_13.setBounds(126, 418, 94, 14);
		panel_5.add(label_13);
		
		textNomeTurno1 = new JTextField();
		textNomeTurno1.setColumns(10);
		textNomeTurno1.setBounds(350, 58, 124, 20);
		panel_5.add(textNomeTurno1);
		
		comboBoxLunedi1 = new JComboBox();
		comboBoxLunedi1.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxLunedi1.setBounds(350, 118, 124, 17);
		panel_5.add(comboBoxLunedi1);
		
		comboBoxMartedi1 = new JComboBox();
		comboBoxMartedi1.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxMartedi1.setBounds(350, 178, 124, 17);
		panel_5.add(comboBoxMartedi1);
		
		comboBoxMercoledi1 = new JComboBox();
		comboBoxMercoledi1.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxMercoledi1.setBounds(350, 238, 124, 17);
		panel_5.add(comboBoxMercoledi1);
		
		comboBoxGiovedi1 = new JComboBox();
		comboBoxGiovedi1.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxGiovedi1.setBounds(350, 298, 124, 17);
		panel_5.add(comboBoxGiovedi1);
		
		comboBoxVenerdi1 = new JComboBox();
		comboBoxVenerdi1.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxVenerdi1.setBounds(350, 358, 124, 17);
		panel_5.add(comboBoxVenerdi1);
		
		comboBoxSabato1 = new JComboBox();
		comboBoxSabato1.setModel(new DefaultComboBoxModel(new String[] {"", "Mattina", "Pomeriggio", "Riposo"}));
		comboBoxSabato1.setBounds(350, 418, 124, 17);
		panel_5.add(comboBoxSabato1);
		
		btnInserisciTurno = new JButton("INSERISCI");
		btnInserisciTurno.setBounds(587, 223, 124, 42);
		panel_5.add(btnInserisciTurno);
		
		btnProdotto = new JButton("Prodotto");
		btnProdotto.setBounds(261, 2, 117, 29);
		frameTurni.getContentPane().add(btnProdotto);
		
		btnDipendenti = new JButton("Dipendenti");
		btnDipendenti.setBounds(376, 2, 117, 29);
		frameTurni.getContentPane().add(btnDipendenti);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1157, 2, 117, 29);
		frameTurni.getContentPane().add(btnLogout);
	
	}


	public void actionPerformed(ActionEvent e) {
    }
public void refreshTableTurno(String codice){
		
		try {
			String sql1 ="select id_turno,nome_turno,lunedi,martedi,mercoledi,giovedi,venerdi,sabato,tot_ore_settimanali from turno where id='"+codice+"'";
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(sql1);
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void refreshFormTurno(){
		textNomeTurno.setText("");
		comboBoxLunedi.setSelectedItem("");
		comboBoxMartedi.setSelectedItem("");
		comboBoxMercoledi.setSelectedItem("");
		comboBoxGiovedi.setSelectedItem("");
		comboBoxVenerdi.setSelectedItem("");
		comboBoxSabato.setSelectedItem("");
	}
	
	public void refreshFormTurno1(){
		textNomeTurno1.setText("");
		comboBoxLunedi1.setSelectedItem("");
		comboBoxMartedi1.setSelectedItem("");
		comboBoxMercoledi1.setSelectedItem("");
		comboBoxGiovedi1.setSelectedItem("");
		comboBoxVenerdi1.setSelectedItem("");
		comboBoxSabato1.setSelectedItem("");
	}
	
	public TurniModel getTurno(){
	        TurniModel model2 = new TurniModel (textNomeTurno.getText().trim(), comboBoxLunedi.getSelectedItem().toString(),
	        		comboBoxMartedi.getSelectedItem().toString(), 
	        		comboBoxMercoledi.getSelectedItem().toString(),
	        		comboBoxGiovedi.getSelectedItem().toString(),
	        		comboBoxVenerdi.getSelectedItem().toString(),
	        		comboBoxSabato.getSelectedItem().toString());
	        return model2;       
	    }
	public TurniModel getTurno1(){
        TurniModel model2 = new TurniModel (textNomeTurno1.getText().trim(), comboBoxLunedi1.getSelectedItem().toString(),
        		comboBoxMartedi1.getSelectedItem().toString(), 
        		comboBoxMercoledi1.getSelectedItem().toString(),
        		comboBoxGiovedi1.getSelectedItem().toString(),
        		comboBoxVenerdi1.getSelectedItem().toString(),
        		comboBoxSabato1.getSelectedItem().toString());
        return model2;       
    }
	
	public void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
	
	public void addCaricaTurnoListener(ActionListener log) {
	  	btnVisualizzaTurni.addActionListener(log);
       }
  public void addEliminaTurnoListener(ActionListener log) {
	  	btnEliminaTurno.addActionListener(log);
       }
  public void addModificaTurnoListener(ActionListener log) {
	  	btnModificaTurno.addActionListener(log);
       }
  public void addInserisciTurnoListener(ActionListener log) {
	  	btnInserisciTurno.addActionListener(log);
       }
  public void prodottoView(ActionListener log) {
	  	btnProdotto.addActionListener(log);
     }
  public void dipendenteView(ActionListener log) {
	  	btnDipendenti.addActionListener(log);
     }
  public void Logout(ActionListener log) {
	  	btnLogout.addActionListener(log);
     }
}
