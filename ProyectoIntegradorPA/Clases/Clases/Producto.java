package Clases;
import Libreria.Libreria;

public class Producto {

	private String IdProducto;
	private String Nombre;
	private String Precio;
	private String Cantidad;
	
	
	public Producto(String idProducto, String nombre, String precio, String cantidad) {
		super();
		IdProducto = idProducto;
		Nombre = nombre;
		Precio = precio;
		Cantidad = cantidad;
	}
	


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getPrecio() {
		return Precio;
	}


	public void setPrecio(String precio) {
		Precio = precio;
	}


	public String getCantidad() {
		return Cantidad;
	}


	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}
	
	public void addCantidad(int cant) {
		this.setCantidad(String.valueOf(Integer.parseInt(Cantidad) + cant));
	}

	public void removeCantidad(int cant) {
		this.setCantidad(String.valueOf(Integer.parseInt(Cantidad) - cant));
	}

	public String getIdProducto() {
		return IdProducto;
	}

	public String txt() {
		return this.getIdProducto() + "," + this.getNombre() + "," + this.Precio + "," + this.Cantidad + "\n";
	}

	@Override
	public String toString() {
		return Libreria.rellenarespacios(getIdProducto(), 5) + " " +Libreria.rellenarespacios(getNombre(), 60) + " " + Libreria.rellenarespacios(getPrecio(), 6) + " " + Libreria.rellenarespacios(Cantidad, 4);
	}
	
	
	
	
}
