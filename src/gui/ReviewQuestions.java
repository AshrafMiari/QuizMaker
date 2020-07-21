package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ReviewQuestions implements ActionListener{

	private JFrame frame = new JFrame("Review Questions");
	private JButton next = new JButton("Next");
	private JButton prev = new JButton("Prev");
	private JLabel question = new JLabel("This is a question");
	private JLabel answer = new JLabel("this is a Answer");
	
	private NewGame settings;
	
	public ReviewQuestions(NewGame s) {
		settings = s;
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setLayout(null);
		frame.add(next);
		next.setBounds(480, 400, 100, 50);
		next.addActionListener(this);
		frame.add(prev);
		prev.setBounds(20, 400, 100, 50);
		prev.addActionListener(this);
		frame.add(question);
		question.setBounds(100, 10, 1000, 100);
		question.setText(settings.questions.get(0).getContents());
		question.setFont(new Font(null, Font.BOLD, 40));
		frame.add(answer);
		answer.setText(settings.questions.get(0).getAnswer());
		answer.setBounds(100, 300, 1000, 100);
		answer.setFont(new Font(null, Font.PLAIN, 20));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
