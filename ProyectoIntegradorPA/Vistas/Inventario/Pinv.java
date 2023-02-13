package Inventario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Clases.Producto;

public class Pinv extends JPanel {

	public LProductos lista;
	public titulo titulo;
	public salida sal;

	
	public Pinv() {
		this.setLayout(new BorderLayout());
		this.setBounds(0,0,600,400);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.lista = new LProductos();
		this.titulo = new titulo();
		this.sal = new salida();
		
		this.add(titulo,BorderLayout.NORTH);
		this.add(lista,BorderLayout.CENTER);
		this.add(sal,BorderLayout.SOUTH);

		
	}
	

}
