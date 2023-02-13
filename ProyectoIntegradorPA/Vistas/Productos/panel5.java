package Productos;

import javax.swing.JButton;
import javax.swing.JPanel;

public class panel5 extends JPanel {

	public static JButton baja = new JButton("Baja");
	public static JButton modificar = new JButton("Modificar");
	
	public panel5() {
		this.add(baja);
		this.add(modificar);
	}

}
