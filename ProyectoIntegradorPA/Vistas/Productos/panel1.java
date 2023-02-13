package Productos;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panel1 extends JPanel {

	public static JLabel Lid = new JLabel("ID");
	public static JTextField Id = new JTextField();
	public final JLabel LNombre = new JLabel("Nombre");
	public final JTextField nombre = new JTextField();
	public final JLabel LPrecio = new JLabel("Precio");
	public final JTextField precio = new JTextField();
	public final JButton buscar = new JButton("Buscar");
	
	public panel1() {
		this.setBounds(0, 0, 600, 50);
		
		this.nombre.setColumns(25);
		this.nombre.setEnabled(false);
		this.precio.setColumns(10);
		this.Id.setColumns(5);
		
		this.add(Lid);
		this.add(Id);
		this.add(LNombre);
		this.add(nombre);
		this.add(LPrecio);
		this.add(precio);	
		this.add(buscar);
	}

}
