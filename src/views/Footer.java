package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Footer extends JPanel{
	
	private static final String IMGS_PATH = "src/resources/images/footerImage.png";

	private String balance;
	
	public Footer(int balance) {
		setPreferredSize(new Dimension(400,120));
		setLayout(new BorderLayout());
		this.balance = "Tu Saldo actual es de: " + String.valueOf(balance);
	}
	
	private void getGraphics2D(Graphics2D g2) {
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2.setRenderingHints(rh);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		getGraphics2D(g2);
		Image image =  new ImageIcon(Toolkit.getDefaultToolkit().getImage(IMGS_PATH)).getImage();
		g2.drawImage(image, 0, 0, getWidth(), getHeight(),this);
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial Rounded MT", Font.BOLD, 20));
		g2.drawString(balance, getWidth()/7, getHeight()- getHeight()/3);
	}

	public void setBalance(int balance) {
		this.balance = "Tu Saldo actual es de: " + String.valueOf(balance);
		repaint();
	}

}
