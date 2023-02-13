package Productos;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel3 extends JPanel {

	JLabel Id = new JLabel("ID");
	JLabel Nombre = new JLabel("Nombre");
	JLabel Precio = new JLabel("Precio");
	JLabel Cantidad = new JLabel("Cantidad");
	
	
	public panel3() {
		this.setBounds(0, 0, 600, 50);
		this.add(Id);
		this.add(Nombre);
		this.add(Precio);
		this.add(Cantidad);
	}

}
