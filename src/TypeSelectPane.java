import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GResizable;

public class TypeSelectPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	/*private GRect Bulking;
	private GRect Cutting;
	private GRect Cardio;*/
	private GImage background = new GImage("images/blurry-blue.jpg");
	
	private GImage bulkingButton = new GImage("images/Button_Bulking.png", 150, 135);
	private GImage cuttingButton = new GImage("images/Button_Cut.png", 150, 220);
	private GImage cardioButton = new GImage("images/Button_Cardio.png", 150, 305);
	//Need to add image for custom button
	//Commit
	private GImage customButton = new GImage("images/Button_Custom.png", 150, 390);
	private WorkoutSpec user;
	
	private GLabel Title;
	//private GLabel Title2;
	//private GLabel labelBulking;
	//private GLabel labelCutting;
	//private GLabel labelCardio;
	//private GRect quit;
	private GLabel labelquit;
	private GImage quitButton = new GImage("images/Button.png", 25, 25);
	
	private GImage quitButton2 = new GImage("images/Button.png", 25, 25);
	private GLabel labelquit2;
	
	private GImage notesButton = new GImage("images/Button.png", 25, 125);
	private GLabel notesMenuLabel;
	
	private GImage statsButton = new GImage("images/Button.png", 25, 75);
	private GLabel statisticsMenuLabel;
	
	public TypeSelectPane(MainApplication app) {
		program = app;
		
		Title = new GLabel("What Would You Like To Do?", 200, 100);
		//Title2 = new GLabel("Bulk, Cut, or Cardio?", 215, 80);
		Font titleFont = new Font("LuzSans-Books", Font.BOLD, 30);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		//Title2.setFont(titleFont);
		//Title2.setColor(Color.WHITE);
		
		bulkingButton.setSize(520, 80);
		customButton.setSize(520, 80);
		cuttingButton.setSize(520, 80);
		cardioButton.setSize(520, 80);
		
		Font textFont2 = new Font("LuzSans-Books", Font.PLAIN, 12);
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
		
		
		/*Font textFont = new Font("Ariel", Font.PLAIN, 24);
		Bulking = new GRect(150, 100, 500, 75);
		labelBulking = new GLabel("Bulking", 360, 150);
		labelBulking.setFont(textFont);
		
		Cutting = new GRect(150, 185, 500, 75);
		labelCutting = new GLabel("Cutting", 360, 235);
		labelCutting.setFont(textFont);
		
		Cardio = new GRect (150, 270, 500, 75);
		labelCardio = new GLabel("Cardio", 360, 320);
		labelCardio.setFont(textFont);
		//oval.setFilled(true);*/
	}

@Override
public void showContents() {
	program.add(background);
	
	program.add(quitButton);
	program.add(labelquit);
	program.add(bulkingButton);
	//program.add(labelBulking);
	program.add(cuttingButton);
	//program.add(labelCutting);
	program.add(cardioButton);
	//program.add(labelCardio);
	program.add(customButton);
	program.add(Title);
	//program.add(Title2);
}

@Override
public void hideContents() {
	program.remove(labelquit);
	program.remove(quitButton);
	program.remove(bulkingButton);
	//program.remove(labelBulking);
	program.remove(cuttingButton);
	//program.remove(labelCutting);
	program.remove(cardioButton);
	program.remove(customButton);
	//program.remove(labelCardio);
	program.remove(Title);
	//program.remove(Title2);
	program.remove(quitButton2);
	program.remove(labelquit2);
	program.remove(notesMenuLabel);
	program.remove(notesButton);
	program.remove(statsButton);
	program.remove(statisticsMenuLabel);
}


@Override
public void mousePressed(MouseEvent e) {
	GObject obj = program.getElementAt(e.getX(), e.getY());
	user = program.get_wspec();
	
	if(obj == background || obj == Title /*|| obj == Title2*/){
		program.add(quitButton);
		program.add(labelquit);
		program.remove(quitButton2);
		program.remove(labelquit2);
		program.remove(notesMenuLabel);
		program.remove(notesButton);
		program.remove(statsButton);
		program.remove(statisticsMenuLabel);
	}
	if(obj == bulkingButton) {
		user.setType(Type.BULKING);
		program.BulkingMuscleOptionPane();
	}
	if(obj == cuttingButton) {
		user.setType(Type.CUTTING);
		program.CuttingMuscleOptionPane();
	}
	if(obj == cardioButton) {
		user.setType(Type.CARDIO);
		program.CardioPane();
	}
	if(obj == customButton) {
		//user.setType(Type.BULKING);
		program.switchToCustom();
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