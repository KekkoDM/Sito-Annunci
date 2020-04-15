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
import java.awt.Font;
import java.awt.Color;

public class InserisciAdmin_Frame extends JDialog {

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
	private JComboBox<String> tipo;
	
    
	private JButton okButton;
	private JPanel buttonPane;
	
    
    Connessione c = new Connessione();
	ristorante risto = new ristorante();
	Alloggio allo = new Alloggio();
	
	public InserisciAdmin_Frame(Controller ctr, String from) {
		setTitle("Inserisci Localit\u00E0");
		
		ctr.main.setEnabled(false);
		
		setBounds(100, 100, 593, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 20, 56, 25);
		contentPanel.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(80, 20, 125, 25);
		contentPanel.add(nome);
		nome.setColumns(10);
		
		JLabel lblCitt = new JLabel("Citt\u00E0");
		lblCitt.setBounds(10, 50, 56, 25);
		contentPanel.add(lblCitt);
		
		citta = new JTextField();
		citta.setBounds(80, 50, 125, 25);
		contentPanel.add(citta);
		citta.setColumns(10);
		
		JLabel lblVia = new JLabel("Via");
		lblVia.setBounds(10, 80, 56, 25);
		contentPanel.add(lblVia);
		
		via = new JTextField();
		via.setBounds(80, 80, 125, 25);
		contentPanel.add(via);
		via.setColumns(10);
		
		JLabel lblCivico = new JLabel("Civico");
		lblCivico.setBounds(10, 120, 56, 25);
		contentPanel.add(lblCivico);
		
		JComboBox<Integer> civico = new JComboBox<Integer>();
		civico.setBounds(80, 120, 43, 25);
		contentPanel.add(civico);
		for(int i=1;i<=100;i++)
			civico.addItem(new Integer(i));
		
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 150, 74, 25);
		contentPanel.add(lblTelefono);
		
		telefono = new JTextField();
		telefono.setBounds(80, 150, 125, 25);
		contentPanel.add(telefono);
		telefono.setColumns(10);
		
		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Inserisci");
				okButton.setBackground(new Color(46, 139, 87));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
				okButton.setVisible(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(from.equals("ristorante")) {//se il valore è ristorante , allora aggiunge la recensione con il codice corrispondente alla chiave esterna di ristorante
							risto.setNome(nome.getText());
							risto.setCittà(citta.getText());
							risto.setCivico(civico.getSelectedIndex());
							risto.setProvenienza(provenienza.getText());
							risto.setTelefono(telefono.getText());
							risto.setQualita(qualita.getText());
							risto.setSpecialita(specialita.getText());
							risto.setCodm2(mare.getSelectedIndex());
							risto.setCodt2(terra.getSelectedIndex());
							risto.setCodv2(vegan.getSelectedIndex());
							ctr.inserisciRistorante(risto, from);
							ctr.main.setEnabled(true);
							dispose();
						}
						
						else if(from.contentEquals("alloggio")){
							allo.setNome(nome.getText());
							allo.setCittà(citta.getText());
							allo.setCivico(civico.toString());
							allo.setTelefono(telefono.getText());
							allo.setBagni(bagni.getSelectedIndex());
							allo.setCamere(camere.getSelectedIndex());
							allo.setMetriq(metriq.getSelectedIndex()+1);
							
							
							ctr.main.setEnabled(true);
							dispose();
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
				cancelButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
				cancelButton.setBackground(new Color(46, 139, 87));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		switch (from) {
		case "ristorante":
			
			this.addSchermataRistorante();
			
			
			break;

			
		case "alloggio":
			this.addSchermataAlloggio(this);
			break;
			
			
		
		default:
			break;
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
		c.ChiudiConn();
	}
	
	
	public void addSchermataRistorante() {
		
		okButton.setVisible(true);
		
		JLabel lblSpecialita = new JLabel("Specialità");
		lblSpecialita.setBounds(10, 180, 56, 25);
		contentPanel.add(lblSpecialita);
		
		specialita = new JTextField();
		specialita.setBounds(80, 180, 125, 25);
		contentPanel.add(specialita);
		specialita.setColumns(10);
		
		JLabel lblQualita = new JLabel("Qualità");
		lblQualita.setBounds(10, 210, 56, 25);
		contentPanel.add(lblQualita);
		
		qualita = new JTextField();
		qualita.setBounds(80, 210, 125, 25);
		contentPanel.add(qualita);
		qualita.setColumns(10);
		
		JLabel lblProvenienza = new JLabel("Provenienza");
		lblProvenienza.setBounds(12, 240, 80, 25);
		contentPanel.add(lblProvenienza);
		
		provenienza = new JTextField();
		provenienza.setBounds(80, 240, 125, 25);
		contentPanel.add(provenienza);
		provenienza.setColumns(10);
		
		
		JLabel lblMare = new JLabel("Mare");
		lblMare.setBounds(350, 20, 125, 25);
		contentPanel.add(lblMare);
		
		mare = new JComboBox<String>();
		mare.setBounds(390, 20, 125, 25);
		contentPanel.add(mare);
		mare.addItem(null);
		this.updateComboBox(mare,"mare","tipom");
		
		
		
		JLabel lblTerra = new JLabel("Terra");
		lblTerra.setBounds(350, 50, 125, 25);
		contentPanel.add(lblTerra);
		
		terra = new JComboBox<String>();
		terra.setBounds(390, 50, 125, 25);
		contentPanel.add(terra);
		terra.addItem(null);
		this.updateComboBox(terra,"terra","tipot");
		
		
		JLabel lblVegan = new JLabel("Vegan");
		lblVegan.setBounds(350, 80, 125, 25);
		contentPanel.add(lblVegan);
		
		vegan = new JComboBox<String>();
		vegan.setBounds(390, 80, 125, 25);
		contentPanel.add(vegan);
		vegan.addItem(null);
		this.updateComboBox(vegan,"vegan","tipov");
		
		
		
	}
	
	
	public void addSchermataAlloggio(InserisciAdmin_Frame frame) {
		JLabel lblBagni = new JLabel("Bagni");
		lblBagni.setBounds(350, 20, 125, 25);
		contentPanel.add(lblBagni);
		
		bagni = new JComboBox<Integer>();
		bagni.setBounds(430, 20, 125, 25);
		contentPanel.add(bagni);
		bagni.addItem(null);
		for(int i=1;i<5;i++)
			bagni.addItem(new Integer(i));
		
		JLabel lblCamere = new JLabel("Camere");
		lblCamere.setBounds(350, 50, 125, 25);
		contentPanel.add(lblCamere);
		
		camere = new JComboBox<Integer>();
		camere.setBounds(430, 50, 125, 25);
		contentPanel.add(camere);
		camere.addItem(null);
		for(int i=1;i<=100;i++)
			camere.addItem(new Integer(i));
		
		
		
		JLabel lblMetriQ = new JLabel("Metri quadri");
		lblMetriQ.setBounds(350, 80, 125, 25);
		contentPanel.add(lblMetriQ);
		
		metriq = new JComboBox<Integer>();
		metriq.setBounds(430, 80, 125, 25);
		contentPanel.add(metriq);
		metriq.addItem(null);
		for(int i=1;i<=100;i++)
			metriq.addItem(new Integer(i));
		
		
		JLabel lblLetti = new JLabel("Letti");
		lblLetti.setBounds(350,110, 125, 25);
		contentPanel.add(lblLetti);
		
		letti = new JComboBox<Integer>();
		letti.setBounds(430, 110, 125, 25);
		contentPanel.add(letti);
		for(int i=1;i<=10;i++)
			letti.addItem(new Integer(i));
		
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(350,140, 125, 25);
		contentPanel.add(lblTipo);
		
		tipo = new JComboBox<String>();
		tipo.setBounds(430, 140, 125, 25);
		contentPanel.add(tipo);
		tipo.addItem(null);
		tipo.addItem("Hotel");
		tipo.addItem("Bed & Breakfast");
		tipo.addItem("Casa");
		
		
		JButton avantiButton = new JButton("Avanti");
		avantiButton.setBackground(new Color(46, 139, 87));
		avantiButton.setForeground(new Color(255, 255, 255));
		avantiButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		avantiButton.setVisible(true);
		avantiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allo.setTipo(tipo.getSelectedItem().toString());
				frame.estendiFrame(allo.getTipo());
			}

			
			
		});
		
		buttonPane.add(avantiButton);
		
	}
	
	
	private void estendiFrame(String tipo) {
		
		
		
	}
	
	
	public void addSchermataAttrazione() {
		
		JLabel lblSpecialita = new JLabel("Specialità");
		lblSpecialita.setBounds(10, 180, 56, 25);
		contentPanel.add(lblSpecialita);
		
		specialita = new JTextField();
		specialita.setBounds(80, 180, 125, 25);
		contentPanel.add(specialita);
		specialita.setColumns(10);
		
		JLabel lblQualita = new JLabel("Qualità");
		lblQualita.setBounds(10, 210, 56, 25);
		contentPanel.add(lblQualita);
		
		qualita = new JTextField();
		qualita.setBounds(80, 210, 125, 25);
		contentPanel.add(qualita);
		qualita.setColumns(10);
		
		JLabel lblProvenienza = new JLabel("Provenienza");
		lblProvenienza.setBounds(12, 240, 80, 25);
		contentPanel.add(lblProvenienza);
		
		provenienza = new JTextField();
		provenienza.setBounds(80, 240, 125, 25);
		contentPanel.add(provenienza);
		provenienza.setColumns(10);
		
		
		JLabel lblMare = new JLabel("Mare");
		lblMare.setBounds(350, 20, 125, 25);
		contentPanel.add(lblMare);
		
		mare = new JComboBox<String>();
		mare.setBounds(390, 20, 125, 25);
		contentPanel.add(mare);
		mare.addItem(null);
		this.updateComboBox(mare,"mare","tipom");
		
		
		
		JLabel lblTerra = new JLabel("Terra");
		lblTerra.setBounds(350, 50, 125, 25);
		contentPanel.add(lblTerra);
		
		terra = new JComboBox<String>();
		terra.setBounds(390, 50, 125, 25);
		contentPanel.add(terra);
		terra.addItem(null);
		this.updateComboBox(terra,"terra","tipot");
		
		
		JLabel lblVegan = new JLabel("Vegan");
		lblVegan.setBounds(350, 80, 125, 25);
		contentPanel.add(lblVegan);
		
		vegan = new JComboBox<String>();
		vegan.setBounds(390, 80, 125, 25);
		contentPanel.add(vegan);
		vegan.addItem(null);
		this.updateComboBox(vegan,"vegan","tipov");
		
	}
}
