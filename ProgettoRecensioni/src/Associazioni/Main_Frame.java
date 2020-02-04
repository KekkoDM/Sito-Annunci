package Associazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
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

public class Main_Frame extends JFrame {

	private JPanel main_panel;
    ristoranteDAO rdao = new ristoranteDAO();
    AlloggioDAO adao = new AlloggioDAO();
    AttrazioneDAO tdao = new AttrazioneDAO();
	private JTable ristotable;
	private JTable alloggiotable;
	private JTable attrazionetable;
	
	public Main_Frame(Controller ctr) {
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
		
		JLabel Usertext = new JLabel("");
		Usertext.setForeground(new Color(0, 0, 0));
		Usertext.setBounds(27, 190, 169, 36);
		homepanel.add(Usertext);
		
		JButton accedijb = new JButton("Accedi\r\n");
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
		testo_home.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 15));
		testo_home.setText("Benvenuto in RevHub, il programma #1 di recensioni in Italia!\r\nPrima di iniziare, clicca sul bottone accedi se hai gi\u00E0 un account RevHub.");
		testo_home.setBounds(26, 121, 501, 46);
		homepanel.add(testo_home);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/capri.jpg")));
		label.setBounds(0, 278, 823, 296);
		homepanel.add(label);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setForeground(new Color(255, 255, 255));
		btnEsci.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		btnEsci.setBackground(new Color(46, 139, 87));
		btnEsci.setBounds(614, 119, 129, 35);
		homepanel.add(btnEsci);
		
		JPanel ristopanel = new JPanel();
		ristopanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(ristopanel, "name_276109691756800");
		ristopanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 78, 598, 426);
		ristopanel.add(scrollPane);
	
		//TABELLA RISTORANTE
		ristotable = new JTable(rdao.getRistoranti());
		scrollPane.setViewportView(ristotable);
		ristotable.setFillsViewportHeight(true);
		ristotable.setColumnSelectionAllowed(true);
		ristotable.setEnabled(false);
		ristotable.setBackground(new Color(245, 245, 245));
		ristotable.setRowHeight(50);
		
		
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

		
		//BOTTONE RISTORANTE
		JButton ristojb = new JButton("Ristorante");
		ristojb.setBounds(0, 204, 244, 43);
		ristojb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.switchPanel(layeredPane,ristopanel);
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
}
