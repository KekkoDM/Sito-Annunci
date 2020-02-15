package Associazioni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.postgresql.util.PSQLException;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

//Classe che rappresenta il frame per inserire una determinata recensione per un particolare elemento
public class Inserisci_Frame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField titolotext;
	private JComboBox ristocombo;
	private JTextArea textarea;
	private JRadioButton oneradio;
	private JRadioButton tworadio;
	private JRadioButton threeradio;
	private JRadioButton fourradio;
	private JRadioButton fiveradio;
	String Codice = new String(" ");

	public Inserisci_Frame(Controller ctr,String from,Utente UtenteCorrente) {
		setTitle("Inserimento");
		setResizable(false);
		RecensioneDAO rdao = new RecensioneDAO();
		setBounds(100, 100, 401, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textarea = new JTextArea();
		textarea.setBounds(10, 212, 374, 113);
		contentPanel.add(textarea);
		
		ristocombo = new JComboBox();
		ristocombo.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		ristocombo.setBounds(171, 37, 213, 30);
		contentPanel.add(ristocombo);
		this.updateComboBox(from);
		
		titolotext = new JTextField();
		titolotext.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		titolotext.setBounds(171, 72, 213, 30);
		contentPanel.add(titolotext);
		titolotext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Scegli la localit\u00E0");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 40, 147, 25);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserire il Titolo");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 74, 146, 25);
		contentPanel.add(lblNewLabel_1);
		
		oneradio = new JRadioButton("*");
		oneradio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oneradio.setBounds(10, 139, 48, 23);
		contentPanel.add(oneradio);
		
		threeradio = new JRadioButton("***");
		threeradio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		threeradio.setBounds(130, 138, 70, 25);
		contentPanel.add(threeradio);
		
		fourradio = new JRadioButton("****");
		fourradio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fourradio.setBounds(207, 138, 80, 25);
		contentPanel.add(fourradio);
		
		tworadio = new JRadioButton("**");
		tworadio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tworadio.setBounds(65, 139, 62, 23);
		contentPanel.add(tworadio);
		
		fiveradio = new JRadioButton("*****");
		fiveradio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fiveradio.setBounds(294, 138, 90, 25);
		contentPanel.add(fiveradio);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci Recensione");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(12, 174, 180, 30);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(46, 139, 87));
				okButton.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Recensione r = new Recensione();//creo l'oggetto recensione settando i suoi valori con quelli inseriti nelle varie aree di inserimento
						r.setCodU(UtenteCorrente.getCodu());
						r.setLuogo(ristocombo.getSelectedItem().toString());
						r.setTitolo(titolotext.getText());
						r.setTesto(textarea.getText());
						r.setValutazione(getValutazione(oneradio, tworadio, threeradio, fourradio, fiveradio));
						String valutazione = r.getValutazione();
						//una volta settato, controllo il valore del flag passato al costruttore
						if(valutazione != "0" && from.equals("ristorante")) {//se il valore è ristorante , allora aggiunge la recensione con il codice corrispondente alla chiave esterna di ristorante
							ctr.inserisciRecensione(r, from, "codri");
							ctr.chiudiInserisci();
						}else if(valutazione != "0" && from.equals("alloggio")){
							ctr.inserisciRecensione(r,from,"codal");
							ctr.chiudiInserisci();	
						}else if(valutazione != "0" && from.equals("attrazione")){
							ctr.inserisciRecensione(r,from,"codat");
							ctr.chiudiInserisci();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancella");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(46, 139, 87));
				cancelButton.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 16));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void updateComboBox(String from) {//prende dal DB tutti i nomi degli elementi interessati (ristoranti, alloggi o attrazioni)
		Connessione c = new Connessione();
		c.ConnessioneDB();
		try {
			ResultSet rs= c.Query("*",from," ");
			while(rs.next()) {
				this.getComboBox().addItem(rs.getString("nome"));
			}
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	public JComboBox<String> getComboBox() {
		return ristocombo; 	
	}
	
	
	
	
	public String getValutazione(JRadioButton r1,JRadioButton r2,JRadioButton r3,JRadioButton r4,JRadioButton r5)
	{
		if(r1.isSelected()) {
			return "1";
		}
		else if (r2.isSelected()) {
			return "2";
		}
		else if (r3.isSelected()) {
			return "3";
		}
		else if (r4.isSelected()) {
			return "4";
		}
		else if (r5.isSelected()) {
			return "5";
		}
		else {
			return "0";
		}
	}
}
