import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class workout {

	public static GImage displayWorkout(MainApplication app){
		WorkoutSpec user = app.get_wspec();
		GImage arms_cut = new GImage("images/arms_cut.png", 110,110);
		GImage arms_bulk = new GImage("images/arms_bulk.png", 110,110);
		GImage shoulders_cut = new GImage("images/shoulder_cut.png", 110,110);
		GImage shoulders_bulk = new GImage("images/shoulder_bulk.png", 110,110);
		GImage legs = new GImage("images/legs.png", 110,110);
		GImage back_cut = new GImage("images/back_cut.png", 110, 110);
		GImage back_bulk = new GImage ("images/back_bulk.png",110,110);
		GImage chest_cut = new GImage("images/chest_cut.png",110,110);
		GImage chest_bulk = new GImage("images/chest_bulk.png", 110, 110);
		GImage core_cut = new GImage("images/core_cut.png",110,110);
		GImage core_bulk = new GImage("images/core_bulk.png", 110, 110);
		GImage custom = app.get_Custom_img();
		if (custom != null){
			custom.setBounds(110,110,580,380);
		}
		shoulders_cut.setSize(580,380);
		shoulders_bulk.setSize(580,380);
		legs.setSize(580,380);
		arms_cut.setSize(580,380);
		arms_bulk.setSize(580,380);
		back_cut.setSize(580,380);
		back_bulk.setSize(580,380);
		chest_cut.setSize(580,380);
		chest_bulk.setSize(580,380);
		core_cut.setSize(580, 380);
		core_bulk.setSize(580,380);
		Type t = user.getType();
		MuscleGroup m = user.getMuscleGroup();
		DifficultyEnum d = user.getDifficulty();
		
		if (t == Type.BULKING){
			if (m == MuscleGroup.ARMS){
				if (d == DifficultyEnum.EASY){
					
					return arms_bulk;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return arms_bulk;
					
				}
				else if (d == DifficultyEnum.HARD){
					return arms_bulk;
					
				}
			}
			else if (m == MuscleGroup.BACK){
				if (d == DifficultyEnum.EASY){
					return back_bulk;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return back_bulk;
					
				}
				else if (d == DifficultyEnum.HARD){
					return back_bulk;
				}
				
			}
			else if (m == MuscleGroup.CHEST){
				if (d == DifficultyEnum.EASY){
					return chest_bulk;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return chest_bulk;
				}
				else if (d == DifficultyEnum.HARD){
					return chest_bulk;
				}
				
			}
			else if (m == MuscleGroup.CORE){
				if (d == DifficultyEnum.EASY){
					return core_bulk;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return core_bulk;
				}
				else if (d == DifficultyEnum.HARD){
					return core_bulk;
				}
				
			}
			else if (m == MuscleGroup.LEGS){
				if (d == DifficultyEnum.EASY){
					return legs;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return legs;
				}
				else if (d == DifficultyEnum.HARD){
					return legs;
				}
				
			}
			else if (m == MuscleGroup.SHOULDERS){
				if (d == DifficultyEnum.EASY){
					return shoulders_bulk;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return shoulders_bulk;
				}
				else if (d == DifficultyEnum.HARD){
					return shoulders_bulk;
				}
				
			}
			
		}
		else if(t == Type.CUSTOM){
			return custom;
		}
		else if (t == Type.CUTTING){
			if (m == MuscleGroup.ARMS){
				if (d == DifficultyEnum.EASY){
					return arms_cut;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return arms_cut;
				}
				else if (d == DifficultyEnum.HARD){
					return arms_cut;
				}
				
			}
			else if (m == MuscleGroup.BACK){
				if (d == DifficultyEnum.EASY){
					return back_cut;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return back_cut;
				}
				else if (d == DifficultyEnum.HARD){
					return back_cut;
				}
				
			}
			else if (m == MuscleGroup.CHEST){
				if (d == DifficultyEnum.EASY){
					return chest_cut;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return chest_cut;
				}
				else if (d == DifficultyEnum.HARD){
					return chest_cut;
				}
				
			}
			else if (m == MuscleGroup.CORE){
				if (d == DifficultyEnum.EASY){
					return core_cut;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return core_cut;
				}
				else if (d == DifficultyEnum.HARD){
					return core_cut;
				}
				
			}
			else if (m == MuscleGroup.LEGS){
				if (d == DifficultyEnum.EASY){
					return legs;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return legs;
				}
				else if (d == DifficultyEnum.HARD){
					return legs;
				}
				
			}
			else if (m == MuscleGroup.SHOULDERS){
				if (d == DifficultyEnum.EASY){
					return shoulders_cut;
				}
				else if (d == DifficultyEnum.MEDIUM){
					return shoulders_cut;
				}
				else if (d == DifficultyEnum.HARD){
					return shoulders_cut;
				}
				
			}
			
		}
		
		
			return null;
	}

}
	
	
	
	
	
	
	
	
	
	