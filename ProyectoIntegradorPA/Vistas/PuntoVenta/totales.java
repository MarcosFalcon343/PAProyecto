package PuntoVenta;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class totales extends JPanel {

	public total total = new total();
	public subiva si = new subiva();
	
	public totales() {
		this.setBounds(0, 0, 100, 200);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(2,1));
		
		this.add(si);
		this.add(total);
		
	}

}
