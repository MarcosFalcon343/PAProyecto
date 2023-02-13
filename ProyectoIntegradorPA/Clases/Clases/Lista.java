package Clases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Lista {

	public ArrayList<Object> lista;
	private File archivo;
	
	//Constructor
	public Lista(String name){
		lista = new ArrayList<Object>();
		archivo = new File(name);
		crearArchivo();
		leerArchivo();
	}
	
	//Archivos
	private void crearArchivo() {
		try {
			archivo.createNewFile();
		}catch (IOException e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	protected void escribirArchivo() {
		try {
			FileWriter esc = new FileWriter(archivo);
				for(Object nodo: lista) {
					if(nodo instanceof Producto) esc.write(((Producto) nodo).txt());
					else if(nodo instanceof Venta) esc.write(((Venta)nodo).txt());
					else if(nodo instanceof Almacen) esc.write(((Almacen)nodo).txt());
				}
				esc.close();
			}catch(IOException e1) {
				System.out.println("ERROR AL SUBIR PRODUCTO" + e1.getMessage());
			}	
	}
	
	public void leerArchivo() {
		String linea = "";
		ArrayList<Object> objetos = new ArrayList<Object>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			while(linea != null) {
				linea = bf.readLine();
				if(linea != null) {
					String[] cadena = linea.split(",");
					if(cadena.length == 4) objetos.add(new Producto(cadena[0],cadena[1],cadena[2],cadena[3]));
					else if(cadena.length == 8) objetos.add(new Venta(cadena[0],cadena[1],cadena[2],cadena[3],cadena[4]));
					else if(cadena.length == 7) objetos.add(new Almacen(cadena[0],cadena[1],cadena[2],cadena[3],cadena[4],cadena[5],cadena[6]));
				}
			}
		lista = objetos;
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Listas
	
	public void agregar(Object nodo) {
		lista.add(nodo);
		this.escribirArchivo();
	}
	

	
	public abstract void mostrar();
	public abstract void eliminar(String id);
}
