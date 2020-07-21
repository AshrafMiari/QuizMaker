package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuestionsList implements ActionListener{
	
	private JFrame frame = new JFrame("Questions");
	private JButton next = new JButton("Next");
	private JButton prev = new JButton("Prev");
	private JLabel question = new JLabel("Question");
	private JLabel answer = new JLabel("Answer");
	private JLabel counter = new JLabel("0" + "/" + "0");

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
