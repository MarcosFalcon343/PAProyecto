package PuntoVenta;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class total extends JPanel {

	public JLabel LTotal;
	public JTextField total;
	
	public total() {
		this.setBounds(0,0,100,80);
		this.setLayout(getLayout());
		//this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());
		this.LTotal = new JLabel("Total");
		LTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.total = new JTextField();
		total.setEnabled(false);
		total.setFont(new Font("Tahoma", Font.PLAIN, 19));
		this.total.setColumns(5);
		this.total.setBounds(0, 0, 100, 100);
		this.add(LTotal,BorderLayout.NORTH);
		this.add(total,BorderLayout.CENTER);
	}

}
