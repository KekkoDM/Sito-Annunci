package Associazioni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class InserisciAdmin_Frame extends Inserisci_Frame {

	private final JPanel contentPanel = new JPanel();
	private JTextField nome;
	private JTextField citta;
	private JTextField via;
	private JTextField telefono;
   
	
	private JTextField specialita;
	private JTextField provenienza;
	private JTextField qualita;
	private JComboBox<String> mare;
	private JComboBox<String> terra;
	private JComboBox<String> vegan;
	
	private JComboBox<Integer> bagni;
	private JComboBox<Integer> camere;
	private JComboBox<Integer> letti;
	private JComboBox<Integer> metriq;
	
    
    
    Connessione c = new Connessione();
	ristorante risto = new ristorante();
	
	
	public InserisciAdmin_Frame(Controller ctr, String from) {
		
		super(ctr, from, null);
		
		setBounds(100, 100, 593, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 25, 56, 16);
		contentPanel.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(58, 22, 116, 22);
		contentPanel.add(nome);
		nome.setColumns(10);
		
		JLabel lblCitt = new JLabel("Citt\u00E0");
		lblCitt.setBounds(12, 54, 56, 16);
		contentPanel.add(lblCitt);
		
		citta = new JTextField();
		citta.setBounds(58, 51, 116, 22);
		contentPanel.add(citta);
		citta.setColumns(10);
		
		JLabel lblVia = new JLabel("Via");
		lblVia.setBounds(12, 83, 56, 16);
		contentPanel.add(lblVia);
		
		via = new JTextField();
		via.setBounds(58, 83, 116, 22);
		contentPanel.add(via);
		via.setColumns(10);
		
		JLabel lblCivico = new JLabel("Civico");
		lblCivico.setBounds(12, 112, 56, 16);
		contentPanel.add(lblCivico);
		
		JComboBox<Integer> civico = new JComboBox<Integer>();
		civico.setBounds(58, 109, 43, 22);
		contentPanel.add(civico);
		for(int i=1;i<=100;i++)
			civico.addItem(new Integer(i));
		
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 138, 56, 16);
		contentPanel.add(lblTelefono);
		
		telefono = new JTextField();
		telefono.setBounds(80, 135, 116, 22);
		contentPanel.add(telefono);
		telefono.setColumns(10);
		
		switch (from) {
		case "ristorante":
			this.addSchermataRistorante();
			
			break;

			
		case "alloggio":
			this.addSchermataAlloggio();
			break;
			
			
		
		default:
			break;
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Inserisci");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(from.equals("ristorante")) {//se il valore è ristorante , allora aggiunge la recensione con il codice corrispondente alla chiave esterna di ristorante
							risto.setNome(nome.getText());
							risto.setCittà(citta.getText());
							risto.setCivico(civico.toString());
							risto.setProvenienza(provenienza.getText());
							risto.setQualita(qualita.getText());
							risto.setSpecialita(specialita.getText());
							risto.setCodm2(mare.getSelectedIndex());
							risto.setCodt2(terra.getSelectedIndex());
							risto.setCodv2(vegan.getSelectedIndex());
							ctr.inserisciRistorante(risto, from);
						}
							
							
//						}else if(valutazione != "0" && from.equals("alloggio")){
//							ctr.inserisciRecensione(r,from,"codal");
//							ctr.chiudiInserisci();	
//						}else if(valutazione != "0" && from.equals("attrazione")){
//							ctr.inserisciRecensione(r,from,"codat");
//							ctr.chiudiInserisci();
//						}
//						
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
	
	
	public void updateComboBox(JComboBox<String> combo,String from,String tipo) {//prende dal DB tutti i nomi degli elementi interessati (ristoranti, alloggi o attrazioni)
		Connessione c = new Connessione();
		c.ConnessioneDB();
		try {
			ResultSet rs= c.Query("*",from," ");
			while(rs.next()) {
				combo.addItem(rs.getString(tipo));
			}
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	
	public void addSchermataRistorante() {
		
		JLabel lblSpecialita = new JLabel("Specialità");
		lblSpecialita.setBounds(12, 162, 56, 16);
		contentPanel.add(lblSpecialita);
		
		specialita = new JTextField();
		specialita.setBounds(80, 165, 116, 22);
		contentPanel.add(specialita);
		specialita.setColumns(10);
		
		JLabel lblQualita = new JLabel("Qualità");
		lblQualita.setBounds(12, 192, 56, 16);
		contentPanel.add(lblQualita);
		
		qualita = new JTextField();
		qualita.setBounds(80, 195, 116, 22);
		contentPanel.add(qualita);
		qualita.setColumns(10);
		
		JLabel lblProvenienza = new JLabel("Provenienza");
		lblProvenienza.setBounds(12, 222, 56, 16);
		contentPanel.add(lblProvenienza);
		
		provenienza = new JTextField();
		provenienza.setBounds(80, 225, 116, 22);
		contentPanel.add(provenienza);
		provenienza.setColumns(10);
		
		
		JLabel lblMare = new JLabel("Mare");
		lblMare.setBounds(200, 22, 116, 22);
		contentPanel.add(lblMare);
		
		mare = new JComboBox<String>();
		mare.setBounds(240, 22, 100, 22);
		contentPanel.add(mare);
		mare.addItem(null);
		this.updateComboBox(mare,"mare","tipom");
		
		
		
		JLabel lblTerra = new JLabel("Terra");
		lblTerra.setBounds(200, 62, 116, 22);
		contentPanel.add(lblTerra);
		
		terra = new JComboBox<String>();
		terra.setBounds(240, 62, 100, 22);
		contentPanel.add(terra);
		terra.addItem(null);
		this.updateComboBox(terra,"terra","tipot");
		
		
		JLabel lblVegan = new JLabel("Vegan");
		lblVegan.setBounds(200, 92, 116, 22);
		contentPanel.add(lblVegan);
		
		vegan = new JComboBox<String>();
		vegan.setBounds(240, 92, 100, 22);
		contentPanel.add(vegan);
		vegan.addItem(null);
		this.updateComboBox(vegan,"vegan","tipov");
		
	}
	
	
	public void addSchermataAlloggio() {
		JLabel lblBagni = new JLabel("Bagni");
		lblBagni.setBounds(200, 22, 116, 22);
		contentPanel.add(lblBagni);
		
		bagni = new JComboBox<Integer>();
		bagni.setBounds(270, 22, 116, 22);
		contentPanel.add(bagni);
		bagni.addItem(null);
		for(int i=1;i<5;i++)
			bagni.addItem(new Integer(i));
		
		JLabel lblCamere = new JLabel("Camere");
		lblCamere.setBounds(200, 62, 116, 22);
		contentPanel.add(lblCamere);
		
		camere = new JComboBox<Integer>();
		camere.setBounds(270, 62, 116, 22);
		contentPanel.add(camere);
		camere.addItem(null);
		for(int i=1;i<=100;i++)
			camere.addItem(new Integer(i));
		
		
		
		JLabel lblMetriQ = new JLabel("Metri quadri");
		lblMetriQ.setBounds(200, 92, 116, 22);
		contentPanel.add(lblMetriQ);
		
		metriq = new JComboBox<Integer>();
		metriq.setBounds(270, 92, 116, 22);
		contentPanel.add(metriq);
		metriq.addItem(null);
		for(int i=1;i<=100;i++)
			metriq.addItem(new Integer(i));
		
		
		JLabel lblLetti = new JLabel("Letti");
		lblLetti.setBounds(200,112, 116, 22);
		contentPanel.add(lblLetti);
		
		letti = new JComboBox<Integer>();
		letti.setBounds(270, 112, 100, 22);
		contentPanel.add(letti);
		for(int i=1;i<=10;i++)
			letti.addItem(new Integer(i));
	}
}
