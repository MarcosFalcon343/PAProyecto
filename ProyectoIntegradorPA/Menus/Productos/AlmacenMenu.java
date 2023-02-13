package Productos;

import java.util.ArrayList;

import Clases.Almacen;
import Clases.Producto;
import Libreria.Libreria;
import Listas.LAlmacen;
import Listas.LProductos;

public class AlmacenMenu {
	private static String[] main = {"MENU ALMACEN\n","1.-VER MOVIMIENTOS","2.-AGREGAR","3.-SALIDA"};
	private static LAlmacen lista;
	private static ArrayList<Producto> listado;
	
	public AlmacenMenu() {
		lista = new LAlmacen("almacen.txt");
	}
	
	public void AlmacenMain(ArrayList lista) {
		this.listado = lista;
		String op = "0";
		try {
			do {
				op = Libreria.leerDato(Libreria.mostrarMenu(main));
				
				switch(op) {
				case "1":
					listado();
					break;
				case "2":
					agregar();
					break;
				default:
					System.out.println("SALIDA DE PRODUCTOS");
					break;
				}
			}while(op.compareTo("3")!=0);
			
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	
	private static void listado() {
		System.out.println("MOVIMIENTOS");
		lista.mostrar();
	}
	
	private static void agregar() {
		String id,cantidad,saldoA,saldoN;
		Producto producto;
		try {
			mostrarInventario();
			id = Libreria.leerDato("\nINGRESE EL ID DEL PRODUCTO A AGREGAR MERCANCIA");
			LProductos productos = new LProductos("productos.txt");
			if(productos.existe(id) != -1) {
				producto = productos.obtener(id);
				saldoA = producto.getCantidad();
				cantidad = Libreria.leerDato("INGRESE LA CANTIDAD A AGREGAR DEL PRODUCTO");
				if(productos.addCantidad(id, cantidad)) {
					saldoN = String.valueOf(Integer.parseInt(saldoA) + Integer.parseInt(cantidad));
					Almacen alm = new Almacen(Libreria.Fecha(),producto.getIdProducto(), producto.getNombre(), cantidad, "ALTA", saldoA, saldoN);
					lista.insertar(alm);
				}
			}
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private static void mostrarInventario() {
		System.out.println("PRODUCTOS");
		for(Producto nodo: listado) {
			System.out.println(nodo);
		}
		System.out.println("\n");
	}
	
}
