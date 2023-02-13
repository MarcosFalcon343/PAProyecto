package Productos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class EditarPanel extends JPanel {

	public static panel1  panel1 = new panel1();
	public static panel2 panel2 = new panel2();
	public static panel5 panel5 = new panel5();
	
	public EditarPanel() {
		this.setBounds(0, 0, 600, 100);
		this.setLayout(new GridLayout(3,1));
		this.add(panel1);
		this.add(panel5);
		this.add(panel2);
		
	}

}
