import Libreria.Libreria;
import Listas.LProductos;
import Productos.AlmacenMenu;
import Productos.ProductosMenu;
import Reportes.ReportesMenu;
import Ticket.PuntoVentaMenu;

public class Principal {
	
	private static String[] main = {"MENU PRINCIPAL\n","1.-PRODUCTOS","2.-PUNTO DE VENTA","3.-ALMACEN","4.-REPORTES DE VENTA","5.-SALIDA"};
	private static ProductosMenu PMenu;
	private static AlmacenMenu AMenu;
	private static ReportesMenu RMenu;
	
	public static void main(String[] args) {
		String op = "0";
		inicializar();
		try {
			do {
				op = Libreria.leerDato(Libreria.mostrarMenu(main));
				
				switch(op) {
				case "1":
					PMenu.ProductosMain();
					break;
				case "2":
					System.out.println();
					PuntoVentaMenu VMenu = new PuntoVentaMenu(PMenu.getListado());
					VMenu.PuntoVentaMain();
					break;
				case "3":
					AMenu.AlmacenMain(PMenu.getListado());
					break;
				case "4":
					RMenu.ReportesMain();
					break;
				default:
					break;
				}
			}while(op.compareTo("5")!=0);
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO" +e.getMessage());
		}
	}
	
	public static void inicializar() {
		PMenu = new ProductosMenu();
		AMenu = new AlmacenMenu();
		RMenu = new ReportesMenu();
	}
}
