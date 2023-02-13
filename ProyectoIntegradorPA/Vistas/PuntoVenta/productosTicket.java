package PuntoVenta;

import java.awt.GridLayout;
import java.util.ArrayList;
import Clases.Producto;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class productosTicket extends JScrollPane{

	public JTextArea Lista = new JTextArea();
	
	public productosTicket() {
		this.setBounds(0, 0, 400, 200);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		Lista.setEditable(false);
		Lista.setToolTipText("");
		Lista.setLineWrap(true);
		this.Lista.setColumns(60);
		setViewportView(Lista);
	}
	
	public void agregarProducto(String A) {
		String text = this.Lista.getText();
		this.Lista.setText(text + A);
	}
	
	

}
