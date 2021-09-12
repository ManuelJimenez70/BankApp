package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Events;

public class DepositPanel extends JPanel {
	
	private Footer footer;
	private QuantityPanel quantity;

	public DepositPanel(ActionListener actionListener, int balance) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(View.WINDOW_WIDTH, View.WINDOW_HEIGHT));
		initComponents(actionListener, balance);
	}

	private void initComponents(ActionListener actionListener, int balance) {
		
		JLabel header = new JLabel(" Depositar");
		header.setForeground(Color.decode("#313186"));
		header.setFont(new Font("Bahnschrift", Font.PLAIN, 35));
		add(header, BorderLayout.NORTH);
		
		this.quantity = new QuantityPanel(actionListener);
		quantity.setCommand(Events.ACEPT_DEPOSIT);
		add(quantity, BorderLayout.CENTER);
		
		this.footer = new Footer(balance);
		add(footer, BorderLayout.SOUTH);
	}

	public void setBalance(int balance) {
		this.footer.setBalance(balance);
	}

	public int getDepositValue() {
		return quantity.getValue();
	}

}
