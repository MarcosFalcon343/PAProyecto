package Listas;

import java.util.ArrayList;

import Clases.Almacen;
import Clases.Lista;
import Clases.Producto;
import Clases.Venta;
import Libreria.Libreria;

public class LVenta extends Lista{

	private ArrayList<String> fechas = new ArrayList<String>();
	private ArrayList<String> idProductos = new ArrayList<String>();
	
	public LVenta(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void insertar(Venta venta) {
		Venta sell = venta;
		
		LProductos productos = new LProductos("productos.txt");
		Producto producto = productos.obtener(sell.getIdProducto());
		
		String sN = String.valueOf(Integer.parseInt(producto.getCantidad()) - Integer.parseInt(sell.getCantidad()));
		
		Almacen alm = new Almacen(sell.getFecha(),producto.getIdProducto(),producto.getNombre(),sell.getCantidad(),"BAJA",producto.getCantidad(),sN);
		LAlmacen Lalm = new LAlmacen("almacen.txt");
		Lalm.insertar(alm);
		System.out.println(producto.getIdProducto()+" "+ sN);
		productos.actualizarC(producto.getIdProducto(), sN);
		
		this.agregar(sell);
	}
	
	public String sigID() {
		String id = "1";
		if(lista.size() > 0) {
			int ultimo = Integer.parseInt(((Venta)lista.get(lista.size()-1)).getIdTicket());
			id = Libreria.idFormat(String.valueOf(ultimo + 1));
		}else  id = "1";
		return String.valueOf(id);
	}
	
	private int existe(String dato,int tipo) {
		int ck  = -1;
		int pos = 0;
		switch(tipo) {
		case 1:
			for(Object nodo: fechas) {
				if(nodo.equals(dato)) ck = pos;
				pos++;
			}
			break;
		case 2:
			for(Object nodo: idProductos) {
				if(nodo.equals(dato))ck = pos;
				pos++;
			}
			break;
		}
		return ck;
	}
	
	
	public void mostrarDia(String Fecha) {
		// TODO Auto-generated method stub
		for(Object nodo: lista) {
			if(((Venta)nodo).getFecha().equals(Fecha)) System.out.println(nodo);
		}
		
	}

	public void mostrarF() {
		int pos = 0;
		for(String nodo: fechas) {
			System.out.println((pos + 1) + "  " + nodo);
		}
	}
	
	public void mostrarP() {
		int cantidad = 0;
		LProductos productos = new LProductos("productos.txt");
		ArrayList<Producto> Lproductos = new ArrayList<Producto>();
		
		for(String nodo: idProductos) {
			cantidad = 0;
			for(Object aux: lista)	if(((Venta)aux).getIdProducto().equals(nodo)) cantidad += Integer.parseInt(((Venta)aux).getCantidad());
			
			Producto producto = productos.obtener(nodo);
			producto.setCantidad(String.valueOf(cantidad));
			Lproductos.add(producto);
		}
		
		for(Producto nodo: Lproductos) {
			double subtotal = Double.parseDouble(nodo.getPrecio()) * Double.parseDouble(nodo.getCantidad());
			double iva = (Double.parseDouble(nodo.getPrecio()) * 0.16) * Double.parseDouble(nodo.getCantidad());
			double total = subtotal + iva;
			 System.out.println(nodo + Libreria.rellenarespacios(String.valueOf(subtotal), 6) + Libreria.rellenarespacios(String.valueOf(iva), 6) + Libreria.rellenarespacios(String.valueOf(total), 6));
		}
		

	}
	
	public String getFecha(int pos) {
		return fechas.get(pos);
	}
	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		System.out.println("O_o No se pueden borrar ventas. Con que haciendo fraudes 7-7");
	}
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		for(Object nodo: lista) {
			if(existe(((Venta)nodo).getFecha(), 1) == -1) fechas.add(((Venta)nodo).getFecha());
			if(existe(((Venta)nodo).getIdProducto(), 2) == -1) idProductos.add(((Venta)nodo).getIdProducto());
		}
		
	}
}
