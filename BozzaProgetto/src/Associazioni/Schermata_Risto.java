package Associazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Schermata_Risto extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table_1;
	String[] column_headers= {"Ristorante","Ultima Recensione","Valutazione","Tag"};
	String[][] rows = {{"Pizzalò","Un posto bla bla bla, bla bla bla , consiglio bla bla bla","****","Pizzeria"}};
	private JScrollPane scrollPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Schermata_Risto(Controller ctr) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(23, 550, 89, 23);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctr.goBack(ctr);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnIndietro);
		panel.setBounds(0, 0, 1027, 64);
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxPizzeria = new JCheckBox("Pizzeria");
		chckbxPizzeria.setBounds(337, 21, 97, 23);
		panel.add(chckbxPizzeria);
		
		JCheckBox chckbxBraceria = new JCheckBox("Braceria");
		chckbxBraceria.setBounds(461, 21, 97, 23);
		panel.add(chckbxBraceria);
		
		JCheckBox chckbxSushi = new JCheckBox("Sushi");
		chckbxSushi.setBounds(584, 21, 97, 23);
		panel.add(chckbxSushi);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Thailandese");
		chckbxNewCheckBox.setBounds(712, 21, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(105, 10, 89, 23);
		panel.add(btnCerca);
		
		JButton btnCerca_1 = new JButton("Cerca");
		btnCerca_1.setBounds(835, 21, 89, 23);
		panel.add(btnCerca_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(130, 105, 757, 398);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(rows,column_headers);
		table_1.setBackground(new Color(135, 206, 250));
		scrollPane.setViewportView(table_1);
		table_1.setEnabled(false);
	}
}
