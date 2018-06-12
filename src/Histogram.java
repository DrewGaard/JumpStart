import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.Color;
import java.util.ArrayList;

//Base functionality is pretty much done, eventually maybe add some averages

public class Histogram {
	private ArrayList<Double> workoutCounts = new ArrayList<Double>();
	public GRect W0;
	public GRect W1;
	public GRect W2;
	public GRect W3;
	public GRect W4;
	public GRect W5;
	public GRect Cardio;
	public GRect Custom;
	private int width;
	
	public GLabel max;
	public GLabel min;
	public GLabel avg;
	public ArrayList<GLabel> histLabels;
	public ArrayList<String> labelNames;
	private double maxCount, minCount, avgCount;
	
	public Histogram(){
		width = 40;
		workoutCounts = FileIO.readData("save.txt");
		for (int i = 0; i < workoutCounts.size(); i++){
			System.out.println(workoutCounts.get(i));
		}
		histLabels = new ArrayList<GLabel>();
		labelNames = new ArrayList<String>();
		labelNames.add("Chest");
		labelNames.add("Arms");
		labelNames.add("Shoulders");
		labelNames.add("Back");
		labelNames.add("Legs");
		labelNames.add("Core");
		labelNames.add("Cardio");
		labelNames.add("Custom");
		maxCount = StatsFunctions.max(workoutCounts);
		minCount = StatsFunctions.min(workoutCounts);
		avgCount = StatsFunctions.average(workoutCounts);
		
		createHistogram();
	}
	
	public void createHistogram(){
		ColumnScale cScale = new ColumnScale(workoutCounts);
		double convertToPixels = cScale.getRatio();
		
		W0 = new GRect(170, (int)(500-workoutCounts.get(0)*convertToPixels), width, (int)(workoutCounts.get(0)*convertToPixels));
		W1 = new GRect(230, (int)(500-workoutCounts.get(1)*convertToPixels), width, (int)(workoutCounts.get(1)*convertToPixels));
		W2 = new GRect(290, (int)(500-workoutCounts.get(2)*convertToPixels), width, (int)(workoutCounts.get(2)*convertToPixels));
		W3 = new GRect(350, (int)(500-workoutCounts.get(3)*convertToPixels), width, (int)(workoutCounts.get(3)*convertToPixels));
		W4 = new GRect(410, (int)(500-workoutCounts.get(4)*convertToPixels), width, (int)(workoutCounts.get(4)*convertToPixels));
		W5 = new GRect(470, (int)(500-workoutCounts.get(5)*convertToPixels), width, (int)(workoutCounts.get(5)*convertToPixels));
		Cardio = new GRect(530, (int)(500-workoutCounts.get(6)*convertToPixels), width, (int)(workoutCounts.get(6)*convertToPixels));
		Custom = new GRect(590, (int)(500-workoutCounts.get(7)*convertToPixels), width, (int)(workoutCounts.get(7)*convertToPixels));
//		System.out.println("Custom count: "+workoutCounts.get(7));
		W0.setFilled(true);
		W1.setFilled(true);
		W2.setFilled(true);
		W3.setFilled(true);
		W4.setFilled(true);
		W5.setFilled(true);
		Cardio.setFilled(true);
		Custom.setFilled(true);
		W0.setFillColor(Color.CYAN);
		W1.setFillColor(Color.CYAN);
		W2.setFillColor(Color.CYAN);
		W3.setFillColor(Color.CYAN);
		W4.setFillColor(Color.CYAN);
		W5.setFillColor(Color.CYAN);
		Cardio.setFillColor(Color.CYAN);
		Custom.setFillColor(Color.CYAN);
		max = new GLabel("Largest Count: "+String.valueOf(maxCount), 125, 125);
		min = new GLabel("Smallest Count: "+String.valueOf(minCount), 125, 150);
		avg = new GLabel("Average Count: "+String.valueOf(avgCount), 125, 175);
		for (int i = 0; i < labelNames.size(); i++){
			//Alternate high and low to avoid names touching
			if (i%2 == 0){
				//Handling some of the names separately to make them look more centered.  Wonder if there is a smart way to do this.
				if(i == 2){
					histLabels.add(new GLabel(labelNames.get(i), (170+ 60*i)-8, 515));
				}
				else if(i == 4){
					histLabels.add(new GLabel(labelNames.get(i), (170+ 60*i)+5, 515));
				}
				else{
					histLabels.add(new GLabel(labelNames.get(i), (170+ 60*i), 515));
				}
			}
			else{
				histLabels.add(new GLabel(labelNames.get(i), (170+ 60*i)+5, 525));
			}
			
		}
		
	}
}
