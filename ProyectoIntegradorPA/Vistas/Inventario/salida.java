package Inventario;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class salida extends JPanel {

	public  JButton salir;
	
	public salida() {
		this.setBounds(0,0,600,50);
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		salir = new JButton("Cerrar");
		this.salir.setPreferredSize(new Dimension(100,30));
		this.add(salir);
	}

}
