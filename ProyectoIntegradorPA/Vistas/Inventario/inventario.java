package Inventario;

import java.util.ArrayList;

import javax.swing.JFrame;
import Listas.LProductos;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inventario extends JFrame {

	public Pinv inv = new Pinv();
	
	public inventario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(inventario.class.getResource("/Assets/img/inventario1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		this.setTitle("Inventario");
		getContentPane().add(inv);

	}

}
