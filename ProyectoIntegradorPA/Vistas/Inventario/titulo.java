package Inventario;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class titulo extends JPanel {

	private JLabel titulo;
	
	public titulo() {
		this.setLayout(new FlowLayout());
		this.setBounds(0,0,600,30);
		titulo = new JLabel("Inventario");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(titulo);
	}

}
