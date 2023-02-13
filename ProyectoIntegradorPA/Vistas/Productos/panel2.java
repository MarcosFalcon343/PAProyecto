package Productos;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panel2 extends JPanel {

	public JLabel LNombre = new JLabel("Nombre");
	public JTextField Nombre = new JTextField();
	public JLabel LPrecio = new JLabel("Precio");
	public JTextField Precio = new JTextField();
	public JLabel Lcantidad = new JLabel("Cantidad");
	public JTextField cantidad = new JTextField();
	public JButton alta = new JButton("Alta");
	
	public panel2() {
		this.setBounds(0, 0, 600, 50);
		//this.setLayout(new FlowLayout());
		this.Nombre.setColumns(20);
		this.Precio.setColumns(10);
		this.cantidad.setColumns(5);
		
		this.add(LNombre);
		this.add(Nombre);
		this.add(LPrecio);
		this.add(Precio);
		this.add(Lcantidad);
		this.add(cantidad);
		this.add(alta);
		
	}

}
