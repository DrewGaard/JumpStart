import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;

public class WorkOutReps {
	public static GLabel description(MainApplication app){
		WorkoutSpec user = app.get_wspec();
		GLabel workout = null;
		Font titleFont = new Font("LuzSans-Book", Font.LAYOUT_LEFT_TO_RIGHT, 30);
		
		Type t = user.getType();
		MuscleGroup m = user.getMuscleGroup();
		DifficultyEnum d = user.getDifficulty();
		
		if (t == Type.BULKING){
			if (m == MuscleGroup.ARMS){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("10 Reps of Each, 20 lbs Weights", 200, 160);
					
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("15 Reps of Each, 40 lbs Weights", 200, 160);
					
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("18 Reps of Each, 50 lbs Weights", 200, 160);
					
				}
			}
			else if (m == MuscleGroup.BACK){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("20 Reps of Each", 280, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("40 Reps of Each", 280, 160);

				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("60 Reps of Each", 280, 160);
				}

			}
			else if (m == MuscleGroup.CHEST){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("10 Reps of Each, 20 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("15 Reps of Each, 30 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("20 Reps of Each, 40 lbs Weights", 200, 160);
				}

			}
			else if (m == MuscleGroup.CORE){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("20 Reps of Each", 280, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("40 Reps of Each", 280, 160);

				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("60 Reps of Each", 280, 160);
				}

			}
			else if (m == MuscleGroup.LEGS){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("15 Reps of Each, 10 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("20 Reps of Each, 20 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("25 Reps of Each, 30 lbs Weights", 200, 160);
				}

			}
			else if (m == MuscleGroup.SHOULDERS){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("10 Reps of Each, 30 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("15 Reps of Each, 50 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("20 Reps of Each, 60 lbs Weights", 200, 160);
				}

			}

		}
		else if (t == Type.CUSTOM){
			workout = new GLabel ("Press start to start the timer, Good luck!", 140, 160);
		}
		else if (t == Type.CUTTING){
			if (m == MuscleGroup.ARMS){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("15 Reps of Each, 10 lbs Weights", 200, 160);
					
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("20 Reps of Each, 20 lbs Weights", 200, 160);
					
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("30 Reps of Each, 30 lbs Weights", 200, 160);
				}
			}
			else if (m == MuscleGroup.BACK){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("40 Reps of Each", 280, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("50 Reps of Each", 280, 160);

				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("60 Reps of Each", 280, 160);
				}

			}
			else if (m == MuscleGroup.CHEST){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("15 Reps of Each, 15 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("20 Reps of Each, 20 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("30 Reps of Each, 25 lbs Weights", 200, 160);
				}

			}
			else if (m == MuscleGroup.CORE){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("30 Reps of Each", 280, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("40 Reps of Each", 280, 160);

				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("50 Reps of Each", 280, 160);
				}

			}
			else if (m == MuscleGroup.LEGS){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("20 Reps of Each, 10 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("30 Reps of Each, 15 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("35 Reps of Each, 20 lbs Weights", 200, 160);
				}

			}
			else if (m == MuscleGroup.SHOULDERS){
				if (d == DifficultyEnum.EASY){
					workout = new GLabel ("15 Reps of Each, 15 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.MEDIUM){
					workout = new GLabel ("20 Reps of Each, 20 lbs Weights", 200, 160);
				}
				else if (d == DifficultyEnum.HARD){
					workout = new GLabel ("30 Reps of Each, 25 lbs Weights", 200, 160);
				}

			}

		
		}
		workout.setFont(titleFont);
		workout.setColor(Color.WHITE);
		if (t == Type.CUSTOM){
			workout.setColor(Color.BLACK);
		}
		return workout;	
	}
	
}

		


