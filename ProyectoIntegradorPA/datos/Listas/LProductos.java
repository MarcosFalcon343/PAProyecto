package Listas;

import java.util.ArrayList;
import Clases.Lista;
import Clases.Producto;
import Libreria.Libreria;

public class LProductos extends Lista{

	public LProductos(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void insertar(String nombre, String precio,String cantidad){
		Producto producto;
		String idProducto;
		try {
			do {
				idProducto = sigID();
			}while(existe(idProducto) != -1);
			
			producto = new Producto(idProducto,nombre,precio,cantidad);
			this.agregar(producto);
			
		}catch(Exception e) {
			System.out.println("ERROR AL INSERTAR EL PRODUCTO" + e.getMessage());
		}
	}
	
	public int existe(String id) {
		int ck  = -1;
		int pos = 0;
		for(Object nodo: lista) {
			if(((Producto)nodo).getIdProducto().equals(id)) ck = pos;
			pos++;
		}
		return ck;
	}
	
	private String sigID() {
		String id = "-1";
		int ultimo = Integer.parseInt(((Producto)lista.get(lista.size()-1)).getIdProducto());
		id = Libreria.idFormat(String.valueOf(ultimo + 1));
		return String.valueOf(id);
	}
	
	public void mostrarT() {
		// TODO Auto-generated method stub
		this.leerArchivo();
		for(Object nodo: lista) {
			if(Integer.parseInt(((Producto)nodo).getCantidad()) > 0) System.out.println(((Producto)nodo).toString());
		}
		
	}
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		this.leerArchivo();
		String producto = Libreria.rellenarespacios("ID", 5) + " " +Libreria.rellenarespacios("NOMBRE", 60) + " " + Libreria.rellenarespacios("PRECIO", 6) + " " + Libreria.rellenarespacios("CANT", 4);
		System.out.println(producto);
		for(Object nodo: lista) {
			System.out.println(((Producto)nodo).toString());
		}
		
	}

	@Override
	public void eliminar(String id) {
		int i = 0;
		int pos = -1;
		for(Object nodo: lista) {
			if(((Producto)nodo).getIdProducto().equals(id)) pos = i;
			i++;
		}
		lista.remove(pos);
		this.escribirArchivo();
		this.leerArchivo();
	}


	public boolean actualizar(String id,String precio) {
		boolean c = false;
		try {
			if(existe(id) != 1) {
				((Producto)lista.get(existe(id))).setPrecio(precio);
				this.escribirArchivo();
				this.leerArchivo();
				return c = true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	public boolean actualizarC(String id,String cant) {
		boolean c = false;
		try {
			if(existe(id) != 1) {
				((Producto)lista.get(existe(id))).setCantidad(cant);
				this.escribirArchivo();
				this.leerArchivo();
				return c = true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	public Producto obtener(String id) {
		int i = 0;
		int pos = -1;
		this.leerArchivo();
		for(Object nodo: lista) {
			if(((Producto)nodo).getIdProducto().equals(id)) pos = i;
			i++;
		}
		if(pos != -1) return (Producto) lista.get(pos);
		else return null;
	}
	
	public ArrayList<Object> getListado() {
		this.leerArchivo();
		return this.lista;
	}
	
	public boolean addCantidad(String id,String cantidad) {
		boolean ck = false;
		for(Object nodo: lista) {
			if(((Producto)nodo).getIdProducto().equals(id)) {
				((Producto)nodo).addCantidad(Integer.parseInt(cantidad));
				ck = true;
			}

		}
		
		this.escribirArchivo();
		this.leerArchivo();
		return ck;
	}

		
		

}
