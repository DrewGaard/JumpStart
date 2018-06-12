import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.*;
import javax.imageio.*;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

import java.io.*;

public class CustomWorkoutPane extends GraphicsPane{
	private MainApplication program;
	
	private GImage background = new GImage("images/blurry-blue.jpg");
	
	private TextField userInput;
	private TextField timeInput;
    private Font textFont;
    private Font textFont2;
	private GLabel enterLabel;
	private GImage enterButton  = new GImage("images/Button.png", 325, 415);
	private String inputText;
	private String inputTime;
	
	private GLabel Title;

	private GLabel customWorkoutLabel;
	
	private GLabel customTimerLabel;
	
	public static double time = 7; //Set this to global so we can pass it in to other classes

	
	private GLabel labelquit;
	private GImage quitButton = new GImage("images/Button.png", 25, 25);
	
	//private GRect quit2;
	private GLabel labelquit2;
	private GImage quitButton2 = new GImage("images/Button.png", 25, 25);
	
	//private GRect workoutMenu;
	private GLabel workoutMenuLabel;
	private GImage workoutButton = new GImage("images/Button.png", 25, 75);
	
	//private GRect statsMenu;
	private GLabel statsMenuLabel;
	private GImage statsButton = new GImage("images/Button.png", 25, 125);
	
	private GLabel notesMenuLabel;
	private GImage notesButton = new GImage("images/Button.png", 25, 175);
	
	private WorkoutSpec user;
	
    public CustomWorkoutPane(MainApplication app){
    	
    	Title = new GLabel("Create A Custom Workout", 200, 60);
    	customWorkoutLabel = new GLabel("Enter in workout name", 220, 180);
    	customTimerLabel = new GLabel("Enter in Time amount in minutes", 180, 300);

    	Font titleFont = new Font("LuzSans-Books", Font.BOLD, 32);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		
		customWorkoutLabel.setFont(titleFont);
		customWorkoutLabel.setColor(Color.WHITE);
		
		customTimerLabel.setFont(titleFont);
		customTimerLabel.setColor(Color.WHITE);
    	
    	Font textFont = new Font("LuzSans-Books", Font.PLAIN, 12);
		//statsMenu = new GRect(23,125,75,50);
		statsButton.setSize(100, 50);
		statsMenuLabel = new GLabel("Statistics", 25, 150);
		statsMenuLabel.setFont(textFont);
		statsMenuLabel.setColor(Color.WHITE);
		
		//workoutMenu = new GRect(23,75,75,50);
		workoutButton.setSize(100, 50);
		workoutMenuLabel = new GLabel("Workout", 30, 100);
		workoutMenuLabel.setFont(textFont);
		workoutMenuLabel.setColor(Color.WHITE);
		
		//quit = new GRect(23,25,75,50);
		quitButton.setSize(100,50);
		labelquit = new GLabel("QUIT", 60, 50);
		labelquit.setFont(textFont);
		labelquit.setColor(Color.WHITE);
		
		//quit2 = new GRect(23,25,75,50);
		quitButton2.setSize(100, 50);
		labelquit2 = new GLabel("Main Menu", 30, 50);
		labelquit2.setFont(textFont);
		labelquit2.setColor(Color.WHITE);
		
		notesButton.setSize(100, 50);
		notesMenuLabel = new GLabel("Notes", 30, 200);
		notesMenuLabel.setFont(textFont);
		notesMenuLabel.setColor(Color.WHITE);
    	
    	program = app;
    	user = program.get_wspec();
    	user.setType(Type.CUSTOM);
    	user.setMuscleGroup(null);
    	textFont = new Font("LuzSans-Book", Font.BOLD, 18);
		inputText = "";
		userInput = new TextField(inputText);
		userInput.setFont(textFont);
		timeInput = new TextField("");
		timeInput.setFont(textFont);
		enterLabel = new GLabel("Enter",350,450);
		
		textFont2 = new Font("LuzSans-Book", Font.BOLD, 30);
		enterLabel.setFont(textFont2);
		enterLabel.setColor(Color.WHITE);
		
		enterButton.setSize(125, 50);
		
    }
    
	@Override
	public void showContents() {
		program.add(background);
		program.add(Title);
		program.add(customWorkoutLabel);
		program.add(customTimerLabel);
		
		program.add(enterButton);
		
		
		program.add(userInput, 100, 200);
		program.add(enterLabel);
		userInput.setVisible(true);
		userInput.setBounds(240, 210, 300, 25); //Change field size
		program.add(timeInput, 100, 250);
		timeInput.setVisible(true);
		timeInput.setBounds(240, 330, 300, 25);
		
		program.add(quitButton);
		program.add(labelquit);
	}

	@Override
	public void hideContents() {
		program.remove(userInput);
		userInput.setVisible(false);
		timeInput.setVisible(false);
		
		program.remove(Title);
		
		program.remove(labelquit);
		program.remove(quitButton);
		program.remove(quitButton2);
		program.remove(labelquit2);
		program.remove(notesButton);
		program.remove(notesMenuLabel);
		program.remove(statsMenuLabel);
		program.remove(statsButton);
		program.remove(workoutButton);
		program.remove(workoutMenuLabel);
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			take_input();
		}
	}
	
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == background || obj == Title || obj == customWorkoutLabel || obj == customTimerLabel){
			program.add(quitButton);
			program.add(labelquit);
			program.remove(quitButton2);
			program.remove(labelquit2);
			program.remove(notesMenuLabel);
			program.remove(notesButton);
			program.remove(statsButton);
			program.remove(statsMenuLabel);
			program.remove(workoutButton);
			program.remove(workoutMenuLabel);
		}
		if (obj == enterLabel || obj == enterButton){
			take_input();
		}
		if(obj == quitButton || obj == labelquit){
			program.remove(quitButton);
			program.remove(labelquit);
			program.add(notesButton);
			program.add(notesMenuLabel);
			program.add(quitButton2);
			program.add(labelquit2);
			program.add(statsButton);
			program.add(statsMenuLabel);
			program.add(workoutButton);
			program.add(workoutMenuLabel);
			
		}
		if(obj == notesButton || obj == notesMenuLabel){
			program.switchToNotesPane();
		}
		if(obj == quitButton2 || obj == labelquit2){
			program.switchBack();
		}
		if(obj == statsButton || obj == statsMenuLabel){
			program.switchToStatisticsPane();
		}
		if(obj == workoutButton || obj == workoutMenuLabel){
			program.switchToTypeSelect();
		}
	}
	public void take_input(){
		String timeText = null;
		GImage custom_img = null;
		inputText = userInput.getText();
		String folderName = "images/";
		String filepath = folderName+inputText;
		
		//Check if the file exists
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			System.out.println("The image path specified was not found.");
			return;
		}
		custom_img = new GImage(filepath);
		
		//Check if the time is a valid number
		timeText = timeInput.getText();
		if (timeText != ""){
			try{
				time = Double.parseDouble(timeText); //double
				if (time < 0){
					System.out.println("Please enter a positive non-zero number.\n");
					return;
				}
			}
			catch(NumberFormatException e){
				System.out.println("Please enter a positive non-zero number.\n");
				return;
			}
		}
		//This check doesn't work.  If the user doesn't put a valid path it still just displays.
		program.set_Custom_img(custom_img);
		program.switchToMainWorkoutPane();
	}
}
