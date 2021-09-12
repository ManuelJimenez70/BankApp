package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class View extends JFrame {

	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 400;
	private static final String TITTLE = "Titulo";
	private static final String ICON_IMAGE = "/resources/images/titleIcon.png";
	private static final Font MY_FONT_LBL = new Font("SansSerif", Font.PLAIN, 17);
	private static final Font MY_FONT_BTN = new Font("SansSerif", Font.PLAIN, 13);
	private static final String LABEL_FONT_PROP = "Label.font";
	private Header header;
	private Body body;
	private Footer footer;

	public View(ActionListener actionListener, int balance) {
		super();
		UIManager.put(LABEL_FONT_PROP, MY_FONT_LBL);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Button.foreground", Color.BLACK);
		UIManager.put("Button.font", MY_FONT_BTN);
		UIManager.put("Panel.background", Color.WHITE);
		this.setTitle(TITTLE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource(ICON_IMAGE)));
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		initComponents(actionListener, balance);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener, int balance) {
		this.body = new Body(actionListener, balance);

		this.add(this.body, BorderLayout.CENTER);
	}

	public CardLayout getCardLayout() {
		return body.getCardLayout();
	}

	public Body getBodyPanel() {
		return body;
	}

	public int getDepositValue() {
		return body.getDepositValue();
	}

	public void setBalance(int balance) {
		body.setBalance(balance);
	}

	public int getwithDrawValue() {
		return body.getwithDrawValue();
	}

}