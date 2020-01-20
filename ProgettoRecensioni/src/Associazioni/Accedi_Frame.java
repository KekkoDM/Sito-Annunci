package Associazioni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Accedi_Frame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public Accedi_Frame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAccedi = new JLabel("Accedi");
			lblAccedi.setBounds(164, 11, 106, 53);
			lblAccedi.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 31));
			contentPanel.add(lblAccedi);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 125, 137, 20);
		contentPanel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(193, 89, 137, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(109, 91, 137, 14);
		lblUsername.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 15));
		contentPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(109, 127, 137, 14);
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		contentPanel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Accedi");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		btnNewButton.setBounds(148, 186, 137, 23);
		contentPanel.add(btnNewButton);
		
		
	}
}
