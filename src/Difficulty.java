
public class Difficulty {
	private WorkoutSpec user;
	private int chestECount = 0;
	private int chestMCount = 0;
	private int chestHCount = 0;
	private int armsECount = 0;
	private int armsMCount = 0;
	private int armsHCount = 0;
	private int shouldersECount = 0;
	private int shouldersMCount = 0;
	private int shouldersHCount = 0;
	private int backECount = 0;
	private int backMCount = 0;
	private int backHCount = 0;
	private int cardioCount = 0;
	

	
	/*
	 * add yes/no button with screen switching them to the next level work out
	 * Create graphics pane saying you've completed X work outs certain level 
	 * Graphics pane if they've completed certain amount of hard work outs 
	 * 
	 * */
	
	public void progress(){
		MuscleGroup m = user.getMuscleGroup();
		DifficultyEnum d = user.getDifficulty();
		Type c = user.getType();
		if (m == MuscleGroup.CHEST){
			if (d == DifficultyEnum.EASY){
				chestECount++;
				if (chestECount >=5){
					System.out.println("You've completed 5 easy level chest workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a medium level chest workout");
				}
				
			}
			else if (d == DifficultyEnum.MEDIUM){
				chestMCount++;
				if (chestMCount >= 5){
					System.out.println("You've completed 5 medium level chest workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a hard level chest workout");
				}
			}
			else if (d == DifficultyEnum.HARD){
				chestHCount++;
				if (chestHCount >= 5){
					System.out.println("You've completed 5 hard level chest workouts, congratulations!");
					System.out.println("Keep up the good work!");
				}
			}
		}
		else if (m == MuscleGroup.ARMS){
			if (d == DifficultyEnum.EASY){
				armsECount++;
				if (armsECount >= 5){
					System.out.println("You've completed 5 easy level arm workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a medium level chest workout");
				}
					
			}
			else if (d == DifficultyEnum.MEDIUM){
				armsMCount++;
				if (armsMCount >= 5){
					System.out.println("You've completed 5 medium level arm workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a hard level chest workout");
				}
			}
			else if (armsHCount >= 5 && d == DifficultyEnum.HARD){
				armsHCount++;
				if (armsHCount >= 5){
					System.out.println("You've completed 5 hard level arm workouts, congratulations!");
					System.out.println("Keep up the good work!");
				}
			}
		}
		else if (m == MuscleGroup.SHOULDERS){
			if (d == DifficultyEnum.EASY){
				shouldersECount++;
				if (shouldersECount >= 5){
					System.out.println("You've completed 5 easy level shoulder workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a medium level chest workout");
				}
				
			}
			else if (d == DifficultyEnum.MEDIUM){
				shouldersMCount++;
				if (shouldersMCount >= 5){
					System.out.println("You've completed 5 medium level shoulder workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a hard level chest workout");
				}
			}
			else if (d == DifficultyEnum.HARD){
				shouldersHCount++;
				if (shouldersHCount >= 5){
					System.out.println("You've completed 5 hard level shoulder workouts, congratulations!");
					System.out.println("Keep up the good work!");
				}
			}
		}
		else if (m == MuscleGroup.BACK){
			if (d == DifficultyEnum.EASY){
				backECount++;
				if (backECount >=5){
					System.out.println("You've completed 5 easy level back workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a medium level chest workout");
				}
				
			}
			else if (backMCount >= 5 && d == DifficultyEnum.MEDIUM){
				backMCount++;
				if (backMCount >= 5){
					System.out.println("You've completed 5 medium level back workouts, congratulations!");
					System.out.println("We suggest you push yourself and do a hard level chest workout");
				}
			}
			else if (backHCount >= 5 && d == DifficultyEnum.HARD){
				backHCount++;
				if (backHCount >= 5){
					System.out.println("You've completed 5 hard level back workouts, congratulations!");
					System.out.println("Keep up the good work!");
				}
			}
		}
		else if (c == Type.CARDIO){
			cardioCount++;
			if (cardioCount % 5 == 0){
				System.out.println("Keep up the cardio!");
			}
		}
	}
		
	

}
