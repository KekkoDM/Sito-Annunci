package Associazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Frame extends JFrame {

	private JPanel main_panel;
	private Controller ctr = new Controller();
	

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
		layeredPane.setBounds(244, -39, 823, 640);
		main_panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel homepanel = new JPanel();
		homepanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(homepanel, "name_276067671491600");
		homepanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 75));
		lblNewLabel.setBounds(305, 225, 204, 99);
		homepanel.add(lblNewLabel);
		
		JPanel ristopanel = new JPanel();
		ristopanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(ristopanel, "name_276109691756800");
		ristopanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SESSO ANALE\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 88));
		lblNewLabel_1.setBounds(180, 212, 544, 177);
		ristopanel.add(lblNewLabel_1);
		
		JPanel alloggipanel = new JPanel();
		layeredPane.add(alloggipanel, "name_276128323411800");
		
		JPanel attrazionipanel = new JPanel();
		layeredPane.add(attrazionipanel, "name_276141316664400");
		
		JButton ristojb = new JButton("Ristorante");
		ristojb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.switchPanel(layeredPane,ristopanel);
			}
		});
		ristojb.setForeground(new Color(255, 255, 255));
		ristojb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		ristojb.setBackground(new Color(102, 204, 0));
		ristojb.setBounds(0, 177, 245, 43);
		main_panel.add(ristojb);
		
		JButton alloggijb = new JButton("Alloggi\r\n");
		alloggijb.setBackground(new Color(102, 204, 51));
		alloggijb.setForeground(new Color(255, 255, 255));
		alloggijb.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 23));
		alloggijb.setBounds(0, 231, 245, 43);
		main_panel.add(alloggijb);
		
		JButton homejb = new JButton("Home\r\n");
		homejb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctr.switchPanel(layeredPane,homepanel);
			}
		});
		homejb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		homejb.setForeground(new Color(255, 255, 255));
		homejb.setBackground(new Color(102, 204, 0));
		homejb.setBounds(0, 123, 244, 43);
		main_panel.add(homejb);
		
		JLabel lblRevhub = new JLabel("RevHub");
		lblRevhub.setForeground(new Color(255, 255, 255));
		lblRevhub.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 33));
		lblRevhub.setBounds(64, 11, 130, 71);
		main_panel.add(lblRevhub);
	}
}
