//http://stackoverflow.com/questions/15438818/printing-a-word-every-x-seconds

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GResizable;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class CuttingMuscleOptionPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	
	private GLabel Title;
	private GImage chestButton = new GImage("Button_Chest.png", 150, 90);
	private GImage armsButton = new GImage("Button_Arms.png", 150, 175);
	private GImage shouldersButton = new GImage("Button_Shoulder.png", 150, 260);
	private GImage backButton = new GImage("Button_Back.png", 150, 345);
	private GImage legsButton = new GImage("Button_Legs.png", 150, 430);
	private GImage coreButton = new GImage("Button_COre.png", 150, 515);

	private GImage background = new GImage("images/blurry-blue.jpg");
	
	private GLabel labelquit;
	private GImage quitButton = new GImage("images/Button.png", 25, 25);
	
	private GImage quitButton2 = new GImage("images/Button.png", 25, 25);
	private GLabel labelquit2;
	
	private GImage notesButton = new GImage("images/Button.png", 25, 125);
	private GLabel notesMenuLabel;
	
	private GImage statsButton = new GImage("images/Button.png", 25, 75);
	private GLabel statisticsMenuLabel;
	
	private GImage workoutButton = new GImage("images/Button.png", 25, 175);
	private GLabel workoutMenuLabel;
	
	//private GLabel timerLabel;
	private WorkoutSpec user;
	//private Countdown timer2; //Will this work?
	
	public CuttingMuscleOptionPane(MainApplication app) {
		program = app;
		
		//rect = new GRect(200, 200, 300, 300);
		//rect.setFilled(true);
		//quit = new GRect(25,25,100,50);
		
		Title = new GLabel("Cutting: Please Select A Muscle Group", 200, 60);
		Font titleFont = new Font("LuzSans-Books", Font.BOLD, 22);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		Font textFont = new Font("LuzSans-Books", Font.PLAIN, 24);
		
		chestButton.setSize(500, 80);
		armsButton.setSize(500, 80);
		shouldersButton.setSize(500, 80);
		backButton.setSize(500, 80);
		legsButton.setSize(500, 80);
		coreButton.setSize(500, 80);
		
		Font textFont2 = new Font("LuzSans-Books", Font.PLAIN, 12);
		
		quitButton.setSize(100,50);
		labelquit = new GLabel("QUIT", 60, 50);
		labelquit.setFont(textFont2);
		labelquit.setColor(Color.WHITE);
		//oval.setFilled(true);
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
		
		workoutButton.setSize(100, 50);
		workoutMenuLabel = new GLabel("Workout", 30, 200);
		workoutMenuLabel.setFont(textFont2);
		workoutMenuLabel.setColor(Color.WHITE);
		
		//timerLabel = new GLabel("Time: ", 30, 200);
	}

@Override
public void showContents() {
	program.add(background);
	program.add(quitButton);
	program.add(labelquit);
	
	program.add(Title);
	
	program.add(chestButton);
	program.add(armsButton);
	program.add(shouldersButton);
	program.add(backButton);
	program.add(legsButton);
	program.add(coreButton);

	//ADDED TIMER HERE TO TEST
	//Got the timer to work and update correctly!
	//Font textFont = new Font("LuzSans-Books", Font.PLAIN, 24);
	//timerLabel = new GLabel("Time: ", 30, 200);
	//timerLabel.setFont(textFont);
	//timerLabel.setColor(Color.WHITE);
	
	/*
	Thread thread = new Thread()
    {

        public void run()
        {
        	int sevenM = 0;
        	int s = 0;
        	int m = 0;
            while (sevenM < 421){
            	if(s == 60)
            	{
            		s = 0;
            		m++;
            	}
            	timerLabel.setLabel("Time: Minutes: " + m  + "Seconds :" + s);
            	program.add(timerLabel);
            	s++;
            	sevenM++;
                try
                {
                    Thread.sleep(1000); // 1 second
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    };
    thread.start();
    */ 
	//Timer code stops here
}



@Override
public void hideContents() {
	program.remove(labelquit);
	program.remove(quitButton);
	program.remove(Title);
	
	program.remove(chestButton);
	program.remove(armsButton);
	program.remove(shouldersButton);
	program.remove(backButton);
	program.remove(legsButton);
	program.remove(coreButton);
	
	program.remove(quitButton2);
	program.remove(labelquit2);
	program.remove(notesMenuLabel);
	program.remove(notesButton);
	program.remove(statsButton);
	program.remove(statisticsMenuLabel);
	program.remove(workoutButton);
	program.remove(workoutMenuLabel);
	//program.remove(timerLabel); need a way to remove the timer
}

@Override
public void mousePressed(MouseEvent e) {
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
		program.remove(workoutButton);
		program.remove(workoutMenuLabel);
	}
	if(obj == chestButton) {
		user.setMuscleGroup(MuscleGroup.CHEST);
		program.switchToDiffcultyScreen();
	}
	if(obj == armsButton) {
		user.setMuscleGroup(MuscleGroup.ARMS);
		program.switchToDiffcultyScreen();
	}
	if(obj == shouldersButton) {
		user.setMuscleGroup(MuscleGroup.SHOULDERS);
		program.switchToDiffcultyScreen();
	}
	if(obj == backButton) {
		user.setMuscleGroup(MuscleGroup.BACK);
		program.switchToDiffcultyScreen();
	}
	if(obj == legsButton) {
		user.setMuscleGroup(MuscleGroup.LEGS);
		program.switchToDiffcultyScreen();
	}
	if(obj == coreButton) {
		user.setMuscleGroup(MuscleGroup.CORE);
		program.switchToDiffcultyScreen();
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
		program.add(workoutButton);
		program.add(workoutMenuLabel);
		
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
	if(obj == workoutButton || obj == workoutMenuLabel){
		program.switchToTypeSelect();
	}
}
}