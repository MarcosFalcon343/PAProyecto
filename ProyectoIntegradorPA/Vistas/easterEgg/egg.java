package easterEgg;

import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class egg extends JFrame {

	private JPanel contentPane;

	public Pegg e = new Pegg();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public egg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(e);
		//this.egg("src/Assets/audio/egg.wav");
                try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/Assets/audio/egg.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		}catch(Exception e) {
			System.out.println("no dance " + e.getMessage());
		}
	}
	
	public void egg(String nombre) {
	}

}
