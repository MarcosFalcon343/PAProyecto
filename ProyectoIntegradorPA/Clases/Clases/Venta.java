package Clases;

import Libreria.Libreria;
public class Venta implements ICuenta{

	//Fecha, idTicket, idProducto, Precio, Cantidad, subtotal, Iva, Total
	private String fecha;
	private String idTicket;
	private String idProducto;
	private String precio;
	private String cantidad;
	
	
	
	public Venta(String fecha, String idTicket, String idProducto, String precio, String cantidad) {
		super();
		this.fecha = fecha;
		this.idTicket = idTicket;
		this.idProducto = idProducto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	
	public String getFecha() {
		return fecha;
	}
	public String getIdTicket() {
		return idTicket;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public String getPrecio() {
		return precio;
	}
	public String getCantidad() {
		return cantidad;
	}

	//Fecha, idTicket, idProducto, Precio, Cantidad, subtotal, Iva, Total
	public String txt() {
		return this.getFecha() + "," + this.getIdTicket() + "," + this.getIdProducto() + "," + this.getPrecio() + "," + this.getCantidad() + "," + this.subtotal() + "," + this.IVA() + "," + this.total() +"\n";
	}
	
	public String toString() {
		
		return Libreria.rellenarespacios(this.idTicket, 5) + Libreria.rellenarespacios(idProducto, 5) + Libreria.rellenarespacios(precio, 6) + Libreria.rellenarespacios(cantidad, 4) + Libreria.rellenarespacios(this.subtotal(), 5) + Libreria.rellenarespacios(this.IVA(), 5) + Libreria.rellenarespacios(this.total(), 5); 
	}
	
	@Override
	public String subtotal() {
		// TODO Auto-generated method stub
		double subtotal = Double.parseDouble(this.getPrecio()) * Double.parseDouble(this.getCantidad());
		return String.valueOf(subtotal);
	}
	@Override
	public String IVA() {
		// TODO Auto-generated method stub
		double iva = Double.parseDouble(this.subtotal()) * 0.16;
		return String.valueOf(iva);
	}
	@Override
	public String total() {
		// TODO Auto-generated method stub
		double total = Double.parseDouble(this.subtotal()) + Double.parseDouble(this.IVA());
		return String.valueOf(total);
	}
}
