import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class StatisticsPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GRect statisticsBox;
	
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
	
	//private GRect notesMenu;
	private GLabel notesMenuLabel;
	private GImage notesButton = new GImage("images/Button.png", 23, 125);
	
	private Histogram histFigure;
	
	public StatisticsPane(MainApplication app) {
		program = app;
		Font textFont = new Font("LuzSans-Book", Font.PLAIN, 12);
		
		//notesMenu = new GRect(23,125,75,50);
		notesButton.setSize(75, 50);
		notesMenuLabel = new GLabel("Notes", 25, 150);
		notesMenuLabel.setFont(textFont);
		notesMenuLabel.setColor(Color.WHITE);
		
		//workoutMenu = new GRect(23,75,75,50);
		workoutButton.setSize(75, 50);
		workoutMenuLabel = new GLabel("Workout", 30, 100);
		workoutMenuLabel.setFont(textFont);
		workoutMenuLabel.setColor(Color.WHITE);
		
		//quit = new GRect(23,25,75,50);
		quitButton.setSize(75,50);
		labelquit = new GLabel("QUIT", 30, 50);
		labelquit.setFont(textFont);
		labelquit.setColor(Color.WHITE);
		
		//quit2 = new GRect(23,25,75,50);
		quitButton2.setSize(75, 50);
		labelquit2 = new GLabel("Main Menu", 30, 50);
		labelquit2.setFont(textFont);
		labelquit2.setColor(Color.WHITE);
		
		statisticsBox = new GRect(100,100,600,400);
		statisticsBox.setFilled(true);
		statisticsBox.setFillColor(Color.WHITE);
		
		Title = new GLabel("Statistics", 320, 75);
		Font titleFont = new Font("LuzSans-Books", Font.BOLD, 34);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		
	}

@Override
public void showContents() {
	histFigure = new Histogram();
	program.add(background);
	program.add(statisticsBox);
	program.add(Title);
	program.add(quitButton);
	program.add(labelquit);
	//Histogram parts
	program.add(histFigure.W0);
	program.add(histFigure.W1);
	program.add(histFigure.W2);
	program.add(histFigure.W3);
	program.add(histFigure.W4);
	program.add(histFigure.W5);
	program.add(histFigure.Cardio);
	program.add(histFigure.Custom);
	program.add(histFigure.max);
	program.add(histFigure.min);
	program.add(histFigure.avg);
	for (int i = 0; i < histFigure.histLabels.size(); i++){
		program.add(histFigure.histLabels.get(i));
	}
}

@Override
public void hideContents() {
	program.remove(statisticsBox);
	program.remove(Title);
	program.remove(quitButton);
	program.remove(labelquit);
	program.remove(quitButton2);
	program.remove(labelquit2);
	program.remove(notesMenuLabel);
	program.remove(notesButton);
	program.remove(workoutButton);
	program.remove(workoutMenuLabel);
	program.remove(background);
	//Histogram parts
	program.remove(histFigure.W0);
	program.remove(histFigure.W1);
	program.remove(histFigure.W2);
	program.remove(histFigure.W3);
	program.remove(histFigure.W4);
	program.remove(histFigure.W5);
	program.remove(histFigure.Cardio);
	for (int i = 0; i < histFigure.histLabels.size(); i++){
		program.remove(histFigure.histLabels.get(i));
	}
}

@Override
public void mousePressed(MouseEvent e) {
	GObject obj = program.getElementAt(e.getX(), e.getY());
	
	if(obj == statisticsBox || obj == background || obj == Title){
		program.add(quitButton);
		program.add(labelquit);
		program.remove(quitButton2);
		program.remove(labelquit2);
		program.remove(notesMenuLabel);
		program.remove(notesButton);
		program.remove(workoutButton);
		program.remove(workoutMenuLabel);
	}
	if(obj == quitButton || obj == labelquit){
		program.remove(quitButton);
		program.remove(labelquit);
		program.add(notesButton);
		program.add(notesMenuLabel);
		program.add(quitButton2);
		program.add(labelquit2);
		program.add(workoutButton);
		program.add(workoutMenuLabel);
		
	}
	if(obj == notesButton || obj == notesMenuLabel){
		program.switchToNotesPane();
	}
	if(obj == quitButton2 || obj == labelquit2){
		program.switchBack();
	}
	if(obj == workoutButton || obj == workoutMenuLabel){
		program.switchToTypeSelect();
	}
}
}
