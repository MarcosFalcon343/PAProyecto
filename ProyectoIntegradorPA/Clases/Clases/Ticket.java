package Clases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import Libreria.Libreria;

public class Ticket implements ICuenta{

	private String idTicket;
	private String fecha;
	private ArrayList<Producto> productos;

	private DecimalFormat formato = new DecimalFormat("#.00");
	
	public Ticket(String id, String fecha) {
		this.idTicket = id;
		this.fecha = fecha;
		productos = new ArrayList<Producto>();
	}
	
	public void insertar(Producto producto) {
		try {
			Producto p = producto;
			p.setCantidad("1");
			if(existe(producto.getIdProducto(),1).equals("-1")) productos.add(p);
		}catch(Exception e) {
			
		}
	}
	
	public void remover(String id) {
		try {
			int pos = Integer.parseInt(existe(id,2));
			if(!String.valueOf(pos).equals("-1") && Integer.parseInt(productos.get(pos).getCantidad()) <= 0) productos.remove(pos);
		}catch(Exception e) {
			
		}
	}
	
	private String existe(String id, int tipo) {
		int i = 0;
		int pos = -1;
		for(Producto p: productos) {
			if(p.getIdProducto().equals(id)) {
				pos = i;
				switch(tipo) {
				case 1: productos.get(pos).addCantidad(1); break;
				case 2: productos.get(pos).removeCantidad(1); break;
				}
			}
			i++;
		}
		return String.valueOf(pos);
	}
	
	
	//Visuales
	public String ticket() {
		int cant = 100;
		String ticket = Libreria.separador('_', cant) + "IDTICKET: " + this.idTicket;
		ticket = ticket + "\nFECHA: " + this.fecha + "\n";
		ticket += Libreria.separador('-', cant);
		ticket += this.mostrarProductos();
		ticket += "\n" + Libreria.separador('-', cant);
		ticket += "SUBTOTAL: " + this.subtotal();
		ticket += "\nIVA: " + this.IVA();
		ticket += "\nTOTAL: " + this.total();
		ticket += "\n" + Libreria.separador('_', cant);
		return ticket;
	}
	
	public String mostrarProductos() {
		String producto = Libreria.rellenarespacios("ID", 5) + " " +Libreria.rellenarespacios("NOMBRE", 60) + " " + Libreria.rellenarespacios("PRECIO", 6) + " " + Libreria.rellenarespacios("CANT", 4)+ "\n";
		if(productos.size() > 0)	for(Producto p: productos)	producto += p.toString() + " " + (Double.parseDouble(p.getCantidad()) * Double.parseDouble(p.getPrecio())) +"\n";
		else producto = "NO HAY NINGUN PRODUCTO AGREGADO";
		
		return producto;
	}
	
	//getters setters
	public int size() {
		return productos.size();
	}
	
	public String getIdTicket() {
		return idTicket;
	}

	public String getFecha() {
		return fecha;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	@Override
	public String subtotal() {
		double subtotal = 0.00;
		// TODO Auto-generated method stub
		for(Producto nodo: productos) subtotal += (Integer.parseInt(nodo.getCantidad()) * Double.parseDouble(nodo.getPrecio()));

		return String.valueOf(formato.format(subtotal));
	}

	@Override
	public String IVA() {
		double iva = 0.00;
		for(Producto nodo: productos) iva += (0.16 * Double.parseDouble(nodo.getPrecio()) * Integer.parseInt(nodo.getCantidad()));
		return String.valueOf(formato.format(iva));
	}

	@Override
	public String total() {
		// TODO Auto-generated method stub
		double total = 0.00;
		total = Double.parseDouble(this.subtotal()) + Double.parseDouble(this.IVA());
		return String.valueOf(formato.format(total));
	}

}
