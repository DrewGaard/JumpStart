//This is the MenuPane - Drew Overgaard

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GResizable;
//Kyle hartman commented here on menu pane
public class MenuPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	//private GRect Workout;
	//private GRect Statistics;
	//private GRect Notes;
	//private GRect Quit;
	private GLabel Title;
	//private GLabel labelWorkout;
	//private GLabel labelStatistics;
	//private GLabel labelNotes;
	//private GLabel labelQuit;
	//private GRect Workout;
	private GImage background = new GImage("images/blurry-blue.jpg");
	private GImage workoutButton = new GImage("images/Button_Workout.png", 150, 135);
	private GImage statisticButton = new GImage("images/Button_Statistics.png", 150, 220);
	private GImage noteButton = new GImage("images/Button_Notes.png", 150, 305);
	private GImage quitButton = new GImage("images/Button_Quit.png", 150, 390);
	private GImage logo = new GImage("images/JumpStartLogo.png", 200, 10);

	public MenuPane(MainApplication app) {
		program = app;
		//rect = new GRect(200, 200, 300, 300);
		//rect.setFilled(true);
		logo.setSize(400, 125);
		workoutButton.setSize(520, 80);
		statisticButton.setSize(520, 80);
		noteButton.setSize(520, 80);
		quitButton.setSize(520, 80);
		/*Title = new GLabel("JumpStart", 315, 50);
		Font titleFont = new Font("Courier", Font.BOLD, 34);
		Title.setFont(titleFont);
		Title.setColor(Color.BLUE);*/
		
		Font textFont = new Font("Ariel", Font.PLAIN, 40);
		//Workout = new GRect(150, 100, 500, 75);
		//labelWorkout = new GLabel("WORKOUT", 300, 180);
		//labelWorkout.setFont(textFont);
		
		//Statistics = new GRect(150, 185, 500, 75);
		/*labelStatistics = new GLabel("STATISTICS", 290, 265);
		labelStatistics.setFont(textFont);
		
		//Notes = new GRect (150, 270, 500, 75);
		labelNotes = new GLabel("NOTES", 330, 340);
		labelNotes.setFont(textFont);
		
		//Quit = new GRect (150, 355, 500, 75);
		labelQuit = new GLabel("QUIT", 345, 430);
		labelQuit.setFont(textFont);*/
		//oval.setFilled(true);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(logo);
		program.add(workoutButton);
		program.add(statisticButton);
		program.add(noteButton);
		program.add(quitButton);
		//program.add(Workout);
		//program.add(labelWorkout);
		//program.add(Statistics);
		//program.add(labelStatistics);
		//program.add(Notes);
		//program.add(labelNotes);
		//program.add(Quit);
		//program.add(labelQuit);
		//program.add(Title);
	}

	@Override
	public void hideContents() {
		program.remove(logo);
		program.remove(workoutButton);
		program.remove(statisticButton);
		program.remove(noteButton);
		program.remove(quitButton);
		//program.remove(Workout);
		//program.remove(labelWorkout);
		//program.remove(Statistics);
		//program.remove(labelStatistics);
		//program.remove(Notes);
		//program.remove(labelNotes);
		//program.remove(Quit);
		//program.remove(labelQuit);
		//program.remove(Title);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == workoutButton) {
			program.switchToTypeSelect();
		}
		if(obj == statisticButton){
			program.switchToStatisticsPane();
		}
		if(obj == noteButton){
			program.switchToNotesPane();
		}
		if(obj == quitButton) {
			System.exit(0);
		}
	}
}
