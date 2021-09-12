package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Header extends JPanel {

	private static final String HEADER_TEXT = "<html>" + "Hola" + System.getProperty("user.name")
			+ ", aqui puedes realizar transacciones a tu cuenta bancaria como consignar y retirar" + "</html>";
	private static final URL HEADER_ICON = View.class.getResource("/resources/images/headerIcon.png");
	
	private JLabel headerLabel;
	private JLabel welcomeText;

	public Header() {
		setPreferredSize(new Dimension(400, 180));
		setLayout(new BorderLayout());
		this.headerLabel = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(HEADER_ICON)));
		this.headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(headerLabel, BorderLayout.CENTER);
		this.welcomeText = new JLabel(HEADER_TEXT, SwingConstants.CENTER);
		this.welcomeText.setForeground(Color.decode("#313186"));
		this.welcomeText.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		add(welcomeText, BorderLayout.SOUTH);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.decode("#4849BD"));
		g.fillRect(0, 0, getWidth(), 5);
	}

}
