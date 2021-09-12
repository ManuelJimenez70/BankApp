package views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import models.Events;

public class Body extends JPanel {

	private WelcomePanel welcome;
	private DepositPanel deposit;
	private WithDrawPanel withDraw;
	private CardLayout cardLayout;

	public Body(ActionListener actionListener, int balance) {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		this.setPreferredSize(new Dimension(View.WINDOW_WIDTH, View.WINDOW_HEIGHT ));
		initComponents(actionListener, balance);
	}

	private void initComponents(ActionListener actionListener, int balance) {
		this.welcome = new WelcomePanel(actionListener, balance);
		add(welcome, Events.WELCOME_PANEL);
		
		this.deposit = new DepositPanel(actionListener, balance);
		add(deposit, Events.DEPOSIT_PANEL);
		
		this.withDraw = new WithDrawPanel(actionListener, balance);
		add(withDraw, Events.WITHDRAW_PANEL);
	}
	
	public void setBalance(int balance) {
		this.welcome.setBalance(balance);
		this.deposit.setBalance(balance);
		this.withDraw.setBalance(balance);
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public int getDepositValue() {
		return deposit.getDepositValue();
	}

	public int getwithDrawValue() {
		return withDraw.getwithDrawValue();
	}

}
