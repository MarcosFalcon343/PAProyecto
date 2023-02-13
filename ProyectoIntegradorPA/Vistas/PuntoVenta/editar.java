package PuntoVenta;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class editar extends JPanel {

	public botonesBAB BAB;
	public botonesICP ICP;
	public entradas entradas;
	public editar() {
		this.setBounds(0, 0, 600,180);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.BAB = new botonesBAB();
		this.ICP = new botonesICP();
		this.entradas = new entradas();
		this.add(entradas);
		this.add(BAB);
		this.add(ICP);
	}

}
