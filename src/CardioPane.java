import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class CardioPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GLabel Title;

	private GImage background = new GImage("images/blurry-blue.jpg");
	
	
	private GImage backgroundButton = new GImage("images/Button.png",90 , 80);
	
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
	
	private GLabel notesMenuLabel;
	private GImage notesButton = new GImage("images/Button.png", 23, 125);
	
	private GLabel timerLabel;
	private GLabel pausedTime;
	public boolean quitTimeG;
	public boolean pause;
	public int timeSoFar;
	public int totalTime = 0;
	public int m = 0;
	public Timer test = new Timer();
	
	
	GObject newTimer = null;
	
	public boolean ifClicked;

	
	private GLabel pauseTimerLabel;
	private GImage pauseButton = new GImage("images/Button.png", 600, 525);
	
	private GLabel resetTimerLabel;
	private GImage resetButton = new GImage("images/Button.png", 105, 525);
	
	private GImage timerButton = new GImage("images/Button.png", 215, 520);
	
	private GLabel startTimerLabel;
	private GImage startButton = new GImage("images/Button.png", 700, 525);
	private GImage suggestion = new GImage ("cardio_suggestion.png", 110,110);
	
	public CardioPane(MainApplication app) {
		
		
		program = app;
		backgroundButton.setSize(640, 450);
		Title = new GLabel("Cardio", 340, 75);
		Font titleFont = new Font("LuzSans-Books", Font.BOLD, 34);
		Title.setFont(titleFont);
		Title.setColor(Color.WHITE);
		
		Font textFont = new Font("LuzSans-Books", Font.PLAIN, 12);
		Font pauseplayFont = new Font("LuzSans-Books", Font.BOLD, 18);
		
		//quit = new GRect(25,25,70,50);
		labelquit = new GLabel("QUIT", 30, 50);
		
		timerButton.setSize(370, 80);
		
		pauseButton.setSize(100, 50);
		pauseTimerLabel = new GLabel("Pause", 620, 555);
		pauseTimerLabel.setFont(pauseplayFont);
		pauseTimerLabel.setColor(Color.WHITE);
		
		resetButton.setSize(100, 50);
		resetTimerLabel = new GLabel("Reset", 115, 555);
		resetTimerLabel.setFont(pauseplayFont);
		resetTimerLabel.setColor(Color.WHITE);
		
		startButton.setSize(100, 50);
		startTimerLabel = new GLabel("Start", 725, 555);
		startTimerLabel.setFont(pauseplayFont);
		startTimerLabel.setColor(Color.WHITE);
		
		//Font textFont = new Font("LuzSans-Books", Font.PLAIN, 12);
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
		labelquit = new GLabel("QUIT", 30, 50);
		labelquit.setFont(textFont);
		labelquit.setColor(Color.WHITE);
		
		//quit2 = new GRect(23,25,75,50);
		quitButton2.setSize(75, 50);
		labelquit2 = new GLabel("Main Menu", 30, 50);
		labelquit2.setFont(textFont);
		labelquit2.setColor(Color.WHITE);
		
		notesButton.setSize(75, 50);
		notesMenuLabel = new GLabel("Notes", 25, 150);
		notesMenuLabel.setFont(textFont);
		notesMenuLabel.setColor(Color.WHITE);
		
	}

@Override
public void showContents() {
	program.add(background);
	program.add(backgroundButton);
	program.add(Title);

	program.add(quitButton);
	program.add(labelquit);
	
	program.add(pauseButton);
	program.add(resetButton);
	program.add(startButton);
	program.add(timerButton);
	program.add(suggestion);
	program.add(startTimerLabel);
	program.add(pauseTimerLabel);
	program.add(resetTimerLabel);
	
	//More timer work
			//Got the timer to work and update correctly!
			Font textFont = new Font("LuzSans-Books", Font.PLAIN, 24);
			timerLabel = new GLabel("Time: ", 233, 570);
			timerLabel.setFont(textFont);
			timerLabel.setColor(Color.WHITE);
			
//			Thread thread = new Thread()
//		    {
//
//		        public void run()
//		        {
//		        	int sevenM = 0;
//		        	int s = 0;
//		        	int m = 0;
//		        	quitTimeG = true;
//		        	pause = false;
//		        	//1200 seconds for 20 minutes of Cardio 
//		            while (sevenM < 421 && quitTimeG){
//		            	if(s == 60)
//		            	{
//		            		s = 0;
//		            		m++;
//		            		totalTime++;
//		            	}
//		            	if(pause)
//		            	{
//		            		try {
//								Thread.sleep(100000);
//								pause = false;				
//								
//							
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//		            	}
//		            	timerLabel.setLabel("Time: Minutes: " + m  + " Seconds: " + s);
//		            	program.add(timerLabel);
//		            	s++;
//		            	sevenM++;
//		            	totalTime++;
//		            	//System.out.println(totalTime);
//		                try
//		                {
//		                    Thread.sleep(1000); // 1 second
//		                } catch (Exception e)
//		                {
//		                    e.printStackTrace();
//		                }
//		            }
//		            //dialog button
//		            if(sevenM == 31){
//		            	UIManager UI=new UIManager();
//		            	UI.put("OptionPane.background", Color.gray);
//		            	UI.put("Panel.background", Color.gray);
//		            	ImageIcon icon = new ImageIcon("images/arm_icon.png");
//		            	JOptionPane.showMessageDialog(null,"You've completed your Cardio work out!","Congratulations!",JOptionPane.INFORMATION_MESSAGE, icon);
//		            }
//		        }
//		    };
//		    thread.start();
}

@Override
public void hideContents() {
	program.remove(labelquit);
	program.remove(quitButton);
	program.remove(quitButton2);
	program.remove(labelquit2);
	program.remove(Title);
	program.remove(statsMenuLabel);
	program.remove(statsButton);
	program.remove(workoutButton);
	program.remove(workoutMenuLabel);
	program.remove(notesMenuLabel);
	program.remove(notesButton);
	program.remove(suggestion);
	quitTimeG = false;
	program.remove(timerLabel);
	program.remove(timerButton);
	program.remove(backgroundButton);
	program.remove(resetButton);
	program.remove(resetTimerLabel);
	
}

@SuppressWarnings("null")
@Override
public void mousePressed(MouseEvent e) {
	GObject obj = program.getElementAt(e.getX(), e.getY());
	if(obj == background || obj == Title){
		program.add(quitButton);
		program.add(labelquit);
		program.remove(quitButton2);
		program.remove(labelquit2);
		program.remove(notesMenuLabel);
		program.remove(notesButton);
		program.remove(statsButton);
		program.remove(statsMenuLabel);
	}
	if(obj == quitButton || obj == labelquit){
		program.remove(quitButton);
		program.remove(labelquit);
		program.add(statsButton);
		program.add(statsMenuLabel);
		program.add(quitButton2);
		program.add(labelquit2);
		program.add(workoutButton);
		program.add(workoutMenuLabel);
		program.add(notesButton);
		program.add(notesMenuLabel);
	}
	if(obj == notesButton || obj == notesMenuLabel){
		program.switchToNotesPane();
		test.pause = true;
		test.ifClicked = false;
		test.calledOnce = false;
	}
	if(obj == quitButton2 || obj == labelquit2){
		program.switchBack();
		test.pause = true;
		test.ifClicked = false;
		test.calledOnce = false;
	}
	if(obj == statsButton || obj == statsMenuLabel){
		program.switchToStatisticsPane();
		test.pause = true;
		test.ifClicked = false;
		test.calledOnce = false;
	}
	if(obj == workoutButton || obj == workoutMenuLabel){
		program.switchToTypeSelect();
		test.pause = true;
		test.ifClicked = false;
		test.calledOnce = false;
	}
	if(obj == resetButton || obj == resetTimerLabel){
		program.remove(timerLabel);
		//pause = true;
		test.pause = true;
		//totalTime = 0;
		test.totalTime = 0;
		//m = 0;
		test.m = 0;
		//ifClicked = false;
		test.ifClicked = false;
		test.removeTimer(program);
	}
	if(obj == pauseButton || obj == pauseTimerLabel){
		test.pause = true;
		test.ifClicked = false;
		//test.removeTimer(program);
		//pausedTime.setLabel("Time: Minutes: " + test.m  + " Seconds: " + test.totalTime);
    	//program.add(pausedTime);
		//pause = true;
		//ifClicked = false;
		//program.remove(timerLabel);
	}
	
	if(obj == startButton || obj == startTimerLabel){
		
		
		if(test.ifClicked == false)
		{
			test.createTimer(20, program);	//Set to 20 for 20 minutes
			test.ifClicked = true;
		}
		
		//timerLabel.setLabel("Time: Minutes: " + test.m  + " Seconds: " + test.timeSoFar);
    	//program.add(timerLabel);
		
		/*
		//pause = true;
		if(ifClicked == false){
		ifClicked = true;
		
		//int startTime = totalTime;
		//System.out.println(totalTime);	
		
		if(totalTime >= 60)
		{
			m++;
			totalTime = 0;
		}
		Thread thread = new Thread()
	    {

	        public void run()
	        {
	        	int sevenM = 0;
	        	//int m = 0;
	        	quitTimeG = true;
	        	pause = false;
	        	//Trying to use a global variable 
	            while (sevenM < 11 && quitTimeG){
	        		System.out.println(totalTime);
	            	if(totalTime == 60)
	            	{
	            		totalTime = 0;
	            		m++;
	            	}
	            	if(pause)
	            	{
	            		try {
							Thread.sleep(1000000000);
							pause = false;				
							
						
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}
	            	timerLabel.setLabel("Time: Minutes: " + m  + " Seconds: " + totalTime);
	            	program.add(timerLabel);
	            	totalTime++;
	            	sevenM++;
	                try
	                {
	                    Thread.sleep(1000); // 1 second
	                } catch (Exception e)
	                {
	                    e.printStackTrace();
	                }
	                if(sevenM == 421){
		            	UIManager UI=new UIManager();
		            	UI.put("OptionPane.background", Color.gray);
		            	UI.put("Panel.background", Color.gray);
		            	ImageIcon icon = new ImageIcon("images/arm_icon.png");
		            	JOptionPane.showMessageDialog(null,"You've completed your Cardio work out!","Congratulations!",JOptionPane.INFORMATION_MESSAGE, icon);
		            }
	            }
	            
	        }
	    };
	    thread.start();
		}
		//Thread.interrupted();
		//pause = false;
	}
	

}
*/
}
}
}