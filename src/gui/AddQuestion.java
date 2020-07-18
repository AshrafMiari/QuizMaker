package gui;

import javax.swing.*;

import appLogic.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuestion implements ActionListener {
	
	private JFrame popup = new JFrame("Add Question");
	private JButton questionAdd = new JButton("add");
	private JTextField textFieldQuestion = new JTextField(1);
	private JTextField textFieldAnswer = new JTextField(1);
	private JLabel labelQuestion = new JLabel("Enter Question: ");
	private JLabel labelAnswer = new JLabel("Enter Answer: ");
	private NewGame settings;
	
	private String question = null;
	private String answer = null;
	
	public AddQuestion(NewGame settings) {
		this.settings = settings;
		popup.setLayout(null);
		popup.setSize(400, 100);
		questionAdd.addActionListener(this);
		popup.add(textFieldQuestion);
		popup.add(textFieldAnswer);
		popup.add(labelQuestion);
		popup.add(labelAnswer);
		popup.add(questionAdd);
		labelQuestion.setBounds(0, 10, 150, 10);
		labelAnswer.setBounds(0, 30, 150, 10);
		textFieldQuestion.setBounds(140, 5, 200, 20);
		textFieldAnswer.setBounds(140, 30, 200, 20);
		questionAdd.setBounds(350, 5, 30, 30);
		popup.setLocationRelativeTo(null);
		popup.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == questionAdd) {
			question = textFieldQuestion.getText();
			answer = textFieldAnswer.getText();
			Question newQuestion = new Question(question, answer, settings.numOfQuestions);
			settings.questions.add(newQuestion);
			settings.numOfQuestions++;
			settings.updateQuestions();
			popup.setVisible(false);
			popup.dispose();
			System.runFinalization();
		}
	}

}
