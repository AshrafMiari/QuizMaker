package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import appLogic.*;

public class NewGame {
	
	private List<Player> players;
	private List<Question> questions;
	private int numOfPlayers = 0;
	private int numOfQuestions = 0;

	Scanner sc= new Scanner(System.in);
	
	
	public NewGame() {
		players = new ArrayList<Player>();
		questions = new ArrayList<Question>();
	}
	
	public void start() {
		
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
			}else if(input == 4) {
				System.exit(0);
			}else {
				System.out.println("Please enter a valid Command");
			}
		}
		sc.close();
	}
	
	private void addPlayer() {
		System.out.print("Enter Player Name: ");
		String name = sc.nextLine();
		Player newPlayer = new Player(name, 0, numOfPlayers);
		players.add(newPlayer);
		numOfPlayers++;
		
	}
	
	private void addQuestion() {
		System.out.print("Enter Question: ");
		String question = sc.nextLine();
		System.out.print("Enter Answer: ");
		String answer = sc.nextLine();
		Question newQuestion = new Question(question, answer, numOfQuestions);
		questions.add(newQuestion);
		numOfQuestions++;
	}
	
}
