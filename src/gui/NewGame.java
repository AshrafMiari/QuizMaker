package gui;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

import appLogic.*;

public class NewGame implements ActionListener{
	
	protected List<Player> players;
	protected List<Question> questions;
	protected int numOfPlayers = 0;
	protected int numOfQuestions = 0;
	
	private JFrame frame = new JFrame("New Game");
	private JLabel listOfPlayers = new JLabel("<html>" + "___Players Ready___" + "</html>");
	private JLabel noOfQuestions = new JLabel("Number Of Questions: 0");
	private JButton addPlayerBtn = new JButton("Add Player");
	private JButton addQuestionBtn = new JButton("Add Question");
	private JButton startGameBtn = new JButton("Start Game");
	private JButton quitBtn = new JButton("Quit");
	private JButton checkQuestionsBtn = new JButton("Review Questions");
	
	public NewGame() {
		players = new ArrayList<Player>();
		questions = new ArrayList<Question>();
	}
	
	public void start() {
		initWindow();
	}
	
	private void initWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.add(listOfPlayers);
		listOfPlayers.setBounds(350, 0, 1000, 50);
		listOfPlayers.repaint();
		frame.add(noOfQuestions);
		noOfQuestions.setBounds(0, 400, 1000, 50);
		noOfQuestions.repaint();
		frame.add(addPlayerBtn);
		addPlayerBtn.setBounds(5, 10, 100, 50);
		addPlayerBtn.addActionListener(this);
		frame.add(addQuestionBtn);
		addQuestionBtn.setBounds(5, 70, 100, 50);
		addQuestionBtn.addActionListener(this);
		frame.add(startGameBtn);
		startGameBtn.setBounds(5, 130, 100, 50);
		startGameBtn.addActionListener(this);
		frame.add(quitBtn);
		quitBtn.setBounds(5, 190, 100, 50);
		quitBtn.addActionListener(this);
		frame.add(checkQuestionsBtn);
		checkQuestionsBtn.setBounds(5, 310, 150, 50);
		checkQuestionsBtn.addActionListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
	}
	
	public void updatePlayers() {
		String output = "";
		for(int i = 0; i < numOfPlayers; i++) {
			output = output + players.get(i).toString();
		}
		int x = numOfPlayers * 15;
		listOfPlayers.setText("<html>" + "___Players Ready___" + output + "</html>");
		listOfPlayers.setBounds(350, 0, 1000, 50 + x);
		listOfPlayers.paintImmediately(listOfPlayers.getVisibleRect());
		frame.repaint();
	}
	
	public void updateQuestions() {
		noOfQuestions.setText("Number of Questions: " + numOfQuestions);
		noOfQuestions.paintImmediately(noOfQuestions.getVisibleRect());
		frame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPlayerBtn) {
			new AddPlayer(this);
		}else if(e.getSource() == addQuestionBtn) {
			new AddQuestion(this);
		}else if(e.getSource() == quitBtn) {
			System.exit(0);
		}else if(e.getSource() == startGameBtn) {
			frame.setVisible(false);
			new Game();
		}else if(e.getSource() == checkQuestionsBtn) {
			if(numOfQuestions == 0) {
				JOptionPane.showMessageDialog(null, "Please add questions first");
			}else {
				new ReviewQuestions(this);
			}
		}
	}
	
}
