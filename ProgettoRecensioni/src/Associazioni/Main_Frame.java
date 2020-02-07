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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JCheckBox;

public class Main_Frame extends JFrame {

	private JPanel main_panel;
    ristoranteDAO rdao = new ristoranteDAO();
    AlloggioDAO adao = new AlloggioDAO();
    AttrazioneDAO tdao = new AttrazioneDAO();
    RecensioneDAO recDAO = new RecensioneDAO();
	private JTable ristotable;
	private JTable modristotable;
	private JTable alloggiotable;
	private JTable attrazionetable;
	private Utente UtenteCorrente;
	private JLabel userlabel;
	private JButton accedijb;
	private JButton escijb;
	private JButton aggiungijb;
	private JButton inseriscijb;
	
	public Main_Frame(Controller ctr) {
		
		UtenteCorrente = new Utente();
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
				ctr.apriAccedi();
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
		
		escijb = new JButton("Esci");
		escijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.main.getAccediButton().setEnabled(true);
				ctr.main.getUtenteCorrente();
				ctr.main.getUtenteLabel().setText(" ");
				Utente nuovo_utente = new Utente();
				ctr.main.setUtenteCorrente(nuovo_utente);
			}
		});
		escijb.setForeground(new Color(255, 255, 255));
		escijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		escijb.setBackground(new Color(46, 139, 87));
		escijb.setBounds(614, 119, 129, 35);
		homepanel.add(escijb);
		
		JPanel ristopanel = new JPanel();
		ristopanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(ristopanel, "name_276109691756800");
		ristopanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 115, 598, 426);
		ristopanel.add(scrollPane);
	
		//TABELLA RISTORANTE
		ristotable = new JTable(rdao.getRistoranti());
	/*	ristotable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int index = ristotable.getSelectedRow();
				JOptionPane.showMessageDialog(null,index);
			}
		}); */
		scrollPane.setViewportView(ristotable);
		ristotable.setFillsViewportHeight(true);
		ristotable.setColumnSelectionAllowed(true);
		ristotable.setEnabled(false);
		ristotable.setBackground(new Color(245, 245, 220));
		ristotable.setRowHeight(50);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/restaurant_alponte_scritta-300x133.png")));
		label_1.setBounds(12, 0, 316, 95);
		ristopanel.add(label_1);
		
		inseriscijb = new JButton("Inserisci");
		inseriscijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.apriInserisci();
			}
		});
		inseriscijb.setBounds(639, 47, 97, 25);
		ristopanel.add(inseriscijb);
		
		aggiungijb = new JButton("Aggiungi");
		aggiungijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		aggiungijb.setBounds(489, 48, 89, 23);
		ristopanel.add(aggiungijb);
		
		
		//PANEL ALLOGGIO
		JPanel alloggipanel = new JPanel();
		alloggipanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(alloggipanel, "name_276128323411800");
		alloggipanel.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(120, 78, 598, 426);
		alloggipanel.add(scrollPane2);
	
		//TABELLA ALLOGGIO
		alloggiotable = new JTable(adao.getAlloggio());
		scrollPane2.setViewportView(alloggiotable);
		alloggiotable.setFillsViewportHeight(true);
		alloggiotable.setColumnSelectionAllowed(true);
		alloggiotable.setEnabled(false);
		alloggiotable.setBackground(new Color(245, 245, 245));
		alloggiotable.setRowHeight(50);

		
		//PANEL ATTRAZIONE
		JPanel attrazionepanel = new JPanel();
		attrazionepanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(attrazionepanel, "name_276141316664400");
		attrazionepanel.setLayout(null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(120, 78, 598, 426);
		attrazionepanel.add(scrollPane3);
	
		//TABELLA ATTRAZIONE
		attrazionetable = new JTable(tdao.getAttrazione());
		scrollPane3.setViewportView(attrazionetable);
		attrazionetable.setFillsViewportHeight(true);
		attrazionetable.setColumnSelectionAllowed(true);
		attrazionetable.setEnabled(false);
		attrazionetable.setBackground(new Color(245, 245, 245));
		attrazionetable.setRowHeight(50);		
		
		
		//PANEL RISTORANTE MODERATORE
		JPanel modristopanel = new JPanel();
		modristopanel.setBackground(Color.WHITE);
		layeredPane.add(modristopanel, "name_1447936606331700");
		modristopanel.setLayout(null);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(120, 78, 598, 426);
		modristopanel.add(scrollPane4);
	
		//TABELLA MODERATORE
		modristotable = new JTable(recDAO.getRistoNonApprovate());
		scrollPane4.setViewportView(modristotable);
		modristotable.setFillsViewportHeight(true);
		modristotable.setColumnSelectionAllowed(true);
		modristotable.setEnabled(false);
		modristotable.setBackground(new Color(245, 245, 245));
		modristotable.setRowHeight(50);
		
		
		
		//BOTTONE RISTORANTE
		JButton ristojb = new JButton("Ristorante");
		ristojb.setBounds(0, 204, 244, 43);
		ristojb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.switchPanel(layeredPane,ristopanel);
				if(ctr.main.getUtenteCorrente().getTipo().equals("moderatore")) 
					ctr.switchPanel(layeredPane, modristopanel);
				else if(ctr.main.getUtenteCorrente().getTipo().equals("admin")){
					ctr.main.getAggiungiButton().setVisible(true);
					ctr.main.getInserisciButton().setVisible(false);
				}
				else if(ctr.main.getUtenteCorrente().getTipo().equals("base")){
					ctr.main.getAggiungiButton().setVisible(false);
					ctr.main.getInserisciButton().setVisible(true);
				}
				else {
					ctr.main.getAggiungiButton().setVisible(false);
					ctr.main.getInserisciButton().setVisible(false);
				}
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
				ctr.switchPanel(layeredPane,alloggipanel);
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
				ctr.switchPanel(layeredPane,attrazionepanel);
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
	}

	public Utente getUtenteCorrente() {
		return UtenteCorrente;
	}

	public void setUtenteCorrente(Utente utenteCorrente) {
		UtenteCorrente = utenteCorrente;
	}
	
	public void setUtenteLabel() {
		this.getUtenteLabel().setText("Benvenuto "+this.getUtenteCorrente().getUsername()+"!");
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
	public JButton getInserisciButton() {
		return inseriscijb;
	}
	public JButton getAggiungiButton() {
		return aggiungijb;
	}
}
