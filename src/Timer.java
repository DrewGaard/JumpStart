import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import acm.graphics.GLabel;
import acm.graphics.GObject;



public class Timer extends GraphicsPane {
	
	//private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GLabel timerLabel = new GLabel("Time: ", 233, 570);;
	public boolean quitTimeG;
	public boolean pause;
	public int timeSoFar;
	public int totalTime = 0;
	public int m = 0;
	public static int userTime = 11;
	public boolean calledOnce = false;
	
	public boolean ifClicked;
	
	
	public void createTimer(double time, MainApplication program) {
		
		Font textFont = new Font("LuzSans-Books", Font.PLAIN, 24);
		//timerLabel = new GLabel("Time: ", 0, 0);
		timerLabel.setFont(textFont);
		timerLabel.setColor(Color.WHITE);
		
			
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
			        	pause = false; //false
			            while (sevenM < time * 60 && quitTimeG){
			        		//System.out.println(totalTime);
			            	/*
			            	if(totalTime == 60)
			            	{
			            		totalTime = 0;
			            		m++;
			            	}
			            	*/
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
			            	totalTime++;
			            	sevenM++;
			            	if(totalTime == 60)
			            	{
			            		totalTime = 0;
			            		m++;
			            	}
			            	timerLabel.setLabel("Time: Minutes: " + m  + " Seconds: " + totalTime);
			            	if(calledOnce == false)
			            	{
			            		program.add(timerLabel);
			            		calledOnce = true;
			            	}
			            	//totalTime++;
			            	//sevenM++;
			                try
			                {
			                    Thread.sleep(1000); // 1 second
			                } catch (Exception e)
			                {
			                    e.printStackTrace();
			                }
			                if(sevenM == time * 60){
				            	UIManager UI=new UIManager();
				            	UI.put("OptionPane.background", Color.gray);
				            	UI.put("Panel.background", Color.gray);
				            	ImageIcon icon = new ImageIcon("images/arm_icon.png");
				            	JOptionPane.showMessageDialog(null,"You've completed your work out!","Congratulations!",JOptionPane.INFORMATION_MESSAGE, icon);
				            }
			            }
			            
			        }
			    };
			    thread.start();
				}
				//Thread.interrupted();
				//pause = false;
			}
	
	public void removeTimer(MainApplication program) {
		program.remove(timerLabel);
		calledOnce = false;
	}
	

	@Override
	public void showContents() {

	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
	}
	