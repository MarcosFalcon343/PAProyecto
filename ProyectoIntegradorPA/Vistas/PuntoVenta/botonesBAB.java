package PuntoVenta;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class botonesBAB extends JPanel {

	public JButton BtnBuscar;
	public JButton BtnAlta;
	public JButton BtnBaja;
	
	public botonesBAB() {
		this.setBounds(0, 0, 600, 50);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new FlowLayout(FlowLayout.CENTER,50,5));
		
		this.BtnBuscar = new JButton("Buscar");
		this.BtnAlta = new JButton("Alta");
		this.BtnBaja = new JButton("Baja");
		
		this.BtnAlta.setPreferredSize(new Dimension(100,30));
		this.BtnBaja.setPreferredSize(new Dimension(100,30));
		this.BtnBuscar.setPreferredSize(new Dimension(100,30));
		this.add(BtnBuscar);
		this.add(BtnAlta);
		this.add(BtnBaja);
	}

}
