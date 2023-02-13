package Productos;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ventana extends JPanel {

	public static EditarPanel editar = new EditarPanel();
	public static lista lista = new lista();
	
	public ventana() {
		this.setBounds(0, 0, 500, 350);
		this.setLayout(new BorderLayout());
		this.add(editar,BorderLayout.NORTH);
		this.add(lista,BorderLayout.CENTER);
	}

}
