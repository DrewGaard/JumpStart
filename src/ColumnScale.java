import java.util.ArrayList;
import java.util.Collections;

public class ColumnScale {
	private double columnRatio;
	
	public ColumnScale(ArrayList<Double> workoutTimes){
		ArrayList<Double> copy = new ArrayList<Double>(workoutTimes); //So we don't sort the actual list
		
		Collections.sort(copy); //Sort array list
		double max = copy.get(copy.size() - 1); //Get largest value
		columnRatio = 300/max; //Create a ratio of pixels/time so we can multiply by the other times to determine their length in pixels 
		//Not 400 because if it were 400 it would look sort of funny and hit the top
	}
	public double getRatio(){
		return columnRatio;
	}
}
