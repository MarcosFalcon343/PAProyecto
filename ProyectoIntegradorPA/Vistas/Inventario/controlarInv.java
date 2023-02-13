package Inventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Listas.LProductos;

public class controlarInv implements ActionListener{
	
	private LProductos productos = new LProductos("productos.txt");
	private ArrayList lista = new ArrayList();
	private inventario inv;
	
	public controlarInv() {
		inv = new inventario();
		lista = productos.getListado();
		this.inv.inv.lista.mostrar(lista);
		this.inv.setVisible(true);
		this.inv.inv.sal.salir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.inv.inv.sal.salir) this.inv.dispose();
		
	}
	
	
}
