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
	private String[] column_headers= {"Ristorante","Ultima Recensione","Valutazione","Tag"};
	private String[][] rows = {{"Pizzalò","Un posto bla bla bla, bla bla bla , consiglio bla bla bla","****","Pizzeria"}};
	private JTable ristotable;

	/**
	 * Create the frame.
	 */
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
		
		JButton accedijb = new JButton("Accedi\r\n");
		accedijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ctr.goAccedi(ctr.main);
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
		testo_home.setBounds(26, 121, 717, 129);
		homepanel.add(testo_home);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/capri.jpg")));
		lblNewLabel_1.setBounds(0, 278, 823, 296);
		homepanel.add(lblNewLabel_1);
		

		
		JPanel ristopanel = new JPanel();
		ristopanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(ristopanel, "name_276109691756800");
		ristopanel.setLayout(null);
		
		//TABELLA RISTORANTE
		ristotable = new JTable(rows,column_headers);
		ristotable.setBackground(new Color(245, 245, 245));
		ristotable.setBounds(120, 129, 598, 375);
		ristopanel.add(ristotable);
		
		JPanel alloggipanel = new JPanel();
		alloggipanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(alloggipanel, "name_276128323411800");
		
		JLabel lblAaaaaaa = new JLabel("Aaaaaaa");
		alloggipanel.add(lblAaaaaaa);
		
		JPanel attrazionipanel = new JPanel();
		attrazionipanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(attrazionipanel, "name_276141316664400");
		
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
				ctr.switchPanel(layeredPane,attrazionipanel);
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
