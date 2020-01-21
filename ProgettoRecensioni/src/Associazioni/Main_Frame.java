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
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class Main_Frame extends JFrame {

	private JPanel main_panel;
	private Controller ctr = new Controller();
	private String[] column_headers= {"Ristorante","Ultima Recensione","Valutazione","Tag"};
	private String[][] rows = {{"Pizzalò","Un posto bla bla bla, bla bla bla , consiglio bla bla bla","****","Pizzeria"}};
	private JTable ristotable;
	ristoranteDAO rdao = new ristoranteDAO();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Main_Frame() {
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
		
		JLabel lblNewLabel = new JLabel("HOME\r\n");
		lblNewLabel.setBounds(305, 231, 204, 99);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 75));
		homepanel.add(lblNewLabel);
		
		JPanel ristopanel = new JPanel();
		ristopanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(ristopanel, "name_276109691756800");
		ristopanel.setLayout(null);
		
		
		//TABELLA RISTORANTE		
		ristotable = new JTable(rdao.getRistoranti());
		ristotable.setEnabled(false);
		ristotable.setBackground(new Color(245, 245, 245));
		ristotable.setBounds(82, 103, 679, 426);
		ristotable.setRowHeight(40);
        ristotable.setFont(new Font("Serif", Font.BOLD, 16));
        ristotable.setPreferredScrollableViewportSize(new Dimension(450,63));      
		ristopanel.add(ristotable);
		
		
		
		
		
		
		
		
		JPanel alloggipanel = new JPanel();
		layeredPane.add(alloggipanel, "name_276128323411800");
		
		JPanel attrazionipanel = new JPanel();
		layeredPane.add(attrazionipanel, "name_276141316664400");
		
		//BOTTONE RISTORANTE
		JButton ristojb = new JButton("Ristorante");
		ristojb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.switchPanel(layeredPane,ristopanel);
			}
		});
		ristojb.setForeground(new Color(255, 255, 255));
		ristojb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		ristojb.setBackground(new Color(46, 139, 87));
		ristojb.setBounds(0, 166, 244, 43);
		main_panel.add(ristojb);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		ristojb.setBorder(emptyBorder);
		
		JButton alloggijb = new JButton("Alloggi\r\n");
		alloggijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		alloggijb.setBackground(new Color(46, 139, 87));
		alloggijb.setForeground(new Color(255, 255, 255));
		alloggijb.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 23));
		alloggijb.setBounds(0, 207, 244, 43);
		main_panel.add(alloggijb);
		Border emptyBorder1 = BorderFactory.createEmptyBorder();
		alloggijb.setBorder(emptyBorder1);
		
		JButton homejb = new JButton("Home\r\n");
		homejb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctr.switchPanel(layeredPane,homepanel);
			}
		});
		homejb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		homejb.setForeground(new Color(255, 255, 255));
		homejb.setBackground(new Color(46, 139, 87));
		homejb.setBounds(0, 123, 244, 43);
		main_panel.add(homejb);
		Border emptyBorder2 = BorderFactory.createEmptyBorder();
		homejb.setBorder(emptyBorder2);
		
		JLabel lblRevhub = new JLabel("RevHub");
		lblRevhub.setForeground(new Color(255, 255, 255));
		lblRevhub.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 33));
		lblRevhub.setBounds(64, 11, 130, 71);
		main_panel.add(lblRevhub);
		
		
		JButton attrazionijb = new JButton("Attrazioni\r\n");
		attrazionijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		attrazionijb.setForeground(new Color(255, 255, 255));
		attrazionijb.setBackground(new Color(46, 139, 87));
		attrazionijb.setBounds(0, 249, 244, 43);
		main_panel.add(attrazionijb);
		Border emptyBorder3 = BorderFactory.createEmptyBorder();
		attrazionijb.setBorder(emptyBorder3);
		
	}
}
