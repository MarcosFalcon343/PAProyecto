package Libreria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libreria {

	//Visual
    public static String rellenarespacios(String dato, int tamano)
    {
        String cadena;
        cadena = dato;
        for (int ciclo = dato.length() - 1; ciclo < tamano; ciclo++)
            cadena = cadena + " ";
        return cadena;
    }
    
    public static String mostrarMenu(String[] op) {
    	String cadena = "";
    	for(String nodo: op) cadena+=nodo+"\n";
    	cadena = cadena + "\nQUE OPCION DESEA...:";
    	return cadena;
    }
    
    public static String separador(char sep, int cant) {
    	String separador = "";
    	for(int i = 0; i < cant; i++) separador+=sep;
    	separador+="\n";
    	return separador;
    }
    
    
    //Lectura
    public static String leerDato() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	return br.readLine();
    }
    
    
    public static String leerDato(String msg) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println(msg);
    	return br.readLine();
    }
    
    //Fecha
    
    public static String Fecha() {
    	Date fecha = new Date();
    	SimpleDateFormat day = new SimpleDateFormat("dd-MM-yyyy");
    	return day.format(fecha);
    }
    
    public static String idFormat(String ID) {
    	String id = "";
    	int num = Integer.parseInt(ID);
    	if(num < 10) id = "00" + String.valueOf(num).trim();
    	else if(num > 9 && num < 100) id = "0" + String.valueOf(num).trim();
    	else id = String.valueOf(num).trim();
    	
    	return id;
    }
    
    public static boolean evaluarNumerico(String dato, int tipo) {
    	boolean valido = true;
    	try {
    		switch(tipo) {
    		case 1: {int x = Integer.parseInt(dato);} break;
    		case 2: {double x = Double.parseDouble(dato);} break;
    		}
    	}catch(NumberFormatException e) {
    		valido = false;
    	}
    	return valido;
    }

}
