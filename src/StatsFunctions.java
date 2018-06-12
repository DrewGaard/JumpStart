

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StatsFunctions {
	public static double average(ArrayList<Double> data){
		double avg = 0;
		double sum = 0;
		Iterator<Double> data_it = data.iterator();
		while (data_it.hasNext()){
			sum += data_it.next();
		}
		avg = sum/data.size();
		
		return Math.ceil(avg); //Rounding up to make the user feel good
	}
	public static double max(ArrayList<Double> data){
		double max = 0;
		ArrayList<Double> copy = new ArrayList<Double>(data); //So we don't sort the actual list
		Collections.sort(copy); //Sort array list
		max = copy.get(copy.size() - 1);
		
		return max;
	}
	public static double min(ArrayList<Double> data){
		double min = 0;
		ArrayList<Double> copy = new ArrayList<Double>(data);
		Collections.sort(copy);
		min = copy.get(0);
		return min;
	}
}
