import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Listas.LProductos;
import Productos.productos;
import easterEgg.egg;
import Clases.Producto;

public class Productoslistado implements ActionListener{

	LProductos productos = new LProductos("productos.txt");
	ArrayList lista = new ArrayList();
	productos panel = new productos();
	public Productoslistado() {
		lista = productos.getListado();
		panel = new productos();
		mostrarProductos();
		panel.setVisible(true);
		panel.editar.panel2.alta.addActionListener(this);
		panel.editar.panel5.baja.addActionListener(this);
		panel.editar.panel1.buscar.addActionListener(this);
		panel.editar.panel5.modificar.addActionListener(this);
	}
	
	
	public void mostrarProductos() {
		lista = productos.getListado();
		panel.lista.panel2.Lista.setText("");
		for(Object e: lista) {
			panel.lista.panel2.agregarProducto(((Producto)e).toString()+"\n");
		}
	}
	
	public void agregarProducto() {
		String nombre = panel.editar.panel2.Nombre.getText();
		String precio = panel.editar.panel2.Precio.getText();
		String cantidad = panel.editar.panel2.cantidad.getText();
		if(Libreria.Libreria.evaluarNumerico(precio, 2) && Libreria.Libreria.evaluarNumerico(cantidad, 1) && nombre.length() != 0) {
			this.productos.insertar(nombre, precio, cantidad);
			this.mostrarProductos();
			panel.editar.panel2.Nombre.setText("");
			panel.editar.panel2.Precio.setText("");
			panel.editar.panel2.cantidad.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "Error en algun campo");
		}
	}
	
	public void eliminar() {
		if(panel.editar.panel1.nombre.getText().length() != 0) {
			String id = panel.editar.panel1.Id.getText();
			this.productos.eliminar(id);
			this.mostrarProductos();
			panel.editar.panel1.Id.setText("");
			panel.editar.panel1.nombre.setText("");
			panel.editar.panel1.precio.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "No se ha buscado el producto");
		}
	}
	
	public void	buscarProductos() {
		Producto info = null;
		String id = this.panel.editar.panel1.Id.getText().trim();
		if(id.equals("dance")) {
			egg e = new egg(); 
			e.setVisible(true);
		}
		info = this.productos.obtener(id);
		if(info != null) {
			this.panel.editar.panel1.nombre.setText(info.getNombre());
			this.panel.editar.panel1.precio.setText(info.getPrecio());
		}else {
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	}
	
	public void actualizar() {
		if(panel.editar.panel1.nombre.getText().length() != 0) {
			String id = panel.editar.panel1.Id.getText();
			String precio = panel.editar.panel1.precio.getText();
			if(Libreria.Libreria.evaluarNumerico(precio, 2)) {
				this.productos.actualizar(id, precio);
				this.mostrarProductos();
				/*
				panel.editar.panel1.Id.setText("");
				panel.editar.panel1.nombre.setText("");
				panel.editar.panel1.precio.setText("");*/
			}else {
				JOptionPane.showMessageDialog(null, "Error en algun campo");
			}
		}else {
			JOptionPane.showMessageDialog(null, "No se ha buscado el producto");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == panel.editar.panel2.alta) this.agregarProducto();
		else if(e.getSource() == panel.editar.panel5.baja) this.eliminar();
		else if (e.getSource() == panel.editar.panel1.buscar) this.buscarProductos();
		else if(e.getSource() == panel.editar.panel5.modificar) this.actualizar();
	}

}
