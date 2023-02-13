package PuntoVenta;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class entradas extends JPanel {

	public JLabel Lid;
	public JLabel Lnombre;
	public JLabel Lprecio;
	
	public JTextField id;
	public JTextField nombre;
	public JTextField precio;
	public entradas() {
		this.setBounds(0, 0, 600, 40);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.Lid = new JLabel("ID:");
		this.Lnombre = new JLabel("Nombre:");
		this.Lprecio = new JLabel("Precio:");
		this.id = new JTextField();
		this.nombre = new JTextField();
		nombre.setEnabled(false);
		this.precio = new JTextField();
		precio.setEnabled(false);
		this.id.setColumns(6);
		this.nombre.setColumns(30);
		this.precio.setColumns(6);
		
		this.add(Lid);
		this.add(id);
		this.add(Lnombre);
		this.add(nombre);
		this.add(Lprecio);
		this.add(precio);
	}

}
