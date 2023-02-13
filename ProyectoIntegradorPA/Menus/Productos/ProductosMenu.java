package Productos;
import java.util.ArrayList;

import Libreria.Libreria;
import Listas.LProductos;

public class ProductosMenu {

	private static String[] main = {"MENU PRODUCTOS\n","1.-ALTA","2.-BAJAS","3.-MODIFICAR","4.-LISTADO","5.-SALIDA"};
	private static LProductos listado;
	
	public ProductosMenu() {
		listado = new LProductos("productos.txt");
	}
	
	public void ProductosMain() {
		String op = "0";
		try {
			do {
				op = Libreria.leerDato(Libreria.mostrarMenu(main));
				
				switch(op) {
				case "1":
					insertar();
					break;
				case "2":
					eliminar();
					break;
				case "3":
					actualizar();
					break;
				case "4":
					listado();
					break;
				default:
					System.out.println("SALIDA DE PRODUCTOS");
					break;
				}
			}while(op.compareTo("5")!=0);
			
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private static void insertar() {
		String nombre,precio,cantidad;
		try {
			System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
			nombre = Libreria.leerDato();
			System.out.println("INGRESE EL PRECIO DEL PRODUCTO");
			precio = Libreria.leerDato();
			System.out.println("INGRESE LA CANTIDAD DE PRODUCTO");
			cantidad = Libreria.leerDato();
			
			if(Libreria.evaluarNumerico(precio, 2)  || Libreria.evaluarNumerico(cantidad, 1))	listado.insertar(nombre, precio, cantidad);
			else System.out.println("ERROR AL INGRESAR LOS DATOS");
			
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private static void eliminar() {
		String id;
		try {
			listado();
			id = Libreria.leerDato("INGRESE EL ID CORRESPONDIENTE AL PRODUCTO A ELIMINAR");
			listado.eliminar(id);
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private static void actualizar() {
		String idProducto, precio;
		try {
			listado();
			idProducto =Libreria.leerDato("INGRESE EL ID CORRESPONDIENTE AL PRODUCTO A MODIFICAR");
			precio = Libreria.leerDato("INGRESE EL NUEVO PRECIO");
			if(Libreria.evaluarNumerico(precio, 1))	if(!listado.actualizar(idProducto, precio)) System.out.println("EL PRODUCTO NO EXISTE");
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}

	private static void listado() {
		System.out.println("PRODUCTOS");
		listado.mostrar();
	}
	
	public ArrayList<Object> getListado() {
		return listado.getListado();
	}
}
