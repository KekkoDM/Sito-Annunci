package Associazioni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class Recensioni_Frame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox ristocombo;
	private ristoranteDAO rdao= new ristoranteDAO();
    private RecensioneDAO recdao = new RecensioneDAO();
	
    public Recensioni_Frame(Controller ctr, String from) {
		
		setBounds(100, 100, 672, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		ristocombo = new JComboBox();
		ristocombo.setBounds(12, 27, 180, 20);
		contentPanel.add(ristocombo);
		this.updateComboBox(from);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 149, 656, 249);
		contentPanel.add(scrollPane);
	
		//TABELLA RECENSIONI
		JTable rectable = new JTable();
		rectable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titolo", "Testo", "Valutazione", "Data" ,"Utente"
			}
		));
		
		scrollPane.setViewportView(rectable);
		rectable.setFillsViewportHeight(true);
		rectable.setColumnSelectionAllowed(true);
		rectable.setEnabled(false);
		rectable.setBackground(new Color(245, 245, 220));
		rectable.setRowHeight(50);	
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String luogo=(ristocombo.getSelectedItem().toString());
						ArrayList<Recensione> lista = new ArrayList<Recensione>();
						
						DefaultTableModel model = (DefaultTableModel) rectable.getModel();
						model.setRowCount(0);
						
						if(from.equals("ristorante")) {
							lista = recdao.getRecensioniRistorante(luogo);
							populateJTableRece(lista,rectable);
						}else if(from.equals("alloggio")) {
							lista = recdao.getRecensioniAlloggio(luogo);
							populateJTableRece(lista,rectable);
						}else {
							lista = recdao.getRecensioniAttrazione(luogo);
							populateJTableRece(lista,rectable);
						}
						
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) rectable.getModel();
						model.setRowCount(0);
						
					}
				});
			}
		}
	}
	
	
	
	public void updateComboBox(String from) {
		Connessione c = new Connessione();
		c.ConnessioneDB();
		try {
			ResultSet rs= c.Query("*",from," ");
			while(rs.next()) {
				this.getComboBox().addItem(rs.getString("nome"));
			}
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	
	public void populateJTableRece(ArrayList<Recensione> list,JTable modrecetable) {
		DefaultTableModel model = (DefaultTableModel) modrecetable.getModel();
		Object[] riga = new Object[5];
		for(int i=0;i<list.size();i++) {
			riga[0] = list.get(i).getTitolo();
			riga[1] = list.get(i).getTesto();
			riga[2] = list.get(i).getValutazione();
			riga[3] = list.get(i).getData();
			riga[4] = list.get(i).getCodU();
			model.addRow(riga);
		}
	}
	
	public JComboBox getComboBox() {
		return ristocombo;
	}
}
