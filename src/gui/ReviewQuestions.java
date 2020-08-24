package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class ReviewQuestions implements ActionListener{

	private JFrame frame = new JFrame("Review Questions");
	private JButton next = new JButton("Next");
	private JButton prev = new JButton("Prev");
	private JTextPane question = new JTextPane();
	private JTextPane answer = new JTextPane();
	
	private NewGame settings;
	
	private int currentQuestionNumber = 0;
	
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
		question.setBounds(100, 10, 400, 100);
		question.setText(settings.questions.get(0).getContents());
		question.setFont(new Font(null, Font.BOLD, 20));
		question.setOpaque(false);
		frame.add(answer);
		answer.setText(settings.questions.get(0).getAnswer());
		answer.setBounds(100, 300, 400, 100);
		answer.setFont(new Font(null, Font.PLAIN, 20));
		answer.setOpaque(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
	}
	
	private void goToNextQuestion() {
		if(currentQuestionNumber != settings.numOfQuestions - 1) {
			question.setText(settings.questions.get(currentQuestionNumber + 1).getContents());
			answer.setText(settings.questions.get(currentQuestionNumber + 1).getAnswer());
			currentQuestionNumber++;
			question.paintImmediately(question.getVisibleRect());
			answer.paintImmediately(answer.getVisibleRect());
			frame.repaint();
		}
	}
	
	private void goToPrevQuestion() {
		if(currentQuestionNumber != 0) {
			question.setText(settings.questions.get(currentQuestionNumber - 1).getContents());
			answer.setText(settings.questions.get(currentQuestionNumber - 1).getAnswer());
			question.paintImmediately(question.getVisibleRect());
			answer.paintImmediately(answer.getVisibleRect());
			frame.repaint();
			currentQuestionNumber--;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == next) {
			goToNextQuestion();
		}else if(e.getSource() == prev) {
			goToPrevQuestion();
		}
	}
}
