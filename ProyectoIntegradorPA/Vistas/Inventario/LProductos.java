package Inventario;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Clases.Producto;

public class LProductos extends JScrollPane {

	public JTextArea listado = new JTextArea();
	
	public LProductos() {
		this.setBounds(0, 0, 600, 300);
		listado.setEditable(false);
		listado.setToolTipText("");
		listado.setLineWrap(true);
		this.listado.setColumns(60);
		//this.Lista.setRows(10);
		setViewportView(listado);
	}
	
	public void mostrar(ArrayList lista) {
		for(Object e: lista) {
			String text = this.listado.getText();
			this.listado.setText(text + ((Producto)e).toString()+"\n");
		}
	}

}
