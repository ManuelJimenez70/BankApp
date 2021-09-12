package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import models.Events;

public class QuantityPanel extends JPanel implements MouseListener {

	private JLabel quantityLb;
	private JButton acept, cancel;
	private JTextField quantityTx;

	public QuantityPanel(ActionListener actionListener) {
		setPreferredSize(new Dimension(400, 300));
		setLayout(new GridBagLayout());
		createComponents(actionListener);
		initComponents();
	}

	private void createComponents(ActionListener actionListener) {
		acept = new JButton("Aceptar");
		acept.setForeground(Color.decode("#71A95B"));
		acept.setBackground(Color.WHITE);
		acept.setBorder(new LineBorder(Color.decode("#71A95B")));
		acept.setFont(new Font("Arial Rounded MT", Font.BOLD, 15));
		acept.addActionListener(actionListener);
		acept.setFocusable(false);
		acept.setPreferredSize(new Dimension(150, 50));
		acept.addMouseListener(this);
		
		cancel = new JButton("Cancelar");
		cancel.setForeground(Color.decode("#DD564B"));
		cancel.setBackground(Color.WHITE);
		cancel.setBorder(new LineBorder(Color.decode("#DD564B")));
		cancel.setFont(new Font("Arial Rounded MT", Font.BOLD, 15));
		cancel.addActionListener(actionListener);
		cancel.setActionCommand(Events.CANCEL_BTN);
		cancel.setFocusable(false);
		cancel.setPreferredSize(new Dimension(150, 50));
		cancel.addMouseListener(this);

		quantityTx = new JTextField(15);
	}

	private void initComponents() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets.set(25, 5, 75, 5);
		quantityLb = new JLabel("Cantidad: ");
		quantityLb.setForeground(Color.decode("#4849BD"));
		quantityLb.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		add(quantityLb, c);
		c.gridx = 1;
		c.gridwidth = 3;
		add(quantityTx, c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		add(acept, c);
		c.gridx = 2;
		add(cancel, c);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(acept)) {
			acept.setBackground(Color.decode("#71A95B"));
			acept.setForeground(Color.WHITE);
		}
		if (e.getSource().equals(cancel)) {
			cancel.setBackground(Color.decode("#DD564B"));
			cancel.setForeground(Color.WHITE);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(acept)) {
			acept.setBackground(Color.WHITE);
			acept.setForeground(Color.decode("#71A95B"));
		}
		if (e.getSource().equals(cancel)) {
			cancel.setBackground(Color.WHITE);
			cancel.setForeground(Color.decode("#DD564B"));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setCommand(String aceptDeposit) {
		acept.setActionCommand(aceptDeposit);
	}

	public int getValue() {
		return Integer.parseInt(this.quantityTx.getText());
	}

}
