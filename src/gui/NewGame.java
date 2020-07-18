package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.*;
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
	private JButton addPlayerBtn = new JButton("Add Player");
	private JButton addQuestionBtn = new JButton("Add Question");
	private JButton startGameBtn = new JButton("Start Game");
	private JButton quitBtn = new JButton("Quit");

	Scanner sc= new Scanner(System.in);
	
	
	public NewGame() {
		players = new ArrayList<Player>();
		questions = new ArrayList<Question>();
	}
	
	public void start() {
		
		initWindow();
		
		boolean gameStarted = false;
		while(gameStarted == false) {
			System.out.println("1. Add Player \n" +
					   "2. Add Question \n" +
					   "3. Start Game \n" + 
					   "4. Quit");
			int input = sc.nextInt();
			sc.nextLine();
			if(input == 1) {
				addPlayer();
			}else if(input == 2) {
				addQuestion();
			}else if(input == 3) {
				System.out.println("To be implemented");
				startGame();
				gameStarted = true;
			}else if(input == 4) {
				System.exit(0);
			}else {
				System.out.println("Please enter a valid Command");
			}
		}
		System.out.println("Thanks for playing :)");
		sc.close();
	}
	
	private void addPlayer() {
		AddPlayer add = new AddPlayer(this);
	}
	
	private void addQuestion() {
		AddQuestion add = new AddQuestion(this);
		System.out.print("Enter Question: ");
		String question = sc.nextLine();
		System.out.print("Enter Answer: ");
		String answer = sc.nextLine();
		Question newQuestion = new Question(question, answer, numOfQuestions);
		questions.add(newQuestion);
		numOfQuestions++;
	}
	
	private void startGame() {
		Game game = new Game();
	}
	
	private void initWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
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
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPlayerBtn) {
			addPlayer();
		}
	}
	
}
