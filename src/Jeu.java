import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Jeu extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ImageIcon icofond;
	Image imgfond ; 
	ImageIcon icomenu;
	Image imgmenu; 
	public Jeu() {
		
		this.setSize(1920,1080);
		this.setTitle("Jeu RISK");

		this.icofond = new ImageIcon(getClass().getResource("/images/RISK_couverture.jpg"));
		this.imgfond = this.icofond.getImage();
		Image newfond = this.imgfond.getScaledInstance(this.getSize().width, this.getSize().height-50, java.awt.Image.SCALE_SMOOTH);
		this.icofond = new ImageIcon(newfond);
		JLabel fond = new JLabel(this.icofond);
		
		this.icomenu = new ImageIcon(getClass().getResource("/images/RISK_menu.png"));
		this.imgmenu = this.icomenu.getImage();
		Image newmenu = this.imgmenu.getScaledInstance(this.getSize().width, this.getSize().height-50, java.awt.Image.SCALE_SMOOTH);
		this.icomenu = new ImageIcon(newmenu);
		//JLabel menu = new JLabel(this.icomenu);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.add(fond);
		//this.add(menu);

	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(imgmenu ,0,0,null);
	}
}

