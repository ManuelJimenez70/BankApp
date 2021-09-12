package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Events;

public class Services extends JPanel implements MouseListener {

	private JButton depositbtn, withdrawbtn;
	private JPanel butnsPanel;
	private JLabel servicesLb;

	public Services(ActionListener actionListener) {
		setPreferredSize(new Dimension(400, 300));
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.servicesLb = new JLabel("  " + "  ¿Que servicio deseas hacer?");
		this.servicesLb.setForeground(Color.decode("#4849BD"));
		this.servicesLb.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		add(servicesLb, BorderLayout.CENTER);

		createButtons(actionListener);
		this.butnsPanel = new JPanel();
		this.butnsPanel.setLayout(new FlowLayout());
		this.butnsPanel.add(depositbtn);
		this.butnsPanel.add(withdrawbtn);
		add(butnsPanel, BorderLayout.SOUTH);
	}

	private void createButtons(ActionListener actionListener) {
		depositbtn = new JButton("Depositar");
		depositbtn.setForeground(Color.WHITE);
		depositbtn.setBackground(Color.decode("#313186"));
		depositbtn.setFont(new Font("Arial Rounded MT", Font.BOLD, 15));
		depositbtn.addActionListener(actionListener);
		depositbtn.setActionCommand(Events.DEPOSIT_BTN);
		depositbtn.setFocusable(false);
		depositbtn.setPreferredSize(new Dimension(150,50));
		depositbtn.addMouseListener(this);
		
		withdrawbtn = new JButton("Retirar");
		withdrawbtn.setForeground(Color.WHITE);
		withdrawbtn.setBackground(Color.decode("#313186"));
		withdrawbtn.setFont(new Font("Arial Rounded MT", Font.BOLD, 15));
		withdrawbtn.addActionListener(actionListener);
		withdrawbtn.setActionCommand(Events.WITHDRAW_BTN);
		withdrawbtn.setFocusable(false);
		withdrawbtn.setPreferredSize(new Dimension(150,50));
		withdrawbtn.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(depositbtn)) {
			depositbtn.setBackground(Color.decode("#4849BD"));
		}
		if (e.getSource().equals(withdrawbtn)) {
			withdrawbtn.setBackground(Color.decode("#4849BD"));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(depositbtn)) {
			depositbtn.setBackground(Color.decode("#313186"));

		}
		if (e.getSource().equals(withdrawbtn)) {
			withdrawbtn.setBackground(Color.decode("#313186"));
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
