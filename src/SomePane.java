import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;
import sun.audio.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.SoundClip;

public class SomePane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GOval oval;
	private GLabel start;
	private GImage background = new GImage("images/Jorge-1.jpg");
	
	public SomePane(MainApplication app) {
		this.program = app;
		//oval = new GOval(325, 200, 150, 150);
		start = new GLabel ("Click To JumpStart", 130, 280);
		Font titleFont = new Font("Courier", Font.BOLD, 50);
		start.setFont(titleFont);
		start.setColor(Color.WHITE);
		

	
		
	}
	
	@Override
	public void showContents() {
		program.add(background);
		//program.add(oval);
		program.add(start);
	}

	@Override
	public void hideContents() {
		//program.remove(oval);
		program.remove(start);
		program.remove(background);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == oval || obj == start) {
			program.switchBack();
			
			//Working on the theme song 
			//SoundClip sound = new SoundClip("Theme.mp3");
			//sound.play();
		}
	}

}
