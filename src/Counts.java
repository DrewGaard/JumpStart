import java.util.ArrayList;

public class Counts {
	private double chestCount;
	private double armsCount;
	private double shouldersCount;
	private double backCount;
	private double legsCount;
	private double coreCount;
	private double cardioCount;
	private double customCount;
	//Add difficulty counts later
	
	//Counts will be stored in the order listed 0 - 6 in a file, save.txt
	public Counts(){
		ArrayList<Double> wCounts = FileIO.readData("save.txt");
//		for (int i = 0; i < wCounts.size(); i++){
//			System.out.println(Double.toString(wCounts.get(i)));	
//		}
		chestCount = wCounts.get(0);
		armsCount = wCounts.get(1);
		shouldersCount = wCounts.get(2);
		backCount = wCounts.get(3);
		legsCount = wCounts.get(4);
		coreCount = wCounts.get(5);
		cardioCount = wCounts.get(6);
		customCount = wCounts.get(7);
//		System.out.println(chestCount);
//		System.out.println(armsCount);
//		System.out.println(shouldersCount);
//		System.out.println(backCount);
//		System.out.println(legsCount);
//		System.out.println(coreCount);
//		System.out.println(cardioCount);
	}
	public void incrementCount(MuscleGroup m, Type t){
		//WorkoutSpec wspec = app.get_wspec();
		//Type t = wspec.getType();
		//MuscleGroup m = wspec.getMuscleGroup();
		if (t == Type.CARDIO){
			cardioCount++;
			return;
		}
		else if (t == Type.CUSTOM){
			customCount++;
			return;
		}
		if (m == MuscleGroup.CHEST){
			chestCount++;
		}
		else if (m == MuscleGroup.ARMS){
			armsCount++;
		}
		else if (m == MuscleGroup.SHOULDERS){
			shouldersCount++;
		}
		else if (m == MuscleGroup.BACK){
			backCount++;
		}
		else if (m == MuscleGroup.LEGS){
			legsCount++;
		}
		else if (m == MuscleGroup.CORE){
			coreCount++;
		}
		else {
			System.out.println("Error when trying to increment");
		}
	}
	
	public ArrayList<Double> getCounts(){
		ArrayList<Double> counts = new ArrayList<Double>();
		counts.add(chestCount);
		counts.add(armsCount);
		counts.add(shouldersCount);
		counts.add(backCount);
		counts.add(legsCount);
		counts.add(coreCount);
		counts.add(cardioCount);
		counts.add(customCount);
		if (!counts.isEmpty()){
			return counts;
		}
		System.out.println("Error getting counts");
		return null;
	}
	public void test(){
		System.out.println("What's going on?");
	}
}
