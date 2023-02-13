package PuntoVenta;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class VTicket extends JFrame {

	public vista vista;
	public editar editar;
	
	public VTicket(String id,String Fecha) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VTicket.class.getResource("/Assets/img/tienda-de-comestibles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 700, 450);
		getContentPane().setLayout(new GridLayout(2,1));
		this.vista = new vista(id, Fecha);
		this.editar = new editar();
		getContentPane().add(vista);
		getContentPane().add(editar);
	}

}
