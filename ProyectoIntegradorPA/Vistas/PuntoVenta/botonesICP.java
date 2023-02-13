package PuntoVenta;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class botonesICP extends JPanel {

	public JButton BtnInventario;
	public JButton BtnCancelar;
	public JButton BtnPagar;

	public botonesICP() {
		this.setBounds(0, 0, 600, 70);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,50,5));
		this.BtnInventario = new JButton();
		this.BtnInventario.setBounds(0, 0, 50, 50);
		this.BtnInventario.setIcon(new ImageIcon(botonesICP.class.getResource("/Assets/img/inventario1.png")));
		this.BtnCancelar = new JButton("Cancelar");
		this.BtnPagar = new JButton("Pagar");
		this.BtnCancelar.setPreferredSize(new Dimension(100,30));
		this.BtnPagar.setPreferredSize(new Dimension(100,30));
		this.BtnInventario.setPreferredSize(new Dimension(60,60));
		this.add(BtnInventario);
		this.add(BtnCancelar);
		this.add(BtnPagar);
		
	}
}
