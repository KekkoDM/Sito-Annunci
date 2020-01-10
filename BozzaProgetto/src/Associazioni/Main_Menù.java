package Associazioni;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class Main_Menù extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Main_Menù(Controller ctr) {
		setTitle("RevHub 1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 522);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 815, 124);
		panel.setBackground(new Color(30, 144, 255));
		
		JLabel lblNewLabel = new JLabel("RevHub");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 37));
		
		//icona mail
		JLabel label = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/mail.png")).getImage();
		label.setIcon(new ImageIcon(img3));
		
		//bottone panino
		JButton button = new JButton("");
		button.setBounds(75, 264, 173, 170);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(245, 245, 245));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctr.goRisto(ctr);
				dispose();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/burger.png")).getImage();
		button.setIcon(new ImageIcon(img));
		
		//bottone hotel
		JButton button_1 = new JButton("");
		button_1.setBounds(313, 264, 173, 170);
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(245, 245, 245));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/hotel.png")).getImage();
		button_1.setIcon(new ImageIcon(img1));
		
		//bottone ombrellone
		JButton button_2 = new JButton("");
		button_2.setBounds(554, 264, 173, 170);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(245, 245, 245));
		Image img2 = new ImageIcon(this.getClass().getResource("/umbrella.png")).getImage();
		button_2.setIcon(new ImageIcon(img2));
		
		JLabel lblPerIniziareSeleziona = new JLabel("Per iniziare, seleziona una categoria!");
		lblPerIniziareSeleziona.setBounds(139, 165, 520, 47);
		lblPerIniziareSeleziona.setForeground(Color.DARK_GRAY);
		lblPerIniziareSeleziona.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		contentPane.setLayout(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(180)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(lblPerIniziareSeleziona);
	}
}
