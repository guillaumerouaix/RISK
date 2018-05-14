import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class Jeu extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ImageIcon icofond;
	Image imgfond ; 
	public Jeu() {
//		JFrame fen = new JFrame ("Ordinateur Qui Parle");
//
//		JPanel pan = new JPanel(new ImageIcon("/images/RISK_couverture.jpg"));
//		pan.setBackground(Color.WHITE);
//		fen.setContentPane(pan);
//
//
//		JTextField tape = new JTextField ();
//
//		Font police = new Font ("Arial", Font.BOLD, 25);
//		pan.add(tape);
//		tape.setBounds(60,450,560,50);
//		tape.setFont(police);
//
//		JButton bouton = new JButton ("Dis lui !");
//
//		pan.add(bouton);
//
//		bouton.setVisible(true);
//
//		bouton.setBounds(650,450,150,50);
//		
//		fen.setSize(850,600);
//
//		fen.pack();
//		fen.setLocationRelativeTo(null);
//
//		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		fen.setVisible(true);
		this.setSize(900,600);

		this.icofond = new ImageIcon(getClass().getResource("/images/RISK_couverture.jpg"));
		this.imgfond = this.icofond.getImage();
		Image newfond = this.imgfond.getScaledInstance(this.getSize().width, this.getSize().height, java.awt.Image.SCALE_SMOOTH);
		this.icofond = new ImageIcon(newfond);
		
		this.setLocationRelativeTo(null);
		JLabel fond = new JLabel(this.icofond);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.add(fond);		

		
		
	}
}

