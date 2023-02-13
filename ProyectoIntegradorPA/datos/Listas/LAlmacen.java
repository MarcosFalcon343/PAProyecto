package Listas;

import Clases.Almacen;
import Clases.Lista;
import Libreria.Libreria;

public class LAlmacen extends Lista{

	public LAlmacen(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void insertar(Almacen alm) {
		Almacen ALM = alm;
		this.agregar(ALM);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		this.leerArchivo();
		String almacen = Libreria.rellenarespacios("FECHA", 12) + Libreria.rellenarespacios("ID", 5) + Libreria.rellenarespacios("NOMBRE", 60) + Libreria.rellenarespacios("CANT", 5)
		+ Libreria.rellenarespacios("TIPO", 5) + Libreria.rellenarespacios("SA", 5) + Libreria.rellenarespacios("SN", 5);
		System.out.println(almacen);
		if(lista.size() > 0)	for(Object nodo: lista)	System.out.println(((Almacen)nodo).toString());
		else System.out.println("\nNO HAY MOVIENTOS REGISTRADOS\n");
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		System.out.println("\nNO SE PUEDE ALTERAR LOS REGISTROS DE ALMACEN O_o\n");
		
	}

}
