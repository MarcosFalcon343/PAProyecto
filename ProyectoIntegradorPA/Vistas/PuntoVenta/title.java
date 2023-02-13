package PuntoVenta;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class title extends JPanel {

	public JLabel Lid;
	public JTextField id;
	public JLabel Lfecha;
	public JTextField fecha;
	
	public title(String id, String fecha) {

		this.setBounds(0,0,600,50);
		
		this.Lid = new JLabel("ID Ticket:");
		this.id = new JTextField();
		this.Lfecha = new JLabel("Fecha:");
		this.fecha = new JTextField();
		this.id.setText(id);
		this.id.setColumns(5);
		this.id.setEditable(false);
		this.fecha.setText(fecha);
		this.fecha.setColumns(20);
		this.fecha.setEditable(false);
		
		
		this.add(this.Lid);
		this.add(this.id);
		this.add(this.Lfecha);
		this.add(this.fecha);	
	}

}
