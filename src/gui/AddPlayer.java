package gui;

import javax.swing.*;

import appLogic.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayer extends JFrame implements ActionListener{
	
	private JFrame popup = new JFrame("Add Player");
	private JButton playerAdd = new JButton("add");
	private JTextField textField = new JTextField(1);
	private JLabel label = new JLabel("Enter Players Name: ");
	private NewGame settings;
	
	private String name = null;
	
	public AddPlayer(NewGame settings) {
		this.settings = settings;
		popup.setLayout(null);
		popup.setSize(400, 60);
		playerAdd.addActionListener(this);
		popup.add(textField);
		popup.add(label);
		popup.add(playerAdd);
		label.setBounds(0, 10, 150, 10);
		textField.setBounds(140, 5, 200, 20);
		playerAdd.setBounds(350, 5, 30, 30);
		popup.setLocationRelativeTo(null);
		popup.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playerAdd) {
			name = textField.getText();
			Player newPlayer = new Player(name, 0, settings.numOfPlayers);
			settings.players.add(newPlayer);
			settings.numOfPlayers++;
			popup.setVisible(false);
			popup.dispose();
			System.runFinalization();
		}
	}
	

}
