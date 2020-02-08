package Associazioni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

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

	public Inserisci_Frame(Controller ctr) {
		setTitle("DACCI UNA VALUTAZIONE !");
		RecensioneDAO rdao = new RecensioneDAO();
		setBounds(100, 100, 401, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textarea = new JTextArea();
		textarea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textarea.setBounds(10, 212, 358, 98);
		contentPanel.add(textarea);
		
		ristocombo = new JComboBox();
		ristocombo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ristocombo.setBounds(172, 32, 180, 30);
		contentPanel.add(ristocombo);
		this.updateComboBox();
		
		titolotext = new JTextField();
		titolotext.setFont(new Font("Tahoma", Font.PLAIN, 19));
		titolotext.setBounds(171, 72, 180, 30);
		contentPanel.add(titolotext);
		titolotext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Scegli il Ristorante");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 40, 147, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci il Titolo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 74, 146, 17);
		contentPanel.add(lblNewLabel_1);
		
		oneradio = new JRadioButton("*");
		oneradio.setBounds(10, 139, 50, 23);
		contentPanel.add(oneradio);
		
		threeradio = new JRadioButton("***");
		threeradio.setBounds(136, 139, 62, 23);
		contentPanel.add(threeradio);
		
		fourradio = new JRadioButton("****");
		fourradio.setBounds(207, 139, 74, 23);
		contentPanel.add(fourradio);
		
		tworadio = new JRadioButton("**");
		tworadio.setBounds(67, 139, 62, 23);
		contentPanel.add(tworadio);
		
		fiveradio = new JRadioButton("*****");
		fiveradio.setBounds(288, 139, 80, 23);
		contentPanel.add(fiveradio);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci recensione");
		lblNewLabel_2.setBounds(12, 187, 145, 14);
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
						String luogo = ristocombo.getSelectedItem().toString();
						String titolo = titolotext.getText();
						String testo = textarea.getText();
						String valutazione = getValutazione(oneradio, tworadio, threeradio, fourradio, fiveradio);
						if(valutazione != "0") {
						rdao.AggiungiRecensione(luogo,titolo,testo,valutazione);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					   textarea.setText("");
					
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void updateComboBox() {
		Connessione c = new Connessione();
		c.ConnessioneDB();
		try {
			ResultSet rs= c.Query("*","ristorante"," ");
			while(rs.next()) {
				this.getComboBox().addItem(rs.getString("nome"));
			}
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	public JComboBox getComboBox() {
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
