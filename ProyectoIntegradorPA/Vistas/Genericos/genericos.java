package Genericos;

import javax.swing.JOptionPane;

public class genericos {

	public static void error(String msg) {
		JOptionPane.showMessageDialog(null, msg,"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
	public static void advertencia(String msg) {
		JOptionPane.showMessageDialog(null, msg,"ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
	}
	
	public static void hecho(String msg) {
		JOptionPane.showMessageDialog(null, msg,"REALIZADO",JOptionPane.INFORMATION_MESSAGE);
	}
}
