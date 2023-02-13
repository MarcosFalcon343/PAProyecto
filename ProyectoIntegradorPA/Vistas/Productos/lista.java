package Productos;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class lista extends JPanel {

	public panel3 panel1 = new panel3();
	public panel4 panel2 = new panel4();
	
	
	public lista() {
		this.setBounds(0, 0, 600, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.CENTER);
	}

}
