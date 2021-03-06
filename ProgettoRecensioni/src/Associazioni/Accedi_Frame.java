package Associazioni;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Accedi_Frame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passtext;
	private JTextField usertext;
	private UtentiDAO udao = new UtentiDAO();

	public Accedi_Frame(Controller ctr) {
		setTitle("Schermata di accesso");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAccedi = new JLabel("Accedi");
			lblAccedi.setBounds(169, 11, 106, 53);
			lblAccedi.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 31));
			contentPanel.add(lblAccedi);
		}
		
		JLabel esitotext = new JLabel();
		esitotext.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		esitotext.setForeground(Color.RED);
		esitotext.setBounds(94, 178, 256, 23);
		contentPanel.add(esitotext);
		
		passtext = new JPasswordField();
		passtext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passtext.setBounds(169, 134, 196, 26);
		contentPanel.add(passtext);
		
		usertext = new JTextField();
		usertext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usertext.setBounds(169, 85, 196, 26);
		contentPanel.add(usertext);
		usertext.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(95, 91, 137, 14);
		lblUsername.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 15));
		contentPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(95, 140, 137, 14);
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		contentPanel.add(lblPassword);
		
		JButton accedijb = new JButton("Accedi");
		accedijb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usertext.getText();
				String password = passtext.getText();
				Utente user = new Utente();
				user = udao.checkUtente(username, password);
				if(user.getUsername().equals(" ")){
					esitotext.setText("Username e Password errati!");
				}
				else {
					ctr.chiudiAccedi();
					ctr.setUtenteCorrente(user);
					ctr.main.setUtenteLabel(ctr);
				}
			}
		});
		accedijb.setForeground(new Color(255, 255, 255));
		accedijb.setBackground(new Color(46, 139, 87));
		accedijb.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		accedijb.setBounds(153, 217, 140, 30);
		contentPanel.add(accedijb);
	}
}
