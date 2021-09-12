package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	
	private Footer footer;
	private Header header;
	private Services services;

	public WelcomePanel(ActionListener actionListener, int balance) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(View.WINDOW_WIDTH, View.WINDOW_HEIGHT));
		initComponents(actionListener, balance);
	}

	private void initComponents(ActionListener actionListener, int balance) {
		this.header = new Header();
		add(header, BorderLayout.NORTH);
		this.services = new Services(actionListener);
		add(services, BorderLayout.CENTER);
		this.footer = new Footer(balance);
		add(footer, BorderLayout.SOUTH);
	}

	public void setBalance(int balance) {
		this.footer.setBalance(balance);
	}

}
