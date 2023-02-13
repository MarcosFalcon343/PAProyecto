package Productos;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class panel4 extends JScrollPane {

	public JTextArea Lista = new JTextArea();
	
	public panel4() {
		this.setBounds(0, 0, 600, 200);
		Lista.setEditable(false);
		Lista.setToolTipText("");
		Lista.setLineWrap(true);
		this.Lista.setColumns(60);
		//this.Lista.setRows(10);
		setViewportView(Lista);

	}
	
	public void agregarProducto(String A) {
			String text = this.Lista.getText();
			this.Lista.setText(text + A);
	}

}
