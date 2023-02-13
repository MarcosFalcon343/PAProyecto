package Clases;
import Libreria.Libreria;
public class Almacen {

	private String Fecha;
	private String IdProducto;
	private String Nombre;
	private String Cantidad;
	private String tipo;
	private String saldoA;
	private String saldoN;
	
	
	
	public Almacen(String fecha,String idProducto, String nombre, String cantidad, String tipo, String saldoA,String saldoN) {
		super();
		this.Fecha = fecha;
		this.IdProducto = idProducto;
		this.Nombre = nombre;
		this.Cantidad = cantidad;
		this.tipo = tipo;
		this.saldoA = saldoA;
		this.saldoN = saldoN;
	}
	
	public String txt() {
		return this.Fecha + "," + this.IdProducto + "," + this.Nombre + "," + this.Cantidad + "," + this.tipo + "," + this.saldoA + "," + this.saldoN+"\n";
	}
	
	public String toString() {
		return Libreria.rellenarespacios(Fecha, 12) + Libreria.rellenarespacios(IdProducto, 5) + Libreria.rellenarespacios(Nombre, 60) + Libreria.rellenarespacios(Cantidad, 5)
		+ Libreria.rellenarespacios(tipo, 5) + Libreria.rellenarespacios(saldoA, 5) + Libreria.rellenarespacios(saldoN, 5);
	}
	
	public String getIdProducto() {
		return IdProducto;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getCantidad() {
		return Cantidad;
	}
	public String getTipo() {
		return tipo;
	}
	public String getSaldoA() {
		return saldoA;
	}
	public String getSaldoN() {
		return this.saldoN;
	}
	
	
	
}
