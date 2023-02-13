package PuntoVenta;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class vista extends JPanel {

	public title titulo;
	public productosTicket lista;
	public totales totals;
	public vista(String id,String fec) {
		this.setBounds(0, 0, 600, 300);
		this.setLayout(new BorderLayout());
		this.titulo = new title(id,fec);
		this.lista = new productosTicket();
		this.totals = new totales();
		
		this.add(titulo,BorderLayout.NORTH);
		this.add(lista,BorderLayout.CENTER);
		this.add(totals,BorderLayout.EAST);
	}
}
