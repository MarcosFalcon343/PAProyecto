package Productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class productos extends JFrame {

	public EditarPanel editar = new EditarPanel();
	public lista lista = new lista();

	
	public productos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Assets/img/bolsa-de-la-compra.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Productos");
		this.setBounds(0, 0, 700, 350);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(editar,BorderLayout.NORTH);
		getContentPane().add(lista,BorderLayout.CENTER);
		
	}

}
