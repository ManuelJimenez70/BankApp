package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Events;
import models.MyList;
import models.Node;
import models.OutOfBalanceException;
import models.Transaction;
import models.TransactionType;
import views.View;

public class Presenter implements ActionListener {

	private View view;
	private MyList list;

	public Presenter() {
		this.list = new MyList(new Node<Transaction>(new Transaction(TransactionType.CONSIGN, 0)));
		this.view = new View(this, list.getActualbalance());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Events.DEPOSIT_BTN:
			view.getCardLayout().show(view.getBodyPanel(), Events.DEPOSIT_PANEL);

			break;
		case Events.WITHDRAW_BTN:
			view.getCardLayout().show(view.getBodyPanel(), Events.WITHDRAW_PANEL);
			break;

		case Events.CANCEL_BTN:
			view.getCardLayout().show(view.getBodyPanel(), Events.WELCOME_PANEL);
			break;
		case Events.ACEPT_DEPOSIT:
			try {
				list.addElement(new Node<Transaction>(new Transaction(TransactionType.CONSIGN, view.getDepositValue())));
				view.setBalance(list.getActualbalance());
				view.getCardLayout().show(view.getBodyPanel(), Events.WELCOME_PANEL);
			} catch (OutOfBalanceException e1) {
				e1.printStackTrace();
			}
			break;
		case Events.ACEPT_WITHDRAW:
			try {
				list.addElement(new Node<Transaction>(new Transaction(TransactionType.WITHDRAWALS, view.getwithDrawValue())));
				view.setBalance(list.getActualbalance());
				view.getCardLayout().show(view.getBodyPanel(), Events.WELCOME_PANEL);
			} catch (OutOfBalanceException e1) {
	            JOptionPane.showMessageDialog(null, "Saldo insuficiente, intentalo de nuevo...");
			}
			break;	
		default:
			break;
		}
	}

}
