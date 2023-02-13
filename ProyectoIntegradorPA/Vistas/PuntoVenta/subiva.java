package PuntoVenta;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class subiva extends JPanel {

	public JLabel Lsubtotal;
	public JLabel Liva;
	public JTextField subtotal;
	public JTextField iva;
	
	public subiva() {
		this.setBounds(0,0,100,100);
		this.setLayout(new GridLayout(4,1));
		this.Lsubtotal = new JLabel("Subtotal");
		this.Liva = new JLabel("IVA");
		this.subtotal = new JTextField();
		subtotal.setEnabled(false);
		this.iva = new JTextField();
		iva.setEnabled(false);
		this.subtotal.setColumns(6);
		this.iva.setColumns(6);
		
		this.add(Lsubtotal);
		this.add(subtotal);
		this.add(Liva);
		this.add(iva);
	}

}
