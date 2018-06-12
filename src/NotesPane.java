//Resources to implement text field that will eventually save user input to a file
//https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/api/java.awt.TextField.html
//Using a TextArea from AWT library was better
//http://www.tutorialspoint.com/awt/awt_textarea.htm
//Will use the above link to implement an example in a separate class

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;


public class NotesPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	
	private GLabel Title;
	
	private GImage background = new GImage("images/blurry-blue.jpg");
	//private GRect quit;
	private GLabel labelquit;
	private GImage quitButton = new GImage("images/Button.png", 23, 25);
	
	//private GRect quit2;
	private GLabel labelquit2;
	private GImage quitButton2 = new GImage("images/Button.png", 23, 25);
	
	//private GRect workoutMenu;
	private GLabel workoutMenuLabel;
	private GImage workoutButton = new GImage("images/Button.png", 23, 75);
	
	//private GRect statsMenu;
	private GLabel statsMenuLabel;
	private GImage statsButton = new GImage("images/Button.png", 23, 125);
	
	//private GRect textSize;
	private GLabel textSizeLabel;
	private GImage textSizeButton = new GImage("images/Button.png", 23, 125);
	
	private GImage increaseFontButton = new GImage("images/Button.png", 525, 25);
	private GLabel increaseFontLabel;
	
	private GImage decreaseFontButton = new GImage("images/Button.png", 625, 25);
	private GLabel decreaseFontLabel;
	
    private TextArea notes;
    private Font textFont;
    private Font textFontButtons;
    
    private FileIO save = new FileIO();
    private FileIO fontSave = new FileIO();
    
    
    //18
    private String fontSizeFile = FileIO.readText("fontSize.txt");
	
    int fontSize = Integer.parseInt(fontSizeFile);
	
	public NotesPane(MainApplication app) throws IOException {
		program = app;
		
		Font textFont = new Font("LuzSans-Books", Font.PLAIN, 12);
		//statsMenu = new GRect(23,125,75,50);
		statsButton.setSize(75, 50);
		statsMenuLabel = new GLabel("Statistics", 25, 150);
		statsMenuLabel.setFont(textFont);
		statsMenuLabel.setColor(Color.WHITE);
		
		//workoutMenu = new GRect(23,75,75,50);
		workoutButton.setSize(75, 50);
		workoutMenuLabel = new GLabel("Workout", 30, 100);
		workoutMenuLabel.setFont(textFont);
		workoutMenuLabel.setColor(Color.WHITE);
		
		//quit = new GRect(23,25,75,50);
		quitButton.setSize(75,50);
		labelquit = new GLabel("Quit", 30, 50);
		labelquit.setFont(textFont);
		labelquit.setColor(Color.WHITE);
		
		//quit2 = new GRect(23,25,75,50);
		quitButton2.setSize(75, 50);
		labelquit2 = new GLabel("Main Menu", 30, 50);
		labelquit2.setFont(textFont);
		labelquit2.setColor(Color.WHITE);
		
		//workoutMenu = new GRect(23,75,75,50);
		textSizeButton.setSize(300, 200);
		textSizeLabel = new GLabel("Increase Text Size", 30, 100);
		textSizeLabel.setFont(textFont);
		textSizeLabel.setColor(Color.WHITE);
		
		Title = new GLabel("Notes", 350, 50);
		Font titleFont = new Font("LuzSans-Books", Font.BOLD, 34);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		
		textFont = new Font("LuzSans-Book", Font.BOLD, fontSize);
		textFontButtons = new Font("LuzSans-Book", Font.BOLD, 18);
		String content = null;
		content = FileIO.readText("notes.txt");
		notes = new TextArea(content, 3, 100, TextArea.SCROLLBARS_VERTICAL_ONLY);	//Load the content of the notes file into the TextArea
		notes.setFont(textFont);
		
		increaseFontButton.setSize(100, 50);
		increaseFontLabel = new GLabel("(+) Font", 543, 55);
		increaseFontLabel.setFont(textFontButtons);
		increaseFontLabel.setColor(Color.WHITE);
		
		decreaseFontButton.setSize(100, 50);
		decreaseFontLabel = new GLabel("(-) Font", 643, 55);
		decreaseFontLabel.setFont(textFontButtons);
		decreaseFontLabel.setColor(Color.WHITE);
	}
	
	      
@Override
public void showContents() {
	program.add(background);
	program.add(notes,100,100);  //Puts the text box at 100,100
	notes.setVisible(true);
	notes.setBounds(100,100,600,400); //Sets the size of the text box
	
	program.add(quitButton);
	program.add(labelquit);
	
	program.add(increaseFontButton);
	program.add(decreaseFontButton);
	program.add(increaseFontLabel);
	program.add(decreaseFontLabel);
	
	program.add(Title);
	
	//fontSave.storeText("100", "fontSize.txt");
	
}

@Override
public void hideContents() {
	
	program.remove(notes); //Why doesn't this make the text box disappear?
	notes.setVisible(false);  //Seems to make it disappear. Might not be the "right" way to handle this
	program.remove(labelquit);
	program.remove(quitButton);
	program.remove(quitButton2);
	program.remove(labelquit2);
	program.remove(Title);
	program.remove(statsMenuLabel);
	program.remove(statsButton);
	program.remove(workoutButton);
	program.remove(workoutMenuLabel);
	program.remove(background);
}

@Override
public void mousePressed(MouseEvent e) {
	GObject obj = program.getElementAt(e.getX(), e.getY());
	
	if(obj == quitButton || obj == labelquit){
		save.storeText(notes.getText(), "notes.txt"); //Sort of a weird spot right now
		//Can we control where this is saved?
		program.remove(quitButton);
		program.remove(labelquit);
		program.add(statsButton);
		program.add(statsMenuLabel);
		program.add(quitButton2);
		program.add(labelquit2);
		program.add(workoutButton);
		program.add(workoutMenuLabel);
		
	}
	if(obj == statsButton || obj == statsMenuLabel){
		program.switchToStatisticsPane();
	}
	if(obj == quitButton2 || obj == labelquit2){
		program.switchBack();
	}
	if(obj == workoutButton || obj == workoutMenuLabel){
		program.switchToTypeSelect();
	}
	if(obj == increaseFontButton || obj == increaseFontLabel) {
		if(fontSize < 100)
		{
			fontSize += 2;
			textFont = new Font("LuzSans-Book", Font.BOLD, fontSize);
			notes.setFont(textFont);
			fontSave.storeText(Integer.toString(fontSize), "fontSize.txt");
		}
	}
	if(obj == decreaseFontButton || obj == decreaseFontLabel) {
		if(fontSize > 2)
		{
			fontSize -= 2;
			textFont = new Font("LuzSans-Book", Font.BOLD, fontSize);
			notes.setFont(textFont);
			fontSave.storeText(Integer.toString(fontSize), "fontSize.txt");
		}
	}
	if(obj == Title || obj == background  || obj == increaseFontButton || obj == increaseFontLabel || obj == decreaseFontButton || obj == decreaseFontLabel){
		program.add(quitButton);
		program.add(labelquit);
		program.remove(quitButton2);
		program.remove(labelquit2);
		program.remove(statsMenuLabel);
		program.remove(statsButton);
		program.remove(workoutButton);
		program.remove(workoutMenuLabel);
	}
}
}