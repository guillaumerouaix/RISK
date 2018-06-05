import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class ImageLoader extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ImageIcon icofond;
	Image imgfond ;
	public ImageLoader(String chemin, int longeur, int hauteur) {
		
		this.setSize(longeur, hauteur);
		this.setTitle("Jeu RISK");

		this.icofond = new ImageIcon(getClass().getResource(chemin));
		this.imgfond = this.icofond.getImage();
		Image newfond = this.imgfond.getScaledInstance(this.getSize().width, this.getSize().height-50, java.awt.Image.SCALE_SMOOTH);
		this.icofond = new ImageIcon(newfond);
		JLabel fond = new JLabel(this.icofond);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.add(fond);

	}
}

