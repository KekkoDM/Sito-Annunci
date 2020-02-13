package Associazioni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Inserisci_recensione extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private ristoranteDAO rdao = new ristoranteDAO();

	public Inserisci_recensione(Controller ctr) {
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("INSERISCI RECENSIONE");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 20));
			comboBox.setBounds(28, 71, 146, 26);
			contentPanel.add(comboBox);
		}
		{
			JLabel lblValutaQuesto = new JLabel("Valuta questo ristorante");
			lblValutaQuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblValutaQuesto.setBounds(15, 16, 429, 22);
			lblValutaQuesto.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 20));
			contentPanel.add(lblValutaQuesto);
		}
		
		textField = new JTextField();
		textField.setBounds(25, 113, 404, 92);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancella");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					     textField.setText("");	
					}
				});
				cancelButton.setActionCommand("");
				buttonPane.add(cancelButton);
			}
		}
	}
}
