package easterEgg;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Pegg extends JPanel {

	public JLabel egg;
	public Pegg() {
		this.setBounds(0, 0, 500, 500);
		this.egg = new JLabel();
		egg.setIcon(new ImageIcon(Pegg.class.getResource("/Assets/img/egg.gif")));
		this.add(egg);
	}

}
