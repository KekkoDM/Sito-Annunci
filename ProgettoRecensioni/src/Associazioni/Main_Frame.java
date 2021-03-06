package Associazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

//Classe che rappresenta il frame principale
public class Main_Frame extends JFrame {

	ristoranteDAO rdao = new ristoranteDAO();
    AlloggioDAO adao = new AlloggioDAO();
    AttrazioneDAO tdao = new AttrazioneDAO();
    RecensioneDAO recdao = new RecensioneDAO();
    
    //elementi jswing del frame 
	private JTable ristotable;
	private JTable modristotable;
	private JTable alloggiotable;
	private JTable attrazionetable;
	private JLabel userlabel;
	private JButton accedijb;
	private JButton escijb;
	private JButton inseriscijb;
	private JButton admininseriscijb;
	private String from;
	private JPanel main_panel;
	
	//Costruttore del Frame principale
	public Main_Frame(Controller ctr) {
		
		setTitle("RevHub");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 603);
		main_panel = new JPanel();
		main_panel.setBackground(new Color(46, 139, 87));
		main_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_panel);
		main_panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(244, 0, 823, 574);
		main_panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		//Panel Home
		JPanel homepanel = new JPanel();
		homepanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(homepanel, "name_276067671491600");
		homepanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBounds(27, 11, 204, 99);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 75));
		homepanel.add(lblNewLabel);
		userlabel = new JLabel();
		userlabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		userlabel.setForeground(new Color(0, 0, 0));
		userlabel.setBounds(27, 190, 226, 36);
		homepanel.add(userlabel);
		
		accedijb = new JButton("Accedi\r\n");
		accedijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ctr.apriAccedi(); // chiamata funzione per accedere al frame di accesso
			}
		});
		accedijb.setForeground(new Color(255, 255, 255));
		accedijb.setBackground(new Color(46, 139, 87));
		accedijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		accedijb.setBounds(614, 51, 129, 36);
		homepanel.add(accedijb);
		
		JTextArea testo_home = new JTextArea();
		testo_home.setEditable(false);
		testo_home.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 15));
		testo_home.setText("Benvenuto in RevHub, il programma #1 di recensioni in Italia!\r\nPrima di iniziare, clicca sul bottone accedi se hai gi\u00E0 un account RevHub.");
		testo_home.setBounds(26, 121, 501, 46);
		homepanel.add(testo_home);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/capri.jpg")));
		label.setBounds(0, 278, 823, 296);
		homepanel.add(label);
		
		escijb = new JButton("Esci"); //Bottone per uscire dall'account corrente
		escijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.main.getAccediButton().setEnabled(true); 
				ctr.main.getUtenteLabel().setText(" ");
				Utente nuovo_utente = new Utente(); //creo nuovo utente vuoto
				ctr.setUtenteCorrente(nuovo_utente); //e setto l'attributo del controller con il nuovo utente (vuoto)
				
			}
		});
		escijb.setForeground(new Color(255, 255, 255));
		escijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		escijb.setBackground(new Color(46, 139, 87));
		escijb.setBounds(614, 119, 129, 35);
		homepanel.add(escijb);
		
		//Panel Ristorante
		JPanel ristopanel = new JPanel();
		ristopanel.setForeground(new Color(255, 255, 255));
		ristopanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(ristopanel, "name_276109691756800");
		ristopanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 149, 823, 436);
		ristopanel.add(scrollPane);
	
		//Tabella del ristorante
		ristotable = new JTable();
		ristotable.setEnabled(false);
		ristotable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Citt�", "Via", "Civico", "Specialit�"
			}
		));
		
		
		populateJTableRisto(ctr.getAllRistoranti(),ristotable); //Aggiungo in tabella tutti i ristoranti presenti nel DB
		
		
		scrollPane.setViewportView(ristotable);
		ristotable.setFillsViewportHeight(true);
		ristotable.setColumnSelectionAllowed(true);
		ristotable.setBackground(new Color(245, 245, 245));
		ristotable.setRowHeight(50);
		
		inseriscijb = new JButton("Inserisci"); //Bottone per inserire le recensioni per un certo elemento 
		inseriscijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		inseriscijb.setBackground(new Color(46, 139, 87));
		inseriscijb.setForeground(new Color(255, 255, 255));
		inseriscijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ctr.apriInserisci(from); //chiamata al frame di insrimento
			}
		});
		inseriscijb.setBounds(683, 100, 125, 30);
		
		
		admininseriscijb = new JButton("Inserisci"); //Bottone per inserire le recensioni per un certo elemento 
		admininseriscijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		admininseriscijb.setBackground(new Color(46, 139, 87));
		admininseriscijb.setForeground(new Color(255, 255, 255));
		admininseriscijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ctr.apriInserisciAdmin(from); //chiamata al frame di inserimento
			}
		});
		admininseriscijb.setBounds(683, 100, 125, 30);
		
		
		JButton btnNewButton = new JButton("Recensioni"); //bottone per visualizzare le recensioni
		btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String from = "ristorante"; 
				ctr.apriRecensioni(from);
			}
		});
		btnNewButton.setBounds(683, 60, 125, 30);
		ristopanel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/Ristoranti.png")));
		lblNewLabel_5.setBounds(0, 0, 280, 148);
		ristopanel.add(lblNewLabel_5);
		
		JRadioButton terrarb = new JRadioButton("Terra");
		terrarb.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		terrarb.setBackground(new Color(222, 184, 135));
		terrarb.setBounds(397, 30, 80, 25);
		ristopanel.add(terrarb);
		
		JRadioButton marerb = new JRadioButton("Mare");
		marerb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		marerb.setBackground(new Color(175, 238, 238));
		marerb.setBounds(484, 31, 80, 25);
		ristopanel.add(marerb);
		
		JRadioButton veganrb = new JRadioButton("Vegan");
		veganrb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		veganrb.setBackground(new Color(144, 238, 144));
		veganrb.setBounds(571, 31, 90, 25);
		ristopanel.add(veganrb);
		//gruppo di rb per la selezione delle tabelle di ristoranti
		ButtonGroup bgroup1 = new ButtonGroup();
        bgroup1.add(terrarb);
        bgroup1.add(marerb);
        bgroup1.add(veganrb);
		
		JButton cercajb = new JButton("Cerca");//bottone che cera tabelle in base al tipo selezionato
		cercajb.setForeground(new Color(255, 255, 255));
		cercajb.setBackground(new Color(46, 139, 87));
		cercajb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		cercajb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ristotable = new JTable();
				ristotable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nome", "Citt�", "Via", "Civico", "Specialit�" ,"Tipo"
					}
				));
				scrollPane.setViewportView(ristotable);
				ristotable.setEnabled(false);
				ristotable.setFillsViewportHeight(true);
				ristotable.setColumnSelectionAllowed(true);
				ristotable.setRowHeight(50);
				
				if(terrarb.isSelected()==true) { // se il tipo selezionato � terra, allora crea la tabella con escluzivamente ristoranti di terra
					populateJTableRisto(ctr.getAllRistorantiTerra(),ristotable); // funzione di inserimento nella jtable
					ristotable.setBackground(new Color(222, 184, 135));
				}
					
				else if(marerb.isSelected()==true) {// se il tipo selezionato � mare...
					populateJTableRisto(ctr.getAllRistorantiMare(),ristotable);
					ristotable.setBackground(new Color(175, 238, 238));
				}
					
				else if(veganrb.isSelected()==true) {// se il tipo selezionato � mare...
					populateJTableRisto(ctr.getAllRistorantiVegan(),ristotable);
					ristotable.setBackground(new Color(144, 238, 144));
				}
					
				else { // altrimenti , ricrea la tabella completa
					ristotable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Specialit�"
							}
						));
					populateJTableRisto(ctr.getAllRistoranti(),ristotable);
					ristotable.setBackground(new Color(245, 245, 245));
				}
			}
		});
		
		JRadioButton tuttird = new JRadioButton("Tutti");
		tuttird.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		tuttird.setBounds(310, 30, 80, 25);
		ristopanel.add(tuttird);
		bgroup1.add(tuttird);
		cercajb.setBounds(422, 84, 100, 30);
		ristopanel.add(cercajb);
		
		
		//PANEL ALLOGGIO
		JPanel alloggipanel = new JPanel();
		alloggipanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(alloggipanel, "name_276128323411800");
		alloggipanel.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 149, 836, 423);
		alloggipanel.add(scrollPane2);
	
		//TABELLA ALLOGGIO
		alloggiotable = new JTable();
		alloggiotable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Citt�", "Via", "Civico", "Bagni" ,"Camere"
			}
		));
		String tipo = " ";
		populateJTableAllo(ctr.getAllAlloggio(),alloggiotable,tipo); //popola la tabella con tutti gli alloggi disponibili
		scrollPane2.setViewportView(alloggiotable);
		alloggiotable.setFillsViewportHeight(true);
		alloggiotable.setColumnSelectionAllowed(true);
		alloggiotable.setEnabled(false);
		alloggiotable.setBackground(new Color(245, 245, 220));
		alloggiotable.setRowHeight(50);
		
		JButton btnNewButton_2 = new JButton("Recensioni"); //apri il frame per visualizzare le recensioni
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = "alloggio";
				ctr.apriRecensioni(from);
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		btnNewButton_2.setBackground(new Color(46, 139, 87));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(683, 60, 125, 30);
		alloggipanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/Alloggi.png")));
		lblNewLabel_1.setBounds(0, 0, 300, 150);
		alloggipanel.add(lblNewLabel_1);
		
		JRadioButton tuttirb2 = new JRadioButton("Tutti");
		tuttirb2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		tuttirb2.setBackground(new Color(240, 240, 240));
		tuttirb2.setBounds(310, 31, 80, 25);
		alloggipanel.add(tuttirb2);
		
		JRadioButton hotelrb = new JRadioButton("Hotel");
		hotelrb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		hotelrb.setBounds(397, 31, 80, 25);
		alloggipanel.add(hotelrb);
		
		JRadioButton bbrb = new JRadioButton("B&B");
		bbrb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		bbrb.setBounds(484, 31, 80, 25);
		alloggipanel.add(bbrb);
		
		JRadioButton casarb = new JRadioButton("Casa");
		casarb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		casarb.setBounds(571, 31, 80, 25);
		alloggipanel.add(casarb);
		
		//gruppo di radio button con i tipi di alloggi
		ButtonGroup bgroup2 = new ButtonGroup();
        bgroup2.add(tuttirb2);
        bgroup2.add(hotelrb);
        bgroup2.add(bbrb);
        bgroup2.add(casarb);
		
		JButton btnNewButton_1 = new JButton("Cerca");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(46, 139, 87));
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = "";
				if(hotelrb.isSelected()==true) { //se il rb � selezionato, crea la tabella con le colonne di quella determinata specializzazione
					alloggiotable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Bagni" ,"Camere","Stelle","Servizio"
							}
						));
					tipo = "hotel";
					populateJTableAllo(ctr.getAllAlloggioHotel(),alloggiotable,tipo);
				}
				else if(bbrb.isSelected()==true) {//se il rb � selezionato, crea la tabella con le colonne di quella determinata specializzazione
					alloggiotable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Bagni" ,"Camere","Colazione","CheckIn","CheckOut"
							}
						));
					tipo = "bb";
					populateJTableAllo(ctr.getAllAlloggioBB(),alloggiotable,tipo);
				}
				else if(casarb.isSelected()==true) {//se il rb � selezionato, crea la tabella con le colonne di quella determinata specializzazione
					alloggiotable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Bagni" ,"Camere","Giardino","Location"
							}
						));
					tipo = "casa";
					populateJTableAllo(ctr.getAllAlloggioCasa(),alloggiotable,tipo);
				}
				else {//se il rb � selezionato, crea la tabella "generale"
					alloggiotable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Bagni" ,"Camere"
							}
						));
					populateJTableAllo(ctr.getAllAlloggio(),alloggiotable,tipo);
				}
			}
			
		});
		btnNewButton_1.setBounds(422, 84, 100, 30);
		alloggipanel.add(btnNewButton_1);

		
		//PANEL ATTRAZIONE
		JPanel attrazionepanel = new JPanel();
		attrazionepanel.setBackground(Color.WHITE);
		layeredPane.add(attrazionepanel, "name_276141316664400");
		attrazionepanel.setLayout(null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(0, 144, 824, 430);
		attrazionepanel.add(scrollPane3);
	
		//TABELLA ATTRAZIONE
		attrazionetable = new JTable();
		attrazionetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Citt�", "Via", "Civico", "Descrizione" ,"Telefono"
			}
		));
		String tipo2 = " ";
		populateJTableAttr(ctr.getAllAttrazioni(),attrazionetable,tipo2);
		scrollPane3.setViewportView(attrazionetable);
		attrazionetable.setFillsViewportHeight(true);
		attrazionetable.setColumnSelectionAllowed(true);
		attrazionetable.setEnabled(false);
		attrazionetable.setBackground(new Color(245, 245, 220));
		attrazionetable.setRowHeight(50);
		
		JButton btnNewButton_5 = new JButton("Recensioni");//bottone che permette di accedere alle recensioni
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = "Attrazione";
				ctr.apriRecensioni(from);
			}
		});
		btnNewButton_5.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(46, 139, 87));
		btnNewButton_5.setBounds(683, 60, 125, 30);
		attrazionepanel.add(btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/Attrazioni.png")));
		lblNewLabel_4.setBounds(0, 0, 300, 151);
		attrazionepanel.add(lblNewLabel_4);
		
		JRadioButton cinemarb = new JRadioButton("Cinema");
		cinemarb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		cinemarb.setBounds(377, 31, 100, 25);
		attrazionepanel.add(cinemarb);
		
		JRadioButton museorb = new JRadioButton("Museo");
		museorb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		museorb.setBounds(484, 32, 90, 25);
		attrazionepanel.add(museorb);
		
		JRadioButton parcorb = new JRadioButton("Parco");
		parcorb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		parcorb.setBounds(581, 32, 90, 25);
		attrazionepanel.add(parcorb);
		
		JRadioButton tuttirb3 = new JRadioButton("Tutti");
		tuttirb3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		tuttirb3.setBounds(280, 31, 90, 25);
		attrazionepanel.add(tuttirb3);
		
		//gruppo con i bottoni delle specializziazioni di attrazione
		ButtonGroup bgroup3 = new ButtonGroup();
        bgroup3.add(tuttirb3);
        bgroup3.add(cinemarb);
        bgroup3.add(museorb);
        bgroup3.add(parcorb);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBackground(new Color(46, 139, 87));
		btnCerca.setForeground(new Color(255, 255, 255));
		btnCerca.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = "";//flag che permette di indicare il tipo specializzato
				
				if(cinemarb.isSelected()==true) {//se il rb � selezionato, crea la tabella con le colonne di quella determinata specializzazione
					attrazionetable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Descrizione" ,"Orario" , "Telefono"
							}
						));
					tipo = "cinema";
					populateJTableAttr(ctr.getAllAttrazioniCinema(),attrazionetable,tipo);
				}
				else if(museorb.isSelected()==true) {//se il rb � selezionato, crea la tabella con le colonne di quella determinata specializzazione
					attrazionetable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Descrizione" ,"Orario" , "Telefono","Guida","Patrimonio"
							}
						));
					tipo = "museo";
					populateJTableAttr(ctr.getAllAttrazioniMuseo(),attrazionetable,tipo);
				}
				else if(parcorb.isSelected()==true) {//se il rb � selezionato, crea la tabella con le colonne di quella determinata specializzazione
					attrazionetable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Descrizione" ,"Orario" , "Telefono", "N�Giostre", "Zoo","Spettacoli"
							}
						));
					tipo = "parco";
					populateJTableAttr(ctr.getAllAttrazioniParco(),attrazionetable,tipo);
				}
				else {//se il rb � selezionato, crea la tabella "generale"
					attrazionetable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Citt�", "Via", "Civico", "Descrizione" ,"Orario" , "Telefono"
							}
						));
					populateJTableAttr(ctr.getAllAttrazioni(),attrazionetable,tipo);
				}
			}
		});
		btnCerca.setBounds(422, 84, 100, 30);
		attrazionepanel.add(btnCerca);
		
		//PANEL RISTORANTE MODERATORE
		JPanel modristopanel = new JPanel();
		modristopanel.setBackground(Color.WHITE);
		layeredPane.add(modristopanel, "name_1447936606331700");
		modristopanel.setLayout(null);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(0, 0, 823, 514);
		modristopanel.add(scrollPane4);
	
		//TABELLA MODERATORE
		modristotable = new JTable();
		modristotable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titolo", "Testo", "Valutazione", "Data","Cod Recensione","Utente"
			}
		));
		
		scrollPane4.setViewportView(modristotable);
		modristotable.setFillsViewportHeight(true);
		modristotable.setColumnSelectionAllowed(true);
		modristotable.setBackground(new Color(245, 245, 245));
		modristotable.setRowHeight(50);
		
		JButton btnConferma = new JButton("Conferma");//bottone che permette di accettare una recensione
		btnConferma.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		btnConferma.setForeground(new Color(255, 255, 255));
		btnConferma.setBackground(new Color(46, 139, 87));
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modristotable.getSelectedRow() != -1) {
		            Recensione r = new Recensione();//creo l'oggetto recensione e lo setto con tutti i parametri presi dalla tabella
					r.setTitolo((String) modristotable.getValueAt(modristotable.getSelectedRow(), 0));
		            r.setTesto((String) modristotable.getValueAt(modristotable.getSelectedRow(), 1));
		            r.setValutazione((String) modristotable.getValueAt(modristotable.getSelectedRow(), 2));
		            r.setData((String) modristotable.getValueAt(modristotable.getSelectedRow(), 3));
		            r.setCodice((String) modristotable.getValueAt(modristotable.getSelectedRow(), 4));
		            ctr.approvaRecensione(r); //chiamo la funzione di "approvazione"
		            ((DefaultTableModel) modristotable.getModel()).removeRow(modristotable.getSelectedRow()); 
			}
			}
		});
		btnConferma.setBounds(535, 523, 120, 35);
		modristopanel.add(btnConferma);
		
		JButton btnElimina = new JButton("Elimina");//permette di non approvare una determinata funzione
		btnElimina.setBackground(new Color(46, 139, 87));
		btnElimina.setForeground(new Color(255, 255, 255));
		btnElimina.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modristotable.getSelectedRow() != -1) {
		            Recensione r = new Recensione();
					
		            r.setCodice((String) modristotable.getValueAt(modristotable.getSelectedRow(), 4));
		            recdao.cancellaRecensione(r); //la recensione viene tolta di mezzo attraverso il suo codice
		            ((DefaultTableModel) modristotable.getModel()).removeRow(modristotable.getSelectedRow()); 
			}
			}
		});
		btnElimina.setBounds(688, 523, 120, 35);
		modristopanel.add(btnElimina);
		
		
		
		//BOTTONE RISTORANTE
		JButton ristojb = new JButton("Ristorante");
		ristojb.setBounds(0, 204, 244, 43);
		ristojb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				from="ristorante";// DA MODIFICARE
				ctr.switchPanel(layeredPane,ristopanel);
				if(ctr.getUtenteCorrente().getTipo().equals("moderatore")) 
					ctr.switchPanel(layeredPane, ristopanel);
					
				
				else if(ctr.getUtenteCorrente().getTipo().equals("base"))
					ristopanel.add(inseriscijb);
				else if(ctr.getUtenteCorrente().getTipo().equals("admin"))
					ristopanel.add(admininseriscijb);
			}
		});
		ristojb.setForeground(new Color(255, 255, 255));
		ristojb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		ristojb.setBackground(new Color(46, 139, 87));
		main_panel.add(ristojb);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		ristojb.setBorder(emptyBorder);
		
		JButton alloggijb = new JButton("Alloggi\r\n");
		alloggijb.setBounds(0, 258, 244, 43);
		alloggijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				from="alloggio";// DA MODIFICARE
				ctr.switchPanel(layeredPane,alloggipanel);
				if(ctr.getUtenteCorrente().getTipo().equals("moderatore")) 
					ctr.switchPanel(layeredPane, alloggipanel);
				
				else if(ctr.getUtenteCorrente().getTipo().equals("base"))
					alloggipanel.add(inseriscijb);
				else if(ctr.getUtenteCorrente().getTipo().equals("admin"))
					alloggipanel.add(admininseriscijb);
			}
		});
		alloggijb.setBackground(new Color(46, 139, 87));
		alloggijb.setForeground(new Color(255, 255, 255));
		alloggijb.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 23));
		main_panel.add(alloggijb);
		Border emptyBorder1 = BorderFactory.createEmptyBorder();
		alloggijb.setBorder(emptyBorder1);
		
		JButton homejb = new JButton("Home\r\n");
		homejb.setBounds(0, 151, 244, 43);
		homejb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctr.switchPanel(layeredPane,homepanel);
			}
		});
		homejb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		homejb.setForeground(Color.WHITE);
		homejb.setBackground(new Color(46, 139, 87));
		main_panel.add(homejb);
		Border emptyBorder2 = BorderFactory.createEmptyBorder();
		homejb.setBorder(emptyBorder2);
		
		
		JButton attrazionijb = new JButton("Attrazioni\r\n");
		attrazionijb.setBounds(0, 312, 244, 43);
		attrazionijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				from="attrazione";// DA MODIFICARE
				ctr.switchPanel(layeredPane,attrazionepanel);
				if(ctr.getUtenteCorrente().getTipo().equals("moderatore")) 
					ctr.switchPanel(layeredPane, attrazionepanel);
				
				else if(ctr.getUtenteCorrente().getTipo().equals("base"))
					attrazionepanel.add(inseriscijb);
				else if(ctr.getUtenteCorrente().getTipo().equals("admin"))
					attrazionepanel.add(admininseriscijb);
			}
		});
		attrazionijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		attrazionijb.setForeground(new Color(255, 255, 255));
		attrazionijb.setBackground(new Color(46, 139, 87));
		main_panel.add(attrazionijb);
		Border emptyBorder3 = BorderFactory.createEmptyBorder();
		attrazionijb.setBorder(emptyBorder3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(49, 1, 154, 88);
		lblNewLabel_2.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/Senza titolo.png")));
		main_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RevHub\r\n");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(76, 89, 104, 26);
		lblNewLabel_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 28));
		main_panel.add(lblNewLabel_3);
		
		JButton modjb = new JButton("Area Moderatore");
		modjb.setBackground(new Color(46, 139, 87));
		Border emptyBorder5 = BorderFactory.createEmptyBorder();
		modjb.setBorder(emptyBorder5);
		modjb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ctr.getUtenteCorrente().getTipo().contentEquals("moderatore")) {
					ctr.switchPanel(layeredPane, modristopanel);
					ArrayList<Recensione> listar = new ArrayList<Recensione>();
					listar = recdao.getAllRecensioniNA();
					populateJTableRece(listar,modristotable);
				}
					
				else
					JOptionPane.showMessageDialog(null, "Non sei moderatore!!");
			}
		});
		modjb.setForeground(Color.WHITE);
		modjb.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 23));
		modjb.setBounds(0, 366, 244, 43);
		main_panel.add(modjb);
	}	
	
	public void populateJTableRisto(ArrayList<ristorante> list,JTable ristotable) {//popola la jtable con gli elementi di un arraylist
		DefaultTableModel model = (DefaultTableModel) ristotable.getModel();
		Object[] riga = new Object[6];
		for(int i=0;i<list.size();i++) {
			riga[0] = list.get(i).getNome();
			riga[1] = list.get(i).getCitt�();
			riga[2] = list.get(i).getVia();
			riga[3] = list.get(i).getCivico();
			riga[4] = list.get(i).getSpecialita();
			riga[5] = list.get(i).getTipo();
			model.addRow(riga);
		}
	}
	public void populateJTableAllo(ArrayList<Alloggio> listalh,JTable alloggiotable,String tipo) {//popola la jtable con gli elementi di un arraylist
		DefaultTableModel model = (DefaultTableModel) alloggiotable.getModel();
		Object[] riga = new Object[10];
		for(int i=0;i<listalh.size();i++) {
			riga[0] = listalh.get(i).getNome();
			riga[1] = listalh.get(i).getCitt�();
			riga[2] = listalh.get(i).getVia();
			riga[3] = listalh.get(i).getCivico();
			riga[4] = listalh.get(i).getBagni();
			riga[5] = listalh.get(i).getCamere();
			if(tipo.equals("hotel")) {//in base al valore del flag(tipo) vengono aggiunte determinate colonne alla jtable 
				Hotel a =  (Hotel) listalh.get(i);
				riga[6] = a.getStelle();
				riga[7] = a.getServizio();
			}else if(tipo.equals("bb")) {
				BandB a =  (BandB) listalh.get(i);
				riga[6] = a.getColazione();
				riga[7] = a.getCheckIn();
				riga[8] = a.getCheckOut();
			}else if(tipo.equals("casa")){
				Casa a =  (Casa) listalh.get(i);
				riga[6] = a.getGiardino();
				riga[7] = a.getLocation();
			}		
			model.addRow(riga);
		}
	}
	public void populateJTableAttr(ArrayList<Attrazione> list,JTable attrazionetable,String tipo) {//popola la jtable con gli elementi di un arraylist
		DefaultTableModel model = (DefaultTableModel) attrazionetable.getModel();
		Object[] riga = new Object[10];
		for(int i=0;i<list.size();i++) {
			riga[0] = list.get(i).getNome();
			riga[1] = list.get(i).getCitt�();
			riga[2] = list.get(i).getVia();
			riga[3] = list.get(i).getCivico();
			riga[4] = list.get(i).getDescrizione();
			riga[5] = list.get(i).getTelefono();
			switch(tipo) {//in base al valore del flag(tipo) vengono aggiunte determinate colonne alla jtable 
				case "cinema": {
					Cinema a =  (Cinema) list.get(i);
					riga[6] = a.getNSale();
					riga[7] = a.getCapienza();
					break;
				}
				case "museo": {
					Museo a =  (Museo) list.get(i);
					riga[6] = a.isGuida();
					riga[7] = a.getPatrimonio();
					break;
				}
				case "parco":{
					Parco a =  (Parco) list.get(i);
					riga[6] = a.getNGiostre();
					riga[7] = a.isZoo();
					riga[8] = a.isSpettacoli();
					break;
				}
			}
			model.addRow(riga);
		}
	}
	public void populateJTableRece(ArrayList<Recensione> list,JTable modrecetable) {//popola la jtable con gli elementi di un arraylist 
		DefaultTableModel model = (DefaultTableModel) modrecetable.getModel();
		Object[] riga = new Object[6];
		for(int i=0;i<list.size();i++) {
			riga[0] = list.get(i).getTitolo();
			riga[1] = list.get(i).getTesto();
			riga[2] = list.get(i).getValutazione();
			riga[3] = list.get(i).getData();
			riga[4] = list.get(i).getCodice();
			riga[5] = list.get(i).getCodU();
			model.addRow(riga);
		}
	}

	
	public void setUtenteLabel(Controller ctr) {//modifica la label con l'username dell'utente corrente
		this.getUtenteLabel().setText("Bentornato "+ctr.getUtenteCorrente().getUsername()+"!!!!");
		this.getAccediButton().setEnabled(false);
	}
	public JLabel getUtenteLabel() {
		return userlabel;
	}
	public JButton getAccediButton() {
		return accedijb;
	}
	public JButton getEsciButton() {
		return escijb;
	}
	
	
}
