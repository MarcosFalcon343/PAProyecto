package Reportes;

import Libreria.Libreria;
import Listas.LVenta;

public class ReportesMenu {
	
	private static String[] main = {"MENU REPORTES","1.-VENTA DIARIA","2.-VENTA DETERMINADA POR FECHA","3.-VENTA POR PRODUCTO","4.-CANCELAR"};
	private static LVenta ventas;
	
	public ReportesMenu() {
		ventas = new LVenta("ventas.txt");
	}

	public void ReportesMain() {
		String op = "0";
		ventas.leerArchivo();
		try {
			while(op.compareTo("4")!=0){
				op = Libreria.leerDato(Libreria.mostrarMenu(main));
				
				switch(op) {
				case "1":
					mostrarDia();
					break;
				case "2":
					mostrarFecha();
					break;
				case "3":
					mostrarProductos();
					break;
				default:
					op = "4";
					System.out.println("SALIDA DE PRODUCTOS");
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	private static void mostrarDia() {
		String diaHoy = Libreria.Fecha();
		String venta = Libreria.rellenarespacios("IDT", 5) + Libreria.rellenarespacios("IDP", 5) + Libreria.rellenarespacios("PRECIO", 6) + Libreria.rellenarespacios("CANT", 4) + Libreria.rellenarespacios("SUBTO", 5) + Libreria.rellenarespacios("IVA", 5) + Libreria.rellenarespacios("TOTAL", 5);
		System.out.println("VENTAS DEL DIA DE HOY " + diaHoy + "\n" +venta);
		ventas.mostrarDia(diaHoy);
	}
	
	private static void mostrarFecha() {
		try {
			ventas.mostrar();
			System.out.println("VENTAS POR FECHAS:");
			ventas.mostrarF();
			int fecha = Integer.parseInt(Libreria.leerDato("SELECCIONE EL NUMERO CORRESPONDIENTE A LA FECHA DESEADA"));
			String venta = Libreria.rellenarespacios("IDT", 5) + Libreria.rellenarespacios("IDP", 5) + Libreria.rellenarespacios("PRECIO", 6) + Libreria.rellenarespacios("CANT", 4) + Libreria.rellenarespacios("SUBTO", 5) + Libreria.rellenarespacios("IVA", 5) + Libreria.rellenarespacios("TOTAL", 5);
			System.out.println(venta);
			ventas.mostrarDia(ventas.getFecha((fecha - 1)));
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}

	private static void mostrarProductos() {
		try {
			ventas.mostrar();
			System.out.println("VENTAS POR PRODUCTOS:");
			String producto = Libreria.rellenarespacios("ID", 5) + " " +Libreria.rellenarespacios("NOMBRE", 60) + " " + Libreria.rellenarespacios("PRECIO", 6) + " " + Libreria.rellenarespacios("CANT", 4)
			+ Libreria.rellenarespacios("SUBT", 6) + Libreria.rellenarespacios("IVA", 6) + Libreria.rellenarespacios("TOTAL", 6);
			System.out.println(producto);
			ventas.mostrarP();
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
}
