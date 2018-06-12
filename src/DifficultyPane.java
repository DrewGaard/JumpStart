import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GResizable;

public class DifficultyPane extends GraphicsPane{
	private MainApplication program;
	
	private GImage background = new GImage("images/blurry-blue.jpg");
	
	private GImage easyButton = new GImage("images/Button_Easy.png", 150, 135);
	private GImage mediumButton = new GImage("images/Button_Medium.png", 150, 220);
	private GImage hardButton = new GImage("images/Button_Hard.png", 150, 305);
	
	private GLabel labelquit;
	private GImage quitButton = new GImage("images/Button.png", 25, 25);
	
	private GImage quitButton2 = new GImage("images/Button.png", 25, 25);
	private GLabel labelquit2;
	
	private GImage notesButton = new GImage("images/Button.png", 25, 125);
	private GLabel notesMenuLabel;
	
	private GImage statsButton = new GImage("images/Button.png", 25, 75);
	private GLabel statisticsMenuLabel;
	
	private GLabel Title;
	private WorkoutSpec user;
	
	public DifficultyPane(MainApplication app){
		program = app;
		Title = new GLabel("Choose a Difficulty", 220, 50);
		Font titleFont = new Font("Courier", Font.BOLD, 30);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		//
		easyButton.setSize(520, 80);
		mediumButton.setSize(520, 80);
		hardButton.setSize(520, 80);
		
		
		
		Font textFont2 = new Font("Courier", Font.PLAIN, 12);
		//quit = new GRect(25,25,100,50);*/
		quitButton.setSize(100,50);
		labelquit = new GLabel("QUIT", 60, 50);
		labelquit.setFont(textFont2);
		labelquit.setColor(Color.WHITE);
		
		notesButton.setSize(100, 50);
		notesMenuLabel = new GLabel("Notes", 30, 150);
		notesMenuLabel.setFont(textFont2);
		notesMenuLabel.setColor(Color.WHITE);
		
		statsButton.setSize(100, 50);
		statisticsMenuLabel = new GLabel("Statistics", 30, 100);
		statisticsMenuLabel.setFont(textFont2);
		statisticsMenuLabel.setColor(Color.WHITE);
		
		quitButton2.setSize(100, 50);
		labelquit2 = new GLabel("Main Menu", 30, 50);
		labelquit2.setFont(textFont2);
		labelquit2.setColor(Color.WHITE);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(quitButton);
		program.add(labelquit);
		
		program.add(easyButton);
		program.add(mediumButton);
		program.add(hardButton);
		program.add(Title);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideContents() {
		program.remove(labelquit);
		program.remove(quitButton);
		
		program.remove(quitButton2);
		program.remove(labelquit2);
		program.remove(notesMenuLabel);
		program.remove(notesButton);
		program.remove(statsButton);
		program.remove(statisticsMenuLabel);
		
		
		program.remove(easyButton);
		program.remove(mediumButton);
		program.remove(hardButton);
		program.remove(Title);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e){
		GObject obj = program.getElementAt(e.getX(), e.getY());
		user = program.get_wspec();
		if(obj == background || obj == Title){
			program.add(quitButton);
			program.add(labelquit);
			program.remove(quitButton2);
			program.remove(labelquit2);
			program.remove(notesMenuLabel);
			program.remove(notesButton);
			program.remove(statsButton);
			program.remove(statisticsMenuLabel);
		}
		if(obj == easyButton){
			user.setDifficulty(DifficultyEnum.EASY);
			program.switchToMainWorkoutPane();
		}
		if(obj == mediumButton){
			user.setDifficulty(DifficultyEnum.MEDIUM);
			program.switchToMainWorkoutPane();
		}
		if(obj == hardButton){
			user.setDifficulty(DifficultyEnum.HARD);
			program.switchToMainWorkoutPane();
		}
		if(obj == quitButton || obj == labelquit){
			program.remove(quitButton);
			program.remove(labelquit);
			program.add(notesButton);
			program.add(notesMenuLabel);
			program.add(quitButton2);
			program.add(labelquit2);
			program.add(statsButton);
			program.add(statisticsMenuLabel);
			
		}
		if(obj == notesButton || obj == notesMenuLabel){
			program.switchToNotesPane();
		}
		if(obj == quitButton2 || obj == labelquit2){
			program.switchBack();
		}
		if(obj == statsButton || obj == statisticsMenuLabel){
			program.switchToStatisticsPane();
		}
	}
}
