package Ticket;

import java.util.ArrayList;

import Clases.Producto;
import Clases.Ticket;
import Clases.Venta;
import Libreria.Libreria;
import Listas.LProductos;
import Listas.LVenta;

public class PuntoVentaMenu {

	private static String[] main = {"1.-Alta","2.-Baja","3.-Inventario","4.-Pagar","5.-Cancelar venta"};
	private static LVenta venta;
	private static LProductos listado = new LProductos("productos.txt");
	private static Ticket ticket;
	
	public PuntoVentaMenu(ArrayList lista) {
		venta = new LVenta("ventas.txt");
		ticket = new Ticket(Libreria.idFormat(venta.sigID()),Libreria.Fecha());
	}

	public void PuntoVentaMain() {
		String op = "0";
		try {
			while(op.compareTo("5")!=0){
				System.out.println(ticket.ticket());
				op = Libreria.leerDato(Libreria.mostrarMenu(main));
				
				switch(op) {
				case "1":
					this.alta();
					break;
				case "2":
					this.baja();
					break;
				case "3":
					this.mostrarInventario();
					break;
				case "4":
					pagar();
				default:
					op = "5";
					System.out.println("SALIDA DE PRODUCTOS");
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	
	private void alta() {
		String id;
		Producto producto = null;
		try {
			this.mostrarInventario();
			id = Libreria.leerDato("INGRESE EL ID DEL PRODUCTO A INSERTAR");
			producto = this.obtener(id);
			ticket.insertar(producto);
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private void baja() {
		String id;
		try {
			if(ticket.size() > 0) {
				System.out.println(ticket.mostrarProductos());
				id = Libreria.leerDato("INGRESE EL ID DEL PRODUCTO A REMOVER");
				ticket.remover(id);
			}else System.out.println("NO HAY NINGUN PRODUCTO, AGREGUE UNO");;
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private void mostrarInventario() {
		System.out.println("PRODUCTOS");
		listado.mostrarT();
		System.out.println("\n");
	}
	
	private void pagar() {
		ArrayList<Producto> productos = ticket.getProductos();
		try {
			if(productos.size() >0) {
				for(Producto nodo: productos) {
					venta.insertar(new Venta(ticket.getFecha(),ticket.getIdTicket(),nodo.getIdProducto(),nodo.getPrecio(),nodo.getCantidad()));
				}
			}else {
				System.out.println("CANCELANDO COMPRA");
			}
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private Producto obtener(String id) {
		return listado.obtener(id);
	}
	
	
	
}
