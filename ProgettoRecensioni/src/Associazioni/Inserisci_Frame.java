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
		setResizable(false);
		RecensioneDAO rdao = new RecensioneDAO();
		setBounds(100, 100, 401, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textarea = new JTextArea();
		textarea.setBounds(10, 212, 342, 113);
		contentPanel.add(textarea);
		
		ristocombo = new JComboBox();
		ristocombo.setBounds(172, 37, 180, 20);
		contentPanel.add(ristocombo);
		this.updateComboBox(from);
		
		titolotext = new JTextField();
		titolotext.setBounds(171, 72, 180, 20);
		contentPanel.add(titolotext);
		titolotext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Scegli il Ristorante");
		lblNewLabel.setBounds(27, 40, 92, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserire il titolo");
		lblNewLabel_1.setBounds(41, 74, 77, 17);
		contentPanel.add(lblNewLabel_1);
		
		oneradio = new JRadioButton("*");
		oneradio.setBounds(20, 139, 38, 23);
		contentPanel.add(oneradio);
		
		threeradio = new JRadioButton("***");
		threeradio.setBounds(151, 139, 50, 23);
		contentPanel.add(threeradio);
		
		fourradio = new JRadioButton("****");
		fourradio.setBounds(236, 140, 50, 23);
		contentPanel.add(fourradio);
		
		tworadio = new JRadioButton("**");
		tworadio.setBounds(74, 139, 62, 23);
		contentPanel.add(tworadio);
		
		fiveradio = new JRadioButton("*****");
		fiveradio.setBounds(312, 139, 55, 23);
		contentPanel.add(fiveradio);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci recensione");
		lblNewLabel_2.setBounds(12, 187, 124, 14);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
						if(valutazione != "0" && from.equals("ristorante")) {//se il valore � ristorante , allora aggiunge la recensione con il codice corrispondente alla chiave esterna di ristorante
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
				JButton cancelButton = new JButton("Cancel");
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
